package main.java.com.wty.huobi.tools.caller;

import com.huobi.client.SyncRequestClient;
import com.huobi.client.model.Candlestick;
import com.huobi.client.model.enums.CandlestickInterval;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SyncRequestClient syncClient = SyncRequestClient.create();

// Get the timestamp from Huobi server and print on console
        long timestamp = syncClient.getExchangeTimestamp();
        System.out.println(timestamp);

// Get the latest btcusdt‘s candlestick data and print the highest price on console
        List<Candlestick> candlestickList =
                syncClient.getLatestCandlestick("btcusdt", CandlestickInterval.DAY1, 20);
        for (Candlestick item : candlestickList) {
            System.out.println(item.getHigh());
        }
    }
}

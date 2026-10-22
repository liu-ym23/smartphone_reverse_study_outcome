package com.facebook.battery.metrics.network;

import android.content.Context;

/* JADX INFO: loaded from: classes22.dex */
abstract class NetworkBytesCollector {
    static final int BG = 4;
    static final int FG = 0;
    static final int MOBILE = 2;
    static final int RX = 0;
    static final int TX = 1;
    static final int WIFI = 0;

    public NetworkBytesCollector() {
    }

    public static long[] createByteArray() {
        return new long[8];
    }

    public abstract boolean getTotalBytes(long[] r100);

    public abstract boolean supportsBgDistinction();

    public static NetworkBytesCollector create(Context r100) {
        QTagUidNetworkBytesCollector r101 = new QTagUidNetworkBytesCollector();
        if (r101.getTotalBytes(new long[8]) == false) goto L6;
        return r101;
    L6:
        return new TrafficStatsNetworkBytesCollector(r100);
    }
}

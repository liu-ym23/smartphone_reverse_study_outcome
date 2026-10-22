package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class NetworkTimeInfo {
    public long timestamp;

    public NetworkTimeInfo() {
    }

    public static NetworkTimeInfo create() {
        return new NetworkTimeInfo();
    }

    public void nativeSetTimestamp(long r100) {
        this.timestamp = r100;
    }
}

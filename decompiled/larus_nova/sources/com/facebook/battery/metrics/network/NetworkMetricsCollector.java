package com.facebook.battery.metrics.network;

import android.content.Context;
import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.core.SystemMetricsCollector;
import com.facebook.battery.metrics.core.SystemMetricsLogger;
import java.util.Arrays;

/* JADX INFO: loaded from: classes22.dex */
public class NetworkMetricsCollector extends SystemMetricsCollector<NetworkMetrics> {
    private static final String TAG = "NetworkMetricsCollector";
    private final long[] mBytes;
    private final NetworkBytesCollector mCollector;
    private boolean mIsValid;
    private final long[] mPrevBytes;

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public NetworkMetrics createMetrics() {
        return new NetworkMetrics();
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public /* bridge */ /* synthetic */ SystemMetrics createMetrics() {
        return createMetrics();
    }

    public NetworkMetricsCollector(Context r100) {
        this.mIsValid = true;
        this.mCollector = NetworkBytesCollector.create(r100);
        this.mBytes = NetworkBytesCollector.createByteArray();
        this.mPrevBytes = NetworkBytesCollector.createByteArray();
    }

    public static void resetMetrics(NetworkMetrics r100) {
        r100.mobileBytesTx = 0;
        r100.mobileBytesRx = 0;
        r100.wifiBytesTx = 0;
        r100.wifiBytesRx = 0;
    }

    public synchronized boolean getSnapshot(NetworkMetrics r100) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsValid == true) goto L6;
    L18:
        monitor-exit(this);
        return false;
    L6:
        if (this.mCollector.getTotalBytes(this.mBytes) == false) goto L18;
        boolean r101 = ensureBytesIncreased(this.mBytes, this.mPrevBytes);     // Catch: Throwable -> L20
        this.mIsValid = r101;     // Catch: Throwable -> L20
        if (r101 == true) goto L12;
        monitor-exit(this);
        return false;
    L12:
        boolean r102 = this.mCollector.supportsBgDistinction();     // Catch: Throwable -> L20
        resetMetrics(r100);     // Catch: Throwable -> L20
        addMetricsFromBytes(r100, this.mBytes, 0);     // Catch: Throwable -> L20
        if (r102 == false) goto L15;
        addMetricsFromBytes(r100, this.mBytes, 4);     // Catch: Throwable -> L20
    L15:
        monitor-exit(this);
        return true;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public /* bridge */ /* synthetic */ boolean getSnapshot(SystemMetrics r100) {
        return getSnapshot((NetworkMetrics) r100);
    }

    public static boolean ensureBytesIncreased(long[] r100, long[] r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L10;
        if (r100[r102] < r101[r102]) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        SystemMetricsLogger.wtf(TAG, "Network Bytes decreased from " + Arrays.toString(r101) + " to " + Arrays.toString(r100));
        return false;
    L10:
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return true;
    }

    public static void addMetricsFromBytes(NetworkMetrics r100, long[] r101, int r102) {
        r100.mobileBytesTx += r101[r102 | 3];
        r100.mobileBytesRx += r101[r102 | 2];
        r100.wifiBytesTx += r101[r102 | 1];
        r100.wifiBytesRx += r101[r102 | 0];
    }
}

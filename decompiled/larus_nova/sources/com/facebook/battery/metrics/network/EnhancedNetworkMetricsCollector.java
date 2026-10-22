package com.facebook.battery.metrics.network;

import android.content.Context;
import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.core.SystemMetricsCollector;

/* JADX INFO: loaded from: classes22.dex */
public class EnhancedNetworkMetricsCollector extends SystemMetricsCollector<EnhancedNetworkMetrics> {
    private final long[] mBytes;
    private final NetworkBytesCollector mCollector;
    private boolean mIsValid;
    private final long[] mPrevBytes;

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public EnhancedNetworkMetrics createMetrics() {
        return new EnhancedNetworkMetrics();
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public /* bridge */ /* synthetic */ SystemMetrics createMetrics() {
        return createMetrics();
    }

    public EnhancedNetworkMetricsCollector(Context r100) {
        this.mIsValid = true;
        this.mCollector = NetworkBytesCollector.create(r100);
        this.mBytes = NetworkBytesCollector.createByteArray();
        this.mPrevBytes = NetworkBytesCollector.createByteArray();
    }

    public synchronized boolean getSnapshot(EnhancedNetworkMetrics r100) {
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
        boolean r101 = NetworkMetricsCollector.ensureBytesIncreased(this.mBytes, this.mPrevBytes);     // Catch: Throwable -> L20
        this.mIsValid = r101;     // Catch: Throwable -> L20
        if (r101 == true) goto L12;
        monitor-exit(this);
        return false;
    L12:
        boolean r102 = this.mCollector.supportsBgDistinction();     // Catch: Throwable -> L20
        r100.supportsBgDetection = r102;     // Catch: Throwable -> L20
        NetworkMetricsCollector.resetMetrics(r100.fgMetrics);     // Catch: Throwable -> L20
        NetworkMetricsCollector.addMetricsFromBytes(r100.fgMetrics, this.mBytes, 0);     // Catch: Throwable -> L20
        if (r102 == false) goto L15;
        NetworkMetricsCollector.resetMetrics(r100.bgMetrics);     // Catch: Throwable -> L20
        NetworkMetricsCollector.addMetricsFromBytes(r100.bgMetrics, this.mBytes, 4);     // Catch: Throwable -> L20
    L15:
        monitor-exit(this);
        return true;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public /* bridge */ /* synthetic */ boolean getSnapshot(SystemMetrics r100) {
        return getSnapshot((EnhancedNetworkMetrics) r100);
    }
}

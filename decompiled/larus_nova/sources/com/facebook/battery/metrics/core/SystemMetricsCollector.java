package com.facebook.battery.metrics.core;

import com.facebook.battery.metrics.core.SystemMetrics;

/* JADX INFO: loaded from: classes22.dex */
public abstract class SystemMetricsCollector<T extends SystemMetrics> {
    public SystemMetricsCollector() {
    }

    public abstract T createMetrics();

    public abstract boolean getSnapshot(T r100);
}

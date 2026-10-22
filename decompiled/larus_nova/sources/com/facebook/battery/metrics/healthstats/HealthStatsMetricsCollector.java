package com.facebook.battery.metrics.healthstats;

import android.content.Context;
import android.os.health.SystemHealthManager;
import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.core.SystemMetricsCollector;
import com.facebook.battery.metrics.core.SystemMetricsLogger;

/* JADX INFO: loaded from: classes22.dex */
public class HealthStatsMetricsCollector extends SystemMetricsCollector<HealthStatsMetrics> {
    private static final String TAG = "HealthStatsMetricsCollector";
    private final SystemHealthManager mSystemHealthManager;

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public HealthStatsMetrics createMetrics() {
        return new HealthStatsMetrics();
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public /* bridge */ /* synthetic */ SystemMetrics createMetrics() {
        return createMetrics();
    }

    public HealthStatsMetricsCollector(Context r100) {
        this.mSystemHealthManager = (SystemHealthManager) r100.getSystemService("systemhealth");
    }

    public boolean getSnapshot(HealthStatsMetrics r100) {
        r100.set(this.mSystemHealthManager.takeMyUidSnapshot());     // Catch: RuntimeException -> L5
        return true;
    L5:
        e = move-exception;
        SystemMetricsLogger.wtf(TAG, "Unable to snapshot healthstats", e);
        return false;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public /* bridge */ /* synthetic */ boolean getSnapshot(SystemMetrics r100) {
        return getSnapshot((HealthStatsMetrics) r100);
    }
}

package com.facebook.battery.metrics.time;

import android.os.SystemClock;
import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.core.SystemMetricsCollector;
import com.facebook.battery.metrics.core.Utilities;

/* JADX INFO: loaded from: classes22.dex */
public class TimeMetricsCollector extends SystemMetricsCollector<TimeMetrics> {
    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public TimeMetrics createMetrics() {
        return new TimeMetrics();
    }

    public TimeMetricsCollector() {
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public /* bridge */ /* synthetic */ SystemMetrics createMetrics() {
        return createMetrics();
    }

    public boolean getSnapshot(TimeMetrics r100) {
        Utilities.checkNotNull(r100, "Null value passed to getSnapshot!");
        r100.realtimeMs = SystemClock.elapsedRealtime();
        r100.uptimeMs = SystemClock.uptimeMillis();
        return true;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public /* bridge */ /* synthetic */ boolean getSnapshot(SystemMetrics r100) {
        return getSnapshot((TimeMetrics) r100);
    }
}

package com.facebook.battery.reporter.time;

import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.time.TimeMetrics;
import com.facebook.battery.reporter.core.SystemMetricsReporter;

/* JADX INFO: loaded from: classes22.dex */
public class TimeMetricsReporter implements SystemMetricsReporter<TimeMetrics> {
    public static final String REALTIME_MS = "realtime_ms";
    public static final String UPTIME_MS = "uptime_ms";

    public TimeMetricsReporter() {
    }

    public void reportTo(TimeMetrics r100, SystemMetricsReporter.Event r101) {
        long r102 = r100.realtimeMs;
        if (r102 == 0) goto L5;
        r101.add(REALTIME_MS, r102);
    L5:
        long r103 = r100.uptimeMs;
        if (r103 == 0) goto L9;
        r101.add(UPTIME_MS, r103);
        return;
    }

    @Override // com.facebook.battery.reporter.core.SystemMetricsReporter
    public /* bridge */ /* synthetic */ void reportTo(SystemMetrics r100, SystemMetricsReporter.Event r101) {
        reportTo((TimeMetrics) r100, r101);
    }
}

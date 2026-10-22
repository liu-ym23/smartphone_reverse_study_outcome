package com.facebook.battery.reporter.healthstats;

import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.core.SystemMetricsLogger;
import com.facebook.battery.metrics.healthstats.HealthStatsMetrics;
import com.facebook.battery.reporter.core.SystemMetricsReporter;
import org.json.JSONException;

/* JADX INFO: loaded from: classes22.dex */
public class HealthStatsMetricsReporter implements SystemMetricsReporter<HealthStatsMetrics> {
    private static final String HEALTHSTATS = "healthstats";

    public HealthStatsMetricsReporter() {
    }

    public void reportTo(HealthStatsMetrics r100, SystemMetricsReporter.Event r101) {
        r101.add(HEALTHSTATS, r100.toJSONObject().toString());     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        SystemMetricsLogger.wtf("HealthStatsMetricsReporter", "Couldn't log healthstats metrics", e);
    }

    @Override // com.facebook.battery.reporter.core.SystemMetricsReporter
    public /* bridge */ /* synthetic */ void reportTo(SystemMetrics r100, SystemMetricsReporter.Event r101) {
        reportTo((HealthStatsMetrics) r100, r101);
    }
}

package com.facebook.battery.reporter.composite;

import androidx.collection.SimpleArrayMap;
import com.facebook.battery.metrics.composite.CompositeMetrics;
import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.reporter.core.SystemMetricsReporter;

/* JADX INFO: loaded from: classes22.dex */
public class CompositeMetricsReporter implements SystemMetricsReporter<CompositeMetrics> {
    private final SimpleArrayMap<Class<? extends SystemMetrics>, SystemMetricsReporter<?>> mMetricsReporterMap;

    public CompositeMetricsReporter() {
        this.mMetricsReporterMap = new SimpleArrayMap();
    }

    public <S extends SystemMetrics<S>, T extends SystemMetricsReporter<S>> T getReporter(Class<S> r100) {
        return (T) this.mMetricsReporterMap.get(r100);
    }

    public <T extends SystemMetrics<T>> CompositeMetricsReporter addMetricsReporter(Class<T> r100, SystemMetricsReporter<T> r101) {
        this.mMetricsReporterMap.put(r100, r101);
        return this;
    }

    public void reportTo(CompositeMetrics r100, SystemMetricsReporter.Event r101) {
        int r102 = 0;
    L4:
        if (r102 >= this.mMetricsReporterMap.size()) goto L9;
        Class<? extends SystemMetrics> r103 = this.mMetricsReporterMap.keyAt(r102);
        if (r100.isValid(r103) == false) goto L8;
        SystemMetrics r104 = r100.getMetric(r103);
        this.mMetricsReporterMap.get(r103).reportTo(r104, r101);
    L8:
        r102 = r102 + 1;
        goto L4
    }

    @Override // com.facebook.battery.reporter.core.SystemMetricsReporter
    public /* bridge */ /* synthetic */ void reportTo(SystemMetrics r100, SystemMetricsReporter.Event r101) {
        reportTo((CompositeMetrics) r100, r101);
    }
}

package com.facebook.battery.metrics.composite;

import androidx.collection.SimpleArrayMap;
import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.core.SystemMetricsCollector;
import com.facebook.battery.metrics.core.Utilities;

/* JADX INFO: loaded from: classes22.dex */
public class CompositeMetricsCollector extends SystemMetricsCollector<CompositeMetrics> {
    private final SimpleArrayMap<Class<? extends SystemMetrics>, SystemMetricsCollector<?>> mMetricsCollectorMap;

    public static class Builder {
        final SimpleArrayMap<Class<? extends SystemMetrics>, SystemMetricsCollector<?>> mMetricsCollectorMap;

        public CompositeMetricsCollector build() {
            return new CompositeMetricsCollector(this);
        }

        public Builder() {
            this.mMetricsCollectorMap = new SimpleArrayMap();
        }

        public <T extends SystemMetrics<T>> Builder addMetricsCollector(Class<T> r100, SystemMetricsCollector<T> r101) {
            this.mMetricsCollectorMap.put(r100, r101);
            return this;
        }
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public CompositeMetrics createMetrics() {
        CompositeMetrics r100 = new CompositeMetrics();
        int r101 = this.mMetricsCollectorMap.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100.putMetric(this.mMetricsCollectorMap.keyAt(r102), this.mMetricsCollectorMap.valueAt(r102).createMetrics());
        r102 = r102 + 1;
        goto L3
    L5:
        return r100;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public /* bridge */ /* synthetic */ SystemMetrics createMetrics() {
        return createMetrics();
    }

    public CompositeMetricsCollector(Builder r100) {
        SimpleArrayMap<Class<? extends SystemMetrics>, SystemMetricsCollector<?>> r101 = new SimpleArrayMap();
        this.mMetricsCollectorMap = r101;
        r101.putAll(r100.mMetricsCollectorMap);
    }

    public <S extends SystemMetrics<S>, T extends SystemMetricsCollector<S>> T getMetricsCollector(Class<S> r100) {
        return (T) this.mMetricsCollectorMap.get(r100);
    }

    public boolean getSnapshot(CompositeMetrics r100) {
        Utilities.checkNotNull(r100, "Null value passed to getSnapshot!");
        SimpleArrayMap<Class<? extends SystemMetrics>, SystemMetrics> r101 = r100.getMetrics();
        int r102 = r101.size();
        int r103 = 0;
        boolean r104 = false;
    L3:
        if (r103 >= r102) goto L9;
        Class<? extends SystemMetrics> r105 = r101.keyAt(r103);
        SystemMetricsCollector<?> r106 = this.mMetricsCollectorMap.get(r105);
        if (r106 == null) goto L7;
        boolean r107 = r106.getSnapshot(r100.getMetric(r105));
    L8:
        r100.setIsValid(r105, r107);
        r104 = r104 | r107;
        r103 = r103 + 1;
        goto L3
    L7:
        r107 = false;
        goto L8
    L9:
        return r104;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public /* bridge */ /* synthetic */ boolean getSnapshot(SystemMetrics r100) {
        return getSnapshot((CompositeMetrics) r100);
    }
}

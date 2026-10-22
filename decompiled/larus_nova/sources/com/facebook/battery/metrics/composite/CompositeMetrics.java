package com.facebook.battery.metrics.composite;

import androidx.collection.SimpleArrayMap;
import com.alipay.sdk.m.u.i;
import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.core.Utilities;

/* JADX INFO: loaded from: classes22.dex */
public class CompositeMetrics extends SystemMetrics<CompositeMetrics> {
    private final SimpleArrayMap<Class<? extends SystemMetrics>, SystemMetrics> mMetricsMap;
    private final SimpleArrayMap<Class<? extends SystemMetrics>, Boolean> mMetricsValid;

    public int hashCode() {
        return (this.mMetricsMap.hashCode() * 31) + this.mMetricsValid.hashCode();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("Composite Metrics{\n");
        int r101 = this.mMetricsMap.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        r100.append(this.mMetricsMap.valueAt(r102));
        if (isValid(this.mMetricsMap.keyAt(r102)) == false) goto L7;
        String r103 = " [valid]";
    L8:
        r100.append(r103);
        r100.append('\n');
        r102 = r102 + 1;
        goto L3
    L7:
        r103 = " [invalid]";
        goto L8
    L9:
        r100.append(i.f25855d);
        return r100.toString();
    }

    public CompositeMetrics() {
        this.mMetricsMap = new SimpleArrayMap();
        this.mMetricsValid = new SimpleArrayMap();
    }

    public SimpleArrayMap<Class<? extends SystemMetrics>, SystemMetrics> getMetrics() {
        return this.mMetricsMap;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        CompositeMetrics r101 = (CompositeMetrics) r100;
        if (Utilities.simpleArrayMapEquals(this.mMetricsValid, r101.mMetricsValid) == true) goto L13;
    L15:
        return false;
    L13:
        if (Utilities.simpleArrayMapEquals(this.mMetricsMap, r101.mMetricsMap) == false) goto L15;
        return true;
    }

    public <T extends SystemMetrics<T>> T getMetric(Class<T> r100) {
        return r100.cast(this.mMetricsMap.get(r100));
    }

    public boolean isValid(Class r100) {
        Boolean r101 = this.mMetricsValid.get(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.booleanValue() == false) goto L7;
        return true;
    }

    public CompositeMetrics set(CompositeMetrics r100) {
        int r101 = this.mMetricsMap.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        Class<? extends SystemMetrics> r103 = this.mMetricsMap.keyAt(r102);
        SystemMetrics r104 = r100.getMetric(r103);
        if (r104 == null) goto L7;
        getMetric(r103).set(r104);
        setIsValid(r103, r100.isValid(r103));
    L8:
        r102 = r102 + 1;
        goto L3
    L7:
        setIsValid(r103, false);
        goto L8
    L9:
        return this;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics set(SystemMetrics r100) {
        return set((CompositeMetrics) r100);
    }

    public CompositeMetrics diff(CompositeMetrics r100, CompositeMetrics r110) {
        if (r110 == null) goto L20;
        if (r100 != null) goto L5;
        r110.set(this);
    L18:
        return r110;
    L5:
        int r101 = this.mMetricsMap.size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L18;
        Class<? extends SystemMetrics> r103 = this.mMetricsMap.keyAt(r102);
        if (isValid(r103) == true) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L17;
        SystemMetrics r105 = r110.getMetric(r103);
        if (r105 == null) goto L17;
        getMetric(r103).diff(r100.getMetric(r103), r105);
    L17:
        r110.setIsValid(r103, r104);
        r102 = r102 + 1;
        goto L6
    L10:
        if (r100.isValid(r103) == false) goto L12;
        r104 = true;
        goto L13
    L20:
        throw new IllegalArgumentException("CompositeMetrics doesn't support nullable results");
    }

    public <T extends SystemMetrics<T>> CompositeMetrics putMetric(Class<T> r100, T r101) {
        this.mMetricsMap.put(r100, r101);
        this.mMetricsValid.put(r100, Boolean.FALSE);
        return this;
    }

    public void setIsValid(Class r100, boolean r101) {
        SimpleArrayMap<Class<? extends SystemMetrics>, Boolean> r102 = this.mMetricsValid;
        if (r101 == false) goto L5;
        Boolean r103 = Boolean.TRUE;
    L6:
        r102.put(r100, r103);
        return;
    L5:
        r103 = Boolean.FALSE;
        goto L6
    }

    public CompositeMetrics sum(CompositeMetrics r100, CompositeMetrics r110) {
        if (r110 == null) goto L20;
        if (r100 != null) goto L5;
        r110.set(this);
    L18:
        return r110;
    L5:
        int r101 = this.mMetricsMap.size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L18;
        Class<? extends SystemMetrics> r103 = this.mMetricsMap.keyAt(r102);
        if (isValid(r103) == true) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L17;
        SystemMetrics r105 = r110.getMetric(r103);
        if (r105 == null) goto L17;
        getMetric(r103).sum(r100.getMetric(r103), r105);
    L17:
        r110.setIsValid(r103, r104);
        r102 = r102 + 1;
        goto L6
    L10:
        if (r100.isValid(r103) == false) goto L12;
        r104 = true;
        goto L13
    L20:
        throw new IllegalArgumentException("CompositeMetrics doesn't support nullable results");
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics diff(SystemMetrics r100, SystemMetrics r101) {
        return diff((CompositeMetrics) r100, (CompositeMetrics) r101);
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics sum(SystemMetrics r100, SystemMetrics r101) {
        return sum((CompositeMetrics) r100, (CompositeMetrics) r101);
    }
}

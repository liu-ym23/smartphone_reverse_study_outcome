package com.facebook.battery.metrics.time;

import com.facebook.battery.metrics.core.SystemMetrics;

/* JADX INFO: loaded from: classes22.dex */
public class TimeMetrics extends SystemMetrics<TimeMetrics> {
    public long realtimeMs;
    public long uptimeMs;

    public int hashCode() {
        long r100 = this.uptimeMs;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.realtimeMs;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public String toString() {
        return "TimeMetrics{uptimeMs=" + this.uptimeMs + ", realtimeMs=" + this.realtimeMs + '}';
    }

    public TimeMetrics() {
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
        TimeMetrics r101 = (TimeMetrics) r100;
        if (this.uptimeMs == r101.uptimeMs) goto L13;
    L15:
        return false;
    L13:
        if (this.realtimeMs != r101.realtimeMs) goto L15;
        return true;
    }

    public TimeMetrics set(TimeMetrics r100) {
        this.uptimeMs = r100.uptimeMs;
        this.realtimeMs = r100.realtimeMs;
        return this;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics set(SystemMetrics r100) {
        return set((TimeMetrics) r100);
    }

    public TimeMetrics diff(TimeMetrics r100, TimeMetrics r101) {
        if (r101 != null) goto L4;
        r101 = new TimeMetrics();
    L4:
        if (r100 != null) goto L6;
        r101.set(this);
    L7:
        return r101;
    L6:
        r101.uptimeMs = this.uptimeMs - r100.uptimeMs;
        r101.realtimeMs = this.realtimeMs - r100.realtimeMs;
        goto L7
    }

    public TimeMetrics sum(TimeMetrics r100, TimeMetrics r101) {
        if (r101 != null) goto L4;
        r101 = new TimeMetrics();
    L4:
        if (r100 != null) goto L6;
        r101.set(this);
    L7:
        return r101;
    L6:
        r101.uptimeMs = this.uptimeMs + r100.uptimeMs;
        r101.realtimeMs = this.realtimeMs + r100.realtimeMs;
        goto L7
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics diff(SystemMetrics r100, SystemMetrics r101) {
        return diff((TimeMetrics) r100, (TimeMetrics) r101);
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics sum(SystemMetrics r100, SystemMetrics r101) {
        return sum((TimeMetrics) r100, (TimeMetrics) r101);
    }
}

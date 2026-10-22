package com.facebook.battery.metrics.network;

import com.facebook.battery.metrics.core.SystemMetrics;

/* JADX INFO: loaded from: classes22.dex */
public class EnhancedNetworkMetrics extends SystemMetrics<EnhancedNetworkMetrics> {
    public final NetworkMetrics bgMetrics;
    public final NetworkMetrics fgMetrics;
    public boolean supportsBgDetection;

    public int hashCode() {
        return ((((this.supportsBgDetection ? 1 : 0) * 31) + this.fgMetrics.hashCode()) * 31) + this.bgMetrics.hashCode();
    }

    public EnhancedNetworkMetrics() {
        this.fgMetrics = new NetworkMetrics();
        this.bgMetrics = new NetworkMetrics();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L20:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L20;
        EnhancedNetworkMetrics r101 = (EnhancedNetworkMetrics) r100;
        if (this.supportsBgDetection == r101.supportsBgDetection) goto L14;
        return false;
    L14:
        if (this.fgMetrics.equals(r101.fgMetrics) == true) goto L17;
        return false;
    L17:
        if (this.bgMetrics.equals(r101.bgMetrics) == true) goto L19;
        return false;
    L19:
        return true;
    }

    public EnhancedNetworkMetrics set(EnhancedNetworkMetrics r100) {
        this.fgMetrics.set(r100.fgMetrics);
        this.bgMetrics.set(r100.bgMetrics);
        return this;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics set(SystemMetrics r100) {
        return set((EnhancedNetworkMetrics) r100);
    }

    public EnhancedNetworkMetrics diff(EnhancedNetworkMetrics r100, EnhancedNetworkMetrics r101) {
        if (r101 != null) goto L4;
        r101 = new EnhancedNetworkMetrics();
    L4:
        if (r100 != null) goto L6;
        r101.set(this);
    L7:
        return r101;
    L6:
        this.fgMetrics.diff(r100.fgMetrics, r101.fgMetrics);
        this.bgMetrics.diff(r100.bgMetrics, r101.bgMetrics);
        goto L7
    }

    public EnhancedNetworkMetrics sum(EnhancedNetworkMetrics r100, EnhancedNetworkMetrics r101) {
        if (r101 != null) goto L4;
        r101 = new EnhancedNetworkMetrics();
    L4:
        if (r100 != null) goto L6;
        r101.set(this);
    L7:
        return r101;
    L6:
        this.fgMetrics.sum(r100.fgMetrics, r101.fgMetrics);
        this.bgMetrics.sum(r100.bgMetrics, r101.bgMetrics);
        goto L7
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics diff(SystemMetrics r100, SystemMetrics r101) {
        return diff((EnhancedNetworkMetrics) r100, (EnhancedNetworkMetrics) r101);
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics sum(SystemMetrics r100, SystemMetrics r101) {
        return sum((EnhancedNetworkMetrics) r100, (EnhancedNetworkMetrics) r101);
    }
}

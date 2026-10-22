package com.facebook.battery.metrics.cpu;

import com.facebook.battery.metrics.core.SystemMetrics;

/* JADX INFO: loaded from: classes22.dex */
public class CpuMetrics extends SystemMetrics<CpuMetrics> {
    public double childSystemTimeS;
    public double childUserTimeS;
    public double systemTimeS;
    public double userTimeS;

    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.systemTimeS);
        int r101 = (int) (r100 ^ (r100 >>> 32));
        long r102 = Double.doubleToLongBits(this.userTimeS);
        int r103 = (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
        long r104 = Double.doubleToLongBits(this.childSystemTimeS);
        int r105 = (r103 * 31) + ((int) (r104 ^ (r104 >>> 32)));
        long r106 = Double.doubleToLongBits(this.childUserTimeS);
        return (r105 * 31) + ((int) (r106 ^ (r106 >>> 32)));
    }

    public String toString() {
        return "CpuMetrics{userTimeS=" + this.userTimeS + ", systemTimeS=" + this.systemTimeS + ", childUserTimeS=" + this.childUserTimeS + ", childSystemTimeS=" + this.childSystemTimeS + '}';
    }

    public CpuMetrics() {
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L21;
        CpuMetrics r101 = (CpuMetrics) r100;
        if (Double.compare(r101.systemTimeS, this.systemTimeS) == 0) goto L13;
    L19:
        return false;
    L13:
        if (Double.compare(r101.userTimeS, this.userTimeS) != 0) goto L19;
        if (Double.compare(r101.childSystemTimeS, this.childSystemTimeS) != 0) goto L19;
        if (Double.compare(r101.childUserTimeS, this.childUserTimeS) != 0) goto L19;
        return true;
    }

    public CpuMetrics set(CpuMetrics r100) {
        this.userTimeS = r100.userTimeS;
        this.systemTimeS = r100.systemTimeS;
        this.childUserTimeS = r100.childUserTimeS;
        this.childSystemTimeS = r100.childSystemTimeS;
        return this;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics set(SystemMetrics r100) {
        return set((CpuMetrics) r100);
    }

    public CpuMetrics diff(CpuMetrics r100, CpuMetrics r101) {
        if (r101 != null) goto L4;
        r101 = new CpuMetrics();
    L4:
        if (r100 != null) goto L6;
        r101.set(this);
    L7:
        return r101;
    L6:
        r101.systemTimeS = this.systemTimeS - r100.systemTimeS;
        r101.userTimeS = this.userTimeS - r100.userTimeS;
        r101.childSystemTimeS = this.childSystemTimeS - r100.childSystemTimeS;
        r101.childUserTimeS = this.childUserTimeS - r100.childUserTimeS;
        goto L7
    }

    public CpuMetrics sum(CpuMetrics r100, CpuMetrics r101) {
        if (r101 != null) goto L4;
        r101 = new CpuMetrics();
    L4:
        if (r100 != null) goto L6;
        r101.set(this);
    L7:
        return r101;
    L6:
        r101.systemTimeS = this.systemTimeS + r100.systemTimeS;
        r101.userTimeS = this.userTimeS + r100.userTimeS;
        r101.childSystemTimeS = this.childSystemTimeS + r100.childSystemTimeS;
        r101.childUserTimeS = this.childUserTimeS + r100.childUserTimeS;
        goto L7
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics diff(SystemMetrics r100, SystemMetrics r101) {
        return diff((CpuMetrics) r100, (CpuMetrics) r101);
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics sum(SystemMetrics r100, SystemMetrics r101) {
        return sum((CpuMetrics) r100, (CpuMetrics) r101);
    }
}

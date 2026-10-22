package com.facebook.battery.metrics.network;

import com.facebook.battery.metrics.core.SystemMetrics;

/* JADX INFO: loaded from: classes22.dex */
public class RadioStateMetrics extends SystemMetrics<RadioStateMetrics> {
    public long mobileHighPowerActiveS;
    public long mobileLowPowerActiveS;
    public int mobileRadioWakeupCount;
    public long wifiActiveS;
    public int wifiRadioWakeupCount;

    public int hashCode() {
        long r100 = this.mobileLowPowerActiveS;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.mobileHighPowerActiveS;
        int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.mobileRadioWakeupCount) * 31;
        long r104 = this.wifiActiveS;
        return ((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.wifiRadioWakeupCount;
    }

    public String toString() {
        return "RadioStateMetrics{mobileLowPowerActiveS=" + this.mobileLowPowerActiveS + ", mobileHighPowerActiveS=" + this.mobileHighPowerActiveS + ", mobileRadioWakeupCount=" + this.mobileRadioWakeupCount + ", wifiActiveS=" + this.wifiActiveS + ", wifiRadioWakeupCount=" + this.wifiRadioWakeupCount + '}';
    }

    public RadioStateMetrics() {
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L23:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L23;
        RadioStateMetrics r101 = (RadioStateMetrics) r100;
        if (this.mobileLowPowerActiveS == r101.mobileLowPowerActiveS) goto L13;
    L21:
        return false;
    L13:
        if (this.mobileHighPowerActiveS != r101.mobileHighPowerActiveS) goto L21;
        if (this.mobileRadioWakeupCount != r101.mobileRadioWakeupCount) goto L21;
        if (this.wifiActiveS != r101.wifiActiveS) goto L21;
        if (this.wifiRadioWakeupCount != r101.wifiRadioWakeupCount) goto L21;
        return true;
    }

    public RadioStateMetrics set(RadioStateMetrics r100) {
        this.mobileLowPowerActiveS = r100.mobileLowPowerActiveS;
        this.mobileHighPowerActiveS = r100.mobileHighPowerActiveS;
        this.mobileRadioWakeupCount = r100.mobileRadioWakeupCount;
        this.wifiActiveS = r100.wifiActiveS;
        this.wifiRadioWakeupCount = r100.wifiRadioWakeupCount;
        return this;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics set(SystemMetrics r100) {
        return set((RadioStateMetrics) r100);
    }

    public RadioStateMetrics diff(RadioStateMetrics r100, RadioStateMetrics r101) {
        if (r101 != null) goto L4;
        r101 = new RadioStateMetrics();
    L4:
        if (r100 != null) goto L6;
        r101.set(this);
    L7:
        return r101;
    L6:
        r101.mobileLowPowerActiveS = this.mobileLowPowerActiveS - r100.mobileLowPowerActiveS;
        r101.mobileHighPowerActiveS = this.mobileHighPowerActiveS - r100.mobileHighPowerActiveS;
        r101.mobileRadioWakeupCount = this.mobileRadioWakeupCount - r100.mobileRadioWakeupCount;
        r101.wifiActiveS = this.wifiActiveS - r100.wifiActiveS;
        r101.wifiRadioWakeupCount = this.wifiRadioWakeupCount - r100.wifiRadioWakeupCount;
        goto L7
    }

    public RadioStateMetrics sum(RadioStateMetrics r100, RadioStateMetrics r101) {
        if (r101 != null) goto L4;
        r101 = new RadioStateMetrics();
    L4:
        if (r100 != null) goto L6;
        r101.set(this);
    L7:
        return r101;
    L6:
        r101.mobileLowPowerActiveS = this.mobileLowPowerActiveS + r100.mobileLowPowerActiveS;
        r101.mobileHighPowerActiveS = this.mobileHighPowerActiveS + r100.mobileHighPowerActiveS;
        r101.mobileRadioWakeupCount = this.mobileRadioWakeupCount + r100.mobileRadioWakeupCount;
        r101.wifiActiveS = this.wifiActiveS + r100.wifiActiveS;
        r101.wifiRadioWakeupCount = this.wifiRadioWakeupCount + r100.wifiRadioWakeupCount;
        goto L7
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics diff(SystemMetrics r100, SystemMetrics r101) {
        return diff((RadioStateMetrics) r100, (RadioStateMetrics) r101);
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics sum(SystemMetrics r100, SystemMetrics r101) {
        return sum((RadioStateMetrics) r100, (RadioStateMetrics) r101);
    }
}

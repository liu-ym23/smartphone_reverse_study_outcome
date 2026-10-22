package xr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f564890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f564891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f564892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f564893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f564894e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Float.compare(this.f564890a, r101.f564890a) == 0) goto L12;
        return false;
    L12:
        if (this.f564891b == r101.f564891b) goto L15;
        return false;
    L15:
        if (this.f564892c == r101.f564892c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f564893d, r101.f564893d) == true) goto L21;
        return false;
    L21:
        if (this.f564894e == r101.f564894e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((Float.floatToIntBits(this.f564890a) * 31) + this.f564891b) * 31) + this.f564892c) * 31;
        Integer r101 = this.f564893d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f564894e == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RawThermalSignals(batteryTemperatureCelsius=" + this.f564890a + ", batteryStatus=" + this.f564891b + ", aospStatus=" + this.f564892c + ", configuredSource=" + this.f564893d + ", aospSupported=" + this.f564894e + ')';
    }

    public h(float r100, int r101, int r102, Integer r103, boolean r104) {
        this.f564890a = r100;
        this.f564891b = r101;
        this.f564892c = r102;
        this.f564893d = r103;
        this.f564894e = r104;
    }
}

package com.larus.dora.impl.settings;

/* JADX INFO: loaded from: classes4.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f338032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f338033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f338034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f338035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f338036e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g1) == true) goto L8;
        return false;
    L8:
        g1 r101 = (g1) r100;
        if (this.f338032a == r101.f338032a) goto L12;
        return false;
    L12:
        if (Float.compare(this.f338033b, r101.f338033b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f338034c, r101.f338034c) == 0) goto L18;
        return false;
    L18:
        if (this.f338035d == r101.f338035d) goto L21;
        return false;
    L21:
        if (this.f338036e == r101.f338036e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.f338032a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + Float.floatToIntBits(this.f338033b)) * 31) + Float.floatToIntBits(this.f338034c)) * 31;
        long r102 = this.f338035d;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f338036e;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "G2SilentOtaSettings(featureEnabled=" + this.f338032a + ", autoInstallStartTime=" + this.f338033b + ", autoInstallEndTime=" + this.f338034c + ", manualRearmDelayMs=" + this.f338035d + ", installCooldownMs=" + this.f338036e + ')';
    }

    public g1(boolean r100, float r101, float r102, long r103, long r104) {
        this.f338032a = r100;
        this.f338033b = r101;
        this.f338034c = r102;
        this.f338035d = r103;
        this.f338036e = r104;
    }
}

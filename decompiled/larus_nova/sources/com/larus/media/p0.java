package com.larus.media;

/* JADX INFO: loaded from: classes30.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f359140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f359141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f359142c;

    public p0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p0) == true) goto L8;
        return false;
    L8:
        p0 r101 = (p0) r100;
        if (this.f359140a == r101.f359140a) goto L12;
        return false;
    L12:
        if (Float.compare(this.f359141b, r101.f359141b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f359142c, r101.f359142c) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f359140a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + Float.floatToIntBits(this.f359141b)) * 31) + Float.floatToIntBits(this.f359142c);
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "StereoPlayoutGainConfig(enable=" + this.f359140a + ", leftGainPercent=" + this.f359141b + ", rightGainPercent=" + this.f359142c + ')';
    }

    public /* synthetic */ p0(int r100) {
        this(false, 100.0f, 100.0f);
    }

    public p0(boolean r100, float r101, float r102) {
        this.f359140a = r100;
        this.f359141b = r101;
        this.f359142c = r102;
    }
}

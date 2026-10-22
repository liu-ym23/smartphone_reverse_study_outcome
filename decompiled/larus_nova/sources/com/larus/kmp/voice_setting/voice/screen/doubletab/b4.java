package com.larus.kmp.voice_setting.voice.screen.doubletab;

/* JADX INFO: loaded from: classes30.dex */
public final class b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f354211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f354212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f354213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f354214d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b4) == true) goto L8;
        return false;
    L8:
        b4 r101 = (b4) r100;
        if (this.f354211a == r101.f354211a) goto L12;
        return false;
    L12:
        if (this.f354212b == r101.f354212b) goto L15;
        return false;
    L15:
        if (Float.compare(this.f354213c, r101.f354213c) == 0) goto L18;
        return false;
    L18:
        if (this.f354214d == r101.f354214d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f354211a * 31) + this.f354212b) * 31) + Float.floatToIntBits(this.f354213c)) * 31;
        if (this.f354214d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "PagerVisiblePageSignal(currentPage=" + this.f354211a + ", settledPage=" + this.f354212b + ", offsetFraction=" + this.f354213c + ", isScrollInProgress=" + this.f354214d + ')';
    }

    public b4(int r100, int r101, float r102, boolean r103) {
        this.f354211a = r100;
        this.f354212b = r101;
        this.f354213c = r102;
        this.f354214d = r103;
    }
}

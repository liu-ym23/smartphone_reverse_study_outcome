package com.obric.miniapp.lynx;

/* JADX INFO: loaded from: classes33.dex */
public final class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f398181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f398182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f398183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f398184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f398185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f398186f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k4) == true) goto L8;
        return false;
    L8:
        k4 r101 = (k4) r100;
        if (this.f398181a == r101.f398181a) goto L12;
        return false;
    L12:
        if (this.f398182b == r101.f398182b) goto L15;
        return false;
    L15:
        if (this.f398183c == r101.f398183c) goto L18;
        return false;
    L18:
        if (this.f398184d == r101.f398184d) goto L21;
        return false;
    L21:
        if (this.f398185e == r101.f398185e) goto L24;
        return false;
    L24:
        if (this.f398186f == r101.f398186f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f398181a * 31) + this.f398182b) * 31) + this.f398183c) * 31) + this.f398184d) * 31) + this.f398185e) * 31) + this.f398186f;
    }

    public final String toString() {
        return "MenuContentMetrics(left=" + this.f398181a + ", top=" + this.f398182b + ", width=" + this.f398183c + ", height=" + this.f398184d + ", right=" + this.f398185e + ", bottom=" + this.f398186f + ')';
    }

    public k4(int r100, int r101, int r102, int r103) {
        this.f398181a = r100;
        this.f398182b = r101;
        this.f398183c = r102;
        this.f398184d = r103;
        this.f398185e = r100 + r102;
        this.f398186f = r101 + r103;
    }
}

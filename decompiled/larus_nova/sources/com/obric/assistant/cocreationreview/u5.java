package com.obric.assistant.cocreationreview;

/* JADX INFO: loaded from: classes32.dex */
public final class u5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f387744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f387745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f387746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f387747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f387748e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u5) == true) goto L8;
        return false;
    L8:
        u5 r101 = (u5) r100;
        if (this.f387744a == r101.f387744a) goto L12;
        return false;
    L12:
        if (this.f387745b == r101.f387745b) goto L15;
        return false;
    L15:
        if (this.f387746c == r101.f387746c) goto L18;
        return false;
    L18:
        if (this.f387747d == r101.f387747d) goto L21;
        return false;
    L21:
        if (this.f387748e == r101.f387748e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f387744a * 31) + this.f387745b) * 31) + this.f387746c) * 31) + this.f387747d) * 31) + this.f387748e;
    }

    public final String toString() {
        return "SummaryStats(total=" + this.f387744a + ", completed=" + this.f387745b + ", pending=" + this.f387746c + ", up=" + this.f387747d + ", down=" + this.f387748e + ')';
    }

    public u5(int r100, int r101, int r102, int r103, int r104) {
        this.f387744a = r100;
        this.f387745b = r101;
        this.f387746c = r102;
        this.f387747d = r103;
        this.f387748e = r104;
    }
}

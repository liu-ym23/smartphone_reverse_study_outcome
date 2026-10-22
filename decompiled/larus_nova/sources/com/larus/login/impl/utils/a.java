package com.larus.login.impl.utils;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f358310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f358311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f358312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f358313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f358314e;

    public a() {
        this(0, 0, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f358310a == r101.f358310a) goto L12;
        return false;
    L12:
        if (this.f358311b == r101.f358311b) goto L15;
        return false;
    L15:
        if (this.f358312c == r101.f358312c) goto L18;
        return false;
    L18:
        if (this.f358313d == r101.f358313d) goto L21;
        return false;
    L21:
        if (this.f358314e == r101.f358314e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f358310a * 31) + this.f358311b) * 31) + this.f358312c) * 31) + this.f358313d) * 31) + this.f358314e;
    }

    public final String toString() {
        return "ItemSpace(leftMargin=" + this.f358310a + ", topMargin=" + this.f358311b + ", rightMargin=" + this.f358312c + ", bottomMargin=" + this.f358313d + ", itemMargin=" + this.f358314e + ')';
    }

    public a(int r100, int r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 8) == 0) goto L8;
        r101 = 0;
    L8:
        this.f358310a = 0;
        this.f358311b = r100;
        this.f358312c = 0;
        this.f358313d = r101;
        this.f358314e = 0;
    }
}

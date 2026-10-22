package com.obric.miniapp.lynx;

/* JADX INFO: loaded from: classes33.dex */
public final class c6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f398057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f398058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f398059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f398060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f398061e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c6) == true) goto L8;
        return false;
    L8:
        c6 r101 = (c6) r100;
        if (this.f398057a == r101.f398057a) goto L12;
        return false;
    L12:
        if (this.f398058b == r101.f398058b) goto L15;
        return false;
    L15:
        if (this.f398059c == r101.f398059c) goto L18;
        return false;
    L18:
        if (this.f398060d == r101.f398060d) goto L21;
        return false;
    L21:
        if (this.f398061e == r101.f398061e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f398057a * 31) + this.f398058b) * 31) + this.f398059c) * 31) + this.f398060d) * 31) + this.f398061e;
    }

    public final String toString() {
        return "ResolvedMenuBounds(left=" + this.f398057a + ", top=" + this.f398058b + ", right=" + this.f398059c + ", bottom=" + this.f398060d + ", depth=" + this.f398061e + ')';
    }

    public c6(int r100, int r101, int r102, int r103, int r104) {
        this.f398057a = r100;
        this.f398058b = r101;
        this.f398059c = r102;
        this.f398060d = r103;
        this.f398061e = r104;
    }
}

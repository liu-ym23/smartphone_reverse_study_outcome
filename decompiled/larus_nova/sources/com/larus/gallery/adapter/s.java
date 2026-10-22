package com.larus.gallery.adapter;

/* JADX INFO: loaded from: classes29.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f343725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f343726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f343727c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (this.f343725a == r101.f343725a) goto L12;
        return false;
    L12:
        if (this.f343726b == r101.f343726b) goto L15;
        return false;
    L15:
        if (this.f343727c == r101.f343727c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f343725a * 31) + this.f343726b) * 31) + this.f343727c;
    }

    public final String toString() {
        return "MediaCanvas(width=" + this.f343725a + ", height=" + this.f343726b + ", topMargin=" + this.f343727c + ')';
    }

    public s(int r100, int r101, int r102) {
        this.f343725a = r100;
        this.f343726b = r101;
        this.f343727c = r102;
    }
}

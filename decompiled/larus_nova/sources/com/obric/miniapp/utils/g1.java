package com.obric.miniapp.utils;

/* JADX INFO: loaded from: classes33.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f398483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f398484b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g1) == true) goto L8;
        return false;
    L8:
        g1 r101 = (g1) r100;
        if (this.f398483a == r101.f398483a) goto L12;
        return false;
    L12:
        if (this.f398484b == r101.f398484b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f398483a * 31) + this.f398484b;
    }

    public final String toString() {
        return "TransitionRes(enterAnim=" + this.f398483a + ", exitAnim=" + this.f398484b + ')';
    }

    public g1(int r100, int r101) {
        this.f398483a = r100;
        this.f398484b = r101;
    }
}

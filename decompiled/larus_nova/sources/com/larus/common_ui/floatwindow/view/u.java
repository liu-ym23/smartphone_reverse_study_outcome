package com.larus.common_ui.floatwindow.view;

/* JADX INFO: loaded from: classes27.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f327558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f327559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f327560c;

    public u() {
        this(0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (this.f327558a == r101.f327558a) goto L12;
        return false;
    L12:
        if (this.f327559b == r101.f327559b) goto L15;
        return false;
    L15:
        if (this.f327560c == r101.f327560c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f327558a * 31) + this.f327559b) * 31) + this.f327560c;
    }

    public final String toString() {
        return "HotInfo(horizontalPadding=" + this.f327558a + ", topMargin=" + this.f327559b + ", bottomMargin=" + this.f327560c + ')';
    }

    public u(int r100, int r101, int r102) {
        this.f327558a = r100;
        this.f327559b = r101;
        this.f327560c = r102;
    }
}

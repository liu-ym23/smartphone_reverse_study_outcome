package com.larksuite.component.ui.layout;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f284232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f284233b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f284232a == r101.f284232a) goto L12;
        return false;
    L12:
        if (this.f284233b == r101.f284233b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f284232a * 31) + this.f284233b;
    }

    public final String toString() {
        return "OnMeasureData(widthMeasureSpec=" + this.f284232a + ", heightMeasureSpec=" + this.f284233b + ')';
    }

    public d() {
        this.f284232a = 0;
        this.f284233b = 0;
    }
}

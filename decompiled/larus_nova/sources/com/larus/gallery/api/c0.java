package com.larus.gallery.api;

/* JADX INFO: loaded from: classes29.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f343842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f343843b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (this.f343842a == r101.f343842a) goto L12;
        return false;
    L12:
        if (this.f343843b == r101.f343843b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f343842a * 31) + this.f343843b;
    }

    public final String toString() {
        return "MediaViewportConfig(topContentReservation=" + this.f343842a + ", bottomContentReservation=" + this.f343843b + ')';
    }

    public c0(int r100, int r101) {
        this.f343842a = r100;
        this.f343843b = r101;
    }
}

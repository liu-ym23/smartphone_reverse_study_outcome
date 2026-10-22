package com.obric.miniapp.lynx;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class x5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f398329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f398330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f398331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f398332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.obric.oui.material.c f398333e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x5) == true) goto L8;
        return false;
    L8:
        x5 r101 = (x5) r100;
        if (this.f398329a == r101.f398329a) goto L12;
        return false;
    L12:
        if (this.f398330b == r101.f398330b) goto L15;
        return false;
    L15:
        if (this.f398331c == r101.f398331c) goto L18;
        return false;
    L18:
        if (Float.compare(this.f398332d, r101.f398332d) == 0) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f398333e, r101.f398333e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f398329a * 31) + this.f398330b) * 31) + this.f398331c) * 31) + Float.floatToIntBits(this.f398332d)) * 31) + this.f398333e.hashCode();
    }

    public final String toString() {
        return "MiniAppMenuBackgroundAppearance(backgroundColor=" + this.f398329a + ", borderColor=" + this.f398330b + ", borderWidthPx=" + this.f398331c + ", cornerRadiusPx=" + this.f398332d + ", materialConfig=" + this.f398333e + ')';
    }

    public x5(int r100, int r101, int r102, float r103, com.obric.oui.material.c r104) {
        Intrinsics.checkNotNullParameter(r104, "materialConfig");
        this.f398329a = r100;
        this.f398330b = r101;
        this.f398331c = r102;
        this.f398332d = r103;
        this.f398333e = r104;
    }
}

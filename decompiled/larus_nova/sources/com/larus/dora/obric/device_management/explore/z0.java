package com.larus.dora.obric.device_management.explore;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f339630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f339631b;

    public z0() {
        this(null, 0, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z0) == true) goto L8;
        return false;
    L8:
        z0 r101 = (z0) r100;
        if (Intrinsics.areEqual(this.f339630a, r101.f339630a) == true) goto L12;
        return false;
    L12:
        if (this.f339631b == r101.f339631b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f339630a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f339631b;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoraObricGlassesIntroductionImage(uri=" + this.f339630a + ", resId=" + this.f339631b + ')';
    }

    public z0(String r100, int r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this.f339630a = r100;
        this.f339631b = r101;
    }
}

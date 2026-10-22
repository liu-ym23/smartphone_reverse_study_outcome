package com.larus.ui.arch.vm.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class r<A, B, C, D> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f375276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f375277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f375278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D f375279d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f375276a, r101.f375276a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f375277b, r101.f375277b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f375278c, r101.f375278c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f375279d, r101.f375279d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        A r100 = this.f375276a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        B r104 = this.f375277b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f375278c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        D r110 = this.f375279d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "Tuple4(a=" + this.f375276a + ", b=" + this.f375277b + ", c=" + this.f375278c + ", d=" + this.f375279d + ')';
    }

    public r(A r100, B r101, C r102, D r103) {
        this.f375276a = r100;
        this.f375277b = r101;
        this.f375278c = r102;
        this.f375279d = r103;
    }
}

package com.larksuite.arch.jack;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class q<A, B, C, D> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f282815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f282816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f282817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D f282818d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f282815a, r101.f282815a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f282816b, r101.f282816b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f282817c, r101.f282817c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f282818d, r101.f282818d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        A r100 = this.f282815a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        B r104 = this.f282816b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f282817c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        D r110 = this.f282818d;
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
        return "Tuple4(a=" + this.f282815a + ", b=" + this.f282816b + ", c=" + this.f282817c + ", d=" + this.f282818d + ')';
    }

    public q(A r100, B r101, C r102, D r103) {
        this.f282815a = r100;
        this.f282816b = r101;
        this.f282817c = r102;
        this.f282818d = r103;
    }
}

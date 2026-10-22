package com.larksuite.arch.jack;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class r<A, B, C, D, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f282819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f282820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f282821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D f282822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final E f282823e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f282819a, r101.f282819a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f282820b, r101.f282820b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f282821c, r101.f282821c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f282822d, r101.f282822d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f282823e, r101.f282823e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        A r100 = this.f282819a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        B r104 = this.f282820b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f282821c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        D r110 = this.f282822d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        E r113 = this.f282823e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "Tuple5(a=" + this.f282819a + ", b=" + this.f282820b + ", c=" + this.f282821c + ", d=" + this.f282822d + ", e=" + this.f282823e + ')';
    }

    public r(A r100, B r101, C r102, D r103, E r104) {
        this.f282819a = r100;
        this.f282820b = r101;
        this.f282821c = r102;
        this.f282822d = r103;
        this.f282823e = r104;
    }
}

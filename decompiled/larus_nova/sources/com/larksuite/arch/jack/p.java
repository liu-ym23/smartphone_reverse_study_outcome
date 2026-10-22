package com.larksuite.arch.jack;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class p<A, B, C> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f282812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f282813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f282814c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f282812a, r101.f282812a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f282813b, r101.f282813b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f282814c, r101.f282814c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        A r100 = this.f282812a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        B r104 = this.f282813b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f282814c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "Tuple3(a=" + this.f282812a + ", b=" + this.f282813b + ", c=" + this.f282814c + ')';
    }

    public p(A r100, B r101, C r102) {
        this.f282812a = r100;
        this.f282813b = r101;
        this.f282814c = r102;
    }
}

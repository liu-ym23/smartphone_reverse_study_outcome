package com.larksuite.arch.jack;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class o<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f282810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f282811b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f282810a, r101.f282810a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f282811b, r101.f282811b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        A r100 = this.f282810a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        B r104 = this.f282811b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "Tuple2(a=" + this.f282810a + ", b=" + this.f282811b + ')';
    }

    public o(A r100, B r101) {
        this.f282810a = r100;
        this.f282811b = r101;
    }
}

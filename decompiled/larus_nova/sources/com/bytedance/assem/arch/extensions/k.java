package com.bytedance.assem.arch.extensions;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f192931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f192932b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L10;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f192931a, r101.f192931a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f192932b, r101.f192932b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        A r100 = this.f192931a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        B r104 = this.f192932b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Tuple2(a=" + this.f192931a + ", b=" + this.f192932b + ")";
    }

    public k(A r100, B r101) {
        this.f192931a = r100;
        this.f192932b = r101;
    }
}

package com.bytedance.assem.arch.extensions;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class l<A, B, C> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f192933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f192934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f192935c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L12;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f192933a, r101.f192933a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f192934b, r101.f192934b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f192935c, r101.f192935c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        A r100 = this.f192933a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        B r104 = this.f192934b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f192935c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Tuple3(a=" + this.f192933a + ", b=" + this.f192934b + ", c=" + this.f192935c + ")";
    }

    public l(A r100, B r101, C r102) {
        this.f192933a = r100;
        this.f192934b = r101;
        this.f192935c = r102;
    }
}

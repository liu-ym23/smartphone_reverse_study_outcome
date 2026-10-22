package com.larus.ui.arch.vm.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class p<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f375271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f375272b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f375271a, r101.f375271a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f375272b, r101.f375272b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        A r100 = this.f375271a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        B r104 = this.f375272b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "Tuple2(a=" + this.f375271a + ", b=" + this.f375272b + ')';
    }

    public p(A r100, B r101) {
        this.f375271a = r100;
        this.f375272b = r101;
    }
}

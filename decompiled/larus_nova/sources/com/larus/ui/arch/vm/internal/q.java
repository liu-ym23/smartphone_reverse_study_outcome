package com.larus.ui.arch.vm.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class q<A, B, C> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f375273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f375274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f375275c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f375273a, r101.f375273a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f375274b, r101.f375274b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f375275c, r101.f375275c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        A r100 = this.f375273a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        B r104 = this.f375274b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f375275c;
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
        return "Tuple3(a=" + this.f375273a + ", b=" + this.f375274b + ", c=" + this.f375275c + ')';
    }

    public q(A r100, B r101, C r102) {
        this.f375273a = r100;
        this.f375274b = r101;
        this.f375275c = r102;
    }
}

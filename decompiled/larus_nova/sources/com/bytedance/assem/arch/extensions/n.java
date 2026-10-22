package com.bytedance.assem.arch.extensions;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class n<A, B, C, D, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f192940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f192941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f192942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D f192943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final E f192944e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L16;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f192940a, r101.f192940a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f192941b, r101.f192941b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f192942c, r101.f192942c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f192943d, r101.f192943d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f192944e, r101.f192944e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        A r100 = this.f192940a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        B r104 = this.f192941b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f192942c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        D r110 = this.f192943d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        E r113 = this.f192944e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Tuple5(a=" + this.f192940a + ", b=" + this.f192941b + ", c=" + this.f192942c + ", d=" + this.f192943d + ", e=" + this.f192944e + ")";
    }

    public n(A r100, B r101, C r102, D r103, E r104) {
        this.f192940a = r100;
        this.f192941b = r101;
        this.f192942c = r102;
        this.f192943d = r103;
        this.f192944e = r104;
    }
}

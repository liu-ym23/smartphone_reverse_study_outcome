package com.obric.miniapp.lynx;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f398195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f398196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f398197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f398198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f398199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f398200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f398201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f398202h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f398203i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f398204j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l4) == true) goto L8;
        return false;
    L8:
        l4 r101 = (l4) r100;
        if (this.f398195a == r101.f398195a) goto L12;
        return false;
    L12:
        if (this.f398196b == r101.f398196b) goto L15;
        return false;
    L15:
        if (this.f398197c == r101.f398197c) goto L18;
        return false;
    L18:
        if (this.f398198d == r101.f398198d) goto L21;
        return false;
    L21:
        if (this.f398199e == r101.f398199e) goto L24;
        return false;
    L24:
        if (this.f398200f == r101.f398200f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f398201g, r101.f398201g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f398202h, r101.f398202h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f398203i, r101.f398203i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f398204j, r101.f398204j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f398195a * 31) + this.f398196b) * 31) + this.f398197c) * 31) + this.f398198d) * 31) + this.f398199e) * 31;
        if (this.f398200f == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        Integer r103 = this.f398201g;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        Integer r107 = this.f398202h;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f398203i;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f398204j;
        if (r113 == null) goto L23;
        r104 = r113.hashCode();
    L23:
        return r112 + r104;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MenuContentSnapshot(left=" + this.f398195a + ", top=" + this.f398196b + ", width=" + this.f398197c + ", height=" + this.f398198d + ", depth=" + this.f398199e + ", isLeaf=" + this.f398200f + ", boundLeft=" + this.f398201g + ", boundTop=" + this.f398202h + ", boundRight=" + this.f398203i + ", boundBottom=" + this.f398204j + ')';
    }

    public l4(int r100, int r101, int r102, int r103, int r104, boolean r105, Integer r106, Integer r107, Integer r108, Integer r110) {
        this.f398195a = r100;
        this.f398196b = r101;
        this.f398197c = r102;
        this.f398198d = r103;
        this.f398199e = r104;
        this.f398200f = r105;
        this.f398201g = r106;
        this.f398202h = r107;
        this.f398203i = r108;
        this.f398204j = r110;
    }
}

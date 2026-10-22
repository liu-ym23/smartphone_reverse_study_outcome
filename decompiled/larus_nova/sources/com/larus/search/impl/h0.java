package com.larus.search.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f367787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f367788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f367789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f367790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f367791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f367792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f367793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f367794h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f367795i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f367796j;

    public h0() {
        this(false, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (this.f367787a == r101.f367787a) goto L12;
        return false;
    L12:
        if (this.f367788b == r101.f367788b) goto L15;
        return false;
    L15:
        if (this.f367789c == r101.f367789c) goto L18;
        return false;
    L18:
        if (this.f367790d == r101.f367790d) goto L21;
        return false;
    L21:
        if (Float.compare(this.f367791e, r101.f367791e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f367792f, r101.f367792f) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.f367793g, r101.f367793g) == 0) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f367794h, r101.f367794h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f367795i, r101.f367795i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f367787a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f367788b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f367789c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f367790d == true) goto L19;
        r100 = 1237;
    L19:
        return ((((((((((r106 + r100) * 31) + Float.floatToIntBits(this.f367791e)) * 31) + Float.floatToIntBits(this.f367792f)) * 31) + Float.floatToIntBits(this.f367793g)) * 31) + this.f367794h.hashCode()) * 31) + this.f367795i.hashCode();
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "WebDialogConfig(dismissOnTouchOutside=" + this.f367787a + ", dismissOnBackPressed=" + this.f367788b + ", dismissOnDialogDragged=" + this.f367789c + ", transferTouchEvent=" + this.f367790d + ", backgroundAlpha=" + this.f367791e + ", topOffset=" + this.f367792f + ", foldingHeight=" + this.f367793g + ", dismissListener=" + this.f367794h + ", cancelListener=" + this.f367795i + ')';
    }

    public h0(boolean r100, int r110) {
        boolean r101 = true;
        if ((r110 & 1) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r110 & 2) == 0) goto L10;
        r100 = false;
    L10:
        if ((r110 & 4) != 0) goto L13;
        r101 = false;
    L13:
        float r103 = 0.0f;
        if ((r110 & 16) == 0) goto L16;
        float r104 = 0.5f;
    L18:
        if ((r110 & 32) == 0) goto L20;
        float r105 = 12.0f;
    L22:
        if ((r110 & 64) == 0) goto L24;
        r103 = 368.0f;
    L24:
        Function0<Unit> r106 = null;
        if ((r110 & 128) == 0) goto L27;
        Function0<Unit> r107 = new f0();
    L29:
        if ((r110 & 256) == 0) goto L31;
        r106 = new g0();
    L31:
        Intrinsics.checkNotNullParameter(r107, "dismissListener");
        Intrinsics.checkNotNullParameter(r106, "cancelListener");
        this.f367787a = r102;
        this.f367788b = r100;
        this.f367789c = r101;
        this.f367790d = false;
        this.f367791e = r104;
        this.f367792f = r105;
        this.f367793g = r103;
        this.f367794h = r107;
        this.f367795i = r106;
        this.f367796j = new e(this);
        return;
    L27:
        r107 = null;
        goto L29
    L20:
        r105 = 0.0f;
        goto L22
    L16:
        r104 = 0.0f;
        goto L18
    L5:
        r102 = false;
        goto L7
    }
}

package com.larus.bmhome.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f316837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f316838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f316839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f316840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f316841e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f316837a == r101.f316837a) goto L12;
        return false;
    L12:
        if (Float.compare(this.f316838b, r101.f316838b) == 0) goto L15;
        return false;
    L15:
        if (this.f316839c == r101.f316839c) goto L18;
        return false;
    L18:
        if (this.f316840d == r101.f316840d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f316841e, r101.f316841e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f316837a * 31) + Float.floatToIntBits(this.f316838b)) * 31) + this.f316839c) * 31) + this.f316840d) * 31;
        Integer r101 = this.f316841e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "BottomMenuColorStyle(textColor=" + this.f316837a + ", iconAlpha=" + this.f316838b + ", iconTint=" + this.f316839c + ", backgroundAlpha=" + this.f316840d + ", backgroundDrawableRes=" + this.f316841e + ')';
    }

    public /* synthetic */ b(int r100, Integer r101) {
        this(r100, 1.0f, 0, 255, r101);
    }

    public b(int r100, float r101, int r102, int r103, Integer r104) {
        this.f316837a = r100;
        this.f316838b = r101;
        this.f316839c = r102;
        this.f316840d = r103;
        this.f316841e = r104;
    }
}

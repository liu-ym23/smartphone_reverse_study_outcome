package com.bytedance.ee.bear.lark.dependency;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f227348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f227349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f227350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f227351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f227352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f227353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f227354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f227355h;

    public a() {
        this(0, 0, null, false, null, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f227348a == r101.f227348a) goto L12;
        return false;
    L12:
        if (this.f227349b == r101.f227349b) goto L15;
        return false;
    L15:
        if (this.f227350c == r101.f227350c) goto L18;
        return false;
    L18:
        if (this.f227351d == r101.f227351d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f227352e, r101.f227352e) == true) goto L24;
        return false;
    L24:
        if (this.f227353f == r101.f227353f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f227354g, r101.f227354g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f227355h, r101.f227355h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f227348a * 31) + this.f227349b) * 31) + this.f227350c) * 31) + this.f227351d) * 31;
        Integer r101 = this.f227352e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        if (this.f227353f == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        Integer r107 = this.f227354g;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f227355h;
        if (r110 == null) goto L19;
        r102 = r110.hashCode();
    L19:
        return r109 + r102;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AiItemViewConfig(paddingStartPx=" + this.f227348a + ", paddingTopPx=" + this.f227349b + ", paddingEndPx=" + this.f227350c + ", paddingBottomPx=" + this.f227351d + ", iconSizePx=" + this.f227352e + ", useDefaultAiAvatar=" + this.f227353f + ", defaultAvatarDrawableRes=" + this.f227354g + ", defaultAiAvatarTint=" + this.f227355h + ')';
    }

    public a(int r100, int r101, Integer r102, boolean r103, Integer r104, Integer r105, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r110 & 4) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r110 & 16) == 0) goto L12;
        r102 = null;
    L12:
        if ((r110 & 32) == 0) goto L15;
        r103 = true;
    L15:
        if ((r110 & 64) == 0) goto L18;
        r104 = null;
    L18:
        if ((r110 & 128) == 0) goto L20;
        r105 = null;
    L20:
        this.f227348a = r100;
        this.f227349b = 0;
        this.f227350c = r101;
        this.f227351d = 0;
        this.f227352e = r102;
        this.f227353f = r103;
        this.f227354g = r104;
        this.f227355h = r105;
    }
}

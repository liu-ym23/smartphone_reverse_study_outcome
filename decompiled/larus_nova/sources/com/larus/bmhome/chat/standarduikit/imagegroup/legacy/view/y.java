package com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f309284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f309285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f309286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f309287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f309288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f309289f;

    public y() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (this.f309284a == r101.f309284a) goto L12;
        return false;
    L12:
        if (this.f309285b == r101.f309285b) goto L15;
        return false;
    L15:
        if (this.f309286c == r101.f309286c) goto L18;
        return false;
    L18:
        if (this.f309287d == r101.f309287d) goto L21;
        return false;
    L21:
        if (Float.compare(this.f309288e, r101.f309288e) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f309289f, r101.f309289f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f309284a * 31;
        int r101 = 1231;
        if (this.f309285b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f309286c == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (((((r103 + r101) * 31) + this.f309287d) * 31) + Float.floatToIntBits(this.f309288e)) * 31;
        Boolean r105 = this.f309289f;
        if (r105 != null) goto L13;
        int r106 = 0;
    L15:
        return r104 + r106;
    L13:
        r106 = r105.hashCode();
        goto L15
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "SizeData(maxWidth=" + this.f309284a + ", isHead=" + this.f309285b + ", isTail=" + this.f309286c + ", imageCount=" + this.f309287d + ", firstImageRatio=" + this.f309288e + ", isTop=" + this.f309289f + ')';
    }

    public /* synthetic */ y(int r100) {
        this(0, false, false, 0, 0.0f, Boolean.FALSE);
    }

    public y(int r100, boolean r101, boolean r102, int r103, float r104, Boolean r105) {
        this.f309284a = r100;
        this.f309285b = r101;
        this.f309286c = r102;
        this.f309287d = r103;
        this.f309288e = r104;
        this.f309289f = r105;
    }
}

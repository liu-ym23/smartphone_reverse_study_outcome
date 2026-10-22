package com.larus.bmhome.chat.standarduikit.imagegroup.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f309290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f309291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f309292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f309293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f309294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f309295f;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f309290a == r101.f309290a) goto L12;
        return false;
    L12:
        if (this.f309291b == r101.f309291b) goto L15;
        return false;
    L15:
        if (this.f309292c == r101.f309292c) goto L18;
        return false;
    L18:
        if (this.f309293d == r101.f309293d) goto L21;
        return false;
    L21:
        if (Float.compare(this.f309294e, r101.f309294e) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f309295f, r101.f309295f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f309290a * 31;
        int r101 = 1231;
        if (this.f309291b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f309292c == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (((((r103 + r101) * 31) + this.f309293d) * 31) + Float.floatToIntBits(this.f309294e)) * 31;
        Boolean r105 = this.f309295f;
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
        return "SizeData(maxWidth=" + this.f309290a + ", isHead=" + this.f309291b + ", isTail=" + this.f309292c + ", imageCount=" + this.f309293d + ", firstImageRatio=" + this.f309294e + ", isTop=" + this.f309295f + ')';
    }

    public /* synthetic */ a(int r100) {
        this(0, false, false, 0, 0.0f, Boolean.FALSE);
    }

    public a(int r100, boolean r101, boolean r102, int r103, float r104, Boolean r105) {
        this.f309290a = r100;
        this.f309291b = r101;
        this.f309292c = r102;
        this.f309293d = r103;
        this.f309294e = r104;
        this.f309295f = r105;
    }
}

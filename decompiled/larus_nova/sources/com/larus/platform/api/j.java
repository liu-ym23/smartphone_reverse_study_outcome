package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f365164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f365165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Float f365166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f365167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f365168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f365169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f365170h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f365163a, r101.f365163a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365164b, r101.f365164b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365165c, r101.f365165c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365166d, r101.f365166d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365167e, r101.f365167e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f365168f, r101.f365168f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f365169g, r101.f365169g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f365170h, r101.f365170h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f365163a.hashCode() * 31;
        Integer r101 = this.f365164b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f365165c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Float r108 = this.f365166d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f365167e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f365168f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.f365169g;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Integer r120 = this.f365170h;
        if (r120 == null) goto L31;
        r102 = r120.hashCode();
    L31:
        return r119 + r102;
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatTitleTagConfig(text=" + this.f365163a + ", textColorRes=" + this.f365164b + ", backgroundRes=" + this.f365165c + ", textSizePx=" + this.f365166d + ", horizontalPaddingPx=" + this.f365167e + ", verticalPaddingPx=" + this.f365168f + ", typefaceStyle=" + this.f365169g + ", gravity=" + this.f365170h + ')';
    }

    public j(String r100, Integer r101, Integer r102, Float r103, Integer r104, Integer r105, Integer r106, Integer r107) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f365163a = r100;
        this.f365164b = r101;
        this.f365165c = r102;
        this.f365166d = r103;
        this.f365167e = r104;
        this.f365168f = r105;
        this.f365169g = r106;
        this.f365170h = r107;
    }
}

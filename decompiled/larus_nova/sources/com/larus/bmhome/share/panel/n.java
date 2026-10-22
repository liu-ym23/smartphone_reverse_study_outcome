package com.larus.bmhome.share.panel;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f313971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f313972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f313973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f313974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CharSequence f313975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f313976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Float f313977g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f313978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f313979i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f313980j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f313981k;

    public n() {
        this(null, null, null, null, null, null, null, null, null, null, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f313971a, r101.f313971a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313972b, r101.f313972b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f313973c, r101.f313973c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f313974d, r101.f313974d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f313975e, r101.f313975e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f313976f, r101.f313976f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f313977g, r101.f313977g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f313978h, r101.f313978h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f313979i, r101.f313979i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f313980j, r101.f313980j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f313981k, r101.f313981k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f313971a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f313972b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Function0<Unit> r107 = this.f313973c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f313974d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        CharSequence r113 = this.f313975e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f313976f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Float r119 = this.f313977g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.f313978h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.f313979i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.f313980j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.f313981k;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SubTitleConfig(iconRes=" + this.f313971a + ", actionText=" + this.f313972b + ", actionClickListener=" + this.f313973c + ", backgroundRes=" + this.f313974d + ", subTitleText=" + this.f313975e + ", subTitleContainerHorizontalPadding=" + this.f313976f + ", subTitleTextSize=" + this.f313977g + ", subTitleBold=" + this.f313978h + ", actionAutoDismiss=" + this.f313979i + ", subTitleMarginTop=" + this.f313980j + ", subTitleContentVerticalPadding=" + this.f313981k + ')';
    }

    public n(Integer r100, String r101, com.larus.doc.impl.operation.j r102, Integer r103, CharSequence r104, Integer r105, Float r106, Boolean r110, Integer r111, Integer r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r113 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r113 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r113 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r113 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r113 & 256) == 0) goto L27;
        r110 = null;
    L27:
        if ((r113 & 512) == 0) goto L30;
        r111 = null;
    L30:
        if ((r113 & 1024) == 0) goto L32;
        r112 = null;
    L32:
        this.f313971a = r100;
        this.f313972b = r101;
        this.f313973c = r102;
        this.f313974d = r103;
        this.f313975e = r104;
        this.f313976f = r105;
        this.f313977g = r106;
        this.f313978h = null;
        this.f313979i = r110;
        this.f313980j = r111;
        this.f313981k = r112;
    }
}

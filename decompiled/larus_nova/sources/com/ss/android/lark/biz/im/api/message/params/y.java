package com.ss.android.lark.biz.im.api.message.params;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class y implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f410396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f410397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f410398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f410399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f410400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a0 f410401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f410402g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f410403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f410404i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final o f410405j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f410396a, r101.f410396a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f410397b, r101.f410397b) == true) goto L15;
        return false;
    L15:
        if (this.f410398c == r101.f410398c) goto L18;
        return false;
    L18:
        if (this.f410399d == r101.f410399d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f410400e, r101.f410400e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f410401f, r101.f410401f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f410402g, r101.f410402g) == true) goto L30;
        return false;
    L30:
        if (this.f410403h == r101.f410403h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f410404i, r101.f410404i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f410405j, r101.f410405j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        o r100 = this.f410396a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        o r104 = this.f410397b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.f410398c == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f410399d == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        Integer r112 = this.f410400e;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        a0 r115 = this.f410401f;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        Integer r118 = this.f410402g;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        if (this.f410403h == true) goto L34;
        r107 = 1237;
    L34:
        int r121 = (r120 + r107) * 31;
        Integer r122 = this.f410404i;
        if (r122 != null) goto L37;
        int r123 = 0;
    L38:
        int r124 = (r121 + r123) * 31;
        o r125 = this.f410405j;
        if (r125 == null) goto L43;
        r101 = r125.hashCode();
    L43:
        return r124 + r101;
    L37:
        r123 = r122.hashCode();
        goto L38
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TextContentBlockParam(textColorConfig=" + this.f410396a + ", deleteTextColorConfig=" + this.f410397b + ", disableEllipsize=" + this.f410398c + ", disableLynxCardEllipsize=" + this.f410399d + ", textGravity=" + this.f410400e + ", underlineParam=" + this.f410401f + ", textSizePx=" + this.f410402g + ", enableClickEdit=" + this.f410403h + ", selectedColorRes=" + this.f410404i + ", cursorHandleColorConfig=" + this.f410405j + ')';
    }

    public /* synthetic */ y(o r110, o r111, boolean r112, Integer r113, Integer r114, Integer r210, o r211, int r212) {
        if ((r212 & 1) == 0) goto L5;
        o r100 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        o r101 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r212 & 8) == 0) goto L17;
        boolean r103 = r102;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Integer r104 = null;
    L23:
        if ((r212 & 256) == 0) goto L25;
        Integer r115 = null;
    L27:
        if ((r212 & 512) == 0) goto L29;
        o r116 = null;
    L30:
        this(r100, r101, r102, r103, r104, null, r114, false, r115, r116);
        return;
    L29:
        r116 = r211;
        goto L30
    L25:
        r115 = r210;
        goto L27
    L21:
        r104 = r113;
        goto L23
    L17:
        r103 = false;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public y(o r100, o r101, boolean r102, boolean r103, Integer r104, a0 r105, Integer r106, boolean r107, Integer r108, o r110) {
        this.f410396a = r100;
        this.f410397b = r101;
        this.f410398c = r102;
        this.f410399d = r103;
        this.f410400e = r104;
        this.f410401f = r105;
        this.f410402g = r106;
        this.f410403h = r107;
        this.f410404i = r108;
        this.f410405j = r110;
    }
}

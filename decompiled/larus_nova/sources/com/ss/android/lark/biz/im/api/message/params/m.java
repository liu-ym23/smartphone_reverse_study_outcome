package com.ss.android.lark.biz.im.api.message.params;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class m implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f410364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f410365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f410366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f410367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f410368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f410369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f410370g;

    public m() {
        this(null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f410364a, r101.f410364a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f410365b, r101.f410365b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f410366c, r101.f410366c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f410367d, r101.f410367d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f410368e, r101.f410368e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f410369f, r101.f410369f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f410370g, r101.f410370g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f410364a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f410365b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f410366c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f410367d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f410368e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f410369f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f410370g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "MessagePopupMenuParam(dimBackgroundColorRes=" + this.f410364a + ", menuContentBackgroundColorRes=" + this.f410365b + ", menuContentSpacerColorRes=" + this.f410366c + ", menuContentDividerColorRes=" + this.f410367d + ", menuContentMaskColorRes=" + this.f410368e + ", menuIconTintColorRes=" + this.f410369f + ", menuItemBackgroundRes=" + this.f410370g + ')';
    }

    public m(Integer r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r105, Integer r106) {
        this.f410364a = r100;
        this.f410365b = r101;
        this.f410366c = r102;
        this.f410367d = r103;
        this.f410368e = r104;
        this.f410369f = r105;
        this.f410370g = r106;
    }
}

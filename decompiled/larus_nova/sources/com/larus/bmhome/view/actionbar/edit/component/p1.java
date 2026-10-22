package com.larus.bmhome.view.actionbar.edit.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f316428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f316429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f316430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f316431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f316432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f316433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f316434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f316435h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f316436i;

    public p1() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p1) == true) goto L8;
        return false;
    L8:
        p1 r101 = (p1) r100;
        if (Intrinsics.areEqual(this.f316428a, r101.f316428a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f316429b, r101.f316429b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f316430c, r101.f316430c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f316431d, r101.f316431d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f316432e, r101.f316432e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f316433f, r101.f316433f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f316434g, r101.f316434g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f316435h, r101.f316435h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f316436i, r101.f316436i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f316428a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f316429b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f316430c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f316431d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f316432e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f316433f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f316434g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f316435h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f316436i;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
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
        return "MobParam(actionBarTemplateType=" + this.f316428a + ", actionBarTemplateId=" + this.f316429b + ", actionBarKey=" + this.f316430c + ", actionBarScene=" + this.f316431d + ", chatType=" + this.f316432e + ", botId=" + this.f316433f + ", currentPage=" + this.f316434g + ", optionLabel=" + this.f316435h + ", optionSubLabel=" + this.f316436i + ')';
    }

    public p1(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108) {
        this.f316428a = r100;
        this.f316429b = r101;
        this.f316430c = r102;
        this.f316431d = r103;
        this.f316432e = r104;
        this.f316433f = r105;
        this.f316434g = r106;
        this.f316435h = r107;
        this.f316436i = r108;
    }
}

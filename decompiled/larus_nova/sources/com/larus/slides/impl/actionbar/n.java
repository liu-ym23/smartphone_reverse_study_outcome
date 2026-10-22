package com.larus.slides.impl.actionbar;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f369485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f369486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f369487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f369488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f369489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f369490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f369491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f369492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f369493i;

    public n() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f369485a, r101.f369485a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f369486b, r101.f369486b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f369487c, r101.f369487c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f369488d, r101.f369488d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f369489e, r101.f369489e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f369490f, r101.f369490f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f369491g, r101.f369491g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f369492h, r101.f369492h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f369493i, r101.f369493i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f369485a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f369486b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f369487c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f369488d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f369489e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f369490f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f369491g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f369492h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f369493i;
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
        return "PPTTemplateMobParam(actionBarTemplateType=" + this.f369485a + ", actionBarTemplateId=" + this.f369486b + ", actionBarKey=" + this.f369487c + ", actionBarScene=" + this.f369488d + ", chatType=" + this.f369489e + ", botId=" + this.f369490f + ", currentPage=" + this.f369491g + ", optionLabel=" + this.f369492h + ", optionSubLabel=" + this.f369493i + ')';
    }

    public n(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108) {
        this.f369485a = r100;
        this.f369486b = r101;
        this.f369487c = r102;
        this.f369488d = r103;
        this.f369489e = r104;
        this.f369490f = r105;
        this.f369491g = r106;
        this.f369492h = r107;
        this.f369493i = r108;
    }
}

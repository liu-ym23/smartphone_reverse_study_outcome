package com.bytedance.ee.bear.middleground.permission.secret;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f234111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f234112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f234113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f234114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f234115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f234116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f234117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f234118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f234119i;

    public n() {
        this(false, false, false, false, false, false, null, false, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f234111a == r101.f234111a) goto L12;
        return false;
    L12:
        if (this.f234112b == r101.f234112b) goto L15;
        return false;
    L15:
        if (this.f234113c == r101.f234113c) goto L18;
        return false;
    L18:
        if (this.f234114d == r101.f234114d) goto L21;
        return false;
    L21:
        if (this.f234115e == r101.f234115e) goto L24;
        return false;
    L24:
        if (this.f234116f == r101.f234116f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f234117g, r101.f234117g) == true) goto L30;
        return false;
    L30:
        if (this.f234118h == r101.f234118h) goto L33;
        return false;
    L33:
        if (this.f234119i == r101.f234119i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f234111a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f234112b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f234113c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f234114d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f234115e == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f234116f == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (((r110 + r111) * 31) + this.f234117g.hashCode()) * 31;
        if (this.f234118h == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.f234119i == true) goto L35;
        r100 = 1237;
    L35:
        return r114 + r100;
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "RecommendSecretBean(isAdminDefault=" + this.f234111a + ", isAutoMark=" + this.f234112b + ", isRecommendMark=" + this.f234113c + ", haveSecretLevel=" + this.f234114d + ", doubleCheckLevel=" + this.f234115e + ", isForceSecret=" + this.f234116f + ", secName=" + this.f234117g + ", isBannerStatus=" + this.f234118h + ", hasColloborateval=" + this.f234119i + ')';
    }

    public /* synthetic */ n(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, String r210, boolean r211, int r212) {
        if ((r212 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r212 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r212 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r212 & 8) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r212 & 16) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r212 & 32) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r116 = "";
    L31:
        if ((r212 & 128) == 0) goto L33;
        boolean r117 = false;
    L34:
        this(r100, r101, r102, r103, r104, r105, r116, r117, false);
        return;
    L33:
        r117 = r211;
        goto L34
    L29:
        r116 = r210;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
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

    public n(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, String r106, boolean r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r106, "secName");
        this.f234111a = r100;
        this.f234112b = r101;
        this.f234113c = r102;
        this.f234114d = r103;
        this.f234115e = r104;
        this.f234116f = r105;
        this.f234117g = r106;
        this.f234118h = r107;
        this.f234119i = r110;
    }
}

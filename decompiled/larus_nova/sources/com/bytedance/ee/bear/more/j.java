package com.bytedance.ee.bear.more;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f234623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f234624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f234625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f234626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f234627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f234628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f234629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f234630h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f234631i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f234632j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f234623a, r101.f234623a) == true) goto L12;
        return false;
    L12:
        if (this.f234624b == r101.f234624b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234625c, r101.f234625c) == true) goto L18;
        return false;
    L18:
        if (this.f234626d == r101.f234626d) goto L21;
        return false;
    L21:
        if (this.f234627e == r101.f234627e) goto L24;
        return false;
    L24:
        if (this.f234628f == r101.f234628f) goto L27;
        return false;
    L27:
        if (this.f234629g == r101.f234629g) goto L30;
        return false;
    L30:
        if (this.f234630h == r101.f234630h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f234631i, r101.f234631i) == true) goto L36;
        return false;
    L36:
        if (this.f234632j == r101.f234632j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f234623a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f234624b) * 31;
        String r104 = this.f234625c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.f234626d == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f234627e == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        if (this.f234628f == false) goto L21;
        int r112 = 1231;
    L22:
        int r113 = (r111 + r112) * 31;
        if (this.f234629g == false) goto L25;
        int r114 = 1231;
    L26:
        int r115 = (r113 + r114) * 31;
        if (this.f234630h == false) goto L29;
        int r116 = 1231;
    L30:
        int r117 = (r115 + r116) * 31;
        String r118 = this.f234631i;
        if (r118 == null) goto L34;
        r101 = r118.hashCode();
    L34:
        int r119 = (r117 + r101) * 31;
        if (this.f234632j == true) goto L39;
        r107 = 1237;
    L39:
        return r119 + r107;
    L29:
        r116 = 1237;
        goto L30
    L25:
        r114 = 1237;
        goto L26
    L21:
        r112 = 1237;
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
        return "MoreMenuViewViewBean(objToken=" + this.f234623a + ", type=" + this.f234624b + ", subType=" + this.f234625c + ", isSubscribed=" + this.f234626d + ", reportMoreMenuView=" + this.f234627e + ", isWiki=" + this.f234628f + ", isAtVc=" + this.f234629g + ", isOwner=" + this.f234630h + ", userPermisson=" + this.f234631i + ", haveAiButton=" + this.f234632j + ')';
    }

    public final int getType() {
        return this.f234624b;
    }

    public j(String r100, int r101, String r102, boolean r103, boolean r104, boolean r105, String r106) {
        this.f234623a = r100;
        this.f234624b = r101;
        this.f234625c = r102;
        this.f234626d = false;
        this.f234627e = false;
        this.f234628f = r103;
        this.f234629g = r104;
        this.f234630h = r105;
        this.f234631i = r106;
        this.f234632j = true;
    }
}

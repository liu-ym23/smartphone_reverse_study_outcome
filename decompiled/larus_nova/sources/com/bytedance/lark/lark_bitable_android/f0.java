package com.bytedance.lark.lark_bitable_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f252996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f252997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f252998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f252999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f253000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f253001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f253002g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f253003h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f253004i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f253005j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l0 f253006k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f253007l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f253008m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f253009n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f253010o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f253011p;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f252996a, r101.f252996a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f252997b, r101.f252997b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f252998c, r101.f252998c) == true) goto L18;
        return false;
    L18:
        if (this.f252999d == r101.f252999d) goto L21;
        return false;
    L21:
        if (this.f253000e == r101.f253000e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f253001f, r101.f253001f) == true) goto L27;
        return false;
    L27:
        if (this.f253002g == r101.f253002g) goto L30;
        return false;
    L30:
        if (this.f253003h == r101.f253003h) goto L33;
        return false;
    L33:
        if (this.f253004i == r101.f253004i) goto L36;
        return false;
    L36:
        if (this.f253005j == r101.f253005j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f253006k, r101.f253006k) == true) goto L42;
        return false;
    L42:
        if (this.f253007l == r101.f253007l) goto L45;
        return false;
    L45:
        if (this.f253008m == r101.f253008m) goto L48;
        return false;
    L48:
        if (this.f253009n == r101.f253009n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f253010o, r101.f253010o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f253011p, r101.f253011p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f252996a.hashCode() * 31) + this.f252997b.hashCode()) * 31) + this.f252998c.hashCode()) * 31) + this.f252999d) * 31) + this.f253000e) * 31) + this.f253001f.hashCode()) * 31;
        long r101 = this.f253002g;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f253003h;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f253004i;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f253005j;
        int r108 = (((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.f253006k.hashCode()) * 31;
        int r109 = 1231;
        if (this.f253007l == false) goto L5;
        int r110 = 1231;
    L6:
        int r111 = (r108 + r110) * 31;
        if (this.f253008m == false) goto L9;
        int r112 = 1231;
    L10:
        int r113 = (r111 + r112) * 31;
        if (this.f253009n == true) goto L15;
        r109 = 1237;
    L15:
        return ((((r113 + r109) * 31) + this.f253010o.hashCode()) * 31) + this.f253011p.hashCode();
    L9:
        r112 = 1237;
        goto L10
    L5:
        r110 = 1237;
        goto L6
    }

    public final String toString() {
        return "HomepageDocData(token=" + this.f252996a + ", icon=" + this.f252997b + ", title=" + this.f252998c + ", bizType=" + this.f252999d + ", objBizType=" + this.f253000e + ", objToken=" + this.f253001f + ", openTime=" + this.f253002g + ", starTime=" + this.f253003h + ", createTime=" + this.f253004i + ", editTime=" + this.f253005j + ", tag=" + this.f253006k + ", isOwner=" + this.f253007l + ", isStared=" + this.f253008m + ", isMyLibrary=" + this.f253009n + ", wikiSpaceName=" + this.f253010o + ", url=" + this.f253011p + ')';
    }

    public f0(String r110, String r111, String r112, int r113, int r114, String r115, long r116, long r117, long r210, long r211, l0 r212, boolean r213, boolean r214, boolean r215, String r216, String r217) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r111, "icon");
        Intrinsics.checkNotNullParameter(r112, "title");
        Intrinsics.checkNotNullParameter(r115, "objToken");
        Intrinsics.checkNotNullParameter(r212, "tag");
        Intrinsics.checkNotNullParameter(r216, "wikiSpaceName");
        Intrinsics.checkNotNullParameter(r217, "url");
        this.f252996a = r110;
        this.f252997b = r111;
        this.f252998c = r112;
        this.f252999d = r113;
        this.f253000e = r114;
        this.f253001f = r115;
        this.f253002g = r116;
        this.f253003h = r117;
        this.f253004i = r210;
        this.f253005j = r211;
        this.f253006k = r212;
        this.f253007l = r213;
        this.f253008m = r214;
        this.f253009n = r215;
        this.f253010o = r216;
        this.f253011p = r217;
    }
}

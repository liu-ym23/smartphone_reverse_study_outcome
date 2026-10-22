package com.bytedance.ee.bear.office.common.screenmenu;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements fk5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f235204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f235205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f235206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f235207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f235208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f235209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f235210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f235211h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f235212i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f235213j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f235214k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f235215l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f235216m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f235217n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Integer f235218o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Integer f235219p;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f235204a == r101.f235204a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f235205b, r101.f235205b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f235206c, r101.f235206c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f235207d, r101.f235207d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f235208e, r101.f235208e) == true) goto L24;
        return false;
    L24:
        if (this.f235209f == r101.f235209f) goto L27;
        return false;
    L27:
        if (this.f235210g == r101.f235210g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f235211h, r101.f235211h) == true) goto L33;
        return false;
    L33:
        if (this.f235212i == r101.f235212i) goto L36;
        return false;
    L36:
        if (this.f235213j == r101.f235213j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f235214k, r101.f235214k) == true) goto L42;
        return false;
    L42:
        if (this.f235215l == r101.f235215l) goto L45;
        return false;
    L45:
        if (this.f235216m == r101.f235216m) goto L48;
        return false;
    L48:
        if (this.f235217n == r101.f235217n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f235218o, r101.f235218o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f235219p, r101.f235219p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f235204a * 31;
        String r101 = this.f235205b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f235206c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f235207d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f235208e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        int r114 = 1231;
        if (this.f235209f == false) goto L21;
        int r115 = 1231;
    L22:
        int r116 = (r113 + r115) * 31;
        if (this.f235210g == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r116 + r117) * 31;
        Integer r119 = this.f235211h;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        if (this.f235212i == false) goto L33;
        int r122 = 1231;
    L34:
        int r123 = (r121 + r122) * 31;
        if (this.f235213j == false) goto L37;
        int r124 = 1231;
    L38:
        int r125 = (r123 + r124) * 31;
        Object r126 = this.f235214k;
        if (r126 != null) goto L41;
        int r127 = 0;
    L42:
        int r128 = (((r125 + r127) * 31) + this.f235215l) * 31;
        if (this.f235216m == false) goto L45;
        int r129 = 1231;
    L46:
        int r130 = (r128 + r129) * 31;
        if (this.f235217n == true) goto L50;
        r114 = 1237;
    L50:
        int r131 = (r130 + r114) * 31;
        Integer r132 = this.f235218o;
        if (r132 != null) goto L53;
        int r133 = 0;
    L54:
        int r134 = (r131 + r133) * 31;
        Integer r135 = this.f235219p;
        if (r135 == null) goto L59;
        r102 = r135.hashCode();
    L59:
        return r134 + r102;
    L53:
        r133 = r132.hashCode();
        goto L54
    L45:
        r129 = 1237;
        goto L46
    L41:
        r127 = r126.hashCode();
        goto L42
    L37:
        r124 = 1237;
        goto L38
    L33:
        r122 = 1237;
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = 1237;
        goto L26
    L21:
        r115 = 1237;
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
        return "MenuItem(id=" + this.f235204a + ", textString=" + this.f235205b + ", subTextString=" + this.f235206c + ", textColor=" + this.f235207d + ", icon=" + this.f235208e + ", iconAtEnd=" + this.f235209f + ", reserveIconSpace=" + this.f235210g + ", endIcon=" + this.f235211h + ", isSelected=" + this.f235212i + ", removeAroundDivider=" + this.f235213j + ", any=" + this.f235214k + ", paddingStart=" + this.f235215l + ", isEnabled=" + this.f235216m + ", isGray=" + this.f235217n + ", iconSize=" + this.f235218o + ", iconTextSpacing=" + this.f235219p + ')';
    }

    @Override // fk5.a
    public final boolean a() {
        return this.f235213j;
    }

    @Override // fk5.a
    public final int getId() {
        return this.f235204a;
    }

    public e(int r110, String r111, String r210, Integer r211, Integer r212, boolean r213, boolean r214, Integer r215, boolean r216, Object r217, boolean r218, boolean r219, Integer r310, Integer r311, int r312) {
        Integer r100 = null;
        if ((r312 & 2) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r312 & 4) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r312 & 8) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r312 & 16) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r312 & 32) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r312 & 64) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r312 & 128) == 0) goto L29;
        Integer r112 = null;
    L31:
        if ((r312 & 256) == 0) goto L33;
        boolean r113 = false;
    L35:
        if ((r312 & 1024) == 0) goto L37;
        Object r114 = null;
    L39:
        if ((r312 & 4096) == 0) goto L41;
        boolean r115 = true;
    L43:
        if ((r312 & 8192) == 0) goto L45;
        boolean r116 = false;
    L47:
        if ((r312 & 16384) == 0) goto L49;
        Integer r117 = null;
    L51:
        if ((r312 & 32768) != 0) goto L54;
        r100 = r311;
    L54:
        this.f235204a = r110;
        this.f235205b = r101;
        this.f235206c = r102;
        this.f235207d = r103;
        this.f235208e = r104;
        this.f235209f = r105;
        this.f235210g = r106;
        this.f235211h = r112;
        this.f235212i = r113;
        this.f235213j = false;
        this.f235214k = r114;
        this.f235215l = 0;
        this.f235216m = r115;
        this.f235217n = r116;
        this.f235218o = r117;
        this.f235219p = r100;
        return;
    L49:
        r117 = r310;
        goto L51
    L45:
        r116 = r219;
        goto L47
    L41:
        r115 = r218;
        goto L43
    L37:
        r114 = r217;
        goto L39
    L33:
        r113 = r216;
        goto L35
    L29:
        r112 = r215;
        goto L31
    L25:
        r106 = r214;
        goto L27
    L21:
        r105 = r213;
        goto L23
    L17:
        r104 = r212;
        goto L19
    L13:
        r103 = r211;
        goto L15
    L9:
        r102 = r210;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}

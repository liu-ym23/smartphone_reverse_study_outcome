package com.larus.bmhome.chat.nestedmenu;

import di8.b0;
import di8.d0;
import di8.f0;
import di8.g0;
import di8.n0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0 f308247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f308248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NestedMenuRightModel f308249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f308250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Float f308251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f308252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n0 f308253g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f0 f308254h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f308255i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f308256j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f308257k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f308247a, r101.f308247a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f308248b, r101.f308248b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f308249c, r101.f308249c) == true) goto L18;
        return false;
    L18:
        if (this.f308250d == r101.f308250d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f308251e, r101.f308251e) == true) goto L24;
        return false;
    L24:
        if (this.f308252f == r101.f308252f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f308253g, r101.f308253g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f308254h, r101.f308254h) == true) goto L33;
        return false;
    L33:
        if (this.f308255i == r101.f308255i) goto L36;
        return false;
    L36:
        if (this.f308256j == r101.f308256j) goto L39;
        return false;
    L39:
        if (this.f308257k == r101.f308257k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f308247a.hashCode() * 31) + this.f308248b.hashCode()) * 31) + this.f308249c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f308250d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        Float r104 = this.f308251e;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        if (this.f308252f == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        n0 r110 = this.f308253g;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        f0 r113 = this.f308254h;
        if (r113 == null) goto L22;
        r105 = r113.hashCode();
    L22:
        int r114 = (r112 + r105) * 31;
        if (this.f308255i == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (r114 + r115) * 31;
        if (this.f308256j == false) goto L29;
        int r117 = 1231;
    L30:
        int r118 = (r116 + r117) * 31;
        if (this.f308257k == true) goto L35;
        r101 = 1237;
    L35:
        return r118 + r101;
    L29:
        r117 = 1237;
        goto L30
    L25:
        r115 = 1237;
        goto L26
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "NestedMenuCommonItemModel(left=" + this.f308247a + ", center=" + this.f308248b + ", right=" + this.f308249c + ", enabled=" + this.f308250d + ", alpha=" + this.f308251e + ", canRespondWhenDisabled=" + this.f308252f + ", subMenu=" + this.f308253g + ", sourcePayload=" + this.f308254h + ", dismissMenuAfterClicked=" + this.f308255i + ", removeAroundDivider=" + this.f308256j + ", isHeader=" + this.f308257k + ')';
    }

    @Override // di8.d0
    public final boolean a() {
        return this.f308256j;
    }

    @Override // di8.d0
    public final boolean b() {
        return this.f308252f;
    }

    @Override // di8.d0
    public final f0 c() {
        return this.f308254h;
    }

    @Override // di8.d0
    public final boolean d() {
        return this.f308255i;
    }

    @Override // di8.d0
    public final Float getAlpha() {
        return this.f308251e;
    }

    @Override // di8.d0
    public final b0 getCenter() {
        return this.f308248b;
    }

    @Override // di8.d0
    public final boolean getEnabled() {
        return this.f308250d;
    }

    @Override // di8.d0
    public final g0 getLeft() {
        return this.f308247a;
    }

    @Override // di8.d0
    public final NestedMenuRightModel getRight() {
        return this.f308249c;
    }

    @Override // di8.d0
    public final n0 getSubMenu() {
        return this.f308253g;
    }

    @Override // di8.d0
    public final boolean isHeader() {
        return this.f308257k;
    }

    public static d e(d r110, f0 r111) {
        g0 r100 = r110.f308247a;
        b0 r101 = r110.f308248b;
        NestedMenuRightModel r102 = r110.f308249c;
        boolean r103 = r110.f308250d;
        Float r104 = r110.f308251e;
        boolean r105 = r110.f308252f;
        n0 r106 = r110.f308253g;
        boolean r107 = r110.f308255i;
        boolean r112 = r110.f308256j;
        boolean r113 = r110.f308257k;
        Intrinsics.checkNotNullParameter(r100, "left");
        Intrinsics.checkNotNullParameter(r101, "center");
        Intrinsics.checkNotNullParameter(r102, "right");
        return new d(r100, r101, r102, r103, r104, r105, r106, r111, r107, r112, r113);
    }

    public d(g0 r100, b0 r101, NestedMenuRightModel r102, boolean r103, Float r104, boolean r105, n0 r106, f0 r107, boolean r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "left");
        Intrinsics.checkNotNullParameter(r101, "center");
        Intrinsics.checkNotNullParameter(r102, "right");
        this.f308247a = r100;
        this.f308248b = r101;
        this.f308249c = r102;
        this.f308250d = r103;
        this.f308251e = r104;
        this.f308252f = r105;
        this.f308253g = r106;
        this.f308254h = r107;
        this.f308255i = r110;
        this.f308256j = r111;
        this.f308257k = r112;
    }

    public /* synthetic */ d(g0 r210, b0 r211, NestedMenuRightModel r212, boolean r213, Float r214, boolean r215, n0 r216, f0 r217, boolean r310, boolean r311, boolean r312, int r313) {
        if ((r313 & 1) == 0) goto L5;
        g0 r110 = new g0(null, null, null, false, null, 63);
    L7:
        if ((r313 & 4) == 0) goto L9;
        NestedMenuRightModel r111 = new NestedMenuRightModel(null, null, null, null, 1023);
    L11:
        if ((r313 & 8) == 0) goto L13;
        boolean r112 = true;
    L15:
        if ((r313 & 16) == 0) goto L17;
        Float r113 = null;
    L19:
        if ((r313 & 32) == 0) goto L21;
        boolean r114 = false;
    L23:
        if ((r313 & 64) == 0) goto L25;
        n0 r115 = null;
    L27:
        if ((r313 & 128) == 0) goto L29;
        f0 r116 = null;
    L31:
        if ((r313 & 256) == 0) goto L33;
        boolean r117 = true;
    L35:
        if ((r313 & 512) == 0) goto L37;
        boolean r118 = false;
    L39:
        if ((r313 & 1024) == 0) goto L41;
        boolean r218 = false;
    L42:
        this(r110, r211, r111, r112, r113, r114, r115, r116, r117, r118, r218);
        return;
    L41:
        r218 = r312;
        goto L42
    L37:
        r118 = r311;
        goto L39
    L33:
        r117 = r310;
        goto L35
    L29:
        r116 = r217;
        goto L31
    L25:
        r115 = r216;
        goto L27
    L21:
        r114 = r215;
        goto L23
    L17:
        r113 = r214;
        goto L19
    L13:
        r112 = r213;
        goto L15
    L9:
        r111 = r212;
        goto L11
    L5:
        r110 = r210;
        goto L7
    }
}

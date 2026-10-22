package com.larus.bmhome.chat.layout.item;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f304311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f304312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f304313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f304314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f304315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f304316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f304317g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f304318h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f304319i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f304320j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f304321k;

    public e1() {
        this(null, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e1) == true) goto L8;
        return false;
    L8:
        e1 r101 = (e1) r100;
        if (this.f304311a == r101.f304311a) goto L12;
        return false;
    L12:
        if (this.f304312b == r101.f304312b) goto L15;
        return false;
    L15:
        if (this.f304313c == r101.f304313c) goto L18;
        return false;
    L18:
        if (this.f304314d == r101.f304314d) goto L21;
        return false;
    L21:
        if (this.f304315e == r101.f304315e) goto L24;
        return false;
    L24:
        if (this.f304316f == r101.f304316f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f304317g, r101.f304317g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f304318h, r101.f304318h) == true) goto L33;
        return false;
    L33:
        if (this.f304319i == r101.f304319i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f304320j, r101.f304320j) == true) goto L39;
        return false;
    L39:
        if (this.f304321k == r101.f304321k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f304311a * 31;
        int r101 = 1231;
        if (this.f304312b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f304313c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f304314d == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f304315e == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f304316f == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (r109 + r110) * 31;
        String r112 = this.f304317g;
        int r113 = 0;
        if (r112 != null) goto L25;
        int r114 = 0;
    L26:
        int r115 = (r111 + r114) * 31;
        String r116 = this.f304318h;
        if (r116 != null) goto L29;
        int r117 = 0;
    L30:
        int r118 = (r115 + r117) * 31;
        if (this.f304319i == false) goto L33;
        int r119 = 1231;
    L34:
        int r120 = (r118 + r119) * 31;
        String r121 = this.f304320j;
        if (r121 == null) goto L38;
        r113 = r121.hashCode();
    L38:
        int r122 = (r120 + r113) * 31;
        if (this.f304321k == true) goto L43;
        r101 = 1237;
    L43:
        return r122 + r101;
    L33:
        r119 = 1237;
        goto L34
    L29:
        r117 = r116.hashCode();
        goto L30
    L25:
        r114 = r112.hashCode();
        goto L26
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "LynxBoxConfig(maxWidthValue=" + this.f304311a + ", disableBackground=" + this.f304312b + ", disableLoading=" + this.f304313c + ", useRadius=" + this.f304314d + ", useCanvasRadius=" + this.f304315e + ", enableStroke=" + this.f304316f + ", initData=" + this.f304317g + ", cardType=" + this.f304318h + ", isForPicShare=" + this.f304319i + ", appletId=" + this.f304320j + ", enableAppletCache=" + this.f304321k + ')';
    }

    public /* synthetic */ e1(String r110, int r111) {
        if ((r111 & 128) == 0) goto L5;
        r110 = null;
    L5:
        String r100 = r110;
        if ((r111 & 1024) == 0) goto L8;
        boolean r112 = true;
    L9:
        this(0, false, false, false, false, false, null, r100, false, null, r112);
        return;
    L8:
        r112 = false;
        goto L9
    }

    public e1(int r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, String r106, String r107, boolean r108, String r110, boolean r111) {
        this.f304311a = r100;
        this.f304312b = r101;
        this.f304313c = r102;
        this.f304314d = r103;
        this.f304315e = r104;
        this.f304316f = r105;
        this.f304317g = r106;
        this.f304318h = r107;
        this.f304319i = r108;
        this.f304320j = r110;
        this.f304321k = r111;
    }
}

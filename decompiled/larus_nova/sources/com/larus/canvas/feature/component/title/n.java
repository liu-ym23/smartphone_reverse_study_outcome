package com.larus.canvas.feature.component.title;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class n implements com.larus.canvas.feature.component.base.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f323709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f323710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f323711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f323712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f323713e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f323714f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f323715g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f323716h;

    public n() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f323709a, r101.f323709a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f323710b, r101.f323710b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f323711c, r101.f323711c) == true) goto L18;
        return false;
    L18:
        if (this.f323712d == r101.f323712d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f323713e, r101.f323713e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f323714f, r101.f323714f) == true) goto L27;
        return false;
    L27:
        if (this.f323715g == r101.f323715g) goto L30;
        return false;
    L30:
        if (this.f323716h == r101.f323716h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f323709a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f323710b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f323711c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        int r110 = 1231;
        if (this.f323712d == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f323713e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f323714f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        int r117 = (r115 + r101) * 31;
        if (this.f323715g == false) goto L29;
        int r118 = 1231;
    L30:
        int r119 = (r117 + r118) * 31;
        if (this.f323716h == true) goto L35;
        r110 = 1237;
    L35:
        return r119 + r110;
    L29:
        r118 = 1237;
        goto L30
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = 1237;
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
        return "TitleUIState(leftIconResId=" + this.f323709a + ", centerText=" + this.f323710b + ", centerImgResId=" + this.f323711c + ", isCenterVisible=" + this.f323712d + ", rightText=" + this.f323713e + ", rightTextColor=" + this.f323714f + ", rightLoadingVisible=" + this.f323715g + ", isRightVisible=" + this.f323716h + ')';
    }

    public /* synthetic */ n(int r110) {
        this(null, null, null, false, null, null, false, false);
    }

    public n(Integer r100, String r101, Integer r102, boolean r103, String r104, Integer r105, boolean r106, boolean r107) {
        this.f323709a = r100;
        this.f323710b = r101;
        this.f323711c = r102;
        this.f323712d = r103;
        this.f323713e = r104;
        this.f323714f = r105;
        this.f323715g = r106;
        this.f323716h = r107;
    }

    public static n a(n r100, Integer r110, String r111, Integer r112, boolean r113, String r114, Integer r115, boolean r116, boolean r117, int r118) {
        if ((r118 & 1) == 0) goto L5;
        Integer r101 = r100.f323709a;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.f323710b;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Integer r103 = r100.f323711c;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = r100.f323712d;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.f323713e;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Integer r106 = r100.f323714f;
    L27:
        if ((r118 & 64) == 0) goto L29;
        boolean r107 = r100.f323715g;
    L31:
        if ((r118 & 128) == 0) goto L33;
        boolean r108 = r100.f323716h;
    L34:
        r100.getClass();
        return new n(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L34
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}

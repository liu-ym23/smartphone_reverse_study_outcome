package com.larus.login.api;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f357042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f357043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f357044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharSequence f357045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CharSequence f357046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CharSequence f357047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f357048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f357049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f357050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f357051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.larus.login.api.ecommerce.b f357052k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, String> f357053l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f357054m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f357055n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f357056o;

    public i() {
        this(null, null, null, null, null, null, false, null, null, false, 32767);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f357042a, r101.f357042a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f357043b, r101.f357043b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f357044c, r101.f357044c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f357045d, r101.f357045d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f357046e, r101.f357046e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f357047f, r101.f357047f) == true) goto L27;
        return false;
    L27:
        if (this.f357048g == r101.f357048g) goto L30;
        return false;
    L30:
        if (this.f357049h == r101.f357049h) goto L33;
        return false;
    L33:
        if (this.f357050i == r101.f357050i) goto L36;
        return false;
    L36:
        if (this.f357051j == r101.f357051j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f357052k, r101.f357052k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f357053l, r101.f357053l) == true) goto L45;
        return false;
    L45:
        if (this.f357054m == r101.f357054m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f357055n, r101.f357055n) == true) goto L51;
        return false;
    L51:
        if (this.f357056o == r101.f357056o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f357042a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f357043b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        CharSequence r107 = this.f357044c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        CharSequence r110 = this.f357045d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        CharSequence r113 = this.f357046e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        CharSequence r116 = this.f357047f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        int r119 = 1231;
        if (this.f357048g == false) goto L29;
        int r120 = 1231;
    L30:
        int r121 = (r118 + r120) * 31;
        if (this.f357049h == false) goto L33;
        int r122 = 1231;
    L34:
        int r123 = (r121 + r122) * 31;
        if (this.f357050i == false) goto L37;
        int r124 = 1231;
    L38:
        int r125 = (r123 + r124) * 31;
        if (this.f357051j == false) goto L41;
        int r126 = 1231;
    L42:
        int r127 = (r125 + r126) * 31;
        com.larus.login.api.ecommerce.b r128 = this.f357052k;
        if (r128 != null) goto L45;
        int r129 = 0;
    L46:
        int r130 = (r127 + r129) * 31;
        Map<String, String> r131 = this.f357053l;
        if (r131 != null) goto L49;
        int r132 = 0;
    L50:
        int r133 = (r130 + r132) * 31;
        if (this.f357054m == false) goto L53;
        int r134 = 1231;
    L54:
        int r135 = (r133 + r134) * 31;
        String r136 = this.f357055n;
        if (r136 == null) goto L58;
        r101 = r136.hashCode();
    L58:
        int r137 = (r135 + r101) * 31;
        if (this.f357056o == true) goto L63;
        r119 = 1237;
    L63:
        return r137 + r119;
    L53:
        r134 = 1237;
        goto L54
    L49:
        r132 = r131.hashCode();
        goto L50
    L45:
        r129 = r128.hashCode();
        goto L46
    L41:
        r126 = 1237;
        goto L42
    L37:
        r124 = 1237;
        goto L38
    L33:
        r122 = 1237;
        goto L34
    L29:
        r120 = 1237;
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
        return "BinderConfigBasicConfig(iconResId=" + this.f357042a + ", hasBoundResId=" + this.f357043b + ", title=" + this.f357044c + ", desc=" + this.f357045d + ", confirmButtonText=" + this.f357046e + ", cancelButtonText=" + this.f357047f + ", cancelButtonVisible=" + this.f357048g + ", cancelableOnTouchOutside=" + this.f357049h + ", cancelableOnBackPressed=" + this.f357050i + ", disableDragDismiss=" + this.f357051j + ", coupon=" + this.f357052k + ", trackData=" + this.f357053l + ", shouldAuthCoupon=" + this.f357054m + ", extra=" + this.f357055n + ", descAtBottom=" + this.f357056o + ')';
    }

    public /* synthetic */ i(Integer r210, Integer r211, CharSequence r212, CharSequence r213, CharSequence r214, CharSequence r215, boolean r216, com.larus.login.api.ecommerce.b r217, Map r218, boolean r219, int r310) {
        if ((r310 & 1) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        CharSequence r102 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        CharSequence r103 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        CharSequence r104 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        CharSequence r105 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        boolean r110 = true;
    L31:
        if ((r310 & 128) == 0) goto L33;
        boolean r106 = true;
    L35:
        if ((r310 & 256) == 0) goto L37;
        boolean r111 = true;
    L39:
        if ((r310 & 1024) == 0) goto L41;
        com.larus.login.api.ecommerce.b r112 = null;
    L43:
        if ((r310 & 2048) == 0) goto L45;
        Map r113 = null;
    L47:
        if ((r310 & 16384) == 0) goto L49;
        boolean r114 = false;
    L50:
        this(r100, r101, r102, r103, r104, r105, r110, r106, r111, false, r112, r113, false, null, r114);
        return;
    L49:
        r114 = r219;
        goto L50
    L45:
        r113 = r218;
        goto L47
    L41:
        r112 = r217;
        goto L43
    L37:
        r111 = false;
        goto L39
    L33:
        r106 = false;
        goto L35
    L29:
        r110 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public i(Integer r100, Integer r101, CharSequence r102, CharSequence r103, CharSequence r104, CharSequence r105, boolean r106, boolean r107, boolean r108, boolean r110, com.larus.login.api.ecommerce.b r111, Map<String, String> r112, boolean r113, String r114, boolean r115) {
        this.f357042a = r100;
        this.f357043b = r101;
        this.f357044c = r102;
        this.f357045d = r103;
        this.f357046e = r104;
        this.f357047f = r105;
        this.f357048g = r106;
        this.f357049h = r107;
        this.f357050i = r108;
        this.f357051j = r110;
        this.f357052k = r111;
        this.f357053l = r112;
        this.f357054m = r113;
        this.f357055n = r114;
        this.f357056o = r115;
    }
}

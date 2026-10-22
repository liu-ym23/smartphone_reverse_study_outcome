package com.bytedance.ee.bear.more;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f234563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f234564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f234565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f234566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f234567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f234568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f234569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f234570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f234571i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f234572j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f234573k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f234574l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f234575m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f234576n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f234577o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f234578p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f234579q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f234580r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f234581s;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f234563a, r101.f234563a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f234564b, r101.f234564b) == true) goto L15;
        return false;
    L15:
        if (this.f234565c == r101.f234565c) goto L18;
        return false;
    L18:
        if (this.f234566d == r101.f234566d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f234567e, r101.f234567e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f234568f, r101.f234568f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f234569g, r101.f234569g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f234570h, r101.f234570h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f234571i, r101.f234571i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f234572j, r101.f234572j) == true) goto L39;
        return false;
    L39:
        if (this.f234573k == r101.f234573k) goto L42;
        return false;
    L42:
        if (this.f234574l == r101.f234574l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f234575m, r101.f234575m) == true) goto L48;
        return false;
    L48:
        if (this.f234576n == r101.f234576n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f234577o, r101.f234577o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f234578p, r101.f234578p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        Bundle r100 = this.f234563a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f234564b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f234565c) * 31;
        int r107 = 1231;
        if (this.f234566d == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f234567e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f234568f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f234569g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f234570h;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f234571i;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f234572j;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        if (this.f234573k == false) goto L41;
        int r128 = 1231;
    L42:
        int r129 = (r127 + r128) * 31;
        if (this.f234574l == false) goto L45;
        int r130 = 1231;
    L46:
        int r131 = (r129 + r130) * 31;
        String r132 = this.f234575m;
        if (r132 != null) goto L49;
        int r133 = 0;
    L50:
        int r134 = (r131 + r133) * 31;
        if (this.f234576n == true) goto L54;
        r107 = 1237;
    L54:
        int r135 = (r134 + r107) * 31;
        String r136 = this.f234577o;
        if (r136 == null) goto L59;
        r101 = r136.hashCode();
    L59:
        return ((r135 + r101) * 31) + this.f234578p.hashCode();
    L49:
        r133 = r132.hashCode();
        goto L50
    L45:
        r130 = 1237;
        goto L46
    L41:
        r128 = 1237;
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
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
        return "MoreItemClickBean(bundle=" + this.f234563a + ", objToken=" + this.f234564b + ", type=" + this.f234565c + ", isShareFolder=" + this.f234566d + ", subType=" + this.f234567e + ", click=" + this.f234568f + ", target=" + this.f234569g + ", exportType=" + this.f234570h + ", convertType=" + this.f234571i + ", language=" + this.f234572j + ", isWiki=" + this.f234573k + ", isAtVc=" + this.f234574l + ", shortcutToken=" + this.f234575m + ", isOwner=" + this.f234576n + ", userPermisson=" + this.f234577o + ", menuLevel=" + this.f234578p + ')';
    }

    public final int getType() {
        return this.f234565c;
    }

    public i(Bundle r110, String r111, int r210, boolean r211, String r212, String r213, String r214, String r215, String r216, boolean r217, boolean r218, String r219, boolean r310, String r311) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, "", r217, r218, r219, r310, r311, "");
    }

    public i(Bundle r100, String r101, int r102, boolean r103, String r104, String r105, String r110, String r111, String r112, String r113, boolean r114, boolean r115, String r116, boolean r117, String r118, String r119) {
        Intrinsics.checkNotNullParameter(r119, "menuLevel");
        this.f234563a = r100;
        this.f234564b = r101;
        this.f234565c = r102;
        this.f234566d = r103;
        this.f234567e = r104;
        this.f234568f = r105;
        this.f234569g = r110;
        this.f234570h = r111;
        this.f234571i = r112;
        this.f234572j = r113;
        this.f234573k = r114;
        this.f234574l = r115;
        this.f234575m = r116;
        this.f234576n = r117;
        this.f234577o = r118;
        this.f234578p = r119;
    }
}

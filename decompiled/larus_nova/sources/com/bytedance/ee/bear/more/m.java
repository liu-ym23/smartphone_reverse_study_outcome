package com.bytedance.ee.bear.more;

import android.os.Bundle;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f234644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f234645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f234646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f234647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f234648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f234649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f234650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f234651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f234652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f234653j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f234654k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f234655l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f234656m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, Object> f234657n;

    public m(Bundle r110, String r111, int r112, String r113, boolean r114, boolean r210, String r211, boolean r212, String r213) {
        this("ccm_space_drive_rename_click", r110, r111, r112, r113, r114, r210, r211, "none", "", r212, false, r213);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f234644a, r101.f234644a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f234645b, r101.f234645b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234646c, r101.f234646c) == true) goto L18;
        return false;
    L18:
        if (this.f234647d == r101.f234647d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f234648e, r101.f234648e) == true) goto L24;
        return false;
    L24:
        if (this.f234649f == r101.f234649f) goto L27;
        return false;
    L27:
        if (this.f234650g == r101.f234650g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f234651h, r101.f234651h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f234652i, r101.f234652i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f234653j, r101.f234653j) == true) goto L39;
        return false;
    L39:
        if (this.f234654k == r101.f234654k) goto L42;
        return false;
    L42:
        if (this.f234655l == r101.f234655l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f234656m, r101.f234656m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f234657n, r101.f234657n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f234644a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Bundle r104 = this.f234645b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f234646c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f234647d) * 31;
        String r110 = this.f234648e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        int r113 = 1231;
        if (this.f234649f == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.f234650g == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        String r118 = this.f234651h;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f234652i;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        String r124 = this.f234653j;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        if (this.f234654k == false) goto L41;
        int r127 = 1231;
    L42:
        int r128 = (r126 + r127) * 31;
        if (this.f234655l == true) goto L46;
        r113 = 1237;
    L46:
        int r129 = (r128 + r113) * 31;
        String r130 = this.f234656m;
        if (r130 != null) goto L49;
        int r131 = 0;
    L50:
        int r132 = (r129 + r131) * 31;
        Map<String, Object> r133 = this.f234657n;
        if (r133 == null) goto L55;
        r101 = r133.hashCode();
    L55:
        return r132 + r101;
    L49:
        r131 = r130.hashCode();
        goto L50
    L41:
        r127 = 1237;
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = 1237;
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
        return "MoreSubMenuViewClickBean(event=" + this.f234644a + ", bundle=" + this.f234645b + ", objToken=" + this.f234646c + ", type=" + this.f234647d + ", subType=" + this.f234648e + ", isWiki=" + this.f234649f + ", isAtVc=" + this.f234650g + ", click=" + this.f234651h + ", target=" + this.f234652i + ", moduleType=" + this.f234653j + ", isOwner=" + this.f234654k + ", isVersion=" + this.f234655l + ", userPermisson=" + this.f234656m + ", extraParams=" + this.f234657n + ')';
    }

    public final int getType() {
        return this.f234647d;
    }

    public /* synthetic */ m(String r110, Bundle r111, String r112, int r113, String r210, boolean r211, boolean r212, String r213, String r214, String r215, boolean r216, boolean r217, String r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, null);
    }

    public m(String r100, Bundle r101, String r102, int r103, String r104, boolean r105, boolean r106, String r107, String r108, String r110, boolean r111, boolean r112, String r113, Map<String, ? extends Object> r114) {
        this.f234644a = r100;
        this.f234645b = r101;
        this.f234646c = r102;
        this.f234647d = r103;
        this.f234648e = r104;
        this.f234649f = r105;
        this.f234650g = r106;
        this.f234651h = r107;
        this.f234652i = r108;
        this.f234653j = r110;
        this.f234654k = r111;
        this.f234655l = r112;
        this.f234656m = r113;
        this.f234657n = r114;
    }
}

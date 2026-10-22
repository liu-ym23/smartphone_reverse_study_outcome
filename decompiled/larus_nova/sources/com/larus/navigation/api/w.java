package com.larus.navigation.api;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes30.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f359697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f359698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f359699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f359700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f359701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f359702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f359703g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f359704h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f359705i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f359706j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f359707k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f359708l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f359709m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f359710n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f359711o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f359712p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<y> f359713q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final x f359714r;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f359697a, r101.f359697a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f359698b, r101.f359698b) == true) goto L15;
        return false;
    L15:
        if (this.f359699c == r101.f359699c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f359700d, r101.f359700d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f359701e, r101.f359701e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f359702f, r101.f359702f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f359703g, r101.f359703g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f359704h, r101.f359704h) == true) goto L33;
        return false;
    L33:
        if (this.f359705i == r101.f359705i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f359706j, r101.f359706j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f359707k, r101.f359707k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f359708l, r101.f359708l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f359709m, r101.f359709m) == true) goto L48;
        return false;
    L48:
        if (this.f359710n == r101.f359710n) goto L51;
        return false;
    L51:
        if (this.f359711o == r101.f359711o) goto L54;
        return false;
    L54:
        if (this.f359712p == r101.f359712p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f359713q, r101.f359713q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f359714r, r101.f359714r) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        a r100 = this.f359697a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f359698b.hashCode()) * 31) + this.f359699c) * 31;
        Integer r104 = this.f359700d;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f359701e;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f359702f.hashCode()) * 31;
        String r110 = this.f359703g;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f359704h;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        int r116 = 1231;
        if (this.f359705i == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f359706j;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f359707k;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f359708l;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f359709m;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (((r127 + r129) * 31) + this.f359710n) * 31;
        if (this.f359711o == true) goto L46;
        r116 = 1237;
    L46:
        int r131 = (((r130 + r116) * 31) + this.f359712p) * 31;
        List<y> r132 = this.f359713q;
        if (r132 != null) goto L49;
        int r133 = 0;
    L50:
        int r134 = (r131 + r133) * 31;
        x r135 = this.f359714r;
        if (r135 == null) goto L55;
        r101 = r135.hashCode();
    L55:
        return r134 + r101;
    L49:
        r133 = r132.hashCode();
        goto L50
    L41:
        r129 = r128.hashCode();
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
        r117 = 1237;
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
        return "NavigationStartParam(startPoint=" + this.f359697a + ", endPoint=" + this.f359698b + ", routePlanType=" + this.f359699c + ", prefer=" + this.f359700d + ", verbalMode=" + this.f359701e + ", navigateUniqueId=" + this.f359702f + ", botId=" + this.f359703g + ", conversationId=" + this.f359704h + ", isQuickRestart=" + this.f359705i + ", ridingType=" + this.f359706j + ", businessId=" + this.f359707k + ", poiId=" + this.f359708l + ", poiType=" + this.f359709m + ", coordType=" + this.f359710n + ", enableForegroundService=" + this.f359711o + ", rotationChangeMinInterval=" + this.f359712p + ", wayPoints=" + this.f359713q + ", navigationTraceContext=" + this.f359714r + ')';
    }

    public w(a r110, a r111, int r112, Integer r113, Integer r114, String r115, String r116, String r117, boolean r118, Integer r210, String r211, String r212, String r213, int r214, boolean r215, int r216, List<y> r217, x r218) {
        Intrinsics.checkNotNullParameter(r111, "endPoint");
        Intrinsics.checkNotNullParameter(r115, "navigateUniqueId");
        this.f359697a = r110;
        this.f359698b = r111;
        this.f359699c = r112;
        this.f359700d = r113;
        this.f359701e = r114;
        this.f359702f = r115;
        this.f359703g = r116;
        this.f359704h = r117;
        this.f359705i = r118;
        this.f359706j = r210;
        this.f359707k = r211;
        this.f359708l = r212;
        this.f359709m = r213;
        this.f359710n = r214;
        this.f359711o = r215;
        this.f359712p = r216;
        this.f359713q = r217;
        this.f359714r = r218;
        boolean r100 = true;
        if (r112 < 0) goto L6;
        if (r112 >= 3) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L55;
        if (r112 != 2) goto L26;
        if (r113 == null) goto L26;
        if (r113 != null) goto L14;
    L15:
        if (r113 != null) goto L18;
    L20:
        boolean r102 = false;
    L22:
        if (r102 == true) goto L26;
        throw new IllegalArgumentException(("driving prefer must be 0 (recommended) or 3 (no reverse), was " + r113).toString());
    L18:
        if (r113.intValue() != 3) goto L20;
    L21:
        r102 = true;
        goto L22
    L14:
        if (r113.intValue() == 0) goto L21;
    L26:
        if (r210 == null) goto L38;
        if (r112 != 1) goto L29;
        boolean r103 = true;
    L30:
        if (r103 == false) goto L37;
        if (new IntRange(0, 1).contains(r210.intValue()) == true) goto L38;
        throw new IllegalArgumentException(("ridingType must be 0 (bicycle) or 1 (electric), was " + r210).toString());
    L37:
        throw new IllegalArgumentException(("ridingType is only valid when routePlanType is 1 (cycling), was " + r112).toString());
    L29:
        r103 = false;
    L38:
        if (r214 != 3) goto L40;
        boolean r104 = true;
    L41:
        if (r104 == false) goto L53;
        if (r217 != null) goto L44;
        return;
    L44:
        if (r217.size() <= 15) goto L47;
        r100 = false;
    L47:
        if (r100 == false) goto L50;
        return;
    L50:
        throw new IllegalArgumentException(("wayPoints cannot exceed 15 points, was " + r217.size()).toString());
    L53:
        throw new IllegalArgumentException(("coordType must be 3 (GCJ02), was " + r214).toString());
    L40:
        r104 = false;
        goto L41
    L55:
        throw new IllegalArgumentException(("routePlanType must be 0 (walking), 1 (cycling), or 2 (driving), was " + r112).toString());
    L6:
        r101 = false;
        goto L7
    }
}

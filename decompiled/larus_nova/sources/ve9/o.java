package ve9;

import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;

/* JADX INFO: loaded from: classes30.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f554487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f554488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f554489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f554490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f554491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f554492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f554493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l f554494h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f554495i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f554496j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f554497k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f554498l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f554499m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f554500n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f554501o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f554502p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f554503q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f554504r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final k f554505s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f554506t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d f554507u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f554508v;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.f554487a == r101.f554487a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f554488b, r101.f554488b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f554489c, r101.f554489c) == true) goto L18;
        return false;
    L18:
        if (this.f554490d == r101.f554490d) goto L21;
        return false;
    L21:
        if (this.f554491e == r101.f554491e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f554492f, r101.f554492f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f554493g, r101.f554493g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f554494h, r101.f554494h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f554495i, r101.f554495i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f554496j, r101.f554496j) == true) goto L39;
        return false;
    L39:
        if (this.f554497k == r101.f554497k) goto L42;
        return false;
    L42:
        if (this.f554498l == r101.f554498l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f554499m, r101.f554499m) == true) goto L48;
        return false;
    L48:
        if (this.f554500n == r101.f554500n) goto L51;
        return false;
    L51:
        if (this.f554501o == r101.f554501o) goto L54;
        return false;
    L54:
        if (this.f554502p == r101.f554502p) goto L57;
        return false;
    L57:
        if (this.f554503q == r101.f554503q) goto L60;
        return false;
    L60:
        if (this.f554504r == r101.f554504r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f554505s, r101.f554505s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f554506t, r101.f554506t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f554507u, r101.f554507u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f554508v, r101.f554508v) == true) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f554487a * 31;
        d0 r101 = this.f554488b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f554489c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f554490d) * 31;
        int r108 = 1231;
        if (this.f554491e == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (((((((r107 + r109) * 31) + this.f554492f.hashCode()) * 31) + this.f554493g.hashCode()) * 31) + this.f554494h.hashCode()) * 31;
        String r111 = this.f554495i;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f554496j;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        if (this.f554497k == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r116 + r117) * 31;
        if (this.f554498l == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (r118 + r119) * 31;
        Integer r121 = this.f554499m;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        if (this.f554500n == false) goto L37;
        int r124 = 1231;
    L38:
        int r125 = (((((r123 + r124) * 31) + this.f554501o) * 31) + this.f554502p) * 31;
        if (this.f554503q == false) goto L41;
        int r126 = 1231;
    L42:
        int r127 = (r125 + r126) * 31;
        if (this.f554504r == true) goto L46;
        r108 = 1237;
    L46:
        int r128 = (((((((r127 + r108) * 31) + this.f554505s.hashCode()) * 31) + this.f554506t.hashCode()) * 31) + this.f554507u.hashCode()) * 31;
        String r129 = this.f554508v;
        if (r129 == null) goto L51;
        r102 = r129.hashCode();
    L51:
        return r128 + r102;
    L41:
        r126 = 1237;
        goto L42
    L37:
        r124 = 1237;
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = 1237;
        goto L30
    L25:
        r117 = 1237;
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SessionConfig(business=" + this.f554487a + ", extra=" + this.f554488b + ", interruptType=" + this.f554489c + ", requestType=" + this.f554490d + ", enablePreQuery=" + this.f554491e + ", subConvFirstMetType=" + this.f554492f + ", subConvSourceMessage=" + this.f554493g + ", scene=" + this.f554494h + ", chat=" + this.f554495i + ", vuiId=" + this.f554496j + ", enableTouch=" + this.f554497k + ", enableBurst=" + this.f554498l + ", modalType=" + this.f554499m + ", isRealtimeNewBackgroundEnabled=" + this.f554500n + ", doraWakeMode=" + this.f554501o + ", doraVisionQueryMode=" + this.f554502p + ", enableOneShot=" + this.f554503q + ", isFirstEnterSi=" + this.f554504r + ", oneshotConfig=" + this.f554505s + ", ncIuctcPath=" + this.f554506t + ", chatConfig=" + this.f554507u + ", astConfig=" + this.f554508v + ')';
    }

    public o() {
        this(1, new d0(MapsKt.emptyMap()), 1, 0, false, "", "", new l(0), "", "", false, false, null, false, 0, 0, false, false, new k(0), "", new d(0), null);
    }

    public o(int r100, d0 r110, Integer r111, int r112, boolean r113, String r114, String r115, l r116, String r117, String r118, boolean r119, boolean r210, Integer r211, boolean r212, int r213, int r214, boolean r215, boolean r216, k r217, String r218, d r219, String r310) {
        Intrinsics.checkNotNullParameter(r114, "subConvFirstMetType");
        Intrinsics.checkNotNullParameter(r115, "subConvSourceMessage");
        Intrinsics.checkNotNullParameter(r116, "scene");
        Intrinsics.checkNotNullParameter(r217, "oneshotConfig");
        Intrinsics.checkNotNullParameter(r218, "ncIuctcPath");
        Intrinsics.checkNotNullParameter(r219, "chatConfig");
        this.f554487a = r100;
        this.f554488b = r110;
        this.f554489c = r111;
        this.f554490d = r112;
        this.f554491e = r113;
        this.f554492f = r114;
        this.f554493g = r115;
        this.f554494h = r116;
        this.f554495i = r117;
        this.f554496j = r118;
        this.f554497k = r119;
        this.f554498l = r210;
        this.f554499m = r211;
        this.f554500n = r212;
        this.f554501o = r213;
        this.f554502p = r214;
        this.f554503q = r215;
        this.f554504r = r216;
        this.f554505s = r217;
        this.f554506t = r218;
        this.f554507u = r219;
        this.f554508v = r310;
    }
}

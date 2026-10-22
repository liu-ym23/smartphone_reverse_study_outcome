package com.bytedance.locallife.biz.experiment;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f256650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f256651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f256652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f256653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f256654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f256655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f256656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f256657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f256658i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f256659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f256660k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f256661l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f256662m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f256663n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f256664o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f256665p;

    public e() {
        this(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f256650a == r101.f256650a) goto L12;
        return false;
    L12:
        if (this.f256651b == r101.f256651b) goto L15;
        return false;
    L15:
        if (this.f256652c == r101.f256652c) goto L18;
        return false;
    L18:
        if (this.f256653d == r101.f256653d) goto L21;
        return false;
    L21:
        if (this.f256654e == r101.f256654e) goto L24;
        return false;
    L24:
        if (this.f256655f == r101.f256655f) goto L27;
        return false;
    L27:
        if (this.f256656g == r101.f256656g) goto L30;
        return false;
    L30:
        if (this.f256657h == r101.f256657h) goto L33;
        return false;
    L33:
        if (this.f256658i == r101.f256658i) goto L36;
        return false;
    L36:
        if (this.f256659j == r101.f256659j) goto L39;
        return false;
    L39:
        if (this.f256660k == r101.f256660k) goto L42;
        return false;
    L42:
        if (this.f256661l == r101.f256661l) goto L45;
        return false;
    L45:
        if (this.f256662m == r101.f256662m) goto L48;
        return false;
    L48:
        if (this.f256663n == r101.f256663n) goto L51;
        return false;
    L51:
        if (this.f256664o == r101.f256664o) goto L54;
        return false;
    L54:
        if (this.f256665p == r101.f256665p) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f256650a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f256651b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f256652c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f256653d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f256654e == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f256655f == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.f256656g == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.f256657h == false) goto L33;
        int r115 = 1231;
    L34:
        int r116 = (r114 + r115) * 31;
        if (this.f256658i == false) goto L37;
        int r117 = 1231;
    L38:
        int r118 = (r116 + r117) * 31;
        if (this.f256659j == false) goto L41;
        int r119 = 1231;
    L42:
        int r120 = (r118 + r119) * 31;
        if (this.f256660k == false) goto L45;
        int r121 = 1231;
    L46:
        int r122 = (r120 + r121) * 31;
        if (this.f256661l == false) goto L49;
        int r123 = 1231;
    L50:
        int r124 = (r122 + r123) * 31;
        if (this.f256662m == false) goto L53;
        int r125 = 1231;
    L54:
        int r126 = (r124 + r125) * 31;
        if (this.f256663n == false) goto L57;
        int r127 = 1231;
    L58:
        int r128 = (r126 + r127) * 31;
        if (this.f256664o == false) goto L61;
        int r129 = 1231;
    L62:
        int r130 = (r128 + r129) * 31;
        if (this.f256665p == true) goto L67;
        r100 = 1237;
    L67:
        return r130 + r100;
    L61:
        r129 = 1237;
        goto L62
    L57:
        r127 = 1237;
        goto L58
    L53:
        r125 = 1237;
        goto L54
    L49:
        r123 = 1237;
        goto L50
    L45:
        r121 = 1237;
        goto L46
    L41:
        r119 = 1237;
        goto L42
    L37:
        r117 = 1237;
        goto L38
    L33:
        r115 = 1237;
        goto L34
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LifeSaasPerfOptConfig(highPriorityEnabled=" + this.f256650a + ", xGetSettingsEnabled=" + this.f256651b + ", abParamsEnabled=" + this.f256652c + ", cubePerfEnabled=" + this.f256653d + ", preloadResourceJsbEnabled=" + this.f256654e + ", preloadGeckoResourceJsbEnabled=" + this.f256655f + ", saasFetchPrefetchEnabled=" + this.f256656g + ", poiWarmUpEnabled=" + this.f256657h + ", prefetchEnabled=" + this.f256658i + ", poiPrefetchEnabled=" + this.f256659j + ", pdpPrefetchEnabled=" + this.f256660k + ", perfServiceCompleteEnabled=" + this.f256661l + ", poiCardPreloadEnabled=" + this.f256662m + ", deviceScoreEnabled=" + this.f256663n + ", fontPreloadEnabled=" + this.f256664o + ", jatoOptEnabled=" + this.f256665p + ')';
    }

    public e(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, boolean r118) {
        this.f256650a = r100;
        this.f256651b = r101;
        this.f256652c = r102;
        this.f256653d = r103;
        this.f256654e = r104;
        this.f256655f = r105;
        this.f256656g = r106;
        this.f256657h = r110;
        this.f256658i = r111;
        this.f256659j = r112;
        this.f256660k = r113;
        this.f256661l = r114;
        this.f256662m = r115;
        this.f256663n = r116;
        this.f256664o = r117;
        this.f256665p = r118;
    }
}

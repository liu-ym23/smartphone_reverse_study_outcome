package v48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f553111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f553112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f553113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f553114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f553115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f553116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f553117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f553118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f553119i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f553120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f553121k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f553122l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f553123m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f553124n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f553125o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f553126p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f553127q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f553128r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f553129s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f553130t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f553131u;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f553111a == r101.f553111a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f553112b, r101.f553112b) == true) goto L15;
        return false;
    L15:
        if (this.f553113c == r101.f553113c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f553114d, r101.f553114d) == true) goto L21;
        return false;
    L21:
        if (this.f553115e == r101.f553115e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f553116f, r101.f553116f) == true) goto L27;
        return false;
    L27:
        if (this.f553117g == r101.f553117g) goto L30;
        return false;
    L30:
        if (this.f553118h == r101.f553118h) goto L33;
        return false;
    L33:
        if (this.f553119i == r101.f553119i) goto L36;
        return false;
    L36:
        if (this.f553120j == r101.f553120j) goto L39;
        return false;
    L39:
        if (this.f553121k == r101.f553121k) goto L42;
        return false;
    L42:
        if (this.f553122l == r101.f553122l) goto L45;
        return false;
    L45:
        if (this.f553123m == r101.f553123m) goto L48;
        return false;
    L48:
        if (this.f553124n == r101.f553124n) goto L51;
        return false;
    L51:
        if (this.f553125o == r101.f553125o) goto L54;
        return false;
    L54:
        if (this.f553126p == r101.f553126p) goto L57;
        return false;
    L57:
        if (this.f553127q == r101.f553127q) goto L60;
        return false;
    L60:
        if (this.f553128r == r101.f553128r) goto L63;
        return false;
    L63:
        if (this.f553129s == r101.f553129s) goto L66;
        return false;
    L66:
        if (this.f553130t == r101.f553130t) goto L69;
        return false;
    L69:
        if (this.f553131u == r101.f553131u) goto L71;
        return false;
    L71:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f553111a * 31) + this.f553112b.hashCode()) * 31) + this.f553113c) * 31) + this.f553114d.hashCode()) * 31) + this.f553115e) * 31) + this.f553116f.hashCode()) * 31;
        int r101 = 1231;
        if (this.f553117g == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f553118h == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f553119i == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f553120j == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f553121k == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (r109 + r110) * 31;
        if (this.f553122l == false) goto L25;
        int r112 = 1231;
    L26:
        int r113 = (((r111 + r112) * 31) + this.f553123m) * 31;
        long r114 = this.f553124n;
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        long r116 = this.f553125o;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        if (this.f553126p == false) goto L29;
        int r118 = 1231;
    L30:
        int r119 = (r117 + r118) * 31;
        if (this.f553127q == false) goto L33;
        int r120 = 1231;
    L34:
        int r121 = (r119 + r120) * 31;
        if (this.f553128r == false) goto L37;
        int r122 = 1231;
    L38:
        int r123 = (((r121 + r122) * 31) + this.f553129s) * 31;
        if (this.f553130t == false) goto L41;
        int r124 = 1231;
    L42:
        int r125 = (r123 + r124) * 31;
        if (this.f553131u == true) goto L47;
        r101 = 1237;
    L47:
        return r125 + r101;
    L41:
        r124 = 1237;
        goto L42
    L37:
        r122 = 1237;
        goto L38
    L33:
        r120 = 1237;
        goto L34
    L29:
        r118 = 1237;
        goto L30
    L25:
        r112 = 1237;
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
        return "AppLogConfigInfo(appId=" + this.f553111a + ", appName=" + this.f553112b + ", versionCode=" + this.f553113c + ", versionName=" + this.f553114d + ", updateVersionCode=" + this.f553115e + ", channel=" + this.f553116f + ", isBoe=" + this.f553117g + ", filterEnable=" + this.f553118h + ", samplingEnable=" + this.f553119i + ", newMonitorEnabled=" + this.f553120j + ", newMonitorInDebugMode=" + this.f553121k + ", defaultSentryEnabled=" + this.f553122l + ", defaultSentryColdStartSamplingRate=" + this.f553123m + ", defaultColdStartReportDelay=" + this.f553124n + ", defaultReportInterval=" + this.f553125o + ", packByLengthEnabled=" + this.f553126p + ", realtimeEventOptEnabled=" + this.f553127q + ", packMultiQueryEnabled=" + this.f553128r + ", packMaxQueryTimes=" + this.f553129s + ", encryptAndCompress=" + this.f553130t + ", debugAlignOnline=" + this.f553131u + ')';
    }

    public a(int r100, String r101, int r102, String r103, int r110, String r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, int r118, long r119, long r210, boolean r211, boolean r212, boolean r213, int r214, boolean r215, boolean r216) {
        Intrinsics.checkNotNullParameter(r101, "appName");
        Intrinsics.checkNotNullParameter(r103, "versionName");
        Intrinsics.checkNotNullParameter(r111, "channel");
        this.f553111a = r100;
        this.f553112b = r101;
        this.f553113c = r102;
        this.f553114d = r103;
        this.f553115e = r110;
        this.f553116f = r111;
        this.f553117g = r112;
        this.f553118h = r113;
        this.f553119i = r114;
        this.f553120j = r115;
        this.f553121k = r116;
        this.f553122l = r117;
        this.f553123m = r118;
        this.f553124n = r119;
        this.f553125o = r210;
        this.f553126p = r211;
        this.f553127q = r212;
        this.f553128r = r213;
        this.f553129s = r214;
        this.f553130t = r215;
        this.f553131u = r216;
    }
}

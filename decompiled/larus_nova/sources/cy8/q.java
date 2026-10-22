package cy8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f465892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f465893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f465894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f465895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f465896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p f465897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f465898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m f465899h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final r f465900i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final o f465901j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final m f465902k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final m f465903l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f465904m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f465905n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f465906o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (this.f465892a == r101.f465892a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465893b, r101.f465893b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465894c, r101.f465894c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f465895d, r101.f465895d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f465896e, r101.f465896e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f465897f, r101.f465897f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f465898g, r101.f465898g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f465899h, r101.f465899h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f465900i, r101.f465900i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f465901j, r101.f465901j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f465902k, r101.f465902k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f465903l, r101.f465903l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f465904m, r101.f465904m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f465905n, r101.f465905n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f465906o, r101.f465906o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f465892a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f465893b;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f465894c;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        m r109 = this.f465895d;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        m r112 = this.f465896e;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        p r115 = this.f465897f;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f465898g;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        m r121 = this.f465899h;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        r r124 = this.f465900i;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        o r127 = this.f465901j;
        if (r127 != null) goto L37;
        int r128 = 0;
    L38:
        int r129 = (r126 + r128) * 31;
        m r130 = this.f465902k;
        if (r130 != null) goto L41;
        int r131 = 0;
    L42:
        int r132 = (r129 + r131) * 31;
        m r133 = this.f465903l;
        if (r133 != null) goto L45;
        int r134 = 0;
    L46:
        int r135 = (r132 + r134) * 31;
        String r136 = this.f465904m;
        if (r136 != null) goto L49;
        int r137 = 0;
    L50:
        int r138 = (r135 + r137) * 31;
        String r139 = this.f465905n;
        if (r139 != null) goto L53;
        int r140 = 0;
    L54:
        int r141 = (r138 + r140) * 31;
        String r142 = this.f465906o;
        if (r142 == null) goto L59;
        r103 = r142.hashCode();
    L59:
        return r141 + r103;
    L53:
        r140 = r139.hashCode();
        goto L54
    L49:
        r137 = r136.hashCode();
        goto L50
    L45:
        r134 = r133.hashCode();
        goto L46
    L41:
        r131 = r130.hashCode();
        goto L42
    L37:
        r128 = r127.hashCode();
        goto L38
    L33:
        r125 = r124.hashCode();
        goto L34
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasOptionItem(id=" + this.f465892a + ", displayText=" + this.f465893b + ", messageText=" + this.f465894c + ", icon=" + this.f465895d + ", darkModeIcon=" + this.f465896e + ", extra=" + this.f465897f + ", redirectSchema=" + this.f465898g + ", maskUri=" + this.f465899h + ", paramFilterConf=" + this.f465900i + ", msgPromptConf=" + this.f465901j + ", iconOri=" + this.f465902k + ", previewIcon=" + this.f465903l + ", language=" + this.f465904m + ", sourceMessageText=" + this.f465905n + ", targetMessageText=" + this.f465906o + ')';
    }

    public q() {
        this(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public q(long r100, String r101, String r102, m r103, m r104, p r110, String r111, m r112, r r113, o r114, m r115, m r116, String r117, String r118, String r119) {
        this.f465892a = r100;
        this.f465893b = r101;
        this.f465894c = r102;
        this.f465895d = r103;
        this.f465896e = r104;
        this.f465897f = r110;
        this.f465898g = r111;
        this.f465899h = r112;
        this.f465900i = r113;
        this.f465901j = r114;
        this.f465902k = r115;
        this.f465903l = r116;
        this.f465904m = r117;
        this.f465905n = r118;
        this.f465906o = r119;
    }
}

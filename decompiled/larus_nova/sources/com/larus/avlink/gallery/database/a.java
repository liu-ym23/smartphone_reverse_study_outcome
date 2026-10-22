package com.larus.avlink.gallery.database;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f292401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f292402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f292403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f292404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f292405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f292406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f292407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f292408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f292409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f292410j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f292411k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final double f292412l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f292413m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f292414n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f292415o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f292416p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f292417q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f292418r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f292419s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f292420t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f292421u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f292422v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f292423w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f292424x;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f292401a, r101.f292401a) == true) goto L12;
        return false;
    L12:
        if (this.f292402b == r101.f292402b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f292403c, r101.f292403c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f292404d, r101.f292404d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f292405e, r101.f292405e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f292406f, r101.f292406f) == true) goto L27;
        return false;
    L27:
        if (this.f292407g == r101.f292407g) goto L30;
        return false;
    L30:
        if (this.f292408h == r101.f292408h) goto L33;
        return false;
    L33:
        if (this.f292409i == r101.f292409i) goto L36;
        return false;
    L36:
        if (this.f292410j == r101.f292410j) goto L39;
        return false;
    L39:
        if (this.f292411k == r101.f292411k) goto L42;
        return false;
    L42:
        if (Double.compare(this.f292412l, r101.f292412l) == 0) goto L45;
        return false;
    L45:
        if (this.f292413m == r101.f292413m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f292414n, r101.f292414n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f292415o, r101.f292415o) == true) goto L54;
        return false;
    L54:
        if (this.f292416p == r101.f292416p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f292417q, r101.f292417q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f292418r, r101.f292418r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f292419s, r101.f292419s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f292420t, r101.f292420t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f292421u, r101.f292421u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f292422v, r101.f292422v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f292423w, r101.f292423w) == true) goto L78;
        return false;
    L78:
        if (this.f292424x == r101.f292424x) goto L80;
        return false;
    L80:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f292401a.hashCode() * 31;
        long r101 = this.f292402b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        Long r103 = this.f292403c;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f292404d;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f292405e;
        if (r110 != null) goto L13;
        int r111 = 0;
    L14:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f292406f;
        if (r113 != null) goto L17;
        int r114 = 0;
    L18:
        int r115 = (((((r112 + r114) * 31) + this.f292407g) * 31) + this.f292408h) * 31;
        long r116 = this.f292409i;
        int r117 = (((((r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31) + this.f292410j) * 31) + this.f292411k) * 31;
        long r118 = Double.doubleToLongBits(this.f292412l);
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        long r120 = this.f292413m;
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        String r122 = this.f292414n;
        if (r122 != null) goto L21;
        int r123 = 0;
    L22:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f292415o;
        if (r125 != null) goto L25;
        int r126 = 0;
    L26:
        int r127 = (((r124 + r126) * 31) + this.f292416p) * 31;
        Integer r128 = this.f292417q;
        if (r128 != null) goto L29;
        int r129 = 0;
    L30:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f292418r;
        if (r131 != null) goto L33;
        int r132 = 0;
    L34:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f292419s;
        if (r134 != null) goto L37;
        int r135 = 0;
    L38:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f292420t;
        if (r137 != null) goto L41;
        int r138 = 0;
    L42:
        int r139 = (r136 + r138) * 31;
        String r140 = this.f292421u;
        if (r140 != null) goto L45;
        int r141 = 0;
    L46:
        int r142 = (r139 + r141) * 31;
        String r143 = this.f292422v;
        if (r143 != null) goto L49;
        int r144 = 0;
    L50:
        int r145 = (r142 + r144) * 31;
        String r146 = this.f292423w;
        if (r146 == null) goto L55;
        r104 = r146.hashCode();
    L55:
        return ((r145 + r104) * 31) + this.f292424x;
    L49:
        r144 = r143.hashCode();
        goto L50
    L45:
        r141 = r140.hashCode();
        goto L46
    L41:
        r138 = r137.hashCode();
        goto L42
    L37:
        r135 = r134.hashCode();
        goto L38
    L33:
        r132 = r131.hashCode();
        goto L34
    L29:
        r129 = r128.hashCode();
        goto L30
    L25:
        r126 = r125.hashCode();
        goto L26
    L21:
        r123 = r122.hashCode();
        goto L22
    L17:
        r114 = r113.hashCode();
        goto L18
    L13:
        r111 = r110.hashCode();
        goto L14
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "MediaData(id=" + this.f292401a + ", mediaId=" + this.f292402b + ", systemGalleryId=" + this.f292403c + ", fileName=" + this.f292404d + ", fileSize=" + this.f292405e + ", mediaType=" + this.f292406f + ", width=" + this.f292407g + ", height=" + this.f292408h + ", duration=" + this.f292409i + ", outVideoWidth=" + this.f292410j + ", outVideoHeight=" + this.f292411k + ", outputVideoCrop=" + this.f292412l + ", createTime=" + this.f292413m + ", geoLocationInfo=" + this.f292414n + ", algorithmType=" + this.f292415o + ", lifecycleState=" + this.f292416p + ", failureStage=" + this.f292417q + ", failureReason=" + this.f292418r + ", downloadFilePath=" + this.f292419s + ", tempFilePath=" + this.f292420t + ", unpackDirPath=" + this.f292421u + ", processedFilePath=" + this.f292422v + ", finalFilePath=" + this.f292423w + ", activeMask=" + this.f292424x + ')';
    }

    public a(String r100, long r101, Long r102, String r103, Long r104, String r110, int r111, int r112, long r113, int r114, int r115, double r116, long r117, String r210, String r211, int r212, Integer r213, String r214, String r215, String r216, String r217, String r218, String r310, int r311) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f292401a = r100;
        this.f292402b = r101;
        this.f292403c = r102;
        this.f292404d = r103;
        this.f292405e = r104;
        this.f292406f = r110;
        this.f292407g = r111;
        this.f292408h = r112;
        this.f292409i = r113;
        this.f292410j = r114;
        this.f292411k = r115;
        this.f292412l = r116;
        this.f292413m = r117;
        this.f292414n = r210;
        this.f292415o = r211;
        this.f292416p = r212;
        this.f292417q = r213;
        this.f292418r = r214;
        this.f292419s = r215;
        this.f292420t = r216;
        this.f292421u = r217;
        this.f292422v = r218;
        this.f292423w = r310;
        this.f292424x = r311;
    }
}

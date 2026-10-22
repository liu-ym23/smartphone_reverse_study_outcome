package com.larus.avlink.gallery.database;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f292456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f292457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f292458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f292459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f292460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f292461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f292462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f292463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f292464i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f292465j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f292466k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f292467l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f292468m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f292469n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f292470o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f292471p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f292472q;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f292456a, r101.f292456a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f292457b, r101.f292457b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f292458c, r101.f292458c) == true) goto L18;
        return false;
    L18:
        if (this.f292459d == r101.f292459d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f292460e, r101.f292460e) == true) goto L24;
        return false;
    L24:
        if (this.f292461f == r101.f292461f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f292462g, r101.f292462g) == true) goto L30;
        return false;
    L30:
        if (this.f292463h == r101.f292463h) goto L33;
        return false;
    L33:
        if (this.f292464i == r101.f292464i) goto L36;
        return false;
    L36:
        if (this.f292465j == r101.f292465j) goto L39;
        return false;
    L39:
        if (this.f292466k == r101.f292466k) goto L42;
        return false;
    L42:
        if (this.f292467l == r101.f292467l) goto L45;
        return false;
    L45:
        if (this.f292468m == r101.f292468m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f292469n, r101.f292469n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f292470o, r101.f292470o) == true) goto L54;
        return false;
    L54:
        if (this.f292471p == r101.f292471p) goto L57;
        return false;
    L57:
        if (this.f292472q == r101.f292472q) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f292456a.hashCode() * 31) + this.f292457b.hashCode()) * 31) + this.f292458c.hashCode()) * 31;
        long r101 = this.f292459d;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f292460e.hashCode()) * 31;
        long r103 = this.f292461f;
        int r104 = (((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f292462g.hashCode()) * 31) + this.f292463h) * 31) + this.f292464i) * 31;
        long r105 = this.f292465j;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f292466k;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f292467l;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.f292468m;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        String r113 = this.f292469n;
        if (r113 != null) goto L5;
        int r114 = 0;
    L6:
        int r115 = (((((r112 + r114) * 31) + this.f292470o.hashCode()) * 31) + this.f292471p) * 31;
        if (this.f292472q == false) goto L9;
        int r116 = 1231;
    L11:
        return r115 + r116;
    L9:
        r116 = 1237;
        goto L11
    L5:
        r114 = r113.hashCode();
        goto L6
    }

    public final String toString() {
        return "ThumbnailData(id=" + this.f292456a + ", filePath=" + this.f292457b + ", fileName=" + this.f292458c + ", fileSize=" + this.f292459d + ", sn=" + this.f292460e + ", imageUuid=" + this.f292461f + ", mediaType=" + this.f292462g + ", width=" + this.f292463h + ", height=" + this.f292464i + ", duration=" + this.f292465j + ", createTime=" + this.f292466k + ", modifyTime=" + this.f292467l + ", downloadTime=" + this.f292468m + ", geoLocationInfo=" + this.f292469n + ", sourceType=" + this.f292470o + ", processingStatus=" + this.f292471p + ", isSynced=" + this.f292472q + ')';
    }

    public i(String r100, String r110, String r111, long r112, String r113, long r114, String r115, int r116, int r117, long r210, long r211, long r212, long r213, String r214, String r215, int r310, boolean r311) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r110, "filePath");
        Intrinsics.checkNotNullParameter(r111, "fileName");
        Intrinsics.checkNotNullParameter(r113, "sn");
        Intrinsics.checkNotNullParameter(r115, "mediaType");
        Intrinsics.checkNotNullParameter(r215, "sourceType");
        this.f292456a = r100;
        this.f292457b = r110;
        this.f292458c = r111;
        this.f292459d = r112;
        this.f292460e = r113;
        this.f292461f = r114;
        this.f292462g = r115;
        this.f292463h = r116;
        this.f292464i = r117;
        this.f292465j = r210;
        this.f292466k = r211;
        this.f292467l = r212;
        this.f292468m = r213;
        this.f292469n = r214;
        this.f292470o = r215;
        this.f292471p = r310;
        this.f292472q = r311;
    }
}

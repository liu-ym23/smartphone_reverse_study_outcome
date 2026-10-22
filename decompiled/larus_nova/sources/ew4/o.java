package ew4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f474582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f474583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f474584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f474585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f474586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f474587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f474588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f474589h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f474590i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f474591j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f474592k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Double.compare(this.f474582a, r101.f474582a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f474583b, r101.f474583b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474584c, r101.f474584c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474585d, r101.f474585d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474586e, r101.f474586e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474587f, r101.f474587f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f474588g, r101.f474588g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f474589h, r101.f474589h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f474590i, r101.f474590i) == true) goto L36;
        return false;
    L36:
        if (this.f474591j == r101.f474591j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f474592k, r101.f474592k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f474582a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f474583b);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.f474584c;
        int r105 = 0;
        if (r104 != null) goto L5;
        int r106 = 0;
    L6:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f474585d;
        if (r108 != null) goto L9;
        int r109 = 0;
    L10:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f474586e;
        if (r111 != null) goto L13;
        int r112 = 0;
    L14:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f474587f;
        if (r114 != null) goto L17;
        int r115 = 0;
    L18:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f474588g;
        if (r117 != null) goto L21;
        int r118 = 0;
    L22:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f474589h;
        if (r120 != null) goto L25;
        int r121 = 0;
    L26:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f474590i;
        if (r123 != null) goto L29;
        int r124 = 0;
    L30:
        int r125 = (((r122 + r124) * 31) + this.f474591j) * 31;
        String r126 = this.f474592k;
        if (r126 == null) goto L35;
        r105 = r126.hashCode();
    L35:
        return r125 + r105;
    L29:
        r124 = r123.hashCode();
        goto L30
    L25:
        r121 = r120.hashCode();
        goto L26
    L21:
        r118 = r117.hashCode();
        goto L22
    L17:
        r115 = r114.hashCode();
        goto L18
    L13:
        r112 = r111.hashCode();
        goto L14
    L9:
        r109 = r108.hashCode();
        goto L10
    L5:
        r106 = r104.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommonLocationInfo(latitude=" + this.f474582a + ", longitude=" + this.f474583b + ", name=" + this.f474584c + ", address=" + this.f474585d + ", province=" + this.f474586e + ", city=" + this.f474587f + ", district=" + this.f474588g + ", street=" + this.f474589h + ", streetNumber=" + this.f474590i + ", errorCode=" + this.f474591j + ", errorMsg=" + this.f474592k + ')';
    }

    public o(double r100, double r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111, int r112, String r113) {
        this.f474582a = r100;
        this.f474583b = r101;
        this.f474584c = r102;
        this.f474585d = r103;
        this.f474586e = r104;
        this.f474587f = r105;
        this.f474588g = r106;
        this.f474589h = r110;
        this.f474590i = r111;
        this.f474591j = r112;
        this.f474592k = r113;
    }
}

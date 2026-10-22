package e25;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f470818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f470819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f470820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f470821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f470822e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f470823f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f470824g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f470825h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f470826i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f470827j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f470828k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f470829l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f470830m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f470831n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f470832o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f470833p;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f470818a == r101.f470818a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470819b, r101.f470819b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f470820c, r101.f470820c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f470821d, r101.f470821d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f470822e, r101.f470822e) == true) goto L24;
        return false;
    L24:
        if (this.f470823f == r101.f470823f) goto L27;
        return false;
    L27:
        if (this.f470824g == r101.f470824g) goto L30;
        return false;
    L30:
        if (this.f470825h == r101.f470825h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f470826i, r101.f470826i) == true) goto L36;
        return false;
    L36:
        if (this.f470827j == r101.f470827j) goto L39;
        return false;
    L39:
        if (this.f470828k == r101.f470828k) goto L42;
        return false;
    L42:
        if (this.f470829l == r101.f470829l) goto L45;
        return false;
    L45:
        if (this.f470830m == r101.f470830m) goto L48;
        return false;
    L48:
        if (this.f470831n == r101.f470831n) goto L51;
        return false;
    L51:
        if (this.f470832o == r101.f470832o) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f470833p, r101.f470833p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f470818a * 31;
        String r101 = this.f470819b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f470820c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f470821d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f470822e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((((((r110 + r112) * 31) + this.f470823f) * 31) + this.f470824g) * 31) + this.f470825h) * 31;
        String r114 = this.f470826i;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        long r116 = this.f470827j;
        int r117 = (((r113 + r115) * 31) + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = this.f470828k;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        long r120 = this.f470829l;
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        long r122 = this.f470830m;
        int r123 = (((((r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31) + this.f470831n) * 31) + this.f470832o) * 31;
        String r124 = this.f470833p;
        if (r124 == null) goto L27;
        r102 = r124.hashCode();
    L27:
        return r123 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreloadReportParams(fileType=" + this.f470818a + ", loadType=" + this.f470819b + ", loadFrom=" + this.f470820c + ", subFrom=" + this.f470821d + ", loaderType=" + this.f470822e + ", priority=" + this.f470823f + ", resultKey=" + this.f470824g + ", resultCode=" + this.f470825h + ", resultMsg=" + this.f470826i + ", startTime=" + this.f470827j + ", triggerTime=" + this.f470828k + ", taskManagerEnqueueTime=" + this.f470829l + ", preloadManagerEnqueueTime=" + this.f470830m + ", length=" + this.f470831n + ", retry=" + this.f470832o + ", sheetId=" + this.f470833p + ')';
    }

    public c(int r100, String r101, String r102, String r103, String r104, int r105, int r110, int r111, String r112, long r113, long r114, long r115, long r116, int r210, int r211, String r212) {
        this.f470818a = r100;
        this.f470819b = r101;
        this.f470820c = r102;
        this.f470821d = r103;
        this.f470822e = r104;
        this.f470823f = r105;
        this.f470824g = r110;
        this.f470825h = r111;
        this.f470826i = r112;
        this.f470827j = r113;
        this.f470828k = r114;
        this.f470829l = r115;
        this.f470830m = r116;
        this.f470831n = r210;
        this.f470832o = r211;
        this.f470833p = r212;
    }
}

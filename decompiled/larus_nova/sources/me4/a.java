package me4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f513470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f513471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f513472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f513473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f513474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f513475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f513476g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f513470a, r101.f513470a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f513471b, r101.f513471b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f513472c, r101.f513472c) == true) goto L18;
        return false;
    L18:
        if (this.f513473d == r101.f513473d) goto L21;
        return false;
    L21:
        if (this.f513474e == r101.f513474e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f513475f, r101.f513475f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f513476g, r101.f513476g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f513470a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f513471b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f513472c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.f513473d;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.f513474e;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        String r114 = this.f513475f;
        if (r114 != null) goto L17;
        int r115 = 0;
    L18:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f513476g;
        if (r117 == null) goto L23;
        r101 = r117.hashCode();
    L23:
        return r116 + r101;
    L17:
        r115 = r114.hashCode();
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
        return "CertInfo(dn=" + this.f513470a + ", sn=" + this.f513471b + ", version=" + this.f513472c + ", startTs=" + this.f513473d + ", endTs=" + this.f513474e + ", alg=" + this.f513475f + ", pubKey=" + this.f513476g + ')';
    }

    public a(String r100, String r101, String r102, long r103, long r104, String r105, String r106) {
        this.f513470a = r100;
        this.f513471b = r101;
        this.f513472c = r102;
        this.f513473d = r103;
        this.f513474e = r104;
        this.f513475f = r105;
        this.f513476g = r106;
    }
}

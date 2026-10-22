package g25;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f479705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f479706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f479707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f479708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f479709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f479710f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f479705a == r101.f479705a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479706b, r101.f479706b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f479707c, r101.f479707c) == true) goto L18;
        return false;
    L18:
        if (this.f479708d == r101.f479708d) goto L21;
        return false;
    L21:
        if (this.f479709e == r101.f479709e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f479710f, r101.f479710f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f479705a * 31;
        String r101 = this.f479706b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f479707c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((r104 + r106) * 31) + this.f479708d) * 31) + this.f479709e) * 31;
        String r108 = this.f479710f;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfflineResultModelV2Params(code=" + this.f479705a + ", message=" + this.f479706b + ", resValue=" + this.f479707c + ", page=" + this.f479708d + ", totalPage=" + this.f479709e + ", batchNumber=" + this.f479710f + ')';
    }

    public d(int r100, String r101, String r102, int r103, int r104, String r105) {
        this.f479705a = r100;
        this.f479706b = r101;
        this.f479707c = r102;
        this.f479708d = r103;
        this.f479709e = r104;
        this.f479710f = r105;
    }
}

package r4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f536010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f536011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f536012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f536013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f536014e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Double.compare(this.f536010a, r101.f536010a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f536011b, r101.f536011b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f536012c, r101.f536012c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f536013d, r101.f536013d) == true) goto L21;
        return false;
    L21:
        if (this.f536014e == r101.f536014e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f536010a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f536011b);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.f536012c;
        int r105 = 0;
        if (r104 != null) goto L5;
        int r106 = 0;
    L6:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f536013d;
        if (r108 == null) goto L11;
        r105 = r108.hashCode();
    L11:
        return ((r107 + r105) * 31) + this.f536014e;
    L5:
        r106 = r104.hashCode();
        goto L6
    }

    public final String toString() {
        return "OpenLocationRequest(latitude=" + this.f536010a + ", longitude=" + this.f536011b + ", name=" + this.f536012c + ", address=" + this.f536013d + ", scale=" + this.f536014e + ')';
    }

    public o(double r100, double r101, String r102, String r103, int r104) {
        this.f536010a = r100;
        this.f536011b = r101;
        this.f536012c = r102;
        this.f536013d = r103;
        this.f536014e = r104;
    }
}

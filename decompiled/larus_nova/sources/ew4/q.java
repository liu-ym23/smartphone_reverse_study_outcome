package ew4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f474594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f474595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f474596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f474597e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f474593a, r101.f474593a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474594b, r101.f474594b) == true) goto L15;
        return false;
    L15:
        if (Double.compare(this.f474595c, r101.f474595c) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.f474596d, r101.f474596d) == 0) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474597e, r101.f474597e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f474593a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f474594b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = Double.doubleToLongBits(this.f474595c);
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = Double.doubleToLongBits(this.f474596d);
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        Integer r111 = this.f474597e;
        if (r111 == null) goto L15;
        r101 = r111.hashCode();
    L15:
        return r110 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommonLocationParams(name=" + this.f474593a + ", address=" + this.f474594b + ", latitude=" + this.f474595c + ", longitude=" + this.f474596d + ", scale=" + this.f474597e + ')';
    }

    public q(String r100, String r101, double r102, double r103, Integer r104) {
        this.f474593a = r100;
        this.f474594b = r101;
        this.f474595c = r102;
        this.f474596d = r103;
        this.f474597e = r104;
    }
}

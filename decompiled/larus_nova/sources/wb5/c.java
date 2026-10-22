package wb5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f558991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f558992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f558993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f558994e;

    public c(String r100, String r110, double r111, double r112) {
        this(r100, r110, r111, r112, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f558990a, r101.f558990a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558991b, r101.f558991b) == true) goto L15;
        return false;
    L15:
        if (Double.compare(this.f558992c, r101.f558992c) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.f558993d, r101.f558993d) == 0) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f558994e, r101.f558994e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f558990a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f558991b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = Double.doubleToLongBits(this.f558992c);
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = Double.doubleToLongBits(this.f558993d);
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        Integer r111 = this.f558994e;
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
        return "LocationParams(name=" + this.f558990a + ", address=" + this.f558991b + ", latitude=" + this.f558992c + ", longitude=" + this.f558993d + ", scale=" + this.f558994e + ')';
    }

    public c(String r100, String r101, double r102, double r103, Integer r104) {
        this.f558990a = r100;
        this.f558991b = r101;
        this.f558992c = r102;
        this.f558993d = r103;
        this.f558994e = r104;
    }

    public /* synthetic */ c(String r100, String r110, double r111, double r112, int r113) {
        this(r100, r110, r111, r112, null);
    }
}

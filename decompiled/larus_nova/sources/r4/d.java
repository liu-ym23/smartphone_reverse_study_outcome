package r4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f535992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f535993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f535994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Float f535995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Float f535996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f535997f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Double.compare(this.f535992a, r101.f535992a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f535993b, r101.f535993b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f535994c, r101.f535994c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f535995d, r101.f535995d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f535996e, r101.f535996e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f535997f, r101.f535997f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f535992a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f535993b);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.f535994c;
        int r105 = 0;
        if (r104 != null) goto L5;
        int r106 = 0;
    L6:
        int r107 = (r103 + r106) * 31;
        Float r108 = this.f535995d;
        if (r108 != null) goto L9;
        int r109 = 0;
    L10:
        int r110 = (r107 + r109) * 31;
        Float r111 = this.f535996e;
        if (r111 != null) goto L13;
        int r112 = 0;
    L14:
        int r113 = (r110 + r112) * 31;
        Boolean r114 = this.f535997f;
        if (r114 == null) goto L19;
        r105 = r114.hashCode();
    L19:
        return r113 + r105;
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
        return "GetLocationResult(latitude=" + this.f535992a + ", longitude=" + this.f535993b + ", timestamp=" + this.f535994c + ", speed=" + this.f535995d + ", accuracy=" + this.f535996e + ", isLightLocation=" + this.f535997f + ')';
    }

    public d(double r100, double r101, String r102, Float r103, Float r104, Boolean r105) {
        this.f535992a = r100;
        this.f535993b = r101;
        this.f535994c = r102;
        this.f535995d = r103;
        this.f535996e = r104;
        this.f535997f = r105;
    }
}

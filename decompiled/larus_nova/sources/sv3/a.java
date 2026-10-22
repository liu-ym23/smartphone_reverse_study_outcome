package sv3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f543645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f543646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f543647c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Double.compare(this.f543645a, r101.f543645a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f543646b, r101.f543646b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f543647c, r101.f543647c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f543645a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f543646b);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.f543647c;
        if (r104 != null) goto L5;
        int r105 = 0;
    L7:
        return r103 + r105;
    L5:
        r105 = r104.hashCode();
        goto L7
    }

    public final String toString() {
        return "GeoPoint(lat=" + this.f543645a + ", lng=" + this.f543646b + ", name=" + this.f543647c + ')';
    }

    public a(double r100, double r101, String r102) {
        this.f543645a = r100;
        this.f543646b = r101;
        this.f543647c = r102;
    }
}

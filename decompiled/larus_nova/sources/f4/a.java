package f4;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f475432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f475433b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Double.compare(this.f475432a, r101.f475432a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f475433b, r101.f475433b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f475432a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f475433b);
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "AILatLng(lat=" + this.f475432a + ", lng=" + this.f475433b + ')';
    }

    public a(double r100, double r101) {
        this.f475432a = r100;
        this.f475433b = r101;
    }
}

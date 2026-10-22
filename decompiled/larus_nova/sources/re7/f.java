package re7;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f537449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f537450b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Double.compare(this.f537449a, r101.f537449a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f537450b, r101.f537450b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f537449a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f537450b);
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "XGetLocationResult(latitude=" + this.f537449a + ", longitude=" + this.f537450b + ')';
    }

    public f(double r100, double r101) {
        this.f537449a = r100;
        this.f537450b = r101;
    }
}

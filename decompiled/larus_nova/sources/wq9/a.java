package wq9;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f560759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f560760b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Double.compare(this.f560759a, r101.f560759a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f560760b, r101.f560760b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f560759a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f560760b);
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "FlowLatLng(lat=" + this.f560759a + ", lng=" + this.f560760b + ')';
    }

    public a(double r100, double r101) {
        this.f560759a = r100;
        this.f560760b = r101;
    }
}

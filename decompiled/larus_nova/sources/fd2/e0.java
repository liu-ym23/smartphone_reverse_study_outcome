package fd2;

/* JADX INFO: loaded from: classes9.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f476489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f476490b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e0) == false) goto L10;
        e0 r101 = (e0) r100;
        if (this.f476489a == r101.f476489a) goto L8;
        return false;
    L8:
        if (Double.compare(this.f476490b, r101.f476490b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f476489a * 31;
        long r101 = Double.doubleToLongBits(this.f476490b);
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "NetWorkStatus(rtt=" + this.f476489a + ", fractionLost=" + this.f476490b + ")";
    }

    public e0(int r100, double r101) {
        this.f476489a = r100;
        this.f476490b = r101;
    }
}

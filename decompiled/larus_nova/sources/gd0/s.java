package gd0;

/* JADX INFO: loaded from: classes46.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f480896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f480897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f480898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f480899d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L14;
        s r101 = (s) r100;
        if (Double.compare(this.f480896a, r101.f480896a) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.f480897b, r101.f480897b) == 0) goto L10;
        return false;
    L10:
        if (Double.compare(this.f480898c, r101.f480898c) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f480899d, r101.f480899d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f480896a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f480897b);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.f480898c);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = Double.doubleToLongBits(this.f480899d);
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    public final String toString() {
        return "InteractAudienceLayoutData(left=" + this.f480896a + ", right=" + this.f480897b + ", top=" + this.f480898c + ", bottom=" + this.f480899d + ")";
    }

    public s(double r100, double r101, double r102, double r103) {
        this.f480896a = r100;
        this.f480897b = r101;
        this.f480898c = r102;
        this.f480899d = r103;
    }
}

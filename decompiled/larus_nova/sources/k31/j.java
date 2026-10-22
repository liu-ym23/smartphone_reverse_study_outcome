package k31;

/* JADX INFO: loaded from: classes47.dex */
public final class j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f501662e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f501663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f501664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f501665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f501666d;

    public static final class a {
        public a() {
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L14;
        j r101 = (j) r100;
        if (Double.compare(this.f501663a, r101.f501663a) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.f501664b, r101.f501664b) == 0) goto L10;
        return false;
    L10:
        if (Double.compare(this.f501665c, r101.f501665c) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f501666d, r101.f501666d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f501663a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f501664b);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.f501665c);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = Double.doubleToLongBits(this.f501666d);
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    static {
        f501662e = new a();
    }

    public final String toString() {
        return "seiLayout[ratioLeft = " + this.f501663a + ", ratioTop = " + this.f501664b + ", ratioRight = " + this.f501665c + ", ratioBottom = " + this.f501666d + ']';
    }

    public j(double r100, double r101, double r102, double r103) {
        this.f501663a = r100;
        this.f501664b = r101;
        this.f501665c = r102;
        this.f501666d = r103;
    }
}

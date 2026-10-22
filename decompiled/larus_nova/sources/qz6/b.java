package qz6;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f535357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f535358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f535359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f535360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f535361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f535362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f535363g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f535364h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f535365i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final double f535366j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f535367k;

    public final int hashCode() {
        int r100 = (((((int) (((double) (((this.f535357a.hashCode() * 31) + this.f535358b.hashCode()) * 31)) + this.f535359c)) * 31) + this.f535360d) * 31) + this.f535361e;
        long r101 = Double.doubleToLongBits(this.f535362f);
        return (((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f535364h;
    }

    public b(String r100, String r101, double r102, int r103, int r104, double r105, double r106, int r110, int r111, double r112, boolean r113) {
        this.f535357a = r100;
        this.f535358b = r101;
        this.f535359c = r102;
        this.f535360d = r103;
        this.f535361e = r104;
        this.f535362f = r105;
        this.f535363g = r106;
        this.f535364h = r110;
        this.f535365i = r111;
        this.f535366j = r112;
        this.f535367k = r113;
    }
}

package m0;

/* JADX INFO: loaded from: classes28.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f511452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f511453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f511454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f511455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f511456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f511457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f511458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f511459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f511460i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f511461j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f511462k;

    public final int hashCode() {
        int r100 = (((((int) (((double) (((this.f511452a.hashCode() * 31) + this.f511453b.hashCode()) * 31)) + this.f511454c)) * 31) + this.f511455d) * 31) + this.f511456e;
        long r101 = Double.doubleToLongBits(this.f511457f);
        return (((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f511459h;
    }

    public b(String r100, String r101, double r102, int r103, int r104, double r105, double r106, int r110, int r111, int r112, boolean r113) {
        this.f511452a = r100;
        this.f511453b = r101;
        this.f511454c = r102;
        this.f511455d = r103;
        this.f511456e = r104;
        this.f511457f = r105;
        this.f511458g = r106;
        this.f511459h = r110;
        this.f511460i = r111;
        this.f511461j = r112;
        this.f511462k = r113;
    }
}

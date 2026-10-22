package qi6;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g f533173g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g f533174h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final g f533175i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final g f533176j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final g f533177k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f533178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f533179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f533180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f533181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f533182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f533183f;

    public static final class a {
    }

    static {
        f533173g = new g(16, 16, 15, 50);
        f533174h = new g(180, 240, 15, 240);
        f533175i = new g(240, 320, 15, 360);
        f533176j = new g(360, 640, 15, 800);
        f533177k = new g(480, 864, 15, 1200);
    }

    public final String toString() {
        return "VideoQuality(width=" + this.f533180c + ", height=" + this.f533181d + ", fps=" + this.f533182e + ", bitrate=" + this.f533183f + ", origWidth=" + this.f533178a + ", origHeight=" + this.f533179b + ')';
    }

    public g(int r100, int r101, int r102, int r103) {
        this.f533180c = r100;
        this.f533181d = r101;
        this.f533182e = r102;
        this.f533183f = r103;
        this.f533178a = r100;
        this.f533179b = r101;
    }
}

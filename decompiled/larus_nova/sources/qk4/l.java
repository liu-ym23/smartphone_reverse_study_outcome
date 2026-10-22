package qk4;

/* JADX INFO: loaded from: classes15.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f533524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f533525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f533526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f533527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f533528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f533529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f533530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f533531h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f533532i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f533533j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f533534k;

    public final String toString() {
        return "VisionTraceInfo{ id: " + this.f533524a + ", vuiId: " + this.f533525b + ", uuid: " + this.f533526c + ", linkType: " + this.f533527d + ", mode: " + this.f533528e + ", format: " + this.f533530g + ", visionStart -> transStart: " + (this.f533533j - this.f533532i) + ", transStart -> visionEnd: " + (this.f533534k - this.f533533j) + ", visionStart -> visionEnd: " + (this.f533534k - this.f533532i) + ", size: " + this.f533529f + ", speed: " + this.f533531h + " }";
    }

    public l(long r100, int r101, int r102, int r103, int r104) {
        this.f533524a = r100;
        this.f533525b = r101;
        this.f533526c = r102;
        this.f533528e = r103;
        this.f533530g = r104;
    }
}

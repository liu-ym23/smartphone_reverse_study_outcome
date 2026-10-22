package v07;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f552330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f552331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f552332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f552333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f552334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f552335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f552336g;

    public final synchronized void a() {
        monitor-enter(this);
        int r100 = this.f552330a;     // Catch: Throwable -> L19
        float r101 = r100 / this.f552331b;     // Catch: Throwable -> L19
        int r102 = this.f552332c;     // Catch: Throwable -> L19
        int r103 = this.f552333d;     // Catch: Throwable -> L19
        float r104 = r102 / r103;     // Catch: Throwable -> L19
        if (r104 <= r101) goto L7;
        int r105 = (int) (r103 * r101);     // Catch: Throwable -> L19
    L10:
        int r106 = r103;
    L11:
        if (r102 <= r100) goto L13;
        this.f552334e = r100 / r102;     // Catch: Throwable -> L19
    L16:
        float r107 = (r102 - r105) / 2.0f;     // Catch: Throwable -> L19
        float r108 = this.f552334e;     // Catch: Throwable -> L19
        this.f552335f = r107 / r108;     // Catch: Throwable -> L19
        this.f552336g = ((r103 - r106) / 2.0f) / r108;     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L13:
        if (r100 <= r102) goto L15;
        this.f552334e = r102 / r100;     // Catch: Throwable -> L19
        goto L16
    L15:
        this.f552334e = 1.0f;     // Catch: Throwable -> L19
        goto L16
    L7:
        if (r104 >= r101) goto L9;
        r106 = (int) (r102 / r101);     // Catch: Throwable -> L19
        r105 = r102;
        goto L11
    L9:
        r105 = r102;
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized float b() {
        monitor-enter(this);
        float r100 = this.f552335f;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized float c() {
        monitor-enter(this);
        float r100 = this.f552334e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized float d() {
        monitor-enter(this);
        float r100 = this.f552336g;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public g(int r100, int r101) {
        this.f552334e = 1.0f;
        this.f552335f = 0.0f;
        this.f552336g = 0.0f;
        this.f552330a = r100;
        this.f552331b = r101;
    }

    public final synchronized void e(int r100, int r101) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f552332c == r100) goto L6;
    L9:
        this.f552332c = r100;     // Catch: Throwable -> L12
        this.f552333d = r101;     // Catch: Throwable -> L12
        a();     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L6:
        if (this.f552333d != r101) goto L9;
        monitor-exit(this);
    }
}

package s47;

/* JADX INFO: loaded from: classes21.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f540632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f540633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i47.e f540634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Throwable f540635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l47.a<i47.e> f540636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public l47.a<Throwable> f540637f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l47.c f540638g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f540639h;

    public j() {
        this.f540639h = -1;
    }

    public final l47.c a(v47.j r100, v47.k r101) {
        monitor-enter(this);
        i47.e r102 = this.f540634c;     // Catch: Throwable -> L16
        boolean r103 = true;
        if (r102 == null) goto L6;
        r100.accept(r102);     // Catch: Throwable -> L16
        boolean r104 = true;
    L7:
        Throwable r105 = this.f540635d;     // Catch: Throwable -> L16
        if (r105 == null) goto L10;
        r101.accept(r105);     // Catch: Throwable -> L16
    L11:
        if (r103 == true) goto L13;
        this.f540636e = r100;     // Catch: Throwable -> L16
        this.f540637f = r101;     // Catch: Throwable -> L16
    L13:
        l47.c r106 = this.f540638g;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r106;
    L10:
        r103 = r104;
        goto L11
    L6:
        r104 = false;
    L16:
        th = move-exception;
        throw th;
    }
}

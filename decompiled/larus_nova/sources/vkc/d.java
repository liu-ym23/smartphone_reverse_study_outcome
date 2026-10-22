package vkc;

/* JADX INFO: loaded from: classes40.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile d f555573e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f555574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f555575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f555576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f555577d;

    public static d b() {
        if (f555573e != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f555573e != null) goto L9;
        f555573e = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f555573e;
    }

    public d() {
        this.f555574a = new g();
        a(new c(new c.a()));
    }

    public final void a(c r100) {
        a r101 = new a(r100);
        this.f555575b = r101;
        this.f555576c = new e(this.f555574a, r101, r100.f555567f, r100.f555568g);
        this.f555577d = r100.f555565d;
    }
}

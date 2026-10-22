package kx5;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f506559a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f506560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f506561c;

    public static c b() {
        if (f506561c != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f506561c != null) goto L9;
        f506561c = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f506561c;
    }

    public static synchronized d c() {
        monitor-enter(c.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f506560b != null) goto L7;
        d.a r100 = new d.a();     // Catch: Throwable -> L10
        r100.f506570a = 8;     // Catch: Throwable -> L10
        r100.f506572c = 8;     // Catch: Throwable -> L10
        r100.f506571b = 8;     // Catch: Throwable -> L10
        r100.f506573d = 8;     // Catch: Throwable -> L10
        r100.f506574e = 30;     // Catch: Throwable -> L10
        r100.f506576g = 10;     // Catch: Throwable -> L10
        r100.f506575f = 10;     // Catch: Throwable -> L10
        r100.f506577h = true;     // Catch: Throwable -> L10
        f506560b = new d(r100);     // Catch: Throwable -> L10
    L7:
        d r101 = f506560b;     // Catch: Throwable -> L10
        monitor-exit(c.class);
        return r101;
    }

    public c() {
        if (f506560b != null) goto L6;
        d.a r100 = new d.a();
        r100.f506570a = 8;
        r100.f506572c = 8;
        r100.f506571b = 8;
        r100.f506573d = 8;
        r100.f506574e = 30;
        r100.f506576g = 10;
        r100.f506575f = 10;
        r100.f506577h = true;
        f506560b = new d(r100);
        return;
    }

    public static synchronized void d(boolean r100) {
        monitor-enter(c.class);
        f506559a = r100;     // Catch: Throwable -> L9
        if (f506560b == null) goto L7;
        d r101 = f506560b;     // Catch: Throwable -> L9
        r101.f506569h = f506559a;     // Catch: Throwable -> L9
    L7:
        monitor-exit(c.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(com.bytedance.frameworks.baselib.network.dispatcher.a r100) {
        monitor-enter(this);
        com.bytedance.frameworks.baselib.network.dispatcher.c.f244658g.a(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}

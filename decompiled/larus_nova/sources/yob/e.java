package yob;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f568692a;

    public e() {
    }

    public static d a() {
        if (f568692a != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f568692a != null) goto L9;
        f568692a = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f568692a;
    }
}

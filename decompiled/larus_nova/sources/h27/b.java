package h27;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {
    public static synchronized void a(cl9.a r100) {
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (a.f483620c == false) goto L8;
        monitor-exit(b.class);
        return;
    L8:
        a.f483619b = r100;     // Catch: Throwable -> L11
        a.f483618a = r100.b();     // Catch: Throwable -> L11
        new j27.b();     // Catch: Throwable -> L11
        a.f483620c = true;     // Catch: Throwable -> L11
        monitor-exit(b.class);
    }
}

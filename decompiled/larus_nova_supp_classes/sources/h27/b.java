package h27;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b extends a {
    public static synchronized void a(cl9.a r2) {
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (a.c == false) goto L8;
        monitor-exit(b.class);
        return;
    L8:
        a.b = r2;     // Catch: Throwable -> L11
        a.a = r2.b();     // Catch: Throwable -> L11
        new j27.b();     // Catch: Throwable -> L11
        a.c = true;     // Catch: Throwable -> L11
        monitor-exit(b.class);
    }
}

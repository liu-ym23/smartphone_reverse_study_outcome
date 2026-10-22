package l4c;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f507363a;

    public static a a() {
        if (f507363a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f507363a != null) goto L9;
        f507363a = new a();     // Catch: Throwable -> L11
        f507363a.b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f507363a;
    }
}

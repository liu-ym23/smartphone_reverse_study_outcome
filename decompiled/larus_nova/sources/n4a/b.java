package n4a;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f517162a;

    public b() {
    }

    public static void a() {
        if (f517162a == null) goto L5;
        return;
    L5:
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f517162a != null) goto L9;
        f517162a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    }
}

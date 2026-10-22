package n07;

import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static o07.a f516584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static p07.a f516585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f516586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f516587d = null;

    public b() {
    }

    static {
        f516587d = new e();
    }

    public static o07.a a() {
        monitor-enter(b.class);
        o07.a r100 = f516584a;     // Catch: Throwable -> L7
        monitor-exit(b.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static void c(p07.a r100) {
        monitor-enter(b.class);
        f516585b = r100;     // Catch: Throwable -> L7
        monitor-exit(b.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void d(o07.a r100) {
        monitor-enter(b.class);
        f516584a = r100;     // Catch: Throwable -> L7
        monitor-exit(b.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void b(String r100, Map<String, String> r101) {
        monitor-enter(b.class);
        p07.a r102 = f516585b;     // Catch: Throwable -> L11
        if (r102 != null) goto L8;
        monitor-exit(b.class);     // Catch: Throwable -> L11
        return;
    L8:
        r102.a(r100, r101);     // Catch: Throwable -> L11
        monitor-exit(b.class);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}

package wt5;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f561223a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f561224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f561225c;

    static {
        f561223a = new c();
    }

    public c() {
    }

    public final synchronized void a() {
        monitor-enter(this);
        f561224b = true;     // Catch: Throwable -> L7
        f561225c = new a();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}

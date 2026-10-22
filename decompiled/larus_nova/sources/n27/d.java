package n27;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f516746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f516747c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f516748a;

    static {
        f516747c = new a();
    }

    public static d a() {
        if (f516746b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f516746b != null) goto L9;
        f516746b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f516746b;
    }

    public d() {
        this.f516748a = 0;
    }
}

package ms.bd.c;

/* JADX INFO: loaded from: classes5.dex */
public final class a4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a4 f515101c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f515102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f515103b;

    public static a4 a() {
        if (f515101c != null) goto L15;
        monitor-enter(a4.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f515101c != null) goto L9;
        f515101c = new a4();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a4.class);     // Catch: Throwable -> L11
    L15:
        return f515101c;
    }

    public a4() {
        this.f515102a = 0;
        this.f515103b = null;
    }
}

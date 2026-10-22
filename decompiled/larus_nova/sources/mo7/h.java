package mo7;

/* JADX INFO: loaded from: classes22.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile h f514615a;

    public static h a() {
        if (f514615a != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f514615a != null) goto L9;
        f514615a = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f514615a;
    }

    public h() {
    }
}

package v04;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f552301a;

    public static a a() {
        if (f552301a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f552301a != null) goto L9;
        f552301a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f552301a;
    }

    public a() {
    }
}

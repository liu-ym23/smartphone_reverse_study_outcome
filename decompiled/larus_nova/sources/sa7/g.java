package sa7;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile g f541193a;

    public static void a() {
        if (f541193a == null) goto L5;
        return;
    L5:
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f541193a != null) goto L9;
        f541193a = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    }

    public g() {
        com.ss.android.account.k.d().getApplicationContext();
    }
}

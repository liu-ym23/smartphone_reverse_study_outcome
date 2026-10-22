package u17;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f548307a;

    public b() {
        this.f548307a = e.a.f548311a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f548307a.getClass();     // Catch: Throwable -> L7 Exception -> L9
        if (t17.a.a("performance_modules", "memory", "npth_hprof_close_expired") == true) goto L16;
        r17.b.f535670b.a(new d(), "checkFileExpired");     // Catch: Throwable -> L7 Exception -> L9
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    L20:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
        goto L16
    }
}

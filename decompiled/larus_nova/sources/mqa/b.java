package mqa;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f514904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f514905b;

    public final void a() {
        Object r100 = this.f514905b.f514916j;     // Catch: Exception -> L19
        monitor-enter(r100);     // Catch: Exception -> L19
        c r101 = this.f514905b;     // Catch: Throwable -> L16
        if (r101.f514915i == true) goto L9;
        monitor-exit(r100);     // Catch: Throwable -> L16
        return;
    L9:
        nqa.b r102 = nqa.a.a(r101.f514908b).b();     // Catch: Throwable -> L16
        com.bytedance.push.utils.f.b("ActivityThreadHandler", "updateLog() called processStartDbInfo = " + r102);     // Catch: Throwable -> L16
        if (r102 == null) goto L14;
        r102.f520152b = this.f514904a;     // Catch: Throwable -> L16
        com.bytedance.push.utils.f.b("ActivityThreadHandler", "updateLog() called update = " + r102);     // Catch: Throwable -> L16
        boolean r103 = nqa.a.a(this.f514905b.f514908b).e(r102);     // Catch: Throwable -> L16
        if (com.bytedance.push.utils.f.f267065a == false) goto L14;
        com.bytedance.push.utils.f.b("ActivityThreadHandler", "updateLog: result = " + r103);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r100);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(c r100, String r101) {
        this.f514905b = r100;
        this.f514904a = r101;
    }
}

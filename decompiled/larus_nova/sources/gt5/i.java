package gt5;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ft5.a f482540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f482541b;

    public i(ft5.a r100, String r101) {
        this.f482540a = r100;
        this.f482541b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r100 = new g("wb_container_resume", e.f482529m, this.f482540a);     // Catch: Throwable -> L4
        p.c(r100, this.f482541b);     // Catch: Throwable -> L4
        r100.flush();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

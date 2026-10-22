package dxb;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cxb.a f470475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f470476b;

    public i(cxb.a r100, String r101) {
        this.f470475a = r100;
        this.f470476b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r100 = new g("wb_container_resume", c.f470464i, this.f470475a);     // Catch: Throwable -> L4
        int r101 = t.f470510a;     // Catch: Throwable -> L4
        t.c(r100, this.f470476b);     // Catch: Throwable -> L4
        r100.b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

package dxb;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cxb.a f470505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f470506b;

    public q(cxb.a r100, String r101) {
        this.f470505a = r100;
        this.f470506b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r100 = new g("wb_browse_url_end", c.f470462g, this.f470505a);     // Catch: Throwable -> L4
        int r101 = t.f470510a;     // Catch: Throwable -> L4
        t.a(this.f470505a, r100, this.f470506b);     // Catch: Throwable -> L4
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

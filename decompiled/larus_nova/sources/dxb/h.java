package dxb;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cxb.a f470473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f470474b;

    public h(cxb.a r100, String r101) {
        this.f470473a = r100;
        this.f470474b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r100 = new g("wb_container_pause", c.f470465j, this.f470473a);     // Catch: Throwable -> L4
        int r101 = t.f470510a;     // Catch: Throwable -> L4
        t.a(this.f470473a, r100, this.f470474b);     // Catch: Throwable -> L4
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

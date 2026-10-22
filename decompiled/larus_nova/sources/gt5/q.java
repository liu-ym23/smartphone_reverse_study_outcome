package gt5;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ft5.a f482571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f482572b;

    public q(ft5.a r100, String r101) {
        this.f482571a = r100;
        this.f482572b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r100 = new g("wb_browse_url_end", e.f482527k, this.f482571a);     // Catch: Throwable -> L4
        int r101 = p.f482566a;     // Catch: Throwable -> L4
        p.a(this.f482571a, r100, this.f482572b);     // Catch: Throwable -> L4
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

package gt5;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ft5.a f482538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f482539b;

    public h(ft5.a r100, String r101) {
        this.f482538a = r100;
        this.f482539b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r100 = new g("wb_container_pause", e.f482530n, this.f482538a);     // Catch: Throwable -> L4
        int r101 = p.f482566a;     // Catch: Throwable -> L4
        p.a(this.f482538a, r100, this.f482539b);     // Catch: Throwable -> L4
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

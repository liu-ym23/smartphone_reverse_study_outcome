package dxb;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cxb.a f470485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f470486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f470487c;

    public l(cxb.a r100, boolean r101, String r102) {
        this.f470485a = r100;
        this.f470486b = r101;
        this.f470487c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r100 = new g("wb_load_url_start", c.f470456a, this.f470485a);     // Catch: Throwable -> L4
        r100.a("is_first_page", Boolean.valueOf(this.f470486b));     // Catch: Throwable -> L4
        t.c(r100, this.f470487c);     // Catch: Throwable -> L4
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

package dxb;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cxb.a f470482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f470483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f470484c;

    public k(cxb.a r100, boolean r101, String r102) {
        this.f470482a = r100;
        this.f470483b = r101;
        this.f470484c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r100 = new g("wb_load_resource", null, this.f470482a);     // Catch: Throwable -> L4
        r100.a("is_first_page", Boolean.valueOf(this.f470483b));     // Catch: Throwable -> L4
        t.c(r100, this.f470484c);     // Catch: Throwable -> L4
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

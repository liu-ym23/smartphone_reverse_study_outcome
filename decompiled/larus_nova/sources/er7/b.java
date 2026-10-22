package er7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f473607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f473608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f473609c;

    public final void a() {
        String r100 = this.f473607a;
        if (r100 == null) goto L9;
        c r101 = this.f473609c;
        if (r101.f473610a == null) goto L9;
        if (r100.equals(r101.f473615f) == false) goto L9;
        String r102 = this.f473607a;
        c r103 = this.f473609c;
        ir7.c.c(r102, r103.f473612c, r103.f473611b, this.f473608b, null, "sec_link_strategy", r103.f473619j, false);
        return;
    L9:
        String r104 = this.f473609c.f473615f;
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

    public b(c r100, String r101, int r102) {
        this.f473609c = r100;
        this.f473607a = r101;
        this.f473608b = r102;
    }
}

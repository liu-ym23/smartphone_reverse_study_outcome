package e84;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f471322a;

    public final void a() {
        k r100 = this.f471322a;
        if (i84.a.a(r100.f471314d, r100.f471320j).getBoolean("_install_started_v2", false) == false) goto L9;
        k r101 = this.f471322a;
        n r102 = r101.f471318h;
        k74.c r103 = r101.f471319i;
        if (r103 == null) goto L7;
        r103.a(new l74.d());
    L7:
        this.f471322a.f471316f = null;
        return;
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

    public l(k r100) {
        this.f471322a = r100;
    }
}

package mk6;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f514308a;

    public b(d r100) {
        this.f514308a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d r100 = this.f514308a;     // Catch: Throwable -> L6
        ak6.e r101 = r100.f514317e;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.a(r100.f514316d.c());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}

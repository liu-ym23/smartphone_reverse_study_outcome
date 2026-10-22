package ww7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f561719a;

    @Override // java.lang.Runnable
    public final void run() {
        k0 r100 = c0.f561643e.f561647d;     // Catch: Throwable -> L4
        a r101 = this.f561719a;     // Catch: Throwable -> L4
        r100.a(new g0(r100), r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public v(zw7.b.a r100) {
        c0 r101 = c0.f561643e;
        this.f561719a = r100;
    }
}

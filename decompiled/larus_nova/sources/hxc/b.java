package hxc;

import com.larus.apm.impl.protector.RunnableProtector;
import exc.e;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f487583a;

    @Override // java.lang.Runnable
    public final void run() {
        boolean r100 = this.f487583a.f487578e.await(4000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L7 Throwable -> L9
        e.c("AIDLClientInvokeManager", "startService await");     // Catch: InterruptedException -> L7 Throwable -> L9
        if (r100 == true) goto L14;
        a.d(this.f487583a);     // Catch: InterruptedException -> L7 Throwable -> L9
    L14:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    L18:
        return;
    L7:
        e.c("AIDLClientInvokeManager", "serviceStartDownLatch InterruptedException");     // Catch: Throwable -> L9
        a.d(this.f487583a);     // Catch: Throwable -> L9
        goto L14
    }

    public b(a r100) {
        this.f487583a = r100;
    }
}

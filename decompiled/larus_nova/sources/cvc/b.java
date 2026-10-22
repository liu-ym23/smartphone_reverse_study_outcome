package cvc;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes42.dex */
public abstract class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465512a;

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = ThreadMethodProxy.currentThread().getName();     // Catch: Throwable -> L8
        ThreadMethodProxy.setName(ThreadMethodProxy.currentThread(), this.f465512a);     // Catch: Throwable -> L8
        a();     // Catch: Throwable -> L5
        ThreadMethodProxy.setName(ThreadMethodProxy.currentThread(), r100);     // Catch: Throwable -> L8
        return;
    L5:
        th = move-exception;
        ThreadMethodProxy.setName(ThreadMethodProxy.currentThread(), r100);     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }

    public b(String r100, Object... r101) {
        this.f465512a = c.l(r100, r101);
    }
}

package pl.droidsonroids.gif;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes41.dex */
public abstract class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f529747a;

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        Thread.UncaughtExceptionHandler r100 = Thread.getDefaultUncaughtExceptionHandler();     // Catch: Throwable -> L11
        if (r100 == null) goto L10;
        r100.uncaughtException(ThreadMethodProxy.currentThread(), th);     // Catch: Throwable -> L11
    L10:
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    L20:
        return;
    L3:
        if (this.f529747a.f529714g.o() == true) goto L14;
        a();     // Catch: Throwable -> L6
        return;
    }

    public o(d r100) {
        this.f529747a = r100;
    }
}

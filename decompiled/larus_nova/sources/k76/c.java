package k76;

import com.airbnb.lottie.l;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends PthreadThreadV2 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f502016v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ d f502017w;

    public final void l() {
    L3:
        if (isInterrupted() == true) goto L36;
        if (this.f502016v == true) goto L49;
        if (this.f502017w.f502023f.isDone() == false) goto L3;
        d r100 = this.f502017w;     // Catch: ExecutionException -> L11 Throwable -> L13
        d.a(r100, (l) r100.f502023f.get());     // Catch: ExecutionException -> L11 Throwable -> L13
    L15:
        boolean r101 = true;
        this.f502016v = true;
        d r102 = this.f502017w;
        monitor-enter(r102);
        c r103 = r102.f502019b;     // Catch: Throwable -> L33
        if (r103 != null) goto L20;
    L22:
        r101 = false;
    L23:
        if (r101 == false) goto L24;
        if (r102.f502020c.isEmpty() == false) goto L29;
    L30:
        r102.f502019b.interrupt();     // Catch: Throwable -> L33
        r102.f502019b = null;     // Catch: Throwable -> L33
    L31:
        monitor-exit(r102);
        goto L3
    L29:
        if (r102.f502024g == null) goto L31;
    L24:
        monitor-exit(r102);
        goto L3
    L20:
        if (ThreadMethodProxy.isAlive(r103) == false) goto L22;
    L33:
        th = move-exception;
        throw th;
    L13:
        e = move-exception;
        d.a(this.f502017w, new l(e));
        goto L15
    L49:
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
    public final void run() {
        l();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(d r100) {
        this.f502017w = r100;
        super("LynxLottieTaskObserver");
        this.f502016v = false;
    }
}

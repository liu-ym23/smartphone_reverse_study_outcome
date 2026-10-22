package dv7;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f470180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f470181b;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.lang.Runnable
    public final void run() {
        Object r100 = this.f470181b.f470178b;     // Catch: Throwable -> L12
        monitor-enter(r100);     // Catch: Throwable -> L12
        OnCompleteListener<TResult> r101 = this.f470181b.f470179c;     // Catch: Throwable -> L9
        if (r101 == 0) goto L7;
        r101.onComplete((Task<TResult>) this.f470180a);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    L15:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    }

    public k(j r100, Task r101) {
        this.f470181b = r100;
        this.f470180a = r101;
    }
}

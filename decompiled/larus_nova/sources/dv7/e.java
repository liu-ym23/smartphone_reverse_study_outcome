package dv7;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f470166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f470167b;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void a() {
        if (this.f470166a.isCanceled() == false) goto L19;
        this.f470167b.f470165c.b();
        return;
    L19:
        Object r100 = this.f470167b.f470164b.then((Task<TResult>) this.f470166a);     // Catch: Exception -> L9 RuntimeExecutionException -> L12
        this.f470167b.f470165c.setResult((TContinuationResult) r100);
        return;
    L12:
        e = move-exception;
        if ((e.getCause() instanceof Exception) == false) goto L17;
        this.f470167b.f470165c.a((Exception) e.getCause());
        return;
    L17:
        this.f470167b.f470165c.a(e);
        return;
    L9:
        e = move-exception;
        this.f470167b.f470165c.a(e);
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

    public e(d r100, Task r101) {
        this.f470167b = r100;
        this.f470166a = r101;
    }
}

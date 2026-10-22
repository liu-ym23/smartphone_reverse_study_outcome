package dv7;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f470171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f470172b;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void a() {
        Task r100 = (Task) this.f470172b.f470169b.then((Task<TResult>) this.f470171a);     // Catch: Exception -> L8 RuntimeExecutionException -> L11
        if (r100 != null) goto L6;
        this.f470172b.onFailure(new NullPointerException("Continuation returned null"));
        return;
    L6:
        u r101 = c.f470161b;
        r100.addOnSuccessListener(r101, this.f470172b);
        r100.addOnFailureListener(r101, this.f470172b);
        r100.addOnCanceledListener(r101, this.f470172b);
        return;
    L11:
        e = move-exception;
        if ((e.getCause() instanceof Exception) == false) goto L16;
        this.f470172b.f470170c.a((Exception) e.getCause());
        return;
    L16:
        this.f470172b.f470170c.a(e);
        return;
    L8:
        e = move-exception;
        this.f470172b.f470170c.a(e);
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

    public g(f r100, Task r101) {
        this.f470172b = r100;
        this.f470171a = r101;
    }
}

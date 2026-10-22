package dv7;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes23.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f470195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f470196b;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void a() {
        Task r100 = this.f470196b.f470193b.then((TResult) this.f470195a.getResult());     // Catch: Exception -> L8 CancellationException -> L11 RuntimeExecutionException -> L13
        if (r100 != null) goto L6;
        this.f470196b.onFailure(new NullPointerException("Continuation returned null"));
        return;
    L6:
        u r101 = c.f470161b;
        r100.addOnSuccessListener(r101, this.f470196b);
        r100.addOnFailureListener(r101, this.f470196b);
        r100.addOnCanceledListener(r101, this.f470196b);
        return;
    L13:
        e = move-exception;
        if ((e.getCause() instanceof Exception) == false) goto L18;
        this.f470196b.onFailure((Exception) e.getCause());
        return;
    L18:
        this.f470196b.onFailure(e);
        return;
    L11:
        this.f470196b.onCanceled();
        return;
    L8:
        e = move-exception;
        this.f470196b.onFailure(e);
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

    public q(p r100, Task r101) {
        this.f470196b = r100;
        this.f470195a = r101;
    }
}

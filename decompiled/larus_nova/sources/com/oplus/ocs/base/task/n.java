package com.oplus.ocs.base.task;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f404301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Task f404302b;

    @Override // java.lang.Runnable
    public final void run() {
        com_oplus_ocs_base_task_n_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void com_oplus_ocs_base_task_n__run$___twin___() {
        Task r100 = this.f404301a.f404298a.then((TResult) this.f404302b.getResult());     // Catch: Exception -> L8 RuntimeException -> L11
        if (r100 != null) goto L6;
        this.f404301a.onFailure(new NullPointerException("Continuation returned null"));
        return;
    L6:
        Executor r101 = TaskExecutors.CURRENT_THREAD;
        r100.addOnSuccessListener(r101, this.f404301a);
        r100.addOnFailureListener(r101, this.f404301a);
        r100.addOnCanceledListener(r101, this.f404301a);
        return;
    L11:
        e = move-exception;
        if ((e.getCause() instanceof Exception) == false) goto L16;
        this.f404301a.onFailure((Exception) e.getCause());
        return;
    L16:
        this.f404301a.onFailure(e);
        return;
    L8:
        e = move-exception;
        this.f404301a.onFailure(e);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_oplus_ocs_base_task_n_com_larus_apm_impl_protector_RunnableLancet_run(n r100) {
        r100.com_oplus_ocs_base_task_n__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public n(m r100, Task r101) {
        this.f404301a = r100;
        this.f404302b = r101;
    }
}

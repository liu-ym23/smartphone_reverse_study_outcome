package com.oplus.ocs.base.task;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Task f404296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f404297b;

    @Override // java.lang.Runnable
    public final void run() {
        com_oplus_ocs_base_task_l_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void com_oplus_ocs_base_task_l__run$___twin___() {
        if (this.f404296a.isCanceled() == false) goto L18;
        this.f404297b.f404275b.tryCancel();
        return;
    L18:
        Object r100 = this.f404297b.f404274a.then((Task<TResult>) this.f404296a);     // Catch: Exception -> L8 RuntimeException -> L10
    L16:
        this.f404297b.f404275b.setResult((TContinuationResult) r100);
        return;
    L10:
        e = move-exception;
        if ((e.getCause() instanceof Exception) == false) goto L14;
        this.f404297b.f404275b.setException((Exception) e.getCause());
    L15:
        r100 = null;
        goto L16
    L14:
        this.f404297b.f404275b.setException(e);
    L8:
        e = move-exception;
        this.f404297b.f404275b.setException(e);
        goto L15
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_oplus_ocs_base_task_l_com_larus_apm_impl_protector_RunnableLancet_run(l r100) {
        r100.com_oplus_ocs_base_task_l__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public l(c r100, Task r101) {
        this.f404297b = r100;
        this.f404296a = r101;
    }
}

package com.oplus.ocs.base.task;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f404289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Task f404290b;

    @Override // java.lang.Runnable
    public final void run() {
        com_oplus_ocs_base_task_i_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_oplus_ocs_base_task_i__run$___twin___() {
        if (this.f404289a.a() == null) goto L6;
        this.f404289a.a().onFailure(this.f404290b.getException());
        return;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_oplus_ocs_base_task_i_com_larus_apm_impl_protector_RunnableLancet_run(i r100) {
        r100.com_oplus_ocs_base_task_i__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(h r100, Task r101) {
        this.f404289a = r100;
        this.f404290b = r101;
    }
}

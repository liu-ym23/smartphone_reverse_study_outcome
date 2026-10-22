package com.oplus.ocs.base.task;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f404280a;

    @Override // java.lang.Runnable
    public final void run() {
        com_oplus_ocs_base_task_e_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_oplus_ocs_base_task_e__run$___twin___() {
        if (this.f404280a.a() == null) goto L6;
        this.f404280a.a().onCanceled();
        return;
    }

    public e(d r100) {
        this.f404280a = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_oplus_ocs_base_task_e_com_larus_apm_impl_protector_RunnableLancet_run(e r100) {
        r100.com_oplus_ocs_base_task_e__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

package com.oplus.ocs.base.task;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Callable;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Callable f404272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TaskImpl f404273b;

    @Override // java.lang.Runnable
    public final void run() {
        com_oplus_ocs_base_task_a_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_oplus_ocs_base_task_a__run$___twin___() {
        this.f404273b.setResult(this.f404272a.call());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        this.f404273b.setException(e);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_oplus_ocs_base_task_a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
        r100.com_oplus_ocs_base_task_a__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(TaskImpl r100, Callable r101) {
        this.f404273b = r100;
        this.f404272a = r101;
    }
}

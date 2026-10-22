package com.oplus.ocs.base.task;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f404284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Task f404285b;

    @Override // java.lang.Runnable
    public final void run() {
        com_oplus_ocs_base_task_g_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_oplus_ocs_base_task_g__run$___twin___() {
        Object r100 = this.f404284a.f404281a;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f404284a.a() == null) goto L7;
        this.f404284a.a().onComplete(this.f404285b);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_oplus_ocs_base_task_g_com_larus_apm_impl_protector_RunnableLancet_run(g r100) {
        r100.com_oplus_ocs_base_task_g__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public g(f r100, Task r101) {
        this.f404284a = r100;
        this.f404285b = r101;
    }
}

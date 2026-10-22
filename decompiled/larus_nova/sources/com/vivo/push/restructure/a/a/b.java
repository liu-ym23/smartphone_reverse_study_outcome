package com.vivo.push.restructure.a.a;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f462451a;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_restructure_a_a_b_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_restructure_a_a_b__run$___twin___() {
        a.b(this.f462451a);
    }

    public b(a r100) {
        this.f462451a = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_restructure_a_a_b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
        r100.com_vivo_push_restructure_a_a_b__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

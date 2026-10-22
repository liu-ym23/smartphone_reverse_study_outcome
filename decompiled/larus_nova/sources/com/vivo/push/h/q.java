package com.vivo.push.h;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.m f462371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f462372b;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_h_q_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_h_q__run$___twin___() {
        p r100 = this.f462372b;
        r100.f462339b.onListTags(p.a(r100), this.f462371a.j(), this.f462371a.e(), this.f462371a.i());
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_h_q_com_larus_apm_impl_protector_RunnableLancet_run(q r100) {
        r100.com_vivo_push_h_q__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public q(p r100, com.vivo.push.b.m r101) {
        this.f462372b = r100;
        this.f462371a = r101;
    }
}

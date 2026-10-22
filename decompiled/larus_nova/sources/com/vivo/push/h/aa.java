package com.vivo.push.h;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class aa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.s f462337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ z f462338b;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_h_aa_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_h_aa__run$___twin___() {
        z r100 = this.f462338b;
        r100.f462339b.onPublish(z.a(r100), this.f462337a.j(), this.f462337a.i());
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_h_aa_com_larus_apm_impl_protector_RunnableLancet_run(aa r100) {
        r100.com_vivo_push_h_aa__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public aa(z r100, com.vivo.push.b.s r101) {
        this.f462338b = r100;
        this.f462337a = r101;
    }
}

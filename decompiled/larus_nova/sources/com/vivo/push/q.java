package com.vivo.push;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f462431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f462432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ m f462433c;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_q_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_q__run$___twin___() {
        this.f462433c.a(this.f462431a);
        m.a(this.f462433c, this.f462432b);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_q_com_larus_apm_impl_protector_RunnableLancet_run(q r100) {
        r100.com_vivo_push_q__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public q(m r100, com.vivo.push.b.b r101, String r102) {
        this.f462433c = r100;
        this.f462431a = r101;
        this.f462432b = r102;
    }
}

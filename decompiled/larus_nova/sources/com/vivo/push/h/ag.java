package com.vivo.push.h;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class ag implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.i f462351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ af f462352b;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_h_ag_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_h_ag__run$___twin___() {
        af r100 = this.f462352b;
        r100.f462339b.onUnBind(af.a(r100), this.f462351a.j(), this.f462351a.e());
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_h_ag_com_larus_apm_impl_protector_RunnableLancet_run(ag r100) {
        r100.com_vivo_push_h_ag__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public ag(af r100, com.vivo.push.b.i r101) {
        this.f462352b = r100;
        this.f462351a = r101;
    }
}

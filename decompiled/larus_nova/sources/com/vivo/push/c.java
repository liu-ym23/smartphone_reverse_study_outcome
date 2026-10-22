package com.vivo.push;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushActionListener f462273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f462274b;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_c_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_c__run$___twin___() {
        int r100 = com.vivo.push.restructure.a.a().h().a();
        IPushActionListener r101 = this.f462273a;
        if (r101 == null) goto L6;
        r101.onStateChanged(r100);
        return;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
        r100.com_vivo_push_c__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(a r100, IPushActionListener r101) {
        this.f462274b = r100;
        this.f462273a = r101;
    }
}

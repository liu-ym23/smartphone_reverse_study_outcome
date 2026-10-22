package com.vivo.push;

import com.larus.apm.impl.protector.RunnableProtector;
import com.vivo.push.listener.IPushQueryActionListener;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushQueryActionListener f462216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f462217b;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_b_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_b__run$___twin___() {
        String r100 = com.vivo.push.restructure.a.a().h().b();
        IPushQueryActionListener r101 = this.f462216a;
        if (r101 == null) goto L6;
        r101.onSuccess(r100);
        return;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
        r100.com_vivo_push_b__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(a r100, IPushQueryActionListener r101) {
        this.f462217b = r100;
        this.f462216a = r101;
    }
}

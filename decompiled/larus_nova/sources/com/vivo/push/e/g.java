package com.vivo.push.e;

import com.larus.apm.impl.protector.RunnableProtector;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.t;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f462316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f462317b;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_e_g_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_e_g__run$___twin___() {
        t.b("delete all profileIds");
        d.a(this.f462317b, "", this.f462316a, 3);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_e_g_com_larus_apm_impl_protector_RunnableLancet_run(g r100) {
        r100.com_vivo_push_e_g__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public g(d r100, IPushRequestCallback r101) {
        this.f462317b = r100;
        this.f462316a = r101;
    }
}

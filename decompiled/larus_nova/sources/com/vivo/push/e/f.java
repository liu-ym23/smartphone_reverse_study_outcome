package com.vivo.push.e;

import com.larus.apm.impl.protector.RunnableProtector;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.t;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f462313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f462314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f462315c;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_e_f_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_e_f__run$___twin___() {
        t.b("delete profileId");
        d.a(this.f462315c, this.f462313a, this.f462314b, 2);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_e_f_com_larus_apm_impl_protector_RunnableLancet_run(f r100) {
        r100.com_vivo_push_e_f__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(d r100, String r101, IPushRequestCallback r102) {
        this.f462315c = r100;
        this.f462313a = r101;
        this.f462314b = r102;
    }
}

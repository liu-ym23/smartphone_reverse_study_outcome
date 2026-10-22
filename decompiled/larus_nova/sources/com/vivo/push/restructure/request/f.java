package com.vivo.push.restructure.request;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f462508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f462509b;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_restructure_request_f_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_restructure_request_f__run$___twin___() {
        b r100 = this.f462508a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.b() == null) goto L9;
        this.f462508a.b().a(1003);
        return;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_restructure_request_f_com_larus_apm_impl_protector_RunnableLancet_run(f r100) {
        r100.com_vivo_push_restructure_request_f__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(e r100, b r101) {
        this.f462509b = r100;
        this.f462508a = r101;
    }
}

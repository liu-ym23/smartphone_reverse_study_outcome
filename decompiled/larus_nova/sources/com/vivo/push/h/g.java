package com.vivo.push.h;

import com.larus.apm.impl.protector.RunnableProtector;
import com.vivo.push.model.UPSNotificationMessage;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSNotificationMessage f462356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f462357b;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_h_g_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_h_g__run$___twin___() {
        e r100 = this.f462357b;
        r100.f462339b.onNotificationMessageClicked(e.a(r100), this.f462356a);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_h_g_com_larus_apm_impl_protector_RunnableLancet_run(g r100) {
        r100.com_vivo_push_h_g__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public g(e r100, UPSNotificationMessage r101) {
        this.f462357b = r100;
        this.f462356a = r101;
    }
}

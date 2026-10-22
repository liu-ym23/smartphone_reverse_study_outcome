package com.vivo.push;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f462434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ m f462435b;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_r_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_r__run$___twin___() {
        m.a r100 = m.b(this.f462435b, this.f462434a);
        if (r100 == null) goto L6;
        r100.a(1003, new Object[0]);
        return;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_r_com_larus_apm_impl_protector_RunnableLancet_run(r r100) {
        r100.com_vivo_push_r__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public r(m r100, String r101) {
        this.f462435b = r100;
        this.f462434a = r101;
    }
}

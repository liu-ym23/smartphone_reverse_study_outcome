package com.vivo.push.h;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.n f462373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ r f462374b;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_h_s_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_h_s__run$___twin___() {
        r r100 = this.f462374b;
        r100.f462339b.onLog(r.a(r100), this.f462373a.e(), this.f462373a.f(), this.f462373a.g());
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_h_s_com_larus_apm_impl_protector_RunnableLancet_run(s r100) {
        r100.com_vivo_push_h_s__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public s(r r100, com.vivo.push.b.n r101) {
        this.f462374b = r100;
        this.f462373a = r101;
    }
}

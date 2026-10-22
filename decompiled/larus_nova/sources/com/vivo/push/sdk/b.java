package com.vivo.push.sdk;

import com.larus.apm.impl.protector.RunnableProtector;
import com.vivo.push.m;
import com.vivo.push.util.t;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.restructure.a.a f462515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f462516b;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_sdk_b_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_sdk_b__run$___twin___() {
        com.vivo.push.restructure.a.a().a(a.a(this.f462516b));
        t.d("CommandWorker", " handleMessage type: ".concat(String.valueOf(this.f462515a.j())));
        m.a().a(a.b(this.f462516b));
        com.vivo.push.restructure.a.a().d().a(this.f462515a);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_sdk_b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
        r100.com_vivo_push_sdk_b__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(a r100, com.vivo.push.restructure.a.b r101) {
        this.f462516b = r100;
        this.f462515a = r101;
    }
}

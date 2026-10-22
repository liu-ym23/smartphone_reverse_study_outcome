package com.vivo.push.util;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f462603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ o f462604b;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_util_p_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_util_p__run$___twin___() {
        if (o.a(this.f462604b) == null) goto L6;
        ad.c().a("com.vivo.push.notify_key", o.b(this.f462604b));
        NotifyAdapterUtil.pushNotification(o.c(this.f462604b), this.f462603a, o.a(this.f462604b), o.b(this.f462604b), o.d(this.f462604b), o.e(this.f462604b), o.f(this.f462604b));
        return;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_util_p_com_larus_apm_impl_protector_RunnableLancet_run(p r100) {
        r100.com_vivo_push_util_p__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public p(o r100, List r101) {
        this.f462604b = r100;
        this.f462603a = r101;
    }
}

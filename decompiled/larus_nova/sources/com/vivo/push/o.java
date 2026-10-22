package com.vivo.push;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f462427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f462428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ m f462429c;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_o_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_o__run$___twin___() {
        this.f462429c.a(this.f462427a);
        m.a(this.f462429c, this.f462428b);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_o_com_larus_apm_impl_protector_RunnableLancet_run(o r100) {
        r100.com_vivo_push_o__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public o(m r100, com.vivo.push.b.b r101, String r102) {
        this.f462429c = r100;
        this.f462427a = r101;
        this.f462428b = r102;
    }
}

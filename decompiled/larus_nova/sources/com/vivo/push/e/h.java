package com.vivo.push.e;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.t;
import java.util.ArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f462318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f462319b;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_e_h_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_e_h__run$___twin___() {
        t.b("query all profileIds");
        if (com.vivo.push.restructure.a.a().g().b() == 0) goto L8;
        t.b("core not support sync profileInfo");
        IPushRequestCallback r100 = this.f462318a;
        if (r100 == null) goto L8;
        r100.onError(AVMDLDataLoader.KeyIsLiveEnableMdlProto);
        return;
    L8:
        Context r101 = com.vivo.push.restructure.a.a().b();
        ArrayList r102 = new ArrayList();
        com.vivo.push.restructure.request.b r103 = new com.vivo.push.restructure.request.b(new com.vivo.push.e.a.a(new com.vivo.push.e.a.b(r101.getPackageName(), r102, 4)), new i(this), 20000);
        com.vivo.push.restructure.request.d.a().a(r103);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_e_h_com_larus_apm_impl_protector_RunnableLancet_run(h r100) {
        r100.com_vivo_push_e_h__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(d r100, IPushRequestCallback r101) {
        this.f462319b = r100;
        this.f462318a = r101;
    }
}

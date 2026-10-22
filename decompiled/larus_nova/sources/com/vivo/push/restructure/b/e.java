package com.vivo.push.restructure.b;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.vivo.push.PushConfig;
import com.vivo.push.util.ah;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f462478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PushConfig f462479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f462480c;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_restructure_b_e_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_restructure_b_e__run$___twin___() {
        Context r100 = this.f462478a;
        ah.a(r100, r100.getPackageName(), this.f462479b.isAgreePrivacyStatement());
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_restructure_b_e_com_larus_apm_impl_protector_RunnableLancet_run(e r100) {
        r100.com_vivo_push_restructure_b_e__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(d r100, Context r101, PushConfig r102) {
        this.f462480c = r100;
        this.f462478a = r101;
        this.f462479b = r102;
    }
}

package com.vivo.push.h;

import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f462358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.i f462359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ h f462360c;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_h_i_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_h_i__run$___twin___() {
        if (TextUtils.isEmpty(this.f462358a) == true) goto L5;
        h r100 = this.f462360c;
        r100.f462339b.onReceiveRegId(h.a(r100), this.f462358a);
    L5:
        h r101 = this.f462360c;
        r101.f462339b.onBind(h.b(r101), this.f462359b.j(), this.f462359b.e());
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_h_i_com_larus_apm_impl_protector_RunnableLancet_run(i r100) {
        r100.com_vivo_push_h_i__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(h r100, String r101, com.vivo.push.b.i r102) {
        this.f462360c = r100;
        this.f462358a = r101;
        this.f462359b = r102;
    }
}

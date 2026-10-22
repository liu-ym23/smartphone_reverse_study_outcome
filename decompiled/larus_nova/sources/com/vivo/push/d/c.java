package com.vivo.push.d;

import android.app.Activity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.vivo.push.IPushActionListener;
import com.vivo.push.util.v;
import com.vivo.push.util.w;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f462282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IPushActionListener f462283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ b f462284c;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_d_c_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_d_c__run$___twin___() {
        int r100 = b.a(this.f462282a);
        if (r100 == 0) goto L6;
        this.f462283b.onStateChanged(r100);
        return;
    L6:
        boolean r101 = w.a(this.f462282a);
        com.vivo.push.restructure.request.b r102 = new com.vivo.push.restructure.request.b(new a(new g(v.a(), r101)), new d(this), 3000);
        com.vivo.push.restructure.request.d.a().a(r102);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_d_c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
        r100.com_vivo_push_d_c__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(b r100, Activity r101, IPushActionListener r102) {
        this.f462284c = r100;
        this.f462282a = r101;
        this.f462283b = r102;
    }
}

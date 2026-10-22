package com.vivo.push.d;

import android.app.Activity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.vivo.push.IPushActionListener;
import com.vivo.push.util.v;
import com.vivo.push.util.w;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f462286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IPushActionListener f462287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f462288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ b f462289d;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_d_e_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_d_e__run$___twin___() {
        int r100 = b.a(this.f462286a);
        if (r100 == 0) goto L6;
        this.f462287b.onStateChanged(r100);
        return;
    L6:
        boolean r101 = w.a(this.f462286a);
        com.vivo.push.restructure.request.b r102 = new com.vivo.push.restructure.request.b(new a(new g(this.f462288c, v.a(), r101)), new f(this), 3000);
        com.vivo.push.restructure.request.d.a().a(r102);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_d_e_com_larus_apm_impl_protector_RunnableLancet_run(e r100) {
        r100.com_vivo_push_d_e__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(b r100, Activity r101, IPushActionListener r102, long r103) {
        this.f462289d = r100;
        this.f462286a = r101;
        this.f462287b = r102;
        this.f462288c = r103;
    }
}

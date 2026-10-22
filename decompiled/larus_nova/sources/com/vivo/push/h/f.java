package com.vivo.push.h;

import android.content.Context;
import android.content.Intent;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f462353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f462354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ e f462355c;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_h_f_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_h_f__run$___twin___() {
        Intent r100 = this.f462353a.getPackageManager().getLaunchIntentForPackage(this.f462353a.getPackageName());
        if (r100 == null) goto L6;
        r100.setFlags(268435456);
        e.a(r100, this.f462354b);
        this.f462353a.startActivity(r100);
        return;
    L6:
        com.vivo.push.util.t.a("NotifyOpenClientTask", "LaunchIntent is null");
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_h_f_com_larus_apm_impl_protector_RunnableLancet_run(f r100) {
        r100.com_vivo_push_h_f__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(e r100, Context r101, Map r102) {
        this.f462355c = r100;
        this.f462353a = r101;
        this.f462354b = r102;
    }
}

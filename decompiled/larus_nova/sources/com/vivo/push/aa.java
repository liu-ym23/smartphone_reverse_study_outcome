package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.vivo.push.util.ah;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class aa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f462210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ z f462211b;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_aa_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_aa__run$___twin___() {
        Context r100 = com.vivo.push.restructure.a.a().b();
        if (r100 != null) goto L6;
        return;
    L6:
        if (m.a().f() == false) goto L8;
        long r101 = 506;
    L10:
        if (TextUtils.isEmpty(this.f462210a) == false) goto L12;
        return;
    L12:
        if (ah.a(r100, r100.getPackageName(), this.f462210a, r101) == false) goto L16;
        com.vivo.push.restructure.a.a().e().e();
        z.a(this.f462211b, "");
        return;
    L16:
        return;
    L8:
        r101 = 356;
        goto L10
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_aa_com_larus_apm_impl_protector_RunnableLancet_run(aa r100) {
        r100.com_vivo_push_aa__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public aa(z r100, String r101) {
        this.f462211b = r100;
        this.f462210a = r101;
    }
}

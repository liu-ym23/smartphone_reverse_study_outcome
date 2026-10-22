package com.vivo.push.restructure.a.a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.vivo.push.PushClient;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f462455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f462456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ e f462457c;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_restructure_a_a_f_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_restructure_a_a_f__run$___twin___() {
        int r100 = this.f462455a;
        if (r100 != 3) goto L7;
        PushClient.getInstance(com.vivo.push.restructure.a.a().b()).unBindAlias(this.f462456b, null);
        return;
    L7:
        if (r100 != 4) goto L10;
        PushClient.getInstance(com.vivo.push.restructure.a.a().b()).delTopic(this.f462456b, null);
        return;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_restructure_a_a_f_com_larus_apm_impl_protector_RunnableLancet_run(f r100) {
        r100.com_vivo_push_restructure_a_a_f__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(e r100, int r101, String r102) {
        this.f462457c = r100;
        this.f462455a = r101;
        this.f462456b = r102;
    }
}

package com.xiaomi.push;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class bi extends ad.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f463193a;

    @Override // com.xiaomi.push.ad.a
    /* JADX INFO: renamed from: a */
    public String mo8851a() {
        return "100887";
    }

    @Override // java.lang.Runnable
    public void run() {
        com_xiaomi_push_bi_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f463193a).m8727a().isPerfUploadSwitchOpen();
    }

    public void com_xiaomi_push_bi__run$___twin___() {
    L6:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("fail to send perf data. " + e);
        return;
    L3:
        if (a() == false) goto L11;
        com.xiaomi.clientreport.manager.a.a(this.f463193a).c();     // Catch: Exception -> L6
        com.xiaomi.channel.commonutils.logger.b.c(this.f463193a.getPackageName() + " perf begin upload");     // Catch: Exception -> L6
        return;
    }

    public bi(Context r100) {
        this.f463193a = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_xiaomi_push_bi_com_larus_apm_impl_protector_RunnableLancet_run(bi r100) {
        r100.com_xiaomi_push_bi__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

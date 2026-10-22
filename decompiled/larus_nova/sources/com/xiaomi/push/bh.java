package com.xiaomi.push;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class bh extends ad.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f463192a;

    @Override // com.xiaomi.push.ad.a
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo8851a() {
        return "100886";
    }

    @Override // java.lang.Runnable
    public void run() {
        com_xiaomi_push_bh_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f463192a).m8727a().isEventUploadSwitchOpen();
    }

    public void com_xiaomi_push_bh__run$___twin___() {
    L6:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        return;
    L3:
        if (a() == false) goto L11;
        com.xiaomi.channel.commonutils.logger.b.c(this.f463192a.getPackageName() + " begin upload event");     // Catch: Exception -> L6
        com.xiaomi.clientreport.manager.a.a(this.f463192a).m8729b();     // Catch: Exception -> L6
        return;
    }

    public bh(Context r100) {
        this.f463192a = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_xiaomi_push_bh_com_larus_apm_impl_protector_RunnableLancet_run(bh r100) {
        r100.com_xiaomi_push_bh__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

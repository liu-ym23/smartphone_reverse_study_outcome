package com.xiaomi.push;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class bj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f463194a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.xiaomi.clientreport.processor.c f268a;

    public bj() {
    }

    @Override // java.lang.Runnable
    public void run() {
        com_xiaomi_push_bj_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_xiaomi_push_bj__run$___twin___() {
        com.xiaomi.clientreport.processor.c r100 = this.f268a;     // Catch: Exception -> L13
        if (r100 == null) goto L5;
        r100.a();     // Catch: Exception -> L13
    L5:
        com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");     // Catch: Exception -> L13
        com.xiaomi.clientreport.processor.c r101 = this.f268a;     // Catch: Exception -> L13
        if ((r101 instanceof IEventProcessor) == false) goto L10;
        bl.a(this.f463194a).m8855a("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());     // Catch: Exception -> L13
        return;
    L10:
        if ((r101 instanceof IPerfProcessor) == false) goto L18;
        bl.a(this.f463194a).m8855a("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());     // Catch: Exception -> L13
        return;
    L18:
        return;
    L13:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_xiaomi_push_bj_com_larus_apm_impl_protector_RunnableLancet_run(bj r100) {
        r100.com_xiaomi_push_bj__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public void a(Context r100) {
        this.f463194a = r100;
    }

    public void a(com.xiaomi.clientreport.processor.c r100) {
        this.f268a = r100;
    }
}

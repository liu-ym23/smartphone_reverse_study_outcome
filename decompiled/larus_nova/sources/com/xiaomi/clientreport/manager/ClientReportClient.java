package com.xiaomi.clientreport.manager;

import android.content.Context;
import android.os.Process;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.clientreport.processor.b;
import com.xiaomi.push.g;

/* JADX INFO: loaded from: classes41.dex */
public class ClientReportClient {
    public ClientReportClient() {
    }

    public static void init(Context r100) {
        init(r100, Config.defaultConfig(r100), new com.xiaomi.clientreport.processor.a(r100), new b(r100));
    }

    public static void init(Context r100, Config r101) {
        init(r100, r101, new com.xiaomi.clientreport.processor.a(r100), new b(r100));
    }

    public static void reportEvent(Context r100, EventClientReport r101) {
        if (r101 == null) goto L5;
        a.a(r100).a(r101);
        return;
    }

    public static void reportPerf(Context r100, PerfClientReport r101) {
        if (r101 == null) goto L5;
        a.a(r100).a(r101);
        return;
    }

    public static void updateConfig(Context r100, Config r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        a.a(r100).a(r101.isEventUploadSwitchOpen(), r101.isPerfUploadSwitchOpen(), r101.getEventUploadFrequency(), r101.getPerfUploadFrequency());
    }

    public static void init(Context r100, Config r101, IEventProcessor r102, IPerfProcessor r103) {
        com.xiaomi.channel.commonutils.logger.b.c("init in  pid :" + Process.myPid() + " threadId: " + ThreadMethodProxy.currentThread().getId());
        a.a(r100).a(r101, r102, r103);
        if (g.m9122a(r100) == false) goto L6;
        com.xiaomi.channel.commonutils.logger.b.c("init in process\u3000start scheduleJob");
        a.a(r100).m8728a();
        return;
    }
}

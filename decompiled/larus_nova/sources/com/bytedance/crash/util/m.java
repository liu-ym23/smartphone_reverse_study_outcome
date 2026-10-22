package com.bytedance.crash.util;

import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IApmAgent;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class m implements Runnable {
    public static void a() {
        File[] r100 = com.bytedance.crash.i.d().listFiles();     // Catch: Throwable -> L15
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L15
        if (r100 != null) goto L5;
    L9:
        o r102 = o.f203416a;     // Catch: Throwable -> L15
        IApmAgent r103 = (IApmAgent) ServiceManager.getService(IApmAgent.class);
        if (r103 == null) goto L19;
        r103.monitorEvent("npth_disk_event", r101, null, null);
        return;
    L19:
        return;
    L5:
        if (r100.length <= 0) goto L9;
        int r104 = r100.length;     // Catch: Throwable -> L15
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L9;
        File r106 = r100[r105];     // Catch: Throwable -> L15
        r101.put(r106.getName(), o.a(r106));     // Catch: Throwable -> L15
        r105 = r105 + 1;     // Catch: Throwable -> L15
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public m() {
    }
}

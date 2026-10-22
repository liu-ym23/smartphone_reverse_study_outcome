package com.bytedance.ee.bear.bitable.homepage.chart;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f212626a = null;

    static {
        f212626a = new q();
    }

    public q() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L4
        r100.put("stage", "start");     // Catch: Throwable -> L4
        n.a().i("base_mobile_performance_dashboard_list", r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

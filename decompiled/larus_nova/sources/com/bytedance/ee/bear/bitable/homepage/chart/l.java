package com.bytedance.ee.bear.bitable.homepage.chart;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f212597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f212598b;

    public l(String r100, long r101) {
        this.f212597a = r100;
        this.f212598b = r101;
    }

    public final void a() {
        JSONObject r100 = new JSONObject();
        r100.put("stage", "end");
        r100.put("result", this.f212597a);
        r100.put(HiAnalyticsConstant.BI_KEY_COST_TIME, this.f212598b);
        n.a().i("base_mobile_performance_dashboard_skeleton_list", r100);
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
}

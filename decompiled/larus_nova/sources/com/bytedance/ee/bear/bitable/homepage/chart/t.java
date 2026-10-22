package com.bytedance.ee.bear.bitable.homepage.chart;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f212631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f212632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f212633c;

    public t(String r100, String r101, long r102) {
        this.f212631a = r100;
        this.f212632b = r101;
        this.f212633c = r102;
    }

    public final void a() {
        JSONObject r100 = new JSONObject();
        r100.put("stage", "end");
        r100.put("scene", this.f212631a);
        r100.put("result", this.f212632b);
        r100.put(HiAnalyticsConstant.BI_KEY_COST_TIME, this.f212633c);
        n.a().i("base_mobile_performance_dashboard_setup_charts", r100);
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

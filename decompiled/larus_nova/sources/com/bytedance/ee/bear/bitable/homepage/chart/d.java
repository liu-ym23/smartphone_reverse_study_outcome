package com.bytedance.ee.bear.bitable.homepage.chart;

import com.bytedance.ee.bear.bitable.homepage.chart.entity.ChartEntity;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChartEntity f212447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f212448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f212449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f212450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f212451e;

    public d(ChartEntity r100, String r101, String r102, Map<String, ? extends Object> r103, long r104) {
        this.f212447a = r100;
        this.f212448b = r101;
        this.f212449c = r102;
        this.f212450d = r103;
        this.f212451e = r104;
    }

    public final void a() {
        if (km4.a.f504063a == true) goto L11;
        tt5.a.d("ChartBizReporter", "reportHomepageChartFullscreenDuration: skip for sdk not init");
        return;
    L11:
        int r100 = c.f212424a;     // Catch: Exception -> L8
        JSONObject r101 = c.b(this.f212447a, this.f212448b, this.f212449c, this.f212450d);     // Catch: Exception -> L8
        r101.put("duration", this.f212451e);     // Catch: Exception -> L8
        r101.put("is_mobile_homepage", "true");     // Catch: Exception -> L8
        c.a().i("ccm_bitable_dashboard_duration_view", r101);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        tt5.a.e("ChartBizReporter", "reportHomepageChartFullscreenDuration failed", e, false);
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

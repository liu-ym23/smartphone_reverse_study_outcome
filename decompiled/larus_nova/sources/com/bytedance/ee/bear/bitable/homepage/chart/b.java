package com.bytedance.ee.bear.bitable.homepage.chart;

import com.bytedance.ee.bear.bitable.homepage.chart.entity.ChartEntity;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChartEntity f212419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f212420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f212421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f212422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f212423e;

    public b(ChartEntity r100, String r101, String r102, Map<String, ? extends Object> r103, String r104) {
        this.f212419a = r100;
        this.f212420b = r101;
        this.f212421c = r102;
        this.f212422d = r103;
        this.f212423e = r104;
    }

    public final void a() {
        ChartEntity r100 = this.f212419a;
        if (r100 == null) goto L5;
        int r101 = c.f212424a;
        JSONObject r102 = c.b(r100, this.f212420b, this.f212421c, this.f212422d);
    L6:
        r102.put("click", this.f212423e);
        c.a().i("ccm_bitable_homepage_dashboard_component_setting_click", r102);
        return;
    L5:
        r102 = new JSONObject();
        int r103 = c.f212424a;
        c.c(new v(r102, null, sbb.e.f541298i.f541317b, this.f212420b, this.f212421c));
        goto L6
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

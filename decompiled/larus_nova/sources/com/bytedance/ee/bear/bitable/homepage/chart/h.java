package com.bytedance.ee.bear.bitable.homepage.chart;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f212484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f212485b;

    public h(String r100, String r101) {
        this.f212484a = r100;
        this.f212485b = r101;
    }

    public final void a() {
        JSONObject r100 = new JSONObject();
        int r101 = c.f212424a;
        c.c(new v(r100, null, sbb.e.f541298i.f541317b, this.f212484a, this.f212485b));
        c.a().i("ccm_bitable_homepage_dashboard_component_setting_view", r100);
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

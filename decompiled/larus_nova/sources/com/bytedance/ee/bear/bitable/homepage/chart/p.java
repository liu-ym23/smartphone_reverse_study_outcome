package com.bytedance.ee.bear.bitable.homepage.chart;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.MobConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f212606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f212607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f212608c;

    public p(String r100, long r101, boolean r102) {
        this.f212606a = r100;
        this.f212607b = r101;
        this.f212608c = r102;
    }

    public final void a() {
        JSONObject r100 = new JSONObject();
        r100.put("stage", "end");
        r100.put("result", this.f212606a);
        r100.put(HiAnalyticsConstant.BI_KEY_COST_TIME, this.f212607b);
        r100.put(MobConstants.FORM_CACHE, this.f212608c);
        n.a().i("base_mobile_performance_dashboard_list", r100);
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

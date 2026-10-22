package com.bytedance.ee.bear.bitable.homepage.chart;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f212600a = 0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f212601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f212602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f212603c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f212604d;

        public a(String r100, String r101, long r102, int r103) {
            this.f212601a = r100;
            this.f212602b = r101;
            this.f212603c = r102;
            this.f212604d = r103;
        }

        public final void a() {
            JSONObject r100 = new JSONObject();
            r100.put("stage", "end");
            r100.put("scene", this.f212601a);
            r100.put("result", this.f212602b);
            r100.put(HiAnalyticsConstant.BI_KEY_COST_TIME, this.f212603c);
            r100.put("fail_count", this.f212604d);
            n.a().i("base_mobile_performance_dashboard_chart_data", r100);
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

    static {
    }

    public n() {
    }

    public static final com.bytedance.ee.bear.contract.d a() {
        return (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
    }

    public static void c(String r100, long r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "result");
        CoreThreadPool.getBackgroundHandler().post(new p(r100, r101, r102));
    }

    public static void d(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "result");
        CoreThreadPool.getBackgroundHandler().post(new r(r100, r101, r102));
    }

    public static void e(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "result");
        CoreThreadPool.getBackgroundHandler().post(new t(r100, r101, r102));
    }

    public static boolean b(String r100, String r101, long r110, int r111) {
        Intrinsics.checkNotNullParameter(r101, "result");
        return CoreThreadPool.getBackgroundHandler().post(new a(r100, r101, r110, r111));
    }
}

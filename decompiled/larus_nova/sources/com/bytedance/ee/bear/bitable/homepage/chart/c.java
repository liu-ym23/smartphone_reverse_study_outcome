package com.bytedance.ee.bear.bitable.homepage.chart;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.ee.bear.bitable.homepage.chart.entity.ChartEntity;
import com.bytedance.ee.bear.bitable.homepage.chart.entity.HomeChartEntity;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f212424a = 0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChartEntity f212425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f212426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f212427c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f212428d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f212429e;

        public a(ChartEntity r100, String r101, String r102, Map<String, ? extends Object> r103, String r104) {
            this.f212425a = r100;
            this.f212426b = r101;
            this.f212427c = r102;
            this.f212428d = r103;
            this.f212429e = r104;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = c.f212424a;     // Catch: Throwable -> L4
            JSONObject r101 = c.b(this.f212425a, this.f212426b, this.f212427c, this.f212428d);     // Catch: Throwable -> L4
            r101.put("click", this.f212429e);     // Catch: Throwable -> L4
            c.a().i("ccm_bitable_homepage_dashboard_component_full_screen_click", r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f212430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f212431b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f212432c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f212433d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f212434e;

        public b(String r100, String r101, String r102, String r103, Map<String, ? extends Object> r104) {
            this.f212430a = r100;
            this.f212431b = r101;
            this.f212432c = r102;
            this.f212433d = r103;
            this.f212434e = r104;
        }

        public final void a() {
            JSONObject r100 = new JSONObject();
            int r101 = c.f212424a;
            c.c(new v(r100, this.f212430a, sbb.e.f541298i.f541317b, this.f212431b, this.f212432c));
            r100.put("click", this.f212433d);
            Map<String, Object> r102 = this.f212434e;
            if (r102 == null) goto L8;
            Iterator<Map.Entry<String, Object>> r103 = r102.entrySet().iterator();
        L6:
            if (r103.hasNext() == false) goto L8;
            Map.Entry<String, Object> r104 = r103.next();
            r100.put(r104.getKey(), r104.getValue());
        L8:
            c.a().i("ccm_bitable_homepage_dashboard_component_add_click", r100);
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

    public c() {
    }

    public static final com.bytedance.ee.bear.contract.d a() {
        return (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
    }

    public static void c(v r100) {
        JSONObject r101 = r100.f212639a;
        String r102 = r100.f212641c;
        r101.put(EventConstant.Key.MODULE, r100.f212640b);
        if (TextUtils.isEmpty(r102) == false) goto L5;
        r102 = "null";
    L5:
        r101.put("sub_module", r102);
        if (TextUtils.isEmpty(r100.f212642d) == true) goto L8;
        r101.put("file_id", du5.b.g(r100.f212642d));
    L9:
        int r103 = r100.f212643e;
        if (r103 == sbb.e.f541294e.f541317b) goto L12;
        r101.put("file_type", sbb.e.c(r103));
    L14:
        if (TextUtils.isEmpty(r100.f212644f) == false) goto L16;
        String r104 = "null";
    L17:
        r101.put("sub_file_type", r104);
        if (TextUtils.isEmpty(r100.f212645g) == true) goto L20;
        r101.put("container_id", du5.b.g(r100.f212645g));
    L22:
        if (TextUtils.isEmpty(r100.f212646h) == true) goto L24;
        r101.put(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, r100.f212646h);
    L26:
        if (TextUtils.isEmpty(r100.f212647i) == true) goto L28;
        r101.put("shortcut_id", du5.b.g(r100.f212647i));
        r101.put("is_shortcut", "true");
    L30:
        if (qc5.a.h() == false) goto L32;
        String r105 = "new_format";
    L33:
        r101.put("space_version", r105);
        r101.put("app_form", "null");
        String r106 = r100.f212648j;
        if (r106 == null) goto L36;
        r101.put("container_env", r106);
    L36:
        String r107 = r100.f212649k;
        if (r107 == null) goto L40;
        r101.put("base_hp_from", r107);
        return;
    L40:
        return;
    L32:
        r105 = "original";
        goto L33
    L28:
        r101.put("shortcut_id", "null");
        r101.put("is_shortcut", "false");
        goto L30
    L24:
        r101.put(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, "null");
        goto L26
    L20:
        r101.put("container_id", "null");
        goto L22
    L16:
        r104 = r100.f212644f;
        goto L17
    L12:
        r101.put("file_type", "null");
        goto L14
    L8:
        r101.put("file_id", "null");
        goto L9
    }

    public static final JSONObject b(ChartEntity r100, String r101, String r110, Map r111) {
        JSONObject r102 = new JSONObject();
        c(new v(r102, r100.getBaseToken(), sbb.e.f541298i.f541317b, r101, r110));
        r102.put("chart_id", du5.b.g(r100.getChartToken()));
        r102.put("block_token", du5.b.g(r100.getDashboardToken()));
        r102.put("is_template", r100.isTemplate());
        if (r111 == null) goto L8;
        Iterator r103 = r111.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.put((String) r104.getKey(), r104.getValue());
    L8:
        return r102;
    }

    public static void d(String r100, HomeChartEntity r101, String r102, String r103, int r110) {
        if ((r110 & 2) == 0) goto L5;
        r101 = null;
    L5:
        HomeChartEntity r104 = r101;
        Intrinsics.checkNotNullParameter(r100, "click");
        CoreThreadPool.getBackgroundHandler().post(new com.bytedance.ee.bear.bitable.homepage.chart.b(r104, r102, r103, null, r100));
    }

    public static boolean e(ChartEntity r100, String r101, String r110, String r111, Map r112) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        Intrinsics.checkNotNullParameter(r101, "click");
        return CoreThreadPool.getBackgroundHandler().post(new a(r100, r110, r111, r112, r101));
    }

    public static boolean f(String r100, String r101, String r110, String r111, Map r112) {
        Intrinsics.checkNotNullParameter(r100, "bitableToken");
        Intrinsics.checkNotNullParameter(r101, "clickType");
        return CoreThreadPool.getBackgroundHandler().post(new b(r100, r110, r111, r101, r112));
    }
}

package com.bytedance.ee.bear.document.render.node.perf;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import otb.n;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f221379h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.document.render.node.f f221380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f221381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f221382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Long> f221383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f221384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f221385f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f221386g;

    public static final class a {
        public a() {
        }

        public static void a(Long r100) {
            int r101 = e.f221379h;
            if (r100 != null) goto L5;
            tt5.a.k("StageReport", "startTime is null");
            return;
        L5:
            JSONObject r102 = new JSONObject();
            r102.put("stage", "before_container_create");
            r102.put(HiAnalyticsConstant.BI_KEY_COST_TIME, System.currentTimeMillis() - r100.longValue());
            r102.put("cost_time_start_click", System.currentTimeMillis() - r100.longValue());
            tt5.a.h("StageReport", "***reportOpenDoc*** stage: " + r102.get("stage") + "  cost: " + r102.get(HiAnalyticsConstant.BI_KEY_COST_TIME));
            com.bytedance.ee.bear.contract.d r103 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
            int r104 = a05.c.C0000c.f1308a;
            r103.a("dev_performance_stage", r102);
        }
    }

    static {
        new a();
    }

    public final long a(long r100) {
        String r101 = this.f221381b.e("start_open", "click_timestamp");
        if (r101 == null) goto L5;
        Long r102 = StringsKt.toLongOrNull(r101);
    L6:
        if (r102 != null) goto L8;
        return -1;
    L8:
        if (r102.longValue() > 0) goto L10;
        return -1;
    L10:
        return r100 - r102.longValue();
    L5:
        r102 = null;
        goto L6
    }

    public e(com.bytedance.ee.bear.document.render.node.f r100, com.bytedance.ee.bear.contract.d r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "mAnalytics");
        Intrinsics.checkNotNullParameter(r102, "versionType");
        this.f221380a = r100;
        this.f221381b = r101;
        this.f221382c = r102;
        this.f221383d = new LinkedHashMap();
        Lazy<n> r103 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(null);
        this.f221384e = false;
        this.f221385f = ((Boolean) new ml5.b("debug_config").a("show_cache_toast", Boolean.FALSE)).booleanValue();
        this.f221386g = "";
    }
}

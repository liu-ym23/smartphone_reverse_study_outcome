package com.bytedance.ee.bear.document.render.node.perf;

import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public static final /* synthetic */ int h = 0;
    public final com.bytedance.ee.bear.document.render.node.f a;
    public final com.bytedance.ee.bear.contract.d b;
    public final String c;
    public final Map<String, Long> d;
    public final boolean e;
    public final boolean f;
    public String g;

    public static final class a {
        public a() {
        }

        public static void a(Long r8) {
            int r0 = e.h;
            if (r8 != null) goto L5;
            tt5.a.k("StageReport", "startTime is null");
            return;
        L5:
            JSONObject r1 = new JSONObject();
            r1.put("stage", "before_container_create");
            r1.put("cost_time", System.currentTimeMillis() - r8.longValue());
            r1.put("cost_time_start_click", System.currentTimeMillis() - r8.longValue());
            tt5.a.h("StageReport", "***reportOpenDoc*** stage: " + r1.get("stage") + "  cost: " + r1.get("cost_time"));
            com.bytedance.ee.bear.contract.d r9 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
            int r2 = a05.c.C0000c.a;
            r9.a("dev_performance_stage", r1);
        }
    }

    static {
        new a();
    }

    public final long a(long r7) {
        String r0 = this.b.e("start_open", "click_timestamp");
        if (r0 == null) goto L5;
        Long r1 = StringsKt.toLongOrNull(r0);
    L6:
        if (r1 != null) goto L8;
        return -1;
    L8:
        if (r1.longValue() > 0) goto L10;
        return -1;
    L10:
        return r7 - r1.longValue();
    L5:
        r1 = null;
        goto L6
    }

    public e(com.bytedance.ee.bear.document.render.node.f r2, com.bytedance.ee.bear.contract.d r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "mAnalytics");
        Intrinsics.checkNotNullParameter(r4, "versionType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new LinkedHashMap();
        Lazy r5 = TTWebViewUtil.a;
        TTWebViewUtil.a.d(null);
        this.e = false;
        this.f = ((Boolean) new ml5.b("debug_config").a("show_cache_toast", Boolean.FALSE)).booleanValue();
        this.g = "";
    }
}

package com.bytedance.ee.bear.templates;

import com.alibaba.fastjson.JSONObject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TemplateReport {
    public static String a;
    public static final Lazy b = null;

    static {
        a = "";
        b = LazyKt.lazy(TemplateReport$myAnalyticService$2.INSTANCE);
    }

    public static com.bytedance.ee.bear.contract.d a() {
        return (com.bytedance.ee.bear.contract.d) b.getValue();
    }

    public static void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        JSONObject r1 = new JSONObject();
        r1.put("action", r2);
        r1.put("template_type", "ugc");
        a().v("management_template_by_user", r1);
    }

    public static void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
        a = r2;
        JSONObject r0 = new JSONObject();
        r0.put("source", r2);
        a().v("enter_template_center", r0);
    }

    public static void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        JSONObject r1 = new JSONObject();
        r1.put("action", r2);
        if (r3 == null) goto L5;
        r1.put("click_searchrecommendwords_name", r3);
    L5:
        a().v("template_search", r1);
    }
}

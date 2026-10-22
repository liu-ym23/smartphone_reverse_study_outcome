package com.bytedance.ee.bear.templates;

import com.alibaba.fastjson.JSONObject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class TemplateReport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f238766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f238767b = null;

    static {
        f238766a = "";
        f238767b = LazyKt.lazy(TemplateReport$myAnalyticService$2.INSTANCE);
    }

    public static com.bytedance.ee.bear.contract.d a() {
        return (com.bytedance.ee.bear.contract.d) f238767b.getValue();
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = new JSONObject();
        r101.put("action", r100);
        r101.put("template_type", "ugc");
        a().v("management_template_by_user", r101);
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        f238766a = r100;
        JSONObject r101 = new JSONObject();
        r101.put("source", r100);
        a().v("enter_template_center", r101);
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r102 = new JSONObject();
        r102.put("action", r100);
        if (r101 == null) goto L5;
        r102.put2("click_searchrecommendwords_name", r101);
    L5:
        a().v("template_search", r102);
    }
}

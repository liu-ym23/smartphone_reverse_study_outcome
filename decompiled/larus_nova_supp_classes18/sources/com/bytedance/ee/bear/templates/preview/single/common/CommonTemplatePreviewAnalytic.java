package com.bytedance.ee.bear.templates.preview.single.common;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.sheet.exportimage.exportshare.ExportShareModel;
import com.bytedance.ee.bear.templates.preview.data.CommonPreviewTemplateData;
import com.bytedance.ee.bear.templates.preview.data.Item;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommonTemplatePreviewAnalytic {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(CommonTemplatePreviewAnalytic$analyticService$2.INSTANCE);
    }

    public static com.bytedance.ee.bear.contract.d b() {
        return (com.bytedance.ee.bear.contract.d) a.getValue();
    }

    public static String c(Item r1) {
        if (r1.isBusinessTemplate() == false) goto L6;
        return "egc";
    L6:
        if (r1.isCustomTemplate() == false) goto L8;
        return "ugc";
    L8:
        return "pgc";
    }

    public static void d(CommonPreviewTemplateData r3) {
        JSONObject r0 = new JSONObject();
        r0.put("click_type", "back");
        r0.put("target", "ccm_template_preview_view");
        if (r3 == null) goto L5;
        r0.put("template_source", r3.getTemplateSource());
    L5:
        b().n("ccm_template_preview_view_click", r0);
    }

    public static void f(Item r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        JSONObject r0 = new JSONObject();
        r0.put("click_type", "delete_button");
        r0.put("template_token", r3.getReportToken());
        r0.put("target", "ccm_template_preview_view");
        b().o("ccm_template_preview_view_click", r0, r3.checkToken());
    }

    public static JSONObject a(Item r3, CommonPreviewTemplateData r4) {
        JSONObject r0 = new JSONObject();
        r0.put("template_token", r3.getReportToken());
        r0.put("template_name", r3.getReportName());
        r0.put("use_source", ExportShareModel.EXPORT_SHARE_TYPE_IMAGE);
        if (r4 == null) goto L5;
        r0.put("template_source", r4.getTemplateSource());
        r0.put("templatecenter_source", r4.getTemplateCenterSource());
        r0.put("template_sort", r4.getTemplateSort());
        r0.put("keywords", r4.getKeywords());
    L5:
        r0.put("create_file_type", sbb.e.c(r3.getObjType()));
        r0.put("template_type", c(r3));
        r0.put("target", "ccm_docs_page_view");
        return r0;
    }

    public static void g(Item r3, CommonPreviewTemplateData r4) {
        Intrinsics.checkNotNullParameter(r3, "item");
        JSONObject r0 = new JSONObject();
        r0.put("click_type", "share_button");
        r0.put("is_customized", "false");
        r0.put("template_token", r3.getReportToken());
        r0.put("template_name", r3.getReportName());
        r0.put("template_type", c(r3));
        r0.put("target", "ccm_permission_share_view");
        if (r4 == null) goto L5;
        r0.put("template_source", r4.getTemplateSource());
        r0.put("templatecenter_source", r4.getTemplateCenterSource());
    L5:
        b().o("ccm_template_preview_view_click", r0, r3.checkToken());
    }

    public static void h(CommonPreviewTemplateData r3, Item r4) {
        JSONObject r0 = new JSONObject();
        if (r3 == null) goto L5;
        r0.put("template_source", r3.getTemplateSource());
        r0.put("templatecenter_source", r3.getTemplateCenterSource());
        r0.put("keywords", r3.getKeywords());
    L5:
        r0.put("template_type", c(r4));
        r0.put("template_token", r4.getReportToken());
        r0.put("template_name", r4.getReportName());
        b().o("ccm_template_preview_view", r0, r4.checkToken());
    }

    public static void e(Item r2, String r3, CommonPreviewTemplateData r4) {
        Intrinsics.checkNotNullParameter(r2, "item");
        JSONObject r5 = a(r2, r4);
        r5.put("click_type", "create_template_objs");
        r5.put("file_id", du5.b.g(r3));
        b().o("ccm_template_preview_view_click", r5, r2.checkToken());
    }
}

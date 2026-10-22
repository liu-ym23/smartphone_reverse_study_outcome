package com.bytedance.ee.bear.templates.preview.single.common;

import com.alibaba.fastjson.JSONObject;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.templates.preview.data.CommonPreviewTemplateData;
import com.bytedance.ee.bear.templates.preview.data.Item;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class CommonTemplatePreviewAnalytic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f239205a = null;

    static {
        f239205a = LazyKt.lazy(CommonTemplatePreviewAnalytic$analyticService$2.INSTANCE);
    }

    public static com.bytedance.ee.bear.contract.d b() {
        return (com.bytedance.ee.bear.contract.d) f239205a.getValue();
    }

    public static String c(Item r100) {
        if (r100.isBusinessTemplate() == false) goto L6;
        return "egc";
    L6:
        if (r100.isCustomTemplate() == false) goto L8;
        return "ugc";
    L8:
        return "pgc";
    }

    public static void d(CommonPreviewTemplateData r100) {
        JSONObject r101 = new JSONObject();
        r101.put2("click_type", "back");
        r101.put2(PickerReporterConstants.KEY.TARGET, "ccm_template_preview_view");
        if (r100 == null) goto L5;
        r101.put2("template_source", r100.getTemplateSource());
    L5:
        b().n("ccm_template_preview_view_click", r101);
    }

    public static void f(Item r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        JSONObject r101 = new JSONObject();
        r101.put2("click_type", "delete_button");
        r101.put2("template_token", r100.getReportToken());
        r101.put2(PickerReporterConstants.KEY.TARGET, "ccm_template_preview_view");
        b().o("ccm_template_preview_view_click", r101, r100.checkToken());
    }

    public static JSONObject a(Item r100, CommonPreviewTemplateData r101) {
        JSONObject r102 = new JSONObject();
        r102.put2("template_token", r100.getReportToken());
        r102.put2("template_name", r100.getReportName());
        r102.put2("use_source", "image");
        if (r101 == null) goto L5;
        r102.put2("template_source", r101.getTemplateSource());
        r102.put2("templatecenter_source", r101.getTemplateCenterSource());
        r102.put2("template_sort", r101.getTemplateSort());
        r102.put2("keywords", r101.getKeywords());
    L5:
        r102.put2("create_file_type", sbb.e.c(r100.getObjType()));
        r102.put2("template_type", c(r100));
        r102.put2(PickerReporterConstants.KEY.TARGET, "ccm_docs_page_view");
        return r102;
    }

    public static void g(Item r100, CommonPreviewTemplateData r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        JSONObject r102 = new JSONObject();
        r102.put2("click_type", "share_button");
        r102.put2("is_customized", "false");
        r102.put2("template_token", r100.getReportToken());
        r102.put2("template_name", r100.getReportName());
        r102.put2("template_type", c(r100));
        r102.put2(PickerReporterConstants.KEY.TARGET, "ccm_permission_share_view");
        if (r101 == null) goto L5;
        r102.put2("template_source", r101.getTemplateSource());
        r102.put2("templatecenter_source", r101.getTemplateCenterSource());
    L5:
        b().o("ccm_template_preview_view_click", r102, r100.checkToken());
    }

    public static void h(CommonPreviewTemplateData r100, Item r101) {
        JSONObject r102 = new JSONObject();
        if (r100 == null) goto L5;
        r102.put2("template_source", r100.getTemplateSource());
        r102.put2("templatecenter_source", r100.getTemplateCenterSource());
        r102.put2("keywords", r100.getKeywords());
    L5:
        r102.put2("template_type", c(r101));
        r102.put2("template_token", r101.getReportToken());
        r102.put2("template_name", r101.getReportName());
        b().o("ccm_template_preview_view", r102, r101.checkToken());
    }

    public static void e(Item r100, String r101, CommonPreviewTemplateData r102) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        JSONObject r103 = a(r100, r102);
        r103.put2("click_type", "create_template_objs");
        r103.put2("file_id", du5.b.g(r101));
        b().o("ccm_template_preview_view_click", r103, r100.checkToken());
    }
}

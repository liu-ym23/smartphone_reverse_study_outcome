package com.bytedance.ee.bear.templates;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.sheet.exportimage.exportshare.ExportShareModel;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TemplateReportV2 {
    public static final TemplateReportV2 a = null;
    public static String b;
    public static String c;
    public static String d;
    public static boolean e;
    public static String f;
    public static final Lazy g = null;

    public TemplateReportV2() {
    }

    static {
        a = new TemplateReportV2();
        b = "ccm_template_systemcenter_view_click";
        c = "";
        d = "";
        f = eu5.b.a.getString(2131887879);
        g = LazyKt.lazy(TemplateReportV2$analyticService$2.INSTANCE);
    }

    public static com.bytedance.ee.bear.contract.d a() {
        return (com.bytedance.ee.bear.contract.d) g.getValue();
    }

    public static String b(TemplateV4 r1) {
        Intrinsics.checkNotNullParameter(r1, ThumbGlideUrl.SOURCE_TEMPLATE);
        if (r1.isBusinessTemplate() == false) goto L6;
        return "egc";
    L6:
        if (r1.isCustomTemplate() == false) goto L8;
        return "ugc";
    L8:
        return "pgc";
    }

    public static String c(sbb.e r2) {
        if (Intrinsics.areEqual(r2, sbb.e.g) == false) goto L5;
    L17:
        return "docs";
    L5:
        if (Intrinsics.areEqual(r2, sbb.e.o) == true) goto L17;
        sbb.e r0 = sbb.e.h;
        if (Intrinsics.areEqual(r2, r0) == true) goto L19;
        sbb.e r1 = sbb.e.i;
        if (Intrinsics.areEqual(r2, r1) == true) goto L20;
        sbb.e r3 = sbb.e.k;
        if (Intrinsics.areEqual(r2, r3) == true) goto L21;
        return "all";
    L21:
        return r3.getType();
    L20:
        return r1.getType();
    L19:
        return r0.getType();
    }

    public static void h(b r5) {
        Intrinsics.checkNotNullParameter(r5, "reportParams");
        JSONObject r0 = new JSONObject();
        r0.put("click_type", r5.a);
        String r1 = r5.f;
        boolean r2 = true;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        r0.put("folder_token", r5.f);
    L11:
        String r4 = r5.g;
        if (r4 != null) goto L14;
    L17:
        if (r2 == true) goto L19;
        r0.put("file_id", r5.g);
    L19:
        r0.put("is_customized", Boolean.valueOf(Intrinsics.areEqual("4", r5.i)));
        r0.put("sub_template_type", sbb.e.c(r5.h));
        r0.put("template_token", r5.b);
        r0.put("template_name", r5.c);
        r0.put("set_name", r5.c);
        r0.put("set_id", r5.d);
        r0.put("template_source", c);
        r0.put("templatecenter_source", r5.e);
        a().o("ccm_set_template_preview_click", r0, false);
        return;
    L14:
        if (StringsKt.isBlank(r4) == true) goto L17;
        r2 = false;
        goto L17
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r3 = false;
        goto L9
    }

    public static void d(TemplateV4 r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, ThumbGlideUrl.SOURCE_TEMPLATE);
        JSONObject r0 = new JSONObject();
        r0.put("click_type", "create_blank_objs");
        r0.put("template_source", c);
        r0.put("create_file_type", sbb.e.c(r3.getObjType()));
        r0.put("target", "ccm_docs_page_view");
        if (TextUtils.isEmpty(r4) == true) goto L5;
        r0.put("file_id", du5.b.g(r4));
    L5:
        a().n(b, r0);
    }

    public static void e(String r3, sbb.e r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "currentFilterDocumentType");
        JSONObject r0 = new JSONObject();
        r0.put("click_type", "sort_click");
        r0.put("sort_name", r3);
        r0.put("filter_status", c(r4));
        r0.put("target", "ccm_template_systemcenter_view");
        a().n(b, r0);
    }

    public static void g(String r2, TemplateV4 r3) {
        Intrinsics.checkNotNullParameter(r2, "click");
        JSONObject r0 = new JSONObject();
        r0.put("click_type", r2);
        if (r3 == null) goto L5;
        String r4 = r3.getObjToken();
    L6:
        r0.put("template_token", r4);
        if (r3 == null) goto L10;
        String r5 = r3.getName();
        if (r5 == null) goto L10;
    L11:
        r0.put("template_name", r5);
        r0.put("template_source", c);
        r0.put("template_type", "pgc");
        a().o("ccm_vc_template_bottom_click", r0, false);
        return;
    L10:
        r5 = "";
        goto L11
    L5:
        r4 = null;
        goto L6
    }

    public static void j(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "clickType");
        Intrinsics.checkNotNullParameter(r4, "target");
        JSONObject r1 = new JSONObject();
        r1.put("click_type", r3);
        r1.put("template_source", c);
        r1.put("target", r4);
        a().n(b, r1);
    }

    public static void k(TemplateV4 r4, e r5) {
        Intrinsics.checkNotNullParameter(r4, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r5, "reportParams");
        JSONObject r0 = new JSONObject();
        r0.put("click_type", r5.getType());
        r0.put("template_token", r4.getReportToken());
        r0.put("template_name", r4.getReportName());
        r0.put("template_sort", f);
        Integer r1 = r5.c;
        if (r1 == null) goto L5;
        int r2 = r1.intValue() + 1;
    L6:
        r0.put("position_index", Integer.valueOf(r2));
        String r3 = r5.d;
        if (r3 == null) goto L9;
        r0.put("sub_template_sort", r3);
    L9:
        r0.put("is_customized", Boolean.valueOf(r4.isCustomized()));
        sbb.e r6 = r5.e;
        if (r6 == null) goto L12;
        r0.put("filter_status", c(r6));
    L12:
        r0.put("template_sort", f);
        r0.put("use_source", ExportShareModel.EXPORT_SHARE_TYPE_IMAGE);
        if (r4.isSceneTemplate() == false) goto L15;
        r0.put("is_set", Boolean.TRUE);
        r0.put("set_id", r4.getCollectionId());
        r0.put("set_name", r4.getReportName());
    L16:
        r0.put("template_source", c);
        r0.put("create_file_type", sbb.e.c(r4.getObjType()));
        r0.put("target", "ccm_template_preview_view");
        r0.put("template_type", b(r4));
        if (Intrinsics.areEqual(b, "ccm_template_search_result_view_click") == true) goto L19;
    L23:
        a().o(b, r0, r4.checkToken());
        return;
    L19:
        if (e == false) goto L21;
        String r7 = r5.b;
    L22:
        r0.put("keywords", r7);
        goto L23
    L21:
        r7 = "input";
        goto L22
    L15:
        r0.put("is_set", Boolean.FALSE);
        goto L16
    L5:
        r2 = 0;
        goto L6
    }

    public static void f(sbb.e r7, boolean r8, String r9) {
        if (Intrinsics.areEqual(b, "ccm_template_enterprisecenter_view_click") == false) goto L5;
        return;
    L5:
        if (r9 != null) goto L8;
        r9 = b;
    L8:
        JSONObject r6 = new JSONObject();
        r6.put("click_type", "filter");
        if (r7 == null) goto L11;
        String r0 = r7.getType();
    L12:
        if (r0 != null) goto L14;
    L17:
        String r10 = "all";
    L18:
        r6.put("file_type", r10);
        r6.put("filter_result", String.valueOf(r8));
        r6.put("target", StringsKt.replace$default(r9, "_click", "", false, 4, null));
        a().n(r9, r6);
        return;
    L14:
        if (Intrinsics.areEqual(r7.getType(), "unknown") == true) goto L17;
        r10 = r7.getType();
        goto L18
    L11:
        r0 = null;
        goto L12
    }

    public static void i(String r8, TemplateV4 r9, sbb.e r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, ThumbGlideUrl.SOURCE_TEMPLATE);
        if (Intrinsics.areEqual(b, "ccm_template_search_result_view_click") == true) goto L5;
    L6:
        if (r8 == null) goto L8;
    L14:
        JSONObject r0 = new JSONObject();
        r0.put("click_type", "single_template_show");
        r0.put("template_token", r9.getReportToken());
        r0.put("template_name", r9.getReportName());
        r0.put("position_index", Integer.valueOf(r11 + 1));
        if (r12 == null) goto L17;
        r0.put("sub_template_sort", r12);
    L17:
        r0.put("is_customized", Boolean.valueOf(r9.isCustomized()));
        if (r10 == null) goto L21;
        r0.put("filter_status", c(r10));
    L21:
        if (Intrinsics.areEqual(b, "ccm_template_systemcenter_view_click") == false) goto L23;
    L24:
        r0.put("template_sort", f);
    L26:
        if (r9.isSceneTemplate() == false) goto L28;
        r0.put("is_set", Boolean.TRUE);
        r0.put("set_id", r9.getCollectionId());
        r0.put("set_name", r9.getReportName());
    L29:
        r0.put("template_source", c);
        r0.put("template_type", b(r9));
        if (r8 == null) goto L32;
        String r13 = r8;
    L51:
        r0.put("target", r13);
        com.bytedance.ee.bear.contract.d r14 = a();
        if (r8 != null) goto L55;
        r8 = b;
    L55:
        r14.o(r8, r0, r9.checkToken());
        return;
    L32:
        String r15 = b;
        switch(r15.hashCode()) {
            case -1849299558: goto L47;
            case -1801240828: goto L43;
            case -875800242: goto L39;
            case 242842220: goto L36;
            default: goto L50;
        };
    L50:
        r13 = "ccm_template_systemcenter_view";
        goto L51
    L36:
        if (r15.equals("ccm_template_search_result_view_click") == false) goto L50;
    L41:
        r13 = "ccm_template_search_result_view";
        goto L51
    L39:
        if (r15.equals("ccm_template_banner_view_click") == true) goto L41;
    L43:
        if (r15.equals("ccm_template_enterprisecenter_view_click") == false) goto L50;
        r13 = "ccm_template_enterprisecenter_view";
        goto L51
    L47:
        if (r15.equals("ccm_template_usercenter_view_click") == false) goto L50;
        r13 = "ccm_template_usercenter_view";
        goto L51
    L28:
        r0.put("is_set", Boolean.FALSE);
        goto L29
    L23:
        if (Intrinsics.areEqual(b, "ccm_template_usercenter_view_click") == false) goto L26;
    L8:
        if (r9.isBusinessTemplate() == false) goto L11;
        r8 = "ccm_template_enterprisecenter_view_click";
        goto L14
    L11:
        if (r9.isCustomTemplate() == false) goto L13;
        r8 = "ccm_template_usercenter_view_click";
        goto L14
    L13:
        r8 = "ccm_template_systemcenter_view_click";
        goto L14
    L5:
        if (Intrinsics.areEqual(b, "ccm_template_banner_view_click") == true) goto L14;
        goto L6
    }

    public static void l(TemplateReportV2 r3, String r4, String r5, String r6, f r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r5 = "";
    L6:
        if ((r8 & 4) == 0) goto L8;
        r6 = "";
    L8:
        String r0 = null;
        if ((r8 & 8) == 0) goto L11;
        r7 = null;
    L11:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "event");
        JSONObject r9 = new JSONObject();
        boolean r10 = true;
        if (r5 != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == true) goto L20;
        r9.put("enterSource", r5);
    L20:
        if (r6 != null) goto L22;
    L25:
        boolean r11 = true;
    L26:
        if (r11 == true) goto L28;
        r9.put("templatecenter_source", r6);
    L28:
        if (r7 == null) goto L30;
        String r12 = r7.a;
    L31:
        if (r12 != null) goto L33;
    L36:
        boolean r13 = true;
    L37:
        if (r13 == true) goto L42;
        if (r7 == null) goto L40;
        String r14 = r7.a;
    L41:
        r9.put("template_token", r14);
        goto L42
    L40:
        r14 = null;
    L42:
        if (r7 == null) goto L44;
        String r15 = r7.b;
    L45:
        if (r15 != null) goto L47;
    L50:
        boolean r16 = true;
    L51:
        if (r16 == true) goto L56;
        if (r7 == null) goto L54;
        String r17 = r7.b;
    L55:
        r9.put("template_name", r17);
        goto L56
    L54:
        r17 = null;
    L56:
        if (r7 == null) goto L58;
        String r18 = r7.c;
    L59:
        if (r18 != null) goto L61;
    L64:
        if (r10 == true) goto L69;
        if (r7 == null) goto L67;
        String r19 = r7.c;
    L68:
        r9.put("set_name", r19);
        goto L69
    L67:
        r19 = null;
    L69:
        if (r7 == null) goto L71;
        r0 = r7.d;
    L71:
        r9.put("is_customized", Boolean.valueOf(Intrinsics.areEqual("4", r0)));
        r9.put("template_source", c);
        a().o(r4, r9, false);
        return;
    L61:
        if (r18.length() == 0) goto L64;
        r10 = false;
        goto L64
    L58:
        r18 = null;
        goto L59
    L47:
        if (r15.length() == 0) goto L50;
        r16 = false;
        goto L51
    L44:
        r15 = null;
        goto L45
    L33:
        if (r12.length() == 0) goto L36;
        r13 = false;
        goto L37
    L30:
        r12 = null;
        goto L31
    L22:
        if (r6.length() == 0) goto L25;
        r11 = false;
        goto L26
    L14:
        if (r5.length() == 0) goto L17;
        r2 = false;
        goto L18
    }
}

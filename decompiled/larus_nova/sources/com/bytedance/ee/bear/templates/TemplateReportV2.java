package com.bytedance.ee.bear.templates;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class TemplateReportV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TemplateReportV2 f238768a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f238769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f238770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f238771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f238772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f238773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f238774g = null;

    public TemplateReportV2() {
    }

    static {
        f238768a = new TemplateReportV2();
        f238769b = "ccm_template_systemcenter_view_click";
        f238770c = "";
        f238771d = "";
        f238773f = eu5.b.f474075a.getString(R.string.Doc_List_All);
        f238774g = LazyKt.lazy(TemplateReportV2$analyticService$2.INSTANCE);
    }

    public static com.bytedance.ee.bear.contract.d a() {
        return (com.bytedance.ee.bear.contract.d) f238774g.getValue();
    }

    public static String b(TemplateV4 r100) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        if (r100.isBusinessTemplate() == false) goto L6;
        return "egc";
    L6:
        if (r100.isCustomTemplate() == false) goto L8;
        return "ugc";
    L8:
        return "pgc";
    }

    public static String c(sbb.e r100) {
        if (Intrinsics.areEqual(r100, sbb.e.f541296g) == false) goto L5;
    L17:
        return "docs";
    L5:
        if (Intrinsics.areEqual(r100, sbb.e.f541304o) == true) goto L17;
        sbb.e r101 = sbb.e.f541297h;
        if (Intrinsics.areEqual(r100, r101) == true) goto L19;
        sbb.e r102 = sbb.e.f541298i;
        if (Intrinsics.areEqual(r100, r102) == true) goto L20;
        sbb.e r103 = sbb.e.f541300k;
        if (Intrinsics.areEqual(r100, r103) == true) goto L21;
        return "all";
    L21:
        return r103.getType();
    L20:
        return r102.getType();
    L19:
        return r101.getType();
    }

    public static void h(b r100) {
        Intrinsics.checkNotNullParameter(r100, "reportParams");
        JSONObject r101 = new JSONObject();
        r101.put2("click_type", r100.f238841a);
        String r102 = r100.f238846f;
        boolean r103 = true;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L11;
        r101.put2("folder_token", r100.f238846f);
    L11:
        String r105 = r100.f238847g;
        if (r105 != null) goto L14;
    L17:
        if (r103 == true) goto L19;
        r101.put2("file_id", r100.f238847g);
    L19:
        r101.put2("is_customized", Boolean.valueOf(Intrinsics.areEqual("4", r100.f238849i)));
        r101.put2("sub_template_type", sbb.e.c(r100.f238848h));
        r101.put2("template_token", r100.f238842b);
        r101.put2("template_name", r100.f238843c);
        r101.put2("set_name", r100.f238843c);
        r101.put2("set_id", r100.f238844d);
        r101.put2("template_source", f238770c);
        r101.put2("templatecenter_source", r100.f238845e);
        a().o("ccm_set_template_preview_click", r101, false);
        return;
    L14:
        if (StringsKt.isBlank(r105) == true) goto L17;
        r103 = false;
        goto L17
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r104 = false;
        goto L9
    }

    public static void d(TemplateV4 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        JSONObject r102 = new JSONObject();
        r102.put2("click_type", "create_blank_objs");
        r102.put2("template_source", f238770c);
        r102.put2("create_file_type", sbb.e.c(r100.getObjType()));
        r102.put2(PickerReporterConstants.KEY.TARGET, "ccm_docs_page_view");
        if (TextUtils.isEmpty(r101) == true) goto L5;
        r102.put2("file_id", du5.b.g(r101));
    L5:
        a().n(f238769b, r102);
    }

    public static void e(String r100, sbb.e r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "currentFilterDocumentType");
        JSONObject r102 = new JSONObject();
        r102.put2("click_type", "sort_click");
        r102.put2("sort_name", r100);
        r102.put2("filter_status", c(r101));
        r102.put2(PickerReporterConstants.KEY.TARGET, "ccm_template_systemcenter_view");
        a().n(f238769b, r102);
    }

    public static void g(String r100, TemplateV4 r101) {
        Intrinsics.checkNotNullParameter(r100, "click");
        JSONObject r102 = new JSONObject();
        r102.put2("click_type", r100);
        if (r101 == null) goto L5;
        String r103 = r101.getObjToken();
    L6:
        r102.put2("template_token", r103);
        if (r101 == null) goto L10;
        String r104 = r101.getName();
        if (r104 == null) goto L10;
    L11:
        r102.put2("template_name", r104);
        r102.put2("template_source", f238770c);
        r102.put2("template_type", "pgc");
        a().o("ccm_vc_template_bottom_click", r102, false);
        return;
    L10:
        r104 = "";
        goto L11
    L5:
        r103 = null;
        goto L6
    }

    public static void j(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "clickType");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        JSONObject r102 = new JSONObject();
        r102.put2("click_type", r100);
        r102.put2("template_source", f238770c);
        r102.put2(PickerReporterConstants.KEY.TARGET, r101);
        a().n(f238769b, r102);
    }

    public static void k(TemplateV4 r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r101, "reportParams");
        JSONObject r102 = new JSONObject();
        r102.put2("click_type", r101.getType());
        r102.put2("template_token", r100.getReportToken());
        r102.put2("template_name", r100.getReportName());
        r102.put2("template_sort", f238773f);
        Integer r103 = r101.f239068c;
        if (r103 == null) goto L5;
        int r104 = r103.intValue() + 1;
    L6:
        r102.put2("position_index", Integer.valueOf(r104));
        String r105 = r101.f239069d;
        if (r105 == null) goto L9;
        r102.put2("sub_template_sort", r105);
    L9:
        r102.put2("is_customized", Boolean.valueOf(r100.isCustomized()));
        sbb.e r106 = r101.f239070e;
        if (r106 == null) goto L12;
        r102.put2("filter_status", c(r106));
    L12:
        r102.put2("template_sort", f238773f);
        r102.put2("use_source", "image");
        if (r100.isSceneTemplate() == false) goto L15;
        r102.put2("is_set", Boolean.TRUE);
        r102.put2("set_id", r100.getCollectionId());
        r102.put2("set_name", r100.getReportName());
    L16:
        r102.put2("template_source", f238770c);
        r102.put2("create_file_type", sbb.e.c(r100.getObjType()));
        r102.put2(PickerReporterConstants.KEY.TARGET, "ccm_template_preview_view");
        r102.put2("template_type", b(r100));
        if (Intrinsics.areEqual(f238769b, "ccm_template_search_result_view_click") == true) goto L19;
    L23:
        a().o(f238769b, r102, r100.checkToken());
        return;
    L19:
        if (f238772e == false) goto L21;
        String r107 = r101.f239067b;
    L22:
        r102.put2("keywords", r107);
        goto L23
    L21:
        r107 = "input";
        goto L22
    L15:
        r102.put2("is_set", Boolean.FALSE);
        goto L16
    L5:
        r104 = 0;
        goto L6
    }

    public static void f(sbb.e r100, boolean r101, String r102) {
        if (Intrinsics.areEqual(f238769b, "ccm_template_enterprisecenter_view_click") == false) goto L5;
        return;
    L5:
        if (r102 != null) goto L8;
        r102 = f238769b;
    L8:
        JSONObject r103 = new JSONObject();
        r103.put2("click_type", "filter");
        if (r100 == null) goto L11;
        String r104 = r100.getType();
    L12:
        if (r104 != null) goto L14;
    L17:
        String r105 = "all";
    L18:
        r103.put2("file_type", r105);
        r103.put2("filter_result", String.valueOf(r101));
        r103.put2(PickerReporterConstants.KEY.TARGET, StringsKt.replace$default(r102, "_click", "", false, 4, null));
        a().n(r102, r103);
        return;
    L14:
        if (Intrinsics.areEqual(r100.getType(), "unknown") == true) goto L17;
        r105 = r100.getType();
        goto L18
    L11:
        r104 = null;
        goto L12
    }

    public static void i(String r100, TemplateV4 r101, sbb.e r110, int r111, String r112) {
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        if (Intrinsics.areEqual(f238769b, "ccm_template_search_result_view_click") == true) goto L5;
    L6:
        if (r100 == null) goto L8;
    L14:
        JSONObject r102 = new JSONObject();
        r102.put2("click_type", "single_template_show");
        r102.put2("template_token", r101.getReportToken());
        r102.put2("template_name", r101.getReportName());
        r102.put2("position_index", Integer.valueOf(r111 + 1));
        if (r112 == null) goto L17;
        r102.put2("sub_template_sort", r112);
    L17:
        r102.put2("is_customized", Boolean.valueOf(r101.isCustomized()));
        if (r110 == null) goto L21;
        r102.put2("filter_status", c(r110));
    L21:
        if (Intrinsics.areEqual(f238769b, "ccm_template_systemcenter_view_click") == false) goto L23;
    L24:
        r102.put2("template_sort", f238773f);
    L26:
        if (r101.isSceneTemplate() == false) goto L28;
        r102.put2("is_set", Boolean.TRUE);
        r102.put2("set_id", r101.getCollectionId());
        r102.put2("set_name", r101.getReportName());
    L29:
        r102.put2("template_source", f238770c);
        r102.put2("template_type", b(r101));
        if (r100 == null) goto L32;
        String r113 = r100;
    L51:
        r102.put2(PickerReporterConstants.KEY.TARGET, r113);
        com.bytedance.ee.bear.contract.d r114 = a();
        if (r100 != null) goto L55;
        r100 = f238769b;
    L55:
        r114.o(r100, r102, r101.checkToken());
        return;
    L32:
        String r115 = f238769b;
        switch(r115.hashCode()) {
            case -1849299558: goto L47;
            case -1801240828: goto L43;
            case -875800242: goto L39;
            case 242842220: goto L36;
            default: goto L50;
        };
    L50:
        r113 = "ccm_template_systemcenter_view";
        goto L51
    L36:
        if (r115.equals("ccm_template_search_result_view_click") == false) goto L50;
    L41:
        r113 = "ccm_template_search_result_view";
        goto L51
    L39:
        if (r115.equals("ccm_template_banner_view_click") == true) goto L41;
    L43:
        if (r115.equals("ccm_template_enterprisecenter_view_click") == false) goto L50;
        r113 = "ccm_template_enterprisecenter_view";
        goto L51
    L47:
        if (r115.equals("ccm_template_usercenter_view_click") == false) goto L50;
        r113 = "ccm_template_usercenter_view";
        goto L51
    L28:
        r102.put2("is_set", Boolean.FALSE);
        goto L29
    L23:
        if (Intrinsics.areEqual(f238769b, "ccm_template_usercenter_view_click") == false) goto L26;
    L8:
        if (r101.isBusinessTemplate() == false) goto L11;
        r100 = "ccm_template_enterprisecenter_view_click";
        goto L14
    L11:
        if (r101.isCustomTemplate() == false) goto L13;
        r100 = "ccm_template_usercenter_view_click";
        goto L14
    L13:
        r100 = "ccm_template_systemcenter_view_click";
        goto L14
    L5:
        if (Intrinsics.areEqual(f238769b, "ccm_template_banner_view_click") == true) goto L14;
        goto L6
    }

    public static void l(TemplateReportV2 r100, String r101, String r102, String r103, f r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r105 & 4) == 0) goto L8;
        r103 = "";
    L8:
        String r106 = null;
        if ((r105 & 8) == 0) goto L11;
        r104 = null;
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "event");
        JSONObject r107 = new JSONObject();
        boolean r108 = true;
        if (r102 != null) goto L14;
    L17:
        boolean r109 = true;
    L18:
        if (r109 == true) goto L20;
        r107.put2("enterSource", r102);
    L20:
        if (r103 != null) goto L22;
    L25:
        boolean r110 = true;
    L26:
        if (r110 == true) goto L28;
        r107.put2("templatecenter_source", r103);
    L28:
        if (r104 == null) goto L30;
        String r111 = r104.f239071a;
    L31:
        if (r111 != null) goto L33;
    L36:
        boolean r112 = true;
    L37:
        if (r112 == true) goto L42;
        if (r104 == null) goto L40;
        String r113 = r104.f239071a;
    L41:
        r107.put2("template_token", r113);
        goto L42
    L40:
        r113 = null;
    L42:
        if (r104 == null) goto L44;
        String r114 = r104.f239072b;
    L45:
        if (r114 != null) goto L47;
    L50:
        boolean r115 = true;
    L51:
        if (r115 == true) goto L56;
        if (r104 == null) goto L54;
        String r116 = r104.f239072b;
    L55:
        r107.put2("template_name", r116);
        goto L56
    L54:
        r116 = null;
    L56:
        if (r104 == null) goto L58;
        String r117 = r104.f239073c;
    L59:
        if (r117 != null) goto L61;
    L64:
        if (r108 == true) goto L69;
        if (r104 == null) goto L67;
        String r118 = r104.f239073c;
    L68:
        r107.put2("set_name", r118);
        goto L69
    L67:
        r118 = null;
    L69:
        if (r104 == null) goto L71;
        r106 = r104.f239074d;
    L71:
        r107.put2("is_customized", Boolean.valueOf(Intrinsics.areEqual("4", r106)));
        r107.put2("template_source", f238770c);
        a().o(r101, r107, false);
        return;
    L61:
        if (r117.length() == 0) goto L64;
        r108 = false;
        goto L64
    L58:
        r117 = null;
        goto L59
    L47:
        if (r114.length() == 0) goto L50;
        r115 = false;
        goto L51
    L44:
        r114 = null;
        goto L45
    L33:
        if (r111.length() == 0) goto L36;
        r112 = false;
        goto L37
    L30:
        r111 = null;
        goto L31
    L22:
        if (r103.length() == 0) goto L25;
        r110 = false;
        goto L26
    L14:
        if (r102.length() == 0) goto L17;
        r109 = false;
        goto L18
    }
}

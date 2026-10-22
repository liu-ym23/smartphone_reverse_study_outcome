package com.larus.office.container.impl.util;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ixigua.lib.track.TrackParams;
import com.larus.office.OfficeInputParam;
import com.larus.office.OfflineDocReportGate;
import com.larus.office.base.utils.o;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f362168a = 0;

    static {
    }

    public static String b(String r100) {
        switch(r100.hashCode()) {
            case -779578017: goto L18;
            case -235927065: goto L14;
            case -123682270: goto L10;
            case 1327548607: goto L6;
            default: goto L25;
        };
    L25:
        return r100;
    L6:
        if (r100.equals("textTransform") == false) goto L26;
        return "adjust_font_size";
    L26:
        return r100;
    L10:
        if (r100.equals("insertImage") == false) goto L27;
        return "insert_image";
    L27:
        return r100;
    L14:
        if (r100.equals("alignTransform") == false) goto L28;
        return "adjust_paragraph";
    L28:
        return r100;
    L18:
        if (r100.equals("blockTransform") == false) goto L29;
        return "adjust_style";
    L29:
        return r100;
    }

    public static String c(OfficeInputParam r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getType();
    L5:
        if (r101 == null) goto L25;
        int r102 = r101.hashCode();
        if (r102 == (-899647262)) goto L22;
        if (r102 == 3016401) goto L18;
        if (r102 != 109403487) goto L25;
        if (r101.equals(DocumentType.SHEET_NAME) == false) goto L25;
        return "aisheet";
    L18:
        if (r101.equals("base") == false) goto L25;
        return "aibase";
    L22:
        if (r101.equals("slides") == false) goto L25;
        return "aippt_new";
    L25:
        return "ai_doc";
    L4:
        r101 = null;
        goto L5
    }

    public static String d(OfficeInputParam r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getType();
    L5:
        if (r101 == null) goto L25;
        int r102 = r101.hashCode();
        if (r102 == (-899647262)) goto L22;
        if (r102 == 3016401) goto L18;
        if (r102 != 109403487) goto L25;
        if (r101.equals(DocumentType.SHEET_NAME) == false) goto L25;
        return "aisheet_detail";
    L18:
        if (r101.equals("base") == false) goto L25;
        return "aibase_detail";
    L22:
        if (r101.equals("slides") == false) goto L25;
        return "aippt_new_detail";
    L25:
        return "ai_doc_detail";
    L4:
        r101 = null;
        goto L5
    }

    public static String e(OfficeInputParam r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getType();
    L6:
        boolean r102 = false;
        if (Intrinsics.areEqual(r101, DocumentType.DOCX_NAME) == false) goto L10;
        if (r100 == null) goto L20;
        String r103 = r100.getResourceId();
    L21:
        if (r103 != null) goto L23;
        return null;
    L23:
        if (r103.length() != 0) goto L26;
        r102 = true;
    L26:
        if ((!r102) == true) goto L28;
        return null;
    L28:
        return r103;
    L20:
        r103 = null;
        goto L21
    L10:
        if (r100 == null) goto L20;
        String r104 = r100.getSlidesToken();
        if (r104 == null) goto L20;
        if (r104.length() != 0) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == false) goto L19;
        r103 = r100.getResourceId();
        goto L21
    L19:
        r103 = r104;
        goto L21
    L16:
        r105 = false;
        goto L17
    L5:
        r101 = null;
        goto L6
    }

    public static void a(OfficeInputParam r100, JSONObject r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r100.getType(), DocumentType.DOCX_NAME) == true) goto L55;
        r101.put("canvas_type", c(r100));     // Catch: JSONException -> L48
        Object r102 = null;
        if (Intrinsics.areEqual(r100.getEnterFrom(), "ai_space_detail") == true) goto L9;
        String r103 = "ai_space";
    L10:
        r101.put("artifact_create_method", r103);     // Catch: JSONException -> L48
        String r104 = r100.getEnterMethod();     // Catch: JSONException -> L48
        boolean r105 = true;
        if (r104.length() <= 0) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == true) goto L17;
        r104 = null;
    L17:
        if (r104 != null) goto L25;
        r104 = r100.getEnterFrom();     // Catch: JSONException -> L48
        if (r104.length() <= 0) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == true) goto L25;
        r104 = null;
        goto L25
    L21:
        r107 = false;
    L25:
        if (r104 == null) goto L27;
        r101.put("enter_method", r104);     // Catch: JSONException -> L48
    L27:
        String r108 = r100.getAiPPTTaskId();     // Catch: JSONException -> L48
        if (r108 == null) goto L30;
        r101.put("aippt_task_id", r108);     // Catch: JSONException -> L48
    L30:
        String r109 = r100.getBotId();     // Catch: JSONException -> L48
        if (r109 == null) goto L33;
        r101.put("bot_id", r109);     // Catch: JSONException -> L48
    L33:
        String r110 = r100.getSlidesToken();     // Catch: JSONException -> L48
        if (r110.length() > 0) goto L37;
        r105 = false;
    L37:
        if (r105 == false) goto L40;
        r102 = r110;
    L40:
        if (r102 == null) goto L45;
        r101.put("resource_id", r102);     // Catch: JSONException -> L48
        if (Intrinsics.areEqual(r100.getType(), DocumentType.SHEET_NAME) == false) goto L45;
        r101.put("spreadsheet_id", r102);     // Catch: JSONException -> L48
        r101.put("artifact_type", 12);     // Catch: JSONException -> L48
    L45:
        if (Intrinsics.areEqual(r100.getType(), "slides") == false) goto L54;
        r101.put("artifact_type", 9);     // Catch: JSONException -> L48
        return;
    L54:
        return;
    L13:
        r106 = false;
        goto L14
    L9:
        r103 = null;
    L48:
        e = move-exception;
        FLogger.f375446a.e("OfficeDetailTracer", "error in OfficeDetailTracer appendSheetOrSlidesToolbarParams: " + e.getLocalizedMessage());
        return;
    }

    public static void f(String r100, JSONObject r101, final Function1 r102) {
        final JSONObject r103 = new JSONObject(r101.toString());
        OfflineDocReportGate r104 = OfflineDocReportGate.f360434a;
        Function1 r105 = new d(r103, r102);
        r104.getClass();
        OfflineDocReportGate.d(r100, r105);
    }

    public static void g(OfficeInputParam r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r102, "params");
        String r103 = e(r100);     // Catch: JSONException -> L26
        String r104 = null;
        if (r100 == null) goto L6;
        String r105 = r100.getArtifactMetaId();     // Catch: JSONException -> L26
    L7:
        Integer r106 = o.a(r100);     // Catch: JSONException -> L26
        if (r100 == null) goto L10;
        String r107 = r100.getConversationId();     // Catch: JSONException -> L26
    L11:
        if (r100 == null) goto L13;
        r104 = r100.getPreviousPage();     // Catch: JSONException -> L26
    L13:
        if (r103 == null) goto L15;
        r102.put("page_token", r103);     // Catch: JSONException -> L26
    L15:
        if (r105 == null) goto L17;
        r102.put("artifact_meta_id", r105);     // Catch: JSONException -> L26
    L17:
        if (r101 == null) goto L19;
        r102.put("button_name_level_one", b(r101));     // Catch: JSONException -> L26
    L19:
        if (r107 == null) goto L21;
        r102.put("conversation_id", r107);     // Catch: JSONException -> L26
    L21:
        r102.put("resource_type", r106);     // Catch: JSONException -> L26
        r102.put("current_page", d(r100));     // Catch: JSONException -> L26
        if (r104 == null) goto L24;
        r102.put("previous_page", r104);     // Catch: JSONException -> L26
    L24:
        a(r100, r102);     // Catch: JSONException -> L26
    L28:
        TrackParams r108 = new TrackParams().merge(r102);
        by7.a r109 = new by7.a("text_selection_bar_show");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L10:
        r107 = null;
        goto L11
    L6:
        r105 = null;
    L26:
        e = move-exception;
        FLogger.f375446a.e("OfficeDetailTracer", "error in OfficeDetailTracer reportOutputPreviewToolShow: " + e.getLocalizedMessage());
        goto L28
    }
}

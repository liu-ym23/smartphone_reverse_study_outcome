package jw4;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.templates.TemplateReport;
import org.json.JSONException;
import org.json.JSONObject;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static void c(d r3) {
        JSONObject r0 = new JSONObject();
        r0.put(JSEventListener.ACTION, r3.b);     // Catch: JSONException -> L12
        if (TextUtils.isEmpty(r3.c) == true) goto L6;
        r0.put("sub_action", r3.c);     // Catch: JSONException -> L12
    L6:
        r0.put("module", r3.d);     // Catch: JSONException -> L12
        r0.put("is_folder", String.valueOf(r3.e));     // Catch: JSONException -> L12
        if (r3.f == false) goto L9;
        String r2 = "blank_page";
    L10:
        r0.put("icon_type", r2);     // Catch: JSONException -> L12
        r3.a.a("click_new_icon", r0);     // Catch: JSONException -> L12
        return;
    L9:
        r2 = "bottom_right";
    L12:
        e = move-exception;
        tt5.a.d("CreateAnalytic", "reportClickNewIcon()...error = " + e);
    }

    public static void b(com.bytedance.ee.bear.contract.d r2, String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("file_type", r3);     // Catch: JSONException -> L5
        r2.a("click_create_item", r0);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.d("CreateAnalytic", "reportClickCreateItem()...error = " + e);
    }

    public static void d(com.bytedance.ee.bear.contract.d r3, b r4) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L11
        r0.put("file_type", r4.b);     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r4.a) == true) goto L5;
        r0.put("module", r4.a);     // Catch: Exception -> L11
    L5:
        r0.put("error_code", String.valueOf(r4.c));     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r4.d) == false) goto L8;
        String r2 = "unknown";
    L9:
        r0.put("error_msg", r2);     // Catch: Exception -> L11
        r0.put("status_name", "fail");     // Catch: Exception -> L11
        r0.put("product", r4.e);     // Catch: Exception -> L11
        r3.a("create_new_objs", r0);     // Catch: Exception -> L11
        return;
    L8:
        r2 = r4.d;     // Catch: Exception -> L11
    L11:
        e = move-exception;
        tt5.a.d("CreateAnalytic", "reportCreateFailEvent()...error = " + e);
    }

    public static void e(com.bytedance.ee.bear.contract.d r3, c r4) {
        JSONObject r0 = new JSONObject();
        r0.put("file_type", r4.a);     // Catch: Exception -> L43
        r0.put("file_id", du5.b.g(r4.b));     // Catch: Exception -> L43
        if (TextUtils.isEmpty(r4.d) == true) goto L6;
        r0.put("src_obj_id", du5.b.g(r4.d));     // Catch: Exception -> L43
    L6:
        r0.put("product", r4.c);     // Catch: Exception -> L43
        if (TextUtils.isEmpty(r4.e) == true) goto L10;
        r0.put("module", r4.e);     // Catch: Exception -> L43
    L10:
        if (TextUtils.isEmpty(r4.l) == true) goto L13;
        r0.put("template_name", r4.l);     // Catch: Exception -> L43
    L13:
        if (TextUtils.isEmpty(r4.f) == true) goto L15;
        r0.put("source", r4.f);     // Catch: Exception -> L43
    L15:
        r0.put("status_name", "success");     // Catch: Exception -> L43
        if (TextUtils.isEmpty(r4.g) == true) goto L19;
        r0.put("subsource", r4.g);     // Catch: Exception -> L43
    L19:
        if (TextUtils.isEmpty(r4.k) == true) goto L22;
        r0.put("templatecenter_source", r4.k);     // Catch: Exception -> L43
    L22:
        if ("from_set".equals(r4.k) == false) goto L25;
        r0.put("singletemplate_source", "from_preview");     // Catch: Exception -> L43
    L25:
        if (TextUtils.isEmpty(TemplateReport.a) == true) goto L28;
        r0.put("template_createfromsource", TemplateReport.a);     // Catch: Exception -> L43
    L28:
        if (TextUtils.isEmpty(r4.h) == true) goto L35;
        if (r4.j.booleanValue() == false) goto L33;
        r0.put("template_token", r4.h);     // Catch: Exception -> L43
        goto L35
    L33:
        r0.put("template_token", du5.b.g(r4.h));     // Catch: Exception -> L43
    L35:
        if (TextUtils.isEmpty(r4.i) == true) goto L38;
        r0.put("template_id", r4.i);     // Catch: Exception -> L43
    L38:
        if (r4.j.booleanValue() == true) goto L40;
        boolean r5 = true;
    L41:
        r3.g("create_new_objs", r0, r5);     // Catch: Exception -> L43
        return;
    L40:
        r5 = false;
    L43:
        e = move-exception;
        tt5.a.d("CreateAnalytic", "reportCreateSuccess()...error = " + e);
    }

    public static void g(String r2, Integer r3) {
        f(r2, 0, r3, "", "");
    }

    public static void a(com.bytedance.ee.bear.contract.d r2, String r3, String r4) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L7
        r0.put("file_type", r3);     // Catch: Exception -> L7
        if (TextUtils.isEmpty(r4) == true) goto L5;
        r0.put("module", r4);     // Catch: Exception -> L7
    L5:
        r2.a("click_create_btn", r0);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.d("CreateAnalytic", "reportClickButtonEvent()...error = " + e);
    }

    public static void h(String r3, Throwable r4, Integer r5) {
        if (r4 == null) goto L5;
        String r1 = r4.getMessage();
    L7:
        if ((r4 instanceof NetService.ServerErrorException) == false) goto L9;
        NetService.ServerErrorException r6 = (NetService.ServerErrorException) r4;
        int r0 = r6.getCode();
        String r7 = r6.getLogId();
    L10:
        f(r3, r0, r5, r1, r7);
        return;
    L9:
        r7 = "";
        r0 = -1;
        goto L10
    L5:
        r1 = "";
        goto L7
    }

    public static void f(String r2, int r3, Integer r4, String r5, String r6) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L21
        r0.put(JSEventListener.ACTION, r2);     // Catch: Exception -> L21
        if (r3 != 0) goto L5;
        String r1 = "success";
    L6:
        r0.put(TipCallBackData.RESULT, r1);     // Catch: Exception -> L21
        r0.put("code", r3);     // Catch: Exception -> L21
        if (r4 == null) goto L9;
        String r7 = e.c(r4.intValue());     // Catch: Exception -> L21
    L10:
        r0.put("filetype", r7);     // Catch: Exception -> L21
        if (r5 == null) goto L14;
        String r8 = r5;
    L15:
        r0.put("msg", r8);     // Catch: Exception -> L21
        if (r6 != null) goto L19;
        r5 = "";
    L19:
        r0.put("logId", r5);     // Catch: Exception -> L21
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).u("dev_mobile_docs_operate_sla", r0);     // Catch: Exception -> L21
        return;
    L14:
        r8 = "";
        goto L15
    L9:
        r7 = "unknown";
        goto L10
    L5:
        r1 = "fail";
    L21:
        e = move-exception;
        tt5.a.e("CreateAnalytic", "reportDocsOperateSla()...error = ", e, false);
    }
}

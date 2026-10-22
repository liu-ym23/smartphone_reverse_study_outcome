package jw4;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.event.VSUserProfileEvent;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.templates.TemplateReport;
import com.ss.android.cert.manager.constants.EventConstant;
import org.json.JSONException;
import org.json.JSONObject;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
public final class a {
    public static void c(d r100) {
        JSONObject r101 = new JSONObject();
        r101.put("action", r100.f500728b);     // Catch: JSONException -> L12
        if (TextUtils.isEmpty(r100.f500729c) == true) goto L6;
        r101.put("sub_action", r100.f500729c);     // Catch: JSONException -> L12
    L6:
        r101.put(EventConstant.Key.MODULE, r100.f500730d);     // Catch: JSONException -> L12
        r101.put("is_folder", String.valueOf(r100.f500731e));     // Catch: JSONException -> L12
        if (r100.f500732f == false) goto L9;
        String r102 = "blank_page";
    L10:
        r101.put("icon_type", r102);     // Catch: JSONException -> L12
        r100.f500727a.a("click_new_icon", r101);     // Catch: JSONException -> L12
        return;
    L9:
        r102 = VSUserProfileEvent.CLICK_POS_RIGHT;
    L12:
        e = move-exception;
        tt5.a.d("CreateAnalytic", "reportClickNewIcon()...error = " + e);
    }

    public static void b(com.bytedance.ee.bear.contract.d r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("file_type", r101);     // Catch: JSONException -> L5
        r100.a("click_create_item", r102);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.d("CreateAnalytic", "reportClickCreateItem()...error = " + e);
    }

    public static void d(com.bytedance.ee.bear.contract.d r100, b r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L11
        r102.put("file_type", r101.f500711b);     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r101.f500710a) == true) goto L5;
        r102.put(EventConstant.Key.MODULE, r101.f500710a);     // Catch: Exception -> L11
    L5:
        r102.put("error_code", String.valueOf(r101.f500712c));     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r101.f500713d) == false) goto L8;
        String r103 = "unknown";
    L9:
        r102.put("error_msg", r103);     // Catch: Exception -> L11
        r102.put("status_name", "fail");     // Catch: Exception -> L11
        r102.put("product", r101.f500714e);     // Catch: Exception -> L11
        r100.a("create_new_objs", r102);     // Catch: Exception -> L11
        return;
    L8:
        r103 = r101.f500713d;     // Catch: Exception -> L11
    L11:
        e = move-exception;
        tt5.a.d("CreateAnalytic", "reportCreateFailEvent()...error = " + e);
    }

    public static void e(com.bytedance.ee.bear.contract.d r100, c r101) {
        JSONObject r102 = new JSONObject();
        r102.put("file_type", r101.f500715a);     // Catch: Exception -> L43
        r102.put("file_id", du5.b.g(r101.f500716b));     // Catch: Exception -> L43
        if (TextUtils.isEmpty(r101.f500718d) == true) goto L6;
        r102.put("src_obj_id", du5.b.g(r101.f500718d));     // Catch: Exception -> L43
    L6:
        r102.put("product", r101.f500717c);     // Catch: Exception -> L43
        if (TextUtils.isEmpty(r101.f500719e) == true) goto L10;
        r102.put(EventConstant.Key.MODULE, r101.f500719e);     // Catch: Exception -> L43
    L10:
        if (TextUtils.isEmpty(r101.f500726l) == true) goto L13;
        r102.put("template_name", r101.f500726l);     // Catch: Exception -> L43
    L13:
        if (TextUtils.isEmpty(r101.f500720f) == true) goto L15;
        r102.put("source", r101.f500720f);     // Catch: Exception -> L43
    L15:
        r102.put("status_name", "success");     // Catch: Exception -> L43
        if (TextUtils.isEmpty(r101.f500721g) == true) goto L19;
        r102.put("subsource", r101.f500721g);     // Catch: Exception -> L43
    L19:
        if (TextUtils.isEmpty(r101.f500725k) == true) goto L22;
        r102.put("templatecenter_source", r101.f500725k);     // Catch: Exception -> L43
    L22:
        if ("from_set".equals(r101.f500725k) == false) goto L25;
        r102.put("singletemplate_source", "from_preview");     // Catch: Exception -> L43
    L25:
        if (TextUtils.isEmpty(TemplateReport.f238766a) == true) goto L28;
        r102.put("template_createfromsource", TemplateReport.f238766a);     // Catch: Exception -> L43
    L28:
        if (TextUtils.isEmpty(r101.f500722h) == true) goto L35;
        if (r101.f500724j.booleanValue() == false) goto L33;
        r102.put("template_token", r101.f500722h);     // Catch: Exception -> L43
        goto L35
    L33:
        r102.put("template_token", du5.b.g(r101.f500722h));     // Catch: Exception -> L43
    L35:
        if (TextUtils.isEmpty(r101.f500723i) == true) goto L38;
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r101.f500723i);     // Catch: Exception -> L43
    L38:
        if (r101.f500724j.booleanValue() == true) goto L40;
        boolean r103 = true;
    L41:
        r100.g("create_new_objs", r102, r103);     // Catch: Exception -> L43
        return;
    L40:
        r103 = false;
    L43:
        e = move-exception;
        tt5.a.d("CreateAnalytic", "reportCreateSuccess()...error = " + e);
    }

    public static void g(String r100, Integer r101) {
        f(r100, 0, r101, "", "");
    }

    public static void a(com.bytedance.ee.bear.contract.d r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L7
        r103.put("file_type", r101);     // Catch: Exception -> L7
        if (TextUtils.isEmpty(r102) == true) goto L5;
        r103.put(EventConstant.Key.MODULE, r102);     // Catch: Exception -> L7
    L5:
        r100.a("click_create_btn", r103);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.d("CreateAnalytic", "reportClickButtonEvent()...error = " + e);
    }

    public static void h(String r100, Throwable r101, Integer r102) {
        if (r101 == null) goto L5;
        String r103 = r101.getMessage();
    L7:
        if ((r101 instanceof NetService.ServerErrorException) == false) goto L9;
        NetService.ServerErrorException r104 = (NetService.ServerErrorException) r101;
        int r105 = r104.getCode();
        String r106 = r104.getLogId();
    L10:
        f(r100, r105, r102, r103, r106);
        return;
    L9:
        r106 = "";
        r105 = -1;
        goto L10
    L5:
        r103 = "";
        goto L7
    }

    public static void f(String r100, int r101, Integer r102, String r103, String r104) {
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L21
        r105.put("action", r100);     // Catch: Exception -> L21
        if (r101 != 0) goto L5;
        String r106 = "success";
    L6:
        r105.put("result", r106);     // Catch: Exception -> L21
        r105.put("code", r101);     // Catch: Exception -> L21
        if (r102 == null) goto L9;
        String r107 = e.c(r102.intValue());     // Catch: Exception -> L21
    L10:
        r105.put("filetype", r107);     // Catch: Exception -> L21
        if (r103 == null) goto L14;
        String r108 = r103;
    L15:
        r105.put("msg", r108);     // Catch: Exception -> L21
        if (r104 != null) goto L19;
        r103 = "";
    L19:
        r105.put("logId", r103);     // Catch: Exception -> L21
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).u("dev_mobile_docs_operate_sla", r105);     // Catch: Exception -> L21
        return;
    L14:
        r108 = "";
        goto L15
    L9:
        r107 = "unknown";
        goto L10
    L5:
        r106 = "fail";
    L21:
        e = move-exception;
        tt5.a.e("CreateAnalytic", "reportDocsOperateSla()...error = ", e, false);
    }
}

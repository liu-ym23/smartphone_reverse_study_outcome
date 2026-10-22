package com.ss.android.update;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import yhc.f0;
import yhc.j0;

/* JADX INFO: loaded from: classes40.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f455250a;

    public static String f() {
        if (f455250a != null) goto L16;
        AppCommonContext r100 = f0.f567694c;     // Catch: Throwable -> L14
        if (r100 == null) goto L7;
        Context r101 = r100.getContext();     // Catch: Throwable -> L14
    L9:
        if (new PolarisFileWrapper(r101.getExternalFilesDir(null).getParentFile(), "AutomationTestInfo.json").exists() == false) goto L11;
        String r102 = "1";
    L12:
        f455250a = r102;     // Catch: Throwable -> L14
        goto L16
    L11:
        r102 = "0";
        goto L12
    L7:
        r101 = null;
    L14:
        f455250a = "0";
    L16:
        return f455250a;
    }

    public static boolean j() {
        IUpdateConfig r100 = f0.f567692a;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getUpdateConfig() != null) goto L7;
        return false;
    L7:
        return r100.getUpdateConfig().f567744h;
    }

    public static String g() {
        if (j() == false) goto L5;
        return "1";
    L5:
        return "0";
    }

    public static String h() {
        d r100 = d.x();
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r100.f455272k == true) goto L7;
        r100.U();     // Catch: Throwable -> L11
        r100.f455272k = true;     // Catch: Throwable -> L11
    L7:
        int r101 = r100.T;     // Catch: Throwable -> L11
        monitor-exit(r100);
        return String.valueOf(r101);
    }

    public static void b(int r100) {
        JSONObject r101 = new JSONObject();
        if (r100 == (-1)) goto L5;
        r101.put("request_state", 1);     // Catch: JSONException -> L8
        r101.put("fail_reason_test", r100);     // Catch: JSONException -> L8
    L6:
        r101.put("scene_id", 1);     // Catch: JSONException -> L8
        r101.put("_event_v3", 1);     // Catch: JSONException -> L8
    L10:
        yhc.b.a("test_request_checkversion_v7", r101);
        return;
    L5:
        r101.put("request_state", 0);     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static void e(String r100) {
        JSONObject r101 = new JSONObject();
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        yhc.b.a("test_package_download_state", r101);
        return;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        r101.put("package_download_state", 1);     // Catch: JSONException -> L11
    L9:
        r101.put("scene_id", 1);     // Catch: JSONException -> L11
        r101.put("_event_v3", 1);     // Catch: JSONException -> L11
        goto L13
    L7:
        r101.put("package_download_state", 0);     // Catch: JSONException -> L11
        r101.put("fail_reason_download", r100);     // Catch: JSONException -> L11
        goto L9
    }

    public static void k(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("scene_id", 1);     // Catch: JSONException -> L5
        r101.put("_event_v3", 1);     // Catch: JSONException -> L5
        r101.put("not_show_reason", r100);     // Catch: JSONException -> L5
    L7:
        yhc.b.a("test_popup_not_show_reason", r101);
        IUpdateConfig r102 = f0.f567692a;
        JSONObject r103 = new JSONObject();
        String r104 = "0";
        if (r102 != null) goto L27;
    L16:
        r103.put("scene_id", 1);     // Catch: JSONException -> L14
        r103.put("_event_v3", 1);     // Catch: JSONException -> L14
        if (TextUtils.isEmpty(r100) == true) goto L20;
        r103.put("reason", r100);     // Catch: JSONException -> L14
    L20:
        if (j0.a.f567706a.f567703b == false) goto L22;
        r104 = "1";
    L22:
        r103.put(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r104);     // Catch: JSONException -> L14
        r103.put("is_local_app", g());     // Catch: JSONException -> L14
        r103.put("package_type", d.x().D());     // Catch: JSONException -> L14
        r103.put("is_monkey", f());     // Catch: JSONException -> L14
        r103.put("popup_type_test", h());     // Catch: JSONException -> L14
    L25:
        yhc.b.a("test_invitation_popup_not_show", r103);
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L25
    L27:
        int r105 = d.x().C() + 1;     // Catch: JSONException -> L14
        if (r102.getUpdateConfig().f567744h == false) goto L12;
        String r106 = "0";
    L13:
        r103.put("is_beta", r106);     // Catch: JSONException -> L14
        goto L16
    L12:
        r106 = r105 + "";     // Catch: JSONException -> L14
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void l(int r100) {
        d r101 = d.x();
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (r101.f455272k == true) goto L7;
        r101.U();     // Catch: Throwable -> L16
        r101.f455272k = true;     // Catch: Throwable -> L16
    L7:
        int r102 = r101.T;     // Catch: Throwable -> L16
        monitor-exit(r101);
        JSONObject r103 = new JSONObject();
        r103.put("scene_id", 1);     // Catch: JSONException -> L12
        r103.put("_event_v3", 1);     // Catch: JSONException -> L12
        r103.put("popup_type_test", r102);     // Catch: JSONException -> L12
        r103.put("popup_action", r100);     // Catch: JSONException -> L12
    L14:
        yhc.b.a("test_popup", r103);
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static void n(int r100) {
        c("test_settings_inhouse_switch", "enable_intranet_guide", r100);
    }

    public static void o(int r100) {
        c("test_is_local_installed", "is_local_installed", r100);
    }

    public static void p(int r100) {
        c("test_request_settings_normal_switch", "enable_normal_popup", r100);
    }

    public static void q(int r100) {
        c("test_current_package_type", "package_type", r100);
    }

    public static void i(int r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("scene_id", 1);     // Catch: JSONException -> L7
        r102.put("_event_v3", 1);     // Catch: JSONException -> L7
        r102.put("is_local_app", g());     // Catch: JSONException -> L7
        r102.put("package_type", d.x().D());     // Catch: JSONException -> L7
        r102.put("is_monkey", f());     // Catch: JSONException -> L7
        r102.put("status", String.valueOf(r100));     // Catch: JSONException -> L7
        r102.put("popup_type_test", h());     // Catch: JSONException -> L7
        if (TextUtils.isEmpty(r101) == true) goto L9;
        r102.put("error_msg", r101);     // Catch: JSONException -> L7
    L9:
        yhc.b.a("test_apk_install_status", r102);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public static void a(int r100, String r101, Map<String, String> r102) {
        JSONObject r103 = new JSONObject();
        r103.put("popup_action", r100);     // Catch: JSONException -> L15
        if (TextUtils.isEmpty(r101) == true) goto L6;
        r103.put("reason", r101);     // Catch: JSONException -> L15
    L6:
        r103.put("is_local_app", g());     // Catch: JSONException -> L15
        r103.put("package_type", d.x().D());     // Catch: JSONException -> L15
        r103.put("is_monkey", f());     // Catch: JSONException -> L15
        r103.put("popup_type_test", h());     // Catch: JSONException -> L15
        r103.put("real_version_code", d.x().f455280o);     // Catch: JSONException -> L15
        if (r102 == null) goto L17;
        HashMap r104 = (HashMap) r102;     // Catch: JSONException -> L15
        Iterator r105 = r104.keySet().iterator();     // Catch: JSONException -> L15
    L9:
        if (r105.hasNext() == false) goto L17;
        String r106 = (String) r105.next();     // Catch: JSONException -> L15
        String r107 = (String) r104.get(r106);     // Catch: JSONException -> L15
        if (TextUtils.isEmpty(r107) == true) goto L9;
        r103.put(r106, r107);     // Catch: JSONException -> L15
    L17:
        yhc.b.a("test_install_alpha_dialog_event", r103);
        Logger.d("installAlphaDialogEvent:action" + r100 + ", reason=" + r101);
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static void c(String r100, String r101, int r102) {
        JSONObject r103 = new JSONObject();
        r103.put("scene_id", 1);     // Catch: JSONException -> L5
        r103.put("_event_v3", 1);     // Catch: JSONException -> L5
        r103.put(r101, r102);     // Catch: JSONException -> L5
    L7:
        yhc.b.a(r100, r103);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void d(String r100, int r101, boolean r102, String r110, String r111) {
        IUpdateConfig r103 = f0.f567692a;
        JSONObject r104 = new JSONObject();
        String r105 = "0";
        int r106 = 1;
        if (r103 != null) goto L36;
    L9:
        r104.put("download_url", r100);     // Catch: JSONException -> L32
        r104.put("version_to", r101 + "");     // Catch: JSONException -> L32
        if (r102 == false) goto L13;
        Object r107 = "1";
    L14:
        r104.put("preload", r107);     // Catch: JSONException -> L32
        r104.put("scene_id", 1);     // Catch: JSONException -> L32
        r104.put("_event_v3", 1);     // Catch: JSONException -> L32
        r104.put("status", r110);     // Catch: JSONException -> L32
        if (TextUtils.isEmpty(r111) == true) goto L18;
        r104.put("error_msg", r111);     // Catch: JSONException -> L32
    L18:
        if (j0.a.f567706a.f567703b == false) goto L20;
        r105 = "1";
    L20:
        r104.put(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r105);     // Catch: JSONException -> L32
        r104.put("is_local_app", g());     // Catch: JSONException -> L32
        r104.put("package_type", d.x().D());     // Catch: JSONException -> L32
        r104.put("is_monkey", f());     // Catch: JSONException -> L32
        r104.put("popup_type_test", h());     // Catch: JSONException -> L32
        if (j() == false) goto L34;
        r104.put("real_version_code", d.x().f455280o);     // Catch: JSONException -> L32
        if (d.x().f455281o0 == null) goto L34;
        b.a r108 = d.x().f455281o0.f455248e;     // Catch: JSONException -> L32
        if (r108 == null) goto L34;
        if (r108.f455249a == true) goto L30;
        r106 = 0;
    L30:
        r104.put("is_alpha_update_bg_dl", r106);     // Catch: JSONException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L34:
        yhc.b.a("test_invitation_download", r104);
        return;
    L13:
        r107 = "0";
        goto L14
    L36:
        int r109 = d.x().C() + 1;     // Catch: JSONException -> L32
        if (r103.getUpdateConfig().f567744h == false) goto L7;
        String r112 = "0";
    L8:
        r104.put("is_beta", r112);     // Catch: JSONException -> L32
        goto L9
    L7:
        r112 = r109 + "";     // Catch: JSONException -> L32
        goto L8
    }

    public static void m(String r100, String r101, int r102, String r103, int r104, boolean r105) {
        IUpdateConfig r106 = f0.f567692a;
        JSONObject r107 = new JSONObject();
        if (r104 >= 0) goto L10;
        if (r106 == null) goto L11;
        int r108 = d.x().C() + 1;     // Catch: JSONException -> L30
        if (r106.getUpdateConfig().f567744h == false) goto L8;
        String r109 = "0";
    L9:
        r107.put("is_beta", r109);     // Catch: JSONException -> L30
        goto L11
    L8:
        r109 = r108 + "";     // Catch: JSONException -> L30
    L11:
        r107.put("download_url", r101);     // Catch: JSONException -> L30
        r107.put("version_to", r102 + "");     // Catch: JSONException -> L30
        r107.put("source", r103);     // Catch: JSONException -> L30
        r107.put("scene_id", 1);     // Catch: JSONException -> L30
        r107.put("_event_v3", 1);     // Catch: JSONException -> L30
        if (j0.a.f567706a.f567703b == false) goto L14;
        String r110 = "1";
    L15:
        r107.put(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r110);     // Catch: JSONException -> L30
        if (r105 == false) goto L18;
        String r111 = "1";
    L19:
        r107.put(MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE, r111);     // Catch: JSONException -> L30
        r107.put("release_rule_id", d.x().F());     // Catch: JSONException -> L30
        d r112 = d.x();     // Catch: JSONException -> L30
        monitor-enter(r112);     // Catch: JSONException -> L30
    L27:
        th = move-exception;
        throw th;     // Catch: JSONException -> L30
    L22:
        if (r112.f455272k == true) goto L24;
        r112.U();     // Catch: Throwable -> L27
        r112.f455272k = true;     // Catch: Throwable -> L27
    L24:
        int r113 = r112.Y;     // Catch: Throwable -> L27
        monitor-exit(r112);     // Catch: JSONException -> L30
        r107.put("strategy_id", r113);     // Catch: JSONException -> L30
        r107.put("release_scene", 0);     // Catch: JSONException -> L30
        r107.put("is_local_app", g());     // Catch: JSONException -> L30
        r107.put("package_type", d.x().D());     // Catch: JSONException -> L30
        r107.put("is_monkey", f());     // Catch: JSONException -> L30
        r107.put("popup_type_test", h());     // Catch: JSONException -> L30
    L32:
        yhc.b.a(r100, r107);
        return;
    L18:
        r111 = "0";
        goto L19
    L14:
        r110 = "0";
        goto L15
    L10:
        r107.put("is_beta", r104 + "");     // Catch: JSONException -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    }
}

package com.bytedance.sdk.account.monitor;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static void a(Throwable r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L4
        r101.put(EventConstant.Key.EXCEPTION_STACK_TRACE, Log.getStackTraceString(r100));     // Catch: Exception -> L4
        r101.put("exception_msg", r100.getMessage());     // Catch: Exception -> L4
        r101.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 60592);     // Catch: Exception -> L4
        r101.put(com.heytap.mcssdk.constant.b.C, 2);     // Catch: Exception -> L4
        a.a("passport_common_err", r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void d(String r100, String r101) {
        tb7.a.d("AccountMonitorUtil", String.format("eventType=%s, errorMessage=%s, extraInfo=%s", new Object[]{r100, null, r101}));
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.f269390n == true) goto L8;
        return;
    L8:
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L7
        r102.put("event_type", r100);     // Catch: Exception -> L7
        r102.put("error_code", 0);     // Catch: Exception -> L7
        r102.put(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, null);     // Catch: Exception -> L7
        r102.put("extra_info", r101);     // Catch: Exception -> L7
        a.a("passport_full_path", r102);     // Catch: Exception -> L7
        return;
    }

    public static void f(String r100, ua7.b r101, Throwable r102, int r103) {
        if (r101.f549249c == false) goto L18;
        return;
    L18:
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L15
        r104.put("urlpath", new URI(r100).getPath().toLowerCase());     // Catch: Exception -> L15
        r104.put("errorCode", r101.f549253g);     // Catch: Exception -> L15
        r104.put("exception_msg", r101.f549255i);     // Catch: Exception -> L15
        r104.put("detail_error_code", r101.f549254h);     // Catch: Exception -> L15
        r104.put("detail_exception_msg", r101.f549256j);     // Catch: Exception -> L15
        List<Integer> r105 = r101.f549260n;     // Catch: Exception -> L15
        if (r105 != null) goto L8;
    L10:
        r104.put("handle_result", r103);     // Catch: Exception -> L15
        if (r102 == null) goto L13;
        r104.put("exception_class_name", r102.getClass().getName());     // Catch: Exception -> L15
    L13:
        r104.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 60592);     // Catch: Exception -> L15
        r104.put(com.heytap.mcssdk.constant.b.C, 2);     // Catch: Exception -> L15
        a.a("passport_net_err", r104);     // Catch: Exception -> L15
        return;
    L8:
        if (r105.size() <= 0) goto L10;
        String r106 = r101.f549260n.toString();     // Catch: Exception -> L15
        r104.put("raw_error_code_list", r106.substring(1, r106.length() - 1).replace(" ", ""));     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    public static void h(Set<String> r100, boolean r101, boolean r102, int r103) {
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L9
        r104.put("has_reserved_keys", r101);     // Catch: Throwable -> L9
        r104.put("reach_max_count", r102);     // Catch: Throwable -> L9
        r104.put(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT, r103);     // Catch: Throwable -> L9
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L9
        Iterator<T> r106 = r100.iterator();     // Catch: Throwable -> L9
        if (r106.hasNext() == false) goto L7;
    L4:
        r105.append((CharSequence) r106.next());     // Catch: Throwable -> L9
        if (r106.hasNext() == false) goto L7;
        r105.append(",");     // Catch: Throwable -> L9
    L7:
        r104.put("keys", r105.toString());     // Catch: Throwable -> L9
        a.a("passport_set_extra_common_params", r104);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        tb7.a.c("AccountMonitorUtil", "onSetExtraCommonParams", th);
    }

    public static void c(String r110, String r111, String r112, ua7.b r113, JSONObject r210) {
        if (r113 == null) goto L23;
        String r100 = r113.f549255i;
        if (TextUtils.isEmpty(r100) == false) goto L7;
        r100 = r113.f549256j;
    L7:
        String r101 = r100;
        if (r210 == null) goto L25;
        JSONObject r102 = r210;
    L27:
        r102.put(CronetDataStorageAccess.LOGID, r113.f549247a);     // Catch: JSONException -> L20
        if ((r113 instanceof ua7.c) == false) goto L22;
        String r103 = ((ua7.c) r113).f549262p;     // Catch: JSONException -> L20
        if (TextUtils.isEmpty(r103) == true) goto L22;
        r102.put("logout_from", r103);     // Catch: JSONException -> L20
    L22:
        JSONObject r104 = r102;
        b(r110, r113.f549250d, r111, r112, r113.f549249c, r113.f549254h, r101, r104);
        return;
    L20:
        e = e;
    L21:
        e.printStackTrace();
        goto L22
    L25:
        r102 = new JSONObject();     // Catch: JSONException -> L11
    L11:
        e = e;
        r102 = r210;
        goto L21
    L23:
        b(r110, null, r111, r112, false, -1, null, r210);
    }

    public static void g(String r100, String r101, String r102, ua7.b r103, ua7.a r104) {
        if (r104 == null) goto L4;
        JSONObject r105 = r104.onSendEvent(r100);
    L5:
        c(r100, r101, r102, r103, r105);
        return;
    L4:
        r105 = null;
        goto L5
    }

    public static void e(String r100, String r101, String r102, String r103, String r104, mc7.a r105) {
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L4
        r106.put(Constants.OperatorKey.KEY_CARRIER, r100);     // Catch: Throwable -> L4
        r106.put("path", r101);     // Catch: Throwable -> L4
        r106.put(CronetDataStorageAccess.LOGID, r102);     // Catch: Throwable -> L4
        r106.put("ip_match", r103);     // Catch: Throwable -> L4
        r106.put("pre_ip_match", r104);     // Catch: Throwable -> L4
        r106.put("enable_cellular_opt", r105.f513238a);     // Catch: Throwable -> L4
        r106.put("enable_ipv4_opt", r105.f513241d);     // Catch: Throwable -> L4
        a.a("passport_ip_match_result", r106);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        tb7.a.b("AccountMonitorUtil", "monitorIpMatchResult, " + th.getMessage());
    }

    public static void i(String r100, String r101, int r102, String r103, String r104, boolean r105) {
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L13
        r106.put("platform", r100);     // Catch: JSONException -> L13
        r106.put("result", r102);     // Catch: JSONException -> L13
        r106.put("scene", r101);     // Catch: JSONException -> L13
        if (r103 == null) goto L6;
        r106.put("errCode", r103);     // Catch: JSONException -> L13
    L6:
        if (r104 == null) goto L8;
        r106.put(AuthorizeMonitorUtil.Param.ERROR_DESC, r104);     // Catch: JSONException -> L13
    L8:
        if (r102 != 0) goto L11;
        if (r105 == false) goto L11;
        r106.put(AuthorizeMonitorUtil.Param.AUTH_ERROR_CANCEL, r105);     // Catch: JSONException -> L13
    L11:
        r106.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 60592);     // Catch: JSONException -> L13
        r106.put(com.heytap.mcssdk.constant.b.C, 2);     // Catch: JSONException -> L13
        a.a("passport_oauth_callback", r106);     // Catch: JSONException -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    public static void b(String r100, String r101, String r102, String r103, boolean r104, int r105, String r106, JSONObject r107) {
        if (r107 == null) goto L19;
    L4:
        r107.put("platform", r102);     // Catch: JSONException -> L16
        r107.put("scene", r103);     // Catch: JSONException -> L16
        if (TextUtils.isEmpty(r101) == true) goto L8;
        r107.put("urlpath", r101);     // Catch: JSONException -> L16
    L8:
        if (r104 == true) goto L10;
        r107.put("result", 0);     // Catch: JSONException -> L16
        r107.put("errorCode", r105);     // Catch: JSONException -> L16
        if (r106 == null) goto L14;
        r107.put(AuthorizeMonitorUtil.Param.ERROR_DESC, r106);     // Catch: JSONException -> L16
    L14:
        r107.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 60592);     // Catch: JSONException -> L16
        r107.put(com.heytap.mcssdk.constant.b.C, 2);     // Catch: JSONException -> L16
        a.a(r100, r107);     // Catch: JSONException -> L16
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L10:
        r107.put("result", 1);     // Catch: JSONException -> L16
        goto L14
    L19:
        r107 = new JSONObject();     // Catch: JSONException -> L16
        goto L4
    }
}

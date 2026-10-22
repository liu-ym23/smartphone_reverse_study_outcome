package com.ss.android.token;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper;
import com.bytedance.bdturing.loginverify.LoginVerifyService;
import com.bytedance.sdk.account.utils.NetworkUtils;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.huawei.hms.framework.common.ContainerUtils;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class TTTokenMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile long f449648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashSet<String> f449649b = null;

    public static final enum SessionExpiredHandleResult extends Enum<SessionExpiredHandleResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SessionExpiredHandleResult[] f449650a = null;
        public static final SessionExpiredHandleResult ignore = null;
        public static final SessionExpiredHandleResult logout = null;

        static {
            SessionExpiredHandleResult r100 = new SessionExpiredHandleResult("ignore", 0);
            ignore = r100;
            SessionExpiredHandleResult r101 = new SessionExpiredHandleResult("logout", 1);
            logout = r101;
            f449650a = new SessionExpiredHandleResult[]{r100, r101};
        }

        public static SessionExpiredHandleResult[] values() {
            return (SessionExpiredHandleResult[]) f449650a.clone();
        }

        public static SessionExpiredHandleResult valueOf(String r100) {
            return (SessionExpiredHandleResult) r27.a.a(SessionExpiredHandleResult.class, r100);
        }

        public SessionExpiredHandleResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f449649b = new HashSet();
    }

    public static void i() {
        JSONObject r100 = new JSONObject();
        r100.put(EventConstants.ExtraJson.KEY_SDK_AID, 71769);     // Catch: Exception -> L5
        r100.put("sdk_version", "0.6.5-alpha.72-doubao");     // Catch: Exception -> L5
    L7:
        r(EventConstants.Label.SDK_SESSION_LAUNCH, r100);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L15;
    L14:
        return r100;
    L15:
        URI r101 = new URI(r100);     // Catch: Exception -> L12
        StringBuilder r102 = new StringBuilder();     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r101.getHost()) == true) goto L8;
        r102.append(r101.getHost());     // Catch: Exception -> L12
    L8:
        if (TextUtils.isEmpty(r101.getPath()) == true) goto L10;
        r102.append(r101.getPath());     // Catch: Exception -> L12
    L10:
        return r102.toString();
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static void d(Throwable r100) {
        r100.printStackTrace();     // Catch: Exception -> L4
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L4
        r101.put("exception_msg", r100.getMessage());     // Catch: Exception -> L4
        r101.put(EventConstant.Key.EXCEPTION_STACK_TRACE, Log.getStackTraceString(r100));     // Catch: Exception -> L4
        t("tt_token_exception", r101);     // Catch: Exception -> L4
        com.ss.android.account.k.b r102 = com.ss.android.account.k.f406317a;     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void b(String r100, String r101) {
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L4
        r102.put("from", r100);     // Catch: JSONException -> L4
        r102.put("old_token", com.bytedance.sdk.account.utils.r.c(r101));     // Catch: JSONException -> L4
        r("passport_login_token_update", r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void h(int r100, String r101) {
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L5
        r102.put("sp_name", "token_shared_preference");     // Catch: JSONException -> L5
        r102.put("error_code", r100);     // Catch: JSONException -> L5
        r102.put("error_msg", r101);     // Catch: JSONException -> L5
        com.bytedance.sdk.account.monitor.a.a("passport_save_sp_fail", r102);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        tb7.a.c("AccountSDK", "monitorSpSaveFail error", e);
    }

    public static void k(int r100, String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L5
        r102.put("error_code", r100);     // Catch: Exception -> L5
        r102.put("error_code_msg", r101);     // Catch: Exception -> L5
        r102.put("extra", new StringBuilder().toString());     // Catch: Exception -> L5
        t("tt_token_beat", r102);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static void l(String r100, String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L4
        r102.put("token", TokenFactory.l(r100));     // Catch: Exception -> L4
        r102.put(CronetDataStorageAccess.LOGID, r101);     // Catch: Exception -> L4
        t("tt_token_change", r102);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void m(String r100, String r101) {
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L4
        r102.put("token", TokenFactory.l(r100));     // Catch: JSONException -> L4
        r102.put("encrypt_token", TokenFactory.l(r101));     // Catch: JSONException -> L4
        com.bytedance.sdk.account.monitor.a.a("passport_token_encrypt_compensate", r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        tb7.a.c("AccountSDK", "monitorTokenEncryptCompensate error", e);
    }

    public static void r(String r100, JSONObject r101) {
        if (r101 != null) goto L9;
    L7:
        com.bytedance.sdk.account.monitor.a.a(r100, r101);
        return;
    L9:
        r101.put("token_config_version", com.bytedance.sdk.account.ticketguard.f.f269457g);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        tb7.a.c("AccountSDK", "onEvent error", e);
        goto L7
    }

    public static void t(String r100, JSONObject r101) {
        if (r101 == null) goto L9;
    L4:
        r101.put("result", 0);     // Catch: JSONException -> L6
        r(r100, r101);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        r101 = new JSONObject();     // Catch: JSONException -> L6
        goto L4
    }

    public static void c(String r100, String r101, JSONObject r102) {
        if (r102 == null) goto L16;
    L4:
        r102.put(DyVerifyEventConstants.EventParam.ERROR_NAME, r100);     // Catch: Exception -> L13
        r102.put("error_message", r101);     // Catch: Exception -> L13
        int r103 = 0;
        if (NetworkUtils.d(com.ss.android.account.k.c()) == false) goto L7;
        int r104 = 1;
    L8:
        r102.put("network_available", r104);     // Catch: Exception -> L13
        if (com.bytedance.sdk.account.utils.d.d() == false) goto L11;
        r103 = 1;
    L11:
        r102.put("app_in_foreground", r103);     // Catch: Exception -> L13
        t("token_config_err_v2", r102);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        r104 = 0;
        goto L8
    L16:
        r102 = new JSONObject();     // Catch: Exception -> L13
        goto L4
    }

    public static void e(String r100, String r101, String r102) {
        com.bytedance.sdk.account.ticketguard.f.a();
        if (com.bytedance.sdk.account.ticketguard.f.f269463j == true) goto L8;
        return;
    L8:
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L7
        r103.put("host", r100);     // Catch: Exception -> L7
        r103.put("path", r101);     // Catch: Exception -> L7
        r103.put("reason", r102);     // Catch: Exception -> L7
        TicketGuardEventHelper r104 = TicketGuardEventHelper.f163517g;     // Catch: Exception -> L7
        String r105 = r103.toString();     // Catch: Exception -> L7
        r104.getClass();     // Catch: Exception -> L7
        TicketGuardEventHelper.h("account_not_mark_get", "all", 0, r101 + " not mark get ticket", r105, null);     // Catch: Exception -> L7
        return;
    }

    public static void j(String r100, List r101, boolean r102) {
        String r103 = "";
        StringBuilder r104 = new StringBuilder();     // Catch: Exception -> L18
        if (r101 == null) goto L16;
        ArrayList r105 = (ArrayList) r101;     // Catch: Exception -> L18
        if (r105.isEmpty() == true) goto L16;
        Iterator r106 = r105.iterator();     // Catch: Exception -> L18
    L8:
        if (r106.hasNext() == false) goto L16;
        Object r107 = r106.next();     // Catch: Exception -> L18
        if ((r107 instanceof o) == true) goto L12;
        if (r107 == null) goto L8;
        r104.append(r107.toString());     // Catch: Exception -> L18
        r104.append(com.alipay.sdk.m.u.i.f25853b);     // Catch: Exception -> L18
        goto L8
    L12:
        if ("X-TT-LOGID".equalsIgnoreCase(((o) r107).f449775a) == false) goto L8;
        r103 = ((o) r107).f449776b;     // Catch: Exception -> L18
    L16:
        String r108 = r104.toString();     // Catch: Exception -> L18
        s(a(r100), r103, r108, r102);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        d(e);
    }

    public static void n(String r100, String r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L4
        r104.put("path", r100);     // Catch: JSONException -> L4
        r104.put("ticket_name", r101);     // Catch: JSONException -> L4
        r104.put("error_code", r102);     // Catch: JSONException -> L4
        r104.put(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, r103);     // Catch: JSONException -> L4
        r("passport_token_guard_fail", r104);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void o(Long r100, Long r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L4
        r104.put("old_id", String.valueOf(r100));     // Catch: JSONException -> L4
        r104.put("new_id", String.valueOf(r101));     // Catch: JSONException -> L4
        r104.put("path", r102);     // Catch: JSONException -> L4
        r104.put("from", r103);     // Catch: JSONException -> L4
        r("passport_uid_update", r104);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        tb7.a.c("AccountSDK", "monitorUidUpdate error", e);
    }

    public static void s(String r100, String r101, String r102, boolean r103) {
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L18
        if (TextUtils.isEmpty(r101) == true) goto L7;
        r104.put(CronetDataStorageAccess.LOGID, r101);     // Catch: JSONException -> L18
    L7:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        r104.put("urlpath", r100);     // Catch: JSONException -> L18
    L9:
        r104.put(com.heytap.mcssdk.constant.b.C, 2);     // Catch: JSONException -> L18
        if (TextUtils.isEmpty(r102) == true) goto L13;
        r104.put("extra", r102);     // Catch: JSONException -> L18
    L13:
        if (r103 == false) goto L15;
        String r105 = "1";
    L16:
        r104.put("user_was_login", r105);     // Catch: JSONException -> L18
        r104.put("result", 0);     // Catch: JSONException -> L18
        r("tt_token_logout", r104);     // Catch: JSONException -> L18
        return;
    L15:
        r105 = "0";
    L18:
        e = move-exception;
        e.printStackTrace();
    }

    public static void g(String r100, String r101, String r102, Map<String, String> r110, Collection<String> r111) {
        if (r111 != null) goto L4;
        return;
    L4:
        if (r111.isEmpty() == true) goto L42;
        HashMap r112 = (HashMap) r110;
        if (r112.isEmpty() == true) goto L44;
        HashSet r103 = new HashSet(r111);
        r103.add(LoginVerifyService.X_TT_TOKEN.toLowerCase());
        StringBuffer r104 = new StringBuffer();
        Iterator r105 = r103.iterator();
        boolean r106 = false;
        boolean r107 = false;
    L10:
        if (r105.hasNext() == false) goto L21;
        String r108 = (String) r105.next();
        if (r108 == null) goto L10;
        String r109 = r108.toLowerCase();
        if (r104.length() <= 0) goto L17;
        r104.append(",");
    L17:
        r104.append(r109);
        r104.append(ContainerUtils.KEY_VALUE_DELIMITER);
        if (TextUtils.isEmpty((String) r112.get(r109)) == false) goto L19;
        r104.append(0);
        r107 = true;
        goto L10
    L19:
        r104.append(1);
        r106 = true;
        goto L10
    L21:
        if (r106 == false) goto L43;
        if (r107 == false) goto L45;
        tb7.a.a("TTTokenMonitor", "response extra headers no identical: " + r104);
        JSONObject r113 = new JSONObject();
        r113.put("host", r100);     // Catch: Exception -> L27
        r113.put("path", r101);     // Catch: Exception -> L27
        r113.put(CronetDataStorageAccess.LOGID, r102);     // Catch: Exception -> L27
        r113.put("x_tt_token", r112.containsKey(LoginVerifyService.X_TT_TOKEN.toLowerCase()) ? 1 : 0);     // Catch: Exception -> L27
        r113.put(DownloadSettingKeys.DownloadTaskParam.EXTRA_HEADERS, r104.toString());     // Catch: Exception -> L27
    L29:
        r("passport_response_extra_header", r113);
        return;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L45:
        return;
    L43:
        return;
    L44:
        return;
    }

    public static void f(String r110, String r111, String r112, String r113, f r114, Map<String, String> r115) {
        if (r114 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r112) == true) goto L83;
        com.bytedance.sdk.account.settings.common.b.a();
        Collection<String> r100 = com.bytedance.sdk.account.settings.common.b.f269405c.f269551c;
        com.bytedance.sdk.account.settings.common.b.a();
        if (com.bytedance.sdk.account.settings.common.b.f269404b == true) goto L10;
        return;
    L10:
        if (r100.isEmpty() == true) goto L84;
        String r101 = r112.toLowerCase();
        if ("/passport/token/beat/v2/".equals(r101) == true) goto L15;
        return;
    L15:
        StringBuilder r102 = new StringBuilder();
        StringBuilder r103 = new StringBuilder();
        Map r104 = r114.f449733a;
        if (r104 != null) goto L18;
        r104 = new HashMap();
    L18:
        Iterator<String> r105 = r100.iterator();
        int r106 = 0;
        boolean r107 = false;
    L20:
        if (r105.hasNext() == false) goto L40;
        String r108 = r105.next();
        if (r108 == null) goto L20;
        if (r108.isEmpty() == true) goto L20;
        if (r102.length() <= 0) goto L29;
        r102.append(",");
    L29:
        r102.append(r108);
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
        if (TextUtils.isEmpty((String) r104.get(r108)) == false) goto L32;
        r102.append(0);
        r107 = true;
    L34:
        if (r103.length() <= 0) goto L36;
        r103.append(",");
    L36:
        r103.append(r108);
        r103.append(ContainerUtils.KEY_VALUE_DELIMITER);
        if (TextUtils.isEmpty((String) ((HashMap) r115).get(r108)) == true) goto L38;
        r103.append(1);
        goto L20
    L38:
        r103.append(0);
        goto L20
    L32:
        r102.append(1);
        goto L34
    L40:
        if (r107 == true) goto L42;
        return;
    L42:
        if (r110 != null) goto L44;
    L46:
        boolean r109 = false;
    L47:
        JSONObject r116 = new JSONObject();
        r116.put("host", r111);     // Catch: Exception -> L65
        r116.put("path", r101);     // Catch: Exception -> L65
        r116.put(CronetDataStorageAccess.LOGID, r113);     // Catch: Exception -> L65
        if (com.bytedance.sdk.account.impl.h.a().isLogin() == false) goto L51;
        int r117 = 1;
    L52:
        r116.put("is_login", r117);     // Catch: Exception -> L65
        if (TextUtils.isEmpty((CharSequence) r104.get("sdk-version")) == true) goto L55;
        int r118 = 1;
    L56:
        r116.put("sdk_version", r118);     // Catch: Exception -> L65
        if (r109 == false) goto L59;
        int r119 = 1;
    L60:
        r116.put("is_from_ttaccountsdk", r119);     // Catch: Exception -> L65
        if (TextUtils.isEmpty((CharSequence) r104.get(LoginVerifyService.X_TT_TOKEN)) == true) goto L63;
        r106 = 1;
    L63:
        r116.put("request_x_tt_token", r106);     // Catch: Exception -> L65
        HashMap r120 = (HashMap) r115;     // Catch: Exception -> L65
        r116.put("response_x_tt_token", !TextUtils.isEmpty((CharSequence) r120.get(LoginVerifyService.X_TT_TOKEN.toLowerCase())) ? 1 : 0);     // Catch: Exception -> L65
        r116.put("request_extra_header", r102.toString());     // Catch: Exception -> L65
        r116.put("response_extra_header", r103.toString());     // Catch: Exception -> L65
    L67:
        r("passport_request_extra_header_miss", r116);
        return;
    L59:
        r119 = 0;
        goto L60
    L55:
        r118 = 0;
        goto L56
    L51:
        r117 = 0;
    L65:
        e = move-exception;
        e.printStackTrace();
        goto L67
    L44:
        if (r110.contains("is_from_ttaccountsdk=1") == false) goto L46;
        r109 = true;
        goto L47
    L84:
        return;
    }

    public static void p(String r100, String r101, String r110, f r111, e0 r112, String r113, List r114) {
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L75
        r102.put("host", r100);     // Catch: JSONException -> L75
        r102.put("path", r101);     // Catch: JSONException -> L75
        r102.put("log_id", r110);     // Catch: JSONException -> L75
        int r103 = 1;
        if (r111 == null) goto L27;
        com.bytedance.android.sdk.bdticketguard.a0 r115 = r111.f449734b;     // Catch: JSONException -> L75
        if (r115 == null) goto L27;
        List<Pair<String, String>> r116 = r115.f163577b;     // Catch: JSONException -> L75
        if (r116 == null) goto L27;
        if (r116.isEmpty() == true) goto L27;
        Iterator<Pair<String, String>> r117 = r115.f163577b.iterator();     // Catch: JSONException -> L75
        int r118 = 0;
        int r104 = 0;
        int r105 = 0;
    L13:
        if (r117.hasNext() == false) goto L26;
        Pair<String, String> r106 = r117.next();     // Catch: JSONException -> L75
        if (r106 == null) goto L13;
        if (TextUtils.equals("bd-ticket-guard-client-csr", (CharSequence) r106.first) == true) goto L19;
        if (TextUtils.equals("bd-ticket-guard-client-cert", (CharSequence) r106.first) == true) goto L22;
        if (TextUtils.equals("bd-ticket-guard-ree-public-key", (CharSequence) r106.first) == false) goto L13;
        r105 = !TextUtils.isEmpty((CharSequence) r106.second) ? 1 : 0;     // Catch: JSONException -> L75
        goto L13
    L22:
        r104 = !TextUtils.isEmpty((CharSequence) r106.second) ? 1 : 0;     // Catch: JSONException -> L75
        goto L13
    L19:
        r118 = !TextUtils.isEmpty((CharSequence) r106.second) ? 1 : 0;     // Catch: JSONException -> L75
        goto L13
    L26:
        r102.put("csr", r118);     // Catch: JSONException -> L75
        r102.put("client_cert", r104);     // Catch: JSONException -> L75
        r102.put("ree_public_key", r105);     // Catch: JSONException -> L75
    L27:
        if (r114 == null) goto L51;
        ArrayList r119 = (ArrayList) r114;     // Catch: JSONException -> L75
        if (r119.isEmpty() == true) goto L51;
        StringBuffer r120 = new StringBuffer();     // Catch: JSONException -> L75
        Iterator r121 = r119.iterator();     // Catch: JSONException -> L75
    L32:
        if (r121.hasNext() == false) goto L48;
        o r122 = (o) r121.next();     // Catch: JSONException -> L75
        if ("set-cookie".equalsIgnoreCase(r122.f449775a) == false) goto L32;
        String r123 = r122.f449776b;     // Catch: JSONException -> L75
        if (TextUtils.isEmpty(r123) == true) goto L32;
        if (r123.contains(InteractConst.INTENT_SESSION_ID) == false) goto L32;
        String r124 = r123.split(com.alipay.sdk.m.u.i.f25853b)[0].split(ContainerUtils.KEY_VALUE_DELIMITER)[0];     // Catch: JSONException -> L75
        if (r124 == null) goto L32;
        if (r124.startsWith(InteractConst.INTENT_SESSION_ID) == false) goto L32;
        if (r120.length() <= 0) goto L46;
        r120.append(",");     // Catch: JSONException -> L75
    L46:
        r120.append(r124);     // Catch: JSONException -> L75
        r120.append("=1");     // Catch: JSONException -> L75
        goto L32
    L48:
        if (r120.length() <= 0) goto L51;
        r102.put("cookies", r120.toString());     // Catch: JSONException -> L75
    L51:
        if (TextUtils.isEmpty(r112.f449725a) == true) goto L53;
        int r125 = 1;
    L54:
        r102.put("token", r125);     // Catch: JSONException -> L75
        if (TextUtils.isEmpty(r112.f449726b) == true) goto L57;
        int r126 = 1;
    L58:
        r102.put("tssign", r126);     // Catch: JSONException -> L75
        String r127 = r112.f449726b;     // Catch: JSONException -> L75
        TokenFactory r128 = TokenFactory.C;     // Catch: JSONException -> L75
        String r129 = r127.replace(" ", "");     // Catch: JSONException -> L75
        if (TextUtils.isEmpty(r129) == false) goto L61;
    L65:
        boolean r130 = false;
    L66:
        if (r130 == false) goto L68;
        int r131 = 1;
    L69:
        r102.put("has_tee_sign", r131);     // Catch: JSONException -> L75
        if (TextUtils.isEmpty(r112.f449727c) == false) goto L73;
        r103 = 0;
    L73:
        r102.put("attest_tssign", r103);     // Catch: JSONException -> L75
        r102.put("new_token", com.bytedance.sdk.account.utils.r.c(r112.f449725a));     // Catch: JSONException -> L75
        r102.put("old_token", com.bytedance.sdk.account.utils.r.c(r113));     // Catch: JSONException -> L75
        r102.put("from", "interceptor");     // Catch: JSONException -> L75
        r102.put("had_sec_uid", r112.f449732h);     // Catch: JSONException -> L75
        r("passport_login_token_update", r102);     // Catch: JSONException -> L75
        return;
    L68:
        r131 = 0;
        goto L69
    L61:
        if (r129.contains("\"ts_sign\"") == false) goto L65;
        if (r129.contains("\"ts_sign\":\"\"") == true) goto L65;
        r130 = true;
        goto L66
    L57:
        r126 = 0;
        goto L58
    L53:
        r125 = 0;
    L75:
        e = move-exception;
        e.printStackTrace();
    }

    public static void q(String r100, String r101, boolean r102, String r103, String r104, boolean r105, String r110) {
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L19
        int r107 = 0;
        if (r102 == false) goto L5;
        int r108 = 1;
    L6:
        r106.put("token_is_null", r108);     // Catch: JSONException -> L19
        if (TextUtils.isEmpty(r103) == false) goto L9;
        int r109 = 1;
    L10:
        r106.put("response_sec_uid_is_null", r109);     // Catch: JSONException -> L19
        if (TextUtils.isEmpty(r104) == false) goto L13;
        int r111 = 1;
    L14:
        r106.put("sec_uid_is_null", r111);     // Catch: JSONException -> L19
        r106.put("path", r100);     // Catch: JSONException -> L19
        r106.put(CronetDataStorageAccess.LOGID, r101);     // Catch: JSONException -> L19
        if (r105 == false) goto L17;
        r107 = 1;
    L17:
        r106.put("is_login", r107);     // Catch: JSONException -> L19
        r106.put("sec_uid", r104);     // Catch: JSONException -> L19
        r106.put("response_sec_uid", r103);     // Catch: JSONException -> L19
        r106.put(DyVerifyEventConstants.EventParam.ERROR_NAME, r110);     // Catch: JSONException -> L19
        r("passport_user_mixed_uid", r106);     // Catch: JSONException -> L19
        return;
    L13:
        r111 = 0;
        goto L14
    L9:
        r109 = 0;
        goto L10
    L5:
        r108 = 0;
    L19:
        e = move-exception;
        tb7.a.c("AccountSDK", "monitorUserMixedUid error", e);
    }
}

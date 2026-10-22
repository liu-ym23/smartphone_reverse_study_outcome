package com.bytedance.ttnet.clientkey;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.frameworks.baselib.network.http.util.l;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.ttnet.TTReportAllLog;
import com.bytedance.ttnet.config.JsonOptConfig;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ClientKeyManager {
    private static final String CLIENT_KEY_CONFIG_FILE_NAME = "ttnet_client_key_config";
    private static final String CLIENT_KEY_CONFIG_NAME = "client_key_config";
    private static final String CLIENT_KEY_NAME = "client_key";
    private static final String CLIENT_KEY_REQUEST_HEADER_NAME = "x-bd-client-key";
    private static final String CLIENT_KEY_RESPONSE_HEADER_NAME = "x-bd-lanusk";
    private static final String HEADER_SPLIT_STRING = "\r\n";
    private static final String KMS_VERSION_NAME = "kms_version";
    private static final String KMS_VERSION_REQUEST_HEADER_NAME = "x-bd-kmsv";
    private static final String KMS_VERSION_RESPONSE_HEADER_NAME = "x-bd-lanusv";
    private static final String MAX_AGE_NAME = "Max-Age=";
    private static final int RESPONSE_CLIENT_KEY_DEFAULT = 0;
    private static final int RESPONSE_CLIENT_KEY_INVALID = 1;
    private static final int RESPONSE_CLIENT_KEY_NULL = 3;
    private static final int RESPONSE_CLIENT_KEY_SAME_NULL = 2;
    private static final String SESSION_ID_NAME = "session_id";
    private static final String SESSION_TIME_NAME = "session_time";
    private static final String SESSION_URL_NAME = "session_url";
    private static final String TAG = null;
    private static volatile boolean mClientKeySignEnabled = false;
    private static Keva mKevaStorage = null;
    private static Map<String, String> sClientKeyHeaders = null;
    private static volatile ClientKeyManager sInstance = null;
    private static boolean sIsMainProcess = true;
    private String mClientKey;
    private String mKmsVersion;
    private boolean mRewriteSessionEnabled;
    private String mSessionId;
    private String mSessionUrl;
    private List<String> mUpdateHostList;
    private List<String> mUpdatePathList;

    static {
        TAG = "ClientKeyManager";
    }

    public static Map<String, String> getClientKeyHeaders() {
        if (mKevaStorage != null) goto L5;
        return null;
    L5:
        if (mClientKeySignEnabled == true) goto L8;
        return null;
    L8:
        if (sIsMainProcess == false) goto L12;
        return sClientKeyHeaders;
    L12:
        return constructClientKeyHeaders(mKevaStorage.getString("client_key", ""), mKevaStorage.getString(KMS_VERSION_NAME, ""));
    }

    public static ClientKeyManager inst() {
        if (sInstance != null) goto L15;
        monitor-enter(ClientKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ClientKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ClientKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private ClientKeyManager() {
        this.mUpdateHostList = new CopyOnWriteArrayList();
        this.mUpdatePathList = new CopyOnWriteArrayList();
        this.mClientKey = "";
        this.mSessionId = "";
        this.mSessionUrl = "";
        this.mKmsVersion = "";
        this.mRewriteSessionEnabled = true;
    }

    private void ParseClientKeyConfig(JSONObject r100) throws Exception {
        int r101 = 0;
        boolean r102 = true;
        if (r100.optInt("client_key_sign_enabled", 0) <= 0) goto L5;
        boolean r103 = true;
    L6:
        mClientKeySignEnabled = r103;
        if (mClientKeySignEnabled == true) goto L14;
        if (Logger.debug() == false) goto L11;
        Logger.d(TAG, "clear client key storage.");
    L11:
        mKevaStorage.clear();
        return;
    L14:
        if (r100.optInt("rewrite_session_enabled", 1) > 0) goto L17;
        r102 = false;
    L17:
        this.mRewriteSessionEnabled = r102;
        this.mUpdateHostList.clear();
        String r104 = r100.optString("update_host_list", null);
        if (TextUtils.isEmpty(r104) == true) goto L26;
        JSONArray r105 = new JSONArray(r104);
        int r106 = 0;
    L21:
        if (r106 >= r105.length()) goto L26;
        String r107 = JSONArrayProtectorUtils.getString(r105, r106);
        if (TextUtils.isEmpty(r107) == true) goto L25;
        this.mUpdateHostList.add(r107);
    L25:
        r106 = r106 + 1;
    L26:
        this.mUpdatePathList.clear();
        String r108 = r100.optString("update_path_list", null);
        if (TextUtils.isEmpty(r108) == true) goto L35;
        JSONArray r109 = new JSONArray(r108);
    L30:
        if (r101 >= r109.length()) goto L42;
        String r110 = JSONArrayProtectorUtils.getString(r109, r101);
        if (TextUtils.isEmpty(r110) == true) goto L34;
        this.mUpdatePathList.add(r110);
    L34:
        r101 = r101 + 1;
        goto L30
    L42:
        return;
    L35:
        return;
    L5:
        r103 = false;
        goto L6
    }

    private void UpdateCookieInfo(String r100) {
        CookieHandler r101 = CookieHandler.getDefault();
        if (r101 != null) goto L25;
        return;
    L25:
        URI r102 = l.b(this.mSessionUrl);     // Catch: Throwable -> L24
        if (r102 != null) goto L8;
        return;
    L8:
        Map<String, List<String>> r103 = r101.get(r102, null);     // Catch: Throwable -> L24
        if (r103 != null) goto L11;
        return;
    L11:
        if (r103.isEmpty() == false) goto L13;
        return;
    L13:
        if (r103.containsKey("Cookie") == false) goto L28;
        String r104 = r103.get("Cookie").toString();     // Catch: Throwable -> L24
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "cookieStr: " + r104 + " sessionId: " + this.mSessionId);     // Catch: Throwable -> L24
    L18:
        if (TextUtils.isEmpty(r104) == false) goto L20;
        refreshSessionCookie(r100, r101, r102);     // Catch: Throwable -> L24
        SendCookieMismatchLog("empty", r100);     // Catch: Throwable -> L24
        return;
    L20:
        if (r104.contains(this.mSessionId) == true) goto L29;
        refreshSessionCookie(r100, r101, r102);     // Catch: Throwable -> L24
        SendCookieMismatchLog(r104, r100);     // Catch: Throwable -> L24
        return;
    L29:
        return;
    L28:
        return;
    }

    public void InitClientKeyAndSessionInfo(boolean r100) {
        sIsMainProcess = r100;
        mKevaStorage = Keva.getRepo(CLIENT_KEY_CONFIG_FILE_NAME, 1);     // Catch: Throwable -> L5
    L7:
        Keva r101 = mKevaStorage;
        if (r101 != null) goto L10;
        return;
    L10:
        String r102 = r101.getString(CLIENT_KEY_CONFIG_NAME, "");
        if (TextUtils.isEmpty(r102) == true) goto L16;
        ParseClientKeyConfig(new JSONObject(r102));     // Catch: Throwable -> L14
    L16:
        if (mClientKeySignEnabled == true) goto L18;
        return;
    L18:
        String r103 = mKevaStorage.getString("session_id", "");
        long r104 = mKevaStorage.getLong(SESSION_TIME_NAME, 0);
        this.mSessionUrl = mKevaStorage.getString(SESSION_URL_NAME, "");
        this.mClientKey = mKevaStorage.getString("client_key", "");
        String r105 = mKevaStorage.getString(KMS_VERSION_NAME, "");
        this.mKmsVersion = r105;
        sClientKeyHeaders = constructClientKeyHeaders(this.mClientKey, r105);
        if (r103.isEmpty() == false) goto L21;
        return;
    L21:
        if (this.mSessionUrl.isEmpty() == true) goto L44;
        String[] r106 = r103.split(i.f25853b);
        if (r106 == null) goto L29;
        if (r106.length <= 0) goto L29;
        this.mSessionId = r106[0].trim();
    L29:
        if (TextUtils.isEmpty(this.mSessionId) == false) goto L31;
        return;
    L31:
        String r107 = ReplaceMaxAgeTime(r106, r104, r103);
        if (TextUtils.isEmpty(r107) == true) goto L35;
        r103 = r107;
    L35:
        if (Logger.debug() == false) goto L37;
        Logger.d(TAG, "client key: " + this.mClientKey + " | kms version: " + this.mKmsVersion + " | session cookie: " + r103 + " | sessionid: " + this.mSessionId + " | session time: " + r104 + " session url: " + this.mSessionUrl + " config: " + r102);
    L37:
        UpdateCookieInfo(r103);
        return;
    L44:
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public void OnNetConfigChanged(Object r100) {
        if (mKevaStorage != null) goto L5;
        return;
    L5:
        if (JsonOptConfig.isValid(r100) == false) goto L26;
        JSONObject r101 = JsonOptConfig.jsonObject(r100);     // Catch: Throwable -> L23
        if (r101 == null) goto L11;
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r101, "data").optJSONObject(CLIENT_KEY_CONFIG_NAME);     // Catch: Throwable -> L23
    L12:
        if (r102 == null) goto L14;
        String r103 = r102.toString();     // Catch: Throwable -> L23
        if (Logger.debug() == false) goto L21;
        Logger.d(TAG, "config: " + r103);     // Catch: Throwable -> L23
    L21:
        mKevaStorage.storeString(CLIENT_KEY_CONFIG_NAME, r103);     // Catch: Throwable -> L23
        ParseClientKeyConfig(r102);     // Catch: Throwable -> L23
        return;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d(TAG, "clear client key storage.");     // Catch: Throwable -> L23
    L16:
        mClientKeySignEnabled = false;     // Catch: Throwable -> L23
        mKevaStorage.clear();     // Catch: Throwable -> L23
        return;
    L11:
        r102 = null;
        goto L12
    L27:
        return;
    }

    private void SendCookieMismatchLog(String r100, String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L4
        r102.put("report_time", System.currentTimeMillis() + "");     // Catch: Throwable -> L4
        r102.put("cookie_line", r100);     // Catch: Throwable -> L4
        r102.put("session_id", r101);     // Catch: Throwable -> L4
        r102.put("url", this.mSessionUrl);     // Catch: Throwable -> L4
        TTReportAllLog.reportInternalAllLog("cookie_mismatch", r102);     // Catch: Throwable -> L4
        return;
    }

    private void UpdateClientKeyAndSessionInfoInner(Request r110, Response r111) {
        URI r100 = l.b(r110.getUrl());     // Catch: Throwable -> L5
    L6:
        if (r100 != null) goto L9;
        return;
    L9:
        if (this.mUpdateHostList.isEmpty() == true) goto L20;
        Iterator<String> r101 = this.mUpdateHostList.iterator();
    L12:
        if (r101.hasNext() == false) goto L16;
        if (UrlUtils.matchPattern(r100.getHost(), r101.next()) == false) goto L12;
        boolean r102 = true;
    L17:
        if (r102 == true) goto L20;
        return;
    L16:
        r102 = false;
    L20:
        if (this.mUpdatePathList.isEmpty() == true) goto L27;
        Iterator<String> r103 = this.mUpdatePathList.iterator();
    L23:
        if (r103.hasNext() == false) goto L27;
        if (UrlUtils.matchPattern(r100.getPath(), r103.next()) == false) goto L23;
        boolean r104 = true;
    L28:
        if (r104 == true) goto L30;
        return;
    L30:
        List<Header> r105 = r111.headers("Set-Cookie");
        if (r105 != null) goto L33;
    L40:
        String r112 = "";
    L41:
        String[] r106 = r112.split(i.f25853b);
        if (r106 != null) goto L44;
    L46:
        String r113 = "";
    L48:
        if (TextUtils.isEmpty(r113) == false) goto L51;
        return;
    L51:
        if (Logger.debug() == false) goto L53;
        Logger.d(TAG, "original sessionid: " + this.mSessionId + " new sessionid: " + r113);
    L53:
        Header r107 = r111.getFirstHeader(CLIENT_KEY_RESPONSE_HEADER_NAME);
        Header r108 = r111.getFirstHeader(KMS_VERSION_RESPONSE_HEADER_NAME);
        if (r107 == null) goto L64;
        if (r108 == null) goto L64;
        String r109 = r107.getValue();
        String r114 = r108.getValue();
        if (TextUtils.isEmpty(r109) == false) goto L59;
    L62:
        String r115 = "";
        String r116 = r115;
        int r117 = 1;
    L67:
        if (r117 != 0) goto L75;
    L71:
        this.mClientKey = r115;
        this.mKmsVersion = r116;
        String r118 = r110.getUrl();
        this.mSessionUrl = r118;
        this.mSessionId = r113;
        mKevaStorage.storeString(SESSION_URL_NAME, r118);
        mKevaStorage.storeString("session_id", r112);
        mKevaStorage.storeString("client_key", this.mClientKey);
        mKevaStorage.storeString(KMS_VERSION_NAME, this.mKmsVersion);
        mKevaStorage.storeLong(SESSION_TIME_NAME, System.currentTimeMillis());
        sClientKeyHeaders = constructClientKeyHeaders(this.mClientKey, this.mKmsVersion);
        if (Logger.debug() == false) goto L88;
        Logger.d(TAG, "save session url: " + this.mSessionUrl + " session cookie: " + r112 + " client key: " + this.mClientKey + " kms version: " + this.mKmsVersion);
        return;
    L88:
        return;
    L75:
        reportClientKeyLog(r117, this.mSessionId, r113, this.mClientKey, r115, this.mKmsVersion, r116, r111, r100.getPath());     // Catch: Throwable -> L70
        goto L71
    L59:
        if (TextUtils.isEmpty(r114) == true) goto L62;
        r115 = r109;
        r116 = r114;
        r117 = 0;
    L64:
        if (r113.equals(this.mSessionId) == false) goto L66;
        String r119 = this.mClientKey;
        r116 = this.mKmsVersion;
        r115 = r119;
        r117 = 2;
        goto L67
    L66:
        r117 = 3;
        r115 = "";
        r116 = r115;
        goto L67
    L44:
        if (r106.length <= 0) goto L46;
        r113 = r106[0].trim();
        goto L48
    L33:
        if (r105.isEmpty() == true) goto L40;
        Iterator<Header> r120 = r105.iterator();
    L36:
        if (r120.hasNext() == false) goto L40;
        String r121 = r120.next().getValue().trim();
        if (r121.toLowerCase().startsWith("sessionid=") == false) goto L36;
        r112 = r121;
    L27:
        r104 = false;
    L5:
        r100 = null;
        goto L6
    }

    private static String appendHeaderString(Response r100, String r101) {
        Header r102 = r100.getFirstHeader(r101);
        if (r102 != null) goto L5;
        return "";
    L5:
        return ("" + r102.toString()) + "; ";
    }

    private static Map<String, String> constructClientKeyHeaders(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        HashMap r102 = new HashMap();
        r102.put(CLIENT_KEY_REQUEST_HEADER_NAME, r100);
        r102.put(KMS_VERSION_REQUEST_HEADER_NAME, r101);
        return r102;
    L11:
        return null;
    }

    public void AddClientKeyHeader(List<Header> r100, RetrofitMetrics r101) {
        if (mKevaStorage != null) goto L5;
        return;
    L5:
        if (mClientKeySignEnabled == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.mClientKey) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.mKmsVersion) == true) goto L21;
        if (r101 == null) goto L13;
        r101.addClientKeyStart();
    L13:
        r100.add(new Header(CLIENT_KEY_REQUEST_HEADER_NAME, this.mClientKey));
        r100.add(new Header(KMS_VERSION_REQUEST_HEADER_NAME, this.mKmsVersion));
        if (r101 == null) goto L20;
        r101.addClientKeyEnd();
        return;
    L20:
        return;
    }

    public synchronized void UpdateClientKeyAndSessionInfo(Request r100, Response r101) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (mKevaStorage != null) goto L6;
    L22:
        monitor-exit(this);
        return;
    L6:
        if (mClientKeySignEnabled == false) goto L22;
        if (r100.getMetrics() == null) goto L27;
        r100.getMetrics().updateClientKeyStart();     // Catch: Throwable -> L24
    L27:
        UpdateClientKeyAndSessionInfoInner(r100, r101);     // Catch: Throwable -> L17
    L13:
        if (r100.getMetrics() == null) goto L15;
        r100.getMetrics().updateClientKeyEnd();     // Catch: Throwable -> L24
    L15:
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        if (r100.getMetrics() == null) goto L21;
        r100.getMetrics().updateClientKeyEnd();     // Catch: Throwable -> L24
    L21:
        throw th;     // Catch: Throwable -> L24
    }

    private static String ReplaceMaxAgeTime(String[] r110, long r111, String r112) {
        if (r110 != null) goto L5;
    L33:
        return null;
    L5:
        if (r110.length < 2) goto L33;
        long r100 = 0;
        if (r111 <= 0) goto L33;
        int r101 = r110.length;
        int r102 = 0;
    L11:
        if (r102 >= r101) goto L18;
        String r103 = r110[r102];
        if (TextUtils.isEmpty(r103) == true) goto L17;
        if (r103.toLowerCase().trim().startsWith(MAX_AGE_NAME.toLowerCase()) == false) goto L17;
        String[] r113 = r103.split(ContainerUtils.KEY_VALUE_DELIMITER);
    L19:
        if (r113 == null) goto L33;
        if (r113.length != 2) goto L33;
        long r104 = CastLongProtector.parseLong(r113[1]);     // Catch: Throwable -> L34
        if (r104 > 0) goto L27;
        return null;
    L27:
        long r105 = r104 - ((System.currentTimeMillis() - r111) / 1000);     // Catch: Throwable -> L34
        if (r105 <= 0) goto L31;
        r100 = r105;
    L31:
        return r112.replaceFirst(r103.trim(), MAX_AGE_NAME + r100);
    L17:
        r102 = r102 + 1;
        goto L11
    L18:
        r113 = null;
        r103 = null;
        goto L19
    }

    private void refreshSessionCookie(String r100, CookieHandler r101, URI r102) throws IOException {
        if (this.mRewriteSessionEnabled == true) goto L5;
        return;
    L5:
        Map<String, List<String>> r103 = new LinkedHashMap();
        ArrayList r104 = new ArrayList();
        r104.add(r100);
        r103.put("Set-Cookie", r104);
        r101.put(r102, r103);
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "Refresh session cookie: " + r100);
        return;
    }

    private void reportClientKeyLog(int r100, String r101, String r102, String r103, String r104, String r105, String r106, Response r110, String r111) throws Exception {
        JSONObject r107 = new JSONObject();
        r107.put("origin_sid", r101);
        r107.put(WsConstants.KEY_SESSION_ID, r102);
        r107.put("origin_key", r103);
        r107.put("key", r104);
        r107.put("origin_kms", r105);
        r107.put("kms", r106);
        if (r110 == null) goto L7;
        String r108 = ((appendHeaderString(r110, "x-tt-token") + appendHeaderString(r110, NetResponse.HEADER_KEY_LOG_ID)) + appendHeaderString(r110, CLIENT_KEY_RESPONSE_HEADER_NAME)) + appendHeaderString(r110, KMS_VERSION_RESPONSE_HEADER_NAME);
        if (TextUtils.isEmpty(r108) == true) goto L7;
        r107.put("headers", r108);
    L7:
        TTReportAllLog.reportInternalAllLog("client_key", r107, r100, r111);
    }
}

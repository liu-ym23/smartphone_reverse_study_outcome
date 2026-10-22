package com.bytedance.ttnet.clientkey;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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
        return constructClientKeyHeaders(mKevaStorage.getString(CLIENT_KEY_NAME, XmlPullParser.NO_NAMESPACE), mKevaStorage.getString(KMS_VERSION_NAME, XmlPullParser.NO_NAMESPACE));
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
        this.mClientKey = XmlPullParser.NO_NAMESPACE;
        this.mSessionId = XmlPullParser.NO_NAMESPACE;
        this.mSessionUrl = XmlPullParser.NO_NAMESPACE;
        this.mKmsVersion = XmlPullParser.NO_NAMESPACE;
        this.mRewriteSessionEnabled = true;
    }

    private void ParseClientKeyConfig(JSONObject r7) throws Exception {
        int r1 = 0;
        boolean r2 = true;
        if (r7.optInt("client_key_sign_enabled", 0) <= 0) goto L5;
        boolean r0 = true;
    L6:
        mClientKeySignEnabled = r0;
        if (mClientKeySignEnabled == true) goto L14;
        if (Logger.debug() == false) goto L11;
        Logger.d(TAG, "clear client key storage.");
    L11:
        mKevaStorage.clear();
        return;
    L14:
        if (r7.optInt("rewrite_session_enabled", 1) > 0) goto L17;
        r2 = false;
    L17:
        this.mRewriteSessionEnabled = r2;
        this.mUpdateHostList.clear();
        String r3 = r7.optString("update_host_list", null);
        if (TextUtils.isEmpty(r3) == true) goto L26;
        JSONArray r4 = new JSONArray(r3);
        int r5 = 0;
    L21:
        if (r5 >= r4.length()) goto L26;
        String r6 = JSONArrayProtectorUtils.getString(r4, r5);
        if (TextUtils.isEmpty(r6) == true) goto L25;
        this.mUpdateHostList.add(r6);
    L25:
        r5 = r5 + 1;
    L26:
        this.mUpdatePathList.clear();
        String r8 = r7.optString("update_path_list", null);
        if (TextUtils.isEmpty(r8) == true) goto L35;
        JSONArray r9 = new JSONArray(r8);
    L30:
        if (r1 >= r9.length()) goto L42;
        String r10 = JSONArrayProtectorUtils.getString(r9, r1);
        if (TextUtils.isEmpty(r10) == true) goto L34;
        this.mUpdatePathList.add(r10);
    L34:
        r1 = r1 + 1;
        goto L30
    L42:
        return;
    L35:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void UpdateCookieInfo(String r7) {
        CookieHandler r2 = CookieHandler.getDefault();
        if (r2 != null) goto L25;
        return;
    L25:
        URI r3 = l.b(this.mSessionUrl);     // Catch: Throwable -> L24
        if (r3 != null) goto L8;
        return;
    L8:
        Map<String, List<String>> r4 = r2.get(r3, null);     // Catch: Throwable -> L24
        if (r4 != null) goto L11;
        return;
    L11:
        if (r4.isEmpty() == false) goto L13;
        return;
    L13:
        if (r4.containsKey("Cookie") == false) goto L28;
        String r0 = r4.get("Cookie").toString();     // Catch: Throwable -> L24
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "cookieStr: " + r0 + " sessionId: " + this.mSessionId);     // Catch: Throwable -> L24
    L18:
        if (TextUtils.isEmpty(r0) == false) goto L20;
        refreshSessionCookie(r7, r2, r3);     // Catch: Throwable -> L24
        SendCookieMismatchLog("empty", r7);     // Catch: Throwable -> L24
        return;
    L20:
        if (r0.contains(this.mSessionId) == true) goto L29;
        refreshSessionCookie(r7, r2, r3);     // Catch: Throwable -> L24
        SendCookieMismatchLog(r0, r7);     // Catch: Throwable -> L24
        return;
    L29:
        return;
    L28:
        return;
    }

    public void InitClientKeyAndSessionInfo(boolean r7) {
        sIsMainProcess = r7;
        mKevaStorage = Keva.getRepo(CLIENT_KEY_CONFIG_FILE_NAME, 1);     // Catch: Throwable -> L5
    L7:
        Keva r8 = mKevaStorage;
        if (r8 != null) goto L10;
        return;
    L10:
        String r9 = r8.getString(CLIENT_KEY_CONFIG_NAME, XmlPullParser.NO_NAMESPACE);
        if (TextUtils.isEmpty(r9) == true) goto L16;
        ParseClientKeyConfig(new JSONObject(r9));     // Catch: Throwable -> L14
    L16:
        if (mClientKeySignEnabled == true) goto L18;
        return;
    L18:
        String r0 = mKevaStorage.getString(SESSION_ID_NAME, XmlPullParser.NO_NAMESPACE);
        long r2 = mKevaStorage.getLong(SESSION_TIME_NAME, 0);
        this.mSessionUrl = mKevaStorage.getString(SESSION_URL_NAME, XmlPullParser.NO_NAMESPACE);
        this.mClientKey = mKevaStorage.getString(CLIENT_KEY_NAME, XmlPullParser.NO_NAMESPACE);
        String r1 = mKevaStorage.getString(KMS_VERSION_NAME, XmlPullParser.NO_NAMESPACE);
        this.mKmsVersion = r1;
        sClientKeyHeaders = constructClientKeyHeaders(this.mClientKey, r1);
        if (r0.isEmpty() == false) goto L21;
        return;
    L21:
        if (this.mSessionUrl.isEmpty() == true) goto L44;
        String[] r3 = r0.split(";");
        if (r3 == null) goto L29;
        if (r3.length <= 0) goto L29;
        this.mSessionId = r3[0].trim();
    L29:
        if (TextUtils.isEmpty(this.mSessionId) == false) goto L31;
        return;
    L31:
        String r4 = ReplaceMaxAgeTime(r3, r2, r0);
        if (TextUtils.isEmpty(r4) == true) goto L35;
        r0 = r4;
    L35:
        if (Logger.debug() == false) goto L37;
        Logger.d(TAG, "client key: " + this.mClientKey + " | kms version: " + this.mKmsVersion + " | session cookie: " + r0 + " | sessionid: " + this.mSessionId + " | session time: " + r2 + " session url: " + this.mSessionUrl + " config: " + r9);
    L37:
        UpdateCookieInfo(r0);
        return;
    L44:
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public void OnNetConfigChanged(Object r6) {
        if (mKevaStorage != null) goto L5;
        return;
    L5:
        if (JsonOptConfig.isValid(r6) == false) goto L26;
        JSONObject r7 = JsonOptConfig.jsonObject(r6);     // Catch: Throwable -> L23
        if (r7 == null) goto L11;
        JSONObject r8 = JSONObjectProtectorUtils.getJSONObject(r7, "data").optJSONObject(CLIENT_KEY_CONFIG_NAME);     // Catch: Throwable -> L23
    L12:
        if (r8 == null) goto L14;
        String r2 = r8.toString();     // Catch: Throwable -> L23
        if (Logger.debug() == false) goto L21;
        Logger.d(TAG, "config: " + r2);     // Catch: Throwable -> L23
    L21:
        mKevaStorage.storeString(CLIENT_KEY_CONFIG_NAME, r2);     // Catch: Throwable -> L23
        ParseClientKeyConfig(r8);     // Catch: Throwable -> L23
        return;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d(TAG, "clear client key storage.");     // Catch: Throwable -> L23
    L16:
        mClientKeySignEnabled = false;     // Catch: Throwable -> L23
        mKevaStorage.clear();     // Catch: Throwable -> L23
        return;
    L11:
        r8 = null;
        goto L12
    L27:
        return;
    }

    private void SendCookieMismatchLog(String r6, String r7) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("report_time", System.currentTimeMillis() + XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L4
        r0.put("cookie_line", r6);     // Catch: Throwable -> L4
        r0.put(SESSION_ID_NAME, r7);     // Catch: Throwable -> L4
        r0.put("url", this.mSessionUrl);     // Catch: Throwable -> L4
        TTReportAllLog.reportInternalAllLog("cookie_mismatch", r0);     // Catch: Throwable -> L4
        return;
    }

    private void UpdateClientKeyAndSessionInfoInner(Request r16, Response r17) {
        URI r0 = l.b(r16.getUrl());     // Catch: Throwable -> L5
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (this.mUpdateHostList.isEmpty() == true) goto L20;
        Iterator<String> r1 = this.mUpdateHostList.iterator();
    L12:
        if (r1.hasNext() == false) goto L16;
        if (UrlUtils.matchPattern(r0.getHost(), r1.next()) == false) goto L12;
        boolean r2 = true;
    L17:
        if (r2 == true) goto L20;
        return;
    L16:
        r2 = false;
    L20:
        if (this.mUpdatePathList.isEmpty() == true) goto L27;
        Iterator<String> r3 = this.mUpdatePathList.iterator();
    L23:
        if (r3.hasNext() == false) goto L27;
        if (UrlUtils.matchPattern(r0.getPath(), r3.next()) == false) goto L23;
        boolean r4 = true;
    L28:
        if (r4 == true) goto L30;
        return;
    L30:
        List r5 = r17.headers("Set-Cookie");
        if (r5 != null) goto L33;
    L40:
        String r11 = XmlPullParser.NO_NAMESPACE;
    L41:
        String[] r6 = r11.split(";");
        if (r6 != null) goto L44;
    L46:
        String r12 = XmlPullParser.NO_NAMESPACE;
    L48:
        if (TextUtils.isEmpty(r12) == false) goto L51;
        return;
    L51:
        if (Logger.debug() == false) goto L53;
        Logger.d(TAG, "original sessionid: " + this.mSessionId + " new sessionid: " + r12);
    L53:
        Header r7 = r17.getFirstHeader(CLIENT_KEY_RESPONSE_HEADER_NAME);
        Header r8 = r17.getFirstHeader(KMS_VERSION_RESPONSE_HEADER_NAME);
        if (r7 == null) goto L64;
        if (r8 == null) goto L64;
        String r9 = r7.getValue();
        String r10 = r8.getValue();
        if (TextUtils.isEmpty(r9) == false) goto L59;
    L62:
        String r13 = XmlPullParser.NO_NAMESPACE;
        String r14 = r13;
        int r15 = 1;
    L67:
        if (r15 != 0) goto L75;
    L71:
        this.mClientKey = r13;
        this.mKmsVersion = r14;
        String r18 = r16.getUrl();
        this.mSessionUrl = r18;
        this.mSessionId = r12;
        mKevaStorage.storeString(SESSION_URL_NAME, r18);
        mKevaStorage.storeString(SESSION_ID_NAME, r11);
        mKevaStorage.storeString(CLIENT_KEY_NAME, this.mClientKey);
        mKevaStorage.storeString(KMS_VERSION_NAME, this.mKmsVersion);
        mKevaStorage.storeLong(SESSION_TIME_NAME, System.currentTimeMillis());
        sClientKeyHeaders = constructClientKeyHeaders(this.mClientKey, this.mKmsVersion);
        if (Logger.debug() == false) goto L88;
        Logger.d(TAG, "save session url: " + this.mSessionUrl + " session cookie: " + r11 + " client key: " + this.mClientKey + " kms version: " + this.mKmsVersion);
        return;
    L88:
        return;
    L75:
        reportClientKeyLog(r15, this.mSessionId, r12, this.mClientKey, r13, this.mKmsVersion, r14, r17, r0.getPath());     // Catch: Throwable -> L70
        goto L71
    L59:
        if (TextUtils.isEmpty(r10) == true) goto L62;
        r13 = r9;
        r14 = r10;
        r15 = 0;
    L64:
        if (r12.equals(this.mSessionId) == false) goto L66;
        String r19 = this.mClientKey;
        r14 = this.mKmsVersion;
        r13 = r19;
        r15 = 2;
        goto L67
    L66:
        r15 = 3;
        r13 = XmlPullParser.NO_NAMESPACE;
        r14 = r13;
        goto L67
    L44:
        if (r6.length <= 0) goto L46;
        r12 = r6[0].trim();
        goto L48
    L33:
        if (r5.isEmpty() == true) goto L40;
        Iterator r20 = r5.iterator();
    L36:
        if (r20.hasNext() == false) goto L40;
        String r21 = ((Header) r20.next()).getValue().trim();
        if (r21.toLowerCase().startsWith("sessionid=") == false) goto L36;
        r11 = r21;
    L27:
        r4 = false;
    L5:
        r0 = null;
        goto L6
    }

    private static String appendHeaderString(Response r1, String r2) {
        Header r3 = r1.getFirstHeader(r2);
        if (r3 != null) goto L5;
        return XmlPullParser.NO_NAMESPACE;
    L5:
        return (XmlPullParser.NO_NAMESPACE + r3.toString()) + "; ";
    }

    private static Map<String, String> constructClientKeyHeaders(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L11;
        HashMap r0 = new HashMap();
        r0.put(CLIENT_KEY_REQUEST_HEADER_NAME, r2);
        r0.put(KMS_VERSION_REQUEST_HEADER_NAME, r3);
        return r0;
    L11:
        return null;
    }

    public void AddClientKeyHeader(List<Header> r4, RetrofitMetrics r5) {
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
        if (r5 == null) goto L13;
        r5.addClientKeyStart();
    L13:
        r4.add(new Header(CLIENT_KEY_REQUEST_HEADER_NAME, this.mClientKey));
        r4.add(new Header(KMS_VERSION_REQUEST_HEADER_NAME, this.mKmsVersion));
        if (r5 == null) goto L20;
        r5.addClientKeyEnd();
        return;
    L20:
        return;
    }

    public synchronized void UpdateClientKeyAndSessionInfo(Request r2, Response r3) {
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
        if (r2.getMetrics() == null) goto L27;
        r2.getMetrics().updateClientKeyStart();     // Catch: Throwable -> L24
    L27:
        UpdateClientKeyAndSessionInfoInner(r2, r3);     // Catch: Throwable -> L17
    L13:
        if (r2.getMetrics() == null) goto L15;
        r2.getMetrics().updateClientKeyEnd();     // Catch: Throwable -> L24
    L15:
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        if (r2.getMetrics() == null) goto L21;
        r2.getMetrics().updateClientKeyEnd();     // Catch: Throwable -> L24
    L21:
        throw th;     // Catch: Throwable -> L24
    }

    private static String ReplaceMaxAgeTime(String[] r10, long r11, String r13) {
        if (r10 != null) goto L5;
    L33:
        return null;
    L5:
        if (r10.length < 2) goto L33;
        long r3 = 0;
        if (r11 <= 0) goto L33;
        int r1 = r10.length;
        int r5 = 0;
    L11:
        if (r5 >= r1) goto L18;
        String r7 = r10[r5];
        if (TextUtils.isEmpty(r7) == true) goto L17;
        if (r7.toLowerCase().trim().startsWith(MAX_AGE_NAME.toLowerCase()) == false) goto L17;
        String[] r12 = r7.split("=");
    L19:
        if (r12 == null) goto L33;
        if (r12.length != 2) goto L33;
        long r2 = CastLongProtector.parseLong(r12[1]);     // Catch: Throwable -> L34
        if (r2 > 0) goto L27;
        return null;
    L27:
        long r4 = r2 - ((System.currentTimeMillis() - r11) / 1000);     // Catch: Throwable -> L34
        if (r4 <= 0) goto L31;
        r3 = r4;
    L31:
        return r13.replaceFirst(r7.trim(), MAX_AGE_NAME + r3);
    L17:
        r5 = r5 + 1;
        goto L11
    L18:
        r12 = null;
        r7 = null;
        goto L19
    }

    private void refreshSessionCookie(String r4, CookieHandler r5, URI r6) throws IOException {
        if (this.mRewriteSessionEnabled == true) goto L5;
        return;
    L5:
        Map<String, List<String>> r0 = new LinkedHashMap();
        ArrayList r1 = new ArrayList();
        r1.add(r4);
        r0.put("Set-Cookie", r1);
        r5.put(r6, r0);
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "Refresh session cookie: " + r4);
        return;
    }

    private void reportClientKeyLog(int r3, String r4, String r5, String r6, String r7, String r8, String r9, Response r10, String r11) throws Exception {
        JSONObject r0 = new JSONObject();
        r0.put("origin_sid", r4);
        r0.put("sid", r5);
        r0.put("origin_key", r6);
        r0.put("key", r7);
        r0.put("origin_kms", r8);
        r0.put("kms", r9);
        if (r10 == null) goto L7;
        String r12 = ((appendHeaderString(r10, "x-tt-token") + appendHeaderString(r10, "x-tt-logid")) + appendHeaderString(r10, CLIENT_KEY_RESPONSE_HEADER_NAME)) + appendHeaderString(r10, KMS_VERSION_RESPONSE_HEADER_NAME);
        if (TextUtils.isEmpty(r12) == true) goto L7;
        r0.put("headers", r12);
    L7:
        TTReportAllLog.reportInternalAllLog(CLIENT_KEY_NAME, r0, r3, r11);
    }
}

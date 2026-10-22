package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.a;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import com.ttnet.org.chromium.base.TimeUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
class WXAPiSecurityHelper {
    private static final int MAX_STORE_KEY = 100;
    private static final int MAX_STORE_VALUE = 2048;
    private static final String SECURITY_KEY_TIMESTAMP_SECOND = "security_key_timestamp_second";
    private static final String STORE_VALUE_DATA = "security_key_resp";
    private static final String TAG = "MicroMsg.SDK.WXAPiSecurityHelper";
    private final Context context;
    private final CopyOnWriteArraySet<String> overtimeSyncReqSet;

    /* JADX INFO: renamed from: sp, reason: collision with root package name */
    private final SharedPreferences f461635sp;

    public static class CheckRuleResult {
        public static final int NoPass = 2;
        public static final int Pass = 1;
        public static final int Unknown = 0;

        private CheckRuleResult() {
        }
    }

    public static class ExtraSecurityCheckRes {
        public static final int Directly_NoPass = 1;
        public static final int Directly_Pass = 0;
        public static final int Need_Deep_Check = 2;

        public ExtraSecurityCheckRes() {
        }
    }

    public interface IHttpCheckCallback {
        void onHttpCheckFinish(PromiseShareRule r100);
    }

    public interface ISecurityCheck {
        void onCheckFinish(boolean r100);
    }

    public interface ISecuritySyncCheck {
        void onSyncCheckFinish(boolean r100);
    }

    public static class PassContext {
        String appid;
        String inputUrl;
        PromiseShareRule localRule;
        String reqSessionId;
        String version;

        private PassContext() {
            this.reqSessionId = "";
            this.appid = "";
            this.inputUrl = "";
            this.version = "";
            this.localRule = new PromiseShareRule(null);
        }

        public /* synthetic */ PassContext(AnonymousClass1 r100) {
            this();
        }
    }

    public static class PromiseShareRule {
        String appidInRule;
        String buffer;
        public long nextRequestIntervalSecond;
        String orgJsonData;
        String reqAppid;
        int state;
        List<UrlRule> urlRuleList;
        long userWaitTimeMs;

        private PromiseShareRule() {
            this.orgJsonData = "";
            this.reqAppid = "";
            this.appidInRule = "";
            this.urlRuleList = new ArrayList();
            this.buffer = "";
        }

        public /* synthetic */ PromiseShareRule(AnonymousClass1 r100) {
            this();
        }

        public long getLegalReqInterval() {
            long r100 = this.nextRequestIntervalSecond;
            if (r100 > 0) goto L5;
        L7:
            r100 = TimeUtils.SECONDS_PER_HOUR;
        L8:
            Log.d(WXAPiSecurityHelper.TAG, "getLegalReqInterval = " + r100);
            return r100;
        L5:
            if (r100 >= 86400) goto L7;
            goto L7
        }

        public long getLegalUserWaitTime() {
            long r100 = this.userWaitTimeMs;
            if (r100 > 100) goto L5;
        L7:
            r100 = 5000;
        L8:
            Log.d(WXAPiSecurityHelper.TAG, "getLegalUserWaitTime = " + r100);
            return r100;
        L5:
            if (r100 >= 60000) goto L7;
            goto L7
        }
    }

    public static class RuleState {
        public static final int InRule = 1;
        public static final int None = 0;
        public static final int NotInRule = 2;

        private RuleState() {
        }
    }

    public static class UrlRule {
        String host;
        List<String> mustQueryKey;

        private UrlRule() {
            this.host = "";
            this.mustQueryKey = new ArrayList();
        }

        public /* synthetic */ UrlRule(AnonymousClass1 r100) {
            this();
        }
    }

    public static class WXSecurityData {
        String appid;
        long lastStoreTimeStampSecond;
        String respDataJson;

        private WXSecurityData() {
            this.appid = "";
            this.respDataJson = "";
        }

        public /* synthetic */ WXSecurityData(AnonymousClass1 r100) {
            this();
        }

        public boolean isBasicParamsAllowed() {
            long r100 = this.lastStoreTimeStampSecond;
            if (r100 > 0) goto L5;
        L7:
            boolean r101 = false;
        L8:
            boolean r102 = !b.b(this.appid);
            boolean r103 = !b.b(this.respDataJson);
            if (r101 == false) goto L14;
            if (r102 == false) goto L15;
            if (r103 == false) goto L16;
            return true;
        L16:
            return false;
        L15:
            return false;
        L14:
            return false;
        L5:
            if (r100 >= (System.currentTimeMillis() / 1000)) goto L7;
            r101 = true;
            goto L8
        }
    }

    public WXAPiSecurityHelper(Context r100) {
        this.overtimeSyncReqSet = new CopyOnWriteArraySet();
        this.context = r100;
        this.f461635sp = r100.getSharedPreferences("__wx_opensdk_sp__", 0);
    }

    public static /* synthetic */ void access$200(WXAPiSecurityHelper r100, ISecurityCheck r101, boolean r102) {
        r100.extraSecurityCheckDoCallback(r101, r102);
    }

    public static /* synthetic */ void access$300(WXAPiSecurityHelper r100, PromiseShareRule r101) {
        r100.storeIfNecessary(r101);
    }

    public static /* synthetic */ CopyOnWriteArraySet access$400(WXAPiSecurityHelper r100) {
        return r100.overtimeSyncReqSet;
    }

    public static /* synthetic */ int access$500(WXAPiSecurityHelper r100, String r101, PromiseShareRule r102) {
        return r100.checkRuleCanPass(r101, r102);
    }

    private int checkRuleCanPass(String r100, PromiseShareRule r101) {
        Log.d(TAG, "checkRuleCanPass, start check!");
        if (r101.orgJsonData.length() <= 2048) goto L6;
        Log.w(TAG, "response json is too long!");
        return 0;
    L6:
        int r102 = r101.state;
        if (r102 != 2) goto L11;
        String r103 = "checkRuleCanPass, not in rule";
    L9:
        Log.d(TAG, r103);
        return 1;
    L11:
        if (r102 == 1) goto L13;
    L22:
        Log.d(TAG, "checkRuleCanPass, unknown");
        return 0;
    L13:
        if (r101.appidInRule.equals(r101.reqAppid) == false) goto L22;
        if (r101.urlRuleList.size() != 0) goto L17;
        r103 = "checkRuleCanPass, urlRuleList empty!";
        goto L9
    L17:
        boolean r104 = checkUrlParametersLegal(r100, r101);
        Log.d(TAG, "checkRuleCanPass, urlCheckResult = " + r104);
        if (r104 == true) goto L21;
        Log.d(TAG, "checkRuleCanPass, no pass");
        return 2;
    L21:
        r103 = "checkRuleCanPass, pass";
        goto L9
    }

    private boolean checkUrlParametersLegal(String r110, PromiseShareRule r111) {
        Uri r112 = UriProtector.parse(r110);
        String r100 = r112.getHost();
        if (b.b(r100) == false) goto L6;
        Log.i(TAG, "checkUrlParameters, host empty!");
        return false;
    L6:
        int r101 = 0;
    L8:
        if (r101 >= r111.urlRuleList.size()) goto L28;
        UrlRule r102 = (UrlRule) ListProtector.get(r111.urlRuleList, r101);
        if (r100.equals(r102.host) == false) goto L27;
        int r103 = 0;
        int r104 = 0;
    L29:
    L25:
        e = move-exception;
        Log.e(TAG, "checkRuleCanPass, parse fail, e = %s" + e.getMessage());
        goto L27
    L14:
        if (r103 >= r102.mustQueryKey.size()) goto L20;
        String r105 = (String) ListProtector.get(r102.mustQueryKey, r103);     // Catch: Exception -> L25
        Log.d(TAG, "checkRuleCanPass, key = " + r105);     // Catch: Exception -> L25
        if (b.b(UriProtector.getQueryParameter(r112, r105)) == true) goto L18;
        r104 = r104 + 1;     // Catch: Exception -> L25
    L18:
        r103 = r103 + 1;     // Catch: Exception -> L25
        goto L29
    L20:
        if (r104 != r102.mustQueryKey.size()) goto L22;
        boolean r106 = true;
    L23:
        Log.d(TAG, "checkRuleCanPass, rule.host = " + r102.host + ", queryOk = " + r106);     // Catch: Exception -> L25
        return r106;
    L22:
        r106 = false;
    L27:
        r101 = r101 + 1;
        goto L8
    L28:
        return false;
    }

    private void doRequest(final PassContext r100, final IHttpCheckCallback r101) {
        b.f461638b.submit(new AnonymousClass6(this, r100, r101));
    }

    private void doRequestAsync(PassContext r100) {
        Log.d(TAG, "doRequestAsync");
        doRequest(r100, new AnonymousClass3(this));
    }

    private void doRequestSync(final PassContext r100, final ISecuritySyncCheck r101) {
        Log.i(TAG, "requestId = " + r100.reqSessionId);
        final PthreadTimer r102 = new PthreadTimer(r100.reqSessionId);
        r102.schedule(new AnonymousClass4(this, r100, r101), r100.localRule.getLegalUserWaitTime());
        doRequest(r100, new AnonymousClass5(this, r102, r100, r101));
    }

    private void extraSecurityCheckDoCallback(final ISecurityCheck r100, final boolean r101) {
        if (r100 == null) goto L5;
        new Handler(Looper.getMainLooper()).post(new AnonymousClass2(this, r100, r101));
        return;
    }

    private String getStoreKey(String r100) {
        return "security_key_appid_" + r100;
    }

    private void storeCheckResp(String r100, PromiseShareRule r101) {
        String r102 = cookStoreJson(r100, r101);
        Log.d(TAG, "cookStoreJson = " + r102);
        if (b.b(r102) == false) goto L13;
        Log.w(TAG, "cookStoreJson get null!");
        return;
    L13:
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L10
        r103.put(SECURITY_KEY_TIMESTAMP_SECOND, System.currentTimeMillis() / 1000);     // Catch: Exception -> L10
        r103.put(STORE_VALUE_DATA, r102);     // Catch: Exception -> L10
        commitSp(r100, r103.toString());     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Log.e(TAG, "storeCheckResp fail, ex = " + e.getMessage());
    }

    private void storeIfNecessary(PromiseShareRule r100) {
        Log.d(TAG, "storeIfNecessary");
        if (b.b(r100.reqAppid) == false) goto L5;
    L24:
        String r101 = "store fail! reqAppid illegal!";
    L22:
        Log.i(TAG, r101);
        return;
    L5:
        if (r100.reqAppid.length() > 100) goto L24;
        if (b.b(r100.orgJsonData) == false) goto L10;
    L21:
        r101 = "store fail! response json illegal!";
        goto L22
    L10:
        if (r100.orgJsonData.length() > 2048) goto L21;
        if (r100.state != 1) goto L18;
        if (r100.reqAppid.equals(r100.appidInRule) == false) goto L18;
        Log.d(TAG, "storeIfNecessary, in rule");
        storeCheckResp(r100.reqAppid, r100);
    L18:
        if (r100.state != 2) goto L25;
        Log.d(TAG, "storeIfNecessary, not rule");
        storeCheckResp(r100.reqAppid, r100);
        return;
    }

    public void commitSp(String r100, String r101) {
        SharedPreferences.Editor r102 = this.f461635sp.edit();
        r102.putString(getStoreKey(r100), r101);
        r102.commit();
    }

    public PromiseShareRule convert2ShareRule(String r110, String r111) {
        AnonymousClass1 r100 = null;
        PromiseShareRule r101 = new PromiseShareRule(r100);
        r101.reqAppid = r110;
        r101.orgJsonData = r111;
        if (b.b(r111) == false) goto L25;
        Log.d(TAG, "convert2ShareRule: jsonRespData is empty");
        return r101;
    L25:
        JSONObject r112 = new JSONObject(r111);     // Catch: Exception -> L22
        r101.state = r112.optInt("state", 0);     // Catch: Exception -> L22
        r101.appidInRule = r112.optString("appid_rule", "");     // Catch: Exception -> L22
        r101.userWaitTimeMs = r112.optLong("wait_time", 0);     // Catch: Exception -> L22
        r101.nextRequestIntervalSecond = r112.optLong(VideoThumbInfo.KEY_INTERVAL, 0);     // Catch: Exception -> L22
        r101.buffer = r112.optString("buffer", "");     // Catch: Exception -> L22
        JSONArray r113 = r112.optJSONArray("rules");     // Catch: Exception -> L22
        if (r113 == null) goto L24;
        int r114 = 0;
    L9:
        if (r114 >= r113.length()) goto L24;
        JSONObject r102 = JSONArrayProtectorUtils.getJSONObject(r113, r114);     // Catch: Exception -> L22
        UrlRule r103 = new UrlRule(r100);     // Catch: Exception -> L22
        r103.host = r102.optString("host");     // Catch: Exception -> L22
        JSONArray r104 = r102.optJSONArray("querys");     // Catch: Exception -> L22
        if (r104 == null) goto L20;
        int r105 = 0;
    L15:
        if (r105 >= r104.length()) goto L20;
        if (b.b(r104.optString(r105, "")) == true) goto L19;
        r103.mustQueryKey.add(r104.optString(r105, ""));     // Catch: Exception -> L22
    L19:
        r105 = r105 + 1;     // Catch: Exception -> L22
    L20:
        r101.urlRuleList.add(r103);     // Catch: Exception -> L22
        r114 = r114 + 1;
    L24:
        return r101;
    L22:
        e = move-exception;
        Log.e(TAG, "coverJson2ShareRule fail, ex = " + e.getMessage());
        goto L24
    }

    public String cookStoreJson(String r100, PromiseShareRule r101) {
        if (r101 != null) goto L5;
    L27:
        return "";
    L5:
        if (b.b(r100) == true) goto L27;
        int r102 = r101.state;     // Catch: Exception -> L25
        if (r102 != 2) goto L21;
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L25
        r103.put("state", r101.state);     // Catch: Exception -> L25
        r103.put(VideoThumbInfo.KEY_INTERVAL, r101.getLegalReqInterval());     // Catch: Exception -> L25
        if (r101.buffer.length() <= 64) goto L18;
        String r104 = "";
    L19:
        r103.put("buffer", r104);     // Catch: Exception -> L25
        String r105 = r103.toString();     // Catch: Exception -> L25
    L24:
        return r105;
    L18:
        r104 = r101.buffer;     // Catch: Exception -> L25
        goto L19
    L21:
        if (r102 != 1) goto L29;
        r105 = covertShareRule2Json(r101);     // Catch: Exception -> L25
        goto L24
    L29:
        return "";
    L25:
        e = move-exception;
        Log.e(TAG, "storeCheckResp fail, ex = " + e.getMessage());
        goto L27
    }

    public String covertShareRule2Json(PromiseShareRule r100) {
        if (r100 != null) goto L32;
        return "";
    L32:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L29
        r101.put("state", r100.state);     // Catch: Exception -> L29
        r101.put("appid_rule", r100.appidInRule);     // Catch: Exception -> L29
        r101.put("wait_time", r100.userWaitTimeMs);     // Catch: Exception -> L29
        r101.put(VideoThumbInfo.KEY_INTERVAL, r100.nextRequestIntervalSecond);     // Catch: Exception -> L29
        if (r100.buffer.length() <= 64) goto L18;
        Object r102 = "";
    L19:
        r101.put("buffer", r102);     // Catch: Exception -> L29
        JSONArray r103 = new JSONArray();     // Catch: Exception -> L29
        Iterator<UrlRule> r104 = r100.urlRuleList.iterator();     // Catch: Exception -> L29
    L21:
        if (r104.hasNext() == false) goto L27;
        UrlRule r105 = r104.next();     // Catch: Exception -> L29
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L29
        r106.put("host", r105.host);     // Catch: Exception -> L29
        r106.put("querys", new JSONArray(r105.mustQueryKey));     // Catch: Exception -> L29
        r103.put(r106);     // Catch: Exception -> L29
        goto L21
    L27:
        r101.put("rules", r103);     // Catch: Exception -> L29
        return r101.toString();
    L18:
        r102 = r100.buffer;     // Catch: Exception -> L29
    L29:
        e = move-exception;
        Log.e(TAG, "covertShareRule2Json fail, ex = " + e.getMessage());
        return "";
    }

    public int doExtraSecurityCheck(String r100, String r110, String r111, final ISecurityCheck r112) {
        Log.i(TAG, "doExtraSecurityCheck: start!");
        if (b.b(r100) == false) goto L5;
    L31:
        Log.e(TAG, "doExtraSecurityCheck: appid or inputurl is empty!");
        return 0;
    L5:
        if (b.b(r111) == true) goto L31;
        long r101 = System.currentTimeMillis();
        PassContext r102 = new PassContext(null);
        r102.reqSessionId = String.format("%s", new Object[]{r101 + "" + new Random().nextInt(9999)});
        r102.appid = r100;
        r102.inputUrl = r111;
        r102.version = r110;
        WXSecurityData r103 = getStoredData(r100);
        if (this.context.getPackageManager().checkPermission("android.permission.INTERNET", this.context.getPackageName()) == 0) goto L12;
        Log.w(TAG, "doExtraSecurityCheck: No Internet permission!");
        return 0;
    L12:
        if (r103.isBasicParamsAllowed() == true) goto L15;
        Log.d(TAG, "doExtraSecurityCheck: local data illegal!");
        doRequestAsync(r102);
        return 0;
    L15:
        PromiseShareRule r113 = convert2ShareRule(r102.appid, r103.respDataJson);
        r102.localRule = r113;
        if (((r103.lastStoreTimeStampSecond + r113.getLegalReqInterval()) * 1000) >= System.currentTimeMillis()) goto L18;
        boolean r114 = true;
    L19:
        Log.d(TAG, "doExtraSecurityCheck: needDoNextReq: " + r114 + ", last req time stamp:" + r103.lastStoreTimeStampSecond);
        if (r114 == true) goto L25;
        int r115 = checkRuleCanPass(r102.inputUrl, r102.localRule);
        Log.d(TAG, "doExtraSecurityCheck: no needDoNextReq, read local rule: " + r115);
        if (r115 != 2) goto L24;
        return 1;
    L24:
        return 0;
    L25:
        Log.d(TAG, "doExtraSecurityCheck: needDoNextReq, state: " + r102.localRule.state);
        if (r102.localRule.state == 1) goto L29;
        doRequestAsync(r102);
        return 0;
    L29:
        doRequestSync(r102, new AnonymousClass1(this, r112));
        return 2;
    L18:
        r114 = false;
        goto L19
    }

    public String extractMayNeedDoSecurityCheckUrl(String r100, BaseReq r101) {
        if (r101.getType() == 2) goto L5;
        return "";
    L5:
        SendMessageToWX.Req r102 = (SendMessageToWX.Req) r101;
        if (r102.message.getType() == 5) goto L8;
        return "";
    L8:
        WXWebpageObject r103 = (WXWebpageObject) r102.message.mediaObject;
        if (b.b(r103.webpageUrl) == false) goto L12;
        Log.i(TAG, "webpageUrl empty, don't need check.");
        return "";
    L12:
        Log.i(TAG, "need check.");
        return r103.webpageUrl;
    }

    public String getLocalStoredJson(String r100) {
        return getStoredData(r100).respDataJson;
    }

    public WXSecurityData getStoredData(String r100) {
        WXSecurityData r101 = new WXSecurityData(null);
        Log.d(TAG, "getStoredData, appid = " + r100);
    L9:
        e = move-exception;
        Log.e(TAG, "getStoredData fail, ex = " + e.getMessage());
    L11:
        return r101;
    L4:
        if (this.f461635sp.contains(getStoreKey(r100)) == true) goto L7;
        String r102 = "getStoredData, fail, not exist!";
    L6:
        Log.d(TAG, r102);     // Catch: Exception -> L9
        goto L11
    L7:
        JSONObject r103 = new JSONObject(this.f461635sp.getString(getStoreKey(r100), ""));     // Catch: Exception -> L9
        long r104 = r103.optLong(SECURITY_KEY_TIMESTAMP_SECOND);     // Catch: Exception -> L9
        String r105 = r103.optString(STORE_VALUE_DATA);     // Catch: Exception -> L9
        r101.appid = r100;     // Catch: Exception -> L9
        r101.lastStoreTimeStampSecond = r104;     // Catch: Exception -> L9
        r101.respDataJson = r105;     // Catch: Exception -> L9
        r102 = "getStoredData, Ok, appid = " + r100 + "timeStampSecond: " + r101.lastStoreTimeStampSecond;     // Catch: Exception -> L9
        goto L6
    }

    public StringBuffer postHttpRequest(String r100, String r101, String r110) {
        StringBuffer r102 = new StringBuffer();
        String r103 = URLEncoder.encode(r100, "UTF-8");     // Catch: Exception -> L14
        String r111 = URLEncoder.encode(r110, "UTF-8");     // Catch: Exception -> L14
        String r104 = String.format("https://mp.weixin.qq.com/publicpoc/opensdkconf?action=GetShareConf&appid=%s&sdkVersion=%s&buffer=%s", new Object[]{r103, r101, r111});     // Catch: Exception -> L14
        Log.d(TAG, "request http, url = " + r104 + ", appid = " + r103 + ", version = " + r101 + ", buffer = " + r111);     // Catch: Exception -> L14
        HttpURLConnection r105 = (HttpURLConnection) INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_WXAPiSecurityHelper_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r104));     // Catch: Exception -> L14
        r105.setConnectTimeout(60000);     // Catch: Exception -> L14
        r105.setReadTimeout(60000);     // Catch: Exception -> L14
        r105.setRequestProperty("Content-Type", "application/json");     // Catch: Exception -> L14
        r105.connect();     // Catch: Exception -> L14
        int r106 = r105.getResponseCode();     // Catch: Exception -> L14
        Log.i(TAG, "http respCode = " + r106);     // Catch: Exception -> L14
        if (r106 != 200) goto L12;
        BufferedReader r107 = new BufferedReader(new InputStreamReader(r105.getInputStream()));     // Catch: Exception -> L14
    L8:
        String r112 = r107.readLine();     // Catch: Exception -> L14
        if (r112 == null) goto L11;
        r102.append(r112);     // Catch: Exception -> L14
        goto L8
    L11:
        Log.d(TAG, "http response = " + r102);     // Catch: Exception -> L14
        r107.close();     // Catch: Exception -> L14
    L12:
        r105.disconnect();     // Catch: Exception -> L14
    L16:
        return r102;
    L14:
        e = move-exception;
        Log.e(TAG, "http request fail, ex = " + e.getMessage());
        goto L16
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_WXAPiSecurityHelper_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        a.b(a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }
}

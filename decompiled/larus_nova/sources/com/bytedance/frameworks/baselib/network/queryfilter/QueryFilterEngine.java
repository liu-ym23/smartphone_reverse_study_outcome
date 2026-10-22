package com.bytedance.frameworks.baselib.network.queryfilter;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.mime.AbsTypedOutput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ux5.c;
import ux5.e;

/* JADX INFO: loaded from: classes3.dex */
public class QueryFilterEngine {
    private static final String CIPHER_VERSION_HEADER = "x-tt-cipher-version";
    private static final String CIPHER_VERSION_VALUE = "1.0.0";
    private static final String ENCRYPT_INFO_HEADER = "x-tt-encrypt-info";
    private static final String KEY_ACTION_NAME = "action";
    private static final String KEY_ACTION_PARAM = "param";
    private static final String KEY_ACTION_PRIORITY = "act_priority";
    public static final String KEY_L0_PARAMS = "L0_params";
    public static final String KEY_QUERY_FILTER_CONFIG = "query_filter_actions";
    public static final String KEY_QUERY_FILTER_ENABLED = "query_filter_enabled";
    private static final String KEY_SET_REQ_PRIORITY = "set_req_priority";
    private static final String TAG = "QueryFilterEngine";
    private static volatile QueryFilterEngine sInstance;
    private boolean mEnableNewSpaceEncodeRule;
    private List<String> mL0ParamsList;
    private volatile String mLocalConfig;
    private boolean mOptRetrofitLog;
    private List<c> mQueryFilterActions;
    private volatile boolean mQueryFilterEnabled;

    /* JADX INFO: loaded from: classes19.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f244798a = null;

        static {
            int[] r100 = new int[RetrofitMetrics.EncryptType.values().length];
            f244798a = r100;
            r100[RetrofitMetrics.EncryptType.ENCRYPT_BOTH_QUERY_AND_BODY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f244798a[RetrofitMetrics.EncryptType.ENCRYPT_BODY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f244798a[RetrofitMetrics.EncryptType.ENCRYPT_QUERY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public class b implements Comparator<c> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(c r100, c r101) {
            return r100.f551989a - r101.f551989a;
        }
    }

    public static QueryFilterEngine inst() {
        if (sInstance != null) goto L15;
        monitor-enter(QueryFilterEngine.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new QueryFilterEngine();     // Catch: Throwable -> L11
    L9:
        monitor-exit(QueryFilterEngine.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private QueryFilterEngine() {
        this.mQueryFilterEnabled = false;
        this.mQueryFilterActions = new CopyOnWriteArrayList();
        this.mL0ParamsList = new CopyOnWriteArrayList();
        this.mEnableNewSpaceEncodeRule = false;
        this.mOptRetrofitLog = true;
    }

    public boolean getEnableNewSpaceEncodeRule() {
        return this.mEnableNewSpaceEncodeRule;
    }

    public List<c> getQueryFilterActionsForTesting() {
        return this.mQueryFilterActions;
    }

    private JSONArray dispatchQueryActionInfo(List<ux5.a> r110) {
        JSONArray r100 = new JSONArray();
        Iterator<ux5.a> r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L30;
        ux5.a r101 = r111.next();
        long r102 = r101.f551982c;     // Catch: JSONException -> L27
        if (r102 < 0) goto L14;
        long r103 = r101.f551983d;     // Catch: JSONException -> L27
        if (r103 < 0) goto L14;
        if (r102 > r103) goto L14;
        long r104 = r103 - r102;     // Catch: JSONException -> L27
    L16:
        if (this.mOptRetrofitLog == false) goto L22;
        if (r101.f551980a == true) goto L22;
        if (r104 <= 0) goto L4;
    L22:
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L27
        r105.put(BaseHttpRequestInfo.KEY_HIT, r101.f551980a);     // Catch: JSONException -> L27
        r105.put("priority", r101.f551981b);     // Catch: JSONException -> L27
        if (r104 <= 0) goto L25;
        r105.put("consume", r104);     // Catch: JSONException -> L27
    L25:
        r100.put(r105);     // Catch: JSONException -> L27
    L14:
        r104 = -1;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L30:
        if (Logger.debug() == false) goto L32;
        Logger.d(TAG, "action info: " + r100.toString());
    L32:
        return r100;
    }

    private synchronized void parseCommonParamsConfig(String r100) throws JSONException {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(this.mLocalConfig) == false) goto L6;
    L12:
        ArrayList<c> r101 = new ArrayList();     // Catch: Throwable -> L19
        JSONArray r102 = new JSONArray(r100);     // Catch: Throwable -> L19
        int r103 = 0;
    L14:
        if (r103 >= r102.length()) goto L16;
        parseActionInfo(JSONArrayProtectorUtils.getJSONObject(r102, r103), r101);     // Catch: Throwable -> L19
        r103 = r103 + 1;     // Catch: Throwable -> L19
        goto L14
    L16:
        Collections.sort(r101, new b());     // Catch: Throwable -> L19
        this.mQueryFilterActions.clear();     // Catch: Throwable -> L19
        this.mQueryFilterActions.addAll(r101);     // Catch: Throwable -> L19
        this.mLocalConfig = r100;     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L6:
        if (this.mLocalConfig.equals(r100) == false) goto L12;
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "Config is same with local config, do not parse.");     // Catch: Throwable -> L19
    L10:
        monitor-exit(this);
    }

    public void enableQueryFilterEngine(boolean r100) {
        this.mQueryFilterEnabled = r100;
    }

    public Request filterQuery(Request r100) {
        if (this.mQueryFilterEnabled == true) goto L9;
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "Query filter engine is not enabled");
    L7:
        return null;
    L9:
        if (r100.isPureRequest() == false) goto L11;
        return null;
    L11:
        String r101 = r100.getUrl();
        if (TextUtils.isEmpty(r101) == false) goto L15;
        return null;
    L15:
        if (r100.getMetrics() == null) goto L74;
        r100.getMetrics().queryFilterStart();
    L74:
        LinkedHashMap r102 = new LinkedHashMap();     // Catch: Throwable -> L63
        Pair<String, String> r103 = UrlUtils.parseUrlWithValueList(r101, r102);     // Catch: Throwable -> L63
        if (r103 != null) goto L24;
        if (r100.getMetrics() == null) goto L22;
        r100.getMetrics().queryFilterEnd();
    L22:
        return null;
    L24:
        if (dispatchQueryMap(r100, r102) == true) goto L30;
        if (r100.getMetrics() == null) goto L28;
        r100.getMetrics().queryFilterEnd();
    L28:
        return null;
    L30:
        if (r100.isQueryEncryptEnabled() == true) goto L32;
    L38:
        String r104 = null;
    L39:
        UrlBuilder r105 = new UrlBuilder(((String) r103.first) + ((String) r103.second));     // Catch: Throwable -> L63
        if (r102.isEmpty() == true) goto L58;
        Iterator r106 = r102.entrySet().iterator();     // Catch: Throwable -> L63
    L43:
        if (r106.hasNext() == false) goto L58;
        Map.Entry r107 = (Map.Entry) r106.next();     // Catch: Throwable -> L63
        if (r107 == null) goto L43;
        if (r107.getKey() == null) goto L43;
        List r108 = (List) r107.getValue();     // Catch: Throwable -> L63
        if (r108 == null) goto L43;
        if (r108.isEmpty() == true) goto L43;
        Iterator r109 = r108.iterator();     // Catch: Throwable -> L63
    L56:
        if (r109.hasNext() == false) goto L43;
        r105.addParam((String) r107.getKey(), (String) r109.next());     // Catch: Throwable -> L63
    L58:
        Request.Builder r110 = r100.newBuilder();     // Catch: Throwable -> L63
        tryEncryptRequest(r110, r100, r104);     // Catch: Throwable -> L63
        r110.url(r105.build());     // Catch: Throwable -> L63
        Request r111 = r110.build();     // Catch: Throwable -> L63
        if (r100.getMetrics() == null) goto L62;
        r100.getMetrics().queryFilterEnd();
    L62:
        return r111;
    L32:
        if (r102.containsKey("x-tt-encrypt-queries") == false) goto L38;
        List r112 = (List) r102.get("x-tt-encrypt-queries");     // Catch: Throwable -> L63
        if (r112 == null) goto L38;
        if (r112.size() <= 0) goto L38;
        r104 = (String) r112.get(0);     // Catch: Throwable -> L63
        r102.remove("x-tt-encrypt-queries");     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L69
        if (r100.getMetrics() == null) goto L68;
        r100.getMetrics().queryFilterEnd();
    L68:
        return null;
    L69:
        th = move-exception;
        if (r100.getMetrics() == null) goto L73;
        r100.getMetrics().queryFilterEnd();
    L73:
        throw th;
    }

    public String filterUrlWithCommonParams(String r110) {
        if (this.mQueryFilterEnabled == true) goto L5;
    L48:
        return r110;
    L5:
        if (TextUtils.isEmpty(r110) == true) goto L48;
        LinkedHashMap r100 = new LinkedHashMap();     // Catch: Throwable -> L42
        Pair<String, String> r101 = UrlUtils.parseUrlWithValueList(r110, r100);     // Catch: Throwable -> L42
        if (r101 != null) goto L10;
    L41:
        return r110;
    L10:
        if (r100.isEmpty() == true) goto L41;
        if (dispatchQueryMap(new Request("GET", r110, null, null, 0, false, -1, false, null), r100) == true) goto L15;
        return r110;
    L15:
        UrlBuilder r102 = new UrlBuilder(((String) r101.first) + ((String) r101.second));     // Catch: Throwable -> L42
        if (r100.isEmpty() == true) goto L34;
        Iterator r103 = r100.entrySet().iterator();     // Catch: Throwable -> L42
    L19:
        if (r103.hasNext() == false) goto L34;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: Throwable -> L42
        if (r104 == null) goto L19;
        if (r104.getKey() == null) goto L19;
        List r105 = (List) r104.getValue();     // Catch: Throwable -> L42
        if (r105 == null) goto L19;
        if (r105.isEmpty() == true) goto L19;
        Iterator r106 = r105.iterator();     // Catch: Throwable -> L42
    L32:
        if (r106.hasNext() == false) goto L19;
        r102.addParam((String) r104.getKey(), (String) r106.next());     // Catch: Throwable -> L42
    L34:
        String r107 = r102.build();     // Catch: Throwable -> L42
        String r111 = UriProtector.parse(r110).getEncodedFragment();     // Catch: Throwable -> L39
        if (TextUtils.isEmpty(r111) == true) goto L45;
        r107 = r107 + "#" + r111;     // Catch: Throwable -> L39
    L45:
        if (this.mEnableNewSpaceEncodeRule == true) goto L47;
        return r107;
    L47:
        return UrlUtils.replacePlusInEncodeUrl(r107);
    L39:
        th = move-exception;
        th = th;
        r110 = r107;
    L43:
        th.printStackTrace();
        r107 = r110;
    L42:
        th = th;
        goto L43
    }

    public void onNetConfigChanged(String r100) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "onNetConfigChanged config: " + r100 + " enabled: " + this.mQueryFilterEnabled);
    L6:
        if (this.mQueryFilterEnabled == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r100) == true) goto L18;
        parseCommonParamsConfig(r100);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void parseL0ParamsString(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.mL0ParamsList.clear();
        JSONArray r101 = new JSONArray(r100);     // Catch: JSONException -> L11
        int r102 = 0;
    L8:
        if (r102 >= r101.length()) goto L17;
        String r103 = JSONArrayProtectorUtils.getString(r101, r102);     // Catch: JSONException -> L11
        this.mL0ParamsList.add(r103);     // Catch: JSONException -> L11
        r102 = r102 + 1;
        goto L8
    L17:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    public Map<String, String> removeL0CommonParams(Map<String, String> r100) {
        if (r100 != null) goto L4;
    L10:
        return r100;
    L4:
        if (r100.isEmpty() == true) goto L10;
        Iterator<String> r101 = this.mL0ParamsList.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        r100.remove(r101.next());
        goto L8
    }

    public void setEnableNewSpaceEncodeRule(boolean r100) {
        this.mEnableNewSpaceEncodeRule = r100;
    }

    public void setLocalCommonParamsConfig(String r100) throws JSONException {
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(r100), "data");     // Catch: JSONException -> L9
        boolean r102 = false;
        int r103 = r101.optInt(KEY_QUERY_FILTER_ENABLED, 0);     // Catch: JSONException -> L9
        if (r103 <= 0) goto L5;
        r102 = true;
    L5:
        enableQueryFilterEngine(r102);     // Catch: JSONException -> L9
        parseL0ParamsString(r101.optString(KEY_L0_PARAMS, ""));     // Catch: JSONException -> L9
        if (r103 <= 0) goto L14;
        parseCommonParamsConfig(JSONObjectProtectorUtils.getString(r101, KEY_QUERY_FILTER_CONFIG));     // Catch: JSONException -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        Logger.e(TAG, "Local common params config is invalid: " + r100);
        throw e;
    }

    public void setOptRetrofitLog(boolean r100) {
        this.mOptRetrofitLog = r100;
    }

    private static void addRequestEncryptHeaders(List<Header> r100, RetrofitMetrics.EncryptType r101) {
        int r102 = a.f244798a[r101.ordinal()];
        if (r102 != 1) goto L5;
        r100.add(new Header(CIPHER_VERSION_HEADER, "1.0.0"));
        r100.add(new Header(ENCRYPT_INFO_HEADER, "2"));
        return;
    L5:
        if (r102 != 2) goto L7;
        r100.add(new Header(CIPHER_VERSION_HEADER, "1.0.0"));
        r100.add(new Header(ENCRYPT_INFO_HEADER, "1"));
        return;
    L7:
        if (r102 != 3) goto L15;
        r100.add(new Header(CIPHER_VERSION_HEADER, "1.0.0"));
        r100.add(new Header(ENCRYPT_INFO_HEADER, "0"));
        return;
    }

    private boolean dispatchQueryMap(Request r110, Map<String, List<String>> r111) {
        ArrayList r100 = new ArrayList();
        r110.setQueryFilterPriority(0);
        Iterator<c> r101 = this.mQueryFilterActions.iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L18;
        c r103 = r101.next();
        r103.getClass();
        ux5.a r104 = new ux5.a();
        r104.f551982c = SystemClock.uptimeMillis();
        if (r110.getQueryFilterPriority() <= r103.f551989a) goto L8;
        boolean r105 = false;
    L9:
        if (r105 == true) goto L11;
        boolean r106 = false;
    L12:
        if (r106 == false) goto L14;
        r110.setQueryFilterPriority(r103.f551990b);
    L14:
        r104.f551980a = r106;
        r104.f551981b = r103.f551989a;
        r104.f551983d = SystemClock.uptimeMillis();
        r100.add(r104);
        if (r106 == false) goto L4;
        r102 = true;
        goto L4
    L11:
        r106 = r103.a(r110, r111);
        goto L12
    L8:
        r105 = true;
        goto L9
    L18:
        if (Logger.debug() == false) goto L21;
        Logger.d(TAG, "dispatchQueryMap hit: " + r102);
    L21:
        if (r110.getMetrics() == null) goto L23;
        r110.getMetrics().dispatchQueryActionInfo = dispatchQueryActionInfo(r100);
    L23:
        return r102;
    }

    private void parseActionInfo(JSONObject r100, ArrayList<c> r101) throws JSONException {
        String r102 = JSONObjectProtectorUtils.getString(r100, "action");
        int r103 = JSONObjectProtectorUtils.getInt(r100, KEY_ACTION_PRIORITY);
        if (r103 >= 0) goto L5;
        return;
    L5:
        JSONObject r104 = JSONObjectProtectorUtils.getJSONObject(r100, "param");
        int r105 = r100.optInt(KEY_SET_REQ_PRIORITY, r103);
        if (r105 != (-1)) goto L8;
        r105 = Integer.MAX_VALUE;
    L8:
        String r106 = c.f551988h;
        if (r102.equals("rm") == false) goto L12;
        c r107 = new e(r103);
    L14:
        r107.d(r104);
        r107.f551990b = r105;
    L16:
        if (r107 == null) goto L19;
        r101.add(r107);
        return;
    L19:
        return;
    L12:
        if (r102.equals(LBSLightLocationTraceLogger.ENCRYPT) == false) goto L15;
        r107 = new ux5.b(r103);
        goto L14
    L15:
        r107 = null;
        goto L16
    }

    public static void parseArrayListConfig(JSONArray r100, List<String> r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L19;
        int r102 = 0;
    L14:
        if (r102 >= r100.length()) goto L21;
        String r103 = JSONArrayProtectorUtils.getString(r100, r102);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r103) == true) goto L11;
        r101.add(r103);     // Catch: JSONException -> L13
    L11:
        r102 = r102 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    private static void tryEncryptRequest(Request.Builder r100, Request r101, String r102) {
        if ((r101.getBody() instanceof AbsTypedOutput) == false) goto L7;
        boolean r103 = ((AbsTypedOutput) r101.getBody()).isBodyEncrypted();
        if (r103 == false) goto L9;
        Logger.i(TAG, "Request body has been encrypted before.");
    L9:
        if (r101.isQueryEncryptEnabled() == false) goto L11;
    L14:
        ArrayList r104 = new ArrayList();
        if (TextUtils.isEmpty(r102) == true) goto L18;
        r104.add(new Header("x-tt-encrypt-queries", r102));
    L18:
        if (r101.getHeaders() == null) goto L20;
        r104.addAll(r101.getHeaders());
    L20:
        RetrofitMetrics r105 = r101.getMetrics();
        if (r103 == false) goto L23;
    L36:
        RetrofitMetrics.EncryptType r106 = RetrofitMetrics.EncryptType.ENCRYPT_NONE;
        if (r103 == true) goto L39;
    L41:
        if (r103 == false) goto L44;
        r106 = RetrofitMetrics.EncryptType.ENCRYPT_BODY;
        addRequestEncryptHeaders(r104, r106);
    L46:
        if (r105 == null) goto L48;
        r105.setEncryptType(r106);
    L48:
        r100.headers(r104);
        return;
    L44:
        if (r101.isQueryEncryptEnabled() == false) goto L46;
        r106 = RetrofitMetrics.EncryptType.ENCRYPT_QUERY;
        addRequestEncryptHeaders(r104, r106);
        goto L46
    L39:
        if (r101.isQueryEncryptEnabled() == false) goto L41;
        r106 = RetrofitMetrics.EncryptType.ENCRYPT_BOTH_QUERY_AND_BODY;
        addRequestEncryptHeaders(r104, r106);
        goto L46
    L23:
        if (r101.isBodyEncryptEnabled() == false) goto L36;
        TypedOutput r107 = r101.getBody();
        if ((r107 instanceof AbsTypedOutput) == false) goto L36;
        AbsTypedOutput r108 = (AbsTypedOutput) r107;
        if (r105 == null) goto L50;
        r105.bodyEncryptStart();
    L50:
        r103 = r108.interceptRequestBody();     // Catch: Throwable -> L32
        if (r105 == null) goto L36;
        r105.bodyEncryptEnd();
    L32:
        th = move-exception;
        if (r105 == null) goto L35;
        r105.bodyEncryptEnd();
    L35:
        throw th;
    L11:
        if (r101.isBodyEncryptEnabled() == true) goto L14;
        if (r103 == true) goto L14;
        return;
    L7:
        r103 = false;
        goto L9
    }
}

package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.retrofit2.client.Request;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class CronetSsCallConfig {
    private static final int CONNECT_INTERVAL = 4000;
    private static final String KEY_BLOCK_ERROR_CODE_LIST = "block_code_list";
    private static final String KEY_BYPASS_ROUTE_SELECTION_ENABLED = "bypass_rs_enabled";
    private static final String KEY_CONCURRENT_HOST_GROUP = "concurrent_hosts";
    private static final String KEY_CONCURRENT_REQUEST_ENABLED = "enabled_v2";
    private static final String KEY_CONNECT_TIME_INTERVAL = "connect_interval_millis";
    private static final String KEY_CONTINUE_FAILED_COUNTS = "fail_count";
    private static final String KEY_FORBIDDEN_SECONDS = "forbid_seconds";
    private static final String KEY_HOST_GROUP = "host_group";
    private static final String KEY_MAX_WAIT_SECONDS = "max_wait_seconds";
    private static final String KEY_PATH_EQUAL_GROUP = "equal_group";
    private static final String KEY_PATH_PATTERN_GROUP = "pattern_group";
    private static final String KEY_PATH_PREFIX_GROUP = "prefix_group";
    private static final String KEY_REFINE_WITH_CONCURRENT_ROUTE = "concurrent_route";
    private static final String KEY_REFINE_WITH_ROUTE_SELECTION = "rs_name";
    private static final String KEY_REQUEST_FINISH_FIX_ENABLED = "fin_fix_enabled";
    private static final String KEY_RETRY_FOR_NOT_2XX_CODE = "retry_for_not_2xx_code";
    private static final String KEY_URL_MATCH_RULE = "match_rules";
    private static final String TAG = null;
    private static volatile CronetSsCallConfig sInstance;
    private volatile int mConcurrentRequestEnabled;
    private List<UrlMatchRule> mUrlMatchRuleList;

    /* JADX INFO: loaded from: classes19.dex */
    public static class UrlMatchRule {
        Set<Integer> mBlockErrorCodeSet;
        boolean mBypassRouteSelectionEnabled;
        final List<String> mConcurrentHostList;
        int mConnectTimeInterval;
        volatile int mContinueFailedCount;
        boolean mEnableRequestReportFix;
        List<String> mEqualPathList;
        int mForbiddenDurationSeconds;
        volatile long mForbiddenTimeStart;
        final List<String> mHostList;
        volatile boolean mIsForbidden;
        int mMaxFailedCount;
        List<Pattern> mPatternPathList;
        List<String> mPrefixPathList;
        String mRefineRsName;
        boolean mRetryForNot2xxCode;
        String mRuleId;
        int mTNCRequestMaxWaitTime;

        public List<String> getDomainList() {
            return this.mConcurrentHostList;
        }

        public String getRuleId() {
            return this.mRuleId;
        }

        public UrlMatchRule(List<String> r100, List<String> r101) {
            this.mEnableRequestReportFix = false;
            this.mTNCRequestMaxWaitTime = 0;
            this.mHostList = r100;
            this.mConcurrentHostList = r101;
            this.mForbiddenTimeStart = SystemClock.uptimeMillis();
            this.mContinueFailedCount = 0;
            this.mMaxFailedCount = Integer.MAX_VALUE;
            this.mForbiddenDurationSeconds = 0;
            this.mIsForbidden = false;
            this.mRuleId = UUID.randomUUID().toString();
            this.mRetryForNot2xxCode = false;
            this.mConnectTimeInterval = 4000;
            this.mBypassRouteSelectionEnabled = true;
            this.mRefineRsName = null;
        }
    }

    static {
        TAG = "CronetSsCallConfig";
    }

    public static CronetSsCallConfig inst() {
        if (sInstance != null) goto L15;
        monitor-enter(CronetSsCallConfig.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CronetSsCallConfig();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CronetSsCallConfig.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void recoverRuleStatusFromForbidden() {
        Iterator<UrlMatchRule> r100 = this.mUrlMatchRuleList.iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        UrlMatchRule r101 = r100.next();
        if (r101.mIsForbidden == false) goto L4;
        long r102 = SystemClock.uptimeMillis() - r101.mForbiddenTimeStart;
        if (r102 <= (r101.mForbiddenDurationSeconds * 1000)) goto L11;
        r101.mIsForbidden = false;
    L11:
        if (Logger.debug() == false) goto L4;
        Logger.d(TAG, "Rule id: " + r101.mRuleId + " has forbidden duration: " + r102 + " fail count: " + r101.mContinueFailedCount + " forbidden duration: " + (r101.mForbiddenDurationSeconds * 1000));
        goto L4
    }

    public boolean isConcurrentRequestEnabled() {
        if (this.mConcurrentRequestEnabled <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private CronetSsCallConfig() {
        this.mConcurrentRequestEnabled = 0;
        this.mUrlMatchRuleList = new CopyOnWriteArrayList();
    }

    private UrlMatchRule getRuleById(String r100) {
        Iterator<UrlMatchRule> r101 = this.mUrlMatchRuleList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        UrlMatchRule r102 = r101.next();
        if (r102.getRuleId().equals(r100) == false) goto L4;
        return r102;
    L8:
        return null;
    }

    private static boolean isEmpty(List<?> r100) {
        if (r100 != null) goto L4;
        return true;
    L4:
        if (r100.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }

    private void parseUrlMatchRule(JSONObject r100) throws JSONException {
        ArrayList r101 = new ArrayList();
        parseJSONArrayList(r100, KEY_HOST_GROUP, r101);
        ArrayList r102 = new ArrayList();
        parseJSONArrayList(r100, KEY_CONCURRENT_HOST_GROUP, r102);
        if (r101.isEmpty() == false) goto L5;
        return;
    L5:
        if (r102.size() < 2) goto L57;
        UrlMatchRule r103 = new UrlMatchRule(r101, r102);
        ArrayList r104 = new ArrayList();
        if (parseJSONArrayList(r100, KEY_PATH_EQUAL_GROUP, r104) == false) goto L10;
        r103.mEqualPathList = r104;
    L10:
        ArrayList r105 = new ArrayList();
        if (parseJSONArrayList(r100, KEY_PATH_PREFIX_GROUP, r105) == false) goto L13;
        r103.mPrefixPathList = r105;
    L13:
        ArrayList r106 = new ArrayList();
        JSONArray r107 = r100.optJSONArray(KEY_PATH_PATTERN_GROUP);
        int r108 = 0;
        if (r107 == null) goto L23;
        int r109 = 0;
    L17:
        if (r109 >= r107.length()) goto L22;
        String r110 = r107.optString(r109);
        if (TextUtils.isEmpty(r110) == true) goto L21;
        r106.add(PatternProtector.compile(r110, 2));     // Catch: Throwable -> L49
    L21:
        r109 = r109 + 1;
        goto L17
    L22:
        r103.mPatternPathList = r106;
    L23:
        r103.mMaxFailedCount = r100.optInt(KEY_CONTINUE_FAILED_COUNTS, Integer.MAX_VALUE);
        r103.mForbiddenDurationSeconds = r100.optInt(KEY_FORBIDDEN_SECONDS, 0);
        r103.mConnectTimeInterval = r100.optInt(KEY_CONNECT_TIME_INTERVAL, 4000);
        boolean r111 = true;
        if (r100.optInt(KEY_BYPASS_ROUTE_SELECTION_ENABLED, 1) <= 0) goto L26;
        boolean r112 = true;
    L27:
        r103.mBypassRouteSelectionEnabled = r112;
        String r113 = r100.optString(KEY_REFINE_WITH_CONCURRENT_ROUTE);
        r103.mRefineRsName = r113;
        if (TextUtils.isEmpty(r113) == false) goto L31;
        r103.mRefineRsName = r100.optString(KEY_REFINE_WITH_ROUTE_SELECTION, null);
    L31:
        if (r100.optInt(KEY_REQUEST_FINISH_FIX_ENABLED, 0) <= 0) goto L33;
        boolean r114 = true;
    L34:
        r103.mEnableRequestReportFix = r114;
        r103.mTNCRequestMaxWaitTime = r100.optInt(KEY_MAX_WAIT_SECONDS, 0);
        if (r103.mConnectTimeInterval > 0) goto L38;
        return;
    L38:
        if (r100.optInt(KEY_RETRY_FOR_NOT_2XX_CODE, 0) > 0) goto L41;
        r111 = false;
    L41:
        r103.mRetryForNot2xxCode = r111;
        HashSet r115 = new HashSet();
        JSONArray r116 = r100.optJSONArray(KEY_BLOCK_ERROR_CODE_LIST);
        if (r116 != null) goto L44;
    L47:
        this.mUrlMatchRuleList.add(r103);
        return;
    L44:
        if (r108 >= r116.length()) goto L46;
        r115.add(Integer.valueOf(r116.optInt(r108)));
        r108 = r108 + 1;
        goto L44
    L46:
        r103.mBlockErrorCodeSet = r115;
        goto L47
    L33:
        r114 = false;
        goto L34
    L26:
        r112 = false;
        goto L27
    }

    public UrlMatchRule getUrlMatchRuleFromRequest(Request r100) {
        recoverRuleStatusFromForbidden();
        Iterator<UrlMatchRule> r101 = this.mUrlMatchRuleList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        UrlMatchRule r102 = r101.next();
        if (isUrlMatchRule(r100, r102) == false) goto L4;
        return r102;
    L8:
        return null;
    }

    public void onNetConfigChanged(String r100) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "onNetConfigChanged config: " + r100);
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L17;
        return;
    L17:
        JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L13
        int r102 = 0;
        this.mConcurrentRequestEnabled = r101.optInt(KEY_CONCURRENT_REQUEST_ENABLED, 0);     // Catch: Throwable -> L13
        this.mUrlMatchRuleList.clear();     // Catch: Throwable -> L13
        JSONArray r103 = JSONObjectProtectorUtils.getJSONArray(r101, KEY_URL_MATCH_RULE);     // Catch: Throwable -> L13
    L10:
        if (r102 >= r103.length()) goto L21;
        parseUrlMatchRule((JSONObject) r103.get(r102));     // Catch: Throwable -> L13
        r102 = r102 + 1;
        goto L10
    L21:
        return;
    L14:
        if (Logger.debug() == false) goto L20;
        Logger.d(TAG, "parse json config error");
        return;
    }

    private boolean isUrlMatchRule(Request r100, UrlMatchRule r101) {
        if (r101.mForbiddenDurationSeconds > 0) goto L5;
    L7:
        String r102 = r100.getUrl();
        if (TextUtils.isEmpty(r102) == false) goto L10;
        return false;
    L10:
        Iterator<String> r103 = r101.mHostList.iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        if (UrlUtils.matchPattern(r100.getHost(), r103.next()) == false) goto L12;
        boolean r104 = true;
    L17:
        if (r104 == false) goto L19;
        String r105 = r100.getPath();
        if (TextUtils.isEmpty(r105) == false) goto L26;
        return false;
    L26:
        if (isEmpty(r101.mEqualPathList) == true) goto L34;
        Iterator<String> r106 = r101.mEqualPathList.iterator();
    L29:
        if (r106.hasNext() == false) goto L34;
        if (r105.equals(r106.next()) == false) goto L29;
        return true;
    L34:
        if (isEmpty(r101.mPrefixPathList) == true) goto L42;
        Iterator<String> r107 = r101.mPrefixPathList.iterator();
    L37:
        if (r107.hasNext() == false) goto L42;
        if (r105.startsWith(r107.next()) == false) goto L37;
        return true;
    L42:
        if (isEmpty(r101.mPatternPathList) == true) goto L52;
        Iterator<Pattern> r108 = r101.mPatternPathList.iterator();
    L45:
        if (r108.hasNext() == false) goto L52;
        Pattern r109 = r108.next();
        if (r109 == null) goto L45;
        if (r109.matcher(r105).matches() == false) goto L45;
        return true;
    L52:
        return false;
    L19:
        if (Logger.debug() == false) goto L21;
        Logger.d(TAG, "host not match: " + r102);
    L21:
        return false;
    L16:
        r104 = false;
        goto L17
    L5:
        if (r101.mIsForbidden == false) goto L7;
        return false;
    }

    private void tryForbiddenCurrentRule(UrlMatchRule r100, boolean r101) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "Forbidden: " + r100.mIsForbidden + " failed count: " + r100.mContinueFailedCount + " max count: " + r100.mMaxFailedCount);
    L5:
        if (r101 == true) goto L7;
        int r102 = r100.mContinueFailedCount + 1;
        r100.mContinueFailedCount = r102;
        if (r102 >= r100.mMaxFailedCount) goto L17;
        return;
    L17:
        if (r100.mIsForbidden == true) goto L20;
        r100.mIsForbidden = true;
        r100.mForbiddenTimeStart = SystemClock.uptimeMillis();
    L20:
        if (Logger.debug() == false) goto L23;
        Logger.d(TAG, "Forbidden: " + r100.mIsForbidden + " failed count: " + r100.mContinueFailedCount);
        return;
    L23:
        return;
    L7:
        if (r100.mContinueFailedCount == 0) goto L9;
    L11:
        r100.mContinueFailedCount = 0;
        r100.mIsForbidden = false;
        return;
    L9:
        if (r100.mIsForbidden == true) goto L11;
    }

    public boolean inBlockErrorCode(int r100, String r101) {
        if (r100 != 0) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        UrlMatchRule r102 = getRuleById(r101);
        if (r102 == null) goto L14;
        Set<Integer> r103 = r102.mBlockErrorCodeSet;
        if (r103 == null) goto L14;
        return r103.contains(Integer.valueOf(r100));
    }

    public void notifyConcurrentRequestFinished(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        UrlMatchRule r102 = getRuleById(r100);
        if (r102 != null) goto L8;
        return;
    L8:
        tryForbiddenCurrentRule(r102, r101);
    }

    private static boolean parseJSONArrayList(JSONObject r100, String r101, List<String> r102) {
        int r103 = 0;
        if (r100 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L19;
        if (r102 == null) goto L19;
        JSONArray r104 = r100.optJSONArray(r101);
        if (r104 != null) goto L12;
        return false;
    L12:
        if (r103 >= r104.length()) goto L17;
        String r105 = r104.optString(r103);
        if (TextUtils.isEmpty(r105) == true) goto L16;
        r102.add(r105);
    L16:
        r103 = r103 + 1;
        goto L12
    L17:
        return true;
    }
}

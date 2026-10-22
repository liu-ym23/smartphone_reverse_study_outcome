package com.bytedance.ttnet.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.exception.CdnCacheVerifyException;
import com.bytedance.frameworks.baselib.network.http.util.l;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.ttnet.http.HttpRequestInfo;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class CdnCacheVerifyUtils {
    private static final String HEADER_VERIFY_KEY = "X-TT-VERIFY-ID";
    public static final String KEY_TTNET_RESPONSE_VERIFY = "ttnet_response_verify";
    public static final String KEY_TTNET_RESPONSE_VERIFY_ENABLED = "ttnet_response_verify_enabled";
    private static final String TAG = "CDN_CACHE_VERIFY";
    public static final int VERIFY_ACCESSIBLE = 1;
    public static final int VERIFY_FAIL = 3;
    public static final int VERIFY_SUCCESS = 2;
    public static final int VERIFY_UNDEFINED = -1;
    private static volatile boolean sEnabled;
    private static Lock sReadLock;
    private static ReentrantReadWriteLock sReadWriteLock;
    private static List<Regex> sRegexArray;
    private static Lock sWriteLock;

    public static class CdnCacheVerifyConfig {
        public int ttnetResponseVerifyEnabled;
        public String verifyRegexsStr;

        public CdnCacheVerifyConfig() {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static class Regex {
        private Pattern pattern;

        public Regex() {
        }

        public boolean matcher(URI r100) {
            if (r100 != null) goto L5;
        L14:
            return false;
        L5:
            if (TextUtils.isEmpty(r100.getHost()) == true) goto L14;
            if (this.pattern == null) goto L14;
            String r101 = r100.getHost();
            if (TextUtils.isEmpty(r100.getPath()) == true) goto L16;
            r101 = r101 + r100.getPath();
        L16:
            return this.pattern.matcher(r101).matches();
        }

        public boolean setPattern(String r100) {
            this.pattern = PatternProtector.compile(r100);     // Catch: PatternSyntaxException -> L5
            return true;
        L5:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    public CdnCacheVerifyUtils() {
    }

    static {
        sRegexArray = new ArrayList();
        ReentrantReadWriteLock r100 = new ReentrantReadWriteLock();
        sReadWriteLock = r100;
        sReadLock = r100.readLock();
        sWriteLock = sReadWriteLock.writeLock();
    }

    private static String generateVerifyValue() {
        return UUID.randomUUID().toString();
    }

    private static boolean filterRule(URI r100) {
        sReadLock.lock();     // Catch: Throwable -> L12
        Iterator<Regex> r101 = sRegexArray.iterator();     // Catch: Throwable -> L12
    L4:
        if (r101.hasNext() == false) goto L10;
        goto L4
    L7:
        if (r101.next().matcher(r100) == false) goto L4;
        sReadLock.unlock();
        return true;
    L10:
        sReadLock.unlock();
        return false;
    L12:
        th = move-exception;
        sReadLock.unlock();
        throw th;
    }

    private static String getCdnCacheVerifyValue(URI r100) {
        if (filterRule(r100) == true) goto L5;
        return null;
    L5:
        return generateVerifyValue();
    }

    public static void onLocalConfigUpdate(SharedPreferences r100) {
        int r101 = r100.getInt(KEY_TTNET_RESPONSE_VERIFY_ENABLED, -1);
        String r102 = r100.getString(KEY_TTNET_RESPONSE_VERIFY, "");
        if (TextUtils.isEmpty(r102) == false) goto L11;
    L8:
        JSONArray r103 = null;
    L9:
        resolveCdnCacheVerify(r101, r103);
        return;
    L11:
        r103 = new JSONArray(r102);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    public static CdnCacheVerifyConfig onServerConfigUpdate(JSONObject r100) {
        int r101 = r100.optInt(KEY_TTNET_RESPONSE_VERIFY_ENABLED, -1);
        JSONArray r102 = r100.optJSONArray(KEY_TTNET_RESPONSE_VERIFY);
        if (r102 == null) goto L5;
        String r103 = r102.toString();
    L6:
        resolveCdnCacheVerify(r101, r102);
        CdnCacheVerifyConfig r104 = new CdnCacheVerifyConfig();
        r104.ttnetResponseVerifyEnabled = r101;
        r104.verifyRegexsStr = r103;
        return r104;
    L5:
        r103 = "";
        goto L6
    }

    public static void setEnabled(boolean r100) {
        sEnabled = r100;
    }

    public static void setRegexArray(List<Regex> r100) {
        sWriteLock.lock();     // Catch: Throwable -> L5
        sRegexArray = r100;     // Catch: Throwable -> L5
        sWriteLock.unlock();
        return;
    L5:
        th = move-exception;
        sWriteLock.unlock();
        throw th;
    }

    private static void preProcessingImpl(String r100, List<Header> r101) {
        String r102 = getCdnCacheVerifyValue(l.b(r100));     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r102) == true) goto L11;
        r101.add(new Header(HEADER_VERIFY_KEY, r102));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    private static void resolveCdnCacheVerify(int r100, JSONArray r101) {
        int r102 = 0;
        if (r100 <= 0) goto L16;
        ArrayList r103 = new ArrayList();
        if (r101 == null) goto L15;
        int r104 = r101.length();
    L7:
        if (r102 >= r104) goto L14;
        String r105 = r101.optString(r102);
        if (TextUtils.isEmpty(r105) == true) goto L13;
        Regex r106 = new Regex();
        if (r106.setPattern(r105) == false) goto L13;
        r103.add(r106);
    L13:
        r102 = r102 + 1;
        goto L7
    L14:
        setRegexArray(r103);
    L15:
        setEnabled(true);
        return;
    L16:
        setEnabled(false);
    }

    public static void postProcessing(Request r100, Response r101, HttpRequestInfo r102) throws IOException {
        if (sEnabled == true) goto L5;
        return;
    L5:
        if (r102 != null) goto L8;
        Logger.w(TAG, "Req info is null");
        return;
    L8:
        postProcessingImpl(r100, r101, r102);
    }

    private static void postProcessingImpl(Request r100, Response r101, HttpRequestInfo r102) throws IOException {
        Header r103 = r100.getFirstHeader(HEADER_VERIFY_KEY);
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getValue();
    L6:
        Header r106 = r101.getFirstHeader(HEADER_VERIFY_KEY);
        if (r106 == null) goto L9;
        r104 = r106.getValue();
    L9:
        if (r105 != null) goto L11;
        return;
    L11:
        if (r104 != null) goto L14;
        r102.cdnVerifyValue = 1;
        Logger.w(TAG, "Cdn cache verify accessible");
    L21:
        RequestTicketUtil.ICdnCacheVerifyCallback r107 = RequestTicketUtil.getCdnCacheVerifyProcessor();
        if (r107 == null) goto L36;
        if (r100.getMetrics() == null) goto L43;
        r100.getMetrics().postCdnCacheVerifyStart();
    L43:
        r107.onCallback(r100.getUrl(), r102);     // Catch: Throwable -> L30
        if (r100.getMetrics() == null) goto L36;
        r100.getMetrics().postCdnCacheVerifyEnd();
    L30:
        th = move-exception;
        if (r100.getMetrics() == null) goto L34;
        r100.getMetrics().postCdnCacheVerifyEnd();
    L34:
        throw th;
    L36:
        if (r102.cdnVerifyValue == 3) goto L39;
        return;
    L39:
        throw new CdnCacheVerifyException("Fail to verify cdn cache");
    L14:
        if (r105.equals(r104) == false) goto L16;
        r102.cdnVerifyValue = 2;
        Logger.w(TAG, "Cdn cache verify success");
        goto L21
    L16:
        r102.cdnVerifyValue = 3;
        Logger.w(TAG, "Cdn cache verify fail");
        r101.getBody().in().close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
        Logger.w(TAG, "Cdn cache verify stream close fail:" + th.toString());
        goto L21
    L5:
        r105 = null;
        goto L6
    }

    public static void preProcessing(String r100, List<Header> r101, RetrofitMetrics r102) {
        if (sEnabled == true) goto L5;
        return;
    L5:
        if (r102 == null) goto L15;
        r102.preCdnCacheVerifyStart();
    L15:
        preProcessingImpl(r100, r101);     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        r102.preCdnCacheVerifyEnd();
        return;
    L17:
        return;
    L11:
        th = move-exception;
        if (r102 == null) goto L14;
        r102.preCdnCacheVerifyEnd();
    L14:
        throw th;
    }
}

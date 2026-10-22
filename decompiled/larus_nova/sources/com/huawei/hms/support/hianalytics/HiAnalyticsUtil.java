package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import com.miui.easygo.constant.EasyGoConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class HiAnalyticsUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f277751a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HiAnalyticsUtil f277752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static HiAnalyticsUtils f277753c;

    public HiAnalyticsUtil() {
    }

    static {
        f277751a = new Object();
    }

    public static HiAnalyticsUtil getInstance() {
        Object r100 = f277751a;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f277752b != null) goto L7;
        f277752b = new HiAnalyticsUtil();     // Catch: Throwable -> L10
        f277753c = HiAnalyticsUtils.getInstance();     // Catch: Throwable -> L10
    L7:
        HiAnalyticsUtil r101 = f277752b;     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    }

    public boolean hasError() {
        if (SystemUtils.isChinaROM() == true) goto L6;
        HMSLog.i("HiAnalyticsUtil", "not ChinaROM ");
        return true;
    L6:
        return false;
    }

    public static Map<String, String> getMapFromForegroundResponseHeader(ResponseHeader r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L5;
        return r101;
    L5:
        r101.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, r100.getTransactionId());
        r101.put("appid", r100.getActualAppID());
        r101.put("service", r100.getSrvName());
        r101.put("apiName", r100.getApiName());
        r101.put("package", r100.getPkgName());
        r101.put("statusCode", String.valueOf(r100.getStatusCode()));
        r101.put("result", String.valueOf(r100.getErrorCode()));
        r101.put(HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, r100.getErrorReason());
        r101.put("callTime", String.valueOf(System.currentTimeMillis()));
        r101.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.13.0.301");
        return r101;
    }

    public static Map<String, String> getMapFromRequestHeader(ResponseHeader r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L5;
        return r101;
    L5:
        r101.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, r100.getTransactionId());
        r101.put("appid", r100.getActualAppID());
        r101.put("service", r100.getSrvName());
        String r102 = r100.getApiName();
        if (TextUtils.isEmpty(r102) == true) goto L10;
        String[] r103 = r102.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r103.length < 2) goto L10;
        r101.put("apiName", r103[1]);
    L10:
        r101.put("package", r100.getPkgName());
        r101.put("statusCode", String.valueOf(r100.getStatusCode()));
        r101.put("result", String.valueOf(r100.getErrorCode()));
        r101.put(HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, r100.getErrorReason());
        r101.put("callTime", String.valueOf(System.currentTimeMillis()));
        r101.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.13.0.301");
        return r101;
    }

    public static String versionCodeToName(String r100) {
        return HiAnalyticsUtils.versionCodeToName(r100);
    }

    public Map<String, String> getMapFromForegroundRequestHeader(RequestHeader r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L5;
        return r101;
    L5:
        r101.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, r100.getTransactionId());
        r101.put("appid", r100.getActualAppID());
        r101.put("service", r100.getSrvName());
        r101.put("apiName", r100.getApiName());
        r101.put("package", r100.getPkgName());
        r101.put("callTime", String.valueOf(System.currentTimeMillis()));
        r101.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.13.0.301");
        return r101;
    }

    public boolean hasError(Context r100) {
        return f277753c.hasError(r100);
    }

    public Map<String, String> getMapFromRequestHeader(RequestHeader r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L5;
        return r101;
    L5:
        r101.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, r100.getTransactionId());
        r101.put("appid", r100.getActualAppID());
        r101.put("service", r100.getSrvName());
        String r102 = r100.getApiName();
        if (TextUtils.isEmpty(r102) == true) goto L10;
        String[] r103 = r102.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r103.length < 2) goto L10;
        r101.put("apiName", r103[1]);
    L10:
        r101.put("package", r100.getPkgName());
        r101.put("callTime", String.valueOf(System.currentTimeMillis()));
        r101.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.13.0.301");
        return r101;
    }

    private String a(Context r100, String r101) {
        return "01||" + r100.getPackageName() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Util.getAppId(r100) + "|61300301|" + r101;
    }

    public Map<String, String> getMapForBi(Context r100, String r101) {
        HashMap r102 = new HashMap();
        String[] r103 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r103.length < 2) goto L8;
        String r104 = r103[0];
        String r105 = r103[1];
        String r106 = Util.getAppId(r100);
        r102.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, TransactionIdCreater.getId(r106, r101));
        r102.put("appid", r106);
        r102.put("service", r104);
        r102.put("apiName", r105);
        if (r100 == null) goto L7;
        r102.put("package", r100.getPackageName());
    L7:
        r102.put("version", "6.13.0.301");
        r102.put("callTime", String.valueOf(System.currentTimeMillis()));
    L8:
        return r102;
    }

    public void onBuoyEvent(Context r100, String r101, String r102) {
        f277753c.onBuoyEvent(r100, r101, r102);
    }

    public void onEvent(Context r100, String r101, String r102) {
        if (r100 == null) goto L5;
        onEvent2(r100, r101, a(r100, r102));
        return;
    }

    public void onEvent2(Context r100, String r101, String r102) {
        f277753c.onEvent2(r100, r101, r102);
    }

    public void onNewEvent(Context r100, String r101, Map r102) {
        f277753c.onNewEvent(r100, r101, r102);
    }

    public void onEvent(Context r100, String r101, Map<String, String> r102) {
        f277753c.onEvent(r100, r101, r102);
    }
}

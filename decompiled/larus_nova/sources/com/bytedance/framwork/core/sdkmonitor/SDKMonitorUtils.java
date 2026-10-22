package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.text.TextUtils;
import com.apm.lite.runtime.ConfigManager;
import com.bytedance.services.apm.api.IHttpService;
import com.ss.videoarch.strategy.log.StrategyCenterLogger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SDKMonitorUtils {
    private static final Object[] LOCKS = null;
    private static ConcurrentHashMap<String, List<String>> sAidToConfigUrl;
    private static ConcurrentHashMap<String, List<String>> sAidToDefaultReportUrl;
    public static ConcurrentHashMap<String, SDKMonitor> sAidToMonitorCommon;

    public SDKMonitorUtils() {
    }

    public static String getSdkVersion() {
        return "2.0.44";
    }

    static {
        sAidToMonitorCommon = new ConcurrentHashMap();
        sAidToDefaultReportUrl = new ConcurrentHashMap();
        sAidToConfigUrl = new ConcurrentHashMap();
        LOCKS = new Object[16];
        int r100 = 0;
    L3:
        Object[] r101 = LOCKS;
        if (r100 >= r101.length) goto L6;
        r101[r100] = new Object();
        r100 = r100 + 1;
        goto L3
    }

    public static List<String> convertReportUrl(List<String> r100) {
        LinkedList r101 = new LinkedList();
        Iterator<String> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        r101.add(("https://" + new URL(r102.next()).getHost()) + StrategyCenterLogger.SLARDAR_REPORT_LOG_API_PATH);     // Catch: MalformedURLException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        return r101;
    }

    public static SDKMonitor getInstance(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L15;
        int r101 = r100.hashCode();
        Object[] r102 = LOCKS;
        Object r103 = r102[r101 % r102.length];
        monitor-enter(r103);
        SDKMonitor r104 = sAidToMonitorCommon.get(r100);     // Catch: Throwable -> L11
        if (r104 != null) goto L9;
        r104 = new SDKMonitor(r100);     // Catch: Throwable -> L11
        sAidToMonitorCommon.put(r100, r104);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r103);     // Catch: Throwable -> L11
        return r104;
    L11:
        th = move-exception;
        throw th;
    L15:
        throw new IllegalArgumentException("param 'aid' is not allowed to assign empty string");
    }

    public static void setHostAid(String r100) {
        SDKMonitor.setHostAid(r100);
    }

    public static void setHttpService(IHttpService r100) {
        SDKMonitor.setHttpService(r100);
    }

    public static void setConfigUrl(String r100, List<String> r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (hy5.b.a(r101) == true) goto L40;
        int r102 = r100.hashCode();
        Object[] r103 = LOCKS;
        Object r104 = r103[r102 % r103.length];
        monitor-enter(r104);
        String r105 = "https://" + new URL(r101.get(0)).getHost();     // Catch: Throwable -> L14 Exception -> L30
        AtomicInteger r106 = fy5.a.f479281a;     // Catch: Throwable -> L14 Exception -> L30
        if (TextUtils.isEmpty(r105) == true) goto L16;
        fy5.a.f479283c = r105 + ConfigManager.EXCEPTION_URL_SUFFIX;     // Catch: Throwable -> L14 Exception -> L30
    L14:
        th = move-exception;
        throw th;
    L16:
        LinkedList r107 = new LinkedList();     // Catch: Throwable -> L14
        Iterator<String> r108 = r101.iterator();     // Catch: Throwable -> L14
    L18:
        if (r108.hasNext() == false) goto L24;
        r107.add(("https://" + new URL(r108.next()).getHost()) + "/monitor/appmonitor/v5/batch_settings");     // Catch: Throwable -> L14 MalformedURLException -> L22
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L18
    L24:
        sAidToConfigUrl.put(r100, r107);     // Catch: Throwable -> L14
        monitor-exit(r104);     // Catch: Throwable -> L14
        return;
    }

    public static void setDeafultReportUrl(String r100, List<String> r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (hy5.b.a(r101) == true) goto L18;
        int r102 = r100.hashCode();
        Object[] r103 = LOCKS;
        Object r104 = r103[r102 % r103.length];
        monitor-enter(r104);
        sAidToDefaultReportUrl.put(r100, convertReportUrl(r101));     // Catch: Throwable -> L12
        monitor-exit(r104);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void setDefaultReportUrl(String r100, List<String> r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (hy5.b.a(r101) == true) goto L25;
        int r102 = r100.hashCode();
        Object[] r103 = LOCKS;
        Object r104 = r103[r102 % r103.length];
        monitor-enter(r104);
        sAidToDefaultReportUrl.put(r100, convertReportUrl(r101));     // Catch: Throwable -> L16
        String r105 = "https://" + new URL(r101.get(0)).getHost();     // Catch: Exception -> L20 Throwable -> L16
        AtomicInteger r106 = fy5.a.f479281a;     // Catch: Exception -> L20 Throwable -> L16
        if (TextUtils.isEmpty(r105) == true) goto L14;
        fy5.a.f479283c = r105 + ConfigManager.EXCEPTION_URL_SUFFIX;     // Catch: Exception -> L20 Throwable -> L16
    L14:
        monitor-exit(r104);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public static void init(Context r100, String r101, JSONObject r102, SDKMonitor.n r103) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L27;
        if (r102 == null) goto L25;
        int r104 = r101.hashCode();
        Object[] r105 = LOCKS;
        Object r106 = r105[r104 % r105.length];
        monitor-enter(r106);
    L21:
        th = move-exception;
        throw th;
    L10:
        if (sAidToMonitorCommon.get(r101) != null) goto L12;
    L15:
        SDKMonitor r107 = sAidToMonitorCommon.get(r101);     // Catch: Throwable -> L21
        if (r107 != null) goto L18;
        r107 = new SDKMonitor(r101);     // Catch: Throwable -> L21
        sAidToMonitorCommon.put(r101, r107);     // Catch: Throwable -> L21
    L18:
        r107.resetConfigUrls(sAidToConfigUrl.remove(r101));     // Catch: Throwable -> L21
        r107.resetReportUrls(sAidToDefaultReportUrl.remove(r101));     // Catch: Throwable -> L21
        r107.init(r100, r102, r103);     // Catch: Throwable -> L21
        monitor-exit(r106);     // Catch: Throwable -> L21
        return;
    L12:
        if (sAidToMonitorCommon.get(r101).isHasInit() == false) goto L15;
        monitor-exit(r106);     // Catch: Throwable -> L21
        return;
    L25:
        throw new IllegalArgumentException("param 'headerInfo' is not allowed to be null");
    L27:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");
    }

    public static void initMonitor(Context r100, String r101, JSONObject r102, SDKMonitor.IGetExtendParams r103) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L27;
        if (r102 == null) goto L25;
        int r104 = r101.hashCode();
        Object[] r105 = LOCKS;
        Object r106 = r105[r104 % r105.length];
        monitor-enter(r106);
    L21:
        th = move-exception;
        throw th;
    L10:
        if (sAidToMonitorCommon.get(r101) != null) goto L12;
    L15:
        SDKMonitor r107 = sAidToMonitorCommon.get(r101);     // Catch: Throwable -> L21
        if (r107 != null) goto L18;
        r107 = new SDKMonitor(r101);     // Catch: Throwable -> L21
        sAidToMonitorCommon.put(r101, r107);     // Catch: Throwable -> L21
    L18:
        r107.resetConfigUrls(sAidToConfigUrl.remove(r101));     // Catch: Throwable -> L21
        r107.resetReportUrls(sAidToDefaultReportUrl.remove(r101));     // Catch: Throwable -> L21
        r107.init(r100, r102, r103);     // Catch: Throwable -> L21
        monitor-exit(r106);     // Catch: Throwable -> L21
        return;
    L12:
        if (sAidToMonitorCommon.get(r101).isHasInit() == false) goto L15;
        monitor-exit(r106);     // Catch: Throwable -> L21
        return;
    L25:
        throw new IllegalArgumentException("param 'headerInfo' is not allowed to be null");
    L27:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");
    }
}

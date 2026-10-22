package com.bytedance.bdlocation.scan.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.thread.AppExecutors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes10.dex */
public class LBSLightWifiUtils {
    public LBSLightWifiUtils() {
    }

    public static /* synthetic */ int a(ScanResult r100, ScanResult r101) {
        return lambda$getWifiScanResultsForLBSLightLocation$0(r100, r101);
    }

    private static List com_bytedance_bdlocation_scan_wifi_LBSLightWifiUtils_android_net_wifi_WifiManager_getScanResults(WifiManager r110) throws BDLocationException {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, "java.util.List", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, null, r111, false);
        return (List) r112.f474983b;
    L6:
        List<ScanResult> r113 = r110.getScanResults();
        r100.a(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, r113, r111, true);
        return r113;
    }

    public static List<ScanResult> getWifiScanResultsForLBSLightLocation(LBSLightLocationTraceLogger r110, LocationOption r111) throws BDLocationException {
        LocationMonitor.lbsLightLocationTraceMetricBegin(r110, LBSLightLocationTraceLogger.PRE_SCAN_RESULTS);
        Context r100 = BDLocationConfig.getContext();
        if (r100 == null) goto L50;
        final WifiManager r101 = (WifiManager) r100.getApplicationContext().getSystemService("wifi");
        LocationMonitor.lbsLightLocationTraceMetricEnd(r110, LBSLightLocationTraceLogger.PRE_SCAN_RESULTS);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r110, LBSLightLocationTraceLogger.GET_BPEA_MANAGER);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r110, LBSLightLocationTraceLogger.GET_BPEA_MANAGER);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r110, LBSLightLocationTraceLogger.GET_SCAN_RESULTS);
        if (BDLocationConfig.isIndependentThreadGetScanResults() == false) goto L11;
        LocationMonitor.lbsLightLocationTracePutCategoryData(r110, LBSLightLocationTraceLogger.INDEPENDENT_THREAD_GET_SCAN_RESULTS, Boolean.TRUE);
        ThreadPoolExecutor r102 = AppExecutors.getInstance().lbsLightLocationExecutor();     // Catch: Throwable -> L9
        r101.getClass();     // Catch: Throwable -> L9
        List r103 = (List) r102.submit(new a(r101)).get();     // Catch: Throwable -> L9
    L12:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r110, LBSLightLocationTraceLogger.GET_SCAN_RESULTS);
        if (r103 == null) goto L48;
        LocationMonitor.lbsLightLocationTraceMetricBegin(r110, LBSLightLocationTraceLogger.TRIM_SCAN_RESULTS);
        ArrayList r104 = new ArrayList(r103.size());
        Iterator r105 = r103.iterator();
        long r106 = -1;
    L16:
        if (r105.hasNext() == false) goto L33;
        ScanResult r107 = (ScanResult) r105.next();
        if (r107 == null) goto L16;
        if (TextUtils.isEmpty(r107.SSID) == true) goto L16;
        if (TextUtils.isEmpty(r107.BSSID) == true) goto L16;
        String r108 = r107.capabilities;
        if (r108 == null) goto L28;
        if (r108.contains("[IBSS]") == true) goto L16;
    L28:
        long r109 = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) + (r107.timestamp / 1000);
        if (r109 <= r106) goto L31;
        r106 = r109;
    L31:
        r107.timestamp = r109 / 1000;
        r104.add(r107);
        goto L16
    L33:
        if (r106 <= 0) goto L35;
        long r112 = System.currentTimeMillis() - r106;
        r111.setLightLocationWifiGap(r112);
        LocationMonitor.lbsLightLocationTracePutMetricData(r110, LBSLightLocationTraceLogger.WIFI_TIMELINESS, r112);
    L35:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r110, LBSLightLocationTraceLogger.TRIM_SCAN_RESULTS);
        if (r104.isEmpty() == true) goto L46;
        LocationMonitor.lbsLightLocationTraceMetricBegin(r110, "sort");
        Collections.sort(r104, new b());
        LocationMonitor.lbsLightLocationTraceMetricEnd(r110, "sort");
        LocationMonitor.lbsLightLocationTraceMetricBegin(r110, LBSLightLocationTraceLogger.SUB_SCAN_LIST);
        int r113 = BDLocationConfig.getWifiNum();
        if (r113 > 0) goto L40;
        r113 = 30;
    L40:
        int r114 = r104.size();
        List<ScanResult> r115 = r104;
        if (r114 <= r113) goto L43;
        r115 = r104.subList(0, r113);
    L43:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r110, LBSLightLocationTraceLogger.SUB_SCAN_LIST);
        return r115;
    L46:
        throw new BDLocationException("wifi get scan results is empty(not null)", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    L48:
        throw new BDLocationException("getWifiScanResultsForLBSLightLocation failed: scanResults == null", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    L9:
        th = move-exception;
        th.printStackTrace();
        r103 = null;
        goto L12
    L11:
        LocationMonitor.lbsLightLocationTracePutCategoryData(r110, LBSLightLocationTraceLogger.INDEPENDENT_THREAD_GET_SCAN_RESULTS, Boolean.FALSE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r110, LBSLightLocationTraceLogger.GET_SCAN_RESULTS_INNER);
        r103 = com_bytedance_bdlocation_scan_wifi_LBSLightWifiUtils_android_net_wifi_WifiManager_getScanResults(r101);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r110, LBSLightLocationTraceLogger.GET_SCAN_RESULTS_INNER);
        goto L12
    L50:
        throw new BDLocationException("getWifiScanResultsForLBSLightLocation failed: context == null", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    }

    private static /* synthetic */ int lambda$getWifiScanResultsForLBSLightLocation$0(ScanResult r100, ScanResult r101) {
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        return 0;
    L6:
        if (r100 != null) goto L9;
        return 1;
    L9:
        if (r101 != null) goto L13;
        return -1;
    L13:
        return r101.level - r100.level;
    }
}

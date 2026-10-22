package com.bytedance.bdlocation.scan.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LBSLightWifiUtils {
    public LBSLightWifiUtils() {
    }

    public static /* synthetic */ int a(ScanResult r0, ScanResult r1) {
        return lambda$getWifiScanResultsForLBSLightLocation$0(r0, r1);
    }

    private static List com_bytedance_bdlocation_scan_wifi_LBSLightWifiUtils_android_net_wifi_WifiManager_getScanResults(WifiManager r13) throws BDLocationException {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(102300, "android/net/wifi/WifiManager", "getScanResults", r13, r9, "java.util.List", r10);
        if (r11.a == false) goto L6;
        r8.a(102300, "android/net/wifi/WifiManager", "getScanResults", r13, r9, null, r10, false);
        return (List) r11.b;
    L6:
        List<ScanResult> r12 = r13.getScanResults();
        r8.a(102300, "android/net/wifi/WifiManager", "getScanResults", r13, r9, r12, r10, true);
        return r12;
    }

    public static List<ScanResult> getWifiScanResultsForLBSLightLocation(LBSLightLocationTraceLogger r14, LocationOption r15) throws BDLocationException {
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.PRE_SCAN_RESULTS);
        Context r1 = BDLocationConfig.getContext();
        if (r1 == null) goto L50;
        final WifiManager r2 = (WifiManager) r1.getApplicationContext().getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.PRE_SCAN_RESULTS);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.GET_BPEA_MANAGER);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.GET_BPEA_MANAGER);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.GET_SCAN_RESULTS);
        if (BDLocationConfig.isIndependentThreadGetScanResults() == false) goto L11;
        LocationMonitor.lbsLightLocationTracePutCategoryData(r14, LBSLightLocationTraceLogger.INDEPENDENT_THREAD_GET_SCAN_RESULTS, Boolean.TRUE);
        ThreadPoolExecutor r4 = AppExecutors.getInstance().lbsLightLocationExecutor();     // Catch: Throwable -> L9
        r2.getClass();     // Catch: Throwable -> L9
        List r3 = (List) r4.submit(new a(r2)).get();     // Catch: Throwable -> L9
    L12:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.GET_SCAN_RESULTS);
        if (r3 == null) goto L48;
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.TRIM_SCAN_RESULTS);
        ArrayList r5 = new ArrayList(r3.size());
        Iterator r6 = r3.iterator();
        long r7 = -1;
    L16:
        if (r6.hasNext() == false) goto L33;
        ScanResult r8 = (ScanResult) r6.next();
        if (r8 == null) goto L16;
        if (TextUtils.isEmpty(r8.SSID) == true) goto L16;
        if (TextUtils.isEmpty(r8.BSSID) == true) goto L16;
        String r9 = r8.capabilities;
        if (r9 == null) goto L28;
        if (r9.contains("[IBSS]") == true) goto L16;
    L28:
        long r10 = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) + (r8.timestamp / 1000);
        if (r10 <= r7) goto L31;
        r7 = r10;
    L31:
        r8.timestamp = r10 / 1000;
        r5.add(r8);
        goto L16
    L33:
        if (r7 <= 0) goto L35;
        long r11 = System.currentTimeMillis() - r7;
        r15.setLightLocationWifiGap(r11);
        LocationMonitor.lbsLightLocationTracePutMetricData(r14, LBSLightLocationTraceLogger.WIFI_TIMELINESS, r11);
    L35:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.TRIM_SCAN_RESULTS);
        if (r5.isEmpty() == true) goto L46;
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.SORT);
        Collections.sort(r5, new b());
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.SORT);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.SUB_SCAN_LIST);
        int r0 = BDLocationConfig.getWifiNum();
        if (r0 > 0) goto L40;
        r0 = 30;
    L40:
        int r12 = r5.size();
        List<ScanResult> r13 = r5;
        if (r12 <= r0) goto L43;
        r13 = r5.subList(0, r0);
    L43:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.SUB_SCAN_LIST);
        return r13;
    L46:
        throw new BDLocationException("wifi get scan results is empty(not null)", "2.17.6-rc.81", BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    L48:
        throw new BDLocationException("getWifiScanResultsForLBSLightLocation failed: scanResults == null", "2.17.6-rc.81", BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    L9:
        th = move-exception;
        th.printStackTrace();
        r3 = null;
        goto L12
    L11:
        LocationMonitor.lbsLightLocationTracePutCategoryData(r14, LBSLightLocationTraceLogger.INDEPENDENT_THREAD_GET_SCAN_RESULTS, Boolean.FALSE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.GET_SCAN_RESULTS_INNER);
        r3 = com_bytedance_bdlocation_scan_wifi_LBSLightWifiUtils_android_net_wifi_WifiManager_getScanResults(r2);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.GET_SCAN_RESULTS_INNER);
        goto L12
    L50:
        throw new BDLocationException("getWifiScanResultsForLBSLightLocation failed: context == null", "2.17.6-rc.81", BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    }

    private static /* synthetic */ int lambda$getWifiScanResultsForLBSLightLocation$0(ScanResult r0, ScanResult r1) {
        if (r0 != null) goto L6;
        if (r1 != null) goto L6;
        return 0;
    L6:
        if (r0 != null) goto L9;
        return 1;
    L9:
        if (r1 != null) goto L13;
        return -1;
    L13:
        return r1.level - r0.level;
    }
}

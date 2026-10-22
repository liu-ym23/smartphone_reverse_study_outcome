package com.bytedance.bdlocation.scan.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class WifiUtil {
    private static final Field SCAN_RESULT_BSSID_FIELD = null;
    private static final Field SCAN_RESULT_SSID_FIELD = null;
    public static final String TAG = "WifiUtil";

    public interface WifiInfoJsonCallback {
        void onFailed(BDLocationException r1);

        void onWifiInfoJson(JsonArray r1, boolean r2, boolean r3, WifiInfo r4);
    }

    public WifiUtil() {
    }

    public static /* synthetic */ List a(IBPEALocal r0, WifiManager r1, Object r2) {
        return lambda$getWifiScanResultsForLBSLightLocation$1(r0, r1, r2);
    }

    public static /* synthetic */ void b(LocationTraceLogger r0, long r1, WifiInfoJsonCallback r3, List r4, boolean r5, boolean r6, WifiInfo r7) {
        lambda$getWifiInfoJsonAsync$0(r0, r1, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ int c(ScanResult r0, ScanResult r1) {
        return lambda$getWifiScanResultsForLBSLightLocation$2(r0, r1);
    }

    static {
        Field r0 = ScanResult.class.getDeclaredField("SSID");     // Catch: Throwable -> L4
        Field r1 = ScanResult.class.getDeclaredField("BSSID");     // Catch: Throwable -> L4
    L6:
        SCAN_RESULT_SSID_FIELD = r0;
        SCAN_RESULT_BSSID_FIELD = r1;
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
        r0 = null;
        r1 = null;
        goto L6
    }

    public static JsonArray getMockWifiJson() {
        ArrayList r0 = new ArrayList();
        WifiInfo r1 = new WifiInfo();
        r1.wifiMac = LocationInfoConst.MOCK_WIFI_MAC;
        r1.rssi = 0;
        r1.isCurrent = 1;
        r1.wifiName = BDLocationConfig.getMockWifiName();
        r1.timeStamp = getCurrentTimeSeconds();
        r0.add(r1);
        JsonElement r2 = JsonUtil.toJsonTreeSafely(r0, new AnonymousClass3().getType());
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.isJsonArray() == true) goto L8;
        return null;
    L8:
        return r2.getAsJsonArray();
    }

    public static long getCurrentTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    public static String getScanResultBSSIDByReflect(ScanResult r5) {
        if (r5 == null) goto L12;
        Field r2 = SCAN_RESULT_BSSID_FIELD;
        if (r2 == null) goto L12;
        return (String) r2.get(r5);
    L9:
        th = move-exception;
        th.printStackTrace();
        Logger.e("getScanResultBSSIDByReflect failed: " + th, th);
        LocationMonitor.monitorReflectScanResultFailed(-2, 1, th.getMessage());
        return null;
    L12:
        StringBuilder r3 = new StringBuilder("getScanResultBSSIDByReflect failed: scanResult == null: ");
        boolean r4 = false;
        if (r5 != null) goto L15;
        boolean r6 = true;
    L16:
        r3.append(r6);
        r3.append(", SCAN_RESULT_BSSID_FIELD == null: ");
        if (SCAN_RESULT_BSSID_FIELD != null) goto L19;
        r4 = true;
    L19:
        r3.append(r4);
        Logger.e(r3.toString());
        if (r5 == null) goto L22;
        LocationMonitor.monitorReflectScanResultFailed(-1, 1, "SCAN_RESULT_BSSID_FIELD == null");
    L22:
        return null;
    L15:
        r6 = false;
        goto L16
    }

    public static String getScanResultSSIDByReflect(ScanResult r5) {
        if (r5 == null) goto L12;
        Field r2 = SCAN_RESULT_SSID_FIELD;
        if (r2 == null) goto L12;
        return (String) r2.get(r5);
    L9:
        th = move-exception;
        th.printStackTrace();
        Logger.e("getScanResultSSIDByReflect failed: " + th, th);
        LocationMonitor.monitorReflectScanResultFailed(-2, 0, th.getMessage());
        return null;
    L12:
        StringBuilder r3 = new StringBuilder("getScanResultSSIDByReflect failed: scanResult == null: ");
        boolean r4 = true;
        if (r5 != null) goto L15;
        boolean r6 = true;
    L16:
        r3.append(r6);
        r3.append(", SCAN_RESULT_SSID_FIELD == null: ");
        if (SCAN_RESULT_SSID_FIELD == null) goto L20;
        r4 = false;
    L20:
        r3.append(r4);
        Logger.e(r3.toString());
        if (r5 == null) goto L23;
        LocationMonitor.monitorReflectScanResultFailed(-1, 0, "SCAN_RESULT_SSID_FIELD == null");
    L23:
        return null;
    L15:
        r6 = false;
        goto L16
    }

    public static JsonArray getWifiInfoJson(Context r2, Object r3) {
        if (r2 != null) goto L21;
        return null;
    L21:
    L18:
        e = move-exception;
        Logger.e("", e);
        return null;
    L6:
        if (BDLocationConfig.isUploadWIFI() == false) goto L23;
        List<WifiInfo> r4 = WifiInfoManager.getWifiInfos(r2, r3, true);     // Catch: Exception -> L18
        if (getWifiListByNum(r4, false) != null) goto L10;
        return null;
    L10:
        JsonElement r5 = JsonUtil.toJsonTreeSafely(r4, new AnonymousClass2().getType());     // Catch: Exception -> L18
        if (r5 != null) goto L13;
    L17:
        return null;
    L13:
        if (r5.isJsonArray() == false) goto L17;
        return r5.getAsJsonArray();
    L23:
        return null;
    }

    private static List<WifiInfo> getWifiListByNum(List<WifiInfo> r1, boolean r2) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (r1.isEmpty() == true) goto L18;
        Collections.sort(r1);
        int r0 = r1.size();
        if (r2 == false) goto L12;
        if (r0 <= 30) goto L15;
        r0 = 30;
    L15:
        return r1.subList(0, r0);
    L12:
        if (r0 <= BDLocationConfig.getWifiNum()) goto L15;
        r0 = BDLocationConfig.getWifiNum();
        goto L15
    L18:
        return null;
    }

    public static WifiInfoModule getWifiModule(Context r5, boolean r6) {
        if (r5 != null) goto L14;
        return null;
    L14:
        WifiInfoModule r7 = WifiInfoManager.getWifiModule(r5, null, true, r6, null);     // Catch: Exception -> L11
        if (r7 != null) goto L9;
        return null;
    L9:
        return new WifiInfoModule(getWifiListByNum(r7.wifiInfoList, r6), r7.connectWifi, r7.cacheWifiTime);
    L11:
        e = move-exception;
        Logger.e("", e);
        return null;
    }

    public static List<ScanResult> getWifiScanResultsForLBSLightLocation(final Object r13, LBSLightLocationTraceLogger r14) throws BDLocationException {
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.PRE_SCAN_RESULTS);
        Context r1 = BDLocationConfig.getContext();
        if (r1 == null) goto L50;
        final WifiManager r2 = (WifiManager) r1.getApplicationContext().getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.PRE_SCAN_RESULTS);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.GET_BPEA_MANAGER);
        final IBPEALocal r4 = BDLocationExtrasService.getBPEAManager();
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.GET_BPEA_MANAGER);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.GET_SCAN_RESULTS);
        if (BDLocationConfig.isIndependentThreadGetScanResults() == false) goto L11;
        LocationMonitor.lbsLightLocationTracePutCategoryData(r14, LBSLightLocationTraceLogger.INDEPENDENT_THREAD_GET_SCAN_RESULTS, Boolean.TRUE);
        List r15 = (List) AppExecutors.getInstance().lbsLightLocationExecutor().submit(new k(r4, r2, r13)).get();     // Catch: Throwable -> L9
    L12:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.GET_SCAN_RESULTS);
        if (r15 == null) goto L48;
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.TRIM_SCAN_RESULTS);
        ArrayList r3 = new ArrayList(r15.size());
        Iterator r16 = r15.iterator();
        long r5 = -1;
    L16:
        if (r16.hasNext() == false) goto L33;
        ScanResult r6 = (ScanResult) r16.next();
        if (r6 == null) goto L16;
        if (TextUtils.isEmpty(getScanResultSSIDByReflect(r6)) == true) goto L16;
        if (TextUtils.isEmpty(getScanResultBSSIDByReflect(r6)) == true) goto L16;
        String r7 = r6.capabilities;
        if (r7 == null) goto L28;
        if (r7.contains("[IBSS]") == true) goto L16;
    L28:
        long r8 = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) + (r6.timestamp / 1000);
        if (r8 <= r5) goto L31;
        r5 = r8;
    L31:
        r6.timestamp = r8 / 1000;
        r3.add(r6);
        goto L16
    L33:
        if (r5 <= 0) goto L35;
        LocationMonitor.lbsLightLocationTracePutMetricData(r14, LBSLightLocationTraceLogger.WIFI_TIMELINESS, System.currentTimeMillis() - r5);
    L35:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.TRIM_SCAN_RESULTS);
        if (r3.isEmpty() == true) goto L46;
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.SORT);
        Collections.sort(r3, new l());
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.SORT);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.SUB_SCAN_LIST);
        int r0 = BDLocationConfig.getWifiNum();
        if (r0 > 0) goto L40;
        r0 = 30;
    L40:
        int r9 = r3.size();
        List<ScanResult> r10 = r3;
        if (r9 <= r0) goto L43;
        r10 = r3.subList(0, r0);
    L43:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.SUB_SCAN_LIST);
        return r10;
    L46:
        throw new BDLocationException("wifi get scan results is empty(not null)", "2.17.6-rc.81", BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    L48:
        throw new BDLocationException("getWifiScanResultsForLBSLightLocation failed: scanResults == null", "2.17.6-rc.81", BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    L9:
        th = move-exception;
        th.printStackTrace();
        r15 = null;
        goto L12
    L11:
        LocationMonitor.lbsLightLocationTracePutCategoryData(r14, LBSLightLocationTraceLogger.INDEPENDENT_THREAD_GET_SCAN_RESULTS, Boolean.FALSE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.GET_SCAN_RESULTS_INNER);
        r15 = r4.getScanResults(r2, r13);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.GET_SCAN_RESULTS_INNER);
        goto L12
    L50:
        throw new BDLocationException("getWifiScanResultsForLBSLightLocation failed: context == null", "2.17.6-rc.81", BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    }

    private static /* synthetic */ int lambda$getWifiScanResultsForLBSLightLocation$2(ScanResult r0, ScanResult r1) {
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

    private static /* synthetic */ List lambda$getWifiScanResultsForLBSLightLocation$1(IBPEALocal r0, WifiManager r1, Object r2) throws Exception {
        return r0.getScanResults(r1, r2);
    }

    public static void getWifiInfoJsonAsync(Context r6, final WifiInfoJsonCallback r7, Object r8, final LocationTraceLogger r9, LocationOption r10) {
    L12:
        e = move-exception;
        Logger.e("", e);
        LocationMonitor.locationTracePutCategoryData(r9, LocationMonitorConst.WIFI_SCAN_SUCCESS, Boolean.FALSE);
        r7.onFailed(new BDLocationException(e.getMessage(), null, BDLocationException.ERROR_WIFI_UPLOAD));
        return;
    L4:
        if (BDLocationConfig.isUploadWIFI() == true) goto L6;
    L10:
        Logger.i("WifiUtil.getWifiInfoJsonAsync: skip wifi collect.");     // Catch: Exception -> L12
        LocationMonitor.locationTracePutCategoryData(r9, LocationMonitorConst.WIFI_SCAN_SUCCESS, Boolean.FALSE);     // Catch: Exception -> L12
        r7.onFailed(new BDLocationException("没有开启wifi上报", null, BDLocationException.ERROR_WIFI_UPLOAD));     // Catch: Exception -> L12
    L15:
        return;
    L6:
        if (BDLocationConfig.needRevertWifiOrStationInfoUpload(r10) == true) goto L10;
        if (LocationUtil.enableContinueLocateUploadSensitiveSignal(r10, BDLocationConfig.isContinueLocateUploadWifi()) == false) goto L10;
        LocationMonitor.locationTraceLogBegin(r9, LocationMonitorConst.SCAN_WIFI_DURATION);     // Catch: Exception -> L12
        WifiInfoManager r11 = new WifiInfoManager();     // Catch: Exception -> L12
        final long r3 = SystemClock.elapsedRealtime();     // Catch: Exception -> L12
        r11.getWifiScanInfos(r6, new j(r9, r3, r7), r8, r9);     // Catch: Exception -> L12
        goto L15
    }

    private static /* synthetic */ void lambda$getWifiInfoJsonAsync$0(LocationTraceLogger r3, long r4, WifiInfoJsonCallback r6, List r7, boolean r8, boolean r9, WifiInfo r10) {
        LocationMonitor.locationTracePutCategoryData(r3, LocationMonitorConst.IS_WIFI_CACHE, Boolean.valueOf(r8));
        LocationMonitor.locationTracePutCategoryData(r3, LocationMonitorConst.WIFI_SCAN_SUCCESS, Boolean.TRUE);
        LocationMonitor.locationTraceLogEnd(r3, LocationMonitorConst.SCAN_WIFI_DURATION);
        LocationMonitor.fetchWifiDuration(SystemClock.elapsedRealtime() - r4, r8);
        Logger.i("LocationMonitor fetch wifi duration is: " + (SystemClock.elapsedRealtime() - r4) + "ms");
        boolean r5 = false;
        List<WifiInfo> r11 = getWifiListByNum(r7, false);
        if (r11 != null) goto L5;
    L9:
        JsonArray r12 = null;
    L10:
        if (r12 != null) goto L12;
        r5 = true;
    L12:
        LocationMonitor.locationTracePutCategoryData(r3, LocationMonitorConst.IS_WIFI_NULL, Boolean.valueOf(r5));
        r6.onWifiInfoJson(r12, r8, r9, r10);
        return;
    L5:
        if (r11.size() <= 0) goto L9;
        JsonElement r13 = JsonUtil.toJsonTreeSafely(r11, new AnonymousClass1().getType());
        if (r13 == null) goto L9;
        r12 = r13.getAsJsonArray();
        goto L10
    }
}

package com.bytedance.bdlocation_impl.shake;

import android.text.TextUtils;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.entity.bpea.BPEACertCheckResult;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.sensor.SensorBatchGpsCollector;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class BDShakeConfig {
    public static final String SHAKE_UPLOAD_SOURCE = "BDShake";
    public static final String TAG = "BDShakeTask";
    private static boolean isStartLocationTask = true;
    private static long sBleScanInterval = 20000;
    private static long sBleScanTime = 2000;
    private static int sBleUploadNum = 50;
    private static long sClassicScanTime = 2000;
    private static long sGetLocationInterval = 60000;
    private static long sGpsCacheTime = 60000;
    private static long sScanTimeoutMS = 1800000;
    private static boolean sShakeUploadBle = true;
    private static long sShakeUploadInterval = 60000;
    private static boolean sShakeUploadWifi = true;
    private static long sWifiScanInterval = 30000;
    private static int sWifiUploadNum = 30;
    public static final String startScanAction = "startScanTask";
    private static String userId = "";

    public BDShakeConfig() {
    }

    public static String getTestUserId() {
        if (TextUtils.isEmpty(userId) == false) goto L5;
        String r0 = String.valueOf(System.currentTimeMillis()).substring(7);
        userId = r0;
        return r0;
    L5:
        return userId;
    }

    public static void stopScanTask() {
        if (BDLocationConfig.initIfNeed() == true) goto L6;
        Logger.i("startShakeUpload Must be called after BDLocation initialization!");
        return;
    L6:
        BDShakeCollectService.getInstance().stopScanTask();
    }

    public static long getBleScanInterval() {
        return sBleScanInterval;
    }

    public static long getBleScanTime() {
        return sBleScanTime;
    }

    public static int getBleUploadNum() {
        return sBleUploadNum;
    }

    public static long getClassicScanTime() {
        return sClassicScanTime;
    }

    public static long getGpsCacheTime() {
        return sGpsCacheTime;
    }

    public static long getLocationInterval() {
        return sGetLocationInterval;
    }

    public static long getScanTimeoutMS() {
        return sScanTimeoutMS;
    }

    public static long getShakeUploadInterval() {
        return sShakeUploadInterval;
    }

    public static long getWifiScanInterval() {
        return sWifiScanInterval;
    }

    public static int getWifiUploadNum() {
        return sWifiUploadNum;
    }

    public static boolean isShakeUploadBle() {
        return sShakeUploadBle;
    }

    public static boolean isShakeUploadWifi() {
        return sShakeUploadWifi;
    }

    public static boolean isStartLocationTask() {
        return isStartLocationTask;
    }

    public static void setBleScanInterval(long r3) {
        if (r3 >= SensorBatchGpsCollector.DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS) goto L5;
        return;
    L5:
        sBleScanInterval = r3;
    }

    public static void setBleScanTime(long r3) {
        if (r3 >= SensorBatchGpsCollector.DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS) goto L5;
        return;
    L5:
        sBleScanTime = r3;
    }

    public static void setBleUploadNum(int r1) {
        if (r1 >= 10) goto L5;
        return;
    L5:
        sBleUploadNum = r1;
    }

    public static void setClassicScanTime(long r3) {
        if (r3 >= SensorBatchGpsCollector.DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS) goto L5;
        return;
    L5:
        sClassicScanTime = r3;
    }

    public static void setGpsCacheTime(long r3) {
        if (r3 >= 60000) goto L5;
        return;
    L5:
        sGpsCacheTime = r3;
    }

    public static void setLocationInterval(long r3) {
        if (r3 >= 60000) goto L5;
        return;
    L5:
        sGetLocationInterval = r3;
    }

    public static void setScanTimeoutMS(long r3) {
        if (r3 >= 600000) goto L5;
        return;
    L5:
        sScanTimeoutMS = r3;
    }

    public static void setShakeParams(JSONObject r4) {
        if (r4 == null) goto L5;
        Logger.i("shake obj:" + r4.toString());
        setBleScanInterval((long) r4.optInt(LocationExtraDataTraceLogger.BLE_SCAN_INTERVAL, 2000));
        setWifiScanInterval((long) r4.optInt("wifi_scan_interval", 10000));
        setBleScanTime(r4.optInt("ble_scan_time", 2000));
        setClassicScanTime(r4.optInt("classic_scan_time", 2000));
        setBleUploadNum(r4.optInt("ble_upload_num", 50));
        setShakeUploadWifi(r4.optBoolean("shake_upload_wifi", true));
        setShakeUploadBle(r4.optBoolean("shake_upload_ble", true));
        setStartLocationTask(r4.optBoolean("start_location_task", true));
        setLocationInterval(r4.optInt(LocationMonitorConst.LOCATION_INTERVAL, 60000));
        setGpsCacheTime(r4.optInt("gps_cache_time", 60000));
        setScanTimeoutMS(r4.optInt("scan_timeout_ms", 1800000));
        return;
    }

    public static void setShakeUploadBle(boolean r0) {
        sShakeUploadBle = r0;
    }

    public static void setShakeUploadInterval(long r5) {
        if (sShakeUploadInterval >= 60000) goto L5;
        return;
    L5:
        sShakeUploadInterval = r5;
    }

    public static void setShakeUploadWifi(boolean r0) {
        sShakeUploadWifi = r0;
    }

    public static void setStartLocationTask(boolean r0) {
        isStartLocationTask = r0;
    }

    public static void setWifiScanInterval(long r3) {
        if (r3 >= 10000) goto L5;
        return;
    L5:
        sWifiScanInterval = r3;
    }

    public static void setWifiUploadNum(int r1) {
        if (r1 >= 10) goto L5;
        return;
    L5:
        sWifiUploadNum = r1;
    }

    public static void startScanTask(Object r4) {
        if (BDLocationConfig.initIfNeed() == true) goto L7;
        Logger.i("startShakeUpload Must be called after BDLocation initialization!");
        return;
    L7:
        if (LocationUtil.checkBackground() == false) goto L20;
        return;
    L20:
        BDShakeCollectService.getInstance().setUploadSource(SHAKE_UPLOAD_SOURCE);     // Catch: Exception -> L17
        LocationUtil.checkBpeaCertNull(startScanAction, r4);     // Catch: Exception -> L17
        if (r4 == null) goto L15;
        BPEACertCheckResult r2 = BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r4, startScanAction);     // Catch: Exception -> L17
        if (r2 == null) goto L14;
        setShakeParams(r2.getParams());     // Catch: Exception -> L17
    L14:
        BDShakeCollectService.getInstance().setUploadSource(BDLocationExtrasService.getBPEAManager().getBpeaToken(r4));     // Catch: Exception -> L17
    L15:
        Logger.d("ShakeTaskScan result:" + BDShakeCollectService.getInstance().startScanTask(r4, startScanAction));     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        Logger.d("BDLocation" + e.getMessage());
    }

    public static void startShakeUpload(Object r1, String r2, JSONObject r3, ShakeUploadCallback r4) {
        if (BDLocationConfig.initIfNeed() == true) goto L11;
        Logger.i("startShakeUpload Must be called after BDLocation initialization!");
        return;
    L11:
        LocationUtil.checkBpeaCertNull("startShakeUpload", r1);     // Catch: BDLocationException -> L8
        BDShakeCollectService.getInstance().startShakeUpload(r1, r2, r3, r4);     // Catch: BDLocationException -> L8
        return;
    L8:
        e = move-exception;
        r4.onError(e);
    }
}

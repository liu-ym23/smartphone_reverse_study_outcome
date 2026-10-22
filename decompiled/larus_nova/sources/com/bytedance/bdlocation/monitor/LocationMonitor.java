package com.bytedance.bdlocation.monitor;

import android.text.TextUtils;
import android.util.Log;
import androidx.camera.video.AudioStats;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.store.BDLightLocationCache;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class LocationMonitor {
    private static AtomicBoolean isUploadLightLocationMonitor;

    public LocationMonitor() {
    }

    static {
        isUploadLightLocationMonitor = new AtomicBoolean(false);
    }

    public static void getLightLocationMonitor() {
        if (isUploadLightLocationMonitor.getAndSet(true) == false) goto L5;
        return;
    L5:
        JSONObject r100 = BDLightLocationCache.getAndClearRequestCellUpdateMonitorData();
        JSONObject r101 = BDLightLocationCache.getAndClearRequestWifiCacheUpdateMonitorData();
        JSONObject r102 = BDLightLocationCache.getAndClearLightLocationMonitorData();
        requestLightLocationInfoUpdateMonitor(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        requestLightLocationInfoUpdateMonitor(r101, "wifi");
        getLightLocationInfoMonitor(r102);
        lightLocationInfoUpdateWholeMonitor(r100, r101, r102);
    }

    public static void doFirstSubmitDuration(long r100) {
        JSONObject r101 = new JSONObject();
        JsonUtil.safePutBoolean(r101, LocationMonitorConst.IS_MAIN_PROCESS, i.c(BDLocationConfig.getContext()));
        JSONObject r102 = new JSONObject();
        JsonUtil.safePutLong(r102, "total_duration", r100);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_FIRST_SUBMIT_DURATION, r101, r102);
    }

    public static void fetchStationDuration(long r100) {
        JSONObject r101 = new JSONObject();
        JsonUtil.safePutLong(r101, "total_duration", r100);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_FETCH_STATION_DURATION, null, r101);
    }

    private static void getLightLocationInfoMonitor(JSONObject r310) {
        if (r310 != null) goto L5;
        return;
    L5:
        boolean r100 = r310.optBoolean(LocationMonitorConst.IS_COLD_BOOT);
        boolean r101 = r310.optBoolean("is_downgrade");
        long r102 = r310.optLong(LocationMonitorConst.APP_BOOT_TIME);
        String r103 = r310.optString(LocationMonitorConst.LIGHT_LOCATION_TYPE);
        boolean r110 = r310.optBoolean(LocationMonitorConst.HAS_CELL_LOCATION_INFO);
        boolean r111 = r310.optBoolean(LocationMonitorConst.HAS_WIFI_LOCATION_INFO);
        long r104 = r310.optLong(LocationMonitorConst.COLD_BOOT_TO_GET_LIGHT_LOCATION_INFO_DURATION);
        boolean r112 = r310.optBoolean(LocationMonitorConst.HAS_LIGHT_LOCATION_INFO);
        boolean r105 = r310.optBoolean(LocationMonitorConst.IS_START_CELL_LIGHT_REQUEST);
        boolean r106 = r310.optBoolean(LocationMonitorConst.IS_END_CELL_LIGHT_REQUEST);
        boolean r107 = r310.optBoolean(LocationMonitorConst.IS_START_WIFI_LIGHT_REQUEST);
        boolean r108 = r310.optBoolean(LocationMonitorConst.IS_END_WIFI_LIGHT_REQUEST);
        int r109 = r310.optInt(LocationMonitorConst.HAS_LOCATION_PERMISSION);
        boolean r113 = r310.optBoolean(LocationMonitorConst.IS_ACTIVITY_COMPONENT_TYPE);
        int r114 = r310.optInt(LocationMonitorConst.FEED_HAS_AVAILABLE_DATA);
        int r115 = r310.optInt(LocationMonitorConst.FEED_CALL_TYPE);
        long r116 = r310.optLong(LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL);
        JSONObject r117 = new JSONObject();
        JsonUtil.safePutBoolean(r117, LocationMonitorConst.IS_COLD_BOOT, r100);
        JsonUtil.safePutBoolean(r117, "is_downgrade", r101);
        JsonUtil.safePutBoolean(r117, LocationMonitorConst.HAS_CELL_LOCATION_INFO, r110);
        JsonUtil.safePutBoolean(r117, LocationMonitorConst.HAS_WIFI_LOCATION_INFO, r111);
        JsonUtil.safePutString(r117, LocationMonitorConst.LIGHT_LOCATION_TYPE, r103);
        JsonUtil.safePutBoolean(r117, LocationMonitorConst.HAS_LIGHT_LOCATION_INFO, r112);
        JsonUtil.safePutBoolean(r117, LocationMonitorConst.IS_START_CELL_LIGHT_REQUEST, r105);
        JsonUtil.safePutBoolean(r117, LocationMonitorConst.IS_END_CELL_LIGHT_REQUEST, r106);
        JsonUtil.safePutBoolean(r117, LocationMonitorConst.IS_START_WIFI_LIGHT_REQUEST, r107);
        JsonUtil.safePutBoolean(r117, LocationMonitorConst.IS_END_WIFI_LIGHT_REQUEST, r108);
        JsonUtil.safePutInt(r117, LocationMonitorConst.HAS_LOCATION_PERMISSION, r109);
        JsonUtil.safePutBoolean(r117, LocationMonitorConst.IS_ACTIVITY_COMPONENT_TYPE, r113);
        JsonUtil.safePutInt(r117, LocationMonitorConst.FEED_HAS_AVAILABLE_DATA, r114);
        JsonUtil.safePutInt(r117, LocationMonitorConst.FEED_CALL_TYPE, r115);
        JsonUtil.safePutLong(r117, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, r116);
        JSONObject r118 = new JSONObject();
        if (r104 == 0) goto L8;
        JsonUtil.safePutLong(r118, LocationMonitorConst.COLD_BOOT_TO_GET_LIGHT_LOCATION_INFO_DURATION, r104);
    L8:
        JSONObject r119 = new JSONObject();
        if (r102 <= 0) goto L11;
        JsonUtil.safePutLong(r119, LocationMonitorConst.APP_BOOT_TIME, r102);
    L11:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.BD_LOCATION_COLD_BOOT_GET_LIGHT_LOCATION_DURATION, r117, r118, r119);
    }

    public static void locationExtraDataTraceLogSuccessReport(LocationOption r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        LocationExtraDataTraceLogger r101 = r100.getLocationExtraDataTraceLogger();
        if (r101 != null) goto L7;
        return;
    L7:
        r101.locationExtraDataSuccessReport();
    }

    public static void overseasLocationFailedGetCache(boolean r100) {
        JSONObject r101 = new JSONObject();
        JsonUtil.safePutBoolean(r101, LocationMonitorConst.OVERSEAS_GET_LOCATION_FAILED_CACHE_IS_VALIDITY, r100);
        JsonUtil.safePutLong(r101, "cache_time", BDLocationConfig.getOverseasGetLocationFailedUseCacheValidity());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_OVERSEAS_GET_LOCATION_FAILED_CACHE_VALIDITY, r101, null, null);
    }

    public static void withoutCert(String r100) {
        JSONObject r101 = new JSONObject();
        JsonUtil.safePutString(r101, "method_name", r100);
        JSONObject r102 = new JSONObject();
        JsonUtil.safePutString(r102, "stack_trace", Log.getStackTraceString(new Throwable()));
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BPEA_WITHOUT_CERT_CHECK, r101, null, r102);
    }

    public static void certNullCheck(String r100, Object r101) {
        if (r101 == null) goto L4;
        return;
    L4:
        Logger.i("bpea cert is null:" + r100);
        long r102 = System.currentTimeMillis();
        StackTraceElement[] r103 = ThreadMethodProxy.currentThread().getStackTrace();
        StringBuilder r104 = new StringBuilder();
        if (r103 != null) goto L7;
    L12:
        doBpeaCertIsNull(r100, System.currentTimeMillis() - r102, r104.toString());
        return;
    L7:
        if (r103.length <= 0) goto L12;
        int r105 = 0;
    L10:
        if (r105 >= r103.length) goto L12;
        r104.append(r103[r105].toString() + "\n");
        r105 = r105 + 1;
        goto L10
    }

    public static void checkLocationProviderEnabledError(Exception r100, String r101) {
        JSONObject r102 = new JSONObject();
        JsonUtil.safePutString(r102, LocationMonitorConst.LOCATION_PROVIDER, r101);
        JSONObject r103 = new JSONObject();
        if (r100 == null) goto L5;
        JsonUtil.safePutString(r103, LocationMonitorConst.DETAIL_ERR_MSG, r100.getMessage());
    L5:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_CHECK_LOCATION_PROVIDER_ENABLED_ERROR, r102, null, r103);
    }

    public static void doBpeaCertParamsNull(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        JsonUtil.safePutString(r102, LocationMonitorConst.BPEA_ACTION, r101);
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutString(r103, LocationMonitorConst.CERT_TOKEN, r100);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BPEA_CHECK_PARAMS_NULL, r102, null, r103);
    }

    public static void doConnectWifiInfo(boolean r100, String r101) {
        JSONObject r102 = new JSONObject();
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_WIFI_OPEN, LocationUtil.isWifiOpen());
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_WIFI_CACHE, r100);
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_WIFI_NULL, TextUtils.isEmpty(r101));
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutString(r103, LocationMonitorConst.CONNECT_WIFI_INFO, r101);
        JsonUtil.safePutString(r103, "stack_trace", Log.getStackTraceString(new Throwable()));
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_CONNECT_WIFI_INFO, r102, null, r103);
    }

    public static void doFirstLocationDuration(long r100, boolean r101) {
        JSONObject r102 = new JSONObject();
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_CACHE, r101);
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_MAIN_PROCESS, i.c(BDLocationConfig.getContext()));
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutLong(r103, "total_duration", r100);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_FIRST_LOCATION_DURATION, r102, r103);
    }

    public static void doScanWiFiList(boolean r100, String r101) {
        JSONObject r102 = new JSONObject();
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_WIFI_OPEN, LocationUtil.isWifiOpen());
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_WIFI_CACHE, r100);
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_WIFI_NULL, TextUtils.isEmpty(r101));
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutString(r103, LocationMonitorConst.SCAN_WIFI_LIST, r101);
        JsonUtil.safePutString(r103, "stack_trace", Log.getStackTraceString(new Throwable()));
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SCAN_WIFI_LIST, r102, null, r103);
    }

    public static void fetchWifiDuration(long r100, boolean r101) {
        JSONObject r102 = new JSONObject();
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_CACHE, r101);
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutLong(r103, "total_duration", r100);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_FETCH_WIFI_DURATION, r102, r103);
    }

    public static void gpsCheckRegion(boolean r100, boolean r101) {
        if (r100 == r101) goto L5;
        JSONObject r102 = new JSONObject();
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_GPS_CHINESE_CHANNEL, r100);
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_REGION_IN_CHINESECHANNEL, r101);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_GPS_CHECK_REGION, r102, null, null);
        return;
    }

    public static void lbsLightLocationTraceMetricBegin(LBSLightLocationTraceLogger r100, String r101) {
        lbsLightLocationTraceMetricBegin(r100, r101, false);
    }

    public static void lbsLightLocationTraceMetricEnd(LBSLightLocationTraceLogger r100, String r101) {
        lbsLightLocationTraceMetricEnd(r100, r101, false);
    }

    public static void locationExtraDataTraceLogBegin(LocationExtraDataTraceLogger r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.begin(r101);
    }

    public static void locationExtraDataTraceLogEnd(LocationExtraDataTraceLogger r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.end(r101);
    }

    public static void locationExtraDataTraceLogErrorReport(LocationOption r100, BDLocationException r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        LocationExtraDataTraceLogger r102 = r100.getLocationExtraDataTraceLogger();
        if (r102 != null) goto L7;
        return;
    L7:
        r102.locationExtraDataErrorReport(r101);
    }

    public static void locationTraceLogBegin(LocationTraceLogger r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.begin(r101);
    }

    public static void locationTraceLogEnd(LocationTraceLogger r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.end(r101);
    }

    public static void locationTraceLogErrorReport(LocationOption r100, BDLocationException r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        LocationTraceLogger r102 = r100.getLocationTraceLogger();
        if (r102 != null) goto L7;
        return;
    L7:
        r102.locationErrorReport(r101);
    }

    public static void locationTraceLogSuccessReport(BDLocation r100, LocationOption r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        LocationTraceLogger r102 = r101.getLocationTraceLogger();
        if (r102 != null) goto L7;
        return;
    L7:
        r102.locationSuccessReport(r100, r101);
    }

    public static void registerNetworkCallbackError(String r100, Exception r101) {
        JSONObject r102 = new JSONObject();
        JsonUtil.safePutString(r102, LocationMonitorConst.REGISTER_NETWORK_ACTION, r100);
        JSONObject r103 = new JSONObject();
        if (r101 == null) goto L5;
        JsonUtil.safePutString(r103, LocationMonitorConst.DETAIL_ERR_MSG, r101.getMessage());
    L5:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_CHECK_LOCATION_PROVIDER_ENABLED_ERROR, r102, null, r103);
    }

    private static void requestLightLocationInfoUpdateMonitor(JSONObject r110, String r111) {
        if (r110 != null) goto L4;
        return;
    L4:
        boolean r100 = r110.optBoolean("is_success");
        boolean r101 = r110.optBoolean(LocationMonitorConst.IS_COLD_BOOT);
        boolean r112 = r110.optBoolean("is_downgrade");
        if (r100 == false) goto L7;
        boolean r102 = r110.optBoolean(LocationMonitorConst.HAS_LIGHT_LOCATION_INFO);
        long r103 = r110.optLong("total_duration");
        long r113 = r110.optLong(LocationMonitorConst.CACHE_DATA_INTERVAL);
        requestLightLocationUpdateSuccess(r103, r102, r101, r110.optLong(LocationMonitorConst.COLD_BOOT_TO_START_REQUEST), r110.optLong(LocationMonitorConst.COLD_BOOT_TO_END_REQUEST), r112, r113, r111);
        return;
    L7:
        requestLightLocationUpdateError(r110.optString(LocationMonitorConst.ERR_MSG), r101, r112, r111);
    }

    public static void uploadAllStackTraces(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L10;
        JSONObject r102 = new JSONObject();
        JsonUtil.safePutString(r102, "method_name", r100);
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutString(r103, "stack_trace", r101);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_LOCATION_ALL_TRACES, r102, null, r103);
        return;
    }

    private static void doBpeaCertIsNull(String r100, long r101, String r102) {
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutString(r103, "method_name", r100);
        JSONObject r104 = new JSONObject();
        JsonUtil.safePutLong(r104, LocationMonitorConst.STACKTRACE_DURATION, r101);
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutString(r105, "stack_trace", r102);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BPEA_CERT_NULL, r103, r104, r105);
    }

    public static void doDesiredLocationFail(long r100, BDLocationException r101, LocationOption r110) {
        JSONObject r102 = new JSONObject();
        if (r101 == null) goto L5;
        JsonUtil.safePutString(r102, LocationMonitorConst.LOCATION_NAME, r101.getSdkName());
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_TIMEOUT, r101.getCode().equals("0"));
        JsonUtil.safePutString(r102, "err_code", r101.getCode());
        JsonUtil.safePutString(r102, LocationMonitorConst.ERR_MSG, r101.getMessage());
    L6:
        JsonUtil.safePutBoolean(r102, "is_success", false);
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_CACHE, false);
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_CN, r110.isChineseRegion());
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_BACKGROUND, r110.isBackground());
        JsonUtil.safePutInt(r102, LocationMonitorConst.BACKGROUND_LOCATION_PERMISSION_STATUS, LocationUtil.getBackgroundLocationPermissionStatus());
        JsonUtil.safePutString(r102, LocationMonitorConst.BPEA_CERT_TOKEN, BDLocationExtrasService.getBPEAManager().getBpeaToken(r110.getBpeaCert()));     // Catch: Exception -> L9
    L10:
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutLong(r103, "total_duration", r100);
        JSONObject r104 = new JSONObject();
        JsonUtil.safePutDouble(r104, LocationMonitorConst.ACCURACY, AudioStats.AUDIO_AMPLITUDE_NONE);
        JsonUtil.safePutLong(r104, "cache_time", r110.getMaxCacheTime());
        JsonUtil.safePutLong(r104, "timeout", r110.getLocationTimeOutMs());
        JsonUtil.safePutString(r104, "upload_source", r110.getUploadSource());
        JsonUtil.safePutLong(r104, LocationMonitorConst.INTEL_UPLOAD_INTERVAL, r110.getUploadInterval());
        JsonUtil.safePutLong(r104, LocationMonitorConst.CACHE_TIMESTAMP, 0);
        JsonUtil.safePutLong(r104, "cache_duration", 0);
        JsonUtil.safePutLong(r104, "timestamp", System.currentTimeMillis());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_DESIRED_LOCATION, r102, r103, r104);
        return;
    L9:
        Logger.i("doDesiredLocationSuccess monitor put bpea_cert_token error");
        goto L10
    L5:
        JsonUtil.safePutString(r102, LocationMonitorConst.LOCATION_NAME, "");
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_TIMEOUT, false);
        JsonUtil.safePutString(r102, "err_code", "-2");
        JsonUtil.safePutString(r102, LocationMonitorConst.ERR_MSG, "exception is null");
        goto L6
    }

    public static void doDesiredLocationSuccess(long r100, BDLocation r101, LocationOption r102) {
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutString(r103, LocationMonitorConst.LOCATION_NAME, r101.getLocationSDKName());
        JsonUtil.safePutString(r103, "err_code", "200");
        JsonUtil.safePutString(r103, LocationMonitorConst.ERR_MSG, "success");
        JsonUtil.safePutBoolean(r103, "is_success", true);
        JsonUtil.safePutBoolean(r103, LocationMonitorConst.IS_TIMEOUT, false);
        JsonUtil.safePutBoolean(r103, LocationMonitorConst.IS_CACHE, r101.isCache());
        JsonUtil.safePutBoolean(r103, LocationMonitorConst.IS_CN, r102.isChineseRegion());
        JsonUtil.safePutBoolean(r103, LocationMonitorConst.IS_BACKGROUND, r102.isBackground());
        JsonUtil.safePutInt(r103, LocationMonitorConst.LOCATE_TYPE, r101.getLocationType());
        JsonUtil.safePutString(r103, LocationMonitorConst.SERVER_LOCATE_METHOD, r101.getServerLocateMethod());
        JsonUtil.safePutBoolean(r103, LocationMonitorConst.HAS_SERVER_LATLNG, r101.hasServerLatLng());
        JsonUtil.safePutBoolean(r103, LocationMonitorConst.IS_SERVER_LOCATE_SUCCESS, r101.isServerLocateSuccess());
        JsonUtil.safePutInt(r103, LocationMonitorConst.BACKGROUND_LOCATION_PERMISSION_STATUS, LocationUtil.getBackgroundLocationPermissionStatus());
        JsonUtil.safePutString(r103, LocationMonitorConst.BPEA_CERT_TOKEN, BDLocationExtrasService.getBPEAManager().getBpeaToken(r102.getBpeaCert()));     // Catch: Exception -> L5
    L6:
        JSONObject r104 = new JSONObject();
        JsonUtil.safePutLong(r104, "total_duration", r100);
        JsonUtil.safePutDouble(r104, LocationMonitorConst.ACCURACY, r101.getAccuracy());
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutLong(r105, "cache_time", r102.getMaxCacheTime());
        JsonUtil.safePutLong(r105, "timeout", r102.getLocationTimeOutMs());
        JsonUtil.safePutString(r105, "upload_source", r102.getUploadSource());
        JsonUtil.safePutLong(r105, LocationMonitorConst.INTEL_UPLOAD_INTERVAL, r102.getUploadInterval());
        if (r101.isCache() == false) goto L9;
        JsonUtil.safePutLong(r105, LocationMonitorConst.CACHE_TIMESTAMP, r101.getLocationMs());
        JsonUtil.safePutLong(r105, "cache_duration", System.currentTimeMillis() - r101.getLocationMs());
    L10:
        JsonUtil.safePutLong(r105, "timestamp", System.currentTimeMillis());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_DESIRED_LOCATION, r103, r104, r105);
        return;
    L9:
        JsonUtil.safePutLong(r105, LocationMonitorConst.CACHE_TIMESTAMP, 0);
        JsonUtil.safePutLong(r105, "cache_duration", 0);
    L5:
        Logger.i("doDesiredLocationSuccess monitor put bpea_cert_token error");
        goto L6
    }

    public static void doGeocode(long r100, int r101, String r102) {
        JSONObject r103 = new JSONObject();
        if (r101 != 0) goto L5;
        int r104 = 0;
    L6:
        JsonUtil.safePutInt(r103, "status", r104);
        JsonUtil.safePutInt(r103, "err_code", r101);
        JsonUtil.safePutString(r103, LocationMonitorConst.ERR_MSG, r102);
        JsonUtil.safePutString(r103, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutLong(r105, "total_duration", r100);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_GEOCODE, r103, r105);
        return;
    L5:
        r104 = 1;
        goto L6
    }

    public static void doScanRefresh(long r100, int r101, String r102) {
        JSONObject r103 = new JSONObject();
        if (r101 != 0) goto L5;
        int r104 = 0;
    L6:
        JsonUtil.safePutInt(r103, "status", r104);
        JsonUtil.safePutInt(r103, "err_code", r101);
        JsonUtil.safePutString(r103, LocationMonitorConst.ERR_MSG, r102);
        JsonUtil.safePutString(r103, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutLong(r105, "total_duration", r100);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SCAN_REFRESH, r103, r105);
        return;
    L5:
        r104 = 1;
        goto L6
    }

    public static void doScanUpload(long r100, int r101, String r102) {
        JSONObject r103 = new JSONObject();
        if (r101 != 0) goto L5;
        int r104 = 0;
    L6:
        JsonUtil.safePutInt(r103, "status", r104);
        JsonUtil.safePutInt(r103, "err_code", r101);
        JsonUtil.safePutString(r103, LocationMonitorConst.ERR_MSG, r102);
        JsonUtil.safePutString(r103, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutLong(r105, "total_duration", r100);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SCAN_UPLOAD, r103, r105);
        return;
    L5:
        r104 = 1;
        goto L6
    }

    public static void fetchTracerouteConfig(long r100, int r101, String r102) {
        JSONObject r103 = new JSONObject();
        if (r101 != 0) goto L5;
        int r104 = 0;
    L6:
        JsonUtil.safePutInt(r103, "status", r104);
        JsonUtil.safePutInt(r103, "err_code", r101);
        JsonUtil.safePutString(r103, LocationMonitorConst.ERR_MSG, r102);
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutLong(r105, "total_duration", r100);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_TRACEROUTE_FETCH_CONFIG, r103, r105);
        return;
    L5:
        r104 = 1;
        goto L6
    }

    public static void lbsLightLocationTraceMetricBegin(LBSLightLocationTraceLogger r100, String r101, boolean r102) {
        if (r102 == true) goto L7;
        if (r100 == null) goto L8;
        r100.begin(r101);
        return;
    L8:
        return;
    }

    public static void lbsLightLocationTraceMetricEnd(LBSLightLocationTraceLogger r100, String r101, boolean r102) {
        if (r102 == true) goto L7;
        if (r100 == null) goto L8;
        r100.end(r101);
        return;
    L8:
        return;
    }

    public static void lbsLightLocationTracePutCategoryData(LBSLightLocationTraceLogger r100, String r101, Object r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.putCategoryData(r101, r102);
    }

    public static void lbsLightLocationTracePutLogExtra(LBSLightLocationTraceLogger r100, String r101, Object r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.putLogExtra(r101, r102);
    }

    public static void lbsLightLocationTracePutMetricData(LBSLightLocationTraceLogger r100, String r101, long r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.putReportMetricData(r101, r102);
    }

    private static void lightLocationInfoUpdateWholeMonitor(JSONObject r100, JSONObject r110, JSONObject r111) {
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        boolean r104 = true;
        if (r100 == null) goto L5;
        boolean r105 = true;
    L6:
        JsonUtil.safePutBoolean(r101, LocationMonitorConst.HAS_REQUEST_CELL_MONITOR, r105);
        if (r110 == null) goto L9;
        boolean r106 = true;
    L10:
        JsonUtil.safePutBoolean(r101, LocationMonitorConst.HAS_REQUEST_WIFI_MONITOR, r106);
        if (r111 == null) goto L13;
        boolean r107 = true;
    L14:
        JsonUtil.safePutBoolean(r101, LocationMonitorConst.HAS_GET_LIGHT_MONITOR, r107);
        int r108 = PermissionManager.LOCATION_PERMISSION_UNKNOWN;
        if (r100 == null) goto L17;
        r108 = r100.optInt(LocationMonitorConst.HAS_LOCATION_PERMISSION);
    L17:
        if (r110 == null) goto L19;
        r108 = r110.optInt(LocationMonitorConst.HAS_LOCATION_PERMISSION);
    L19:
        JsonUtil.safePutInt(r101, LocationMonitorConst.HAS_LOCATION_PERMISSION, r108);
        if (r100 != null) goto L22;
    L24:
        boolean r109 = false;
    L25:
        if (r110 != null) goto L27;
    L29:
        boolean r112 = false;
    L30:
        if (r109 == true) goto L34;
        if (r112 == true) goto L34;
        r104 = false;
    L34:
        JsonUtil.safePutBoolean(r101, LocationMonitorConst.REQUEST_HAS_LIGHT_LOCATION_INFO, r104);
        JsonUtil.safePutLong(r101, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, BDLightLocationCache.getLightLocationCacheInterval());
        addCellMonitorData(r100, r109, r101, r102, r103);
        addWifiMonitorData(r110, r112, r101, r102, r103);
        addGetMonitorData(r111, r101, r102, r103);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.BD_LOCATION_COLD_BOOT_REQUEST_LIGHT_LOCATION_WHOLE_INFO, r101, r102, r103);
        return;
    L27:
        if (r110.optBoolean(LocationMonitorConst.HAS_LIGHT_LOCATION_INFO) == false) goto L29;
        r112 = true;
        goto L30
    L22:
        if (r100.optBoolean(LocationMonitorConst.HAS_LIGHT_LOCATION_INFO) == false) goto L24;
        r109 = true;
        goto L25
    L13:
        r107 = false;
        goto L14
    L9:
        r106 = false;
        goto L10
    L5:
        r105 = false;
        goto L6
    }

    public static void locationExtraDataTracePutCategoryData(LocationExtraDataTraceLogger r100, String r101, Object r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.putCategoryData(r101, r102);
    }

    public static void locationExtraDataTracePutExtraData(LocationExtraDataTraceLogger r100, String r101, Object r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.putLogExtra(r101, r102);
    }

    public static void locationExtraDataTracePutMetricData(LocationExtraDataTraceLogger r100, String r101, long r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.putReportMetricData(r101, r102);
    }

    public static void locationTracePutCategoryData(LocationTraceLogger r100, String r101, Object r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.putCategoryData(r101, r102);
    }

    public static void locationTracePutLogExtra(LocationTraceLogger r100, String r101, Object r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.putLogExtra(r101, r102);
    }

    public static void locationTracePutMetricData(LocationTraceLogger r100, String r101, long r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.putReportMetricData(r101, r102);
    }

    public static void monitorReflectScanResultFailed(int r100, int r101, String r102) {
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutInt(r103, "err_code", r100);
        JsonUtil.safePutInt(r103, "type", r101);
        JSONObject r104 = new JSONObject();
        JsonUtil.safePutString(r104, LocationMonitorConst.ERR_MSG, r102);
        Logger.i("monitorReflectScanResultFailed, categories: " + r103 + ", logExtras: " + r104);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_REFLECT_SCAN_RESULT_FAILED, r103, null, r104);
    }

    public static void uploadInitInfo(long r100, long r101, long r102) {
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutInt(r103, LocationMonitorConst.INVOKER_API_INIT_STATUS, BDLocationConfig.getInvokerApiInitStatus());
        JSONObject r104 = new JSONObject();
        JsonUtil.safePutLong(r104, "total_duration", r102);
        if (r100 <= 0) goto L5;
        JsonUtil.safePutLong(r104, LocationMonitorConst.APP_COLD_BOOT_TO_END_INIT_DURATION, r100);
    L5:
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutLong(r105, LocationMonitorConst.APP_BOOT_TIME, r101);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_INIT, r103, r104, r105);
    }

    public static void uploadRestrictedInfo(long r100, int r101, String r102) {
        JSONObject r103 = new JSONObject();
        if (r101 != 0) goto L5;
        int r104 = 0;
    L6:
        JsonUtil.safePutInt(r103, "status", r104);
        JsonUtil.safePutInt(r103, "err_code", r101);
        JsonUtil.safePutString(r103, LocationMonitorConst.ERR_MSG, r102);
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutLong(r105, "total_duration", r100);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_RESTRICTED_INFO, r103, r105);
        return;
    L5:
        r104 = 1;
        goto L6
    }

    private static void addGetMonitorData(JSONObject r210, JSONObject r211, JSONObject r212, JSONObject r213) {
        if (r210 == null) goto L11;
        boolean r100 = r210.optBoolean(LocationMonitorConst.HAS_CELL_LOCATION_INFO);
        boolean r101 = r210.optBoolean(LocationMonitorConst.HAS_WIFI_LOCATION_INFO);
        long r102 = r210.optLong(LocationMonitorConst.COLD_BOOT_TO_GET_LIGHT_LOCATION_INFO_DURATION);
        boolean r103 = r210.optBoolean(LocationMonitorConst.HAS_LIGHT_LOCATION_INFO);
        boolean r104 = r210.optBoolean(LocationMonitorConst.IS_START_CELL_LIGHT_REQUEST);
        boolean r110 = r210.optBoolean(LocationMonitorConst.IS_END_CELL_LIGHT_REQUEST);
        boolean r111 = r210.optBoolean(LocationMonitorConst.IS_START_WIFI_LIGHT_REQUEST);
        boolean r112 = r210.optBoolean(LocationMonitorConst.IS_END_WIFI_LIGHT_REQUEST);
        boolean r105 = r210.optBoolean(LocationMonitorConst.IS_ACTIVITY_COMPONENT_TYPE);
        int r106 = r210.optInt(LocationMonitorConst.FEED_HAS_AVAILABLE_DATA);
        int r107 = r210.optInt(LocationMonitorConst.FEED_CALL_TYPE);
        JsonUtil.safePutBoolean(r211, LocationMonitorConst.GET_HAS_CELL_LOCATION_INFO, r100);
        JsonUtil.safePutBoolean(r211, LocationMonitorConst.GET_HAS_WIFI_LOCATION_INFO, r101);
        JsonUtil.safePutBoolean(r211, LocationMonitorConst.GET_HAS_LIGHT_LOCATION_INFO, r103);
        JsonUtil.safePutBoolean(r211, LocationMonitorConst.IS_START_CELL_LIGHT_REQUEST, r104);
        JsonUtil.safePutBoolean(r211, LocationMonitorConst.IS_END_CELL_LIGHT_REQUEST, r110);
        JsonUtil.safePutBoolean(r211, LocationMonitorConst.IS_START_WIFI_LIGHT_REQUEST, r111);
        JsonUtil.safePutBoolean(r211, LocationMonitorConst.IS_END_WIFI_LIGHT_REQUEST, r112);
        JsonUtil.safePutBoolean(r211, LocationMonitorConst.GET_IS_ACTIVITY_COMPONENT_TYPE, r105);
        JsonUtil.safePutInt(r211, LocationMonitorConst.FEED_HAS_AVAILABLE_DATA, r106);
        JsonUtil.safePutInt(r211, LocationMonitorConst.FEED_CALL_TYPE, r107);
        if (r102 == 0) goto L7;
        JsonUtil.safePutLong(r212, LocationMonitorConst.COLD_BOOT_TO_GET_LIGHT_LOCATION_INFO_DURATION, r102);
    L7:
        long r108 = r210.optLong(LocationMonitorConst.APP_BOOT_TIME);
        if (r108 <= 0) goto L12;
        JsonUtil.safePutLong(r213, LocationMonitorConst.APP_BOOT_TIME, r108);
        return;
    L12:
        return;
    }

    public static void dimLocationCheckMonitor(String r100, int r101, long r102, Throwable r103) {
        JSONObject r104 = new JSONObject();
        JsonUtil.safePutString(r104, "device_brand", r100);
        JsonUtil.safePutInt(r104, LocationMonitorConst.CHECK_RESULT, r101);
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutLong(r105, LocationMonitorConst.DIM_LOCATION_CHECK_DURATION, r102);
        JSONObject r106 = new JSONObject();
        if (r103 == null) goto L5;
        JsonUtil.safePutString(r106, LocationMonitorConst.DETAIL_ERR_MSG, r103.getMessage());
    L5:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_DIM_LOCATION_CHECK, r104, r105, r106);
    }

    public static void doBpeaCertCheck(String r100, boolean r101, String r102, long r103) {
        Logger.i("bpea check " + r101 + ",token is:" + r102);
        JSONObject r104 = new JSONObject();
        JsonUtil.safePutString(r104, "method_name", r100);
        JsonUtil.safePutBoolean(r104, LocationMonitorConst.IS_VALID, r101);
        JsonUtil.safePutString(r104, LocationMonitorConst.CERT_TOKEN, r102);
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutLong(r105, LocationMonitorConst.BPEA_CHECK_DURATION, r103);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BPEA_CERT_CHECK, r104, r105, null);
    }

    public static void doGis(long r100, int r101, String r102, int r103) {
        JSONObject r104 = new JSONObject();
        if (r101 != 0) goto L5;
        int r105 = 0;
    L6:
        JsonUtil.safePutInt(r104, "status", r105);
        JsonUtil.safePutInt(r104, "err_code", r101);
        JsonUtil.safePutInt(r104, "api_version", r103);
        JsonUtil.safePutString(r104, LocationMonitorConst.ERR_MSG, r102);
        JsonUtil.safePutString(r104, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r106 = new JSONObject();
        JsonUtil.safePutLong(r106, "total_duration", r100);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_GIS, r104, r106);
        return;
    L5:
        r105 = 1;
        goto L6
    }

    public static void doLightLocationError(String r110, String r111, boolean r112, boolean r113) {
        doLightLocation(0, 0, 0, 0, false, r110, r111, r112, r113);
    }

    public static void doSubmit(long r100, int r101, String r102, boolean r103) {
        JSONObject r104 = new JSONObject();
        if (r101 != 0) goto L5;
        int r105 = 0;
    L6:
        JsonUtil.safePutInt(r104, "status", r105);
        JsonUtil.safePutInt(r104, "err_code", r101);
        JsonUtil.safePutString(r104, LocationMonitorConst.ERR_MSG, r102);
        JsonUtil.safePutBoolean(r104, LocationMonitorConst.IS_BACKGROUND, r103);
        JsonUtil.safePutString(r104, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r106 = new JSONObject();
        JsonUtil.safePutLong(r106, "total_duration", r100);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SUBMIT_V2, r104, r106);
        return;
    L5:
        r105 = 1;
        goto L6
    }

    public static void requestCellInfoUpdateMonitor(long r100, boolean r101, int r102, Throwable r103) {
        JSONObject r104 = new JSONObject();
        JsonUtil.safePutBoolean(r104, LocationMonitorConst.REQUEST_CELL_INFO_UPDATE_SUCCESS, r101);
        JsonUtil.safePutInt(r104, "err_code", r102);
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutLong(r105, LocationMonitorConst.REQUEST_CELL_INFO_UPDATE_DURATION, r100);
        JSONObject r106 = new JSONObject();
        if (r103 == null) goto L5;
        JsonUtil.safePutString(r106, LocationMonitorConst.DETAIL_ERR_MSG, r103.getMessage());
    L5:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_REQUEST_CELL_INFO_UPDATE, r104, r105, r106);
    }

    private static void requestLightLocationUpdateError(String r100, boolean r101, boolean r102, String r103) {
        JSONObject r104 = new JSONObject();
        JsonUtil.safePutBoolean(r104, LocationMonitorConst.IS_COLD_BOOT, r101);
        JsonUtil.safePutBoolean(r104, "is_downgrade", r102);
        JsonUtil.safePutBoolean(r104, "is_success", false);
        JsonUtil.safePutString(r104, LocationMonitorConst.LIGHT_LOCATION_TYPE, r103);
        JsonUtil.safePutLong(r104, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, BDLightLocationCache.getLightLocationCacheInterval());
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutString(r105, LocationMonitorConst.ERR_MSG, r100);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.BD_LOCATION_COLD_BOOT_REQUEST_LIGHT_LOCATION_INFO, r104, null, r105);
    }

    public static void uploadTraceroute(long r100, int r101, int r102, String r103) {
        JSONObject r104 = new JSONObject();
        JsonUtil.safePutInt(r104, "status", r101);
        JsonUtil.safePutInt(r104, "err_code", r102);
        JsonUtil.safePutString(r104, LocationMonitorConst.ERR_MSG, r103);
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutLong(r105, "total_duration", r100);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_TRACEROUTE_UPLOAD, r104, r105);
    }

    private static void addCellMonitorData(JSONObject r100, boolean r101, JSONObject r110, JSONObject r111, JSONObject r112) {
        if (r100 == null) goto L9;
        boolean r102 = r100.optBoolean("is_success");
        boolean r103 = r100.optBoolean(LocationMonitorConst.IS_COLD_BOOT);
        boolean r104 = r100.optBoolean("is_downgrade");
        JsonUtil.safePutLong(r111, LocationMonitorConst.CELL_EXECUTE_CALLBACK_DURATION, r100.optLong(LocationMonitorConst.EXECUTE_CALLBACK_DURATION));
        JsonUtil.safePutBoolean(r110, LocationMonitorConst.IS_CELL_COLD_BOOT, r103);
        JsonUtil.safePutBoolean(r110, LocationMonitorConst.IS_CELL_DOWNGRADE, r104);
        JsonUtil.safePutBoolean(r110, LocationMonitorConst.IS_CELL_SUCCESS, r102);
        if (r102 == false) goto L6;
        long r105 = r100.optLong(LocationMonitorConst.CACHE_DATA_INTERVAL);
        long r106 = r100.optLong(LocationMonitorConst.COLD_BOOT_TO_START_REQUEST);
        long r107 = r100.optLong(LocationMonitorConst.COLD_BOOT_TO_END_REQUEST);
        long r108 = r100.optLong("total_duration");
        JsonUtil.safePutBoolean(r110, LocationMonitorConst.REQUEST_HAS_CELL_LIGHT_LOCATION_INFO, r101);
        JsonUtil.safePutLong(r111, LocationMonitorConst.CACHE_CELL_DATA_INTERVAL, r105);
        JsonUtil.safePutLong(r111, LocationMonitorConst.CELL_TOTAL_DURATION, r108);
        JsonUtil.safePutLong(r111, LocationMonitorConst.CELL_COLD_BOOT_TO_START_REQUEST, r106);
        JsonUtil.safePutLong(r111, LocationMonitorConst.CELL_COLD_BOOT_TO_END_REQUEST, r107);
    L7:
        JsonUtil.safePutString(r110, LocationMonitorConst.REQUEST_CELL_ERR_CODE, r100.optString("err_code", "-1"));
        return;
    L6:
        JsonUtil.safePutString(r112, LocationMonitorConst.REQUEST_CELL_ERR_MSG, r100.optString(LocationMonitorConst.ERR_MSG));
        goto L7
    }

    private static void addWifiMonitorData(JSONObject r100, boolean r101, JSONObject r110, JSONObject r111, JSONObject r112) {
        if (r100 == null) goto L9;
        boolean r102 = r100.optBoolean("is_success");
        boolean r103 = r100.optBoolean(LocationMonitorConst.IS_COLD_BOOT);
        boolean r104 = r100.optBoolean("is_downgrade");
        JsonUtil.safePutLong(r111, LocationMonitorConst.WIFI_EXECUTE_CALLBACK_DURATION, r100.optLong(LocationMonitorConst.EXECUTE_CALLBACK_DURATION));
        JsonUtil.safePutBoolean(r110, LocationMonitorConst.IS_WIFI_COLD_BOOT, r103);
        JsonUtil.safePutBoolean(r110, LocationMonitorConst.IS_WIFI_DOWNGRADE, r104);
        JsonUtil.safePutBoolean(r110, LocationMonitorConst.IS_WIFI_SUCCESS, r102);
        if (r102 == false) goto L6;
        long r105 = r100.optLong(LocationMonitorConst.CACHE_DATA_INTERVAL);
        long r106 = r100.optLong(LocationMonitorConst.COLD_BOOT_TO_START_REQUEST);
        long r107 = r100.optLong(LocationMonitorConst.COLD_BOOT_TO_END_REQUEST);
        long r108 = r100.optLong("total_duration");
        JsonUtil.safePutBoolean(r110, LocationMonitorConst.REQUEST_HAS_WIFI_LIGHT_LOCATION_INFO, r101);
        JsonUtil.safePutLong(r111, LocationMonitorConst.CACHE_WIFI_DATA_INTERVAL, r105);
        JsonUtil.safePutLong(r111, LocationMonitorConst.WIFI_TOTAL_DURATION, r108);
        JsonUtil.safePutLong(r111, LocationMonitorConst.WIFI_COLD_BOOT_TO_START_REQUEST, r106);
        JsonUtil.safePutLong(r111, LocationMonitorConst.WIFI_COLD_BOOT_TO_END_REQUEST, r107);
    L7:
        JsonUtil.safePutString(r110, LocationMonitorConst.REQUEST_WIFI_ERR_CODE, r100.optString("err_code", "-1"));
        return;
    L6:
        JsonUtil.safePutString(r112, LocationMonitorConst.REQUEST_WIFI_ERR_MSG, r100.optString(LocationMonitorConst.ERR_MSG));
        goto L7
    }

    public static void doColdBootLocateDuration(boolean r100, boolean r101, String r102, long r103, long r104) {
        Logger.i("LocationMonitor doColdBootLocateDuration isSuccess: " + r100 + ", isMainProcess: " + r101 + ", coldBootLocateTag: " + r102 + ", startColdBootLocateDuration: " + r103 + ", totalDuration: " + r104);
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutBoolean(r105, "is_success", r100);
        JsonUtil.safePutBoolean(r105, LocationMonitorConst.IS_MAIN_PROCESS, r101);
        JsonUtil.safePutString(r105, LocationMonitorConst.COLD_BOOT_LOCATE_TAG, r102);
        JSONObject r106 = new JSONObject();
        JsonUtil.safePutLong(r106, LocationMonitorConst.START_COLD_BOOT_LOCATE_DURATION, r103);
        JsonUtil.safePutLong(r106, "total_duration", r104);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_COLD_BOOT_LOCATE_DURATION, r105, r106);
    }

    public static void doSubmitSource(long r100, int r101, String r102, boolean r103, String r104) {
        JSONObject r105 = new JSONObject();
        if (r101 != 0) goto L5;
        int r106 = 0;
    L6:
        JsonUtil.safePutInt(r105, "status", r106);
        JsonUtil.safePutString(r105, LocationMonitorConst.ERR_MSG, r102);
        JsonUtil.safePutBoolean(r105, LocationMonitorConst.IS_BACKGROUND, r103);
        JsonUtil.safePutString(r105, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JsonUtil.safePutString(r105, LocationMonitorConst.SUBMIT_SOURCE, r104);
        JSONObject r107 = new JSONObject();
        JsonUtil.safePutLong(r107, "total_duration", r100);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SUBMIT_SOURCE, r105, r107);
        return;
    L5:
        r106 = 1;
        goto L6
    }

    public static void monitorLocationApiStatistics(int r100, String r101, String r102, boolean r103, boolean r104) {
        JSONObject r105 = new JSONObject();
        JSONObject r106 = new JSONObject();
        r105.put("method_id", r100);     // Catch: JSONException -> L6
        r105.put("class_name", r101);     // Catch: JSONException -> L6
        r105.put("member_name", r102);     // Catch: JSONException -> L6
        r105.put("scene", r103);     // Catch: JSONException -> L6
        r105.put("intercept", r104);     // Catch: JSONException -> L6
        r106.put("count", 1);     // Catch: JSONException -> L6
    L4:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_LOCATION_API_ACTION, r105, r106);
    }

    public static void nonLocationSceneException(int r100, String r101, String r102, long r103, boolean r110) {
        Throwable r104 = new Throwable("" + r101 + "_" + r102 + " LocationException");
        JSONObject r105 = new JSONObject();
        JSONObject r106 = new JSONObject();
        r105.put("method_id", "" + r100);     // Catch: JSONException -> L5
        r105.put("class_name", r101);     // Catch: JSONException -> L5
        r105.put("member_name", r102);     // Catch: JSONException -> L5
        r105.put("biz_class_member", r110);     // Catch: JSONException -> L5
        r105.put(LocationMonitorConst.IS_BACKGROUND, LocationUtil.isBackground());     // Catch: JSONException -> L5
        r106.put("stop_locate_interval", "" + (System.currentTimeMillis() - r103));     // Catch: JSONException -> L5
        r106.put("count", 1);     // Catch: JSONException -> L5
        LocationMonitorUtil.monitorEventWithException(LocationMonitorConst.EVENT_LOCATION_API_ACTION_WITH_EXCEPTION, r105, r106, null, r104);     // Catch: JSONException -> L5
        return;
    }

    public static void uploadBaseInfo(String r100, long r101, int r102, String r103, boolean r104) {
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutString(r105, "upload_source", r100);
        if (r102 != 0) goto L5;
        int r106 = 0;
    L6:
        JsonUtil.safePutInt(r105, "status", r106);
        JsonUtil.safePutInt(r105, "err_code", r102);
        JsonUtil.safePutString(r105, LocationMonitorConst.ERR_MSG, r103);
        JsonUtil.safePutBoolean(r105, LocationMonitorConst.IS_BACKGROUND, r104);
        JsonUtil.safePutString(r105, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r107 = new JSONObject();
        JsonUtil.safePutLong(r107, "total_duration", r101);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BASE_INFO, r105, r107);
        return;
    L5:
        r106 = 1;
        goto L6
    }

    public static void locationFrequencyMonitor(LocationOption r100, int r101, long r102, long r103, int r110, long r111) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutString(r104, LocationMonitorConst.BPEA_CERT_TOKEN, r100.getUploadSource());
        JsonUtil.safePutInt(r104, LocationMonitorConst.LOCATION_REASON_CODE, r101);
        JsonUtil.safePutLong(r105, LocationMonitorConst.CACHE_AVAILABLE_TIME, r100.getMaxCacheTime());
        if (r103 == (-1)) goto L8;
        JsonUtil.safePutLong(r105, LocationMonitorConst.LOCATION_INTERVAL, r103);
    L8:
        if (r111 == (-1)) goto L10;
        JsonUtil.safePutLong(r105, LocationMonitorConst.LAST_LOCATION_CACHE_TIME, r111);
        JsonUtil.safePutInt(r104, LocationMonitorConst.LAST_LOCATION_CACHE_CONDITION, r110);
        JsonUtil.safePutLong(r105, LocationMonitorConst.REAL_CACHE_INTERVAL, r102 - r111);
    L10:
        JsonUtil.safePutBoolean(r104, LocationMonitorConst.IS_DOWN_GRADE_LOCATION, r100.isDownGradeLocation());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_LOCATION_FREQUENCY, r104, r105, null);
    }

    public static void uploadAuthStatus(String r100, int r101, int r102, int r103, int r104, boolean r105) {
        JSONObject r106 = new JSONObject();
        JsonUtil.safePutString(r106, "tag", r100);
        JsonUtil.safePutInt(r106, LocationMonitorConst.AUTH_STATUS, r101);
        JsonUtil.safePutInt(r106, LocationMonitorConst.LOCATION_MODE, r102);
        JsonUtil.safePutInt(r106, LocationMonitorConst.BLUETOOTH_AUTH_STATUS, r103);
        JsonUtil.safePutInt(r106, LocationMonitorConst.BLUETOOTH_SWITCH_STATUS, r104);
        JsonUtil.safePutInt(r106, "target_sdk_version", LocationUtil.getTargetSdkVersion());
        JsonUtil.safePutBoolean(r106, "is_skip", r105);
        Logger.i("LocationMonitor.uploadAuthStatus, categories: " + r106);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_AUTH_STATUS, r106, null);
    }

    public static void monitorPassiveInit(final boolean r110, final long r111, final boolean r112, final boolean r113, final boolean r114, final String r115, final Throwable r116) {
        final RuntimeException r100 = new RuntimeException();
        AppExecutors.getInstance().diskIO().execute(new AnonymousClass1(r110, r112, r113, r114, r115, r111, r100, r116));
    }

    public static void doDesiredLocationDuration(String r110, long r111, String r112, String r113, String r114, boolean r115, int r116, boolean r117) {
        doDesiredLocationDuration(r110, r111, r112, r113, r114, r115, r116, "", r117);
    }

    public static void gpsCollectMonitor(long r100, String r101, boolean r102, String r103, long r104, long r110, List<Double> r111, List<Long> r112) {
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutString(r105, LocationMonitorConst.GPS_PROVIDER, r101);
        JsonUtil.safePutBoolean(r105, LocationMonitorConst.IS_CONTINUOUS_LOCATE, r102);
        if (r102 == false) goto L5;
        JsonUtil.safePutString(r105, "gps_continuous_conf", r103);
    L5:
        JSONObject r106 = new JSONObject();
        JsonUtil.safePutLong(r106, LocationMonitorConst.GPS_COLLECT_DURATION, r100);
        JsonUtil.safePutLong(r106, LocationMonitorConst.GPS_COLLECT_DURATION_FULL, r104);
        JsonUtil.safePutLong(r106, LocationMonitorConst.GPS_COLLECT_CNT, r110);
        if (r111 == null) goto L11;
        Iterator<Double> r107 = r111.iterator();
        long r113 = 0;
    L9:
        if (r107.hasNext() == false) goto L11;
        JsonUtil.safePutDouble(r106, LocationMonitorConst.GPS_ACCURACY_STEP_ + r113, r107.next().doubleValue());
        r113 = r113 + 1;
    L11:
        if (r112 == null) goto L20;
        Iterator<Long> r108 = r112.iterator();
        long r114 = 0;
        long r115 = 0;
    L14:
        if (r108.hasNext() == false) goto L20;
        Long r116 = r108.next();
        JsonUtil.safePutLong(r106, LocationMonitorConst.GPS_COLLECT_DURATION_STEP_ + r114, r116.longValue());
        if (r114 != 0) goto L18;
        r115 = r116.longValue();
    L19:
        r114 = r114 + 1;
        goto L14
    L18:
        JsonUtil.safePutLong(r106, LocationMonitorConst.GPS_COLLECT_DURATION_APPEND_ + r114, r116.longValue() - r115);
    L20:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_GPS_INFO_COLLECT, r105, r106, null);
    }

    private static void requestLightLocationUpdateSuccess(long r100, boolean r101, boolean r102, long r103, long r104, boolean r110, long r111, String r112) {
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutBoolean(r105, LocationMonitorConst.IS_COLD_BOOT, r102);
        JsonUtil.safePutBoolean(r105, "is_downgrade", r110);
        JsonUtil.safePutBoolean(r105, "is_success", true);
        JsonUtil.safePutBoolean(r105, LocationMonitorConst.HAS_LIGHT_LOCATION_INFO, r101);
        JsonUtil.safePutString(r105, LocationMonitorConst.LIGHT_LOCATION_TYPE, r112);
        JsonUtil.safePutLong(r105, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, BDLightLocationCache.getLightLocationCacheInterval());
        JSONObject r106 = new JSONObject();
        JsonUtil.safePutLong(r106, LocationMonitorConst.CACHE_DATA_INTERVAL, r111);
        JsonUtil.safePutLong(r106, "total_duration", r100);
        JsonUtil.safePutLong(r106, LocationMonitorConst.COLD_BOOT_TO_START_REQUEST, r103);
        JsonUtil.safePutLong(r106, LocationMonitorConst.COLD_BOOT_TO_END_REQUEST, r104);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.BD_LOCATION_COLD_BOOT_REQUEST_LIGHT_LOCATION_INFO, r105, r106, null);
    }

    public static void doDesiredLocationDuration(String r100, long r101, String r102, String r103, String r104, boolean r105, int r106, String r110, boolean r111) {
        Logger.i("locationmonitor location only duration is: " + r101 + "ms");
        JSONObject r107 = new JSONObject();
        JsonUtil.safePutString(r107, LocationMonitorConst.LOCATION_NAME, r100);
        JsonUtil.safePutString(r107, "err_code", r102);
        JsonUtil.safePutString(r107, LocationMonitorConst.ERR_MSG, r103);
        JsonUtil.safePutBoolean(r107, LocationMonitorConst.IS_CN, r105);
        JsonUtil.safePutInt(r107, LocationMonitorConst.LOCATE_TYPE, r106);
        JsonUtil.safePutInt(r107, LocationMonitorConst.BACKGROUND_LOCATION_PERMISSION_STATUS, LocationUtil.getBackgroundLocationPermissionStatus());
        JsonUtil.safePutBoolean(r107, LocationMonitorConst.IS_BACKGROUND, r111);
        JSONObject r108 = new JSONObject();
        JsonUtil.safePutLong(r108, "total_duration", r101);
        JSONObject r109 = new JSONObject();
        JsonUtil.safePutString(r109, LocationMonitorConst.DETAIL_ERR_MSG, r104);
        JsonUtil.safePutString(r109, "sdk_version", r110);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_DESIRED_LOCATION_DURATION, r107, r108, r109);
    }

    public static void doLightLocation(long r100, long r101, long r102, long r103, boolean r110, String r111, String r112, boolean r113, boolean r114) {
        JSONObject r104 = new JSONObject();
        JsonUtil.safePutBoolean(r104, "is_success", r110);
        JsonUtil.safePutBoolean(r104, LocationMonitorConst.IS_COLD_BOOT, r113);
        JsonUtil.safePutString(r104, "err_code", r111);
        JsonUtil.safePutString(r104, LocationMonitorConst.ERR_MSG, r112);
        JsonUtil.safePutBoolean(r104, LocationMonitorConst.EXECUTE_SUBMIT_NOTIFICATION, r114);
        JSONObject r115 = new JSONObject();
        if (r110 == true) goto L5;
    L8:
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutLong(r105, LocationMonitorConst.APP_BOOT_TIME, BDLocationConfig.getAppBootTime());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_LOCATION_LIGHT_LOCATION, r104, r115, r105);
        return;
    L5:
        if (BDLocationConfig.getAppBootTime() == 0) goto L7;
        JsonUtil.safePutLong(r115, LocationMonitorConst.APP_COLD_BOOT_TO_START_LOCATION_DURATION, r100);
    L7:
        JsonUtil.safePutLong(r115, "total_duration", r101);
        JsonUtil.safePutLong(r115, LocationMonitorConst.GET_CELL_DURATION, r102);
        JsonUtil.safePutLong(r115, LocationMonitorConst.SUBMIT_DURATION, r103);
        goto L8
    }

    public static void doContinueLocation(String r100, String r101, String r102, boolean r103, int r104, String r105, long r106, boolean r110, String r111, String r112) {
        JSONObject r107 = new JSONObject();
        JsonUtil.safePutBoolean(r107, LocationMonitorConst.IS_CN, r103);
        JsonUtil.safePutInt(r107, LocationMonitorConst.LOCATE_TYPE, r104);
        JsonUtil.safePutString(r107, "sdk_version", r105);
        JsonUtil.safePutString(r107, LocationMonitorConst.LOCATION_NAME, r100);
        JsonUtil.safePutString(r107, "err_code", r101);
        JsonUtil.safePutString(r107, LocationMonitorConst.ERR_MSG, r102);
        JsonUtil.safePutBoolean(r107, LocationMonitorConst.IS_FIRST_LOCATION, r110);
        JsonUtil.safePutString(r107, "upload_source", r111);
        JsonUtil.safePutInt(r107, LocationMonitorConst.BACKGROUND_LOCATION_PERMISSION_STATUS, LocationUtil.getBackgroundLocationPermissionStatus());
        JsonUtil.safePutBoolean(r107, LocationMonitorConst.IS_BACKGROUND, LocationUtil.isBackground());
        JSONObject r108 = new JSONObject();
        JsonUtil.safePutLong(r108, "total_duration", r106);
        JSONObject r109 = new JSONObject();
        JsonUtil.safePutString(r109, LocationMonitorConst.DETAIL_ERR_MSG, r112);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_CONTINUE, r107, r108, r109);
    }

    public static void monitorByteLocationStealGpsInfoAndSysLocation(int r100, int r101, int r102, long r103, long r110, long r111, long r112, boolean r113, boolean r114, boolean r115, boolean r116, String r210, long r211) {
        JSONObject r104 = new JSONObject();
        JsonUtil.safePutInt(r104, "before_wait_count", r100);
        JsonUtil.safePutInt(r104, "after_wait_count", r101);
        JsonUtil.safePutInt(r104, "downgrade_location", r102);
        JsonUtil.safePutLong(r104, "max_wait_time", r110);
        JsonUtil.safePutBoolean(r104, "steal_gps_success", r113);
        JsonUtil.safePutBoolean(r104, "steal_sys_loc_success", r114);
        JsonUtil.safePutBoolean(r104, "has_option", r115);
        JsonUtil.safePutBoolean(r104, LocationExtraDataTraceLogger.USE_CONTINUOUS_GPS, r116);
        if (r116 == false) goto L5;
        JsonUtil.safePutString(r104, "gps_continuous_conf", r210);
    L5:
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutLong(r105, "real_wait_time", r112);
        JsonUtil.safePutLong(r105, "time_to_locate_start", r103);
        JsonUtil.safePutLong(r105, "real_max_wait_time", r111);
        JsonUtil.safePutLong(r105, LocationMonitorConst.GPS_COLLECT_CNT, r211);
        Logger.i("location-trace-core monitorByteLocationStealGpsInfoAndSysLocation, category: " + r104 + ", metric: " + r105);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_STEAL_GPS_INFO_AND_SYS_LOCATION, r104, r105);
    }
}

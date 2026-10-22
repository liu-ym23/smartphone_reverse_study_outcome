package com.bytedance.bdlocation.monitor;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.GPSResult;
import com.bytedance.bdlocation.network.model.LocationResult;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class LBSLightLocationTraceLogger extends AbstractTraceLogger {
    public static final String BPEA = "bpea";
    public static final String CHECK_ABLE_LOCATION = "check_able_location";
    public static final String CHECK_CACHE_VALIDITY = "check_cache_validity";
    public static final String CHECK_CERT = "check_cert";
    public static final String ENABLE_LOCATION_OPT_BPEA_LIST = "enable_location_opt_bpea_list";
    public static final String ENCRYPT = "encrypt";
    public static final String ENCRYPT_SUBMIT_V2_BODY = "encrypt_submit_v2_body";
    public static final String GET_BPEA_MANAGER = "get_bpea_manager";
    public static final String GET_SCAN_RESULTS = "get_scan_results";
    public static final String GET_SCAN_RESULTS_INNER = "get_scan_results_inner";
    public static final String GET_SUITABLE_CACHE = "get_suitable_cache";
    public static final String GET_WIFI_MODULE = "get_wifi_module";
    public static final String HAS_VALID_LOCATION = "has_valid_location";
    public static final String INDEPENDENT_THREAD_GET_SCAN_RESULTS = "independent_thread_get_scan_results";
    public static final String IS_64_BIT = "is_64_bit";
    public static final String IS_FULL_LOCATE_MERGE = "is_full_locate_merge";
    public static final String IS_GET_WIFI_SUCCESS = "is_get_wifi_success";
    public static final String LOCATION_CACHE = "location_cache";
    public static final String LOCATION_MERGE = "location_merge";
    public static final String LOCATION_MERGE_SYNC = "location_merge_sync";
    public static final String NETWORK_REQUEST_LOC_INFO = "network_request_loc_info";
    public static final String NETWORK_REQUEST_PARAMS_PARSE = "network_request_params_parse";
    public static final String NETWORK_REQUEST_PARAMS_PREPARE = "network_request_params_prepare";
    public static final String NETWORK_TOTAL = "network_total";
    public static final String PREPARE = "prepare";
    public static final String PRE_SCAN_RESULTS = "pre_scan_results";
    public static final String SORT = "sort";
    public static final String SUBMIT_V2_LOG_ID = "submit_v2_log_id";
    public static final String SUBMIT_V2_REQUEST = "submit_v2_request";
    public static final String SUB_PREPARE = "sub_prepare";
    public static final String SUB_SCAN_LIST = "sub_scan_list";
    public static final String SWITCH_THREAD = "switch_thread";
    public static final String SWITCH_THREAD_SECOND_TIME = "switch_thread_second_time";
    public static final String THREAD_NAME = "thread_name";
    public static final String TOTAL = "total";
    public static final String TRIM_SCAN_RESULTS = "trim_scan_results";
    public static final String WIFI_TIMELINESS = "wifi_timeliness";
    public static final String WRAP_LOCATION_OPTION = "wrap_location_option";

    private int isCurrentProcess64Bit() {
        return Process.is64Bit() ? 1 : 0;
    L4:
        return -1;
    }

    public LBSLightLocationTraceLogger() {
    }

    public void reportLBSLightLocationSuccess(LocInfoRspData r100) {
        if (r100 == null) goto L13;
        LocationResult r101 = r100.location;
        if (r101 == null) goto L13;
        GPSResult r102 = r101.gps;
        if (r102 == null) goto L13;
        if (r102.latitude == AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
    L12:
        boolean r103 = true;
    L14:
        JSONObject r104 = new JSONObject();
        dumpMetricsTo(r104);
        JSONObject r105 = new JSONObject();
        dumpCategoriesTo(r105);
        JsonUtil.safePutBoolean(r105, "is_success", true);
        JsonUtil.safePutString(r105, "sdk_version", BuildConfig.BDLOCATION_VERSION);
        JsonUtil.safePutString(r105, "err_code", "200");
        JsonUtil.safePutBoolean(r105, HAS_VALID_LOCATION, r103);
        if (Build.VERSION.SDK_INT < 23) goto L17;
        JsonUtil.safePutInt(r105, IS_64_BIT, isCurrentProcess64Bit());
    L17:
        JSONObject r106 = new JSONObject();
        dumpLogExtrasTo(r106);
        JsonUtil.safePutString(r106, ENABLE_LOCATION_OPT_BPEA_LIST, BDLocationConfig.getEnableLocationOptBpeaList());
        Logger.i("reportLBSLightLocationSuccess categories: " + r105);
        Logger.i("reportLBSLightLocationSuccess metrics: " + r104);
        Logger.i("reportLBSLightLocationSuccess logExtras: " + r106);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_LBS_LIGHT_LOCATION_TRACE_LOG, r105, r104, r106);
        return;
    L11:
        if (r102.longitude != AudioStats.AUDIO_AMPLITUDE_NONE) goto L12;
    L13:
        r103 = false;
        goto L14
    }

    public void reportLBSLightLocationFailed(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        dumpCategoriesTo(r102);
        JsonUtil.safePutBoolean(r102, "is_success", false);
        JsonUtil.safePutString(r102, "sdk_version", BuildConfig.BDLOCATION_VERSION);
        if (TextUtils.isEmpty(r100) == true) goto L5;
        JsonUtil.safePutString(r102, "err_code", r100);
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        JsonUtil.safePutInt(r102, IS_64_BIT, isCurrentProcess64Bit());
    L9:
        JSONObject r103 = new JSONObject();
        dumpLogExtrasTo(r103);
        JsonUtil.safePutString(r103, ENABLE_LOCATION_OPT_BPEA_LIST, BDLocationConfig.getEnableLocationOptBpeaList());
        if (TextUtils.isEmpty(r101) == true) goto L12;
        JsonUtil.safePutString(r103, LocationMonitorConst.DETAIL_ERR_MSG, r101);
    L13:
        Logger.i("reportLBSLightLocationFailed categories: " + r102);
        Logger.i("reportLBSLightLocationFailed logExtras: " + r103);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_LBS_LIGHT_LOCATION_TRACE_LOG, r102, null, r103);
        return;
    L12:
        JsonUtil.safePutString(r103, LocationMonitorConst.DETAIL_ERR_MSG, "empty");
        goto L13
    L5:
        JsonUtil.safePutString(r102, "err_code", "-1002");
        goto L7
    }
}

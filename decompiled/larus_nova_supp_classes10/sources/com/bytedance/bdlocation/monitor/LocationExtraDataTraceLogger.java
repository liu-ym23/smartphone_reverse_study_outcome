package com.bytedance.bdlocation.monitor;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LocationExtraDataTraceLogger extends AbstractTraceLogger {
    public static final String ALLOW_USE_LOCATION_CODE = "allow_use_location_code";
    public static final String AMAP_LOCATION_CHANGED = "amap_location_changed";
    public static final String AMAP_LOCATION_ERROR = "amap_location_error";
    public static final String BLE_INFO_LIST_STATUS = "ble_info_list_status";
    public static final String BLE_SCAN_DURATION = "ble_scan_duration";
    public static final String BLE_SCAN_INTERVAL = "ble_scan_interval";
    public static final String BYTE_LOCATION_LIBRA_PARAM = "byte_location_libra_param";
    public static final String COLLECT_EXTRA_DATA_DURATION = "collect_extra_data_duration";
    public static final String COLLECT_GPS_TYPE = "collect_gps_type";
    public static final String COLLECT_HAS_AMAP_INFO = "collect_has_amap_info";
    public static final String COLLECT_HAS_BLE_INFO = "collect_has_ble_info";
    public static final String COLLECT_HAS_GPS_INFO = "collect_has_gps_info";
    public static final String COLLECT_HAS_NETWORK_INFO = "collect_has_network_info";
    public static final String COLLECT_LOCATION_INFO_DURATION = "collect_location_info_duration";
    public static final String COLLECT_LOCATION_INFO_ERROR_CODE = "collect_location_info_error_code";
    public static final String COLLECT_LOCATION_INFO_SUCCESS = "collect_location_info_success";
    public static final String CONVERT_LOCATION_TO_GCJ_O2_SUCCESS = "convert_location_to_gcj02_success";
    public static final String DEFAULT_GPS_SCAN_INTERVAL = "default_gps_scan_interval";
    public static final String DISABLE_COLLECT_AMAP_LOCATION_SOURCE = "disable_collect_amap_location_source";
    public static final String ENABLE_BACKGROUND_UPLOAD_LOCATION = "enable_background_upload_location";
    public static final String ENABLE_CHECK_LAST_LOG_ID = "enable_check_last_log_id";
    public static final String ENABLE_CHECK_UPLOAD_COMPLIANCE = "enable_check_upload_compliance";
    public static final String ENABLE_COLLECT_AMAP_LOCATION_IN_BATTERY_SAVING_MODE = "enable_amap_location_in_battery_saving_mode";
    public static final String ENABLE_COLLECT_BLE_IN_BATTERY_SAVING_MODE = "enable_collect_ble_in_battery_saving_mode";
    public static final String ENABLE_COLLECT_GPS_LOCATION_IN_BATTERY_SAVING_MODE = "enable_collect_gps_location_in_battery_saving_mode";
    public static final String ENABLE_COLLECT_NETWORK_LOCATION_IN_BATTERY_SAVING_MODE = "enable_network_location_in_battery_saving_mode";
    public static final String ENABLE_SCAN_BLE = "enable_scan_ble";
    public static final String ENABLE_UPLOAD_LAST_LOCATION_INFO = "enable_upload_last_location_info";
    public static final String EXTRA_DATA_MARK = "extra_data_mark";
    public static final String FIRST_REQUEST_LOCATION = "first_request_location";
    public static final String GPS_CONTINUOUS_CONF = "gps_continuous_conf";
    public static final String GPS_INFO_STATUS = "gps_info_status";
    public static final String GPS_LOCATION_CHANGED = "gps_location_changed";
    public static final String GPS_OR_NETWORK_LOCATION_IS_NULL = "gps_or_network_location_is_null";
    public static final String GPS_SCAN_INTERVAL = "gps_scan_interval";
    public static final String HAS_BLE_SCAN_INTERVAL = "has_ble_scan_interval";
    public static final String HAS_GPS_SCAN_INTERVAL = "has_gps_scan_interval";
    public static final String HAS_LAST_GPS_LOCATION = "has_last_gps_location";
    public static final String HAS_LAST_NETWORK_LOCATION = "has_last_network_location";
    public static final String IS_DOWNGRADE_LOCATION = "is_downgrade_location";
    public static final String IS_ENABLE_GPS_SCAN = "is_enable_gps_scan";
    public static final String IS_MOCK_ENABLE = "is_mock_enable";
    public static final String LAST_GPS_AND_LIGHT_LOCATION_DISTANCE_GAP = "last_gps_and_light_location_distance_gap";
    public static final String LAST_GPS_AND_LIGHT_LOCATION_GAP = "last_gps_and_light_location_gap";
    public static final String LAST_GPS_DISTANCE = "last_gps_distance";
    public static final String LAST_GPS_LOCATION_DURATION = "last_gps_location_duration";
    public static final String LAST_GPS_LOCATION_GAP = "last_gps_location_gap";
    public static final String LAST_NETWORK_AND_LIGHT_LOCATION_DISTANCE_GAP = "last_network_and_light_location_distance_gap";
    public static final String LAST_NETWORK_AND_LIGHT_LOCATION_GAP = "last_network_and_light_location_gap";
    public static final String LAST_NETWORK_DISTANCE = "last_network_distance";
    public static final String LAST_NETWORK_LOCATION_DURATION = "last_network_location_duration";
    public static final String LAST_NETWORK_LOCATION_GAP = "last_network_location_gap";
    public static final String LAST_TOTAL_LOCATION_DURATION = "last_total_location_duration";
    public static final String LIGHT_LOCATION_DISTANCE = "light_location_distance";
    public static final String LIGHT_LOCATION_WIFI_GAP = "light_location_wifi_gap";
    public static final String LOCATE_MODE = "locate_mode";
    public static final String LOCATION_LOG_ID = "location_log_id";
    public static final String LOCATION_LOG_ID_CACHE_TIME = "log_id_cache_time";
    public static final String LOG_ID_CACHE_ENTITY_IS_NULL = "log_id_cache_entity_is_null";
    public static final String LOG_ID_CACHE_ENTITY_TIME_CHECK = "log_id_cache_entity_time_check";
    public static final String NETWORK_LOCATION_CHANGED = "network_location_changed";
    public static final String QUICK_GPS = "quick_gps";
    public static final String REGISTER_GNSS = "register_gnss";
    public static final String REQUEST_AMAP_LOCATION = "request_amap_location";
    public static final String REQUEST_GPS_LOCATION = "request_gps_location";
    public static final String REQUEST_NETWORK_LOCATION = "request_network_location";
    public static final String SCAN_BLE_SUCCESS = "scan_ble_success";
    public static final String SDK_INT = "sdk_int";
    public static final String START_LOCATION_TIME = "start_location_time";
    public static final String SUBMIT_BLE_NOW = "submit_ble_now";
    public static final String TARGET_SDK_VERSION = "target_sdk_version";
    public static final String UPLOAD_GPS_AND_BLE_NUM = "upload_gps_and_ble_num";
    public static final String UPLOAD_HAS_AMAP_LOCATION_INFO = "upload_has_amap_location_info";
    public static final String UPLOAD_HAS_BLE_INFO_LIST = "upload_has_ble_info_list";
    public static final String UPLOAD_HAS_GPS_INFO = "upload_has_gps_info";
    public static final String UPLOAD_HAS_SYS_LOCATION_INFO = "upload_has_sys_location_info";
    public static final String UPLOAD_SOURCE = "upload_source";
    public static final String USE_CONTINUOUS_GPS = "use_continuous_gps";

    private JSONObject getCategory() {
        JSONObject r0 = new JSONObject();
        dumpCategoriesTo(r0);
        return r0;
    }

    private JSONObject getExtra() {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutLong(r0, LocationMonitorConst.TIMESTAMP, System.currentTimeMillis());
        return r0;
    }

    private JSONObject getMetric() {
        JSONObject r0 = new JSONObject();
        dumpMetricsTo(r0);
        return r0;
    }

    public void locationExtraDataSuccessReport() {
        JSONObject r0 = getCategory();
        JSONObject r1 = getMetric();
        JSONObject r2 = getExtra();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_SUCCESS, true);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, BDLocationException.SUCCESS);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, "success");
        Logger.i("LocationTraceLogger category:" + r0.toString());
        Logger.i("LocationTraceLogger   metric:" + r1.toString());
        Logger.i("LocationTraceLogger    extra:" + r2.toString());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_LOCATION_EXTRA_DATE_TRACE_LOG, r0, r1, r2);
    }

    public LocationExtraDataTraceLogger() {
    }

    public void locationExtraDataErrorReport(BDLocationException r7) {
        JSONObject r0 = getCategory();
        JSONObject r1 = getMetric();
        JSONObject r2 = getExtra();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_SUCCESS, false);
        if (r7 == null) goto L5;
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, r7.getCode());
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r7.getMessage());
        JsonUtil.safePutString(r2, LocationMonitorConst.DETAIL_ERR_MSG, r7.getDetailMessage());
    L6:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_LOCATION_EXTRA_DATE_TRACE_LOG, r0, r1, r2);
        return;
    L5:
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, "-1002");
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, "exception is null");
        goto L6
    }
}

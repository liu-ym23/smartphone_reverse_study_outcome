package com.bytedance.bdlocation.settings;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class LocationSettingModel {
    public static final String LOCATION_BEACON_SETTINGS_KEY = "locationsdk_beacon_config_android";
    public static final String LOCATION_SETTINGS_KEY = "locationsdk_config_android";
    public static final String LOCATION_SHAKE_SETTINGS_KEY = "locationsdk_shake_config_android";
    public boolean amapGPSCollectAlwaysUseNewAMapClient;
    public boolean asyncScanWifi;
    public int baseStationInfoType;
    public JSONObject beaconConfig;
    public String byteLocationLibraParam;
    public String byteLocationWhiteList;
    public int checkConnectWifiRssi;
    public boolean checkLocationBpea;
    public long checkWifiCacheDuration;
    public boolean coldBootABTest;
    public boolean coldBootCollectGps;
    public int coldBootCollectGpsStrategy;
    public boolean collectConfig;
    public boolean collectContinuousGpsDisableGnssUpload;
    public long collectContinuousGpsDuration;
    public long collectContinuousGpsInterval;
    public String collectContinuousGpsLocTokenBlacklist;
    public boolean collectContinuousGpsOnlyLast;
    public int collectGpsType;
    public boolean collectLightInfo;
    public long defaultGpsScanInterval;
    public String disableCollectAMapLocationSource;
    public String disableTailLocateOptimizeSource;
    public boolean enableAcceptLightLocationParam;
    public boolean enableBackgroundLocation;
    public boolean enableBackgroundUploadLocation;
    public boolean enableBlePassiveName;
    public boolean enableBleTruncateOnTimeout;
    public boolean enableByteContinuousLocation;
    public boolean enableCheckConnectWifi;
    public boolean enableCheckLastLogId;
    public boolean enableCheckUploadCompliance;
    public boolean enableCheckWifiCache;
    public boolean enableCollectAMapLocationInBatterySavingMode;
    public boolean enableCollectBleInBatterySavingMode;
    public boolean enableCollectContinuousGps;
    public boolean enableCollectContinuousGpsForTest;
    public boolean enableCollectGPSLocationInBatterySavingMode;
    public boolean enableCollectNetworkLocationInBatterySavingMode;
    public boolean enableContinueLocateUploadCell;
    public boolean enableContinueLocateUploadWifi;
    public boolean enableDestroyAMapContinuousClient;
    public boolean enableDestroyAMapSingleClient;
    public boolean enableDimLocationCheck;
    public boolean enableFusionLocation;
    public boolean enableGpsScan;
    public boolean enableInfoRequestOpt;
    public boolean enableLightLocation;
    public boolean enableLightLocationNewPolicy;
    public boolean enableLiveStallReport;
    public boolean enableLocationCacheTokenWhiteList;
    public String enableLocationOptBpeaList;
    public boolean enableLocationOptEncrypt;
    public boolean enableMonitor;
    public boolean enableNoLocReqCgi;
    public boolean enableScanGnss;
    public boolean enableScanWifi;
    public boolean enableStationaryScenePolicy;
    public boolean enableSysNetworkLoc;
    public boolean enableTailLocateOptimize;
    public boolean enableTraceroute;
    public boolean enableTrackUpload;
    public boolean enableUploadLastLocationInfo;
    public boolean enableUploadLastLogId;
    public boolean enableUseCoarseLocation;
    public long firstLocationTimeoutMs;
    public long freshBaseStationTimeout;
    public int hotBootCacheTime;
    public String hotBootLocToken;
    public long inOutDoorStatusCacheTime;
    public boolean independentThreadGetScanResults;
    public long infoRequestKeyParamsMaxCacheTime;
    public boolean isUploadFreshBaseStation;
    public boolean isUseQuickGPS;
    public int lightInfoInterval;
    public int liveStallReportWindowMs;
    public int locateType;
    public String locationCacheTokenWhiteList;
    public long locationExpiredInterval;
    public int locationMode;
    public int maxLightCount;
    public long maxLightDuration;
    public long maxWaitGPSTimeMillis;
    public List<String> monitorBusinessStartLocationClassMember;
    public List<String> monitorBusinessStopLocationClassMember;
    public int monitorStrategy;
    public List<String> monitorStrategyClassMember;
    public long monitorStrategyInterval;
    public boolean needDowngradeLocationInOverseas;
    public boolean needUploadLastContinuousLocation;
    public String networkSignatureMode;
    public boolean openWifiListMonitor;
    public long overseasGetLocationFailedCacheValidityTime;
    public boolean pollingUpload;
    public boolean preLocationCallback;
    public String redGeoNameIds;
    public boolean reportAtStart;
    public boolean reportBss;
    public int reportBssMax;
    public boolean reportGps;
    public boolean reportHar;
    public int reportHarRange;
    public int reportIntervalSeconds;
    public boolean reportLocationAtStart;
    public boolean reportWifi;
    public int reportWifiMax;
    public boolean revertToSystemLocation;
    public boolean sEnableRescanWifi;
    public int sRescanWifiCount;
    public boolean scanBle;
    public long scanBleInterval;
    public long searchLocationCacheTime;
    public boolean sensorAccelerometerEnabled;
    public int sensorAccelerometerHz;
    public boolean sensorBarometerEnabled;
    public int sensorBarometerHz;
    public int sensorBatchAccelerometerInterval;
    public int sensorBatchBarometerInterval;
    public int sensorBatchDopInterval;
    public int sensorBatchGpsInterval;
    public int sensorBatchGyroscopeInterval;
    public int sensorBatchHeadingInterval;
    public int sensorBatchLightInterval;
    public int sensorBatchMagnetometerInterval;
    public int sensorBatchPushInterval;
    public int sensorBatchSatelliteInfoInterval;
    public int sensorBatchTempInterval;
    public boolean sensorCollectionEnabled;
    public boolean sensorDopEnabled;
    public boolean sensorGnssEnabled;
    public boolean sensorGyroscopeEnabled;
    public int sensorGyroscopeHz;
    public boolean sensorLightEnabled;
    public int sensorLightHz;
    public boolean sensorMagnetometerEnabled;
    public int sensorMagnetometerHz;
    public long sensorMaxCacheSeconds;
    public JSONObject shakeConfig;
    public int stationarySceneMaxDistance;
    public int stationarySceneMaxGpsAccuracy;
    public long stationarySceneMaxInterval;
    public String stationarySceneTokenWhiteList;
    public String stationarySceneWifiWhiteList;
    public float tailAccuracyThreshold;
    public long tailWifiTimeThreshold;
    public int trackIntervalSec;
    public int uploadBleNum;
    public long uploadNetSignalInterval;
    public boolean useCacheCondition;
    public boolean useGpsCheckRegion;
    public boolean useNewCacheStrategy;
    public boolean useNewReverseGeoLocationApi;
    public long wifiScanInterval;

    public LocationSettingModel() {
        this.collectConfig = true;
        this.enableLiveStallReport = false;
        this.liveStallReportWindowMs = 5000;
        this.reportAtStart = true;
        this.reportLocationAtStart = false;
        this.pollingUpload = false;
        this.independentThreadGetScanResults = false;
        this.amapGPSCollectAlwaysUseNewAMapClient = true;
        this.enableLocationOptBpeaList = "";
        this.enableLocationOptEncrypt = false;
        this.locateType = 3;
        this.reportIntervalSeconds = 300;
        this.reportWifiMax = 30;
        this.reportBssMax = 10;
        this.reportGps = true;
        this.reportWifi = true;
        this.reportBss = true;
        this.reportHar = false;
        this.reportHarRange = 64;
        this.enableTraceroute = false;
        this.openWifiListMonitor = false;
        this.coldBootABTest = false;
        this.uploadBleNum = 30;
        this.scanBleInterval = 1000;
        this.scanBle = false;
        this.enableBlePassiveName = true;
        this.enableBleTruncateOnTimeout = true;
        this.checkLocationBpea = false;
        this.locationMode = 2;
        this.useNewCacheStrategy = false;
        this.collectLightInfo = false;
        this.revertToSystemLocation = false;
        this.lightInfoInterval = 3;
        this.maxLightCount = 30;
        this.maxLightDuration = 5000;
        this.sensorCollectionEnabled = false;
        this.sensorLightEnabled = true;
        this.sensorLightHz = 10;
        this.sensorMaxCacheSeconds = 5;
        this.sensorAccelerometerEnabled = true;
        this.sensorAccelerometerHz = 50;
        this.sensorGyroscopeEnabled = true;
        this.sensorGyroscopeHz = 50;
        this.sensorMagnetometerEnabled = true;
        this.sensorMagnetometerHz = 50;
        this.sensorBarometerEnabled = true;
        this.sensorBarometerHz = 10;
        this.sensorDopEnabled = true;
        this.sensorGnssEnabled = true;
        this.enableGpsScan = false;
        this.checkConnectWifiRssi = -60;
        this.checkWifiCacheDuration = 10000;
        this.enableScanWifi = true;
        this.useNewReverseGeoLocationApi = false;
        this.enableNoLocReqCgi = false;
        this.enableSysNetworkLoc = true;
        this.enableMonitor = false;
        this.monitorStrategy = 0;
        this.monitorStrategyInterval = 3000;
        this.monitorStrategyClassMember = new ArrayList();
        this.monitorBusinessStartLocationClassMember = new ArrayList();
        this.monitorBusinessStopLocationClassMember = new ArrayList();
        this.infoRequestKeyParamsMaxCacheTime = 86400000;
        this.maxWaitGPSTimeMillis = 0;
        this.enableAcceptLightLocationParam = false;
        this.preLocationCallback = false;
        this.byteLocationLibraParam = "v2";
        this.byteLocationWhiteList = "";
        this.collectGpsType = 0;
        this.sEnableRescanWifi = false;
        this.sRescanWifiCount = 60;
        this.useCacheCondition = false;
        this.disableCollectAMapLocationSource = LocationInfoConst.UNKNOWN_SOURCE;
        this.enableLocationCacheTokenWhiteList = false;
        this.locationCacheTokenWhiteList = "";
        this.hotBootLocToken = "";
        this.hotBootCacheTime = -1;
        this.coldBootCollectGpsStrategy = 0;
        this.coldBootCollectGps = false;
        this.enableUploadLastLogId = true;
        this.networkSignatureMode = "";
        this.defaultGpsScanInterval = 0;
        this.enableCheckUploadCompliance = true;
        this.enableBackgroundUploadLocation = false;
        this.enableCheckLastLogId = true;
        this.enableDimLocationCheck = false;
        this.enableTailLocateOptimize = false;
        this.tailAccuracyThreshold = 100.0f;
        this.tailWifiTimeThreshold = 300000;
        this.disableTailLocateOptimizeSource = LocationInfoConst.UNKNOWN_SOURCE;
        this.isUploadFreshBaseStation = false;
        this.freshBaseStationTimeout = 0;
        this.enableUploadLastLocationInfo = false;
        this.enableCollectContinuousGps = false;
        this.collectContinuousGpsInterval = 1000;
        this.collectContinuousGpsDuration = 5000;
        this.collectContinuousGpsLocTokenBlacklist = "";
        this.collectContinuousGpsDisableGnssUpload = false;
        this.collectContinuousGpsOnlyLast = true;
        this.inOutDoorStatusCacheTime = 600000;
        this.enableScanGnss = true;
        this.stationarySceneMaxDistance = 50;
        this.stationarySceneMaxInterval = 1800000;
        this.stationarySceneMaxGpsAccuracy = 50;
        this.stationarySceneWifiWhiteList = "";
        this.stationarySceneTokenWhiteList = "";
        this.enableCollectContinuousGpsForTest = false;
        this.enableContinueLocateUploadWifi = true;
        this.enableContinueLocateUploadCell = true;
        this.enableByteContinuousLocation = true;
        this.locationExpiredInterval = 100000;
        this.uploadNetSignalInterval = 30000;
        this.firstLocationTimeoutMs = 10000;
        this.needUploadLastContinuousLocation = true;
        this.isUseQuickGPS = false;
        this.enableFusionLocation = true;
        this.sensorBatchPushInterval = 10;
        this.sensorBatchGpsInterval = 1;
        this.sensorBatchAccelerometerInterval = 50;
        this.sensorBatchGyroscopeInterval = 50;
        this.sensorBatchMagnetometerInterval = 50;
        this.sensorBatchHeadingInterval = 20;
        this.sensorBatchBarometerInterval = 10;
        this.sensorBatchLightInterval = 10;
        this.sensorBatchDopInterval = 1;
        this.sensorBatchTempInterval = 10;
        this.sensorBatchSatelliteInfoInterval = 1;
        this.enableTrackUpload = true;
        this.trackIntervalSec = 15;
    }

    public static LocationSettingModel toModel(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L6;
        return null;
    L6:
        LocationSettingModel r100 = new LocationSettingModel();
        JSONObject r101 = new JSONObject(r110);     // Catch: JSONException -> L45
        JSONObject r102 = r101.optJSONObject(LOCATION_SETTINGS_KEY);     // Catch: JSONException -> L45
        if (r102 == null) goto L43;
        r100.collectConfig = r102.optBoolean("collect_config", true);     // Catch: JSONException -> L45
        r100.enableLiveStallReport = r102.optBoolean(SettingsConstants.ENABLE_LIVE_STALL_REPORT, false);     // Catch: JSONException -> L45
        r100.liveStallReportWindowMs = r102.optInt(SettingsConstants.LIVE_STALL_REPORT_WINDOW_MS, 5000);     // Catch: JSONException -> L45
        r100.pollingUpload = r102.optBoolean("polling_upload", false);     // Catch: JSONException -> L45
        r100.independentThreadGetScanResults = r102.optBoolean(LBSLightLocationTraceLogger.INDEPENDENT_THREAD_GET_SCAN_RESULTS, false);     // Catch: JSONException -> L45
        r100.amapGPSCollectAlwaysUseNewAMapClient = r102.optBoolean("amap_gps_collect_always_use_new_amap_client", true);     // Catch: JSONException -> L45
        r100.enableLocationOptBpeaList = r102.optString(LBSLightLocationTraceLogger.ENABLE_LOCATION_OPT_BPEA_LIST, "");     // Catch: JSONException -> L45
        r100.enableLocationOptEncrypt = r102.optBoolean("enable_location_opt_encrypt", false);     // Catch: JSONException -> L45
        r100.locateType = r102.optInt(LocationMonitorConst.LOCATE_TYPE, 3);     // Catch: JSONException -> L45
        r100.reportIntervalSeconds = r102.optInt("report_interval_seconds", 300);     // Catch: JSONException -> L45
        r100.reportAtStart = r102.optBoolean("report_at_start", true);     // Catch: JSONException -> L45
        r100.reportLocationAtStart = r102.optBoolean("report_location_at_start", false);     // Catch: JSONException -> L45
        r100.reportGps = r102.optBoolean("report_gps", true);     // Catch: JSONException -> L45
        r100.reportWifi = r102.optBoolean("report_wifi", true);     // Catch: JSONException -> L45
        r100.reportBss = r102.optBoolean("report_bss", true);     // Catch: JSONException -> L45
        r100.reportHar = r102.optBoolean("report_har", false);     // Catch: JSONException -> L45
        r100.reportHarRange = r102.optInt("report_har_range", 64);     // Catch: JSONException -> L45
        r100.enableTraceroute = r102.optBoolean("enable_traceroute", false);     // Catch: JSONException -> L45
        r100.reportBssMax = r102.optInt("report_bss_max", 10);     // Catch: JSONException -> L45
        r100.reportWifiMax = r102.optInt("report_wifi_max", 30);     // Catch: JSONException -> L45
        r100.coldBootABTest = r102.optBoolean(SettingsConstants.COLD_BOOT_AB_TEST, false);     // Catch: JSONException -> L45
        r100.uploadBleNum = r102.optInt("upload_ble_num", 30);     // Catch: JSONException -> L45
        r100.scanBleInterval = r102.optLong("scan_ble_interval", 1000);     // Catch: JSONException -> L45
        r100.scanBle = r102.optBoolean("scan_ble", false);     // Catch: JSONException -> L45
        r100.enableBlePassiveName = r102.optBoolean(SettingsConstants.ENABLE_BLE_PASSIVE_NAME, true);     // Catch: JSONException -> L45
        r100.enableBleTruncateOnTimeout = r102.optBoolean(SettingsConstants.ENABLE_BLE_TRUNCATE_ON_TIMEOUT, true);     // Catch: JSONException -> L45
        r100.checkLocationBpea = r102.optBoolean("check_location_bpea", false);     // Catch: JSONException -> L45
        r100.locationMode = r102.optInt(LocationMonitorConst.LOCATION_MODE, 2);     // Catch: JSONException -> L45
        r100.openWifiListMonitor = r102.optBoolean("open_wifi_list_monitor", false);     // Catch: JSONException -> L45
        r100.useGpsCheckRegion = r102.optBoolean("use_gps_check_region", false);     // Catch: JSONException -> L45
        r100.overseasGetLocationFailedCacheValidityTime = r102.optLong("overseas_get_location_failed_cache_validity_time", LocationInfoConst.defaultsOverseasCacheValidity);     // Catch: JSONException -> L45
        r100.redGeoNameIds = r102.optString("red_geo_name_ids", LocationInfoConst.defaultRedGeoNameIds);     // Catch: JSONException -> L45
        r100.needDowngradeLocationInOverseas = r102.optBoolean("need_downgrade_location_in_overseas", false);     // Catch: JSONException -> L45
        r100.useNewCacheStrategy = r102.optBoolean("use_new_cache_strategy", false);     // Catch: JSONException -> L45
        r100.enableLightLocation = r102.optBoolean(SettingsConstants.ENABLE_LIGHT_LOCATION, false);     // Catch: JSONException -> L45
        r100.collectLightInfo = r102.optBoolean("collect_light_info", false);     // Catch: JSONException -> L45
        r100.revertToSystemLocation = r102.optBoolean("revert_to_system_location", false);     // Catch: JSONException -> L45
        r100.lightInfoInterval = r102.optInt("light_info_interval", 3);     // Catch: JSONException -> L45
        r100.maxLightCount = r102.optInt("max_light_count", 30);     // Catch: JSONException -> L45
        r100.maxLightDuration = r102.optLong("max_light_duration", 5000);     // Catch: JSONException -> L45
        r100.sensorCollectionEnabled = r102.optBoolean("sensor_collection_enabled", false);     // Catch: JSONException -> L45
        r100.sensorLightEnabled = r102.optBoolean("light_enabled", true);     // Catch: JSONException -> L45
        r100.sensorLightHz = r102.optInt("light_hz", 10);     // Catch: JSONException -> L45
        r100.sensorMaxCacheSeconds = r102.optLong("sensor_max_cache_seconds", 5);     // Catch: JSONException -> L45
        r100.sensorAccelerometerEnabled = r102.optBoolean("accelerometer_enabled", true);     // Catch: JSONException -> L45
        r100.sensorAccelerometerHz = r102.optInt("accelerometer_hz", 50);     // Catch: JSONException -> L45
        r100.sensorGyroscopeEnabled = r102.optBoolean("gyroscope_enabled", true);     // Catch: JSONException -> L45
        r100.sensorGyroscopeHz = r102.optInt("gyroscope_hz", 50);     // Catch: JSONException -> L45
        r100.sensorMagnetometerEnabled = r102.optBoolean("magnetometer_enabled", true);     // Catch: JSONException -> L45
        r100.sensorMagnetometerHz = r102.optInt("magnetometer_hz", 50);     // Catch: JSONException -> L45
        r100.sensorBarometerEnabled = r102.optBoolean("barometer_enabled", true);     // Catch: JSONException -> L45
        r100.sensorBarometerHz = r102.optInt("barometer_hz", 10);     // Catch: JSONException -> L45
        r100.sensorDopEnabled = r102.optBoolean("dop_enabled", true);     // Catch: JSONException -> L45
        r100.sensorGnssEnabled = r102.optBoolean("gnss_enabled", true);     // Catch: JSONException -> L45
        r100.enableGpsScan = r102.optBoolean("enable_gps_scan", false);     // Catch: JSONException -> L45
        r100.asyncScanWifi = r102.optBoolean("async_scan_wifi", false);     // Catch: JSONException -> L45
        r100.enableCheckConnectWifi = r102.optBoolean("enable_check_connect_wifi", false);     // Catch: JSONException -> L45
        r100.checkConnectWifiRssi = r102.optInt("check_connect_wifi_rssi", -60);     // Catch: JSONException -> L45
        r100.enableCheckWifiCache = r102.optBoolean("enable_check_wifi_cache", false);     // Catch: JSONException -> L45
        r100.checkWifiCacheDuration = r102.optLong("check_wifi_cache_duration", 10000);     // Catch: JSONException -> L45
        r100.enableScanWifi = r102.optBoolean("enable_scan_wifi", true);     // Catch: JSONException -> L45
        r100.useNewReverseGeoLocationApi = r102.optBoolean("use_new_reverse_geolocation_api", false);     // Catch: JSONException -> L45
        r100.enableNoLocReqCgi = r102.optBoolean("enable_no_loc_reqcgi", false);     // Catch: JSONException -> L45
        r100.enableSysNetworkLoc = r102.optBoolean("enable_sys_network_loc", true);     // Catch: JSONException -> L45
        r100.enableLightLocationNewPolicy = r102.optBoolean("enable_light_location_new_policy", false);     // Catch: JSONException -> L45
        r100.enableBackgroundLocation = r102.optBoolean("enable_background_location", false);     // Catch: JSONException -> L45
        r100.enableInfoRequestOpt = r102.optBoolean("enable_info_request_opt", false);     // Catch: JSONException -> L45
        r100.maxWaitGPSTimeMillis = r102.optLong(LocationMonitorConst.MAX_WAIT_GPS_TIME_MILLIS, 0);     // Catch: JSONException -> L45
        r100.preLocationCallback = r102.optBoolean(LocationMonitorConst.PRE_LOCATION_CALLBACK, false);     // Catch: JSONException -> L45
        r100.enableAcceptLightLocationParam = r102.optBoolean("enable_accept_light_location_param", false);     // Catch: JSONException -> L45
        r100.infoRequestKeyParamsMaxCacheTime = r102.optLong("info_request_key_params_max_cache_time", 86400000);     // Catch: JSONException -> L45
        r100.byteLocationLibraParam = r102.optString("byte_location_libra_param", "v2");     // Catch: JSONException -> L45
        r100.searchLocationCacheTime = r102.optLong(SettingsConstants.SEARCH_LOCATION_CACHE_TIME, -1);     // Catch: JSONException -> L45
        r100.byteLocationWhiteList = r102.optString(SettingsConstants.BYTE_LOCATION_WHITE_LIST, "");     // Catch: JSONException -> L45
        r100.collectGpsType = r102.optInt("collect_gps_type", 0);     // Catch: JSONException -> L45
        r100.disableCollectAMapLocationSource = r102.optString("disable_collect_amap_location_source", LocationInfoConst.UNKNOWN_SOURCE);     // Catch: JSONException -> L45
        r100.wifiScanInterval = r102.optLong(SettingsConstants.SCAN_WIFI_INTERVAL, 0);     // Catch: JSONException -> L45
        r100.enableCollectGPSLocationInBatterySavingMode = r102.optBoolean("enable_collect_gps_location_in_battery_saving_mode", false);     // Catch: JSONException -> L45
        r100.enableCollectNetworkLocationInBatterySavingMode = r102.optBoolean(SettingsConstants.ENABLE_COLLECT_NETWORK_LOCATION_IN_BATTERY_SAVING_MODE, false);     // Catch: JSONException -> L45
        r100.enableCollectAMapLocationInBatterySavingMode = r102.optBoolean(SettingsConstants.ENABLE_COLLECT_AMAP_LOCATION_IN_BATTERY_SAVING_MODE, false);     // Catch: JSONException -> L45
        r100.enableCollectBleInBatterySavingMode = r102.optBoolean("enable_collect_ble_in_battery_saving_mode", false);     // Catch: JSONException -> L45
        r100.enableUploadLastLogId = r102.optBoolean(SettingsConstants.ENABLE_UPLOAD_LAST_LOG_ID, true);     // Catch: JSONException -> L45
        r100.enableDestroyAMapSingleClient = r102.optBoolean(SettingsConstants.ENABLE_DESTROY_AMAP_SINGLE_CLIENT, false);     // Catch: JSONException -> L45
        r100.enableDestroyAMapContinuousClient = r102.optBoolean(SettingsConstants.ENABLE_DESTROY_AMAP_CONTINUOUS_CLIENT, false);     // Catch: JSONException -> L45
        r100.enableByteContinuousLocation = r102.optBoolean("enable_byte_continuous_location", true);     // Catch: JSONException -> L45
        r100.locationExpiredInterval = r102.optLong("location_expired_interval", 100000);     // Catch: JSONException -> L45
        r100.uploadNetSignalInterval = r102.optLong("upload_net_signal_interval", 30000);     // Catch: JSONException -> L45
        r100.firstLocationTimeoutMs = r102.optLong("first_location_timeout_ms", 10000);     // Catch: JSONException -> L45
        r100.needUploadLastContinuousLocation = r102.optBoolean("need_upload_last_continuous_location", true);     // Catch: JSONException -> L45
        r100.isUseQuickGPS = r102.optBoolean("is_use_quick_gps", false);     // Catch: JSONException -> L45
        r100.enableFusionLocation = r102.optBoolean("enable_fusion_location", true);     // Catch: JSONException -> L45
        r100.sensorBatchPushInterval = r102.optInt("sensor_batch_push_interval", 10);     // Catch: JSONException -> L45
        r100.sensorBatchGpsInterval = r102.optInt("sensor_batch_gps_interval", 1);     // Catch: JSONException -> L45
        r100.sensorBatchAccelerometerInterval = r102.optInt("sensor_batch_accelerometer_interval", 50);     // Catch: JSONException -> L45
        r100.sensorBatchGyroscopeInterval = r102.optInt("sensor_batch_gyroscope_interval", 50);     // Catch: JSONException -> L45
        r100.sensorBatchMagnetometerInterval = r102.optInt("sensor_batch_magnetometer_interval", 50);     // Catch: JSONException -> L45
        r100.sensorBatchHeadingInterval = r102.optInt("sensor_batch_heading_interval", 20);     // Catch: JSONException -> L45
        r100.sensorBatchBarometerInterval = r102.optInt("sensor_batch_barometer_interval", 10);     // Catch: JSONException -> L45
        r100.sensorBatchLightInterval = r102.optInt("sensor_batch_light_interval", 10);     // Catch: JSONException -> L45
        r100.sensorBatchDopInterval = r102.optInt("sensor_batch_dop_interval", 1);     // Catch: JSONException -> L45
        r100.sensorBatchTempInterval = r102.optInt("sensor_batch_temp_interval", 10);     // Catch: JSONException -> L45
        r100.sensorBatchSatelliteInfoInterval = r102.optInt("sensor_batch_satellite_info_interval", 1);     // Catch: JSONException -> L45
        r100.enableTrackUpload = r102.optBoolean("enable_track_upload", true);     // Catch: JSONException -> L45
        r100.trackIntervalSec = r102.optInt("track_interval_sec", 15);     // Catch: JSONException -> L45
        r100.enableMonitor = r102.optBoolean(DownloadSettingKeys.ENABLE_MONITOR, false);     // Catch: JSONException -> L45
        r100.monitorStrategy = r102.optInt("monitor_strategy", 0);     // Catch: JSONException -> L45
        r100.monitorStrategyInterval = r102.optLong("monitor_strategy_interval", 3000);     // Catch: JSONException -> L45
        JSONArray r103 = r102.optJSONArray("monitor_strategy_class_member");     // Catch: JSONException -> L45
        if (r103 != null) goto L12;
    L20:
        JSONArray r104 = r102.optJSONArray("monitor_business_start_location_class_member");     // Catch: JSONException -> L45
        if (r104 != null) goto L23;
    L31:
        JSONArray r105 = r102.optJSONArray("monitor_business_stop_location_class_member");     // Catch: JSONException -> L45
        if (r105 != null) goto L34;
    L42:
        r100.sEnableRescanWifi = r102.optBoolean("enable_rescan_wifi", false);     // Catch: JSONException -> L45
        r100.sRescanWifiCount = r102.optInt("rescan_wifi_count", 60);     // Catch: JSONException -> L45
        r100.useCacheCondition = r102.optBoolean("use_cache_condition", false);     // Catch: JSONException -> L45
        r100.enableLocationCacheTokenWhiteList = r102.optBoolean("enable_location_cache_token_white_list", false);     // Catch: JSONException -> L45
        r100.locationCacheTokenWhiteList = r102.optString("location_cache_token_white_list", "");     // Catch: JSONException -> L45
        r100.hotBootLocToken = r102.optString("hot_boot_loc_token", "");     // Catch: JSONException -> L45
        r100.hotBootCacheTime = r102.optInt("hot_boot_cache_time", -1);     // Catch: JSONException -> L45
        r100.coldBootCollectGpsStrategy = r102.optInt("cold_boot_collect_gps_strategy", 0);     // Catch: JSONException -> L45
        r100.coldBootCollectGps = r102.optBoolean("cold_boot_collect_gps", false);     // Catch: JSONException -> L45
        r100.networkSignatureMode = r102.optString(LocationMonitorConst.NETWORK_SIGNATURE_MODE, "");     // Catch: JSONException -> L45
        r100.defaultGpsScanInterval = r102.optLong(LocationExtraDataTraceLogger.DEFAULT_GPS_SCAN_INTERVAL, 0);     // Catch: JSONException -> L45
        r100.enableCheckUploadCompliance = r102.optBoolean(LocationExtraDataTraceLogger.ENABLE_CHECK_UPLOAD_COMPLIANCE, true);     // Catch: JSONException -> L45
        r100.enableBackgroundUploadLocation = r102.optBoolean(LocationExtraDataTraceLogger.ENABLE_BACKGROUND_UPLOAD_LOCATION, false);     // Catch: JSONException -> L45
        r100.enableCheckLastLogId = r102.optBoolean(LocationExtraDataTraceLogger.ENABLE_CHECK_LAST_LOG_ID, true);     // Catch: JSONException -> L45
        r100.enableUseCoarseLocation = r102.optBoolean(SettingsConstants.ENABLE_USE_COARSE_LOCATION, false);     // Catch: JSONException -> L45
        r100.enableCollectContinuousGps = r102.optBoolean("collect_continuous_gps_enable", false);     // Catch: JSONException -> L45
        r100.collectContinuousGpsInterval = r102.optLong("collect_continuous_gps_interval", 1000);     // Catch: JSONException -> L45
        r100.collectContinuousGpsDuration = r102.optLong("collect_continuous_gps_duration", 5000);     // Catch: JSONException -> L45
        r100.collectContinuousGpsDisableGnssUpload = r102.optBoolean("collect_continuous_gps_disable_gnss_upload", false);     // Catch: JSONException -> L45
        r100.collectContinuousGpsOnlyLast = r102.optBoolean("collect_continuous_gps_only_last", true);     // Catch: JSONException -> L45
        r100.collectContinuousGpsLocTokenBlacklist = r102.optString("collect_continuous_gps_loc_token_blacklist");     // Catch: JSONException -> L45
        r100.enableDimLocationCheck = r102.optBoolean("enable_dim_location_check", false);     // Catch: JSONException -> L45
        r100.enableTailLocateOptimize = r102.optBoolean(LocationMonitorConst.ENABLE_TAIL_LOCATE_OPTIMIZE, false);     // Catch: JSONException -> L45
        r100.tailAccuracyThreshold = (float) r102.optDouble("tail_accuracy_threshold", 100.0d);     // Catch: JSONException -> L45
        r100.tailWifiTimeThreshold = r102.optLong("tail_wifi_time_threshold", 300000);     // Catch: JSONException -> L45
        r100.disableTailLocateOptimizeSource = r102.optString("disable_tail_locate_optimize_source", LocationInfoConst.UNKNOWN_SOURCE);     // Catch: JSONException -> L45
        r100.isUploadFreshBaseStation = r102.optBoolean("upload_fresh_base_station", false);     // Catch: JSONException -> L45
        r100.freshBaseStationTimeout = r102.optLong(LocationMonitorConst.FRESH_BASE_STATION_TIMEOUT, 0);     // Catch: JSONException -> L45
        r100.baseStationInfoType = r102.optInt(SettingsConstants.BASE_STATION_INFO_TYPE, 0);     // Catch: JSONException -> L45
        r100.enableUploadLastLocationInfo = r102.optBoolean("enable_upload_last_location_info", false);     // Catch: JSONException -> L45
        r100.inOutDoorStatusCacheTime = r102.optLong(SettingsConstants.IN_OUT_DOOR_STATUS_CACHE_TIME, 600000);     // Catch: JSONException -> L45
        r100.enableScanGnss = r102.optBoolean(SettingsConstants.ENABLE_SCAN_GNSS, true);     // Catch: JSONException -> L45
        r100.stationarySceneMaxDistance = r102.optInt(SettingsConstants.STATIONARY_SCENE_MAX_DISTANCE, 50);     // Catch: JSONException -> L45
        r100.stationarySceneMaxInterval = r102.optLong(SettingsConstants.STATIONARY_SCENE_MAX_INTERVAL, 1800000);     // Catch: JSONException -> L45
        r100.stationarySceneMaxGpsAccuracy = r102.optInt(SettingsConstants.STATIONARY_SCENE_MAX_GPS_ACCURACY, 50);     // Catch: JSONException -> L45
        r100.stationarySceneWifiWhiteList = r102.optString(SettingsConstants.STATIONARY_SCENE_WIFI_WHITE_LIST, "");     // Catch: JSONException -> L45
        r100.stationarySceneTokenWhiteList = r102.optString(SettingsConstants.STATIONARY_SCENE_TOKEN_WHITE_LIST, "");     // Catch: JSONException -> L45
        r100.enableStationaryScenePolicy = r102.optBoolean(SettingsConstants.ENABLE_STATIONARY_SCENE_POLICY, false);     // Catch: JSONException -> L45
        r100.enableCollectContinuousGpsForTest = r102.optBoolean(SettingsConstants.ENABLE_COLLECT_CONTINUOUS_GPS_FOR_TEST, false);     // Catch: JSONException -> L45
        r100.enableContinueLocateUploadWifi = r102.optBoolean(SettingsConstants.ENABLE_CONTINUE_LOCATE_UPLOAD_WIFI, true);     // Catch: JSONException -> L45
        r100.enableContinueLocateUploadCell = r102.optBoolean(SettingsConstants.ENABLE_CONTINUE_LOCATE_UPLOAD_CELL, true);     // Catch: JSONException -> L45
        goto L43
    L34:
        if (r105.length() <= 0) goto L42;
        int r106 = 0;
    L37:
        if (r106 >= r105.length()) goto L42;
        String r107 = r105.optString(r106);     // Catch: JSONException -> L45
        if (TextUtils.isEmpty(r107) == true) goto L41;
        r100.monitorBusinessStopLocationClassMember.add(r107);     // Catch: JSONException -> L45
    L41:
        r106 = r106 + 1;     // Catch: JSONException -> L45
        goto L37
    L23:
        if (r104.length() <= 0) goto L31;
        int r108 = 0;
    L26:
        if (r108 >= r104.length()) goto L31;
        String r109 = r104.optString(r108);     // Catch: JSONException -> L45
        if (TextUtils.isEmpty(r109) == true) goto L30;
        r100.monitorBusinessStartLocationClassMember.add(r109);     // Catch: JSONException -> L45
    L30:
        r108 = r108 + 1;     // Catch: JSONException -> L45
        goto L26
    L12:
        if (r103.length() <= 0) goto L20;
        int r111 = 0;
    L15:
        if (r111 >= r103.length()) goto L20;
        String r112 = r103.optString(r111);     // Catch: JSONException -> L45
        if (TextUtils.isEmpty(r112) == true) goto L19;
        r100.monitorStrategyClassMember.add(r112);     // Catch: JSONException -> L45
    L19:
        r111 = r111 + 1;     // Catch: JSONException -> L45
    L43:
        r100.shakeConfig = r101.optJSONObject(LOCATION_SHAKE_SETTINGS_KEY);     // Catch: JSONException -> L45
        r100.beaconConfig = r101.optJSONObject(LOCATION_BEACON_SETTINGS_KEY);     // Catch: JSONException -> L45
    L46:
        return r100;
    L45:
        Logger.i("LocationSettingModel parseLocationSettingModel error");
        goto L46
    }
}

package com.bytedance.bdlocation.client;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LocationInfoConst {
    public static final int ACCURACYLEVEL_CITY = 2;
    public static final int ACCURACYLEVEL_COUNTRY = 0;
    public static final int ACCURACYLEVEL_DISTRICT = 3;
    public static final int ACCURACYLEVEL_POI = 4;
    public static final int ACCURACYLEVEL_PROVINCE = 1;
    public static final String ALLOW_USE_LOCATION = "1";
    public static final int ALL_LOCATION = 2;
    public static final String AMAP = "AMap";
    public static final int ANDROID = 2;
    public static final int ANDROID_ALWAYS = 5;
    public static final int ANDROID_APPROXIMATE_LOCATION_ON = 32;
    public static final int ANDROID_GPS_PROVIDER_ON = 2;
    public static final int ANDROID_NETWORK_PROVIDER_ON = 4;
    public static final int ANDROID_NO = 71;
    public static final int ANDROID_OK = 1;
    public static final int ANDROID_PASSIVE_PROVIDER_ON = 8;
    public static final int ANDROID_WHEN_IN_USE = 3;
    public static final int AdministrativeArea = 1;
    public static final String BACKGROUND_UPLOAD = "_background_upload";
    public static final int BASE_STATION = 3;
    public static final int BASE_STATION_ONLY_REFRESH = 1;
    public static final String BDLOCATION = "bdlocation";
    public static final int BEIDOU = 12;
    public static final String BYTE = "ByteLocation";
    public static final String BYTE_CONTINUOUS = "ByteContinuousLocation";
    public static final String BYTE_FUSION_CONTINUOUS = "ByteFusionContinuousLocation";
    public static final int Battery_Saving = 0;
    public static final int CACHE = 5;
    public static final String CDMA = "cdma";
    public static final int COARSE = 11;
    public static final int COARSE_LOCATION = 1;
    public static final String COLDSTART_CERT = "coldstart_cert";
    public static final int COLD_BOOT_GET_CACHE_GPS = 3;
    public static final int COLD_BOOT_GET_CACHE_GPS_NETWORK = 2;
    public static final int COLD_BOOT_GET_GPS_NETWORK = 1;
    public static final int COLD_BOOT_GET_NETWORK = 4;
    public static final int COLD_BOOT_NOT_COLLECT = 0;
    public static final int COLLECT_ALL_TYPE = 0;
    public static final int COLLECT_AMAP_TYPE = 2;
    public static final int COLLECT_NETWORK_TYPE = 1;
    public static final String CONTINUE = "continuous";
    public static final int CONTINUOUS_GPS_MODE = 2;
    public static final int City = 2;
    public static final int Country = 0;
    public static final int DEFAULT_CACHE_TIME = 5000;
    public static final int Device_Sensors = 1;
    public static final int District = 3;
    public static final int FINE_LOCATION = 0;
    public static final String GCJ_O2 = "gcj02";
    public static final int GEOCODE = 1;
    public static final String GOOGLE = "Google";
    public static final int GPS = 1;
    public static final String GSM = "gsm";
    public static final int HALF_MINUTES = 30000;
    public static final String HTTPS = "https";
    public static final int Hight_Accuracy = 2;
    public static final String INIT_CERT = "init_cert";
    public static final int INVOKER_API_INIT_STATUS_DEFAULT = -1;
    public static final int INVOKER_API_INIT_STATUS_DISABLE = 0;
    public static final int INVOKER_API_INIT_STATUS_ENABLE = 1;
    public static final int IN_DOOR = 1;
    public static final int IOS = 1;
    public static final int IP = 6;
    public static final int LAST_CACHE = 10;
    public static final String LIBRA_PARAM_V1 = "v1";
    public static final String LIBRA_PARAM_V2 = "v2";
    public static final String LIGHT = "LightLocation";
    public static final String LIGHT_LOCATION_IS_DOWNGRADE_KEY = "is_downgrade";
    public static final String LIGHT_LOCATION_UPLOAD_CELL_KEY = "bi";
    public static final String LIGHT_LOCATION_UPLOAD_WIFI_KEY = "wi";
    public static final int LOCATE_AMAP = 1;
    public static final int LOCATE_BYTE = 3;
    public static final int LOCATE_BYTE_CONTINUOUS = 6;
    public static final int LOCATE_BYTE_FUSION_CONTINUOUS = 7;
    public static final int LOCATE_GOOGLE = 2;
    public static final int LOCATE_MOCK = 4;
    public static final int LOCATE_SYS = 0;
    public static final int LOCATE_TMAP = 5;
    public static final int LOCATION_RANGE_SIZE = 4;
    public static final int LOCATION_TIMEOUT_LOWER_LIMIT = 5000;
    public static final String LTE = "lte";
    public static final int MCC = 7;
    public static final String MOCK = "Mock";
    public static final long MOCK_RSSI = 0;
    public static final String MOCK_WIFI_MAC = "02:04:06:08:0A:0C";
    public static final int NETWORK = 4;
    public static final String NETWORK_CHANGE_CERT = "network_change_cert";
    public static final int NOT_SCAN = 1;
    public static final int NO_GEOCODE = 0;
    public static final String NR = "nr";
    public static final int NoChange = -1;
    public static final int OFFLINE = 9;
    public static final int OUT_DOOR = 2;
    public static final String POLL_CERT = "poll_cert";
    public static final int PREVIOUS = 8;
    public static final int REQUEST_CELL_INFO_SUCCESS = 200;
    public static final int RESTRICTED_MODE_OFF = 2;
    public static final int RESTRICTED_MODE_ON = 1;
    public static final int RESTRICTED_MODE_UNKNOWN = 0;
    public static final int SCAN_FAIL = 2;
    public static final int SCAN_SUCCESS = 3;
    public static final String SINGLE = "single";
    public static final int SINGLE_GPS_MODE = 1;
    public static final int STATIONARY_SCENE_WITH_AOI_STATUS_DISABLE = 1;
    public static final int STATIONARY_SCENE_WITH_AOI_STATUS_ENABLE = 2;
    public static final String SYSTEM = "Android";
    public static final int SYSTEM_LOCATION_OFF = 1;
    public static final int SubAdministrativeArea = 4;
    public static final String TEST_CHANNEL = "local_test,debug";
    public static final String TMap = "TMap";
    public static final int TRUSTED_LEVEL_BAD = 4;
    public static final int TRUSTED_LEVEL_HIGH = 1;
    public static final int TRUSTED_LEVEL_LOW = 3;
    public static final int TRUSTED_LEVEL_NORMAL = 2;
    public static final int TWO_MINUTES = 120000;
    public static final int UNIVERSAL = 0;
    public static final int UNKNOWN = 0;
    public static final float UNKNOWN_CONFIDENCE = -1.0f;
    public static final int UNKNOWN_GPS_MODE = 0;
    public static final int UNKNOWN_MODE = -1;
    public static final String UNKNOWN_SERVER_LOCATE_METHOD = "unknown";
    public static final String UNKNOWN_SOURCE = "unknown_source";
    public static final int USER_MOTION_MODE_CYCLING = 2;
    public static final int USER_MOTION_MODE_DRIVING = 3;
    public static final int USER_MOTION_MODE_UNKNOWN = 0;
    public static final int USER_MOTION_MODE_WALKING = 1;
    public static final String WCDMA = "wcdma";
    public static final String WGS_84 = "wgs84";
    public static final int WIFI = 2;
    public static final int WORK_MODE_CRUISE = 1;
    public static final int WORK_MODE_NAVIGATION = 2;
    public static final int WORK_MODE_NORMAL = 0;
    public static final String defaultRedGeoNameIds = "1814991,1819730,1821275";
    public static final long defaultsOverseasCacheValidity = 28800000;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CoordinateSystem {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DeviceType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GpsMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocationMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocationSDK {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocationType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Permission {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RadioType {
    }

    public LocationInfoConst() {
    }
}

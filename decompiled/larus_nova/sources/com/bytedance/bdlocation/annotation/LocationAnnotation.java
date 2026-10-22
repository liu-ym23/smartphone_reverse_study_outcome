package com.bytedance.bdlocation.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes10.dex */
public class LocationAnnotation {

    @Retention(RetentionPolicy.SOURCE)
    public @interface CheckConnectedValidWiFiType {
        public static final int DIFFERENT_WIFI = 5;
        public static final int HIT_WHITE_WIFI = 1;
        public static final int LOCATION_NULL = 6;
        public static final int METERED_NETWORK = 3;
        public static final int SAME_WIFI = 4;
        public static final int UNKNOWN = 0;
        public static final int WIFI_MAC_NULL = 2;
        public static final int WIFI_NULL = 7;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CheckStationaryScenePolicyType {
        public static final int AOI_INVALID = 3;
        public static final int DISTANCE_LARGE = 7;
        public static final int HIGHT_ACCURACY_INVALID = 6;
        public static final int INTERVAL_LARGE = 4;
        public static final int LOCATION_NULL = 2;
        public static final int NOT_HIT_TOKEN_WHITE_LIST = 9;
        public static final int NOT_OPEN_SCENE = 8;
        public static final int SUCCESS = 1;
        public static final int UNABLE = 0;
        public static final int WIFI_INVALID = 5;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GeocodeMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LightLocationType {
        public static final String LIGHT_LOCATION_ALL = "all";
        public static final String LIGHT_LOCATION_CELL = "cell";
        public static final String LIGHT_LOCATION_WIFI = "wifi";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocateCacheCode {
        public static final int CACHE_CONDITION_1 = 1;
        public static final int CACHE_CONDITION_10 = 10;
        public static final int CACHE_CONDITION_11 = 11;
        public static final int CACHE_CONDITION_12 = 12;
        public static final int CACHE_CONDITION_13 = 13;
        public static final int CACHE_CONDITION_14 = 14;
        public static final int CACHE_CONDITION_2 = 2;
        public static final int CACHE_CONDITION_3 = 3;
        public static final int CACHE_CONDITION_4 = 4;
        public static final int CACHE_CONDITION_5 = 5;
        public static final int CACHE_CONDITION_6 = 6;
        public static final int CACHE_CONDITION_7 = 7;
        public static final int CACHE_CONDITION_8 = 8;
        public static final int CACHE_CONDITION_9 = 9;
        public static final int INIT_VAL = -1;
        public static final int LOCATE_ON_ERROR = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocateReasonCode {
        public static final int CACHE_AVAILABLE = 3;
        public static final int CACHE_NOT_RECOMMEND = 4;
        public static final int INIT_VAL = -1;
        public static final int REASON_0 = 0;
        public static final int REASON_1 = 1;
        public static final int REASON_2 = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocateType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocationAccuracy {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocationMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocationPermission {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocationRange {
    }

    public @interface NetworkStatusType {
        public static final int BLUETOOTH = 103;
        public static final int CELLULAR = 101;
        public static final int ETHERNET = 104;
        public static final int LOWPAN = 107;
        public static final int NONE = 0;
        public static final int NO_CONNECTION = 100;
        public static final int VPN = 105;
        public static final int WIFI = 102;
        public static final int WIFI_AWARE = 106;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RestrictedMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SubmitSource {
        public static final String CACHE_LOCATION = "cache_location";
        public static final String FULL_LOCATION = "full_location";
        public static final String LIGHT_LOCATION = "light_location";
        public static final String LIGHT_LOCATION_SUBMIT_V2 = "light_location_submit_v2";
        public static final String RESCAN_WIFI = "rescan_wifi";
        public static final String UPLOAD_GPS_BLE = "upload_gps_ble";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TriggerType {
        public static final int AUTO = 0;
        public static final int MANUAL = 1;
    }

    public LocationAnnotation() {
    }
}

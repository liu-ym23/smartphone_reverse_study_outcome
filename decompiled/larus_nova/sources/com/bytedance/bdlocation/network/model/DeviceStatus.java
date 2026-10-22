package com.bytedance.bdlocation.network.model;

import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceStatus {

    @SerializedName("bluetooth_permission")
    public int bluetoothPermission;

    @SerializedName("is_bluetooth_open")
    public boolean bluetoothSwitch;

    @SerializedName("device_type")
    public int deviceType;

    @SerializedName("is_strict_restricted_mode")
    public boolean isStrictRestrictedMode;

    @SerializedName(LocationMonitorConst.IS_WIFI_CACHE)
    public String isWifiCache;

    @SerializedName(LocationMonitorConst.IS_WIFI_OPEN)
    public boolean isWifiOpen;

    @SerializedName("system_language")
    public String language;

    @SerializedName("locale")
    public String locale;

    @SerializedName(LocationMonitorConst.LOCATION_MODE)
    public int locationMode;

    @SerializedName("mccmnc")
    public String mccmnc;

    @SerializedName("permission")
    public int permission;

    @SerializedName("system_region")
    public String region;

    @SerializedName("restricted_mode")
    public int restrictedMode;

    /* JADX INFO: loaded from: classes10.dex */
    public static final class DiffDimension {
        public static final int DIFF_BLUETOOTH_PERMISSION = 1024;
        public static final int DIFF_BLUETOOTH_SWITCH_STATUS = 2;
        public static final int DIFF_IS_STRICT_RESTRICTED_MODE = 512;
        public static final int DIFF_IS_WIFI_OPEN = 4;
        public static final int DIFF_LANGUAGE = 32;
        public static final int DIFF_LOCALE = 64;
        public static final int DIFF_LOCATION_MODE = 256;
        public static final int DIFF_LOCATION_PERMISSION = 1;
        public static final int DIFF_MCC_MNC = 8;
        public static final int DIFF_REGION = 16;
        public static final int DIFF_RESTRICTED_MODE = 128;

        public DiffDimension() {
        }
    }

    public DeviceStatus() {
        this.isWifiCache = "unknown";
    }

    public int diffWith(DeviceStatus r100) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        if (TextUtils.equals(this.mccmnc, r100.mccmnc) == true) goto L8;
        int r101 = 8;
    L10:
        if (TextUtils.equals(this.region, r100.region) == true) goto L13;
        r101 = r101 | 16;
    L13:
        if (TextUtils.equals(this.language, r100.language) == true) goto L16;
        r101 = r101 | 32;
    L16:
        if (TextUtils.equals(this.locale, r100.locale) == true) goto L19;
        r101 = r101 | 64;
    L19:
        if (this.permission == r100.permission) goto L22;
        r101 = r101 | 1;
    L22:
        if (this.restrictedMode == r100.restrictedMode) goto L25;
        r101 = r101 | 128;
    L25:
        if (this.locationMode == r100.locationMode) goto L28;
        r101 = r101 | 256;
    L28:
        if (this.isStrictRestrictedMode == r100.isStrictRestrictedMode) goto L31;
        r101 = r101 | 512;
    L31:
        if (this.bluetoothSwitch == r100.bluetoothSwitch) goto L34;
        r101 = r101 | 2;
    L34:
        if (this.isWifiOpen == r100.isWifiOpen) goto L37;
        r101 = r101 | 4;
    L37:
        if (this.bluetoothPermission != r100.bluetoothPermission) goto L39;
        return r101;
    L39:
        return r101 | 1024;
    L8:
        r101 = 0;
        goto L10
    }
}

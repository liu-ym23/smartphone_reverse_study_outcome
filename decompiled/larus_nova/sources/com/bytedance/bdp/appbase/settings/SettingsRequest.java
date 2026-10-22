package com.bytedance.bdp.appbase.settings;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpInfoService;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class SettingsRequest {
    private String appId;
    private String appName;
    private int bdpVersionCode;
    private String callerName;
    private String channel;
    private String ctxInfo;
    private String deviceBrand;
    private String deviceId;
    private String devicePlatform;
    private String deviceType;
    private boolean dyeTagType;
    private String installId;
    private String isAndroidPad;
    private int osApi;
    private String osVersion;
    private String pluginVersion;
    private Map<String, String> queryParams;
    private long settingsTime;
    private String settingsUrl;
    private String updateVersionCode;
    private String versionCode;
    private String versionName;

    public static class Builder {
        private String appId;
        private String appName;
        private int bdpVersionCode;
        private String callerName;
        private String channel;
        private String ctxInfo;
        private String deviceBrand;
        private String deviceId;
        private String devicePlatform;
        private String deviceType;
        private boolean dyeTagType;
        private String installId;
        private String isAndroidPad;
        private int osApi;
        private String osVersion;
        private String pluginVersion;
        private Map<String, String> queryParams;
        private long settingsTime;
        private String settingsUrl;
        private String updateVersionCode;
        private String versionCode;
        private String versionName;

        public SettingsRequest build() {
            SettingsRequest r100 = new SettingsRequest(null);
            SettingsRequest.access$102(r100, this.settingsUrl);
            SettingsRequest.access$202(r100, this.callerName);
            SettingsRequest.access$302(r100, this.pluginVersion);
            SettingsRequest.access$402(r100, this.appId);
            SettingsRequest.access$502(r100, this.appName);
            SettingsRequest.access$602(r100, this.versionCode);
            SettingsRequest.access$702(r100, this.devicePlatform);
            SettingsRequest.access$802(r100, this.deviceType);
            SettingsRequest.access$902(r100, this.deviceBrand);
            SettingsRequest.access$1002(r100, this.deviceId);
            SettingsRequest.access$1102(r100, this.bdpVersionCode);
            SettingsRequest.access$1202(r100, this.ctxInfo);
            SettingsRequest.access$1302(r100, this.settingsTime);
            SettingsRequest.access$1402(r100, this.osVersion);
            SettingsRequest.access$1502(r100, this.osApi);
            SettingsRequest.access$1602(r100, this.channel);
            SettingsRequest.access$1702(r100, this.queryParams);
            SettingsRequest.access$1802(r100, this.updateVersionCode);
            SettingsRequest.access$1902(r100, this.versionName);
            SettingsRequest.access$2002(r100, this.installId);
            SettingsRequest.access$2102(r100, this.dyeTagType);
            SettingsRequest.access$2202(r100, this.isAndroidPad);
            return r100;
        }

        public Builder() {
            this.settingsUrl = "https://ib.snssdk.com/service/settings/v3/";
            this.callerName = "iron_man";
            this.deviceType = Build.MODEL;
            this.deviceBrand = Build.BRAND;
            BdpInfoService r100 = (BdpInfoService) BdpManager.getInst().getService(BdpInfoService.class);
            if (r100 != null) goto L5;
            return;
        L5:
            this.pluginVersion = r100.getHostInfo().getPluginVersion();
            this.appId = r100.getHostInfo().getAppId();
            this.appName = r100.getHostInfo().getAppName();
            this.versionCode = r100.getHostInfo().getVersionCode();
            this.devicePlatform = r100.getHostInfo().getDevicePlatform();
            this.deviceId = r100.getHostInfo().getDeviceId("");
            BdpManager.getInst().getSDKInfo().getClass();
            this.bdpVersionCode = 13080201;
            r100.B();
            this.isAndroidPad = "0";
        }

        public String getAppId() {
            return this.appId;
        }

        public String getAppName() {
            return this.appName;
        }

        public String getCallerName() {
            return this.callerName;
        }

        public String getCtxInfo() {
            return this.ctxInfo;
        }

        public String getDeviceBrand() {
            return this.deviceBrand;
        }

        public String getDeviceId() {
            return this.deviceId;
        }

        public String getDevicePlatform() {
            return this.devicePlatform;
        }

        public String getDeviceType() {
            return this.deviceType;
        }

        public boolean getDyeTagType() {
            return this.dyeTagType;
        }

        public String getIsAndroidPad() {
            return this.isAndroidPad;
        }

        public String getPluginVersion() {
            return this.pluginVersion;
        }

        public Map<String, String> getQueryParams() {
            return this.queryParams;
        }

        public long getSettingsTime() {
            return this.settingsTime;
        }

        public String getSettingsUrl() {
            return this.settingsUrl;
        }

        public String getVersionCode() {
            return this.versionCode;
        }

        public Builder setAppId(String r100) {
            this.appId = r100;
            return this;
        }

        public Builder setAppName(String r100) {
            this.appName = r100;
            return this;
        }

        public Builder setBdpVersionCode(int r100) {
            this.bdpVersionCode = r100;
            return this;
        }

        public Builder setCallerName(String r100) {
            this.callerName = r100;
            return this;
        }

        public Builder setChannel(String r100) {
            this.channel = r100;
            return this;
        }

        public Builder setCtxInfo(String r100) {
            this.ctxInfo = r100;
            return this;
        }

        public Builder setDeviceBrand(String r100) {
            this.deviceBrand = r100;
            return this;
        }

        public Builder setDeviceId(String r100) {
            this.deviceId = r100;
            return this;
        }

        public Builder setDevicePlatform(String r100) {
            this.devicePlatform = r100;
            return this;
        }

        public Builder setDeviceType(String r100) {
            this.deviceType = r100;
            return this;
        }

        public Builder setDyeTagType(boolean r100) {
            this.dyeTagType = r100;
            return this;
        }

        public Builder setInstallId(String r100) {
            this.installId = r100;
            return this;
        }

        public Builder setIsAndroidPad(String r100) {
            this.isAndroidPad = r100;
            return this;
        }

        public Builder setOsApi(int r100) {
            this.osApi = r100;
            return this;
        }

        public Builder setOsVersion(String r100) {
            this.osVersion = r100;
            return this;
        }

        public Builder setPluginVersion(String r100) {
            this.pluginVersion = r100;
            return this;
        }

        public Builder setQueryParams(Map<String, String> r100) {
            this.queryParams = r100;
            return this;
        }

        public Builder setSettingsTime(long r100) {
            this.settingsTime = r100;
            return this;
        }

        public Builder setSettingsUrl(String r100) {
            this.settingsUrl = r100;
            return this;
        }

        public Builder setUpdateVersionCode(String r100) {
            this.updateVersionCode = r100;
            return this;
        }

        public Builder setVersionCode(String r100) {
            this.versionCode = r100;
            return this;
        }

        public Builder setVersionName(String r100) {
            this.versionName = r100;
            return this;
        }
    }

    public static /* synthetic */ class a {
    }

    private SettingsRequest() {
    }

    public String toUrl() {
        StringBuilder r100 = new StringBuilder(this.settingsUrl);
        HashMap r101 = new HashMap();
        Map<String, String> r102 = this.queryParams;
        if (r102 == null) goto L5;
        r101.putAll(r102);
    L5:
        appendParamsIfNotEmpty(r100, Constant.KEY_CALL_NAME, this.callerName, r101, true);
        appendParamsIfNotEmpty(r100, "app_id", this.appId, r101, false);
        appendParamsIfNotEmpty(r100, "app_name", this.appName, r101, false);
        appendParamsIfNotEmpty(r100, "version_code", this.versionCode, r101, false);
        appendParamsIfNotEmpty(r100, "device_platform", this.devicePlatform, r101, false);
        appendParamsIfNotEmpty(r100, "device_type", this.deviceType, r101, false);
        appendParamsIfNotEmpty(r100, "device_brand", this.deviceBrand, r101, false);
        appendParamsIfNotEmpty(r100, "device_id", this.deviceId, r101, false);
        appendParamsIfNotEmpty(r100, "bdp_version_code", this.bdpVersionCode + "", r101, false);
        appendParamsIfNotEmpty(r100, BdpAppEventConstant.PARAMS_PLUGIN_VERSION, this.pluginVersion, r101, false);
        appendParamsIfNotEmpty(r100, "ctx_infos", this.ctxInfo, r101, false);
        appendParamsIfNotEmpty(r100, "settings_time", "" + this.settingsTime, r101, false);
        appendParamsIfNotEmpty(r100, "os_version", this.osVersion, r101, false);
        appendParamsIfNotEmpty(r100, "os_api", "" + this.osApi, r101, false);
        appendParamsIfNotEmpty(r100, "channel", this.channel, r101, false);
        appendParamsIfNotEmpty(r100, "update_version_code", this.updateVersionCode, r101, false);
        appendParamsIfNotEmpty(r100, "version_name", this.versionName, r101, false);
        appendParamsIfNotEmpty(r100, WsConstants.KEY_INSTALL_ID, this.installId, r101, false);
        appendParamsIfNotEmpty(r100, "is_android_pad", this.isAndroidPad, r101, false);
        Iterator r103 = r101.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L10;
        Map.Entry r104 = (Map.Entry) r103.next();
        appendParamsIfNotEmpty(r100, (String) r104.getKey(), (String) r104.getValue(), null, false);
        goto L7
    L10:
        return r100.toString();
    }

    public String toString() {
        return toUrl();
    }

    public boolean getDyeTagType() {
        return this.dyeTagType;
    }

    public /* synthetic */ SettingsRequest(a r100) {
        this();
    }

    public static /* synthetic */ String access$1002(SettingsRequest r100, String r101) {
        r100.deviceId = r101;
        return r101;
    }

    public static /* synthetic */ String access$102(SettingsRequest r100, String r101) {
        r100.settingsUrl = r101;
        return r101;
    }

    public static /* synthetic */ int access$1102(SettingsRequest r100, int r101) {
        r100.bdpVersionCode = r101;
        return r101;
    }

    public static /* synthetic */ String access$1202(SettingsRequest r100, String r101) {
        r100.ctxInfo = r101;
        return r101;
    }

    public static /* synthetic */ long access$1302(SettingsRequest r100, long r101) {
        r100.settingsTime = r101;
        return r101;
    }

    public static /* synthetic */ String access$1402(SettingsRequest r100, String r101) {
        r100.osVersion = r101;
        return r101;
    }

    public static /* synthetic */ int access$1502(SettingsRequest r100, int r101) {
        r100.osApi = r101;
        return r101;
    }

    public static /* synthetic */ String access$1602(SettingsRequest r100, String r101) {
        r100.channel = r101;
        return r101;
    }

    public static /* synthetic */ Map access$1702(SettingsRequest r100, Map r101) {
        r100.queryParams = r101;
        return r101;
    }

    public static /* synthetic */ String access$1802(SettingsRequest r100, String r101) {
        r100.updateVersionCode = r101;
        return r101;
    }

    public static /* synthetic */ String access$1902(SettingsRequest r100, String r101) {
        r100.versionName = r101;
        return r101;
    }

    public static /* synthetic */ String access$2002(SettingsRequest r100, String r101) {
        r100.installId = r101;
        return r101;
    }

    public static /* synthetic */ String access$202(SettingsRequest r100, String r101) {
        r100.callerName = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2102(SettingsRequest r100, boolean r101) {
        r100.dyeTagType = r101;
        return r101;
    }

    public static /* synthetic */ String access$2202(SettingsRequest r100, String r101) {
        r100.isAndroidPad = r101;
        return r101;
    }

    public static /* synthetic */ String access$302(SettingsRequest r100, String r101) {
        r100.pluginVersion = r101;
        return r101;
    }

    public static /* synthetic */ String access$402(SettingsRequest r100, String r101) {
        r100.appId = r101;
        return r101;
    }

    public static /* synthetic */ String access$502(SettingsRequest r100, String r101) {
        r100.appName = r101;
        return r101;
    }

    public static /* synthetic */ String access$602(SettingsRequest r100, String r101) {
        r100.versionCode = r101;
        return r101;
    }

    public static /* synthetic */ String access$702(SettingsRequest r100, String r101) {
        r100.devicePlatform = r101;
        return r101;
    }

    public static /* synthetic */ String access$802(SettingsRequest r100, String r101) {
        r100.deviceType = r101;
        return r101;
    }

    public static /* synthetic */ String access$902(SettingsRequest r100, String r101) {
        r100.deviceBrand = r101;
        return r101;
    }

    private void appendParamsIfNotEmpty(StringBuilder r100, String r101, String r102, Map<String, String> r103, boolean r104) {
        if (TextUtils.isEmpty(r102) == false) goto L8;
        if (r103 != null) goto L6;
        return;
    L6:
        if (r103.containsKey(r101) == true) goto L8;
        return;
    L8:
        if (r103 == null) goto L13;
        if (r103.containsKey(r101) == false) goto L13;
        r102 = r103.get(r101);
        r103.remove(r101);
    L13:
        if (r104 == false) goto L15;
        r100.append("?");
        r100.append(r101);
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(r102);
        return;
    L15:
        r100.append("&");
        r100.append(r101);
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(r102);
    }
}

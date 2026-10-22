package com.ss.android.downloadad.api.download;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class AppPkgInfo {
    private String appName;
    private String descUrl;
    private String developerName;
    private String iconUrl;
    private String permissionUrl;
    private String policyUrl;
    private String regUrl;
    private String versionName;

    public interface JsonKey {
        public static final String APP_NAME = "app_name";
        public static final String DESC_URL = "desc_url";
        public static final String DEVELOPER_NAME = "developer_name";
        public static final String ICON_URL = "icon_url";
        public static final String PERMISSION_URL = "permission_url";
        public static final String POLICY_URL = "policy_url";
        public static final String REG_URL = "reg_url";
        public static final String VERSION_NAME = "version_name";
    }

    public AppPkgInfo() {
    }

    public String getAppName() {
        return this.appName;
    }

    public String getDescUrl() {
        return this.descUrl;
    }

    public String getDeveloperName() {
        return this.developerName;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getPermissionUrl() {
        return this.permissionUrl;
    }

    public String getPolicyUrl() {
        return this.policyUrl;
    }

    public String getRegUrl() {
        return this.regUrl;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public static boolean checkAppPkgInfoComplete(AppPkgInfo r100) {
        if (r100 == null) goto L14;
        if (TextUtils.isEmpty(r100.appName) == true) goto L14;
        if (TextUtils.isEmpty(r100.developerName) == true) goto L14;
        if (TextUtils.isEmpty(r100.versionName) == true) goto L14;
        if (TextUtils.isEmpty(r100.permissionUrl) == true) goto L14;
        if (TextUtils.isEmpty(r100.policyUrl) == true) goto L14;
    L15:
        return true;
    L14:
        if (TextUtils.isEmpty(r100.descUrl) == true) goto L15;
        return false;
    }

    public static JSONObject generateAppPkgInfoJson(AppPkgInfo r100) {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L9;
    L8:
        return r101;
    L9:
        r101.putOpt("app_name", r100.appName);     // Catch: Exception -> L6
        r101.putOpt("developer_name", r100.developerName);     // Catch: Exception -> L6
        r101.putOpt("version_name", r100.versionName);     // Catch: Exception -> L6
        r101.putOpt(JsonKey.PERMISSION_URL, r100.permissionUrl);     // Catch: Exception -> L6
        r101.putOpt("policy_url", r100.policyUrl);     // Catch: Exception -> L6
        r101.putOpt("icon_url", r100.iconUrl);     // Catch: Exception -> L6
        r101.putOpt("desc_url", r100.descUrl);     // Catch: Exception -> L6
        r101.putOpt("reg_url", r100.regUrl);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        GlobalInfo.getTTMonitor().monitorException(e, "AdDownloadEventConfig appPkginfo fromJson");
        goto L8
    }

    public static AppPkgInfo getAppPkgInfoObject(JSONObject r100) {
        AppPkgInfo r101 = new AppPkgInfo();
        r101.setAppName(r100.optString("app_name"));
        r101.setDeveloperName(r100.optString("developer_name"));
        r101.setVersionName(r100.optString("version_name"));
        r101.setPermissionUrl(r100.optString(JsonKey.PERMISSION_URL));
        r101.setPolicyUrl(r100.optString("policy_url"));
        r101.setIconUrl(r100.optString("icon_url"));
        r101.setDescUrl(r100.optString("desc_url"));
        r101.setRegUrl(r100.optString("reg_url"));
        return r101;
    }

    public void setAppName(String r100) {
        this.appName = r100;
    }

    public void setDescUrl(String r100) {
        this.descUrl = r100;
    }

    public void setDeveloperName(String r100) {
        this.developerName = r100;
    }

    public void setIconUrl(String r100) {
        this.iconUrl = r100;
    }

    public void setPermissionUrl(String r100) {
        this.permissionUrl = r100;
    }

    public void setPolicyUrl(String r100) {
        this.policyUrl = r100;
    }

    public void setRegUrl(String r100) {
        this.regUrl = r100;
    }

    public void setVersionName(String r100) {
        this.versionName = r100;
    }
}

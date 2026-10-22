package com.ss.android.downloadlib.addownload.compliance;

import android.text.TextUtils;
import com.ss.android.downloadlib.exception.TTDownloaderMonitor;
import com.ss.android.downloadlib.utils.ToolUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class ComplianceResult {
    public static final int REQUEST_SUCCESS = 0;
    private long Id;
    private int appstorePermit;
    private AuthInfo authInfo;
    private String backWebUrl;
    private int code;
    private int downloadPermit;
    private int hijackPermit;
    private String hijackUrl;
    private String hwAppId;
    private String marketDeepLink;
    private int marketOnlineStatus;
    private String message;
    private String packageName;
    private long requestDuration;
    private boolean showAuth;
    private Status status;

    public static class AuthInfo {
        private String appName;
        private String descUrl;
        private String developerName;
        private String downloadUrl;
        private String iconUrl;
        private String packageName;
        private String permissionClassifyUrl;
        private List<Permissions> permissions;
        private String policyUrl;
        private String regUrl;
        private long size;
        private long updateTime;
        private String versionName;

        public static class Permissions {
            private String permissionDesc;
            private String permissionName;

            public Permissions() {
            }

            public String getPermissionDesc() {
                return this.permissionDesc;
            }

            public String getPermissionName() {
                return this.permissionName;
            }

            public static /* synthetic */ String access$1300(Permissions r100) {
                return r100.permissionName;
            }

            public static /* synthetic */ String access$1400(Permissions r100) {
                return r100.permissionDesc;
            }

            public void setPermissionDesc(String r100) {
                this.permissionDesc = r100;
            }

            public void setPermissionName(String r100) {
                this.permissionName = r100;
            }
        }

        public AuthInfo() {
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

        public String getDownloadUrl() {
            return this.downloadUrl;
        }

        public String getIconUrl() {
            return this.iconUrl;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public String getPermissionClassifyUrl() {
            return this.permissionClassifyUrl;
        }

        public List<Permissions> getPermissions() {
            return this.permissions;
        }

        public String getPolicyUrl() {
            return this.policyUrl;
        }

        public String getRegUrl() {
            return this.regUrl;
        }

        public long getSize() {
            return this.size;
        }

        public long getUpdateTime() {
            return this.updateTime;
        }

        public String getVersionName() {
            return this.versionName;
        }

        public static /* synthetic */ String access$000(AuthInfo r100) {
            return r100.appName;
        }

        public static /* synthetic */ String access$100(AuthInfo r100) {
            return r100.versionName;
        }

        public static /* synthetic */ List access$1200(AuthInfo r100) {
            return r100.permissions;
        }

        public static /* synthetic */ long access$200(AuthInfo r100) {
            return r100.updateTime;
        }

        public static /* synthetic */ long access$300(AuthInfo r100) {
            return r100.size;
        }

        public static /* synthetic */ String access$400(AuthInfo r100) {
            return r100.developerName;
        }

        public static /* synthetic */ String access$500(AuthInfo r100) {
            return r100.policyUrl;
        }

        public static /* synthetic */ String access$600(AuthInfo r100) {
            return r100.iconUrl;
        }

        public static /* synthetic */ String access$700(AuthInfo r100) {
            return r100.downloadUrl;
        }

        public static /* synthetic */ String access$800(AuthInfo r100) {
            return r100.permissionClassifyUrl;
        }

        public static /* synthetic */ String access$900(AuthInfo r100) {
            return r100.descUrl;
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

        public void setDownloadUrl(String r100) {
            this.downloadUrl = r100;
        }

        public void setIconUrl(String r100) {
            this.iconUrl = r100;
        }

        public void setPackageName(String r100) {
            this.packageName = r100;
        }

        public void setPermissionUrl(String r100) {
            this.permissionClassifyUrl = r100;
        }

        public void setPermissions(List<Permissions> r100) {
            this.permissions = r100;
        }

        public void setPolicyUrl(String r100) {
            this.policyUrl = r100;
        }

        public void setRegUrl(String r100) {
            this.regUrl = r100;
        }

        public void setSize(long r100) {
            this.size = r100;
        }

        public void setUpdateTime(long r100) {
            this.updateTime = r100;
        }

        public void setVersionName(String r100) {
            this.versionName = r100;
        }
    }

    public interface JsonKey {
        public static final String APPSTORE_PERMIT = "appstore_permit";
        public static final String APP_NAME = "app_name";
        public static final String AUTH_INFO = "auth_info";
        public static final String BACK_WEB_URL = "back_web_url";
        public static final String CODE = "code";
        public static final String DESC_URL = "desc_url";
        public static final String DEVELOPER_NAME = "developer_name";
        public static final String DOWNLOAD_PERMIT = "download_permit";
        public static final String DOWNLOAD_URL = "download_url";
        public static final String HIJACK_PERMIT = "hijack_permit";
        public static final String HIJACK_URL = "hijack_url";
        public static final String HW_APP_ID = "hw_app_id";
        public static final String ICON_URL = "icon_url";
        public static final String ID = "id";
        public static final String MARKET_DEEP_LINK = "deep_link";
        public static final String MARKET_ONLINE_STATUS = "market_online_status";
        public static final String MESSAGE = "message";
        public static final String PACKAGE_NAME = "package_name";
        public static final String PERMISSIONS = "permissions";
        public static final String PERMISSION_CLASSIFY_URL = "permission_classify_url";
        public static final String PERMISSION_DESC = "permission_desc";
        public static final String PERMISSION_NAME = "permission_name";
        public static final String POLICY_URL = "policy_url";
        public static final String REG_URL = "reg_url";
        public static final String REQUEST_DURATION = "request_duration";
        public static final String SHOW_AUTH = "show_auth";
        public static final String SIZE = "size";
        public static final String STATUS = "status";
        public static final String STATUS_MESSAGE = "message";
        public static final String UPDATE_TIME = "update_time";
        public static final String VERSION_NAME = "version_name";
    }

    public static class Status {
        private int status;
        private String statusMessage;

        public Status() {
        }

        public int getStatus() {
            return this.status;
        }

        public String getStatusMessage() {
            return this.statusMessage;
        }

        public static /* synthetic */ int access$1000(Status r100) {
            return r100.status;
        }

        public static /* synthetic */ String access$1100(Status r100) {
            return r100.statusMessage;
        }

        public void setStatus(int r100) {
            this.status = r100;
        }

        public void setStatusMessage(String r100) {
            this.statusMessage = r100;
        }
    }

    public JSONObject generateComplianceResultReport() {
        JSONObject r100 = new JSONObject();
    L20:
        e = move-exception;
        TTDownloaderMonitor.inst().monitorException(e, "generateComplianceResultReport");
    L22:
        return r100;
    L4:
        if (this.showAuth == false) goto L6;
        int r101 = 1;
    L7:
        r100.putOpt(JsonKey.SHOW_AUTH, Integer.valueOf(r101));     // Catch: JSONException -> L20
        r100.putOpt(JsonKey.DOWNLOAD_PERMIT, Integer.valueOf(this.downloadPermit));     // Catch: JSONException -> L20
        r100.putOpt("appstore_permit", Integer.valueOf(this.appstorePermit));     // Catch: JSONException -> L20
        r100.putOpt("market_online_status", Integer.valueOf(this.marketOnlineStatus));     // Catch: JSONException -> L20
        r100.putOpt(JsonKey.HIJACK_PERMIT, Integer.valueOf(this.hijackPermit));     // Catch: JSONException -> L20
        r100.putOpt(JsonKey.HIJACK_URL, this.hijackUrl);     // Catch: JSONException -> L20
        r100.putOpt(JsonKey.REQUEST_DURATION, Long.valueOf(this.requestDuration));     // Catch: JSONException -> L20
        r100.putOpt(JsonKey.BACK_WEB_URL, this.backWebUrl);     // Catch: JSONException -> L20
        if (getAuthInfo() == null) goto L11;
        r100.putOpt("app_name", AuthInfo.access$000(getAuthInfo()));     // Catch: JSONException -> L20
        r100.putOpt("version_name", AuthInfo.access$100(getAuthInfo()));     // Catch: JSONException -> L20
        r100.putOpt("developer_name", AuthInfo.access$400(getAuthInfo()));     // Catch: JSONException -> L20
    L11:
        if (getStatus() == null) goto L14;
        r100.putOpt("message", Status.access$1100(getStatus()));     // Catch: JSONException -> L20
    L14:
        if (TextUtils.isEmpty(this.hwAppId) == true) goto L17;
        r100.putOpt("hw_app_id", this.hwAppId);     // Catch: JSONException -> L20
    L17:
        if (TextUtils.isEmpty(this.marketDeepLink) == true) goto L22;
        r100.putOpt(JsonKey.MARKET_DEEP_LINK, this.marketDeepLink);     // Catch: JSONException -> L20
        goto L22
    L6:
        r101 = 0;
        goto L7
    }

    public ComplianceResult() {
        this.marketOnlineStatus = 15;
    }

    public String toString() {
        return toJson(this);
    }

    public int getAppstorePermit() {
        return this.appstorePermit;
    }

    public AuthInfo getAuthInfo() {
        return this.authInfo;
    }

    public String getBackWebUrl() {
        return this.backWebUrl;
    }

    public int getCode() {
        return this.code;
    }

    public int getDownloadPermit() {
        return this.downloadPermit;
    }

    public int getHijackPermit() {
        return this.hijackPermit;
    }

    public String getHijackUrl() {
        return this.hijackUrl;
    }

    public String getHwAppId() {
        return this.hwAppId;
    }

    public long getId() {
        return this.Id;
    }

    public String getMarketDeepLink() {
        return this.marketDeepLink;
    }

    public int getMarketOnlineStatus() {
        return this.marketOnlineStatus;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public long getRequestDuration() {
        return this.requestDuration;
    }

    public boolean getShowAuth() {
        return this.showAuth;
    }

    public Status getStatus() {
        return this.status;
    }

    public boolean isShowAuth() {
        return this.showAuth;
    }

    public static ComplianceResult fromJson(String r100) {
        ComplianceResult r101 = new ComplianceResult();
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L8
        AuthInfo r103 = getAuthInfo(r102);     // Catch: Exception -> L8
        Status r104 = getStatus(r102);     // Catch: Exception -> L8
        r101.setAuthInfo(r103);     // Catch: Exception -> L8
        r101.setStatus(r104);     // Catch: Exception -> L8
        boolean r105 = false;
        if (r102.optInt(JsonKey.SHOW_AUTH, 0) != 1) goto L6;
        r105 = true;
    L6:
        r101.setShowAuth(r105);     // Catch: Exception -> L8
        r101.setDownloadPermit(r102.optInt(JsonKey.DOWNLOAD_PERMIT));     // Catch: Exception -> L8
        r101.setAppstorePermit(r102.optInt("appstore_permit"));     // Catch: Exception -> L8
        r101.setMarketOnlineStatus(r102.optInt("market_online_status", 15));     // Catch: Exception -> L8
        r101.setHijackPermit(r102.optInt(JsonKey.HIJACK_PERMIT));     // Catch: Exception -> L8
        r101.setPackageName(r102.optString("package_name"));     // Catch: Exception -> L8
        r101.setHijackUrl(r102.optString(JsonKey.HIJACK_URL));     // Catch: Exception -> L8
        r101.setCode(r102.optInt("code"));     // Catch: Exception -> L8
        r101.setMessage(r102.optString("message"));     // Catch: Exception -> L8
        r101.setRequestDuration(r102.optLong(JsonKey.REQUEST_DURATION, 0));     // Catch: Exception -> L8
        r101.setBackWebUrl(r102.optString(JsonKey.BACK_WEB_URL));     // Catch: Exception -> L8
        r101.setHwAppId(r102.optString("hw_app_id"));     // Catch: Exception -> L8
        r101.setMarketDeepLink(r102.optString(JsonKey.MARKET_DEEP_LINK));     // Catch: Exception -> L8
    L10:
        return r101;
    L8:
        e = move-exception;
        TTDownloaderMonitor.inst().monitorException(e, "ComplianceResult fromJson");
        goto L10
    }

    private static JSONObject generateAuthInfoJson(AuthInfo r100) throws JSONException {
        JSONObject r101 = new JSONObject();
        if (r100 == null) goto L5;
        r101.putOpt("app_name", AuthInfo.access$000(r100));
        r101.putOpt("version_name", AuthInfo.access$100(r100));
        r101.putOpt("update_time", Long.valueOf(AuthInfo.access$200(r100)));
        r101.putOpt("size", Long.valueOf(AuthInfo.access$300(r100)));
        r101.putOpt("developer_name", AuthInfo.access$400(r100));
        r101.putOpt("policy_url", AuthInfo.access$500(r100));
        r101.putOpt("icon_url", AuthInfo.access$600(r100));
        r101.putOpt("download_url", AuthInfo.access$700(r100));
        r101.putOpt(JsonKey.PERMISSIONS, generatePermissionJsonArray(r100));
        r101.putOpt(JsonKey.PERMISSION_CLASSIFY_URL, AuthInfo.access$800(r100));
        r101.putOpt("desc_url", AuthInfo.access$900(r100));
    L5:
        return r101;
    }

    private static JSONArray generatePermissionJsonArray(AuthInfo r100) throws JSONException {
        JSONArray r101 = new JSONArray();
        List r102 = AuthInfo.access$1200(r100);
        if (r102 != null) goto L5;
    L10:
        return r101;
    L5:
        if (r102.size() <= 0) goto L10;
        Iterator r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        AuthInfo.Permissions r104 = (AuthInfo.Permissions) r103.next();
        JSONObject r105 = new JSONObject();
        r105.putOpt(JsonKey.PERMISSION_NAME, AuthInfo.Permissions.access$1300(r104));
        r105.putOpt(JsonKey.PERMISSION_DESC, AuthInfo.Permissions.access$1400(r104));
        r101.put(r105);
        goto L8
    }

    private static JSONObject generateStatus(Status r100) throws JSONException {
        JSONObject r101 = new JSONObject();
        if (r100 == null) goto L5;
        r101.putOpt("status", Integer.valueOf(Status.access$1000(r100)));
        r101.putOpt("message", Status.access$1100(r100));
    L5:
        return r101;
    }

    private static AuthInfo getAuthInfo(JSONObject r100) {
        AuthInfo r101 = new AuthInfo();
        JSONObject r102 = r100.optJSONObject(JsonKey.AUTH_INFO);     // Catch: Exception -> L10
        if (r102 == null) goto L12;
        r101.setAppName(r102.optString("app_name"));     // Catch: Exception -> L10
        r101.setVersionName(r102.optString("version_name"));     // Catch: Exception -> L10
        r101.setUpdateTime(ToolUtils.optLong(r102, "update_time"));     // Catch: Exception -> L10
        r101.setSize(ToolUtils.optLong(r102, "size"));     // Catch: Exception -> L10
        r101.setDeveloperName(r102.optString("developer_name"));     // Catch: Exception -> L10
        r101.setPackageName(r102.optString("package_name"));     // Catch: Exception -> L10
        r101.setRegUrl(r102.optString("reg_url"));     // Catch: Exception -> L10
        JSONArray r103 = r102.optJSONArray(JsonKey.PERMISSIONS);     // Catch: Exception -> L10
        if (r103 == null) goto L8;
        ArrayList r104 = new ArrayList();     // Catch: Exception -> L10
        parsePermissionJsonArray(r103, r104);     // Catch: Exception -> L10
        r101.setPermissions(r104);     // Catch: Exception -> L10
    L8:
        r101.setPermissionUrl(r102.optString(JsonKey.PERMISSION_CLASSIFY_URL));     // Catch: Exception -> L10
        r101.setPolicyUrl(r102.optString("policy_url"));     // Catch: Exception -> L10
        r101.setIconUrl(r102.optString("icon_url"));     // Catch: Exception -> L10
        r101.setDownloadUrl(r102.optString("download_url"));     // Catch: Exception -> L10
        r101.setDescUrl(r102.optString("desc_url"));     // Catch: Exception -> L10
    L12:
        return r101;
    L10:
        e = move-exception;
        TTDownloaderMonitor.inst().monitorException(e, "ComplianceResult getAuthInfo");
        goto L12
    }

    private static Status getStatus(JSONObject r100) {
        Status r101 = new Status();
        JSONObject r102 = r100.optJSONObject("status");     // Catch: Exception -> L7
        if (r102 == null) goto L9;
        r101.setStatus(r102.optInt("status"));     // Catch: Exception -> L7
        r101.setStatusMessage(r102.optString("message"));     // Catch: Exception -> L7
    L9:
        return r101;
    L7:
        e = move-exception;
        TTDownloaderMonitor.inst().monitorException(e, "ComplianceResult getStatus");
        goto L9
    }

    public static String toJson(ComplianceResult r100) {
        JSONObject r101 = new JSONObject();
    L9:
        e = move-exception;
        TTDownloaderMonitor.inst().monitorException(e, "ComplianceResult toJson");
    L12:
        return r101.toString();
    L4:
        if (r100.showAuth == false) goto L6;
        int r102 = 1;
    L7:
        r101.putOpt(JsonKey.SHOW_AUTH, Integer.valueOf(r102));     // Catch: JSONException -> L9
        r101.putOpt(JsonKey.DOWNLOAD_PERMIT, Integer.valueOf(r100.downloadPermit));     // Catch: JSONException -> L9
        r101.putOpt("appstore_permit", Integer.valueOf(r100.appstorePermit));     // Catch: JSONException -> L9
        r101.putOpt("market_online_status", Integer.valueOf(r100.marketOnlineStatus));     // Catch: JSONException -> L9
        r101.putOpt(JsonKey.HIJACK_PERMIT, Integer.valueOf(r100.hijackPermit));     // Catch: JSONException -> L9
        r101.putOpt("package_name", r100.packageName);     // Catch: JSONException -> L9
        r101.putOpt(JsonKey.HIJACK_URL, r100.hijackUrl);     // Catch: JSONException -> L9
        r101.putOpt("code", Integer.valueOf(r100.code));     // Catch: JSONException -> L9
        r101.putOpt("message", r100.message);     // Catch: JSONException -> L9
        r101.putOpt(JsonKey.REQUEST_DURATION, Long.valueOf(r100.requestDuration));     // Catch: JSONException -> L9
        r101.putOpt(JsonKey.AUTH_INFO, generateAuthInfoJson(r100.authInfo));     // Catch: JSONException -> L9
        r101.putOpt("status", generateStatus(r100.status));     // Catch: JSONException -> L9
        r101.putOpt(JsonKey.BACK_WEB_URL, r100.backWebUrl);     // Catch: JSONException -> L9
        r101.putOpt("hw_app_id", r100.hwAppId);     // Catch: JSONException -> L9
        r101.putOpt(JsonKey.MARKET_DEEP_LINK, r100.marketDeepLink);     // Catch: JSONException -> L9
        goto L12
    L6:
        r102 = 0;
        goto L7
    }

    public void setAppstorePermit(int r100) {
        this.appstorePermit = r100;
    }

    public void setAuthInfo(AuthInfo r100) {
        this.authInfo = r100;
    }

    public void setBackWebUrl(String r100) {
        this.backWebUrl = r100;
    }

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setDownloadPermit(int r100) {
        this.downloadPermit = r100;
    }

    public void setHijackPermit(int r100) {
        this.hijackPermit = r100;
    }

    public void setHijackUrl(String r100) {
        this.hijackUrl = r100;
    }

    public void setHwAppId(String r100) {
        this.hwAppId = r100;
    }

    public void setId(long r100) {
        this.Id = r100;
    }

    public void setMarketDeepLink(String r100) {
        this.marketDeepLink = r100;
    }

    public void setMarketOnlineStatus(int r100) {
        this.marketOnlineStatus = r100;
    }

    public void setMessage(String r100) {
        this.message = r100;
    }

    public void setPackageName(String r100) {
        this.packageName = r100;
    }

    public void setRequestDuration(long r100) {
        this.requestDuration = r100;
    }

    public void setShowAuth(boolean r100) {
        this.showAuth = r100;
    }

    public void setStatus(Status r100) {
        this.status = r100;
    }

    private static void parsePermissionJsonArray(JSONArray r100, List<AuthInfo.Permissions> r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L16;
        int r102 = 0;
    L7:
        if (r102 >= r100.length()) goto L17;
        JSONObject r103 = r100.optJSONObject(r102);
        if (r103 == null) goto L11;
        AuthInfo.Permissions r104 = new AuthInfo.Permissions();
        r104.setPermissionName(r103.optString(JsonKey.PERMISSION_NAME));
        r104.setPermissionDesc(r103.optString(JsonKey.PERMISSION_DESC));
        r101.add(r104);
    L11:
        r102 = r102 + 1;
        goto L7
    L17:
        return;
    L16:
        return;
    }
}

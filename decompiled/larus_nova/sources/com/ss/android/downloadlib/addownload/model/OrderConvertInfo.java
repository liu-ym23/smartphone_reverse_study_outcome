package com.ss.android.downloadlib.addownload.model;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class OrderConvertInfo {
    private String adId;
    private String appId;
    private String appVersion;
    private long cid;
    private String deviceId;
    private String logExtra;

    /* JADX INFO: renamed from: os, reason: collision with root package name */
    private String f408297os;
    private String pageType;
    private String pageUrl;
    private String reqId;
    private String siteId;
    private String ttBridge;
    private String ttEnv;
    private String uid;
    private String userId;

    /* JADX INFO: renamed from: ut, reason: collision with root package name */
    private String f408298ut;
    private long value;
    private String versionCode;

    public static final class Builder {
        OrderConvertInfo convertInfo;

        public Builder() {
            this.convertInfo = new OrderConvertInfo();
        }

        public OrderConvertInfo build() {
            return this.convertInfo;
        }

        public Builder setAdId(String r100) {
            OrderConvertInfo.access$402(this.convertInfo, r100);
            return this;
        }

        public Builder setAppId(String r100) {
            OrderConvertInfo.access$1102(this.convertInfo, r100);
            return this;
        }

        public Builder setAppVersion(String r100) {
            OrderConvertInfo.access$902(this.convertInfo, r100);
            return this;
        }

        public Builder setCid(long r100) {
            OrderConvertInfo.access$302(this.convertInfo, r100);
            return this;
        }

        public Builder setDeviceId(String r100) {
            OrderConvertInfo.access$502(this.convertInfo, r100);
            return this;
        }

        public Builder setLogExtra(String r100) {
            OrderConvertInfo.access$102(this.convertInfo, r100);
            return this;
        }

        public Builder setOs(String r100) {
            OrderConvertInfo.access$1202(this.convertInfo, r100);
            return this;
        }

        public Builder setPageType(String r100) {
            OrderConvertInfo.access$1402(this.convertInfo, r100);
            return this;
        }

        public Builder setPageUrl(String r100) {
            OrderConvertInfo.access$1302(this.convertInfo, r100);
            return this;
        }

        public Builder setReqId(String r100) {
            OrderConvertInfo.access$202(this.convertInfo, r100);
            return this;
        }

        public Builder setSiteId(String r100) {
            OrderConvertInfo.access$1502(this.convertInfo, r100);
            return this;
        }

        public Builder setTtBridge(String r100) {
            OrderConvertInfo.access$1602(this.convertInfo, r100);
            return this;
        }

        public Builder setTtEnv(String r100) {
            OrderConvertInfo.access$1702(this.convertInfo, r100);
            return this;
        }

        public Builder setUid(String r100) {
            OrderConvertInfo.access$702(this.convertInfo, r100);
            return this;
        }

        public Builder setUserId(String r100) {
            OrderConvertInfo.access$602(this.convertInfo, r100);
            return this;
        }

        public Builder setUt(String r100) {
            OrderConvertInfo.access$802(this.convertInfo, r100);
            return this;
        }

        public Builder setValue(long r100) {
            OrderConvertInfo.access$002(this.convertInfo, r100);
            return this;
        }

        public Builder setVersionCode(String r100) {
            OrderConvertInfo.access$1002(this.convertInfo, r100);
            return this;
        }
    }

    public OrderConvertInfo() {
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("value", this.value);     // Catch: JSONException -> L5
        r100.put("log_extra", this.logExtra);     // Catch: JSONException -> L5
        r100.put("req_id", this.reqId);     // Catch: JSONException -> L5
        r100.put("cid", this.cid);     // Catch: JSONException -> L5
        r100.put("ad_id", this.adId);     // Catch: JSONException -> L5
        r100.put("device_id", this.deviceId);     // Catch: JSONException -> L5
        r100.put("user_id", this.userId);     // Catch: JSONException -> L5
        r100.put("uid", this.uid);     // Catch: JSONException -> L5
        r100.put("ut", this.f408298ut);     // Catch: JSONException -> L5
        r100.put("app_version", this.appVersion);     // Catch: JSONException -> L5
        r100.put("version_code", this.versionCode);     // Catch: JSONException -> L5
        r100.put("app_id", this.appId);     // Catch: JSONException -> L5
        r100.put("os", this.f408297os);     // Catch: JSONException -> L5
        r100.put("page_url", this.pageUrl);     // Catch: JSONException -> L5
        r100.put("page_type", this.pageType);     // Catch: JSONException -> L5
        r100.put("site_id", this.siteId);     // Catch: JSONException -> L5
        r100.put("tt_bridge", this.ttBridge);     // Catch: JSONException -> L5
        r100.put("tt_env", this.ttEnv);     // Catch: JSONException -> L5
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        return new JSONObject();
    }

    public String toString() {
        return toJson().toString();
    }

    public long getCid() {
        return this.cid;
    }

    public static /* synthetic */ long access$002(OrderConvertInfo r100, long r101) {
        r100.value = r101;
        return r101;
    }

    public static /* synthetic */ String access$1002(OrderConvertInfo r100, String r101) {
        r100.versionCode = r101;
        return r101;
    }

    public static /* synthetic */ String access$102(OrderConvertInfo r100, String r101) {
        r100.logExtra = r101;
        return r101;
    }

    public static /* synthetic */ String access$1102(OrderConvertInfo r100, String r101) {
        r100.appId = r101;
        return r101;
    }

    public static /* synthetic */ String access$1202(OrderConvertInfo r100, String r101) {
        r100.f408297os = r101;
        return r101;
    }

    public static /* synthetic */ String access$1302(OrderConvertInfo r100, String r101) {
        r100.pageUrl = r101;
        return r101;
    }

    public static /* synthetic */ String access$1402(OrderConvertInfo r100, String r101) {
        r100.pageType = r101;
        return r101;
    }

    public static /* synthetic */ String access$1502(OrderConvertInfo r100, String r101) {
        r100.siteId = r101;
        return r101;
    }

    public static /* synthetic */ String access$1602(OrderConvertInfo r100, String r101) {
        r100.ttBridge = r101;
        return r101;
    }

    public static /* synthetic */ String access$1702(OrderConvertInfo r100, String r101) {
        r100.ttEnv = r101;
        return r101;
    }

    public static /* synthetic */ String access$202(OrderConvertInfo r100, String r101) {
        r100.reqId = r101;
        return r101;
    }

    public static /* synthetic */ long access$302(OrderConvertInfo r100, long r101) {
        r100.cid = r101;
        return r101;
    }

    public static /* synthetic */ String access$402(OrderConvertInfo r100, String r101) {
        r100.adId = r101;
        return r101;
    }

    public static /* synthetic */ String access$502(OrderConvertInfo r100, String r101) {
        r100.deviceId = r101;
        return r101;
    }

    public static /* synthetic */ String access$602(OrderConvertInfo r100, String r101) {
        r100.userId = r101;
        return r101;
    }

    public static /* synthetic */ String access$702(OrderConvertInfo r100, String r101) {
        r100.uid = r101;
        return r101;
    }

    public static /* synthetic */ String access$802(OrderConvertInfo r100, String r101) {
        r100.f408298ut = r101;
        return r101;
    }

    public static /* synthetic */ String access$902(OrderConvertInfo r100, String r101) {
        r100.appVersion = r101;
        return r101;
    }
}

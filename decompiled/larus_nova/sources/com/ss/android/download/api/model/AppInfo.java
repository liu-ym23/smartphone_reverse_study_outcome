package com.ss.android.download.api.model;

/* JADX INFO: loaded from: classes34.dex */
public class AppInfo {
    private String appId;
    private String appName;
    private String appVersion;
    private String channel;
    private String deviceId;
    private boolean hasBoundPhone;
    private String secUid;
    private String uniqueId;
    private String userId;
    private String versionCode;

    public static class Builder {
        private String mAppId;
        private String mAppName;
        private String mAppVersion;
        private String mChannel;
        private String mDeviceId;
        private boolean mHasBoundPhone;
        private String mSecUid;
        private String mUniqueId;
        private String mUserId;
        private String mVersionCode;

        public Builder() {
        }

        public AppInfo build() {
            return new AppInfo(this);
        }

        public static /* synthetic */ String access$000(Builder r100) {
            return r100.mAppName;
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.mAppId;
        }

        public static /* synthetic */ String access$200(Builder r100) {
            return r100.mChannel;
        }

        public static /* synthetic */ String access$300(Builder r100) {
            return r100.mAppVersion;
        }

        public static /* synthetic */ String access$400(Builder r100) {
            return r100.mVersionCode;
        }

        public static /* synthetic */ String access$500(Builder r100) {
            return r100.mDeviceId;
        }

        public static /* synthetic */ String access$600(Builder r100) {
            return r100.mUserId;
        }

        public static /* synthetic */ String access$700(Builder r100) {
            return r100.mUniqueId;
        }

        public static /* synthetic */ boolean access$800(Builder r100) {
            return r100.mHasBoundPhone;
        }

        public static /* synthetic */ String access$900(Builder r100) {
            return r100.mSecUid;
        }

        public Builder appId(String r100) {
            this.mAppId = r100;
            return this;
        }

        public Builder appName(String r100) {
            this.mAppName = r100;
            return this;
        }

        public Builder appVersion(String r100) {
            this.mAppVersion = r100;
            return this;
        }

        public Builder channel(String r100) {
            this.mChannel = r100;
            return this;
        }

        public Builder deviceId(String r100) {
            this.mDeviceId = r100;
            return this;
        }

        public Builder hasBoundPhone(boolean r100) {
            this.mHasBoundPhone = r100;
            return this;
        }

        public Builder secUid(String r100) {
            this.mSecUid = r100;
            return this;
        }

        public Builder uniqueId(String r100) {
            this.mUniqueId = r100;
            return this;
        }

        public Builder userId(String r100) {
            this.mUserId = r100;
            return this;
        }

        public Builder versionCode(String r100) {
            this.mVersionCode = r100;
            return this;
        }
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getSecUid() {
        return this.secUid;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public boolean hasBoundPhone() {
        return this.hasBoundPhone;
    }

    public AppInfo(Builder r100) {
        this.appId = "";
        this.appName = Builder.access$000(r100);
        this.appId = Builder.access$100(r100);
        this.channel = Builder.access$200(r100);
        this.appVersion = Builder.access$300(r100);
        this.versionCode = Builder.access$400(r100);
        this.deviceId = Builder.access$500(r100);
        this.userId = Builder.access$600(r100);
        this.uniqueId = Builder.access$700(r100);
        this.hasBoundPhone = Builder.access$800(r100);
        this.secUid = Builder.access$900(r100);
    }

    public void setAppId(String r100) {
        this.appId = r100;
    }

    public void setAppName(String r100) {
        this.appName = r100;
    }

    public void setAppVersion(String r100) {
        this.appVersion = r100;
    }

    public void setChannel(String r100) {
        this.channel = r100;
    }

    public void setDeviceId(String r100) {
        this.deviceId = r100;
    }

    public void setHasBoundPhone(boolean r100) {
        this.hasBoundPhone = r100;
    }

    public void setSecUid(String r100) {
        this.secUid = r100;
    }

    public void setUniqueId(String r100) {
        this.uniqueId = r100;
    }

    public void setUserId(String r100) {
        this.userId = r100;
    }

    public void setVersionCode(String r100) {
        this.versionCode = r100;
    }
}

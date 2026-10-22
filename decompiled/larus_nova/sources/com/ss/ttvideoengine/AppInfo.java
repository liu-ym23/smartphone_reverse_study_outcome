package com.ss.ttvideoengine;

/* JADX INFO: loaded from: classes34.dex */
public class AppInfo extends BaseAppInfo {
    public static final String APP_REGION_CN = "cn-north-1";
    public static final String APP_REGION_SINGAPORE = "singapore";

    public static String getDefaultVodTopHost() {
        throw new UnsupportedOperationException("tob only");
    }

    public static String getDefaultVodTopHostV2() {
        throw new UnsupportedOperationException("tob only");
    }

    public static String getDeviceId() {
        if (BaseAppInfo.mDeviceId != null) goto L6;
        BaseAppInfo.mDeviceId = "";
    L6:
        return BaseAppInfo.mDeviceId;
    }

    public static String getSmartUrlApiHost() {
        throw new UnsupportedOperationException("tob only");
    }

    public AppInfo() {
    }
}

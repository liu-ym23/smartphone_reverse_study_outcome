package com.bytedance.map.api;

/* JADX INFO: loaded from: classes21.dex */
public class MapGlobalConfig {
    private static int mProtocol = 1;
    private static String sAppId = "";
    private static String sAppVersion = "";
    private static String sChannel = "";
    private static String sDeviceId = "";
    private static boolean sIsContainsPrivacy = true;
    private static boolean sIsPrivacyConfirmed = true;
    private static boolean sIsShowPrivacy = true;
    private static String sPackageName = "";
    private static String sUpdateVersion = "";

    public MapGlobalConfig() {
    }

    public static String getAppId() {
        return sAppId;
    }

    public static String getAppVersion() {
        return sAppVersion;
    }

    public static String getChannel() {
        return sChannel;
    }

    public static String getDeviceId() {
        return sDeviceId;
    }

    public static String getPackageName() {
        return sPackageName;
    }

    public static int getProtocol() {
        return mProtocol;
    }

    public static String getUpdateVersion() {
        return sUpdateVersion;
    }

    public static boolean isContainsPrivacy() {
        return sIsContainsPrivacy;
    }

    public static boolean isIsShowPrivacy() {
        return sIsShowPrivacy;
    }

    public static boolean isPrivacyConfirmed() {
        return sIsPrivacyConfirmed;
    }

    public static void setAppId(String r100) {
        sAppId = r100;
    }

    public static void setAppVersion(String r100) {
        sAppVersion = r100;
    }

    public static void setChannel(String r100) {
        sChannel = r100;
    }

    public static void setContainsPrivacy(boolean r100) {
        sIsContainsPrivacy = r100;
    }

    public static void setDeviceId(String r100) {
        sDeviceId = r100;
    }

    public static void setIsShowPrivacy(boolean r100) {
        sIsShowPrivacy = r100;
    }

    public static void setPackageName(String r100) {
        sPackageName = r100;
    }

    public static void setPrivacyConfirmed(boolean r100) {
        sIsPrivacyConfirmed = r100;
    }

    public static void setProtocol(int r100) {
        mProtocol = r100;
    }

    public static void setUpdateVersion(String r100) {
        sUpdateVersion = r100;
    }
}

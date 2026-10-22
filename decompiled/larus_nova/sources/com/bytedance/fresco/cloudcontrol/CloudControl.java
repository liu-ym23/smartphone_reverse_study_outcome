package com.bytedance.fresco.cloudcontrol;

import android.os.Build;
import java.util.LinkedHashMap;
import java.util.Random;

/* JADX INFO: loaded from: classes19.dex */
public final class CloudControl {
    private static final String PULL_CLOUD_CONFIG = "/app/monitor/settings";
    private static final String PULL_CLOUD_URL_BOE = "https://imagex-settings-boe.byted.org";
    private static final String PULL_CLOUD_URL_CN_NORTH = "https://imagex-settings.bytedanceapi.com";
    private static final String PULL_CLOUD_URL_SINGAPORE = "https://imagex-settings-sg.bytevcloudapi.com";
    private static final String PULL_CLOUD_URL_US_EAST = "https://imagex-settings-va.bytevcloudapi.com";
    private static final String TAG = "CloudControl";
    private static volatile CloudControl sSingleCloudControl;
    private InitConfig initConfig;
    private final CloudControlCache mControlCache;

    private String parseUriConfig(int r100) {
        if (r100 != 2) goto L7;
        return PULL_CLOUD_URL_SINGAPORE;
    L7:
        if (r100 != 3) goto L11;
        return PULL_CLOUD_URL_US_EAST;
    L11:
        if (r100 != 1) goto L15;
        return PULL_CLOUD_URL_CN_NORTH;
    L15:
        if (r100 != 4) goto L18;
        return PULL_CLOUD_URL_BOE;
    L18:
        return null;
    }

    public static boolean canUploadImageMonitorErrorV2ForSampling() {
        if (Float.compare(checkNotNull(sSingleCloudControl).mControlCache.getImageMonitorErrorV2(), new Random().nextFloat()) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean canUploadImageMonitorV2ForSampling() {
        if (Float.compare(checkNotNull(sSingleCloudControl).mControlCache.getImageMonitorV2(), new Random().nextFloat()) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static String[] getAnimatedAdaptivePolicy() {
        String r100 = checkNotNull(sSingleCloudControl).mControlCache.getAnimatedAdaptivePolicy();
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return null;
    L7:
        return r100.split(",");
    }

    public static String getCloudControlConfig() {
        return checkNotNull(sSingleCloudControl).mControlCache.getCloudControlConfig();
    }

    public static boolean getDecodeHeicUseSystemApiFirst() {
        if (checkNotNull(sSingleCloudControl).mControlCache.isDecodeHeicUseSystemApiFirst() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static String getHttpdnsAuthId() {
        return checkNotNull(sSingleCloudControl).mControlCache.getHttpdnsAuthId();
    }

    public static String getHttpdnsAuthKey() {
        return checkNotNull(sSingleCloudControl).mControlCache.getHttpdnsAuthKey();
    }

    public static InitConfig getInitConfig() {
        return checkNotNull(sSingleCloudControl).initConfig;
    }

    public static String[] getStaticAdaptivePolicy() {
        String r100 = checkNotNull(sSingleCloudControl).mControlCache.getStaticAdaptivePolicy();
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return null;
    L7:
        return r100.split(",");
    }

    public static String getTTNetConfig() {
        return checkNotNull(sSingleCloudControl).mControlCache.getTTNetConfig();
    }

    public static boolean isHeifEnabled() {
        if (checkNotNull(sSingleCloudControl).mControlCache.isEnableHeif() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isHttp2Enabled() {
        return checkNotNull(sSingleCloudControl).mControlCache.isEnableHttp2();
    }

    public static boolean isHttpDnsEnabled() {
        return checkNotNull(sSingleCloudControl).mControlCache.isEnableHttpdns();
    }

    public static boolean isSrEnabled() {
        if (checkNotNull(sSingleCloudControl).mControlCache.isEnableSr() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static String getExpectImageFormat() {
        return ImageFormatUtils.getExpectImageFormat();
    }

    private CloudControl(InitConfig r100) {
        CloudControlCache r101 = new CloudControlCache(r100.getContext());
        this.mControlCache = r101;
        this.initConfig = r100;
        if (canPullImageMonitorSettings(r101) == false) goto L6;
        pullCloudConfig(r100.getAid(), "android", r100.getVersionName(), r100.getUriConfig(), "1.41.6", Build.VERSION.SDK);
        return;
    }

    public static /* synthetic */ CloudControlCache access$000(CloudControl r100) {
        return r100.mControlCache;
    }

    private boolean canPullImageMonitorSettings(CloudControlCache r100) {
        int r101 = r100.getFetchSettingInterval();
        if ((System.currentTimeMillis() - r100.getLastFetchSettingTimeStamp()) <= (r101 * 1000)) goto L5;
        return true;
    L5:
        return false;
    }

    private static CloudControl checkNotNull(CloudControl r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new IllegalStateException("CloudControl must be initiated first");
    }

    public static void init(InitConfig r100) {
        sSingleCloudControl = new CloudControl(r100);
    }

    private void pullCloudConfig(String r100, String r101, String r102, int r103, String r104, String r105) {
        NetworkFetcher r106 = new NetworkFetcher();
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("os", r101);
        r107.put("app_version", r102);
        r107.put("sdk_version", r104);
        r107.put("aid", r100);
        r107.put("os_version", r105);
        r106.fetch(parseUriConfig(r103) + PULL_CLOUD_CONFIG, new AnonymousClass1(this), r107);
    }
}

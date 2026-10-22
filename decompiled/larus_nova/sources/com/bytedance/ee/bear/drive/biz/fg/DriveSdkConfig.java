package com.bytedance.ee.bear.drive.biz.fg;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
@AppConfig(key = DriveSdkConfig.DRIVE_SDK_CONFIG_KEY)
public class DriveSdkConfig implements NonProguard {
    private static final String DRIVE_SDK_CONFIG_KEY = "drive_sdk_config";
    private static final String TAG = "DriveSdk_DriveSdkConfig";
    private static volatile DriveSdkConfig sDriveSdkConfig;
    private volatile Map<String, Map<String, ArrayList<Integer>>> previewTranfroms;

    public static DriveSdkConfig getConfig() {
        if (sDriveSdkConfig != null) goto L15;
        monitor-enter(DriveSdkConfig.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sDriveSdkConfig != null) goto L9;
        sDriveSdkConfig = (DriveSdkConfig) c.a.f206237a.c(DRIVE_SDK_CONFIG_KEY, DriveSdkConfig.class, new DriveSdkConfig());     // Catch: Throwable -> L11
        a.h(TAG, "init DriveSdkConfig=" + sDriveSdkConfig);     // Catch: Throwable -> L11
    L9:
        monitor-exit(DriveSdkConfig.class);     // Catch: Throwable -> L11
    L15:
        return sDriveSdkConfig;
    }

    public Map<String, Map<String, ArrayList<Integer>>> getPreviewTranfroms() {
        if (this.previewTranfroms != null) goto L7;
        a.d(TAG, "getPreviewTranfromsInApp() getPreviewTranfroms null return empty map");
        return new HashMap();
    L7:
        return this.previewTranfroms;
    }

    public String toString() {
        return "DriveSdkConfig{previewTranfroms=" + this.previewTranfroms + '}';
    }

    public boolean isPreviewTransformDisabled() {
        return FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.mobile.drive.wps_downgrade_disable");
    }

    private DriveSdkConfig() {
    }

    public Map<String, ArrayList<Integer>> getPreviewTranfromsInApp(String r100) {
        Map<String, ArrayList<Integer>> r101 = getPreviewTranfroms().get(r100);
        if (r101 != null) goto L6;
        a.d(TAG, "getPreviewTranfromsInApp() get appid tranfoems null return empty map");
        return new HashMap();
    L6:
        return r101;
    }

    public void setPreviewTranfroms(Map<String, Map<String, ArrayList<Integer>>> r100) {
        this.previewTranfroms = r100;
    }
}

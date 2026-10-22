package com.ss.android.cert.manager;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.ss.android.cert.manager.ablity.ICertDialogDepend;
import com.ss.android.cert.manager.ablity.SettingsDelegate;
import com.ss.android.cert.manager.ablity.service.ICertRouterService;
import com.ss.android.cert.manager.ablity.service.animation.ICertAnimationService;
import com.ss.android.cert.manager.ablity.service.asr.IASRService;
import com.ss.android.cert.manager.web.anniex.IAnnieXFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public class BytedCertSdkInitParam {
    private ICertAnimationService animationService;
    private IAnnieXDepend annieXDepend;
    private IASRService asrService;
    private ICertDialogDepend certDialogDepend;
    private CnNetAuthParams cnNetAuthParams;
    private boolean enableReportQualityInfo;
    private List<FaceDetectCycleConfig> faceDetectCycleConfigs;
    private int infoDetectFrameBuff;
    private boolean isLocalTest;
    private boolean isScreenRecordDetect;
    private NfcParams nfcParams;
    private boolean optPermissionRequest;
    private PermissionParam permissionParam;
    private PluginParams pluginParams;
    private List<String> recordUploadFailVideoScenes;
    private boolean reportBadgerEnable;
    private long reportBadgerInterval;
    private boolean reportDepthCameraInfo;
    private int reportTimeout;
    private ICertRouterService routerService;
    private SettingsDelegate settingsDelegate;
    private boolean upgradeV3;
    private String webContainerType;
    private boolean withoutFaceDetect;

    /* JADX INFO: loaded from: classes34.dex */
    public static class CnNetAuthParams {
        private final String appId;
        private final String orgID;

        public String getAppId() {
            return this.appId;
        }

        public String getOrgID() {
            return this.orgID;
        }

        public CnNetAuthParams(String r100, String r101) {
            this.orgID = r100;
            this.appId = r101;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static class FaceDetectCycleConfig {
        private final int baseDpi;
        private final float offsetYScale;
        private final float radiusScale;

        public int getBaseDpi() {
            return this.baseDpi;
        }

        public float getOffsetYScale() {
            return this.offsetYScale;
        }

        public float getRadiusScale() {
            return this.radiusScale;
        }

        public FaceDetectCycleConfig(int r100, float r101, float r102) {
            this.baseDpi = r100;
            this.radiusScale = r101;
            this.offsetYScale = r102;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public interface IAnnieXDepend {
        IAnnieXFragment createFragment(Activity r100, Bundle r101);
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static class NfcParams {
        private final String appId;

        public String getAppId() {
            return this.appId;
        }

        public NfcParams(String r100) {
            this.appId = r100;
        }
    }

    public static class PermissionParam {
        private final Map<String, String> defaultUsageMap;
        private final Map<String, Map<String, String>> localizationUsageMap;
        private final boolean showMask;

        public Map<String, String> getDefaultUsageMap() {
            return this.defaultUsageMap;
        }

        public Map<String, Map<String, String>> getLocalizationUsageMap() {
            return this.localizationUsageMap;
        }

        public boolean isShowMask() {
            return this.showMask;
        }

        public boolean canShowMask(String r100) {
            if (this.showMask == true) goto L5;
            return false;
        L5:
            if (TextUtils.isEmpty(r100) == true) goto L11;
            Map<String, Map<String, String>> r101 = this.localizationUsageMap;
            if (r101 == null) goto L11;
            if (r101.containsKey(r100) == false) goto L11;
            return true;
        L11:
            Map<String, String> r102 = this.defaultUsageMap;
            if (r102 != null) goto L14;
            return false;
        L14:
            if (r102.isEmpty() == true) goto L19;
            return true;
        L19:
            return false;
        }

        public PermissionParam(boolean r100, Map<String, String> r101) {
            this.showMask = r100;
            this.defaultUsageMap = r101;
            this.localizationUsageMap = null;
        }

        public PermissionParam(boolean r100, Map<String, String> r101, Map<String, Map<String, String>> r102) {
            this.showMask = r100;
            this.defaultUsageMap = r101;
            this.localizationUsageMap = r102;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static abstract class PluginParams {

        public interface PluginPreloadCallback {
            void onFinish(PluginType r100, Status r101, String r102);
        }

        public static final enum PluginType extends Enum<PluginType> {
            private static final /* synthetic */ PluginType[] $VALUES = null;
            public static final PluginType ALIYUN = null;
            public static final PluginType CERT = null;

            static {
                PluginType r100 = new PluginType("CERT", 0);
                CERT = r100;
                PluginType r101 = new PluginType("ALIYUN", 1);
                ALIYUN = r101;
                $VALUES = new PluginType[]{r100, r101};
            }

            public static PluginType[] values() {
                return (PluginType[]) $VALUES.clone();
            }

            public static PluginType valueOf(String r100) {
                return (PluginType) a.a(PluginType.class, r100);
            }

            private PluginType(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final enum Status extends Enum<Status> {
            private static final /* synthetic */ Status[] $VALUES = null;
            public static final Status CANCEL = null;
            public static final Status FAIL = null;
            public static final Status SUCCESS = null;

            static {
                Status r100 = new Status("SUCCESS", 0);
                SUCCESS = r100;
                Status r101 = new Status("FAIL", 1);
                FAIL = r101;
                Status r102 = new Status("CANCEL", 2);
                CANCEL = r102;
                $VALUES = new Status[]{r100, r101, r102};
            }

            public static Status[] values() {
                return (Status[]) $VALUES.clone();
            }

            public static Status valueOf(String r100) {
                return (Status) a.a(Status.class, r100);
            }

            private Status(String r100, int r101) {
                super(r100, r101);
            }
        }

        public PluginParams() {
        }

        public abstract boolean isPluginLoaded(PluginType r100);

        public abstract void tryPreloadPlugin(Map<String, String> r100, PluginType r101, PluginPreloadCallback r102);
    }

    public BytedCertSdkInitParam() {
        this.enableReportQualityInfo = true;
    }

    public ICertAnimationService getAnimationService() {
        return this.animationService;
    }

    public IAnnieXDepend getAnnieXDepend() {
        return this.annieXDepend;
    }

    public IASRService getAsrService() {
        return this.asrService;
    }

    public ICertDialogDepend getCertDialogDepend() {
        return this.certDialogDepend;
    }

    public CnNetAuthParams getCnNetAuthParams() {
        return this.cnNetAuthParams;
    }

    public List<FaceDetectCycleConfig> getFaceDetectCycleConfig() {
        return this.faceDetectCycleConfigs;
    }

    public int getInfoDetectFrameBuff() {
        return this.infoDetectFrameBuff;
    }

    public NfcParams getNfcParams() {
        return this.nfcParams;
    }

    public PermissionParam getPermissionParam() {
        return this.permissionParam;
    }

    public PluginParams getPluginParams() {
        return this.pluginParams;
    }

    public long getReportBadgerInterval() {
        return this.reportBadgerInterval;
    }

    public int getReportTimeout() {
        return this.reportTimeout;
    }

    public ICertRouterService getRouterService() {
        return this.routerService;
    }

    public SettingsDelegate getSettingsDelegate() {
        return this.settingsDelegate;
    }

    public String getWebContainerType() {
        return this.webContainerType;
    }

    public boolean isLocalTest() {
        return this.isLocalTest;
    }

    public boolean isOptPermissionRequest() {
        return this.optPermissionRequest;
    }

    public boolean isReportBadgerEnable() {
        return this.reportBadgerEnable;
    }

    public boolean isReportDepthCameraInfo() {
        return this.reportDepthCameraInfo;
    }

    public boolean isReportQualityInfo() {
        return this.enableReportQualityInfo;
    }

    public boolean isScreenRecordDetect() {
        return this.isScreenRecordDetect;
    }

    public boolean isUpgradeV3() {
        return this.upgradeV3;
    }

    public boolean isWithoutFaceDetect() {
        return this.withoutFaceDetect;
    }

    public boolean isRecordUploadFailVideo(String r100) {
        List<String> r101 = this.recordUploadFailVideoScenes;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.isEmpty() == false) goto L8;
        return false;
    L8:
        return this.recordUploadFailVideoScenes.contains(r100);
    }

    public BytedCertSdkInitParam setAnimationService(ICertAnimationService r100) {
        this.animationService = r100;
        return this;
    }

    public BytedCertSdkInitParam setAnnieXDepend(IAnnieXDepend r100) {
        this.annieXDepend = r100;
        return this;
    }

    public BytedCertSdkInitParam setAsrService(IASRService r100) {
        this.asrService = r100;
        return this;
    }

    public BytedCertSdkInitParam setCertDialogDepend(ICertDialogDepend r100) {
        this.certDialogDepend = r100;
        return this;
    }

    public BytedCertSdkInitParam setCnNetAuthParams(CnNetAuthParams r100) {
        this.cnNetAuthParams = r100;
        return this;
    }

    public BytedCertSdkInitParam setEnableReportQualityInfo(boolean r100) {
        this.enableReportQualityInfo = r100;
        return this;
    }

    public BytedCertSdkInitParam setFaceDetectCycleConfig(FaceDetectCycleConfig... r100) {
        if (this.faceDetectCycleConfigs != null) goto L5;
        this.faceDetectCycleConfigs = new ArrayList();
    L5:
        if (r100 == null) goto L12;
        int r101 = r100.length;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L12;
        FaceDetectCycleConfig r103 = r100[r102];
        if (r103 == null) goto L11;
        this.faceDetectCycleConfigs.add(r103);
    L11:
        r102 = r102 + 1;
    L12:
        return this;
    }

    public BytedCertSdkInitParam setInfoDetectFrameBuff(int r100) {
        this.infoDetectFrameBuff = r100;
        return this;
    }

    public BytedCertSdkInitParam setLocalTest(boolean r100) {
        this.isLocalTest = r100;
        return this;
    }

    public BytedCertSdkInitParam setNfcParams(NfcParams r100) {
        this.nfcParams = r100;
        return this;
    }

    public BytedCertSdkInitParam setOptPermissionRequest(boolean r100) {
        this.optPermissionRequest = r100;
        return this;
    }

    public BytedCertSdkInitParam setPermissionParam(PermissionParam r100) {
        this.permissionParam = r100;
        return this;
    }

    public BytedCertSdkInitParam setPluginParams(PluginParams r100) {
        this.pluginParams = r100;
        return this;
    }

    public BytedCertSdkInitParam setRecordUploadFailVideo(List<String> r100) {
        this.recordUploadFailVideoScenes = r100;
        return this;
    }

    public BytedCertSdkInitParam setReportBadgerEnable(boolean r100) {
        this.reportBadgerEnable = r100;
        return this;
    }

    public BytedCertSdkInitParam setReportBadgerInterval(long r100) {
        this.reportBadgerInterval = r100;
        return this;
    }

    public BytedCertSdkInitParam setReportDepthCameraInfo(boolean r100) {
        this.reportDepthCameraInfo = r100;
        return this;
    }

    public BytedCertSdkInitParam setReportTimeout(int r100) {
        this.reportTimeout = r100;
        return this;
    }

    public BytedCertSdkInitParam setRouterService(ICertRouterService r100) {
        this.routerService = r100;
        return this;
    }

    public BytedCertSdkInitParam setScreenRecordDetect(boolean r100) {
        this.isScreenRecordDetect = r100;
        return this;
    }

    public BytedCertSdkInitParam setSettingsDelegate(SettingsDelegate r100) {
        this.settingsDelegate = r100;
        return this;
    }

    public BytedCertSdkInitParam setUpgradeV3(boolean r100) {
        this.upgradeV3 = r100;
        return this;
    }

    public BytedCertSdkInitParam setWebContainerType(String r100) {
        this.webContainerType = r100;
        return this;
    }

    public BytedCertSdkInitParam setWithoutFaceDetect(boolean r100) {
        this.withoutFaceDetect = r100;
        return this;
    }

    public BytedCertSdkInitParam setFaceDetectCycleConfig(List<FaceDetectCycleConfig> r100) {
        this.faceDetectCycleConfigs = r100;
        return this;
    }
}

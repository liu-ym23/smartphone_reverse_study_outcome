package com.ss.android.cert.manager;

import com.ss.android.cert.manager.ablity.ICertDialogDepend;
import com.ss.android.cert.manager.ablity.SettingsDelegate;
import com.ss.android.cert.manager.ablity.service.CertServiceManager;
import com.ss.android.cert.manager.ablity.service.ICertRouterService;
import com.ss.android.cert.manager.ablity.service.animation.ICertAnimationService;
import com.ss.android.cert.manager.ablity.service.asr.IASRService;
import dta.b;
import dta.c;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class BytedCertSdkManager {
    private static BytedCertSdkManager instance;
    private BytedCertSdkInitParam initParam;

    public BytedCertSdkManager() {
    }

    public static /* synthetic */ Object a(String r100) {
        return lambda$getSettingsDelegate$0(r100);
    }

    public static /* synthetic */ Object b(String r100) {
        return lambda$getSettingsDelegate$1(r100);
    }

    private static /* synthetic */ Object lambda$getSettingsDelegate$0(String r100) {
        return null;
    }

    private static /* synthetic */ Object lambda$getSettingsDelegate$1(String r100) {
        return null;
    }

    public static BytedCertSdkManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(BytedCertSdkManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new BytedCertSdkManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BytedCertSdkManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public BytedCertSdkInitParam.IAnnieXDepend getAnnieXDepend() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAnnieXDepend();
    }

    public ICertDialogDepend getCertDialogDepend() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCertDialogDepend();
    }

    public BytedCertSdkInitParam.CnNetAuthParams getCnNetAuthParams() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCnNetAuthParams();
    }

    public List<BytedCertSdkInitParam.FaceDetectCycleConfig> getFaceDetectCycleConfig() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getFaceDetectCycleConfig();
    }

    public int getInfoDetectFrameBuff() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return 10;
    L7:
        return r100.getInfoDetectFrameBuff();
    }

    public BytedCertSdkInitParam.NfcParams getNfcParams() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getNfcParams();
    }

    public BytedCertSdkInitParam.PermissionParam getPermissionParam() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPermissionParam();
    }

    public BytedCertSdkInitParam.PluginParams getPluginParams() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPluginParams();
    }

    public long getReportBadgerInterval() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getReportBadgerInterval();
    }

    public int getReportTimeout() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getReportTimeout();
    }

    public SettingsDelegate getSettingsDelegate() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 == null) goto L5;
        SettingsDelegate r101 = r100.getSettingsDelegate();
        if (r101 == null) goto L9;
        return r101;
    L9:
        return new c();
    L5:
        return new b();
    }

    public String getWebContainerType() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getWebContainerType();
    }

    public boolean isLocalTest() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isLocalTest();
    }

    public boolean isOptPermissionRequest() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isOptPermissionRequest();
    }

    public boolean isReportBadgerEnable() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isReportBadgerEnable();
    }

    public boolean isReportDepthCameraInfo() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isReportDepthCameraInfo();
    }

    public boolean isReportQualityInfo() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isReportQualityInfo();
    }

    public boolean isScreenRecordDetect() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isScreenRecordDetect();
    }

    public boolean isUpgradeV3() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isUpgradeV3();
    }

    public boolean withFaceDetect() {
        BytedCertSdkInitParam r100 = this.initParam;
        if (r100 != null) goto L6;
        return true;
    L6:
        return !r100.isWithoutFaceDetect();
    }

    public void init(BytedCertSdkInitParam r100) {
        this.initParam = r100;
        if (r100 == null) goto L14;
        IASRService r101 = r100.getAsrService();
        if (r101 == null) goto L7;
        CertServiceManager.getInst().registerService(IASRService.class, r101);
    L7:
        ICertRouterService r102 = r100.getRouterService();
        if (r102 == null) goto L10;
        CertServiceManager.getInst().registerService(ICertRouterService.class, r102);
    L10:
        ICertAnimationService r103 = r100.getAnimationService();
        if (r103 == null) goto L15;
        CertServiceManager.getInst().registerService(ICertAnimationService.class, r103);
        return;
    L15:
        return;
    }

    public boolean isRecordUploadFailVideo(String r100) {
        BytedCertSdkInitParam r101 = this.initParam;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isRecordUploadFailVideo(r100);
    }
}

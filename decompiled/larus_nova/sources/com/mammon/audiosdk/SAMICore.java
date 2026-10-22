package com.mammon.audiosdk;

import com.bytedance.speech.speechaudio.SpeechAudioLoader;
import com.mammon.audiosdk.bridge.SAMICoreBridge;
import com.mammon.audiosdk.enums.SAMICoreContextType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreAISTunnelDumpConfig;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreConnectPoolContextParameter;
import com.mammon.audiosdk.structures.SAMICoreConnectPoolSetting;
import com.mammon.audiosdk.structures.SAMICoreFrontierClientContextParameter;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreWSConnectPoolParameter;
import com.mammon.audiosdk.structures.SAMICoreWakeupFingerprintInitParameter;
import com.mammon.audiosdk.structures.SamiCoreWakeupFingerPrintSensitivityParameter;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes4.dex */
public class SAMICore {
    private static SAMICoreBridge globalBridge;
    private static boolean isInitContext;
    private static SAMICoreNativeLogCallback nativeLogCallBack;
    private static SAMICoreNativeServerParamRequestCallback nativeServerParamRequestCallback;
    private static SAMICoreNativeTraceSpanCallback nativeTraceSpanCallback;
    private static SAMICoreNativeWakeupParamRequestCallback nativeWakeupParamRequestCallback;
    private SAMICoreBridge bridge;
    private boolean enableSyncInterface;
    private SAMICoreIdentify identify;
    private ReentrantReadWriteLock readWriteLock;
    private long resourceHandle;
    private int[] retAarry;

    public static int CloseFrontierClient() {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.FrontierClientClose.getValue(), null);
    }

    public static int FetchWakeupFingerPrintAudio() {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.WakeupFingerprintFetchAudio.getValue(), null);
    }

    public static int InitABContext() {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.SAMICoreContextType_AbConfig.getValue(), null);
    }

    public static int InitTTNetDynamicContext() {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.TTNETDynamicInit.getValue(), null);
    }

    public static int ReleaseWakeupFingerPrintContext() {
        return globalBridge.Native_SAMICoreReleaseContext(SAMICoreContextType.WakeupFingerprintInit.getValue());
    }

    public static int ShutDownConnectPool() {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.ConnectPoolShutDown.getValue(), null);
    }

    public static int ShutDownWSConnectPool() {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.WebSocketConnectPoolContextShutDown.getValue(), null);
    }

    public int SAMICoreDestroyHandle() {
        if (this.enableSyncInterface == true) goto L5;
    L26:
        long r100 = this.resourceHandle;     // Catch: Throwable -> L19
        if (r100 == 0) goto L12;
        int r101 = this.bridge.Native_SAMICoreDestroyHandle(r100);     // Catch: Throwable -> L19
        this.resourceHandle = 0;     // Catch: Throwable -> L19
    L14:
        if (this.enableSyncInterface == false) goto L18;
        this.readWriteLock.writeLock().unlock();
        if (nativeLogCallBack == null) goto L18;
        SAMICoreNativeLogCallback.onLogReceived(4, "[mammon] destroy handle with sync interface unlock " + this.resourceHandle);
    L18:
        return r101;
    L12:
        r101 = 0;
    L19:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L25;
        this.readWriteLock.writeLock().unlock();
        if (nativeLogCallBack == null) goto L25;
        SAMICoreNativeLogCallback.onLogReceived(4, "[mammon] destroy handle with sync interface unlock " + this.resourceHandle);
    L25:
        throw th;
    L5:
        if (nativeLogCallBack == null) goto L7;
        SAMICoreNativeLogCallback.onLogReceived(4, "[mammon] destroy handle with sync interface lock " + this.resourceHandle);
    L7:
        this.readWriteLock.writeLock().lock();
        goto L26
    }

    static {
        SpeechAudioLoader.getInstance().load();
        globalBridge = SpeechAudioLoader.getInstance().createSAMICoreBridge();
        isInitContext = false;
    }

    public SAMICore() {
        this.bridge = SpeechAudioLoader.getInstance().createSAMICoreBridge();
        this.readWriteLock = new ReentrantReadWriteLock();
        this.enableSyncInterface = false;
        this.resourceHandle = 0;
        this.retAarry = new int[]{100000};
    }

    public long getHandle() {
        return this.resourceHandle;
    }

    public static int AddConnectPoolClient(SAMICoreConnectPoolContextParameter r100) {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.ConnectPoolAddConnectClient.getValue(), r100);
    }

    public static int InitAisDumpConfig(SAMICoreAISTunnelDumpConfig r100) {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.AIS_DumpConfig.getValue(), r100);
    }

    public static int InitConnectPool(SAMICoreConnectPoolSetting r100) {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.ConnectPoolInit.getValue(), r100);
    }

    public static int InitFrontierClient(SAMICoreFrontierClientContextParameter r100) {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.FrontierClientInit.getValue(), r100);
    }

    public static int InitWSConnectPool(SAMICoreWSConnectPoolParameter r100) {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.WebSocketConnectPoolContext.getValue(), r100);
    }

    public static int InitWakeupFingerPrintContext(SAMICoreWakeupFingerprintInitParameter r100) {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.WakeupFingerprintInit.getValue(), r100);
    }

    public static long RegisterLog(SAMICoreLogCallback r100) {
        if (nativeLogCallBack != null) goto L5;
        nativeLogCallBack = new SAMICoreNativeLogCallback();
    L5:
        SAMICoreNativeLogCallback.setLogCallback(r100);
        long r101 = globalBridge.Native_SAMICoreRegisterLogger(nativeLogCallBack);
        if (r101 != 0) goto L8;
    L8:
        return r101;
    }

    public static long RegisterServerParamRequestCallback(SAMICoreServerParamRequestCallback r100) {
        if (nativeServerParamRequestCallback != null) goto L5;
        nativeServerParamRequestCallback = new SAMICoreNativeServerParamRequestCallback();
    L5:
        SAMICoreNativeServerParamRequestCallback.setServerParamRequestCallback(r100);
        long r101 = globalBridge.Native_SAMICoreRegisterServerParamRequestCallback(nativeServerParamRequestCallback);
        if (r101 != 0) goto L9;
    L9:
        return r101;
    }

    public static long RegisterSpeechWakeupParamRequestCallback(SAMICoreWakeupParamRequestCallback r100) {
        if (nativeWakeupParamRequestCallback != null) goto L5;
        nativeWakeupParamRequestCallback = new SAMICoreNativeWakeupParamRequestCallback();
    L5:
        SAMICoreNativeWakeupParamRequestCallback.setWakeupParamRequestCallback(r100);
        long r101 = globalBridge.Native_SAMICoreRegisterSpeechWakeupParamRequestCallback(nativeWakeupParamRequestCallback);
        if (r101 != 0) goto L9;
    L9:
        return r101;
    }

    public static long RegisterTraceSpanCallback(SAMICoreTraceSpanCallback r100) {
        if (nativeTraceSpanCallback != null) goto L5;
        nativeTraceSpanCallback = new SAMICoreNativeTraceSpanCallback();
    L5:
        SAMICoreNativeTraceSpanCallback.setTraceSpanCallback(r100);
        long r101 = globalBridge.Native_SAMICoreRegisterTraceSpanCallback(nativeTraceSpanCallback);
        if (r101 != 0) goto L8;
    L8:
        return r101;
    }

    public static long RegisterWakeupParamRequestCallback(SAMICoreWakeupParamRequestCallback r100) {
        if (nativeWakeupParamRequestCallback != null) goto L5;
        nativeWakeupParamRequestCallback = new SAMICoreNativeWakeupParamRequestCallback();
    L5:
        SAMICoreNativeWakeupParamRequestCallback.setWakeupParamRequestCallback(r100);
        long r101 = globalBridge.Native_SAMICoreRegisterWakeupParamRequestCallback(nativeWakeupParamRequestCallback);
        if (r101 != 0) goto L9;
    L9:
        return r101;
    }

    public static int RemoveConnectPoolClient(SAMICoreConnectPoolContextParameter r100) {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.ConnectPoolRemoveConnectClient.getValue(), r100);
    }

    public static int SetWakeupFingerPrintThreshold(float r100) {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.WakeupFingerprintSetSidThreshold.getValue(), Float.valueOf(r100));
    }

    public static int SetWakeupFingerPrintVolume(float r100) {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.WakeupFingerprintSetSidVolume.getValue(), Float.valueOf(r100));
    }

    public static int UpdateFrontierClientPingInterval(Integer r100) {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.FrontierClientUpdatePingInterval.getValue(), r100);
    }

    public static int UpdateWakeupFingerPrintFWEngineVersion(String r100) {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.WakeupFingerprintUpdateFWEngineVersion.getValue(), r100);
    }

    public static int UpdateWakeupFingerPrintModelPath(String r100) {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.WakeupFingerprintUpdateModelPath.getValue(), r100);
    }

    public static int UpdateWakeupFingerPrintUid(String r100) {
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.WakeupFingerprintUpdateUid.getValue(), r100);
    }

    public int SAMICoreProcessAsync(SAMICoreBlock r100) {
        return this.bridge.Native_SAMICoreProcessAsync(this.resourceHandle, this.identify.getValue(), r100);
    }

    public void setEnableSyncInterface(boolean r100) {
        this.enableSyncInterface = r100;
    }

    public void setHostCallBackListener(SAMICoreHostCallBackListener r100) {
        this.bridge.setHostCallBackListener(r100);
    }

    public void setListener(SAMICoreCallBackListener r100) {
        this.bridge.setListener(r100);
    }

    public static int SetWakeupFingerPrintSensitivity(int r100, int r101) {
        SamiCoreWakeupFingerPrintSensitivityParameter r102 = new SamiCoreWakeupFingerPrintSensitivityParameter();
        r102.level = r100;
        r102.bargein_status = r101;
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.WakeupFingerprintSetSidSensitivity.getValue(), r102);
    }

    public int SAMICoreCreateHandleByIdentify(SAMICoreIdentify r100, Object r101) {
        if (this.enableSyncInterface == true) goto L5;
    L23:
        this.identify = r100;     // Catch: Throwable -> L16
        this.retAarry[0] = 100000;     // Catch: Throwable -> L16
        this.resourceHandle = this.bridge.Native_SAMICoreCreateHandleByIdentify(r100.getValue(), r101, this.retAarry);     // Catch: Throwable -> L16
        if (this.enableSyncInterface == false) goto L15;
        this.readWriteLock.readLock().unlock();
        if (nativeLogCallBack == null) goto L15;
        SAMICoreNativeLogCallback.onLogReceived(4, "[mammon] create handle with sync interface unlock " + this.resourceHandle);
    L15:
        return this.retAarry[0];
    L16:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L22;
        this.readWriteLock.readLock().unlock();
        if (nativeLogCallBack == null) goto L22;
        SAMICoreNativeLogCallback.onLogReceived(4, "[mammon] create handle with sync interface unlock " + this.resourceHandle);
    L22:
        throw th;
    L5:
        if (nativeLogCallBack == null) goto L7;
        SAMICoreNativeLogCallback.onLogReceived(4, "[mammon] create handle with sync interface lock " + this.resourceHandle);
    L7:
        this.readWriteLock.readLock().lock();
        goto L23
    }

    public int SAMICoreGetPropertyById(SAMICorePropertyId r100, SAMICoreProperty r101) {
        return this.bridge.Native_SAMICoreGetPropertyById(this.resourceHandle, r100.getValue(), r101);
    }

    public int SAMICoreProcess(SAMICoreBlock r100, SAMICoreBlock r101) {
        if (this.enableSyncInterface == false) goto L15;
        this.readWriteLock.readLock().lock();
    L15:
        int r102 = this.bridge.Native_SAMICoreProcess(this.resourceHandle, this.identify.getValue(), r100, r101);     // Catch: Throwable -> L10
        if (this.enableSyncInterface == false) goto L9;
        this.readWriteLock.readLock().unlock();
    L9:
        return r102;
    L10:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L14;
        this.readWriteLock.readLock().unlock();
    L14:
        throw th;
    }

    public int SAMICoreSetProperty(SAMICorePropertyId r100, SAMICoreProperty r101) {
        if (this.enableSyncInterface == false) goto L19;
        this.readWriteLock.readLock().lock();
    L19:
        long r102 = this.resourceHandle;     // Catch: Throwable -> L14
        if (r102 == 0) goto L9;
        int r103 = this.bridge.Native_SAMICoreSetProperty(r102, r100.getValue(), r101);     // Catch: Throwable -> L14
    L11:
        if (this.enableSyncInterface == false) goto L13;
        this.readWriteLock.readLock().unlock();
    L13:
        return r103;
    L9:
        r103 = 0;
    L14:
        th = move-exception;
        if (this.enableSyncInterface == false) goto L18;
        this.readWriteLock.readLock().unlock();
    L18:
        throw th;
    }

    public static int InitWSConnectPool(String r100, boolean r101, int r102, int r103) {
        SAMICoreWSConnectPoolParameter r104 = new SAMICoreWSConnectPoolParameter();
        r104.url = r100;
        r104.enable = r101;
        r104.poolSize = r102;
        r104.retryCount = r103;
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.WebSocketConnectPoolContext.getValue(), r104);
    }

    public static int InitWSConnectPool(String r100, String r101, boolean r102, int r103, int r104) {
        SAMICoreWSConnectPoolParameter r105 = new SAMICoreWSConnectPoolParameter();
        r105.business = r100;
        r105.url = r101;
        r105.enable = r102;
        r105.poolSize = r103;
        r105.retryCount = r104;
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.WebSocketConnectPoolContext.getValue(), r105);
    }

    public static int InitWSConnectPool(String r100, String r101, boolean r102, int r103, int r104, String r105) {
        SAMICoreWSConnectPoolParameter r106 = new SAMICoreWSConnectPoolParameter();
        r106.business = r100;
        r106.url = r101;
        r106.enable = r102;
        r106.poolSize = r103;
        r106.retryCount = r104;
        r106.header = r105;
        return (int) globalBridge.Native_SAMICoreInitContext(SAMICoreContextType.WebSocketConnectPoolContext.getValue(), r106);
    }
}

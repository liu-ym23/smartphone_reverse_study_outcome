package com.ss.bytertc.audio.device.hwearback.ovm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.oplus.ocs.base.common.constant.CapabilityConstants;
import com.ss.bytertc.audio.device.base.ManufacturerChecker;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class OVMClient {
    private static final int OPEN_DELAY_TIME = 200;
    private static final String TAG = "OVMClient";
    private static final int WAIT_SERVICE_DELAY_TIME = 2500;
    private static volatile OVMClient sClient;
    private BroadcastReceiver headsetPlugReceiver;
    private OVMAuthManager.AuthCallback mAuthCallback;
    private int mAuthResultCode;
    private Context mContext;
    private OVMAuthManager.AuthCallback mInitCallback;
    private boolean mIsHeadsetConnected;
    private boolean mIsSupport;
    private OVMKaraokeMediaHelper mMediaHelper;
    private boolean mNeedDestroyWhenRelease;
    private OVMAuthManager.AuthCallback mRestartAuthCallback;
    private OperateStorage mStorage;
    private Handler postHandler;
    private Runnable restartRunnable;
    private Runnable restoreParamsRunnable;

    /* JADX INFO: renamed from: com.ss.bytertc.audio.device.hwearback.ovm.OVMClient$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$audio$device$base$ManufacturerChecker$Type = null;

        static {
            int[] r100 = new int[ManufacturerChecker.Type.values().length];
            $SwitchMap$com$ss$bytertc$audio$device$base$ManufacturerChecker$Type = r100;
            r100[ManufacturerChecker.Type.OP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$audio$device$base$ManufacturerChecker$Type[ManufacturerChecker.Type.VO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class OperateStorage {
        int equalizerTypeParam;
        boolean isKTVDeviceOpen;
        int listenRecordSameParam;
        int micVolumeParam;
        int mixSoundTypeParam;
        int playFeedbackParam;

        private OperateStorage() {
        }

        public void reset() {
            this.listenRecordSameParam = 0;
            this.playFeedbackParam = 0;
            this.micVolumeParam = 6;
            this.mixSoundTypeParam = 0;
            this.equalizerTypeParam = 0;
        }

        public String toString() {
            return "isKTVDeviceOpen: " + this.isKTVDeviceOpen + ", recordSame: " + this.listenRecordSameParam + ", playFeedback: " + this.playFeedbackParam + ", micVolume: " + this.micVolumeParam + ", mix: " + this.mixSoundTypeParam + ", eq: " + this.equalizerTypeParam;
        }

        public /* synthetic */ OperateStorage(AnonymousClass1 r100) {
            this();
        }
    }

    public static /* synthetic */ void a(OVMClient r100) {
        r100.lambda$new$1();
    }

    public static /* synthetic */ void b(OVMClient r100) {
        r100.lambda$new$0();
    }

    public synchronized void closeKTVDevice() {
        monitor-enter(this);
        RXLogging.i(TAG, "closeKTVDevice");     // Catch: Throwable -> L8
        this.mStorage.isKTVDeviceOpen = true;     // Catch: Throwable -> L8
        clearRestartRunner();     // Catch: Throwable -> L8
        OVMKaraokeMediaHelper r100 = lockMediaHelper();     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        r100.closeKTVDevice();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void openKTVDevice() {
        monitor-enter(this);
        RXLogging.i(TAG, "openKTVDevice");     // Catch: Throwable -> L8
        this.mStorage.isKTVDeviceOpen = true;     // Catch: Throwable -> L8
        OVMKaraokeMediaHelper r100 = lockMediaHelper();     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        r100.openKTVDevice();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void resetKTVParamsAndUpdate() {
        monitor-enter(this);
        RXLogging.i(TAG, "resetKTVParamsAndUpdate");     // Catch: Throwable -> L6
        this.mStorage.reset();     // Catch: Throwable -> L6
        this.postHandler.postDelayed(this.restoreParamsRunnable, 200);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void clearRestartRunner() {
        this.postHandler.removeCallbacks(this.restartRunnable);
        this.postHandler.removeCallbacks(this.restoreParamsRunnable);
    }

    private OVMKaraokeMediaHelper lockMediaHelper() {
        if (this.mIsSupport == true) goto L5;
        return null;
    L5:
        return this.mMediaHelper;
    }

    private void registerHeadsetPlugEvent() {
        if (this.mIsSupport == true) goto L5;
        return;
    L5:
        if (this.mContext != null) goto L7;
        return;
    L7:
        if (needRegisterHeadsetPlug() == false) goto L23;
        RXLogging.i(TAG, "registerHeadsetPlug");
        IntentFilter r100 = new IntentFilter();     // Catch: Throwable -> L16
        r100.addAction("android.intent.action.HEADSET_PLUG");     // Catch: Throwable -> L16
        boolean r101 = true;
        if (INVOKEVIRTUAL_com_ss_bytertc_audio_device_hwearback_ovm_OVMClient_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.headsetPlugReceiver, r100).getIntExtra("state", -99) == 1) goto L14;
        r101 = false;
    L14:
        this.mIsHeadsetConnected = r101;     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        RXLogging.e(TAG, "registerReceiver error", th);
        return;
    }

    private void unRegisterHeadsetPlugEvent() {
        if (this.mContext != null) goto L5;
        return;
    L5:
        if (needRegisterHeadsetPlug() == false) goto L16;
        RXLogging.i(TAG, "unregisterHeadsetPlug");
        INVOKEVIRTUAL_com_ss_bytertc_audio_device_hwearback_ovm_OVMClient_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(this.mContext, this.headsetPlugReceiver);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        RXLogging.e(TAG, "unregisterReceiver error", th);
        return;
    }

    public boolean isSupportedAndAuth() {
        if (this.mIsSupport == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mAuthResultCode != 1001) goto L7;
        return true;
    }

    public void release() {
        RXLogging.i(TAG, "release()");
        OVMAuthManager.getInstance().removeCallback(this.mInitCallback);
        OVMAuthManager.getInstance().removeCallback(this.mRestartAuthCallback);
        unRegisterHeadsetPlugEvent();
        clearRestartRunner();
        if (this.mNeedDestroyWhenRelease == true) goto L5;
        return;
    L5:
        monitor-enter(OVMClient.class);
        RXLogging.i(TAG, "clear sClient");     // Catch: Throwable -> L11
        if (sClient != this) goto L9;
        sClient = null;     // Catch: Throwable -> L11
    L9:
        monitor-exit(OVMClient.class);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$0() {
        RXLogging.i(TAG, "restart media helper");
        if (isSupported() == true) goto L5;
    L18:
        RXLogging.e(TAG, "restart with error, return: " + isSupported() + ", " + this.mStorage.isKTVDeviceOpen);
        return;
    L5:
        if (this.mStorage.isKTVDeviceOpen == false) goto L18;
        int r100 = AnonymousClass4.$SwitchMap$com$ss$bytertc$audio$device$base$ManufacturerChecker$Type[ManufacturerChecker.getManufacturerType().ordinal()];
        if (r100 != 1) goto L10;
        initMediaHelper(this.mRestartAuthCallback);
        return;
    L10:
        if (r100 != 2) goto L23;
        OVMKaraokeMediaHelper r101 = lockMediaHelper();
        if (this.mStorage.isKTVDeviceOpen == false) goto L20;
        if (r101 == null) goto L21;
        RXLogging.i(TAG, "closeKTVDevice duration restart.");
        r101.openKTVDevice();
        restoreParams(r101);
        return;
    L21:
        return;
    L20:
        return;
    }

    private /* synthetic */ void lambda$new$1() {
        OVMKaraokeMediaHelper r100 = lockMediaHelper();
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mStorage.isKTVDeviceOpen == false) goto L9;
        RXLogging.i(TAG, "openKTVDevice duration restore params.");
        restoreParams(r100);
        return;
    }

    private boolean needRegisterHeadsetPlug() {
        ManufacturerChecker.Type r100 = ManufacturerChecker.getManufacturerType();
        if (r100 != ManufacturerChecker.Type.OP) goto L5;
    L8:
        return true;
    L5:
        if (r100 == ManufacturerChecker.Type.VO) goto L8;
        return false;
    }

    public String getKaraokeSupportParameters() {
        OVMKaraokeMediaHelper r100 = lockMediaHelper();
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.getKaraokeSupportParameters();
    }

    public int getListenRecordSame() {
        OVMKaraokeMediaHelper r100 = lockMediaHelper();
        if (r100 == null) goto L7;
        r100.getListenRecordSame();
        return 0;
    L7:
        return 0;
    }

    public int getMicVolParam() {
        OVMKaraokeMediaHelper r100 = lockMediaHelper();
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getMicVolParam();
    }

    public int getPlayFeedbackParam() {
        OVMKaraokeMediaHelper r100 = lockMediaHelper();
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getPlayFeedbackParam();
    }

    public int getVersion() {
        OVMKaraokeMediaHelper r100 = lockMediaHelper();
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getVersion();
    }

    public boolean isDeviceSupportKaraoke() {
        OVMKaraokeMediaHelper r100 = lockMediaHelper();
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isDeviceSupportKaraoke();
    }

    public boolean isSupported() {
        return this.mIsSupport;
    }

    private OVMClient(Context r100) {
        boolean r101 = false;
        this.mIsSupport = false;
        this.mAuthResultCode = -2;
        this.mNeedDestroyWhenRelease = false;
        this.mStorage = new OperateStorage(null);
        this.mInitCallback = new AnonymousClass1(this);
        this.mIsHeadsetConnected = false;
        this.mRestartAuthCallback = new AnonymousClass2(this);
        this.postHandler = new Handler(Looper.getMainLooper());
        this.restartRunnable = new b(this);
        this.restoreParamsRunnable = new c(this);
        this.headsetPlugReceiver = new AnonymousClass3(this);
        if (ManufacturerChecker.getManufacturerType() != ManufacturerChecker.Type.OP) goto L5;
        r101 = true;
    L5:
        this.mNeedDestroyWhenRelease = r101;
        this.mContext = r100.getApplicationContext();
        initClient(r100);
    }

    public static /* synthetic */ int access$100(OVMClient r100) {
        return r100.mAuthResultCode;
    }

    public static /* synthetic */ OVMAuthManager.AuthCallback access$200(OVMClient r100) {
        return r100.mAuthCallback;
    }

    public static /* synthetic */ Runnable access$300(OVMClient r100) {
        return r100.restoreParamsRunnable;
    }

    public static /* synthetic */ Handler access$400(OVMClient r100) {
        return r100.postHandler;
    }

    public static /* synthetic */ OperateStorage access$500(OVMClient r100) {
        return r100.mStorage;
    }

    public static /* synthetic */ OVMKaraokeMediaHelper access$600(OVMClient r100) {
        return r100.lockMediaHelper();
    }

    public static /* synthetic */ boolean access$700(OVMClient r100) {
        return r100.mIsHeadsetConnected;
    }

    public static /* synthetic */ void access$900(OVMClient r100) {
        r100.clearRestartRunner();
    }

    private void initClient(Context r100) {
        RXLogging.i(TAG, "initClient");
        boolean r101 = false;
        this.mIsSupport = false;
        OperateStorage r102 = this.mStorage;
        r102.isKTVDeviceOpen = false;
        r102.reset();
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        return;
    L5:
        initMediaHelper(this.mInitCallback);
        if (this.mMediaHelper == null) goto L8;
        boolean r103 = true;
    L9:
        this.mIsSupport = r103;
        if (r103 == true) goto L12;
    L19:
        registerHeadsetPlugEvent();
        return;
    L12:
        if (isDeviceSupportKaraoke() == true) goto L14;
    L18:
        this.mIsSupport = r101;
        goto L19
    L14:
        if (isAppSupportKaraoke(r100.getPackageName()) == false) goto L18;
        if (getVersion() < 10000) goto L18;
        r101 = true;
        goto L18
    L8:
        r103 = false;
        goto L9
    }

    private void initMediaHelper(OVMAuthManager.AuthCallback r100) {
        OVMKaraokeMediaHelper r101 = OVMKaraokeMediaHelper.create(this.mContext);     // Catch: Throwable -> L6
        this.mMediaHelper = r101;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        OVMAuthManager.getInstance().addCallback(r100);     // Catch: Throwable -> L6
        OVMAuthManager.getInstance().startAuth(this.mContext, CapabilityConstants.MEDIA_CLIENT);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        RXLogging.e(TAG, "init media helper error", th);
    }

    public static OVMClient initialize(Context r100) {
        if (sClient != null) goto L15;
        monitor-enter(OVMClient.class);
        Context r101 = r100.getApplicationContext();     // Catch: Throwable -> L11
        if (sClient != null) goto L9;
        sClient = new OVMClient(r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(OVMClient.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L15:
        return sClient;
    }

    private void restartKTVDevice(int r100) {
        clearRestartRunner();
        this.postHandler.postDelayed(this.restartRunnable, r100);
    }

    private void restoreParams(OVMKaraokeMediaHelper r100) {
        RXLogging.i(TAG, "restore params: " + this.mStorage.toString());
        r100.setPlayFeedbackParam(this.mStorage.playFeedbackParam);
        r100.setListenRecordSame(this.mStorage.listenRecordSameParam);
        r100.setMicVolParam(this.mStorage.micVolumeParam);
        r100.setEqualizerType(this.mStorage.equalizerTypeParam);
        r100.setMixerSoundType(this.mStorage.mixSoundTypeParam);
    }

    public boolean isAppSupportKaraoke(String r100) {
        OVMKaraokeMediaHelper r101 = lockMediaHelper();
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.isAppSupportKaraoke(r100);
    }

    public synchronized void setAuthCallback(OVMAuthManager.AuthCallback r100) {
        monitor-enter(this);
        this.mAuthCallback = r100;     // Catch: Throwable -> L9
        int r101 = this.mAuthResultCode;     // Catch: Throwable -> L9
        if (r101 == (-2)) goto L7;
        if (r100 == null) goto L7;
        r100.onResult(r101);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void setEqualizerType(int r100) {
        RXLogging.i(TAG, "setEqualizerType: " + r100);
        this.mStorage.equalizerTypeParam = r100;
        OVMKaraokeMediaHelper r101 = lockMediaHelper();
        if (r101 == null) goto L6;
        r101.setEqualizerType(r100);
        return;
    }

    public void setListenRecordSame(int r100) {
        RXLogging.i(TAG, "setListenRecordSame: " + r100);
        this.mStorage.listenRecordSameParam = r100;
        OVMKaraokeMediaHelper r101 = lockMediaHelper();
        if (r101 == null) goto L6;
        r101.setListenRecordSame(r100);
        return;
    }

    public void setMicVolParam(int r100) {
        RXLogging.i(TAG, "setMicVolParam: " + r100);
        this.mStorage.micVolumeParam = r100;
        OVMKaraokeMediaHelper r101 = lockMediaHelper();
        if (r101 == null) goto L6;
        r101.setMicVolParam(r100);
        return;
    }

    public void setMixerSoundType(int r100) {
        RXLogging.i(TAG, "setMixerSoundType: " + r100);
        this.mStorage.mixSoundTypeParam = r100;
        OVMKaraokeMediaHelper r101 = lockMediaHelper();
        if (r101 == null) goto L6;
        r101.setMixerSoundType(r100);
        return;
    }

    public void setPlayFeedbackParam(int r100) {
        RXLogging.i(TAG, "setPlayFeedbackParam: " + r100);
        this.mStorage.playFeedbackParam = r100;
        OVMKaraokeMediaHelper r101 = lockMediaHelper();
        if (r101 == null) goto L6;
        r101.setPlayFeedbackParam(r100);
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_ss_bytertc_audio_device_hwearback_ovm_OVMClient_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    public static /* synthetic */ int access$102(OVMClient r100, int r101) {
        r100.mAuthResultCode = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$702(OVMClient r100, boolean r101) {
        r100.mIsHeadsetConnected = r101;
        return r101;
    }

    public static /* synthetic */ void access$800(OVMClient r100, int r101) {
        r100.restartKTVDevice(r101);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ss_bytertc_audio_device_hwearback_ovm_OVMClient_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }
}

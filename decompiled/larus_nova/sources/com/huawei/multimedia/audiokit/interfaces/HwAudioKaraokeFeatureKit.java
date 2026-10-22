package com.huawei.multimedia.audiokit.interfaces;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature;
import com.huawei.multimedia.audiokit.utils.LogUtils;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public class HwAudioKaraokeFeatureKit extends AudioFeaturesKit {
    private static final String ENGINE_CLASS_NAME = "com.huawei.multimedia.audioengine.HwAudioKaraokeFeatureService";
    private static final String TAG = "HwAudioKit.HwAudioKaraokeFeatureKit";
    private ServiceConnection mConnection;
    private Context mContext;
    private IBinder.DeathRecipient mDeathRecipient;
    private FeatureKitManager mFeatureKitManager;
    private IHwAudioKaraokeFeature mIHwAudioKaraokeFeatureAidl;
    private boolean mIsServiceConnected;
    private IBinder mService;

    public static final enum ParameName extends Enum<ParameName> {
        private static final /* synthetic */ ParameName[] $VALUES = null;
        public static final ParameName CMD_SET_AUDIO_EFFECT_MODE_BASE = null;
        public static final ParameName CMD_SET_VOCAL_EQUALIZER_MODE = null;
        public static final ParameName CMD_SET_VOCAL_VOLUME_BASE = null;
        private String mParameName;

        static {
            ParameName r100 = new ParameName("CMD_SET_AUDIO_EFFECT_MODE_BASE", 0, "Karaoke_reverb_mode=");
            CMD_SET_AUDIO_EFFECT_MODE_BASE = r100;
            ParameName r101 = new ParameName("CMD_SET_VOCAL_VOLUME_BASE", 1, "Karaoke_volume=");
            CMD_SET_VOCAL_VOLUME_BASE = r101;
            ParameName r102 = new ParameName("CMD_SET_VOCAL_EQUALIZER_MODE", 2, "Karaoke_eq_mode=");
            CMD_SET_VOCAL_EQUALIZER_MODE = r102;
            $VALUES = new ParameName[]{r100, r101, r102};
        }

        public static ParameName[] values() {
            return (ParameName[]) $VALUES.clone();
        }

        public String getParameName() {
            return this.mParameName;
        }

        public static ParameName valueOf(String r100) {
            return (ParameName) a.a(ParameName.class, r100);
        }

        private ParameName(String r100, int r101, String r102) {
            super(r100, r101);
            this.mParameName = r102;
        }
    }

    public void destroy() {
        LogUtils.info(TAG, "destroy, mIsServiceConnected = " + this.mIsServiceConnected);
        if (this.mIsServiceConnected == false) goto L6;
        this.mIsServiceConnected = false;
        this.mFeatureKitManager.unbindService(this.mContext, this.mConnection);
        return;
    }

    public int getKaraokeLatency() {
        LogUtils.info(TAG, "getKaraokeLatency");
        IHwAudioKaraokeFeature r100 = this.mIHwAudioKaraokeFeatureAidl;     // Catch: RemoteException -> L9
        if (r100 != null) goto L6;
        return -1;
    L6:
        if (this.mIsServiceConnected == false) goto L16;
        return r100.getKaraokeLatency();
    L16:
        return -1;
    L9:
        e = move-exception;
        LogUtils.error(TAG, "getKaraokeLatency,RemoteException ex : " + e.getMessage());
        return -1;
    }

    public boolean isKaraokeFeatureSupport() {
        LogUtils.info(TAG, "isKaraokeFeatureSupport");
        IHwAudioKaraokeFeature r100 = this.mIHwAudioKaraokeFeatureAidl;     // Catch: RemoteException -> L9
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.mIsServiceConnected == false) goto L16;
        return r100.isKaraokeFeatureSupport();
    L16:
        return false;
    L9:
        e = move-exception;
        LogUtils.error(TAG, "isFeatureSupported,RemoteException ex :" + e.getMessage());
        return false;
    }

    public HwAudioKaraokeFeatureKit(Context r100) {
        this.mFeatureKitManager = null;
        this.mIsServiceConnected = false;
        this.mService = null;
        this.mConnection = new AnonymousClass1(this);
        this.mDeathRecipient = new AnonymousClass2(this);
        this.mFeatureKitManager = FeatureKitManager.getInstance();
        this.mContext = r100;
    }

    public static /* synthetic */ IHwAudioKaraokeFeature access$000(HwAudioKaraokeFeatureKit r100) {
        return r100.mIHwAudioKaraokeFeatureAidl;
    }

    public static /* synthetic */ FeatureKitManager access$200(HwAudioKaraokeFeatureKit r100) {
        return r100.mFeatureKitManager;
    }

    public static /* synthetic */ Context access$300(HwAudioKaraokeFeatureKit r100) {
        return r100.mContext;
    }

    public static /* synthetic */ IBinder.DeathRecipient access$600(HwAudioKaraokeFeatureKit r100) {
        return r100.mDeathRecipient;
    }

    public static /* synthetic */ IBinder access$700(HwAudioKaraokeFeatureKit r100) {
        return r100.mService;
    }

    private void bindService(Context r100) {
        LogUtils.info(TAG, "bindService");
        FeatureKitManager r101 = this.mFeatureKitManager;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.mIsServiceConnected == true) goto L9;
        r101.bindService(r100, this.mConnection, ENGINE_CLASS_NAME);
        return;
    }

    private void serviceInit(String r100) {
        IHwAudioKaraokeFeature r101 = this.mIHwAudioKaraokeFeatureAidl;     // Catch: RemoteException -> L8
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.mIsServiceConnected == false) goto L14;
        r101.init(r100);     // Catch: RemoteException -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        LogUtils.error(TAG, "isFeatureSupported,RemoteException ex :" + e.getMessage());
    }

    private void serviceLinkToDeath(IBinder r100) {
        this.mService = r100;
        if (r100 == null) goto L10;
        r100.linkToDeath(this.mDeathRecipient, 0);     // Catch: RemoteException -> L6
        return;
    L6:
        this.mFeatureKitManager.onCallBack(1002);
        LogUtils.error(TAG, "serviceLinkToDeath, RemoteException");
        return;
    }

    public int enableKaraokeFeature(boolean r100) {
        LogUtils.info(TAG, "enableKaraokeFeature, enable = " + r100);
        IHwAudioKaraokeFeature r101 = this.mIHwAudioKaraokeFeatureAidl;     // Catch: RemoteException -> L9
        if (r101 != null) goto L6;
        return -2;
    L6:
        if (this.mIsServiceConnected == false) goto L16;
        return r101.enableKaraokeFeature(r100);
    L16:
        return -2;
    L9:
        e = move-exception;
        LogUtils.error(TAG, "enableKaraokeFeature,RemoteException ex : " + e.getMessage());
        return -2;
    }

    public void initialize(Context r100) {
        LogUtils.info(TAG, "initialize");
        if (r100 != null) goto L7;
        LogUtils.info(TAG, "initialize, context is null");
        return;
    L7:
        if (this.mFeatureKitManager.isAudioKitSupport(r100) == true) goto L10;
        this.mFeatureKitManager.onCallBack(2);
        LogUtils.info(TAG, "initialize, not install AudioEngine");
        return;
    L10:
        bindService(r100);
    }

    public static /* synthetic */ IHwAudioKaraokeFeature access$002(HwAudioKaraokeFeatureKit r100, IHwAudioKaraokeFeature r101) {
        r100.mIHwAudioKaraokeFeatureAidl = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(HwAudioKaraokeFeatureKit r100, boolean r101) {
        r100.mIsServiceConnected = r101;
        return r101;
    }

    public static /* synthetic */ void access$400(HwAudioKaraokeFeatureKit r100, String r101) {
        r100.serviceInit(r101);
    }

    public static /* synthetic */ void access$500(HwAudioKaraokeFeatureKit r100, IBinder r101) {
        r100.serviceLinkToDeath(r101);
    }

    public static /* synthetic */ IBinder access$702(HwAudioKaraokeFeatureKit r100, IBinder r101) {
        r100.mService = r101;
        return r101;
    }

    public int setParameter(ParameName r100, int r101) {
        if (r100 != null) goto L16;
        return 1807;
    L16:
        LogUtils.info(TAG, "parameValue =" + r101 + ", parame.getParameName() =" + r100.getParameName());     // Catch: RemoteException -> L12
        IHwAudioKaraokeFeature r102 = this.mIHwAudioKaraokeFeatureAidl;     // Catch: RemoteException -> L12
        if (r102 != null) goto L9;
        return -2;
    L9:
        if (this.mIsServiceConnected == false) goto L19;
        return r102.setParameter(r100.getParameName(), r101);
    L19:
        return -2;
    L12:
        e = move-exception;
        LogUtils.error(TAG, "setParameter,RemoteException ex : " + e.getMessage());
        return -2;
    }
}

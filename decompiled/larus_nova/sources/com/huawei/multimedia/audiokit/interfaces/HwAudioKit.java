package com.huawei.multimedia.audiokit.interfaces;

import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.multimedia.audioengine.IHwAudioEngine;
import com.huawei.multimedia.audiokit.config.Version;
import com.huawei.multimedia.audiokit.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public class HwAudioKit {
    private static final List<Integer> DEFAULT_FEATURE_LIST = null;
    private static final int DEFAULT_VALUE = 0;
    private static final String ENGINE_CLASS_NAME = "com.huawei.multimedia.audioengine.HwAudioEngineService";
    private static final String ENGINE_PACKAGE_NAME = "com.huawei.multimedia.audioengine";
    private static final String TAG = "HwAudioKit.HwAudioKit";
    private ServiceConnection mConnection;
    private Context mContext;
    private IBinder.DeathRecipient mDeathRecipient;
    private FeatureKitManager mFeatureKitManager;
    private IHwAudioEngine mIHwAudioEngine;
    private boolean mIsServiceConnected;
    private IBinder mService;

    public static final enum FeatureType extends Enum<FeatureType> {
        private static final /* synthetic */ FeatureType[] $VALUES = null;
        public static final FeatureType HWAUDIO_FEATURE_KARAOKE = null;
        private int mFeatureType;

        static {
            FeatureType r100 = new FeatureType("HWAUDIO_FEATURE_KARAOKE", 0, 1);
            HWAUDIO_FEATURE_KARAOKE = r100;
            $VALUES = new FeatureType[]{r100};
        }

        public static FeatureType[] values() {
            return (FeatureType[]) $VALUES.clone();
        }

        public int getFeatureType() {
            return this.mFeatureType;
        }

        public static FeatureType valueOf(String r100) {
            return (FeatureType) a.a(FeatureType.class, r100);
        }

        private FeatureType(String r100, int r101, int r102) {
            super(r100, r101);
            this.mFeatureType = r102;
        }
    }

    static {
        DEFAULT_FEATURE_LIST = new ArrayList(0);
    }

    public void destroy() {
        LogUtils.info(TAG, "destroy, mIsServiceConnected = " + this.mIsServiceConnected);
        if (this.mIsServiceConnected == false) goto L6;
        this.mIsServiceConnected = false;
        this.mFeatureKitManager.unbindService(this.mContext, this.mConnection);
        return;
    }

    public List<Integer> getSupportedFeatures() {
        LogUtils.info(TAG, "getSupportedFeatures");
        IHwAudioEngine r100 = this.mIHwAudioEngine;     // Catch: RemoteException -> L9
        if (r100 != null) goto L6;
    L10:
        LogUtils.info(TAG, "getSupportedFeatures, service not bind");
        return DEFAULT_FEATURE_LIST;
    L6:
        if (this.mIsServiceConnected == false) goto L10;
        return r100.getSupportedFeatures();
    L9:
        LogUtils.error(TAG, "getSupportedFeatures, createFeature,wait bind service fail");
        goto L10
    }

    public void initialize() {
        LogUtils.info(TAG, "initialize");
        Context r100 = this.mContext;
        if (r100 != null) goto L7;
        LogUtils.info(TAG, "mContext is null");
        this.mFeatureKitManager.onCallBack(7);
        return;
    L7:
        if (this.mFeatureKitManager.isAudioKitSupport(r100) == true) goto L10;
        LogUtils.info(TAG, "not install AudioKitEngine");
        this.mFeatureKitManager.onCallBack(2);
        return;
    L10:
        bindService(this.mContext);
    }

    public boolean isSdkVersionMoreEngineVersion() {
        if (Version.SDK_VERSION <= getAudioVersion(this.mContext, ENGINE_PACKAGE_NAME)) goto L6;
        return true;
    L6:
        return false;
    }

    public static /* synthetic */ IHwAudioEngine access$000(HwAudioKit r100) {
        return r100.mIHwAudioEngine;
    }

    public static /* synthetic */ FeatureKitManager access$200(HwAudioKit r100) {
        return r100.mFeatureKitManager;
    }

    public static /* synthetic */ Context access$300(HwAudioKit r100) {
        return r100.mContext;
    }

    public static /* synthetic */ IBinder.DeathRecipient access$600(HwAudioKit r100) {
        return r100.mDeathRecipient;
    }

    public static /* synthetic */ IBinder access$700(HwAudioKit r100) {
        return r100.mService;
    }

    private void bindService(Context r100) {
        LogUtils.info(TAG, "bindService, mIsServiceConnected = " + this.mIsServiceConnected);
        FeatureKitManager r101 = this.mFeatureKitManager;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.mIsServiceConnected == true) goto L9;
        r101.bindService(r100, this.mConnection, ENGINE_CLASS_NAME);
        return;
    }

    private void serviceLinkToDeath(IBinder r100) {
        this.mService = r100;
        if (r100 == null) goto L10;
        r100.linkToDeath(this.mDeathRecipient, 0);     // Catch: RemoteException -> L6
        return;
    L6:
        this.mFeatureKitManager.onCallBack(5);
        LogUtils.error(TAG, "serviceLinkToDeath, RemoteException");
        return;
    }

    public <T extends AudioFeaturesKit> T createFeature(FeatureType r100) {
        FeatureKitManager r101 = this.mFeatureKitManager;
        if (r101 == null) goto L7;
        if (r100 != null) goto L6;
        return null;
    L6:
        return (T) r101.createFeatureKit(r100.getFeatureType(), this.mContext);
    L7:
        return null;
    }

    public EnhancedDeviceInfo getEnhancedDeviceInfo(int r100) throws UnsupportedVersionException {
        if (this.mContext != null) goto L7;
        LogUtils.error(TAG, " getEnhancedDeviceInfo mContext is null");
        return null;
    L7:
        if (r100 == 4) goto L19;
        if (r100 == 3) goto L19;
        if (r100 == 11) goto L19;
        if (r100 == 22) goto L19;
        if (r100 == 8) goto L19;
        LogUtils.error(TAG, " getEnhancedDeviceInfo device type is not supported");
        return null;
    L19:
        if (isSdkVersionMoreEngineVersion() == true) goto L23;
        return new EnhancedDeviceInfo(this.mContext, r100);
    L23:
        throw new UnsupportedVersionException();
    }

    public boolean isFeatureSupported(FeatureType r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        LogUtils.info(TAG, "isFeatureSupported, type = " + r100.getFeatureType());
        IHwAudioEngine r101 = this.mIHwAudioEngine;     // Catch: RemoteException -> L12
        if (r101 != null) goto L9;
    L14:
        return false;
    L9:
        if (this.mIsServiceConnected == false) goto L14;
        return r101.isFeatureSupported(r100.getFeatureType());
    L12:
        e = move-exception;
        LogUtils.error(TAG, "isFeatureSupported,RemoteException ex : " + e.getMessage());
        goto L14
    }

    public HwAudioKit(Context r100, IAudioKitCallback r101) {
        this.mContext = null;
        this.mIHwAudioEngine = null;
        this.mIsServiceConnected = false;
        this.mService = null;
        this.mConnection = new AnonymousClass1(this);
        this.mDeathRecipient = new AnonymousClass2(this);
        FeatureKitManager r102 = FeatureKitManager.getInstance();
        this.mFeatureKitManager = r102;
        r102.setCallBack(r101);
        this.mContext = r100;
    }

    public static /* synthetic */ IHwAudioEngine access$002(HwAudioKit r100, IHwAudioEngine r101) {
        r100.mIHwAudioEngine = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(HwAudioKit r100, boolean r101) {
        r100.mIsServiceConnected = r101;
        return r101;
    }

    public static /* synthetic */ void access$500(HwAudioKit r100, IBinder r101) {
        r100.serviceLinkToDeath(r101);
    }

    public static /* synthetic */ IBinder access$702(HwAudioKit r100, IBinder r101) {
        r100.mService = r101;
        return r101;
    }

    private void serviceInit(String r100, String r101) {
        LogUtils.info(TAG, "serviceInit");
        IHwAudioEngine r102 = this.mIHwAudioEngine;     // Catch: RemoteException -> L9
        if (r102 != null) goto L6;
        return;
    L6:
        if (this.mIsServiceConnected == false) goto L15;
        r102.init(r100, r101);     // Catch: RemoteException -> L9
        return;
    L15:
        return;
    L9:
        e = move-exception;
        LogUtils.error(TAG, "isFeatureSupported,RemoteException ex :" + e.getMessage());
    }

    public long getAudioVersion(Context r100, String r101) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        PackageManager r102 = r100.getPackageManager();
        if (r102 != null) goto L17;
        return 0;
    L17:
        PackageInfo r103 = r102.getPackageInfo(r101, 0);     // Catch: PackageManager.NameNotFoundException -> L14
        if (r103 != null) goto L19;
        LogUtils.info(TAG, "packageInfo is null");     // Catch: PackageManager.NameNotFoundException -> L14
        return 0;
    L19:
        return r103.getLongVersionCode();
    L14:
        e = move-exception;
        LogUtils.error(TAG, "getAudioVersion Exception e = " + e.getMessage());
        return 0;
    }

    public static /* synthetic */ void access$400(HwAudioKit r100, String r101, String r102) {
        r100.serviceInit(r101, r102);
    }
}

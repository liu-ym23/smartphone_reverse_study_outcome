package com.huawei.multimedia.audiokit.interfaces;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import com.huawei.multimedia.audiokit.utils.LogUtils;

/* JADX INFO: loaded from: classes23.dex */
public class FeatureKitManager {
    private static final Object BIND_SERVICE_LOCK = null;
    private static final String ENGINE_PACKAGE_NAME = "com.huawei.multimedia.audioengine";
    private static final Object NEW_FEATUREMANAGER_LOCK = null;
    private static final int PACKAGE_INFO_FLAG = 0;
    private static final Object SET_CALL_BACK_LOCK = null;
    private static final String TAG = "HwAudioKit.FeatureKitManager";
    private static final Object UNBIND_SERVICE_LOCK = null;
    private static FeatureKitManager sInstance;
    private IAudioKitCallback mCallBack;

    static {
        SET_CALL_BACK_LOCK = new Object();
        NEW_FEATUREMANAGER_LOCK = new Object();
        BIND_SERVICE_LOCK = new Object();
        UNBIND_SERVICE_LOCK = new Object();
        sInstance = null;
    }

    public static FeatureKitManager getInstance() {
        Object r100 = NEW_FEATUREMANAGER_LOCK;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new FeatureKitManager();     // Catch: Throwable -> L10
    L7:
        FeatureKitManager r101 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    }

    private FeatureKitManager() {
        this.mCallBack = null;
    }

    public IAudioKitCallback getCallBack() {
        return this.mCallBack;
    }

    public boolean isAudioKitSupport(Context r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        PackageManager r101 = r100.getPackageManager();
        if (r101 != null) goto L15;
        return true;
    L15:
    L11:
        LogUtils.error(TAG, "isAudioKitSupport ,NameNotFoundException");
        return false;
    L8:
        if (r101.getPackageInfo(ENGINE_PACKAGE_NAME, 0) != null) goto L17;
        LogUtils.info(TAG, "packageInfo is null");     // Catch: PackageManager.NameNotFoundException -> L11
        return false;
    L17:
        return true;
    }

    public void onCallBack(int r100) {
        LogUtils.info(TAG, "onCallBack, result =" + r100);
        Object r101 = SET_CALL_BACK_LOCK;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (getCallBack() == null) goto L7;
        getCallBack().onResult(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    public void setCallBack(IAudioKitCallback r100) {
        this.mCallBack = r100;
    }

    public <T extends AudioFeaturesKit> T createFeatureKit(int r100, Context r101) {
        LogUtils.info(TAG, "createFeatureKit, type =" + r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r100 == 1) goto L9;
        LogUtils.info(TAG, "createFeatureKit, type error");
        return null;
    L9:
        HwAudioKaraokeFeatureKit r102 = new HwAudioKaraokeFeatureKit(r101);
        r102.initialize(r101);
        return r102;
    }

    public void unbindService(Context r100, ServiceConnection r101) {
        LogUtils.info(TAG, "unbindService");
        Object r102 = UNBIND_SERVICE_LOCK;
        monitor-enter(r102);
        if (r100 != null) goto L11;
    L6:
        monitor-exit(r102);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        r100.unbindService(r101);     // Catch: Throwable -> L8
        goto L6
    }

    public void bindService(Context r100, ServiceConnection r101, String r102) {
        Object r103 = BIND_SERVICE_LOCK;
        monitor-enter(r103);
        if (r100 != null) goto L7;
        monitor-exit(r103);     // Catch: Throwable -> L14
        return;
    L7:
        Intent r104 = new Intent();     // Catch: Throwable -> L14
        r104.setClassName(ENGINE_PACKAGE_NAME, r102);     // Catch: Throwable -> L14
        LogUtils.info(TAG, "bindService");     // Catch: SecurityException -> L10 Throwable -> L14
        r100.bindService(r104, r101, 1);     // Catch: SecurityException -> L10 Throwable -> L14
    L12:
        monitor-exit(r103);     // Catch: Throwable -> L14
        return;
    L10:
        e = move-exception;
        LogUtils.error(TAG, "bindService, SecurityException, " + e.getMessage());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }
}

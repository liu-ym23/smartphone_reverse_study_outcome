package com.bytedance.mira.core;

import com.bytedance.mira.Mira;

/* JADX INFO: loaded from: classes21.dex */
public class GlobalInfoManager {
    private static final String DEVICE_SUPPORT_KEY = "device_support_key";
    private static volatile GlobalInfoManager sInstance;
    private volatile boolean mDeviceSupport;
    private final Object mDeviceSupportLock;
    private android.content.SharedPreferences mPreferences;

    public static GlobalInfoManager getInst() {
        if (sInstance != null) goto L15;
        monitor-enter(GlobalInfoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new GlobalInfoManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(GlobalInfoManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void initDeviceSupport() {
        this.mDeviceSupport = this.mPreferences.getBoolean(DEVICE_SUPPORT_KEY, true);
    }

    public void disableDeviceSupport() {
        if (this.mDeviceSupport == false) goto L14;
        Object r100 = this.mDeviceSupportLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mDeviceSupport == false) goto L9;
        this.mDeviceSupport = false;     // Catch: Throwable -> L11
        this.mPreferences.edit().putBoolean(DEVICE_SUPPORT_KEY, false).apply();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    }

    private GlobalInfoManager() {
        this.mDeviceSupport = true;
        this.mDeviceSupportLock = new Object();
        initSp();
        initDeviceSupport();
    }

    private void initSp() {
        this.mPreferences = Mira.getAppContext().getSharedPreferences("plugin_global_info", 0);
    }

    public boolean isDeviceSupport() {
        return this.mDeviceSupport;
    }
}

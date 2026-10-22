package com.lynx.devtool.recorder;

import android.content.Context;
import android.content.SharedPreferences;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public class SettingUtils {
    private static final String ENABLE_LYNX_SERVICE_KEY = "lynx_service_enabled";
    private static final String SP_SETTINGS_KEY = "lynx_example_sp";
    private static final String TAG = "SettingUtils";
    private static volatile SettingUtils sInstance;
    private boolean lynxServiceEnabled;
    private SharedPreferences mSP;

    public boolean isLynxServiceEnabled() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mSP != null) goto L6;
        LLog.e(TAG, "please call initSettings first");     // Catch: Throwable -> L9
    L6:
        boolean r100 = this.lynxServiceEnabled;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r100;
    }

    public static SettingUtils inst() {
        if (sInstance != null) goto L15;
        monitor-enter(SettingUtils.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SettingUtils();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SettingUtils.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public SettingUtils() {
        this.mSP = null;
        this.lynxServiceEnabled = false;
    }

    private SharedPreferences initIfNot(Context r100) {
        monitor-enter(this);
        SharedPreferences r101 = this.mSP;     // Catch: Throwable -> L9
        if (r101 != null) goto L7;
        r101 = r100.getSharedPreferences(SP_SETTINGS_KEY, 0);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return r101;
    L9:
        th = move-exception;
        throw th;
    }

    public void initSettings(Context r100) {
        monitor-enter(this);
        if (r100 != null) goto L10;
    L5:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    L10:
        SharedPreferences r101 = initIfNot(r100);     // Catch: Throwable -> L7
        this.mSP = r101;     // Catch: Throwable -> L7
        this.lynxServiceEnabled = r101.getBoolean(ENABLE_LYNX_SERVICE_KEY, false);     // Catch: Throwable -> L7
        goto L5
    }

    public void setLynxServiceEnabled(boolean r100) {
        monitor-enter(this);
        SharedPreferences r101 = this.mSP;     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        r101.edit().putBoolean(ENABLE_LYNX_SERVICE_KEY, r100).commit();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}

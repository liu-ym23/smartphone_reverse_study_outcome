package com.huawei.hms.framework.common;

import android.content.ContentResolver;
import android.provider.Settings;

/* JADX INFO: loaded from: classes23.dex */
public class SettingUtil {
    private static final String TAG = "SettingUtil";

    public SettingUtil() {
    }

    public static int getSecureInt(ContentResolver r100, String r101, int r102) {
        return Settings.Secure.getInt(r100, r101, r102);
    L4:
        e = move-exception;
        Logger.e(TAG, "Settings Secure getInt throwFromSystemServer:", e);
        return r102;
    }

    public static int getSystemInt(ContentResolver r100, String r101, int r102) {
        return Settings.System.getInt(r100, r101, r102);
    L4:
        e = move-exception;
        Logger.e(TAG, "Settings System getInt throwFromSystemServer:", e);
        return r102;
    }
}

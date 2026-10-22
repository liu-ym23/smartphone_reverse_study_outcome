package com.bytedance.ttnet.debug;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes22.dex */
public class DebugSetting {
    private static String KEY_LOG_SWITCHER = "log_switcher";
    private static String KEY_X86_SWITCHER = "x86_support";
    private static String TTNET_DEBUG_SETTING = "ttnet_debug_setting";

    public DebugSetting() {
    }

    public static boolean isLogOpen(Context r100) {
        return "true".equals(getSharePref(r100, KEY_LOG_SWITCHER));
    }

    public static boolean isX86Support(Context r100) {
        return "true".equals(getSharePref(r100, KEY_X86_SWITCHER));
    }

    private static String getSharePref(Context r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getSharedPreferences(TTNET_DEBUG_SETTING, 0).getString(r101, null);
    }

    public static void logSwitcher(Context r100, boolean r101) {
        putSharePref(r100, KEY_LOG_SWITCHER, String.valueOf(r101));
    }

    public static void x86Support(Context r100, boolean r101) {
        putSharePref(r100, KEY_X86_SWITCHER, String.valueOf(r101));
    }

    private static void putSharePref(Context r100, String r101, String r102) {
        if (r100 == null) goto L5;
        SharedPreferences.Editor r103 = r100.getSharedPreferences(TTNET_DEBUG_SETTING, 0).edit();
        r103.putString(r101, r102);
        r103.apply();
        return;
    }
}

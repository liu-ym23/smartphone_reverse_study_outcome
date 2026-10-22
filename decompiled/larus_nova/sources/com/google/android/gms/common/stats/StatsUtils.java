package com.google.android.gms.common.stats;

import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes23.dex */
public class StatsUtils {
    public StatsUtils() {
    }

    public static String getEventKey(PowerManager.WakeLock r100, String r101) {
        String r102 = String.valueOf((Process.myPid() << 32) | ((long) System.identityHashCode(r100)));
        if (true != TextUtils.isEmpty(r101)) goto L6;
        r101 = "";
    L6:
        return String.valueOf(r102).concat(String.valueOf(r101));
    }
}

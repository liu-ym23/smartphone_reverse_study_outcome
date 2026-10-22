package com.samsung.sdk.sperf;

import android.content.Context;

/* JADX INFO: loaded from: classes34.dex */
public class SPerf {
    private static SPerfManager sPerfManager;

    private SPerf() {
    }

    public static int getVersionCode() {
        return 1;
    }

    public static String getVersionName() {
        return "v1.0.0";
    }

    public static boolean initialize(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Boost.init() == true) goto L8;
        return false;
    L8:
        SPerfManager r101 = SPerfManager.createInstance(r100);
        sPerfManager = r101;
        if (r101 != null) goto L11;
        return false;
    L11:
        return true;
    }

    private static boolean isFeatureEnabled(int r100) {
        if (sPerfManager == null) goto L6;
        return true;
    L6:
        return false;
    }

    public static void setDebugModeEnabled(boolean r100) {
        SPerfUtil.setDebug(r100);
    }
}

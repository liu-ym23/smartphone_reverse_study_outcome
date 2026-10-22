package com.ss.ttvideoengine.utils;

import android.os.Build;

/* JADX INFO: loaded from: classes35.dex */
public class DeviceUtil {
    public static String sBoard;
    public static String sHardware;

    public DeviceUtil() {
    }

    public static String getDeviceBoard() {
    L6:
        sBoard = null;
    L8:
        return sBoard;
    L3:
        if (sBoard != null) goto L8;
        sBoard = Build.BOARD;     // Catch: Throwable -> L6
        goto L8
    }

    public static String getDeviceHardware() {
    L6:
        sHardware = null;
    L8:
        return sHardware;
    L3:
        if (sHardware != null) goto L8;
        sHardware = Build.HARDWARE;     // Catch: Throwable -> L6
        goto L8
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }
}

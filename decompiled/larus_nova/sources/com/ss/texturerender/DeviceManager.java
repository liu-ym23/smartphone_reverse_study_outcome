package com.ss.texturerender;

import android.os.Build;

/* JADX INFO: loaded from: classes40.dex */
public class DeviceManager {
    private static int mIsVRDevice = -1;

    public DeviceManager() {
    }

    public static boolean isVRDevice() {
        if (mIsVRDevice >= 0) goto L6;
        mIsVRDevice = Build.MANUFACTURER.equalsIgnoreCase("Pico") ? 1 : 0;
    L6:
        if (mIsVRDevice == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public static void setDeviceType(int r100) {
        mIsVRDevice = r100;
    }
}

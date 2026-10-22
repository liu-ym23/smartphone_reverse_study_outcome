package com.ss.ttm.utils;

import android.os.Build;

/* JADX INFO: loaded from: classes40.dex */
public final class Util {
    public static final String BARND = null;
    public static final String DEVICE = null;
    public static final String DEVICE_DEBUG_INFO = null;
    public static final String HARDWARE = null;
    public static final String MANUFACTURER = null;
    public static final String MODEL = null;
    public static final int SDK_INT = 0;

    public Util() {
    }

    static {
        int r100 = Build.VERSION.SDK_INT;
        SDK_INT = r100;
        String r101 = Build.DEVICE;
        DEVICE = r101;
        String r102 = Build.MANUFACTURER;
        MANUFACTURER = r102;
        String r103 = Build.MODEL;
        MODEL = r103;
        HARDWARE = Build.HARDWARE;
        BARND = Build.BRAND;
        DEVICE_DEBUG_INFO = r101 + ", " + r103 + ", " + r102 + ", " + r100;
    }
}

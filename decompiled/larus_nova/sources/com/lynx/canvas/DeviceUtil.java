package com.lynx.canvas;

import android.os.Build;
import java.util.Arrays;

/* JADX INFO: loaded from: classes32.dex */
public class DeviceUtil {
    private static final String sDeviceModel = null;
    private static final String sManufacturer = null;
    private static final boolean sTextureDestroyWorkaround = false;

    public DeviceUtil() {
    }

    static {
        sManufacturer = Build.MANUFACTURER.toLowerCase();
        String r100 = Build.MODEL.toLowerCase();
        sDeviceModel = r100;
        sTextureDestroyWorkaround = Arrays.asList(new String[]{"m6 note", "m721c"}).contains(r100);
    }

    public static boolean needTextureDestroyWorkaround() {
        return sTextureDestroyWorkaround;
    }
}

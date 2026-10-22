package com.bytedance.unitm.util;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;

/* JADX INFO: loaded from: classes22.dex */
public class RomUtil {
    public static final int ROM_TYPE_HONOR = 6;
    public static final int ROM_TYPE_HW = 1;
    public static final int ROM_TYPE_OPPO = 2;
    public static final int ROM_TYPE_SAMSUNG = 5;
    public static final int ROM_TYPE_VIVO = 3;
    public static final int ROM_TYPE_XIAOMI = 4;
    public static int UNKNOWN;

    public RomUtil() {
    }

    public static int getRomType() {
        int r100 = UNKNOWN;
        if (isOppoRom() == false) goto L6;
        r100 = 2;
    L8:
        TLog.i("current rom type:" + r100);
        return r100;
    L6:
        if (isVivoRom() == false) goto L8;
        r100 = 3;
        goto L8
    }

    public static boolean isOppoRom() {
        String r100 = SystemProperties.get("ro.product.brand", "");
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.toLowerCase().contains(AppConstants.CHANNEL_OPPO) == false) goto L7;
        return true;
    }

    public static boolean isVivoRom() {
        String r100 = SystemProperties.get("ro.vivo.os.name", "");
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.toLowerCase().contains("funtouch") == false) goto L7;
        return true;
    }
}

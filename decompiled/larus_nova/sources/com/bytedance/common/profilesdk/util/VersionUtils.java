package com.bytedance.common.profilesdk.util;

import android.os.Build;

/* JADX INFO: loaded from: classes15.dex */
public class VersionUtils {
    public static boolean isN() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 != 24) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 25) goto L8;
        return false;
    }

    public static boolean isO() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 != 26) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 27) goto L8;
        return false;
    }

    public static boolean isP() {
        if (Build.VERSION.SDK_INT != 28) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isQ() {
        if (Build.VERSION.SDK_INT != 29) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isR() {
        if (Build.VERSION.SDK_INT != 30) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean supportLegacySecondaryProfile() {
        if (Build.VERSION.SDK_INT != 26) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isNOP() {
        if (isN() == false) goto L5;
    L10:
        return true;
    L5:
        if (isO() == true) goto L10;
        if (isP() == true) goto L10;
        return false;
    }

    public static boolean isNOPQR() {
        if (isN() == false) goto L5;
    L14:
        return true;
    L5:
        if (isO() == true) goto L14;
        if (isP() == true) goto L14;
        if (isQ() == true) goto L14;
        if (isR() == true) goto L14;
        return false;
    }

    public static boolean isOPQR() {
        if (isO() == false) goto L5;
    L12:
        return true;
    L5:
        if (isP() == true) goto L12;
        if (isQ() == true) goto L12;
        if (isR() == true) goto L12;
        return false;
    }

    public static boolean isPQR() {
        if (isP() == false) goto L5;
    L10:
        return true;
    L5:
        if (isQ() == true) goto L10;
        if (isR() == true) goto L10;
        return false;
    }

    public static boolean supportDex2oat() {
        return isNOP();
    }

    public static boolean supportProfman() {
        return isOPQR();
    }

    public static boolean supportSecondaryProfile() {
        return isOPQR();
    }

    public static boolean supportVersion() {
        return isNOPQR();
    }
}

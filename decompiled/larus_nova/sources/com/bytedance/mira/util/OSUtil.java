package com.bytedance.mira.util;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.ss.android.socialbase.appdownloader.util.RomUtils;

/* JADX INFO: loaded from: classes.dex */
public class OSUtil {
    public OSUtil() {
    }

    public static boolean isAndroidHHigher() {
        return true;
    }

    public static boolean isAndroidIHigher() {
        return true;
    }

    public static boolean isAndroidI_MR1Higher() {
        return true;
    }

    public static boolean isAndroidIceMr1Higher() {
        return false;
    }

    public static boolean isAndroidJ() {
        return false;
    }

    public static boolean isAndroidJLower() {
        return false;
    }

    public static boolean isAndroidJ_MR1Higher() {
        return true;
    }

    public static boolean isAndroidJ_MR2Higher() {
        return true;
    }

    public static boolean isAndroidKHigher() {
        return true;
    }

    public static boolean isAndroidKLower() {
        return false;
    }

    public static boolean isAndroidLHigher() {
        return true;
    }

    public static boolean isAndroidLLower() {
        return false;
    }

    public static boolean isAndroidBHigher() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 36) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 35) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean isAndroidJ_Q() {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAndroidLM() {
        if (Build.VERSION.SDK_INT > 23) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAndroidLN() {
        if (Build.VERSION.SDK_INT > 25) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAndroidLO() {
        if (Build.VERSION.SDK_INT > 27) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAndroidLP() {
        if (Build.VERSION.SDK_INT > 28) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAndroidL_M() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAndroidL_N() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAndroidMHigher() {
        if (Build.VERSION.SDK_INT <= 23) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAndroidMLower() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAndroidMOrHigher() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAndroidN() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 24) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 25) goto L7;
        return true;
    }

    public static boolean isAndroidNHigher() {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAndroidNMR1() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 24) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 25) goto L7;
        return true;
    }

    public static boolean isAndroidNOHigher() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 > 25) goto L9;
        if (r100 == 25) goto L6;
    L8:
        return false;
    L6:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L8;
    L9:
        return true;
    }

    public static boolean isAndroidNP() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 24) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 28) goto L7;
        return true;
    }

    public static boolean isAndroidN_MR1Higher() {
        if (Build.VERSION.SDK_INT <= 25) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAndroidO() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 26) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 27) goto L7;
        return true;
    }

    public static boolean isAndroidOHigher() {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAndroidOLower() {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAndroidPHigher() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 28) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 27) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean isAndroidQ() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 != 29) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 28) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean isAndroidQHigher() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 29) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 28) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean isAndroidRHigher() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 30) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 29) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean isAndroidS() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 != 31) goto L5;
    L12:
        return true;
    L5:
        if (r100 == 32) goto L12;
        if (r100 == 30) goto L9;
    L11:
        return false;
    L9:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L11;
        goto L11
    }

    public static boolean isAndroidSHigher() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 31) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 30) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean isAndroidTHigher() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 33) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 32) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean isAndroidUHigher() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 34) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 33) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean isGoogle() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "google");
    }

    public static boolean isHonor() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), RomUtils.BRAND_HONOR);
    }

    public static boolean isHtc() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "htc");
    }

    public static boolean isHuawei() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), RomUtils.BRAND_HUAWEI);
    }

    public static boolean isOppo() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), AppConstants.CHANNEL_OPPO);
    }

    public static boolean isSamsung() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), SmEditTextLeakOpt.SAMSUNG);
    }
}

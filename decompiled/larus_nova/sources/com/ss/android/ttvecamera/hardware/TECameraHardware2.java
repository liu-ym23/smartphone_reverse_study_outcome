package com.ss.android.ttvecamera.hardware;

import android.os.Build;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.ttvecamera.TELogUtils;

/* JADX INFO: loaded from: classes38.dex */
public class TECameraHardware2 {
    public static final int[] CameraHWLevelAndroid2VE = null;
    public static final int[] CameraHWLevelVE2Android = null;
    public static final int HW_CHECK_LEVEL_3 = 3;
    public static final int HW_CHECK_LEVEL_FULL = 2;
    public static final int HW_CHECK_LEVEL_LEGACY = 0;
    public static final int HW_CHECK_LEVEL_LIMITED = 1;
    private static final String TAG = "TECameraHardware2";

    static {
        CameraHWLevelVE2Android = new int[]{2, 0, 1, 3, 4};
        CameraHWLevelAndroid2VE = new int[]{1, 2, 0, 3, 4};
    }

    public TECameraHardware2() {
    }

    public static boolean isHWPlatform() {
        String r100 = Build.BRAND.toLowerCase();
        if (r100.equals(RomUtils.BRAND_HUAWEI) == false) goto L5;
        return true;
    L5:
        if (r100.equals(RomUtils.BRAND_HONOR) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isMTKPlatform() {
        if (Build.HARDWARE.toLowerCase().matches("mt[0-9]*") == false) goto L6;
        TELogUtils.d(TAG, "MTK Platform.");
        return true;
    L6:
        return false;
    }

    public static boolean isQCOMPlatform() {
        String r100 = Build.HARDWARE.toLowerCase();
        if (r100.equals("qcom") == false) goto L5;
    L9:
        TELogUtils.d(TAG, "QCOM Platform.");
        return true;
    L5:
        if (r100.matches("msm[0-9]*") == true) goto L9;
        return false;
    }

    public static boolean isSSPlatform() {
        if (Build.BRAND.toLowerCase().equals(SmEditTextLeakOpt.SAMSUNG) == false) goto L6;
        return true;
    L6:
        return false;
    }
}

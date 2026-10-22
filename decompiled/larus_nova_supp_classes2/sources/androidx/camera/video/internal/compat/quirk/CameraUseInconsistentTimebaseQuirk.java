package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class CameraUseInconsistentTimebaseQuirk implements Quirk {
    private static final Set<String> BUILD_HARDWARE_SET = null;
    private static final Set<String> BUILD_MODEL_SET = null;
    private static final Set<String> BUILD_SOC_MODEL_SET = null;

    public CameraUseInconsistentTimebaseQuirk() {
    }

    static {
        BUILD_HARDWARE_SET = new HashSet(Arrays.asList(new String[]{"samsungexynos7570", "samsungexynos7870", "qcom"}));
        BUILD_SOC_MODEL_SET = new HashSet(Arrays.asList(new String[]{"sm4350", "sm6375", "sm7325"}));
        BUILD_MODEL_SET = new HashSet(Arrays.asList(new String[]{"m2007j20cg", "m2007j20ct"}));
    }

    private static boolean isAffectedModel() {
        return BUILD_MODEL_SET.contains(Build.MODEL.toLowerCase());
    }

    private static boolean isAffectedSamsungDevice() {
        if ("SAMSUNG".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if (BUILD_HARDWARE_SET.contains(Build.HARDWARE.toLowerCase()) == false) goto L7;
        return true;
    }

    private static boolean usesAffectedSoc() {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
    L7:
        return false;
    L5:
        if (BUILD_SOC_MODEL_SET.contains(Build.SOC_MODEL.toLowerCase()) == false) goto L7;
        return true;
    }

    public static boolean load() {
        if (usesAffectedSoc() == false) goto L5;
    L10:
        return true;
    L5:
        if (isAffectedSamsungDevice() == true) goto L10;
        if (isAffectedModel() == true) goto L10;
        return false;
    }
}

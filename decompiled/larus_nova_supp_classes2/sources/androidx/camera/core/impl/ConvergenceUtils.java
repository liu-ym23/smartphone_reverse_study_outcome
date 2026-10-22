package androidx.camera.core.impl;

import androidx.camera.core.Logger;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ConvergenceUtils {
    private static final Set<CameraCaptureMetaData.AeState> AE_CONVERGED_STATE_SET = null;
    private static final Set<CameraCaptureMetaData.AeState> AE_TORCH_AS_FLASH_CONVERGED_STATE_SET = null;
    private static final Set<CameraCaptureMetaData.AfState> AF_CONVERGED_STATE_SET = null;
    private static final Set<CameraCaptureMetaData.AwbState> AWB_CONVERGED_STATE_SET = null;
    private static final String TAG = "ConvergenceUtils";

    static {
        AF_CONVERGED_STATE_SET = Collections.unmodifiableSet(EnumSet.of(CameraCaptureMetaData.AfState.PASSIVE_FOCUSED, CameraCaptureMetaData.AfState.PASSIVE_NOT_FOCUSED, CameraCaptureMetaData.AfState.LOCKED_FOCUSED, CameraCaptureMetaData.AfState.LOCKED_NOT_FOCUSED));
        AWB_CONVERGED_STATE_SET = Collections.unmodifiableSet(EnumSet.of(CameraCaptureMetaData.AwbState.CONVERGED, CameraCaptureMetaData.AwbState.UNKNOWN));
        CameraCaptureMetaData.AeState r0 = CameraCaptureMetaData.AeState.CONVERGED;
        CameraCaptureMetaData.AeState r1 = CameraCaptureMetaData.AeState.FLASH_REQUIRED;
        CameraCaptureMetaData.AeState r2 = CameraCaptureMetaData.AeState.UNKNOWN;
        Set<CameraCaptureMetaData.AeState> r3 = Collections.unmodifiableSet(EnumSet.of(r0, r1, r2));
        AE_CONVERGED_STATE_SET = r3;
        EnumSet r4 = EnumSet.copyOf(r3);
        r4.remove(r1);
        r4.remove(r2);
        AE_TORCH_AS_FLASH_CONVERGED_STATE_SET = Collections.unmodifiableSet(r4);
    }

    private ConvergenceUtils() {
    }

    public static boolean is3AConverged(CameraCaptureResult r6, boolean r7) {
        if (r6.getAfMode() != CameraCaptureMetaData.AfMode.OFF) goto L5;
    L10:
        boolean r0 = true;
    L12:
        if (r6.getAeMode() != CameraCaptureMetaData.AeMode.OFF) goto L14;
        boolean r1 = true;
    L15:
        if (r7 == false) goto L22;
        if (r1 == false) goto L18;
    L21:
        boolean r8 = true;
    L27:
        if (r6.getAwbMode() != CameraCaptureMetaData.AwbMode.OFF) goto L29;
        boolean r2 = true;
    L30:
        if (r2 == false) goto L32;
    L35:
        boolean r3 = true;
    L36:
        Logger.d(TAG, "checkCaptureResult, AE=" + r6.getAeState() + " AF =" + r6.getAfState() + " AWB=" + r6.getAwbState());
        if (r0 == false) goto L42;
        if (r8 == false) goto L43;
        if (r3 == false) goto L44;
        return true;
    L44:
        return false;
    L43:
        return false;
    L42:
        return false;
    L32:
        if (AWB_CONVERGED_STATE_SET.contains(r6.getAwbState()) == true) goto L35;
        r3 = false;
        goto L36
    L29:
        r2 = false;
        goto L30
    L18:
        if (AE_TORCH_AS_FLASH_CONVERGED_STATE_SET.contains(r6.getAeState()) == true) goto L21;
    L20:
        r8 = false;
        goto L27
    L22:
        if (r1 == true) goto L21;
        if (AE_CONVERGED_STATE_SET.contains(r6.getAeState()) == false) goto L20;
    L14:
        r1 = false;
        goto L15
    L5:
        if (r6.getAfMode() == CameraCaptureMetaData.AfMode.UNKNOWN) goto L10;
        if (AF_CONVERGED_STATE_SET.contains(r6.getAfState()) == true) goto L10;
        r0 = false;
        goto L12
    }
}

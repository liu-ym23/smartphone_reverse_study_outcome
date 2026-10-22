package androidx.camera.core.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraValidator {
    private static final CameraSelector EXTERNAL_LENS_FACING = null;
    private static final String TAG = "CameraValidator";

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static int getDeviceId(Context r0) {
            return r0.getDeviceId();
        }
    }

    public static class CameraIdListIncorrectException extends Exception {
        private int mAvailableCameraCount;

        public int getAvailableCameraCount() {
            return this.mAvailableCameraCount;
        }

        public CameraIdListIncorrectException(String r1, int r2, Throwable r3) {
            super(r1, r3);
            this.mAvailableCameraCount = r2;
        }
    }

    static {
        EXTERNAL_LENS_FACING = new CameraSelector.Builder().requireLensFacing(2).build();
    }

    private CameraValidator() {
    }

    public static void validateCameras(Context r7, CameraRepository r8, CameraSelector r9) throws CameraIdListIncorrectException {
        int r2 = 0;
        IllegalArgumentException r3 = null;
        if (Build.VERSION.SDK_INT >= 34) goto L5;
    L12:
        if (r9 != null) goto L52;
        Integer r0 = null;
    L21:
        Logger.d(TAG, "Verifying camera lens facing on " + Build.DEVICE + ", lensFacingInteger: " + r0);
        PackageManager r10 = r7.getPackageManager();
    L30:
        e = move-exception;
        r3 = e;
        Logger.w(TAG, "Camera LENS_FACING_BACK verification failed", r3);
    L54:
    L39:
        e = move-exception;
        r3 = e;
        Logger.w(TAG, "Camera LENS_FACING_FRONT verification failed", r3);
    L48:
        EXTERNAL_LENS_FACING.select(r8.getCameras());     // Catch: IllegalArgumentException -> L43
        Logger.d(TAG, "Found a LENS_FACING_EXTERNAL camera");     // Catch: IllegalArgumentException -> L43
        r2 = r2 + 1;
    L44:
        if (r3 != null) goto L46;
        return;
    L46:
        Logger.e(TAG, "Camera LensFacing verification failed, existing cameras: " + r8.getCameras());
        throw new CameraIdListIncorrectException("Expected camera missing from device.", r2, r3);
    L33:
        if (r10.hasSystemFeature("android.hardware.camera.front") == false) goto L48;
        if (r9 != null) goto L36;
    L37:
        CameraSelector.DEFAULT_FRONT_CAMERA.select(r8.getCameras());     // Catch: IllegalArgumentException -> L39
        r2 = r2 + 1;
        goto L48
    L36:
        if (r0.intValue() != 0) goto L48;
    L23:
        if (r10.hasSystemFeature("android.hardware.camera") == false) goto L54;
        if (r9 != null) goto L27;
    L28:
        CameraSelector.DEFAULT_BACK_CAMERA.select(r8.getCameras());     // Catch: IllegalArgumentException -> L30
        r2 = 1;
        goto L54
    L27:
        if (r0.intValue() != 1) goto L54;
    L52:
        r0 = r9.getLensFacing();     // Catch: IllegalStateException -> L17
        if (r0 != null) goto L21;
        Logger.w(TAG, "No lens facing info in the availableCamerasSelector, don't verify the camera lens facing.");     // Catch: IllegalStateException -> L17
        return;
    L17:
        e = move-exception;
        Logger.e(TAG, "Cannot get lens facing from the availableCamerasSelector don't verify the camera lens facing.", e);
        return;
    L5:
        if (Api34Impl.getDeviceId(r7) == 0) goto L12;
        LinkedHashSet<CameraInternal> r11 = r8.getCameras();
        if (r11.isEmpty() == true) goto L11;
        Logger.d(TAG, "Virtual device with ID: " + Api34Impl.getDeviceId(r7) + " has " + r11.size() + " cameras. Skipping validation.");
        return;
    L11:
        throw new CameraIdListIncorrectException("No cameras available", 0, null);
    }
}

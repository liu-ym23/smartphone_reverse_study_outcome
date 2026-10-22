package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class CameraAccessExceptionCompat extends Exception {
    public static final int CAMERA_CHARACTERISTICS_CREATION_ERROR = 10002;
    public static final int CAMERA_DEPRECATED_HAL = 1000;
    public static final int CAMERA_DISABLED = 1;
    public static final int CAMERA_DISCONNECTED = 2;
    public static final int CAMERA_ERROR = 3;
    public static final int CAMERA_IN_USE = 4;
    public static final int CAMERA_UNAVAILABLE_DO_NOT_DISTURB = 10001;
    static final Set<Integer> COMPAT_ERRORS = null;
    public static final int MAX_CAMERAS_IN_USE = 5;
    static final Set<Integer> PLATFORM_ERRORS = null;
    private final CameraAccessException mCameraAccessException;
    private final int mReason;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AccessError {
    }

    private static String getDefaultMessage(int r1) {
        if (r1 != 1) goto L5;
        return "The camera is disabled due to a device policy, and cannot be opened.";
    L5:
        if (r1 != 2) goto L7;
        return "The camera device is removable and has been disconnected from the Android device, or the camera service has shut down the connection due to a higher-priority access request for the camera device.";
    L7:
        if (r1 != 3) goto L9;
        return "The camera device is currently in the error state; no further calls to it will succeed.";
    L9:
        if (r1 != 4) goto L11;
        return "The camera device is in use already";
    L11:
        if (r1 != 5) goto L13;
        return "The system-wide limit for number of open cameras has been reached, and more camera devices cannot be opened until previous instances are closed.";
    L13:
        if (r1 != 10001) goto L15;
        return "Some API 28 devices cannot access the camera when the device is in \"Do Not Disturb\" mode. The camera will not be accessible until \"Do Not Disturb\" mode is disabled.";
    L15:
        if (r1 == 10002) goto L18;
        return null;
    L18:
        return "Failed to create CameraCharacteristics.";
    }

    private static String getProblemString(int r1) {
        if (r1 != 1) goto L5;
        return "CAMERA_DISABLED";
    L5:
        if (r1 != 2) goto L7;
        return "CAMERA_DISCONNECTED";
    L7:
        if (r1 != 3) goto L9;
        return "CAMERA_ERROR";
    L9:
        if (r1 != 4) goto L11;
        return "CAMERA_IN_USE";
    L11:
        if (r1 != 5) goto L13;
        return "MAX_CAMERAS_IN_USE";
    L13:
        if (r1 != 1000) goto L15;
        return "CAMERA_DEPRECATED_HAL";
    L15:
        if (r1 != 10001) goto L17;
        return "CAMERA_UNAVAILABLE_DO_NOT_DISTURB";
    L17:
        if (r1 == 10002) goto L19;
        return "<UNKNOWN ERROR>";
    L19:
        return "CAMERA_CHARACTERISTICS_CREATION_ERROR";
    }

    static {
        PLATFORM_ERRORS = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{4, 5, 1, 2, 3})));
        COMPAT_ERRORS = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(CAMERA_UNAVAILABLE_DO_NOT_DISTURB), Integer.valueOf(CAMERA_CHARACTERISTICS_CREATION_ERROR)})));
    }

    public final int getReason() {
        return this.mReason;
    }

    public CameraAccessException toCameraAccessException() {
        return this.mCameraAccessException;
    }

    public CameraAccessExceptionCompat(int r3) {
        super(getDefaultMessage(r3));
        this.mReason = r3;
        if (PLATFORM_ERRORS.contains(Integer.valueOf(r3)) == false) goto L5;
        CameraAccessException r0 = new CameraAccessException(r3);
    L6:
        this.mCameraAccessException = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static CameraAccessExceptionCompat toCameraAccessExceptionCompat(CameraAccessException r1) {
        if (r1 == null) goto L6;
        return new CameraAccessExceptionCompat(r1);
    L6:
        throw new NullPointerException("cameraAccessException should not be null");
    }

    private CameraAccessExceptionCompat(CameraAccessException r3) {
        super(r3.getMessage(), r3.getCause());
        this.mReason = r3.getReason();
        this.mCameraAccessException = r3;
    }

    public CameraAccessExceptionCompat(int r3, String r4) {
        super(getCombinedMessage(r3, r4));
        this.mReason = r3;
        if (PLATFORM_ERRORS.contains(Integer.valueOf(r3)) == false) goto L5;
        CameraAccessException r0 = new CameraAccessException(r3, r4);
    L6:
        this.mCameraAccessException = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    private static String getCombinedMessage(int r3, String r4) {
        return String.format("%s (%d): %s", new Object[]{getProblemString(r3), Integer.valueOf(r3), r4});
    }

    public CameraAccessExceptionCompat(int r3, Throwable r4) {
        super(getDefaultMessage(r3), r4);
        this.mReason = r3;
        CameraAccessException r1 = null;
        if (PLATFORM_ERRORS.contains(Integer.valueOf(r3)) == false) goto L5;
        r1 = new CameraAccessException(r3, null, r4);
    L5:
        this.mCameraAccessException = r1;
    }

    public CameraAccessExceptionCompat(int r3, String r4, Throwable r5) {
        super(getCombinedMessage(r3, r4), r5);
        this.mReason = r3;
        if (PLATFORM_ERRORS.contains(Integer.valueOf(r3)) == false) goto L5;
        CameraAccessException r0 = new CameraAccessException(r3, r4, r5);
    L6:
        this.mCameraAccessException = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }
}

package androidx.camera.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class CameraUnavailableException extends Exception {
    public static final int CAMERA_DISABLED = 1;
    public static final int CAMERA_DISCONNECTED = 2;
    public static final int CAMERA_ERROR = 3;
    public static final int CAMERA_IN_USE = 4;
    public static final int CAMERA_MAX_IN_USE = 5;
    public static final int CAMERA_UNAVAILABLE_DO_NOT_DISTURB = 6;
    public static final int CAMERA_UNKNOWN_ERROR = 0;
    private final int mReason;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Reason {
    }

    public int getReason() {
        return this.mReason;
    }

    public CameraUnavailableException(int r1) {
        this.mReason = r1;
    }

    public CameraUnavailableException(int r1, String r2) {
        super(r2);
        this.mReason = r1;
    }

    public CameraUnavailableException(int r1, Throwable r2) {
        super(r2);
        this.mReason = r1;
    }

    public CameraUnavailableException(int r1, String r2, Throwable r3) {
        super(r2, r3);
        this.mReason = r1;
    }
}

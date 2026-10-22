package com.facebook.imagepipeline.common;

import com.facebook.common.util.HashCodeUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes23.dex */
public class RotationOptions {
    private static final int DISABLE_ROTATION = -2;
    public static final int NO_ROTATION = 0;
    public static final int ROTATE_180 = 180;
    public static final int ROTATE_270 = 270;
    public static final int ROTATE_90 = 90;
    private static final RotationOptions ROTATION_OPTIONS_AUTO_ROTATE = null;
    private static final RotationOptions ROTATION_OPTIONS_DISABLE_ROTATION = null;
    private static final RotationOptions ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME = null;
    private static final int USE_EXIF_ROTATION_ANGLE = -1;
    private final boolean mDeferUntilRendered;
    private final int mRotation;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RotationAngle {
    }

    public String toString() {
        return String.format(null, "%d defer:%b", new Object[]{Integer.valueOf(this.mRotation), Boolean.valueOf(this.mDeferUntilRendered)});
    }

    static {
        ROTATION_OPTIONS_AUTO_ROTATE = new RotationOptions(-1, false);
        ROTATION_OPTIONS_DISABLE_ROTATION = new RotationOptions(-2, false);
        ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME = new RotationOptions(-1, true);
    }

    public int hashCode() {
        return HashCodeUtil.hashCode(Integer.valueOf(this.mRotation), Boolean.valueOf(this.mDeferUntilRendered));
    }

    public boolean rotationEnabled() {
        if (this.mRotation == (-2)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean useImageMetadata() {
        if (this.mRotation != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public int getForcedAngle() {
        if (useImageMetadata() == true) goto L7;
        return this.mRotation;
    L7:
        throw new IllegalStateException("Rotation is set to use EXIF");
    }

    public static RotationOptions autoRotate() {
        return ROTATION_OPTIONS_AUTO_ROTATE;
    }

    public static RotationOptions autoRotateAtRenderTime() {
        return ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME;
    }

    public static RotationOptions disableRotation() {
        return ROTATION_OPTIONS_DISABLE_ROTATION;
    }

    public boolean canDeferUntilRendered() {
        return this.mDeferUntilRendered;
    }

    public static RotationOptions forceRotation(int r100) {
        return new RotationOptions(r100, false);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof RotationOptions) == true) goto L8;
        return false;
    L8:
        RotationOptions r101 = (RotationOptions) r100;
        if (this.mRotation == r101.mRotation) goto L11;
    L13:
        return false;
    L11:
        if (this.mDeferUntilRendered != r101.mDeferUntilRendered) goto L13;
        return true;
    }

    private RotationOptions(int r100, boolean r101) {
        this.mRotation = r100;
        this.mDeferUntilRendered = r101;
    }
}

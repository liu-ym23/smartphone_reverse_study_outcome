package androidx.camera.core.impl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraMode {
    public static final int CONCURRENT_CAMERA = 1;
    public static final int DEFAULT = 0;
    public static final int ULTRA_HIGH_RESOLUTION_CAMERA = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public static String toLabelString(int r1) {
        if (r1 != 1) goto L5;
        return "CONCURRENT_CAMERA";
    L5:
        if (r1 == 2) goto L8;
        return "DEFAULT";
    L8:
        return "ULTRA_HIGH_RESOLUTION_CAMERA";
    }

    private CameraMode() {
    }
}

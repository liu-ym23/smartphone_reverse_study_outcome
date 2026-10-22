package androidx.camera.core;

import androidx.camera.core.impl.CameraConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface Camera {

    /* JADX INFO: renamed from: androidx.camera.core.Camera$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isUseCasesCombinationSupported(Camera r0, boolean r1, UseCase... r2) {
            return true;
        }

        public static boolean $default$isUseCasesCombinationSupported(Camera r1, UseCase... r2) {
            return r1.isUseCasesCombinationSupported(true, r2);
        }

        public static boolean $default$isUseCasesCombinationSupportedByFramework(Camera r1, UseCase... r2) {
            return r1.isUseCasesCombinationSupported(false, r2);
        }
    }

    CameraControl getCameraControl();

    CameraInfo getCameraInfo();

    CameraConfig getExtendedConfig();

    boolean isUseCasesCombinationSupported(boolean r1, UseCase... r2);

    boolean isUseCasesCombinationSupported(UseCase... r1);

    boolean isUseCasesCombinationSupportedByFramework(UseCase... r1);
}

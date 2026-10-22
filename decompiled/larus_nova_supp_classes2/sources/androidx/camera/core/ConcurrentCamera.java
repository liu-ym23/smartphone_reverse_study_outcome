package androidx.camera.core;

import androidx.lifecycle.LifecycleOwner;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ConcurrentCamera {
    private List<Camera> mCameras;

    public static final class SingleCameraConfig {
        private CameraSelector mCameraSelector;
        private LayoutSettings mLayoutSettings;
        private LifecycleOwner mLifecycleOwner;
        private UseCaseGroup mUseCaseGroup;

        public CameraSelector getCameraSelector() {
            return this.mCameraSelector;
        }

        public LayoutSettings getLayoutSettings() {
            return this.mLayoutSettings;
        }

        public LifecycleOwner getLifecycleOwner() {
            return this.mLifecycleOwner;
        }

        public UseCaseGroup getUseCaseGroup() {
            return this.mUseCaseGroup;
        }

        public SingleCameraConfig(CameraSelector r2, UseCaseGroup r3, LifecycleOwner r4) {
            this(r2, r3, LayoutSettings.DEFAULT, r4);
        }

        public SingleCameraConfig(CameraSelector r1, UseCaseGroup r2, LayoutSettings r3, LifecycleOwner r4) {
            this.mCameraSelector = r1;
            this.mUseCaseGroup = r2;
            this.mLayoutSettings = r3;
            this.mLifecycleOwner = r4;
        }
    }

    public List<Camera> getCameras() {
        return this.mCameras;
    }

    public ConcurrentCamera(List<Camera> r1) {
        this.mCameras = r1;
    }
}

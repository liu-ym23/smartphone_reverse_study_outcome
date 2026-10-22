package com.ss.bytertc.base.media.camera;

import android.content.Context;
import android.graphics.Matrix;
import android.view.WindowManager;
import com.byted.cast.common.bean.State;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.realx.video.TextureBufferImpl;
import com.bytedance.realx.video.VideoFrame;

/* JADX INFO: loaded from: classes40.dex */
public interface CameraSession {

    /* JADX INFO: renamed from: com.ss.bytertc.base.media.camera.CameraSession$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int getDeviceUIOrientation(Context r100) {
            int r101 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getRotation();
            if (r101 == 1) goto L15;
            if (r101 == 2) goto L13;
            if (r101 == 3) goto L11;
            return UIDeviceOrientation.Portrait.value();
        L11:
            return UIDeviceOrientation.LandscapeLeft.value();
        L13:
            return UIDeviceOrientation.PortraitUpsideDown.value();
        L15:
            return UIDeviceOrientation.LandscapeRight.value();
        }

        public static VideoFrame.TextureBuffer createTextureBufferWithModifiedTransformMatrix(TextureBufferImpl r100, boolean r101, int r102) {
            Matrix r103 = new Matrix();
            r103.preTranslate(0.5f, 0.5f);
            if (r101 == false) goto L5;
            r103.preScale(-1.0f, 1.0f);
        L5:
            r103.preRotate(r102);
            r103.preTranslate(-0.5f, -0.5f);
            return r100.applyTransformMatrix(r103, r100.getWidth(), r100.getHeight());
        }
    }

    public interface CreateSessionCallback {
        void onDone(CameraSession r100);

        void onFailure(FailureType r100, String r101);
    }

    public interface Events {
        void onCameraClosed(CameraSession r100);

        void onCameraConfig(int r100, int r101, CameraEnumerationAndroid.CaptureFormat.FramerateRange r102);

        void onCameraDisconnected(CameraSession r100);

        void onCameraError(CameraSession r100, String r101);

        void onCameraOpening();

        void onFrameCaptured(CameraSession r100, VideoFrame r101);
    }

    public static final enum FailureType extends Enum<FailureType> {
        private static final /* synthetic */ FailureType[] $VALUES = null;
        public static final FailureType DISCONNECTED = null;
        public static final FailureType ERROR = null;

        static {
            FailureType r100 = new FailureType("ERROR", 0);
            ERROR = r100;
            FailureType r101 = new FailureType(State.DISCONNECTED, 1);
            DISCONNECTED = r101;
            $VALUES = new FailureType[]{r100, r101};
        }

        public static FailureType[] values() {
            return (FailureType[]) $VALUES.clone();
        }

        public static FailureType valueOf(String r100) {
            return (FailureType) r27.a.a(FailureType.class, r100);
        }

        private FailureType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum UIDeviceOrientation extends Enum<UIDeviceOrientation> {
        private static final /* synthetic */ UIDeviceOrientation[] $VALUES = null;
        public static final UIDeviceOrientation LandscapeLeft = null;
        public static final UIDeviceOrientation LandscapeRight = null;
        public static final UIDeviceOrientation Portrait = null;
        public static final UIDeviceOrientation PortraitUpsideDown = null;
        private int value;

        static {
            UIDeviceOrientation r100 = new UIDeviceOrientation("Portrait", 0, 0);
            Portrait = r100;
            UIDeviceOrientation r101 = new UIDeviceOrientation("LandscapeLeft", 1, 90);
            LandscapeLeft = r101;
            UIDeviceOrientation r102 = new UIDeviceOrientation("PortraitUpsideDown", 2, 180);
            PortraitUpsideDown = r102;
            UIDeviceOrientation r103 = new UIDeviceOrientation("LandscapeRight", 3, 270);
            LandscapeRight = r103;
            $VALUES = new UIDeviceOrientation[]{r100, r101, r102, r103};
        }

        public static UIDeviceOrientation[] values() {
            return (UIDeviceOrientation[]) $VALUES.clone();
        }

        public int value() {
            return this.value;
        }

        public static UIDeviceOrientation valueOf(String r100) {
            return (UIDeviceOrientation) r27.a.a(UIDeviceOrientation.class, r100);
        }

        private UIDeviceOrientation(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    int enableCameraAutoExposureFaceMode(boolean r100);

    int enableFollowGravity(boolean r100);

    float getCameraZoomMaxRatio();

    int getDeviceOrientation();

    boolean isCameraExposurePointSupported();

    boolean isCameraFocusPointSupported();

    boolean isCameraTorchSupported();

    boolean isCameraZoomSupported();

    int setCameraExposureCompensation(float r100);

    int setCameraExposurePoint(float r100, float r101);

    int setCameraFocusPoint(float r100, float r101);

    int setCameraZoomRatio(float r100);

    void setOrientationMode(CameraVideoCapturer.ORIENTATION_MODE r100);

    void stop();

    void turnOffFlashLight();

    void turnOnFlashLight();
}

package com.ss.bytertc.base.media.camera;

import android.media.MediaRecorder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.bytertc.base.media.SurfaceTextureHelper;
import com.ss.bytertc.base.media.VideoCapturer;

/* JADX INFO: loaded from: classes40.dex */
public interface CameraVideoCapturer extends VideoCapturer {

    /* JADX INFO: renamed from: com.ss.bytertc.base.media.camera.CameraVideoCapturer$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$removeMediaRecorderFromCamera(CameraVideoCapturer r100, MediaRecorderHandler r101) {
            throw new UnsupportedOperationException("Deprecated and not implemented.");
        }

        public static void $default$addMediaRecorderToCamera(CameraVideoCapturer r100, MediaRecorder r101, MediaRecorderHandler r102) {
            throw new UnsupportedOperationException("Deprecated and not implemented.");
        }
    }

    public interface CameraEventsHandler {
        void onCameraClosed();

        void onCameraConfig(int r100, int r101, CameraEnumerationAndroid.CaptureFormat.FramerateRange r102);

        void onCameraDisconnected();

        void onCameraError(String r100);

        void onCameraFreezed(String r100);

        void onCameraOpening(String r100);

        void onFirstFrameAvailable();
    }

    public static class CameraStatistics {
        private static final int CAMERA_FREEZE_REPORT_TIMOUT_MS = 4000;
        private static final int CAMERA_OBSERVER_PERIOD_MS = 2000;
        private static final String TAG = "CameraStatistics";
        private final Runnable cameraObserver;
        private final CameraEventsHandler eventsHandler;
        private int frameCount;
        private int freezePeriodCount;
        private final SurfaceTextureHelper surfaceTextureHelper;

        public void release() {
            this.surfaceTextureHelper.getHandler().removeCallbacks(this.cameraObserver);
        }

        private void checkThread() {
            if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(this.surfaceTextureHelper.getHandler().getLooper())) goto L6;
            return;
        L6:
            throw new IllegalStateException("Wrong thread");
        }

        public void addFrame() {
            checkThread();
            this.frameCount++;
        }

        public static /* synthetic */ int access$000(CameraStatistics r100) {
            return r100.frameCount;
        }

        public static /* synthetic */ int access$100(CameraStatistics r100) {
            return r100.freezePeriodCount;
        }

        public static /* synthetic */ int access$104(CameraStatistics r100) {
            int r101 = r100.freezePeriodCount + 1;
            r100.freezePeriodCount = r101;
            return r101;
        }

        public static /* synthetic */ CameraEventsHandler access$200(CameraStatistics r100) {
            return r100.eventsHandler;
        }

        public static /* synthetic */ SurfaceTextureHelper access$300(CameraStatistics r100) {
            return r100.surfaceTextureHelper;
        }

        public CameraStatistics(SurfaceTextureHelper r100, CameraEventsHandler r101) {
            Runnable r102 = new AnonymousClass1(this);
            this.cameraObserver = r102;
            if (r100 == null) goto L7;
            this.surfaceTextureHelper = r100;
            this.eventsHandler = r101;
            this.frameCount = 0;
            this.freezePeriodCount = 0;
            r100.getHandler().postDelayed(r102, 2000);
            return;
        L7:
            throw new IllegalArgumentException("SurfaceTextureHelper is null");
        }

        public static /* synthetic */ int access$002(CameraStatistics r100, int r101) {
            r100.frameCount = r101;
            return r101;
        }

        public static /* synthetic */ int access$102(CameraStatistics r100, int r101) {
            r100.freezePeriodCount = r101;
            return r101;
        }
    }

    public interface CameraSwitchHandler {
        void onCameraSwitchDone(boolean r100);

        void onCameraSwitchError(String r100);
    }

    public interface MediaRecorderHandler {
        void onMediaRecorderError(String r100);

        void onMediaRecorderSuccess();
    }

    public static final enum ORIENTATION_MODE extends Enum<ORIENTATION_MODE> {
        private static final /* synthetic */ ORIENTATION_MODE[] $VALUES = null;
        public static final ORIENTATION_MODE ORIENTATION_MODE_ADAPTIVE = null;
        public static final ORIENTATION_MODE ORIENTATION_MODE_FIXED_LANDSCAPE = null;
        public static final ORIENTATION_MODE ORIENTATION_MODE_FIXED_PORTRAIT = null;
        private int value;

        static {
            ORIENTATION_MODE r100 = new ORIENTATION_MODE("ORIENTATION_MODE_ADAPTIVE", 0, 0);
            ORIENTATION_MODE_ADAPTIVE = r100;
            ORIENTATION_MODE r101 = new ORIENTATION_MODE("ORIENTATION_MODE_FIXED_LANDSCAPE", 1, 1);
            ORIENTATION_MODE_FIXED_LANDSCAPE = r101;
            ORIENTATION_MODE r102 = new ORIENTATION_MODE("ORIENTATION_MODE_FIXED_PORTRAIT", 2, 2);
            ORIENTATION_MODE_FIXED_PORTRAIT = r102;
            $VALUES = new ORIENTATION_MODE[]{r100, r101, r102};
        }

        public static ORIENTATION_MODE[] values() {
            return (ORIENTATION_MODE[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static ORIENTATION_MODE convertFromInt(int r100) {
            return values()[r100];
        }

        public static ORIENTATION_MODE valueOf(String r100) {
            return (ORIENTATION_MODE) r27.a.a(ORIENTATION_MODE.class, r100);
        }

        private ORIENTATION_MODE(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    void addMediaRecorderToCamera(MediaRecorder r100, MediaRecorderHandler r101);

    void removeMediaRecorderFromCamera(MediaRecorderHandler r100);

    void setOrientationMode(ORIENTATION_MODE r100);

    void switchCamera(CameraSwitchHandler r100);
}

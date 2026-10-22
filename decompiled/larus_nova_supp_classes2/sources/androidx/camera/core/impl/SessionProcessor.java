package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Size;
import androidx.camera.core.CameraInfo;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface SessionProcessor {

    /* JADX INFO: renamed from: androidx.camera.core.impl.SessionProcessor$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Pair $default$getRealtimeCaptureLatency(SessionProcessor r0) {
            return null;
        }

        public static int $default$startTrigger(SessionProcessor r0, Config r1, TagBundle r2, CaptureCallback r3) {
            return -1;
        }

        public static Set $default$getSupportedCameraOperations(SessionProcessor r0) {
            return Collections.emptySet();
        }

        public static Map $default$getSupportedPostviewSize(SessionProcessor r0, Size r1) {
            return Collections.emptyMap();
        }
    }

    public interface CaptureCallback {

        /* JADX INFO: renamed from: androidx.camera.core.impl.SessionProcessor$CaptureCallback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onCaptureCompleted(CaptureCallback r0, long r1, int r3, CameraCaptureResult r4) {
            }

            public static void $default$onCaptureFailed(CaptureCallback r0, int r1) {
            }

            public static void $default$onCaptureProcessProgressed(CaptureCallback r0, int r1) {
            }

            public static void $default$onCaptureProcessStarted(CaptureCallback r0, int r1) {
            }

            public static void $default$onCaptureSequenceAborted(CaptureCallback r0, int r1) {
            }

            public static void $default$onCaptureSequenceCompleted(CaptureCallback r0, int r1) {
            }

            public static void $default$onCaptureStarted(CaptureCallback r0, int r1, long r2) {
            }
        }

        void onCaptureCompleted(long r1, int r3, CameraCaptureResult r4);

        void onCaptureFailed(int r1);

        void onCaptureProcessProgressed(int r1);

        void onCaptureProcessStarted(int r1);

        void onCaptureSequenceAborted(int r1);

        void onCaptureSequenceCompleted(int r1);

        void onCaptureStarted(int r1, long r2);
    }

    void abortCapture(int r1);

    void deInitSession();

    Pair<Long, Long> getRealtimeCaptureLatency();

    Set<Integer> getSupportedCameraOperations();

    Map<Integer, List<Size>> getSupportedPostviewSize(Size r1);

    SessionConfig initSession(CameraInfo r1, OutputSurfaceConfiguration r2);

    void onCaptureSessionEnd();

    void onCaptureSessionStart(RequestProcessor r1);

    void setParameters(Config r1);

    int startCapture(boolean r1, TagBundle r2, CaptureCallback r3);

    int startRepeating(TagBundle r1, CaptureCallback r2);

    int startTrigger(Config r1, TagBundle r2, CaptureCallback r3);

    void stopRepeating();
}

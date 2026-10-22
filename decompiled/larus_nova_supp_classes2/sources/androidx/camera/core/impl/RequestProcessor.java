package androidx.camera.core.impl;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface RequestProcessor {

    public interface Callback {

        /* JADX INFO: renamed from: androidx.camera.core.impl.RequestProcessor$Callback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onCaptureBufferLost(Callback r0, Request r1, long r2, int r4) {
            }

            public static void $default$onCaptureCompleted(Callback r0, Request r1, CameraCaptureResult r2) {
            }

            public static void $default$onCaptureFailed(Callback r0, Request r1, CameraCaptureFailure r2) {
            }

            public static void $default$onCaptureProgressed(Callback r0, Request r1, CameraCaptureResult r2) {
            }

            public static void $default$onCaptureSequenceAborted(Callback r0, int r1) {
            }

            public static void $default$onCaptureSequenceCompleted(Callback r0, int r1, long r2) {
            }

            public static void $default$onCaptureStarted(Callback r0, Request r1, long r2, long r4) {
            }
        }

        void onCaptureBufferLost(Request r1, long r2, int r4);

        void onCaptureCompleted(Request r1, CameraCaptureResult r2);

        void onCaptureFailed(Request r1, CameraCaptureFailure r2);

        void onCaptureProgressed(Request r1, CameraCaptureResult r2);

        void onCaptureSequenceAborted(int r1);

        void onCaptureSequenceCompleted(int r1, long r2);

        void onCaptureStarted(Request r1, long r2, long r4);
    }

    public interface Request {
        Config getParameters();

        List<Integer> getTargetOutputConfigIds();

        int getTemplateId();
    }

    void abortCaptures();

    int setRepeating(Request r1, Callback r2);

    void stopRepeating();

    int submit(Request r1, Callback r2);

    int submit(List<Request> r1, Callback r2);
}

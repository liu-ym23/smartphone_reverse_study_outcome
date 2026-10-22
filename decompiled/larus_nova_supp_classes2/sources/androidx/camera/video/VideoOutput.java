package androidx.camera.video;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.ConstantObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface VideoOutput {

    /* JADX INFO: renamed from: androidx.camera.video.VideoOutput$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onSourceStateChanged(VideoOutput r0, SourceState r1) {
        }

        public static Observable $default$getMediaSpec(VideoOutput r0) {
            return ConstantObservable.withValue(null);
        }

        public static Observable $default$getStreamInfo(VideoOutput r0) {
            return StreamInfo.ALWAYS_ACTIVE_OBSERVABLE;
        }

        public static Observable $default$isSourceStreamRequired(VideoOutput r0) {
            return ConstantObservable.withValue(Boolean.FALSE);
        }

        public static VideoCapabilities $default$getMediaCapabilities(VideoOutput r0, CameraInfo r1) {
            return VideoCapabilities.EMPTY;
        }

        public static void $default$onSurfaceRequested(VideoOutput r0, SurfaceRequest r1, Timebase r2) {
            r0.onSurfaceRequested(r1);
        }
    }

    public static final enum SourceState extends Enum<SourceState> {
        private static final /* synthetic */ SourceState[] $VALUES = null;
        public static final SourceState ACTIVE_NON_STREAMING = null;
        public static final SourceState ACTIVE_STREAMING = null;
        public static final SourceState INACTIVE = null;

        private static /* synthetic */ SourceState[] $values() {
            return new SourceState[]{ACTIVE_STREAMING, ACTIVE_NON_STREAMING, INACTIVE};
        }

        static {
            ACTIVE_STREAMING = new SourceState("ACTIVE_STREAMING", 0);
            ACTIVE_NON_STREAMING = new SourceState("ACTIVE_NON_STREAMING", 1);
            INACTIVE = new SourceState("INACTIVE", 2);
            $VALUES = $values();
        }

        public static SourceState[] values() {
            return (SourceState[]) $VALUES.clone();
        }

        public static SourceState valueOf(String r1) {
            return (SourceState) r27.a.a(SourceState.class, r1);
        }

        private SourceState(String r1, int r2) {
            super(r1, r2);
        }
    }

    VideoCapabilities getMediaCapabilities(CameraInfo r1);

    Observable<MediaSpec> getMediaSpec();

    Observable<StreamInfo> getStreamInfo();

    Observable<Boolean> isSourceStreamRequired();

    void onSourceStateChanged(SourceState r1);

    void onSurfaceRequested(SurfaceRequest r1);

    void onSurfaceRequested(SurfaceRequest r1, Timebase r2);
}

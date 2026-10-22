package androidx.camera.video;

import android.view.Surface;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.encoder.EncoderFactory;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class VideoEncoderSession {
    private static final String TAG = "VideoEncoderSession";
    private Surface mActiveSurface;
    private final Executor mExecutor;
    private Executor mOnSurfaceUpdateExecutor;
    private Encoder.SurfaceInput.OnSurfaceUpdateListener mOnSurfaceUpdateListener;
    private CallbackToFutureAdapter.Completer<Encoder> mReadyToReleaseCompleter;
    private ListenableFuture<Encoder> mReadyToReleaseFuture;
    private CallbackToFutureAdapter.Completer<Void> mReleasedCompleter;
    private ListenableFuture<Void> mReleasedFuture;
    private final Executor mSequentialExecutor;
    private SurfaceRequest mSurfaceRequest;
    private Encoder mVideoEncoder;
    private final EncoderFactory mVideoEncoderFactory;
    private VideoEncoderState mVideoEncoderState;

    public static final enum VideoEncoderState extends Enum<VideoEncoderState> {
        private static final /* synthetic */ VideoEncoderState[] $VALUES = null;
        public static final VideoEncoderState INITIALIZING = null;
        public static final VideoEncoderState NOT_INITIALIZED = null;
        public static final VideoEncoderState PENDING_RELEASE = null;
        public static final VideoEncoderState READY = null;
        public static final VideoEncoderState RELEASED = null;

        private static /* synthetic */ VideoEncoderState[] $values() {
            return new VideoEncoderState[]{NOT_INITIALIZED, INITIALIZING, PENDING_RELEASE, READY, RELEASED};
        }

        static {
            NOT_INITIALIZED = new VideoEncoderState("NOT_INITIALIZED", 0);
            INITIALIZING = new VideoEncoderState("INITIALIZING", 1);
            PENDING_RELEASE = new VideoEncoderState("PENDING_RELEASE", 2);
            READY = new VideoEncoderState("READY", 3);
            RELEASED = new VideoEncoderState("RELEASED", 4);
            $VALUES = $values();
        }

        public static VideoEncoderState[] values() {
            return (VideoEncoderState[]) $VALUES.clone();
        }

        public static VideoEncoderState valueOf(String r1) {
            return (VideoEncoderState) r27.a.a(VideoEncoderState.class, r1);
        }

        private VideoEncoderState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ Object a(VideoEncoderSession r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$configure$1(r1);
    }

    public static /* synthetic */ void b(VideoEncoderSession r0, SurfaceRequest.Result r1) {
        r0.onSurfaceRequestComplete(r1);
    }

    public static /* synthetic */ void c(VideoEncoderSession r0, Surface r1) {
        r0.lambda$configureVideoEncoderInternal$4(r1);
    }

    public static /* synthetic */ Object d(VideoEncoderSession r0, SurfaceRequest r1, Timebase r2, VideoValidatedEncoderProfilesProxy r3, MediaSpec r4, CallbackToFutureAdapter.Completer r5) {
        return r0.lambda$configure$2(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void e(VideoEncoderSession r0, CallbackToFutureAdapter.Completer r1, SurfaceRequest r2, Surface r3) {
        r0.lambda$configureVideoEncoderInternal$5(r1, r2, r3);
    }

    public static /* synthetic */ void f(VideoEncoderSession r0) {
        r0.lambda$terminateNow$3();
    }

    public static /* synthetic */ Object g(VideoEncoderSession r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$configure$0(r1);
    }

    private void closeInternal() {
        int r0 = this.mVideoEncoderState.ordinal();
        if (r0 != 0) goto L5;
    L16:
        terminateNow();
        return;
    L5:
        if (r0 == 1) goto L16;
        if (r0 != 2) goto L9;
    L15:
        Logger.d(TAG, "closeInternal in " + this.mVideoEncoderState + " state");
        this.mVideoEncoderState = VideoEncoderState.PENDING_RELEASE;
        return;
    L9:
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L14;
        Logger.d(TAG, "closeInternal in RELEASED state, No-op");
        return;
    L14:
        throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
    }

    private /* synthetic */ void lambda$terminateNow$3() {
        this.mReleasedCompleter.set(null);
    }

    public Surface getActiveSurface() {
        if (this.mVideoEncoderState == VideoEncoderState.READY) goto L7;
        return null;
    L7:
        return this.mActiveSurface;
    }

    public ListenableFuture<Encoder> getReadyToReleaseFuture() {
        return Futures.nonCancellationPropagating(this.mReadyToReleaseFuture);
    }

    public void terminateNow() {
        int r0 = this.mVideoEncoderState.ordinal();
        if (r0 != 0) goto L5;
        this.mVideoEncoderState = VideoEncoderState.RELEASED;
        return;
    L5:
        if (r0 != 1) goto L7;
    L16:
        this.mVideoEncoderState = VideoEncoderState.RELEASED;
        this.mReadyToReleaseCompleter.set(this.mVideoEncoder);
        this.mSurfaceRequest = null;
        if (this.mVideoEncoder == null) goto L19;
        Logger.d(TAG, "VideoEncoder is releasing: " + this.mVideoEncoder);
        this.mVideoEncoder.release();
        this.mVideoEncoder.getReleasedFuture().addListener(new p0(this), this.mSequentialExecutor);
        this.mVideoEncoder = null;
        return;
    L19:
        Logger.w(TAG, "There's no VideoEncoder to release! Finish release completer.");
        this.mReleasedCompleter.set(null);
        return;
    L7:
        if (r0 == 2) goto L16;
        if (r0 == 3) goto L16;
        if (r0 != 4) goto L15;
        Logger.d(TAG, "terminateNow in " + this.mVideoEncoderState + ", No-op");
        return;
    L15:
        throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
    }

    public String toString() {
        return "VideoEncoderSession@" + hashCode() + " for " + Objects.toString(this.mSurfaceRequest, "SURFACE_REQUEST_NOT_CONFIGURED");
    }

    public ListenableFuture<Void> signalTermination() {
        closeInternal();
        return Futures.nonCancellationPropagating(this.mReleasedFuture);
    }

    public Encoder getVideoEncoder() {
        return this.mVideoEncoder;
    }

    private /* synthetic */ Object lambda$configure$0(CallbackToFutureAdapter.Completer r2) throws Exception {
        this.mReleasedCompleter = r2;
        return "ReleasedFuture " + this;
    }

    private /* synthetic */ Object lambda$configure$1(CallbackToFutureAdapter.Completer r2) throws Exception {
        this.mReadyToReleaseCompleter = r2;
        return "ReadyToReleaseFuture " + this;
    }

    private /* synthetic */ void lambda$configureVideoEncoderInternal$4(Surface r2) {
        this.mOnSurfaceUpdateListener.onSurfaceUpdate(r2);
    }

    private void onSurfaceRequestComplete(SurfaceRequest.Result r3) {
        Logger.d(TAG, "Surface can be closed: " + r3.getSurface().hashCode());
        Surface r4 = r3.getSurface();
        if (r4 != this.mActiveSurface) goto L5;
        this.mActiveSurface = null;
        this.mReadyToReleaseCompleter.set(this.mVideoEncoder);
        closeInternal();
        return;
    L5:
        r4.release();
    }

    public boolean isConfiguredSurfaceRequest(SurfaceRequest r5) {
        int r0 = this.mVideoEncoderState.ordinal();
        if (r0 != 0) goto L5;
        return false;
    L5:
        if (r0 == 1) goto L16;
        if (r0 != 2) goto L9;
        return false;
    L9:
        if (r0 == 3) goto L16;
        if (r0 != 4) goto L14;
        return false;
    L14:
        throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
    L16:
        if (this.mSurfaceRequest != r5) goto L21;
        return true;
    L21:
        return false;
    }

    public void setOnSurfaceUpdateListener(Executor r1, Encoder.SurfaceInput.OnSurfaceUpdateListener r2) {
        this.mOnSurfaceUpdateExecutor = r1;
        this.mOnSurfaceUpdateListener = r2;
    }

    public VideoEncoderSession(EncoderFactory r4, Executor r5, Executor r6) {
        this.mVideoEncoder = null;
        this.mActiveSurface = null;
        this.mSurfaceRequest = null;
        this.mOnSurfaceUpdateExecutor = null;
        this.mOnSurfaceUpdateListener = null;
        this.mVideoEncoderState = VideoEncoderState.NOT_INITIALIZED;
        this.mReleasedFuture = Futures.immediateFailedFuture(new IllegalStateException("Cannot close the encoder before configuring."));
        this.mReleasedCompleter = null;
        this.mReadyToReleaseFuture = Futures.immediateFailedFuture(new IllegalStateException("Cannot close the encoder before configuring."));
        this.mReadyToReleaseCompleter = null;
        this.mExecutor = r6;
        this.mSequentialExecutor = r5;
        this.mVideoEncoderFactory = r4;
    }

    private /* synthetic */ void lambda$configureVideoEncoderInternal$5(CallbackToFutureAdapter.Completer r5, SurfaceRequest r6, final Surface r7) {
        int r0 = this.mVideoEncoderState.ordinal();
        if (r0 != 0) goto L5;
    L25:
        Logger.d(TAG, "Not provide surface in " + this.mVideoEncoderState);
        r5.set(null);
        return;
    L5:
        if (r0 == 1) goto L22;
        if (r0 == 2) goto L25;
        if (r0 == 3) goto L16;
        if (r0 == 4) goto L25;
        throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
    L16:
        if (this.mOnSurfaceUpdateListener == null) goto L20;
        Executor r8 = this.mOnSurfaceUpdateExecutor;
        if (r8 == null) goto L20;
        r8.execute(new r0(this, r7));
    L20:
        Logger.w(TAG, "Surface is updated in READY state: " + r7);
        return;
    L22:
        if (r6.isServiced() == false) goto L24;
        Logger.d(TAG, "Not provide surface, " + Objects.toString(r6, "EMPTY") + " is already serviced.");
        r5.set(null);
        closeInternal();
        return;
    L24:
        this.mActiveSurface = r7;
        Logger.d(TAG, "provide surface: " + r7);
        r6.provideSurface(r7, this.mSequentialExecutor, new q0(this));
        this.mVideoEncoderState = VideoEncoderState.READY;
        r5.set(this.mVideoEncoder);
    }

    public ListenableFuture<Encoder> configure(final SurfaceRequest r8, final Timebase r9, final MediaSpec r10, final VideoValidatedEncoderProfilesProxy r11) {
        if (this.mVideoEncoderState.ordinal() != 0) goto L5;
        this.mVideoEncoderState = VideoEncoderState.INITIALIZING;
        this.mSurfaceRequest = r8;
        Logger.d(TAG, "Create VideoEncoderSession: " + this);
        this.mReleasedFuture = CallbackToFutureAdapter.getFuture(new t0(this));
        this.mReadyToReleaseFuture = CallbackToFutureAdapter.getFuture(new u0(this));
        ListenableFuture r12 = CallbackToFutureAdapter.getFuture(new v0(this, r8, r9, r11, r10));
        Futures.addCallback(r12, new AnonymousClass1(this), this.mSequentialExecutor);
        return Futures.nonCancellationPropagating(r12);
    L5:
        return Futures.immediateFailedFuture(new IllegalStateException("configure() shouldn't be called in " + this.mVideoEncoderState));
    }

    private void configureVideoEncoderInternal(final SurfaceRequest r7, Timebase r8, VideoValidatedEncoderProfilesProxy r9, MediaSpec r10, final CallbackToFutureAdapter.Completer<Encoder> r11) {
        DynamicRange r4 = r7.getDynamicRange();
        VideoEncoderConfig r12 = VideoConfigUtil.resolveVideoEncoderConfig(VideoConfigUtil.resolveVideoMimeInfo(r10, r4, r9), r8, r10.getVideoSpec(), r7.getResolution(), r4, r7.getExpectedFrameRate());
        Encoder r13 = this.mVideoEncoderFactory.createEncoder(this.mExecutor, r12);     // Catch: InvalidConfigException -> L10
        this.mVideoEncoder = r13;     // Catch: InvalidConfigException -> L10
        Encoder.EncoderInput r14 = r13.getInput();
        if ((r14 instanceof Encoder.SurfaceInput) == true) goto L8;
        r11.setException(new AssertionError("The EncoderInput of video isn't a SurfaceInput."));
        return;
    L8:
        ((Encoder.SurfaceInput) r14).setOnSurfaceUpdateListener(this.mSequentialExecutor, new s0(this, r11, r7));
        return;
    L10:
        e = move-exception;
        Logger.e(TAG, "Unable to initialize video encoder.", e);
        r11.setException(e);
    }

    private /* synthetic */ Object lambda$configure$2(SurfaceRequest r1, Timebase r2, VideoValidatedEncoderProfilesProxy r3, MediaSpec r4, CallbackToFutureAdapter.Completer r5) throws Exception {
        configureVideoEncoderInternal(r1, r2, r3, r4, r5);
        return "ConfigureVideoEncoderFuture " + this;
    }
}

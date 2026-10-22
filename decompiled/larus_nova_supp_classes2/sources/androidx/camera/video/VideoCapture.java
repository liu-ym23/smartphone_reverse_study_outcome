package androidx.camera.video;

import android.graphics.Rect;
import android.media.MediaCodec;
import android.os.SystemClock;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.core.processing.util.OutConfig;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.video.VideoOutput;
import androidx.camera.video.impl.VideoCaptureConfig;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.SizeCannotEncodeVideoQuirk;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.SwappedVideoEncoderInfo;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.encoder.VideoEncoderInfoImpl;
import androidx.camera.video.internal.utils.DynamicRangeUtil;
import androidx.camera.video.internal.workaround.VideoEncoderInfoWrapper;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class VideoCapture<T extends VideoOutput> extends UseCase {
    private static final Defaults DEFAULT_CONFIG = null;
    private static final String SURFACE_UPDATE_KEY = "androidx.camera.video.VideoCapture.streamUpdate";
    private static final String TAG = "VideoCapture";
    private SurfaceEdge mCameraEdge;
    private SessionConfig.CloseableErrorListener mCloseableErrorListener;
    private Rect mCropRect;
    DeferrableSurface mDeferrableSurface;
    private boolean mHasCompensatingTransformation;
    private SurfaceProcessorNode mNode;
    private int mRotationDegrees;
    SessionConfig.Builder mSessionConfigBuilder;
    VideoOutput.SourceState mSourceState;
    private SourceStreamRequirementObserver mSourceStreamRequirementObserver;
    StreamInfo mStreamInfo;
    private final Observable.Observer<StreamInfo> mStreamInfoObserver;
    private SurfaceRequest mSurfaceRequest;
    ListenableFuture<Void> mSurfaceUpdateFuture;

    /* JADX INFO: renamed from: androidx.camera.video.VideoCapture$2, reason: invalid class name */
    public class AnonymousClass2 extends CameraCaptureCallback {
        private boolean mIsFirstCaptureResult;
        final /* synthetic */ VideoCapture this$0;
        final /* synthetic */ CallbackToFutureAdapter.Completer val$completer;
        final /* synthetic */ SessionConfig.Builder val$sessionConfigBuilder;
        final /* synthetic */ AtomicBoolean val$surfaceUpdateComplete;

        public static /* synthetic */ void a(AnonymousClass2 r0, SessionConfig.Builder r1) {
            r0.lambda$onCaptureCompleted$0(r1);
        }

        private /* synthetic */ void lambda$onCaptureCompleted$0(SessionConfig.Builder r1) {
            r1.removeCameraCaptureCallback(this);
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCompleted(int r3, CameraCaptureResult r4) {
            super.onCaptureCompleted(r3, r4);
            if (this.mIsFirstCaptureResult == false) goto L6;
            this.mIsFirstCaptureResult = false;
            Logger.d(VideoCapture.TAG, "cameraCaptureResult timestampNs = " + r4.getTimestamp() + ", current system uptimeMs = " + SystemClock.uptimeMillis() + ", current system realtimeMs = " + SystemClock.elapsedRealtime());
        L6:
            if (this.val$surfaceUpdateComplete.get() == true) goto L17;
            Object r5 = r4.getTagBundle().getTag(VideoCapture.SURFACE_UPDATE_KEY);
            if (r5 != null) goto L10;
            return;
        L10:
            if (((Integer) r5).intValue() == this.val$completer.hashCode()) goto L12;
            return;
        L12:
            if (this.val$completer.set(null) == true) goto L14;
            return;
        L14:
            if (this.val$surfaceUpdateComplete.getAndSet(true) == true) goto L21;
            ScheduledExecutorService r6 = CameraXExecutors.mainThreadExecutor();
            final SessionConfig.Builder r7 = this.val$sessionConfigBuilder;
            r6.execute(new n0(this, r7));
            return;
        L21:
            return;
        }

        public AnonymousClass2(VideoCapture r1, AtomicBoolean r2, CallbackToFutureAdapter.Completer r3, SessionConfig.Builder r4) {
            this.this$0 = r1;
            this.val$surfaceUpdateComplete = r2;
            this.val$completer = r3;
            this.val$sessionConfigBuilder = r4;
            this.mIsFirstCaptureResult = true;
        }
    }

    public static final class Builder<T extends VideoOutput> implements UseCaseConfig.Builder<VideoCapture<T>, VideoCaptureConfig<T>, Builder<T>>, ImageOutputConfig.Builder<Builder<T>>, ImageInputConfig.Builder<Builder<T>>, ThreadConfig.Builder<Builder<T>> {
        private final MutableOptionsBundle mMutableConfig;

        @Override // androidx.camera.core.ExtendableBuilder
        public VideoCapture<T> build() {
            return new VideoCapture(getUseCaseConfig());
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public VideoCaptureConfig<T> getUseCaseConfig() {
            return new VideoCaptureConfig(OptionsBundle.from(this.mMutableConfig));
        }

        public Builder<T> setSurfaceProcessingForceEnabled() {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_FORCE_ENABLE_SURFACE_PROCESSING, Boolean.TRUE);
            return this;
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public /* bridge */ /* synthetic */ Object build() {
            return build();
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ UseCaseConfig getUseCaseConfig() {
            return getUseCaseConfig();
        }

        private Builder(MutableOptionsBundle r4) {
            this.mMutableConfig = r4;
            if (r4.containsOption(VideoCaptureConfig.OPTION_VIDEO_OUTPUT) == false) goto L14;
            Class r5 = (Class) r4.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (r5 != null) goto L7;
        L11:
            setCaptureType(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE);
            setTargetClass(VideoCapture.class);
            return;
        L7:
            if (r5.equals(VideoCapture.class) == true) goto L11;
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + r5);
        L14:
            throw new IllegalArgumentException("VideoOutput is required");
        }

        private static <T extends VideoOutput> MutableOptionsBundle createInitialBundle(T r2) {
            MutableOptionsBundle r0 = MutableOptionsBundle.create();
            r0.insertOption(VideoCaptureConfig.OPTION_VIDEO_OUTPUT, r2);
            return r0;
        }

        public static Builder<? extends VideoOutput> fromConfig(Config r1) {
            return new Builder(MutableOptionsBundle.from(r1));
        }

        @Override // androidx.camera.core.internal.ThreadConfig.Builder
        public Builder<T> setBackgroundExecutor(Executor r3) {
            getMutableConfig().insertOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, r3);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder<T> setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, r3);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder<T> setCaptureType(UseCaseConfigFactory.CaptureType r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, r3);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder<T> setCustomOrderedResolutions(List<Size> r3) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, r3);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder<T> setDefaultCaptureConfig(CaptureConfig r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, r3);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder<T> setDefaultResolution(Size r3) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, r3);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder<T> setDefaultSessionConfig(SessionConfig r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, r3);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageInputConfig.Builder
        public Builder<T> setDynamicRange(DynamicRange r3) {
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, r3);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder<T> setHighResolutionDisabled(boolean r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(r3));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder<T> setMaxResolution(Size r3) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, r3);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder<T> setMirrorMode(int r3) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MIRROR_MODE, Integer.valueOf(r3));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder<T> setResolutionSelector(ResolutionSelector r3) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, r3);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder<T> setSessionOptionUnpacker(SessionConfig.OptionUnpacker r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, r3);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder<T> setSupportedResolutions(List<Pair<Integer, Size[]>> r3) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, r3);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder<T> setSurfaceOccupancyPriority(int r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(r3));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder<T> setTargetAspectRatio(int r2) {
            throw new UnsupportedOperationException("setTargetAspectRatio is not supported.");
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public Builder<T> setTargetClass(Class<VideoCapture<T>> r4) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, r4);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) != null) goto L5;
            setTargetName(r4.getCanonicalName() + "-" + UUID.randomUUID());
        L5:
            return this;
        }

        public Builder<T> setTargetFrameRate(Range<Integer> r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE, r3);
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public Builder<T> setTargetName(String r3) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, r3);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder<T> setTargetResolution(Size r2) {
            throw new UnsupportedOperationException("setTargetResolution is not supported.");
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder<T> setTargetRotation(int r3) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(r3));
            return this;
        }

        public Builder<T> setVideoEncoderInfoFinder(Function<VideoEncoderConfig, VideoEncoderInfo> r3) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_VIDEO_ENCODER_INFO_FINDER, r3);
            return this;
        }

        public Builder<T> setVideoOutput(VideoOutput r3) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_VIDEO_OUTPUT, r3);
            return this;
        }

        public Builder<T> setVideoStabilizationEnabled(boolean r3) {
            MutableConfig r0 = getMutableConfig();
            Config.Option<Integer> r1 = UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE;
            if (r3 == false) goto L5;
            int r4 = 2;
        L6:
            r0.insertOption(r1, Integer.valueOf(r4));
            return this;
        L5:
            r4 = 1;
            goto L6
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder<T> setZslDisabled(boolean r3) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(r3));
            return this;
        }

        public Builder(T r1) {
            this(createInitialBundle(r1));
        }

        public static <T extends VideoOutput> Builder<T> fromConfig(VideoCaptureConfig<T> r1) {
            return new Builder(MutableOptionsBundle.from(r1));
        }

        @Override // androidx.camera.core.internal.ThreadConfig.Builder
        public /* bridge */ /* synthetic */ Object setBackgroundExecutor(Executor r1) {
            return setBackgroundExecutor(r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Object setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker r1) {
            return setCaptureOptionUnpacker(r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Object setCaptureType(UseCaseConfigFactory.CaptureType r1) {
            return setCaptureType(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Object setCustomOrderedResolutions(List r1) {
            return setCustomOrderedResolutions(r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Object setDefaultCaptureConfig(CaptureConfig r1) {
            return setDefaultCaptureConfig(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Object setDefaultResolution(Size r1) {
            return setDefaultResolution(r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Object setDefaultSessionConfig(SessionConfig r1) {
            return setDefaultSessionConfig(r1);
        }

        @Override // androidx.camera.core.impl.ImageInputConfig.Builder
        public /* bridge */ /* synthetic */ Object setDynamicRange(DynamicRange r1) {
            return setDynamicRange(r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Object setHighResolutionDisabled(boolean r1) {
            return setHighResolutionDisabled(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Object setMaxResolution(Size r1) {
            return setMaxResolution(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Object setMirrorMode(int r1) {
            return setMirrorMode(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Object setResolutionSelector(ResolutionSelector r1) {
            return setResolutionSelector(r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Object setSessionOptionUnpacker(SessionConfig.OptionUnpacker r1) {
            return setSessionOptionUnpacker(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Object setSupportedResolutions(List r1) {
            return setSupportedResolutions(r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Object setSurfaceOccupancyPriority(int r1) {
            return setSurfaceOccupancyPriority(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Object setTargetAspectRatio(int r1) {
            return setTargetAspectRatio(r1);
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public /* bridge */ /* synthetic */ Object setTargetClass(Class r1) {
            return setTargetClass(r1);
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public /* bridge */ /* synthetic */ Object setTargetName(String r1) {
            return setTargetName(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Object setTargetResolution(Size r1) {
            return setTargetResolution(r1);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Object setTargetRotation(int r1) {
            return setTargetRotation(r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Object setZslDisabled(boolean r1) {
            return setZslDisabled(r1);
        }
    }

    public static final class Defaults implements ConfigProvider<VideoCaptureConfig<?>> {
        private static final VideoCaptureConfig<?> DEFAULT_CONFIG = null;
        static final DynamicRange DEFAULT_DYNAMIC_RANGE = null;
        static final Range<Integer> DEFAULT_FPS_RANGE = null;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 5;
        private static final Function<VideoEncoderConfig, VideoEncoderInfo> DEFAULT_VIDEO_ENCODER_INFO_FINDER = null;
        private static final VideoOutput DEFAULT_VIDEO_OUTPUT = null;

        public Defaults() {
        }

        static {
            VideoOutput r0 = new o0();
            DEFAULT_VIDEO_OUTPUT = r0;
            Function<VideoEncoderConfig, VideoEncoderInfo> r1 = VideoEncoderInfoImpl.FINDER;
            DEFAULT_VIDEO_ENCODER_INFO_FINDER = r1;
            DEFAULT_FPS_RANGE = new Range(30, 30);
            DynamicRange r2 = DynamicRange.SDR;
            DEFAULT_DYNAMIC_RANGE = r2;
            DEFAULT_CONFIG = new Builder(r0).setSurfaceOccupancyPriority(5).setVideoEncoderInfoFinder(r1).setDynamicRange(r2).getUseCaseConfig();
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        public /* bridge */ /* synthetic */ Config getConfig() {
            return getConfig();
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        public VideoCaptureConfig<?> getConfig() {
            return DEFAULT_CONFIG;
        }
    }

    public static class SourceStreamRequirementObserver implements Observable.Observer<Boolean> {
        private CameraControlInternal mCameraControl;
        private boolean mIsSourceStreamRequired;

        public void close() {
            Preconditions.checkState(Threads.isMainThread(), "SourceStreamRequirementObserver can be closed from main thread only");
            Logger.d(VideoCapture.TAG, "SourceStreamRequirementObserver#close: mIsSourceStreamRequired = " + this.mIsSourceStreamRequired);
            if (this.mCameraControl != null) goto L6;
            Logger.d(VideoCapture.TAG, "SourceStreamRequirementObserver#close: Already closed!");
            return;
        L6:
            updateVideoUsageInCamera(false);
            this.mCameraControl = null;
        }

        public SourceStreamRequirementObserver(CameraControlInternal r2) {
            this.mIsSourceStreamRequired = false;
            this.mCameraControl = r2;
        }

        private void updateVideoUsageInCamera(boolean r2) {
            if (this.mIsSourceStreamRequired != r2) goto L5;
            return;
        L5:
            this.mIsSourceStreamRequired = r2;
            CameraControlInternal r0 = this.mCameraControl;
            if (r0 == null) goto L10;
            if (r2 == false) goto L9;
            r0.incrementVideoUsage();
            return;
        L9:
            r0.decrementVideoUsage();
            return;
        L10:
            Logger.d(VideoCapture.TAG, "SourceStreamRequirementObserver#isSourceStreamRequired: Received new data despite being closed already");
        }

        @Override // androidx.camera.core.impl.Observable.Observer
        public void onError(Throwable r3) {
            Logger.w(VideoCapture.TAG, "SourceStreamRequirementObserver#onError", r3);
        }

        /* JADX INFO: renamed from: onNewData, reason: avoid collision after fix types in other method */
        public void onNewData2(Boolean r3) {
            Preconditions.checkState(Threads.isMainThread(), "SourceStreamRequirementObserver can be updated from main thread only");
            updateVideoUsageInCamera(Boolean.TRUE.equals(r3));
        }

        @Override // androidx.camera.core.impl.Observable.Observer
        public /* bridge */ /* synthetic */ void onNewData(Boolean r1) {
            onNewData2(r1);
        }
    }

    public static /* synthetic */ void a(AtomicBoolean r0, SessionConfig.Builder r1, CameraCaptureCallback r2) {
        lambda$setupSurfaceUpdateNotifier$5(r0, r1, r2);
    }

    public static /* synthetic */ Object b(VideoCapture r0, SessionConfig.Builder r1, CallbackToFutureAdapter.Completer r2) {
        return r0.lambda$setupSurfaceUpdateNotifier$6(r1, r2);
    }

    public static /* synthetic */ void c(VideoCapture r0, SurfaceEdge r1, CameraInternal r2, VideoCaptureConfig r3, Timebase r4) {
        r0.lambda$createPipeline$1(r1, r2, r3, r4);
    }

    public static /* synthetic */ void d(VideoCapture r0, SessionConfig r1, SessionConfig.SessionError r2) {
        r0.lambda$createPipeline$3(r1, r2);
    }

    public static /* synthetic */ void e(VideoCapture r0) {
        lambda$createPipeline$0(r0);
    }

    public static /* synthetic */ void f(VideoCapture r0, DeferrableSurface r1) {
        r0.lambda$createPipeline$2(r1);
    }

    public static /* synthetic */ int g(Rect r0, Size r1, Size r2) {
        return lambda$adjustCropRectToValidSize$4(r0, r1, r2);
    }

    static {
        DEFAULT_CONFIG = new Defaults();
    }

    private boolean shouldCompensateTransformation() {
        if (this.mStreamInfo.getInProgressTransformationInfo() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.camera.core.UseCase
    public Set<Integer> getSupportedEffectTargets() {
        HashSet r0 = new HashSet();
        r0.add(2);
        return r0;
    }

    public SurfaceRequest getSurfaceRequest() {
        SurfaceRequest r0 = this.mSurfaceRequest;
        Objects.requireNonNull(r0);
        return r0;
    }

    @Override // androidx.camera.core.UseCase
    public void onStateDetached() {
        Logger.d(TAG, "VideoCapture#onStateDetached");
        Preconditions.checkState(Threads.isMainThread(), "VideoCapture can only be detached on the main thread.");
        if (this.mSourceStreamRequirementObserver == null) goto L5;
        getOutput().isSourceStreamRequired().removeObserver(this.mSourceStreamRequirementObserver);
        this.mSourceStreamRequirementObserver.close();
        this.mSourceStreamRequirementObserver = null;
    L5:
        setSourceState(VideoOutput.SourceState.INACTIVE);
        getOutput().getStreamInfo().removeObserver(this.mStreamInfoObserver);
        ListenableFuture<Void> r0 = this.mSurfaceUpdateFuture;
        if (r0 != null) goto L8;
    L10:
        clearPipeline();
        return;
    L8:
        if (r0.cancel(false) == false) goto L10;
        Logger.d(TAG, "VideoCapture is detached from the camera. Surface update cancelled.");
        goto L10
    }

    public String toString() {
        return "VideoCapture:" + getName();
    }

    private void clearPipeline() {
        Threads.checkMainThread();
        SessionConfig.CloseableErrorListener r0 = this.mCloseableErrorListener;
        if (r0 == null) goto L5;
        r0.close();
        this.mCloseableErrorListener = null;
    L5:
        DeferrableSurface r1 = this.mDeferrableSurface;
        if (r1 == null) goto L8;
        r1.close();
        this.mDeferrableSurface = null;
    L8:
        SurfaceProcessorNode r2 = this.mNode;
        if (r2 == null) goto L11;
        r2.release();
        this.mNode = null;
    L11:
        SurfaceEdge r3 = this.mCameraEdge;
        if (r3 == null) goto L14;
        r3.close();
        this.mCameraEdge = null;
    L14:
        this.mCropRect = null;
        this.mSurfaceRequest = null;
        this.mStreamInfo = StreamInfo.STREAM_INFO_ANY_INACTIVE;
        this.mRotationDegrees = 0;
        this.mHasCompensatingTransformation = false;
    }

    private MediaSpec getMediaSpec() {
        return (MediaSpec) fetchObservableValue(getOutput().getMediaSpec(), null);
    }

    private void sendTransformationInfoIfReady() {
        CameraInternal r0 = getCamera();
        SurfaceEdge r1 = this.mCameraEdge;
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        int r2 = getCompensatedRotation(r0);
        this.mRotationDegrees = r2;
        r1.updateTransformation(r2, getAppTargetRotation());
        return;
    L8:
        return;
    }

    public DynamicRange getDynamicRange() {
        if (getCurrentConfig().hasDynamicRange() == false) goto L6;
        return getCurrentConfig().getDynamicRange();
    L6:
        return Defaults.DEFAULT_DYNAMIC_RANGE;
    }

    public int getMirrorMode() {
        int r0 = getMirrorModeInternal();
        if (r0 != (-1)) goto L6;
        return 0;
    L6:
        return r0;
    }

    public T getOutput() {
        return (T) ((VideoCaptureConfig) getCurrentConfig()).getVideoOutput();
    }

    public Range<Integer> getTargetFrameRate() {
        return getTargetFrameRateInternal();
    }

    public int getTargetRotation() {
        return getTargetRotationInternal();
    }

    public boolean isVideoStabilizationEnabled() {
        if (getCurrentConfig().getVideoStabilizationMode() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.camera.core.UseCase
    public void onStateAttached() {
        super.onStateAttached();
        Logger.d(TAG, "VideoCapture#onStateAttached: cameraID = " + getCameraId());
        if (getAttachedStreamSpec() != null) goto L5;
        return;
    L5:
        if (this.mSurfaceRequest != null) goto L13;
        StreamSpec r0 = (StreamSpec) Preconditions.checkNotNull(getAttachedStreamSpec());
        this.mStreamInfo = (StreamInfo) fetchObservableValue(getOutput().getStreamInfo(), StreamInfo.STREAM_INFO_ANY_INACTIVE);
        this.mSessionConfigBuilder = createPipeline((VideoCaptureConfig) getCurrentConfig(), r0);
        applyStreamInfoAndStreamSpecToSessionConfigBuilder(this.mSessionConfigBuilder, this.mStreamInfo, r0);
        Object[] r2 = {this.mSessionConfigBuilder.build()};
        ArrayList r1 = new ArrayList(1);
        Object r3 = r2[0];
        Objects.requireNonNull(r3);
        r1.add(r3);
        updateSessionConfig(Collections.unmodifiableList(r1));
        notifyActive();
        getOutput().getStreamInfo().addObserver(CameraXExecutors.mainThreadExecutor(), this.mStreamInfoObserver);
        SourceStreamRequirementObserver r4 = this.mSourceStreamRequirementObserver;
        if (r4 == null) goto L10;
        r4.close();
    L10:
        this.mSourceStreamRequirementObserver = new SourceStreamRequirementObserver(getCameraControl());
        getOutput().isSourceStreamRequired().addObserver(CameraXExecutors.mainThreadExecutor(), this.mSourceStreamRequirementObserver);
        setSourceState(VideoOutput.SourceState.ACTIVE_NON_STREAMING);
        return;
    }

    public void resetPipeline() {
        if (getCamera() != null) goto L5;
        return;
    L5:
        clearPipeline();
        this.mSessionConfigBuilder = createPipeline((VideoCaptureConfig) getCurrentConfig(), (StreamSpec) Preconditions.checkNotNull(getAttachedStreamSpec()));
        applyStreamInfoAndStreamSpecToSessionConfigBuilder(this.mSessionConfigBuilder, this.mStreamInfo, getAttachedStreamSpec());
        Object[] r2 = {this.mSessionConfigBuilder.build()};
        ArrayList r0 = new ArrayList(1);
        Object r1 = r2[0];
        Objects.requireNonNull(r1);
        r0.add(r1);
        updateSessionConfig(Collections.unmodifiableList(r0));
        notifyReset();
    }

    public SurfaceEdge getCameraEdge() {
        return this.mCameraEdge;
    }

    public Rect getCropRect() {
        return this.mCropRect;
    }

    public SurfaceProcessorNode getNode() {
        return this.mNode;
    }

    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    public VideoCapture(VideoCaptureConfig<T> r1) {
        super(r1);
        this.mStreamInfo = StreamInfo.STREAM_INFO_ANY_INACTIVE;
        this.mSessionConfigBuilder = new SessionConfig.Builder();
        this.mSurfaceUpdateFuture = null;
        this.mSourceState = VideoOutput.SourceState.INACTIVE;
        this.mHasCompensatingTransformation = false;
        this.mStreamInfoObserver = new AnonymousClass1(this);
    }

    public static /* synthetic */ void access$100(VideoCapture r0) {
        r0.notifyReset();
    }

    public static /* synthetic */ void access$300(VideoCapture r0) {
        r0.notifyUpdated();
    }

    private int getCompensatedRotation(CameraInternal r4) {
        boolean r0 = isMirroringRequired(r4);
        int r5 = getRelativeRotation(r4, r0);
        if (shouldCompensateTransformation() == false) goto L9;
        SurfaceRequest.TransformationInfo r1 = this.mStreamInfo.getInProgressTransformationInfo();
        Objects.requireNonNull(r1);
        int r2 = r1.getRotationDegrees();
        if (r0 == r1.isMirroring()) goto L8;
        r2 = -r2;
    L8:
        return TransformUtils.within360(r5 - r2);
    L9:
        return r5;
    }

    private VideoCapabilities getVideoCapabilities(CameraInfo r2) {
        return getOutput().getMediaCapabilities(r2);
    }

    private static /* synthetic */ void lambda$createPipeline$0(VideoCapture r0) {
        r0.notifyReset();
    }

    private /* synthetic */ void lambda$createPipeline$2(DeferrableSurface r2) {
        if (r2 != this.mDeferrableSurface) goto L6;
        clearPipeline();
        return;
    }

    private static Range<Integer> resolveFrameRate(StreamSpec r1) {
        Range<Integer> r2 = r1.getExpectedFrameRateRange();
        if (Objects.equals(r2, StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED) == true) goto L5;
        return r2;
    L5:
        return Defaults.DEFAULT_FPS_RANGE;
    }

    private static boolean shouldEnableSurfaceProcessingByQuirk(CameraInternal r1) {
        if (r1.getHasTransform() == true) goto L5;
    L9:
        return false;
    L5:
        if (SurfaceProcessingQuirk.CC.workaroundBySurfaceProcessing(DeviceQuirks.getAll()) == false) goto L7;
    L8:
        return true;
    L7:
        if (SurfaceProcessingQuirk.CC.workaroundBySurfaceProcessing(r1.getCameraInfoInternal().getCameraQuirks()) == false) goto L9;
        goto L8
    }

    private boolean shouldMirror(CameraInternal r2) {
        if (r2.getHasTransform() == true) goto L5;
    L7:
        return false;
    L5:
        if (isMirroringRequired(r2) == false) goto L7;
        return true;
    }

    public static <T extends VideoOutput> VideoCapture<T> withOutput(T r1) {
        return new Builder((VideoOutput) Preconditions.checkNotNull(r1)).build();
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config r1) {
        return Builder.fromConfig(r1);
    }

    @Override // androidx.camera.core.UseCase
    public StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config r5) {
        this.mSessionConfigBuilder.addImplementationOptions(r5);
        Object[] r2 = {this.mSessionConfigBuilder.build()};
        ArrayList r0 = new ArrayList(1);
        Object r1 = r2[0];
        Objects.requireNonNull(r1);
        r0.add(r1);
        updateSessionConfig(Collections.unmodifiableList(r0));
        StreamSpec r3 = getAttachedStreamSpec();
        Objects.requireNonNull(r3);
        return r3.toBuilder().setImplementationOptions(r5).build();
    }

    public void setSourceState(VideoOutput.SourceState r2) {
        if (r2 == this.mSourceState) goto L6;
        this.mSourceState = r2;
        getOutput().onSourceStateChanged(r2);
        return;
    }

    public void setTargetRotation(int r1) {
        if (setTargetRotationInternal(r1) == false) goto L6;
        sendTransformationInfoIfReady();
        return;
    }

    @Override // androidx.camera.core.UseCase
    public void setViewPortCropRect(Rect r1) {
        super.setViewPortCropRect(r1);
        sendTransformationInfoIfReady();
    }

    public static /* synthetic */ void access$000(VideoCapture r0, List r1) {
        r0.updateSessionConfig(r1);
    }

    public static /* synthetic */ void access$200(VideoCapture r0, List r1) {
        r0.updateSessionConfig(r1);
    }

    private Rect adjustCropRectWithInProgressTransformation(Rect r2, int r3) {
        if (shouldCompensateTransformation() == true) goto L5;
        return r2;
    L5:
        return TransformUtils.sizeToRect(TransformUtils.getRotatedSize(((SurfaceRequest.TransformationInfo) Preconditions.checkNotNull(this.mStreamInfo.getInProgressTransformationInfo())).getCropRect(), r3));
    }

    private Rect calculateCropRect(Size r5, VideoEncoderInfo r6) {
        if (getViewPortCropRect() == null) goto L5;
        Rect r0 = getViewPortCropRect();
    L6:
        if (r6 != null) goto L8;
    L12:
        return r0;
    L8:
        if (r6.isSizeSupportedAllowSwapping(r0.width(), r0.height()) == true) goto L12;
        return adjustCropRectToValidSize(r0, r5, r6);
    L5:
        r0 = new Rect(0, 0, r5.getWidth(), r5.getHeight());
        goto L6
    }

    private SessionConfig.Builder createPipeline(final VideoCaptureConfig<T> r26, StreamSpec r27) {
        Threads.checkMainThread();
        final CameraInternal r8 = (CameraInternal) Preconditions.checkNotNull(getCamera());
        Size r9 = r27.getResolution();
        Runnable r10 = new i0(this);
        Range<Integer> r11 = resolveFrameRate(r27);
        MediaSpec r2 = getMediaSpec();
        Objects.requireNonNull(r2);
        VideoCapabilities r0 = getVideoCapabilities(r8.getCameraInfo());
        DynamicRange r12 = r27.getDynamicRange();
        VideoEncoderInfo r1 = resolveVideoEncoderInfo(r26.getVideoEncoderInfoFinder(), r0.findNearestHigherSupportedEncoderProfilesFor(r9, r12), r2, r9, r12, r11);
        this.mRotationDegrees = getCompensatedRotation(r8);
        Rect r3 = calculateCropRect(r9, r1);
        Rect r4 = adjustCropRectWithInProgressTransformation(r3, this.mRotationDegrees);
        this.mCropRect = r4;
        Size r13 = adjustResolutionWithInProgressTransformation(r9, r3, r4);
        boolean r14 = true;
        if (shouldCompensateTransformation() == false) goto L5;
        this.mHasCompensatingTransformation = true;
    L5:
        Rect r5 = this.mCropRect;
        Rect r6 = adjustCropRectByQuirk(r5, this.mRotationDegrees, isCreateNodeNeeded(r8, r26, r5, r9), r1);
        this.mCropRect = r6;
        SurfaceProcessorNode r7 = createNodeIfNeeded(r8, r26, r6, r9, r12);
        this.mNode = r7;
        final Timebase r15 = resolveTimebase(r8, r7);
        Logger.d(TAG, "camera timebase = " + r8.getCameraInfoInternal().getTimebase() + ", processing timebase = " + r15);
        StreamSpec r18 = r27.toBuilder().setResolution(r13).setExpectedFrameRateRange(r11).build();
        if (this.mCameraEdge == null) goto L9;
        r14 = false;
    L9:
        Preconditions.checkState(r14);
        SurfaceEdge r16 = new SurfaceEdge(2, 34, r18, getSensorToBufferTransformMatrix(), r8.getHasTransform(), this.mCropRect, this.mRotationDegrees, getAppTargetRotation(), shouldMirror(r8));
        this.mCameraEdge = r16;
        r16.addOnInvalidatedListener(r10);
        if (this.mNode == null) goto L12;
        OutConfig r17 = OutConfig.of(this.mCameraEdge);
        final SurfaceEdge r19 = this.mNode.transform2(SurfaceProcessorNode.In.of(this.mCameraEdge, Collections.singletonList(r17))).get(r17);
        Objects.requireNonNull(r19);
        r19.addOnInvalidatedListener(new j0(this, r19, r8, r26, r15));
        this.mSurfaceRequest = r19.createSurfaceRequest(r8);
        final DeferrableSurface r20 = this.mCameraEdge.getDeferrableSurface();
        this.mDeferrableSurface = r20;
        r20.getTerminationFuture().addListener(new k0(this, r20), CameraXExecutors.mainThreadExecutor());
    L13:
        r26.getVideoOutput().onSurfaceRequested(this.mSurfaceRequest, r15);
        sendTransformationInfoIfReady();
        this.mDeferrableSurface.setContainerClass(MediaCodec.class);
        SessionConfig.Builder r21 = SessionConfig.Builder.createFrom(r26, r27.getResolution());
        r21.setExpectedFrameRateRange(r27.getExpectedFrameRateRange());
        r21.setVideoStabilization(UseCaseConfig.CC.$default$getVideoStabilizationMode(r26));
        SessionConfig.CloseableErrorListener r22 = this.mCloseableErrorListener;
        if (r22 == null) goto L16;
        r22.close();
    L16:
        SessionConfig.CloseableErrorListener r23 = new SessionConfig.CloseableErrorListener(new l0(this));
        this.mCloseableErrorListener = r23;
        r21.setErrorListener(r23);
        if (r27.getImplementationOptions() == null) goto L19;
        r21.addImplementationOptions(r27.getImplementationOptions());
    L19:
        return r21;
    L12:
        SurfaceRequest r24 = this.mCameraEdge.createSurfaceRequest(r8);
        this.mSurfaceRequest = r24;
        this.mDeferrableSurface = r24.getDeferrableSurface();
        goto L13
    }

    private static <T> T fetchObservableValue(Observable<T> r1, T r2) {
        ListenableFuture<T> r3 = r1.fetchData();
        if (r3.isDone() == true) goto L12;
        return r2;
    L12:
        return (T) r3.get();
    L7:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private /* synthetic */ void lambda$createPipeline$3(SessionConfig r1, SessionConfig.SessionError r2) {
        resetPipeline();
    }

    private /* synthetic */ Object lambda$setupSurfaceUpdateNotifier$6(final SessionConfig.Builder r6, CallbackToFutureAdapter.Completer r7) throws Exception {
        r6.addTag(SURFACE_UPDATE_KEY, Integer.valueOf(r7.hashCode()));
        final AtomicBoolean r0 = new AtomicBoolean(false);
        final AnonymousClass2 r3 = new AnonymousClass2(this, r0, r7, r6);
        r7.addCancellationListener(new h0(r0, r6, r3), CameraXExecutors.directExecutor());
        r6.addRepeatingCameraCaptureCallback(r3);
        return String.format("%s[0x%x]", new Object[]{SURFACE_UPDATE_KEY, Integer.valueOf(r7.hashCode())});
    }

    private static Timebase resolveTimebase(CameraInternal r0, SurfaceProcessorNode r1) {
        if (r1 != null) goto L8;
        if (r0.getHasTransform() == false) goto L8;
        return Timebase.UPTIME;
    L8:
        return r0.getCameraInfoInternal().getTimebase();
    }

    private void setupSurfaceUpdateNotifier(final SessionConfig.Builder r3, final boolean r4) {
        ListenableFuture<Void> r0 = this.mSurfaceUpdateFuture;
        if (r0 != null) goto L5;
    L7:
        final ListenableFuture<Void> r5 = CallbackToFutureAdapter.getFuture(new m0(this, r3));
        this.mSurfaceUpdateFuture = r5;
        Futures.addCallback(r5, new AnonymousClass3(this, r5, r4), CameraXExecutors.mainThreadExecutor());
        return;
    L5:
        if (r0.cancel(false) == false) goto L7;
        Logger.d(TAG, "A newer surface update is requested. Previous surface update cancelled.");
        goto L7
    }

    private static boolean shouldCrop(Rect r2, Size r3) {
        if (r3.getWidth() == r2.width()) goto L5;
    L8:
        return true;
    L5:
        if (r3.getHeight() != r2.height()) goto L8;
        return false;
    }

    private static <T extends VideoOutput> boolean shouldEnableSurfaceProcessingByConfig(CameraInternal r0, VideoCaptureConfig<T> r1) {
        if (r0.getHasTransform() == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.isSurfaceProcessingForceEnabled() == false) goto L7;
        return true;
    }

    private void updateCustomOrderedResolutionsByQuality(CameraInfoInternal r10, UseCaseConfig.Builder<?, ?, ?> r11) throws IllegalArgumentException {
        MediaSpec r1 = getMediaSpec();
        if (r1 == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Unable to update target resolution by null MediaSpec.");
        DynamicRange r2 = getDynamicRange();
        VideoCapabilities r3 = getVideoCapabilities(r10);
        List<Quality> r4 = r3.getSupportedQualities(r2);
        if (r4.isEmpty() == false) goto L10;
        Logger.w(TAG, "Can't find any supported quality on the device.");
        return;
    L10:
        VideoSpec r5 = r1.getVideoSpec();
        QualitySelector r6 = r5.getQualitySelector();
        List<Quality> r7 = r6.getPrioritizedQualities(r4);
        Logger.d(TAG, "Found selectedQualities " + r7 + " by " + r6);
        if (r7.isEmpty() == true) goto L19;
        int r8 = r5.getAspectRatio();
        Map<Quality, Size> r9 = QualitySelector.getQualityToResolutionMap(r3, r2);
        QualityRatioToResolutionsTable r12 = new QualityRatioToResolutionsTable(r10.getSupportedResolutions(getImageFormat()), r9);
        ArrayList r13 = new ArrayList();
        Iterator<Quality> r14 = r7.iterator();
    L14:
        if (r14.hasNext() == false) goto L16;
        r13.addAll(r12.getResolutions(r14.next(), r8));
        goto L14
    L16:
        List<Size> r15 = filterOutEncoderUnsupportedResolutions((VideoCaptureConfig) r11.getUseCaseConfig(), r1, r2, r3, r13, r9);
        Logger.d(TAG, "Set custom ordered resolutions = " + r15);
        r11.getMutableConfig().insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, r15);
        return;
    L19:
        throw new IllegalArgumentException("Unable to find supported quality by QualitySelector");
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> getDefaultConfig(boolean r4, UseCaseConfigFactory r5) {
        Defaults r0 = DEFAULT_CONFIG;
        VideoCaptureConfig<?> r1 = r0.getConfig();
        r1.getClass();
        Config r6 = r5.getConfig(UseCaseConfig.CC.$default$getCaptureType(r1), 1);
        if (r4 == false) goto L5;
        r6 = Config.CC.mergeConfigs(r6, r0.getConfig());
    L5:
        if (r6 != null) goto L8;
        return null;
    L8:
        return getUseCaseConfigBuilder(r6).getUseCaseConfig();
    }

    public boolean isStreamIdChanged(int r3, int r4) {
        Set<Integer> r0 = StreamInfo.NON_SURFACE_STREAM_ID;
        if (r0.contains(Integer.valueOf(r3)) == false) goto L5;
    L8:
        return false;
    L5:
        if (r0.contains(Integer.valueOf(r4)) == true) goto L8;
        if (r3 == r4) goto L8;
        return true;
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> onMergeConfig(CameraInfoInternal r1, UseCaseConfig.Builder<?, ?, ?> r2) {
        updateCustomOrderedResolutionsByQuality(r1, r2);
        return r2.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec r4, StreamSpec r5) {
        Logger.d(TAG, "onSuggestedStreamSpecUpdated: " + r4);
        VideoCaptureConfig r6 = (VideoCaptureConfig) getCurrentConfig();
        r6.getClass();
        List r7 = ImageOutputConfig.CC.$default$getCustomOrderedResolutions(r6, null);
        if (r7 != null) goto L5;
    L7:
        return r4;
    L5:
        if (r7.contains(r4.getResolution()) == true) goto L7;
        Logger.w(TAG, "suggested resolution " + r4.getResolution() + " is not in custom ordered resolutions " + r7);
        goto L7
    }

    public boolean shouldResetCompensatingTransformation(StreamInfo r2, StreamInfo r3) {
        if (this.mHasCompensatingTransformation == true) goto L5;
    L9:
        return false;
    L5:
        if (r2.getInProgressTransformationInfo() == null) goto L9;
        if (r3.getInProgressTransformationInfo() != null) goto L9;
        return true;
    }

    private static Rect adjustCropRectToValidSize(final Rect r10, Size r11, VideoEncoderInfo r12) {
        Logger.d(TAG, String.format("Adjust cropRect %s by width/height alignment %d/%d and supported widths %s / supported heights %s", new Object[]{TransformUtils.rectToString(r10), Integer.valueOf(r12.getWidthAlignment()), Integer.valueOf(r12.getHeightAlignment()), r12.getSupportedWidths(), r12.getSupportedHeights()}));
        if (r12.getSupportedWidths().contains(Integer.valueOf(r10.width())) == false) goto L8;
        if (r12.getSupportedHeights().contains(Integer.valueOf(r10.height())) == false) goto L8;
    L14:
        boolean r0 = false;
    L15:
        if (r0 == false) goto L17;
        r12 = new SwappedVideoEncoderInfo(r12);
    L17:
        int r1 = r12.getWidthAlignment();
        int r5 = r12.getHeightAlignment();
        Range<Integer> r6 = r12.getSupportedWidths();
        Range<Integer> r7 = r12.getSupportedHeights();
        int r8 = alignDown(r10.width(), r1, r6);
        int r2 = alignUp(r10.width(), r1, r6);
        int r9 = alignDown(r10.height(), r5, r7);
        int r13 = alignUp(r10.height(), r5, r7);
        HashSet r14 = new HashSet();
        addBySupportedSize(r14, r8, r9, r11, r12);
        addBySupportedSize(r14, r8, r13, r11, r12);
        addBySupportedSize(r14, r2, r9, r11, r12);
        addBySupportedSize(r14, r2, r13, r11, r12);
        if (r14.isEmpty() == false) goto L21;
        Logger.w(TAG, "Can't find valid cropped size");
        return r10;
    L21:
        ArrayList r15 = new ArrayList(r14);
        Logger.d(TAG, "candidatesList = " + r15);
        Collections.sort(r15, new g0(r10));
        Logger.d(TAG, "sorted candidatesList = " + r15);
        Size r16 = (Size) ListProtector.get(r15, 0);
        int r3 = r16.getWidth();
        int r17 = r16.getHeight();
        if (r3 != r10.width()) goto L28;
        if (r17 != r10.height()) goto L28;
        Logger.d(TAG, "No need to adjust cropRect because crop size is valid.");
        return r10;
    L28:
        if ((r3 % 2) == 0) goto L30;
    L36:
        boolean r18 = false;
    L37:
        Preconditions.checkState(r18);
        Rect r19 = new Rect(r10);
        if (r3 == r10.width()) goto L43;
        int r20 = Math.max(0, r10.centerX() - (r3 / 2));
        r19.left = r20;
        int r21 = r20 + r3;
        r19.right = r21;
        if (r21 <= r11.getWidth()) goto L43;
        int r22 = r11.getWidth();
        r19.right = r22;
        r19.left = r22 - r3;
    L43:
        if (r17 == r10.height()) goto L47;
        int r4 = Math.max(0, r10.centerY() - (r17 / 2));
        r19.top = r4;
        int r23 = r4 + r17;
        r19.bottom = r23;
        if (r23 <= r11.getHeight()) goto L47;
        int r110 = r11.getHeight();
        r19.bottom = r110;
        r19.top = r110 - r17;
    L47:
        Logger.d(TAG, String.format("Adjust cropRect from %s to %s", new Object[]{TransformUtils.rectToString(r10), TransformUtils.rectToString(r19)}));
        return r19;
    L30:
        if ((r17 % 2) != 0) goto L36;
        if (r3 > r11.getWidth()) goto L36;
        if (r17 > r11.getHeight()) goto L36;
        r18 = true;
    L8:
        if (r12.canSwapWidthHeight() == false) goto L14;
        if (r12.getSupportedHeights().contains(Integer.valueOf(r10.width())) == false) goto L14;
        if (r12.getSupportedWidths().contains(Integer.valueOf(r10.height())) == false) goto L14;
        r0 = true;
        goto L15
    }

    private Size adjustResolutionWithInProgressTransformation(Size r4, Rect r5, Rect r6) {
        if (shouldCompensateTransformation() == true) goto L5;
        return r4;
    L5:
        if (r6.equals(r5) == true) goto L9;
        float r7 = r6.height() / r5.height();
        return new Size((int) Math.ceil(r4.getWidth() * r7), (int) Math.ceil(r4.getHeight() * r7));
    L9:
        return r4;
    }

    private static int alignDown(int r1, int r2, Range<Integer> r3) {
        return align(true, r1, r2, r3);
    }

    private static int alignUp(int r1, int r2, Range<Integer> r3) {
        return align(false, r1, r2, r3);
    }

    private static /* synthetic */ int lambda$adjustCropRectToValidSize$4(Rect r2, Size r3, Size r4) {
        return (Math.abs(r3.getWidth() - r2.width()) + Math.abs(r3.getHeight() - r2.height())) - (Math.abs(r4.getWidth() - r2.width()) + Math.abs(r4.getHeight() - r2.height()));
    }

    private static /* synthetic */ void lambda$setupSurfaceUpdateNotifier$5(AtomicBoolean r2, SessionConfig.Builder r3, CameraCaptureCallback r4) {
        Preconditions.checkState(Threads.isMainThread(), "Surface update cancellation should only occur on main thread.");
        r2.set(true);
        r3.removeCameraCaptureCallback(r4);
    }

    public void applyStreamInfoAndStreamSpecToSessionConfigBuilder(SessionConfig.Builder r6, StreamInfo r7, StreamSpec r8) {
        boolean r1 = true;
        if (r7.getId() != (-1)) goto L5;
        boolean r0 = true;
    L7:
        if (r7.getStreamState() == StreamInfo.StreamState.ACTIVE) goto L10;
        r1 = false;
    L10:
        if (r0 == false) goto L15;
        if (r1 == false) goto L15;
        throw new IllegalStateException("Unexpected stream state, stream is error but active");
    L15:
        r6.clearSurfaces();
        DynamicRange r9 = r8.getDynamicRange();
        if (r0 == true) goto L22;
        DeferrableSurface r10 = this.mDeferrableSurface;
        if (r10 == null) goto L22;
        if (r1 == false) goto L21;
        r6.addSurface(r10, r9, null, -1);
        goto L22
    L21:
        r6.addNonRepeatingSurface(r10, r9);
    L22:
        setupSurfaceUpdateNotifier(r6, r1);
        return;
    L5:
        r0 = false;
        goto L7
    }

    private static Rect adjustCropRectByQuirk(Rect r1, int r2, boolean r3, VideoEncoderInfo r4) {
        SizeCannotEncodeVideoQuirk r0 = (SizeCannotEncodeVideoQuirk) DeviceQuirks.get(SizeCannotEncodeVideoQuirk.class);
        if (r0 == null) goto L9;
        if (r3 == true) goto L8;
        r2 = 0;
    L8:
        return r0.adjustCropRectForProblematicEncodeSize(r1, r2, r4);
    L9:
        return r1;
    }

    private static int align(boolean r1, int r2, int r3, Range<Integer> r4) {
        int r0 = r2 % r3;
        if (r0 == 0) goto L9;
        if (r1 == false) goto L7;
        r2 = r2 - r0;
        goto L9
    L7:
        r2 = r2 + (r3 - r0);
    L9:
        return ((Integer) r4.clamp(Integer.valueOf(r2))).intValue();
    }

    private boolean isCreateNodeNeeded(CameraInternal r2, VideoCaptureConfig<?> r3, Rect r4, Size r5) {
        if (getEffect() == null) goto L5;
    L16:
        return true;
    L5:
        if (shouldEnableSurfaceProcessingByConfig(r2, r3) == true) goto L16;
        if (shouldEnableSurfaceProcessingByQuirk(r2) == true) goto L16;
        if (shouldCrop(r4, r5) == true) goto L16;
        if (shouldMirror(r2) == true) goto L16;
        if (shouldCompensateTransformation() == true) goto L16;
        return false;
    }

    private /* synthetic */ void lambda$createPipeline$1(SurfaceEdge r1, CameraInternal r2, VideoCaptureConfig r3, Timebase r4) {
        onAppEdgeInvalidated(r1, r2, r3, r4);
    }

    private void onAppEdgeInvalidated(SurfaceEdge r2, CameraInternal r3, VideoCaptureConfig<T> r4, Timebase r5) {
        if (r3 != getCamera()) goto L6;
        this.mSurfaceRequest = r2.createSurfaceRequest(r3);
        r4.getVideoOutput().onSurfaceRequested(this.mSurfaceRequest, r5);
        sendTransformationInfoIfReady();
        return;
    }

    private static void addBySupportedSize(Set<Size> r3, int r4, int r5, Size r6, VideoEncoderInfo r7) {
        if (r4 <= r6.getWidth()) goto L5;
        return;
    L5:
        if (r5 > r6.getHeight()) goto L21;
        r3.add(new Size(r4, ((Integer) r7.getSupportedHeightsFor(r4).clamp(Integer.valueOf(r5))).intValue()));     // Catch: IllegalArgumentException -> L9
    L18:
        r3.add(new Size(((Integer) r7.getSupportedWidthsFor(r5).clamp(Integer.valueOf(r4))).intValue(), r5));     // Catch: IllegalArgumentException -> L13
        return;
    L13:
        e = move-exception;
        Logger.w(TAG, "No supportedWidths for height: " + r5, e);
        return;
    L9:
        e = move-exception;
        Logger.w(TAG, "No supportedHeights for width: " + r4, e);
        goto L18
    }

    private SurfaceProcessorNode createNodeIfNeeded(CameraInternal r1, VideoCaptureConfig<T> r2, Rect r3, Size r4, DynamicRange r5) {
        if (isCreateNodeNeeded(r1, r2, r3, r4) == false) goto L10;
        Logger.d(TAG, "Surface processing is enabled.");
        CameraInternal r6 = getCamera();
        Objects.requireNonNull(r6);
        CameraInternal r7 = r6;
        if (getEffect() == null) goto L7;
        SurfaceProcessorInternal r8 = getEffect().createSurfaceProcessorInternal();
    L9:
        return new SurfaceProcessorNode(r7, r8);
    L7:
        r8 = DefaultSurfaceProcessor.Factory.newInstance(r5);
        goto L9
    L10:
        return null;
    }

    private static List<Size> filterOutEncoderUnsupportedResolutions(VideoCaptureConfig<?> r8, MediaSpec r9, DynamicRange r10, VideoCapabilities r11, List<Size> r12, Map<Quality, Size> r13) {
        if (r12.isEmpty() == false) goto L5;
        return r12;
    L5:
        Iterator<Size> r0 = r12.iterator();
    L7:
        if (r0.hasNext() == false) goto L19;
        Size r1 = r0.next();
        if (r13.containsValue(r1) == true) goto L7;
        VideoValidatedEncoderProfilesProxy r3 = r11.findNearestHigherSupportedEncoderProfilesFor(r1, r10);
        if (r3 == null) goto L7;
        Function<VideoEncoderConfig, VideoEncoderInfo> r2 = r8.getVideoEncoderInfoFinder();
        Range r7 = UseCaseConfig.CC.$default$getTargetFrameRate(r8, Defaults.DEFAULT_FPS_RANGE);
        Objects.requireNonNull(r7);
        VideoEncoderInfo r4 = findLargestSupportedSizeVideoEncoderInfo(r2, r3, r10, r9, r1, r7);
        if (r4 == null) goto L7;
        if (r4.isSizeSupportedAllowSwapping(r1.getWidth(), r1.getHeight()) == true) goto L7;
        r0.remove();
        goto L7
    L19:
        return r12;
    }

    private static VideoEncoderInfo findLargestSupportedSizeVideoEncoderInfo(Function<VideoEncoderConfig, VideoEncoderInfo> r12, VideoValidatedEncoderProfilesProxy r13, DynamicRange r14, MediaSpec r15, Size r16, Range<Integer> r17) {
        if (r14.isFullySpecified() == true) goto L5;
        Iterator<EncoderProfilesProxy.VideoProfileProxy> r0 = r13.getVideoProfiles().iterator();
        VideoEncoderInfo r1 = null;
        int r2 = RtlSpacingHelper.UNDEFINED;
    L8:
        if (r0.hasNext() == false) goto L17;
        EncoderProfilesProxy.VideoProfileProxy r3 = r0.next();
        if (DynamicRangeUtil.isHdrSettingsMatched(r3, r14) == false) goto L8;
        VideoEncoderInfo r4 = resolveVideoEncoderInfo(r12, r13, r15, r16, new DynamicRange(DynamicRangeUtil.videoProfileHdrFormatsToDynamicRangeEncoding(r3.getHdrFormat()), DynamicRangeUtil.videoProfileBitDepthToDynamicRangeBitDepth(r3.getBitDepth())), r17);
        if (r4 == null) goto L8;
        int r5 = SizeUtil.getArea(((Integer) r4.getSupportedWidths().getUpper()).intValue(), ((Integer) r4.getSupportedHeights().getUpper()).intValue());
        if (r5 <= r2) goto L8;
        r1 = r4;
        r2 = r5;
        goto L8
    L17:
        return r1;
    L5:
        return resolveVideoEncoderInfo(r12, r13, r15, r16, r14, r17);
    }

    private static VideoEncoderInfo resolveVideoEncoderInfo(Function<VideoEncoderConfig, VideoEncoderInfo> r6, VideoValidatedEncoderProfilesProxy r7, MediaSpec r8, Size r9, DynamicRange r10, Range<Integer> r11) {
        VideoEncoderInfo r12 = r6.apply(VideoConfigUtil.resolveVideoEncoderConfig(VideoConfigUtil.resolveVideoMimeInfo(r8, r10, r7), Timebase.UPTIME, r8.getVideoSpec(), r9, r10, r11));
        Size r13 = null;
        if (r12 != null) goto L6;
        Logger.w(TAG, "Can't find videoEncoderInfo");
        return null;
    L6:
        if (r7 == null) goto L9;
        r13 = new Size(r7.getDefaultVideoProfile().getWidth(), r7.getDefaultVideoProfile().getHeight());
    L9:
        return VideoEncoderInfoWrapper.from(r12, r13);
    }
}

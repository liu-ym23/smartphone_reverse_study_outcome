package androidx.camera.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.location.Location;
import android.media.MediaMuxer;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.MutableStateObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.StateObservable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.CloseGuardHelper;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.utils.ArrayRingBuffer;
import androidx.camera.core.internal.utils.RingBuffer;
import androidx.camera.video.internal.DebugUtils;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.internal.audio.AudioSourceAccessException;
import androidx.camera.video.internal.compat.Api26Impl;
import androidx.camera.video.internal.compat.quirk.DeactivateEncoderSurfaceBeforeStopEncoderQuirk;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.EncoderNotUsePersistentInputSurfaceQuirk;
import androidx.camera.video.internal.config.AudioConfigUtil;
import androidx.camera.video.internal.config.AudioMimeInfo;
import androidx.camera.video.internal.encoder.EncodeException;
import androidx.camera.video.internal.encoder.EncodedData;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.encoder.EncoderFactory;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.camera.video.internal.encoder.OutputConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.encoder.VideoEncoderInfoImpl;
import androidx.camera.video.internal.utils.OutputUtil;
import androidx.camera.video.internal.workaround.CorrectNegativeLatLongForMediaMuxer;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Recorder implements VideoOutput {
    private static final int AUDIO_CACHE_SIZE = 60;
    private static final Executor AUDIO_EXECUTOR = null;
    static final EncoderFactory DEFAULT_ENCODER_FACTORY = null;
    public static final QualitySelector DEFAULT_QUALITY_SELECTOR = null;
    private static final String MEDIA_COLUMN = "_data";
    private static final MediaSpec MEDIA_SPEC_DEFAULT = null;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final Exception PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE = null;
    private static final Set<State> PENDING_STATES = null;
    private static final long RETRY_SETUP_VIDEO_DELAY_MS = 1000;
    private static final int RETRY_SETUP_VIDEO_MAX_COUNT = 3;
    private static final long SOURCE_NON_STREAMING_TIMEOUT_MS = 1000;
    private static final String TAG = "Recorder";
    private static final Set<State> VALID_NON_PENDING_STATES_WHILE_PENDING = null;
    public static final int VIDEO_CAPABILITIES_SOURCE_CAMCORDER_PROFILE = 0;
    public static final int VIDEO_CAPABILITIES_SOURCE_CODEC_CAPABILITIES = 1;
    private static final VideoSpec VIDEO_SPEC_DEFAULT = null;
    static long sRetrySetupVideoDelayMs;
    static int sRetrySetupVideoMaxCount;
    RecordingRecord mActiveRecordingRecord;
    Surface mActiveSurface;
    double mAudioAmplitude;
    Encoder mAudioEncoder;
    private final EncoderFactory mAudioEncoderFactory;
    Throwable mAudioErrorCause;
    OutputConfig mAudioOutputConfig;
    AudioSource mAudioSource;
    AudioState mAudioState;
    Integer mAudioTrackIndex;
    long mDurationLimitNs;
    private final boolean mEncoderNotUsePersistentInputSurface;
    final List<ListenableFuture<Void>> mEncodingFutures;
    private final Executor mExecutor;
    long mFileSizeLimitInBytes;
    long mFirstRecordingAudioDataTimeUs;
    int mFirstRecordingVideoBitrate;
    long mFirstRecordingVideoDataTimeUs;
    RecordingRecord mInProgressRecording;
    boolean mInProgressRecordingStopping;
    private SurfaceRequest.TransformationInfo mInProgressTransformationInfo;
    boolean mIsAudioSourceSilenced;
    private final MutableStateObservable<Boolean> mIsRecording;
    private long mLastGeneratedRecordingId;
    Surface mLatestSurface;
    SurfaceRequest mLatestSurfaceRequest;
    private final Object mLock;
    MediaMuxer mMediaMuxer;
    final MutableStateObservable<MediaSpec> mMediaSpec;
    private boolean mNeedsResetBeforeNextStart;
    private State mNonPendingState;
    Uri mOutputUri;
    final RingBuffer<EncodedData> mPendingAudioRingBuffer;
    EncodedData mPendingFirstVideoData;
    RecordingRecord mPendingRecordingRecord;
    long mPreviousRecordingAudioDataTimeUs;
    long mPreviousRecordingVideoDataTimeUs;
    long mRecordingBytes;
    long mRecordingDurationNs;
    int mRecordingStopError;
    Throwable mRecordingStopErrorCause;
    private VideoValidatedEncoderProfilesProxy mResolvedEncoderProfiles;
    final Executor mSequentialExecutor;
    private SetupVideoTask mSetupVideoTask;
    private boolean mShouldSendResumeEvent;
    ScheduledFuture<?> mSourceNonStreamingTimeout;
    VideoOutput.SourceState mSourceState;
    private SurfaceRequest.TransformationInfo mSourceTransformationInfo;
    private State mState;
    int mStreamId;
    private final MutableStateObservable<StreamInfo> mStreamInfo;
    private final Executor mUserProvidedExecutor;
    private final int mVideoCapabilitiesSource;
    Encoder mVideoEncoder;
    Range<Integer> mVideoEncoderBitrateRange;
    private final EncoderFactory mVideoEncoderFactory;
    VideoEncoderSession mVideoEncoderSession;
    VideoEncoderSession mVideoEncoderSessionToRelease;
    OutputConfig mVideoOutputConfig;
    Timebase mVideoSourceTimebase;
    Integer mVideoTrackIndex;

    public static final enum AudioState extends Enum<AudioState> {
        private static final /* synthetic */ AudioState[] $VALUES = null;
        public static final AudioState DISABLED = null;
        public static final AudioState ENABLED = null;
        public static final AudioState ERROR_ENCODER = null;
        public static final AudioState ERROR_SOURCE = null;
        public static final AudioState IDLING = null;
        public static final AudioState INITIALIZING = null;

        private static /* synthetic */ AudioState[] $values() {
            return new AudioState[]{INITIALIZING, IDLING, DISABLED, ENABLED, ERROR_ENCODER, ERROR_SOURCE};
        }

        static {
            INITIALIZING = new AudioState("INITIALIZING", 0);
            IDLING = new AudioState("IDLING", 1);
            DISABLED = new AudioState("DISABLED", 2);
            ENABLED = new AudioState("ENABLED", 3);
            ERROR_ENCODER = new AudioState("ERROR_ENCODER", 4);
            ERROR_SOURCE = new AudioState("ERROR_SOURCE", 5);
            $VALUES = $values();
        }

        public static AudioState[] values() {
            return (AudioState[]) $VALUES.clone();
        }

        public static AudioState valueOf(String r1) {
            return (AudioState) r27.a.a(AudioState.class, r1);
        }

        private AudioState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class Builder {
        private EncoderFactory mAudioEncoderFactory;
        private Executor mExecutor;
        private final MediaSpec.Builder mMediaSpecBuilder;
        private int mVideoCapabilitiesSource;
        private EncoderFactory mVideoEncoderFactory;

        public static /* synthetic */ void a(int r0, VideoSpec.Builder r1) {
            lambda$setAspectRatio$2(r0, r1);
        }

        public static /* synthetic */ void b(QualitySelector r0, VideoSpec.Builder r1) {
            lambda$setQualitySelector$0(r0, r1);
        }

        public static /* synthetic */ void c(int r0, AudioSpec.Builder r1) {
            lambda$setAudioSource$3(r0, r1);
        }

        public static /* synthetic */ void d(int r0, VideoSpec.Builder r1) {
            lambda$setTargetVideoEncodingBitRate$1(r0, r1);
        }

        public Recorder build() {
            return new Recorder(this.mExecutor, this.mMediaSpecBuilder.build(), this.mVideoCapabilitiesSource, this.mVideoEncoderFactory, this.mAudioEncoderFactory);
        }

        public Builder() {
            this.mVideoCapabilitiesSource = 0;
            this.mExecutor = null;
            EncoderFactory r0 = Recorder.DEFAULT_ENCODER_FACTORY;
            this.mVideoEncoderFactory = r0;
            this.mAudioEncoderFactory = r0;
            this.mMediaSpecBuilder = MediaSpec.builder();
        }

        public Builder setAspectRatio(final int r3) {
            this.mMediaSpecBuilder.configureVideo(new w(r3));
            return this;
        }

        public Builder setAudioEncoderFactory(EncoderFactory r1) {
            this.mAudioEncoderFactory = r1;
            return this;
        }

        public Builder setAudioSource(final int r3) {
            this.mMediaSpecBuilder.configureAudio(new u(r3));
            return this;
        }

        public Builder setExecutor(Executor r2) {
            Preconditions.checkNotNull(r2, "The specified executor can't be null.");
            this.mExecutor = r2;
            return this;
        }

        public Builder setQualitySelector(final QualitySelector r3) {
            Preconditions.checkNotNull(r3, "The specified quality selector can't be null.");
            this.mMediaSpecBuilder.configureVideo(new t(r3));
            return this;
        }

        public Builder setTargetVideoEncodingBitRate(final int r4) {
            if (r4 <= 0) goto L6;
            this.mMediaSpecBuilder.configureVideo(new v(r4));
            return this;
        L6:
            throw new IllegalArgumentException("The requested target bitrate " + r4 + " is not supported. Target bitrate must be greater than 0.");
        }

        public Builder setVideoCapabilitiesSource(int r4) {
            boolean r0 = true;
            if (r4 == 0) goto L7;
            if (r4 == 1) goto L7;
            r0 = false;
        L7:
            Preconditions.checkArgument(r0, "Not a supported video capabilities source: " + r4);
            this.mVideoCapabilitiesSource = r4;
            return this;
        }

        public Builder setVideoEncoderFactory(EncoderFactory r1) {
            this.mVideoEncoderFactory = r1;
            return this;
        }

        private static /* synthetic */ void lambda$setAspectRatio$2(int r0, VideoSpec.Builder r1) {
            r1.setAspectRatio(r0);
        }

        private static /* synthetic */ void lambda$setAudioSource$3(int r0, AudioSpec.Builder r1) {
            r1.setSource(r0);
        }

        private static /* synthetic */ void lambda$setQualitySelector$0(QualitySelector r0, VideoSpec.Builder r1) {
            r1.setQualitySelector(r0);
        }

        private static /* synthetic */ void lambda$setTargetVideoEncodingBitRate$1(int r2, VideoSpec.Builder r3) {
            r3.setBitrate(new Range(Integer.valueOf(r2), Integer.valueOf(r2)));
        }
    }

    public static abstract class RecordingRecord implements AutoCloseable {
        private final AtomicReference<AudioSourceSupplier> mAudioSourceSupplier;
        private final CloseGuardHelper mCloseGuard;
        private final AtomicBoolean mInitialized;
        private final AtomicReference<MediaMuxerSupplier> mMediaMuxerSupplier;
        private final AtomicBoolean mMuted;
        private final AtomicReference<Consumer<Uri>> mRecordingFinalizer;
        private final MutableStateObservable<Boolean> mRecordingState;

        public interface AudioSourceSupplier {
            AudioSource get(AudioSettings r1, Executor r2) throws AudioSourceAccessException;
        }

        public interface MediaMuxerSupplier {
            MediaMuxer get(int r1, Consumer<Uri> r2) throws IOException;
        }

        public static /* synthetic */ void a(MediaStoreOutputOptions r0, Uri r1) {
            lambda$initializeRecording$2(r0, r1);
        }

        public static /* synthetic */ void b(MediaStoreOutputOptions r0, Context r1, Uri r2) {
            lambda$initializeRecording$4(r0, r1, r2);
        }

        public static /* synthetic */ void c(ParcelFileDescriptor r0, Uri r1) {
            lambda$initializeRecording$5(r0, r1);
        }

        public static /* synthetic */ MediaMuxer d(OutputOptions r0, ParcelFileDescriptor r1, int r2, Consumer r3) {
            return lambda$initializeRecording$1(r0, r1, r2, r3);
        }

        public static /* synthetic */ void e(String r0, Uri r1) {
            lambda$initializeRecording$3(r0, r1);
        }

        public static /* synthetic */ void f(RecordingRecord r0, VideoRecordEvent r1) {
            r0.lambda$updateVideoRecordEvent$6(r1);
        }

        public static /* synthetic */ void g(Uri r0) {
            lambda$new$0(r0);
        }

        private static /* synthetic */ void lambda$new$0(Uri r0) {
        }

        public abstract Executor getCallbackExecutor();

        public abstract Consumer<VideoRecordEvent> getEventListener();

        public abstract OutputOptions getOutputOptions();

        public abstract long getRecordingId();

        public abstract boolean hasAudioEnabled();

        public abstract boolean isPersistent();

        @Override // java.lang.AutoCloseable
        public void close() {
            finalizeRecording(Uri.EMPTY);
        }

        public void finalize() throws Throwable {
            this.mCloseGuard.warnIfOpen();     // Catch: Throwable -> L7
            Consumer<Uri> r0 = this.mRecordingFinalizer.getAndSet(null);     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            finalizeRecordingInternal(r0, Uri.EMPTY);     // Catch: Throwable -> L7
        L5:
            super.finalize();
            return;
        L7:
            th = move-exception;
            super.finalize();
            throw th;
        }

        public boolean isMuted() {
            return this.mMuted.get();
        }

        public RecordingRecord() {
            this.mCloseGuard = CloseGuardHelper.create();
            this.mInitialized = new AtomicBoolean(false);
            this.mMediaMuxerSupplier = new AtomicReference(null);
            this.mAudioSourceSupplier = new AtomicReference(null);
            this.mRecordingFinalizer = new AtomicReference(new d0());
            this.mMuted = new AtomicBoolean(false);
            this.mRecordingState = MutableStateObservable.withInitialState(Boolean.FALSE);
        }

        public StateObservable<Boolean> getRecordingState() {
            return this.mRecordingState;
        }

        private /* synthetic */ void lambda$updateVideoRecordEvent$6(VideoRecordEvent r2) {
            getEventListener().accept(r2);
        }

        private void updateRecordingState(VideoRecordEvent r2) {
            if ((r2 instanceof VideoRecordEvent.Start) == false) goto L5;
        L12:
            this.mRecordingState.setState(Boolean.TRUE);
            return;
        L5:
            if ((r2 instanceof VideoRecordEvent.Resume) == true) goto L12;
            if ((r2 instanceof VideoRecordEvent.Pause) == false) goto L10;
        L11:
            this.mRecordingState.setState(Boolean.FALSE);
            return;
        L10:
            if ((r2 instanceof VideoRecordEvent.Finalize) == true) goto L11;
        }

        public void finalizeRecording(Uri r3) {
            if (this.mInitialized.get() == true) goto L5;
            return;
        L5:
            finalizeRecordingInternal(this.mRecordingFinalizer.getAndSet(null), r3);
        }

        public void initializeRecording(final Context r7) throws IOException {
            if (this.mInitialized.getAndSet(true) == true) goto L26;
            final OutputOptions r0 = getOutputOptions();
            boolean r1 = r0 instanceof FileDescriptorOutputOptions;
            Consumer<Uri> r2 = null;
            if (r1 == false) goto L7;
            final ParcelFileDescriptor r3 = ((FileDescriptorOutputOptions) r0).getParcelFileDescriptor().dup();
        L8:
            this.mCloseGuard.open("finalizeRecording");
            this.mMediaMuxerSupplier.set(new x(r0, r3));
            if (hasAudioEnabled() == false) goto L15;
            if (Build.VERSION.SDK_INT < 31) goto L13;
            this.mAudioSourceSupplier.set(new AnonymousClass1(this, r7));
            goto L15
        L13:
            this.mAudioSourceSupplier.set(new AnonymousClass2(this));
        L15:
            if ((r0 instanceof MediaStoreOutputOptions) == false) goto L20;
            final MediaStoreOutputOptions r4 = (MediaStoreOutputOptions) r0;
            if (Build.VERSION.SDK_INT < 29) goto L19;
            r2 = new y(r4);
        L22:
            if (r2 == null) goto L27;
            this.mRecordingFinalizer.set(r2);
            return;
        L27:
            return;
        L19:
            r2 = new z(r4, r7);
            goto L22
        L20:
            if (r1 == false) goto L22;
            r2 = new a0(r3);
            goto L22
        L7:
            r3 = null;
            goto L8
        L26:
            throw new AssertionError("Recording " + this + " has already been initialized");
        }

        public void mute(boolean r2) {
            this.mMuted.set(r2);
        }

        public void updateVideoRecordEvent(final VideoRecordEvent r5) {
            if (Objects.equals(r5.getOutputOptions(), getOutputOptions()) == false) goto L19;
            String r0 = "Sending VideoRecordEvent ".concat(r5.getClass().getSimpleName());
            if ((r5 instanceof VideoRecordEvent.Finalize) == false) goto L9;
            VideoRecordEvent.Finalize r1 = (VideoRecordEvent.Finalize) r5;
            if (r1.hasError() == false) goto L9;
            r0 = r0 + String.format(" [error: %s]", new Object[]{VideoRecordEvent.Finalize.errorToString(r1.getError())});
        L9:
            Logger.d(Recorder.TAG, r0);
            updateRecordingState(r5);
            if (getCallbackExecutor() != null) goto L12;
            return;
        L12:
            if (getEventListener() == null) goto L23;
            getCallbackExecutor().execute(new c0(this, r5));     // Catch: RejectedExecutionException -> L15
            return;
        L15:
            e = move-exception;
            Logger.e(Recorder.TAG, "The callback executor is invalid.", e);
            return;
        L23:
            return;
        L19:
            throw new AssertionError("Attempted to update event listener with event from incorrect recording [Recording: " + r5.getOutputOptions() + ", Expected: " + getOutputOptions() + "]");
        }

        private void finalizeRecordingInternal(Consumer<Uri> r2, Uri r3) {
            if (r2 == null) goto L6;
            this.mCloseGuard.close();
            r2.accept(r3);
            return;
        L6:
            throw new AssertionError("Recording " + this + " has already been finalized");
        }

        public static RecordingRecord from(PendingRecording r9, long r10) {
            return new AutoValue_Recorder_RecordingRecord(r9.getOutputOptions(), r9.getListenerExecutor(), r9.getEventListener(), r9.isAudioEnabled(), r9.isPersistent(), r10);
        }

        private static /* synthetic */ void lambda$initializeRecording$2(MediaStoreOutputOptions r3, Uri r4) {
            if (r4.equals(Uri.EMPTY) == false) goto L5;
            return;
        L5:
            ContentValues r0 = new ContentValues();
            r0.put("is_pending", 0);
            androidx_camera_video_Recorder$RecordingRecord_android_content_ContentResolver_update(r3.getContentResolver(), r4, r0, null, null);
        }

        private static /* synthetic */ void lambda$initializeRecording$3(String r4, Uri r5) {
            if (r5 != null) goto L5;
            Logger.e(Recorder.TAG, String.format("File scanning operation failed [path: %s]", new Object[]{r4}));
            return;
        L5:
            Logger.d(Recorder.TAG, String.format("File scan completed successfully [path: %s, URI: %s]", new Object[]{r4, r5}));
        }

        private static /* synthetic */ void lambda$initializeRecording$5(ParcelFileDescriptor r1, Uri r2) {
            r1.close();     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            Logger.e(Recorder.TAG, "Failed to close dup'd ParcelFileDescriptor", e);
        }

        public AudioSource performOneTimeAudioSourceCreation(AudioSettings r3, Executor r4) throws AudioSourceAccessException {
            if (hasAudioEnabled() == false) goto L11;
            AudioSourceSupplier r0 = this.mAudioSourceSupplier.getAndSet(null);
            if (r0 == null) goto L9;
            return r0.get(r3, r4);
        L9:
            throw new AssertionError("One-time audio source creation has already occurred for recording " + this);
        L11:
            throw new AssertionError("Recording does not have audio enabled. Unable to create audio source for recording " + this);
        }

        public MediaMuxer performOneTimeMediaMuxerCreation(int r3, Consumer<Uri> r4) throws IOException {
            if (this.mInitialized.get() == false) goto L14;
            MediaMuxerSupplier r0 = this.mMediaMuxerSupplier.getAndSet(null);
            if (r0 == null) goto L12;
            return r0.get(r3, r4);
        L8:
            e = move-exception;
            throw new IOException("Failed to create MediaMuxer by " + e, e);
        L12:
            throw new AssertionError("One-time media muxer creation has already occurred for recording " + this);
        L14:
            throw new AssertionError("Recording " + this + " has not been initialized");
        }

        private static Uri androidx_camera_video_Recorder$RecordingRecord_android_content_ContentResolver_insert(ContentResolver r18, Uri r19, ContentValues r20) throws IOException {
            ArrayList r0 = new ArrayList();
            Object[] r1 = {r19, r20};
            f06.b r11 = new f06.b();
            g06.a r2 = (g06.a) ApiHookConfig.b.get(240017);
            if (r2 == null) goto L5;
            f06.a[] r3 = r2.i;
        L6:
            f06.a[] r15 = r3;
            int r9 = r15.length;
            int r8 = 0;
        L8:
            if (r8 >= r9) goto L15;
            f06.a r7 = r15[r8];
            int r16 = r8;
            int r17 = r9;
            f06.d r4 = r7.preInvoke(240017, "android/content/ContentResolver", "insert", r18, r1, "android.net.Uri", r11);     // Catch: Exception -> L22
            if (r4.a == true) goto L17;
            r0.add(r7);     // Catch: Exception -> L22
        L17:
            if (r4.a == false) goto L21;
            return (Uri) r4.b;
        L21:
            return r18.insert(r19, r20);
        L14:
            r8 = r16 + 1;
            r9 = r17;
            goto L8
        L15:
            r4 = new f06.d(false, null);
            goto L17
        L5:
            r3 = ApiHookConfig.d;
            goto L6
        }

        private static ParcelFileDescriptor androidx_camera_video_Recorder$RecordingRecord_android_content_ContentResolver_openFileDescriptor(ContentResolver r18, Uri r19, String r20) throws IOException {
            ArrayList r0 = new ArrayList();
            Object[] r1 = {r19, r20};
            f06.b r11 = new f06.b();
            g06.a r2 = (g06.a) ApiHookConfig.b.get(240020);
            if (r2 == null) goto L5;
            f06.a[] r3 = r2.i;
        L6:
            f06.a[] r15 = r3;
            int r9 = r15.length;
            int r8 = 0;
        L8:
            if (r8 >= r9) goto L15;
            f06.a r7 = r15[r8];
            int r16 = r8;
            int r17 = r9;
            f06.d r4 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r18, r1, "android.os.ParcelFileDescriptor", r11);     // Catch: Exception -> L22
            if (r4.a == true) goto L17;
            r0.add(r7);     // Catch: Exception -> L22
        L17:
            if (r4.a == false) goto L21;
            return (ParcelFileDescriptor) r4.b;
        L21:
            return r18.openFileDescriptor(r19, r20);
        L14:
            r8 = r16 + 1;
            r9 = r17;
            goto L8
        L15:
            r4 = new f06.d(false, null);
            goto L17
        L5:
            r3 = ApiHookConfig.d;
            goto L6
        }

        private static /* synthetic */ void lambda$initializeRecording$4(MediaStoreOutputOptions r1, Context r2, Uri r3) {
            if (r3.equals(Uri.EMPTY) == false) goto L5;
            return;
        L5:
            String r4 = OutputUtil.getAbsolutePathFromUri(r1.getContentResolver(), r3, Recorder.MEDIA_COLUMN);
            if (r4 == null) goto L8;
            MediaScannerConnection.scanFile(r2, new String[]{r4}, null, new b0());
            return;
        L8:
            Logger.d(Recorder.TAG, "Skipping media scanner scan. Unable to retrieve file path from URI: " + r3);
        }

        private static /* synthetic */ MediaMuxer lambda$initializeRecording$1(OutputOptions r6, ParcelFileDescriptor r7, int r8, Consumer r9) throws IOException {
            Uri r0 = Uri.EMPTY;
            if ((r6 instanceof FileOutputOptions) == false) goto L9;
            File r10 = ((FileOutputOptions) r6).getFile();
            if (OutputUtil.createParentFolder(r10) == true) goto L7;
            Logger.w(Recorder.TAG, "Failed to create folder for " + r10.getAbsolutePath());
        L7:
            MediaMuxer r11 = new MediaMuxer(r10.getAbsolutePath(), r8);
            r0 = Uri.fromFile(r10);
        L33:
            r9.accept(r0);
            return r11;
        L9:
            if ((r6 instanceof FileDescriptorOutputOptions) == false) goto L16;
            if (Build.VERSION.SDK_INT < 26) goto L14;
            r11 = Api26Impl.createMediaMuxer(r7.getFileDescriptor(), r8);
            goto L33
        L14:
            throw new IOException("MediaMuxer doesn't accept FileDescriptor as output destination.");
        L16:
            if ((r6 instanceof MediaStoreOutputOptions) == false) goto L41;
            MediaStoreOutputOptions r12 = (MediaStoreOutputOptions) r6;
            ContentValues r13 = new ContentValues(r12.getContentValues());
            int r1 = Build.VERSION.SDK_INT;
            if (r1 < 29) goto L42;
            r13.put("is_pending", 1);
        L42:
            Uri r14 = androidx_camera_video_Recorder$RecordingRecord_android_content_ContentResolver_insert(r12.getContentResolver(), r12.getCollectionUri(), r13);     // Catch: RuntimeException -> L37
            if (r14 == null) goto L36;
            if (r1 >= 26) goto L31;
            String r15 = OutputUtil.getAbsolutePathFromUri(r12.getContentResolver(), r14, Recorder.MEDIA_COLUMN);
            if (r15 == null) goto L30;
            if (OutputUtil.createParentFolder(new File(r15)) == true) goto L28;
            Logger.w(Recorder.TAG, "Failed to create folder for ".concat(r15));
        L28:
            MediaMuxer r16 = new MediaMuxer(r15, r8);
        L32:
            r0 = r14;
            r11 = r16;
            goto L33
        L30:
            throw new IOException("Unable to get path from uri " + r14);
        L31:
            ParcelFileDescriptor r17 = androidx_camera_video_Recorder$RecordingRecord_android_content_ContentResolver_openFileDescriptor(r12.getContentResolver(), r14, "rw");
            r16 = Api26Impl.createMediaMuxer(r17.getFileDescriptor(), r8);
            r17.close();
            goto L32
        L36:
            throw new IOException("Unable to create MediaStore entry.");
        L37:
            e = move-exception;
            throw new IOException("Unable to create MediaStore entry by " + e, e);
        L41:
            throw new AssertionError("Invalid output options type: ".concat(r6.getClass().getSimpleName()));
        }

        private static int androidx_camera_video_Recorder$RecordingRecord_android_content_ContentResolver_update(ContentResolver r18, Uri r19, ContentValues r20, String r21, String[] r22) {
            ArrayList r0 = new ArrayList();
            Object[] r1 = {r19, r20, r21, r22};
            f06.b r11 = new f06.b();
            g06.a r2 = (g06.a) ApiHookConfig.b.get(240018);
            if (r2 == null) goto L5;
            f06.a[] r3 = r2.i;
        L6:
            f06.a[] r15 = r3;
            int r9 = r15.length;
            int r8 = 0;
        L8:
            if (r8 >= r9) goto L15;
            f06.a r7 = r15[r8];
            int r16 = r8;
            int r17 = r9;
            f06.d r4 = r7.preInvoke(240018, "android/content/ContentResolver", "update", r18, r1, "int", r11);     // Catch: Exception -> L22
            if (r4.a == true) goto L17;
            r0.add(r7);     // Catch: Exception -> L22
        L17:
            if (r4.a == false) goto L21;
            return ((Integer) r4.b).intValue();
        L21:
            return r18.update(r19, r20, r21, r22);
        L14:
            r8 = r16 + 1;
            r9 = r17;
            goto L8
        L15:
            r4 = new f06.d(false, null);
            goto L17
        L5:
            r3 = ApiHookConfig.d;
            goto L6
        }
    }

    public class SetupVideoTask {
        private boolean mIsFailedRetryCanceled;
        private final int mMaxRetryCount;
        private int mRetryCount;
        private ScheduledFuture<?> mRetryFuture;
        private final SurfaceRequest mSurfaceRequest;
        private final Timebase mTimebase;
        final /* synthetic */ Recorder this$0;

        /* JADX INFO: renamed from: androidx.camera.video.Recorder$SetupVideoTask$1, reason: invalid class name */
        public class AnonymousClass1 implements FutureCallback<Encoder> {
            final /* synthetic */ SetupVideoTask this$1;
            final /* synthetic */ VideoEncoderSession val$videoEncoderSession;

            public static /* synthetic */ void a(AnonymousClass1 r0) {
                r0.lambda$onFailure$0();
            }

            private /* synthetic */ void lambda$onFailure$0() {
                if (SetupVideoTask.access$800(this.this$1) == true) goto L6;
                Logger.d(Recorder.TAG, "Retry setupVideo #" + SetupVideoTask.access$400(this.this$1));
                SetupVideoTask r0 = this.this$1;
                SetupVideoTask.access$1100(r0, SetupVideoTask.access$900(r0), SetupVideoTask.access$1000(this.this$1));
                return;
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable r6) {
                Logger.w(Recorder.TAG, "VideoEncoder Setup error: " + r6, r6);
                if (SetupVideoTask.access$400(this.this$1) >= SetupVideoTask.access$500(this.this$1)) goto L5;
                SetupVideoTask.access$408(this.this$1);
                SetupVideoTask r7 = this.this$1;
                SetupVideoTask.access$602(r7, Recorder.access$700(new f0(this), r7.this$0.mSequentialExecutor, Recorder.sRetrySetupVideoDelayMs, TimeUnit.MILLISECONDS));
                return;
            L5:
                this.this$1.this$0.onEncoderSetupError(r6);
            }

            /* JADX INFO: renamed from: onSuccess, reason: avoid collision after fix types in other method */
            public void onSuccess2(Encoder r4) {
                Logger.d(Recorder.TAG, "VideoEncoder is created. " + r4);
                if (r4 != null) goto L5;
                return;
            L5:
                boolean r1 = true;
                if (this.this$1.this$0.mVideoEncoderSession != this.val$videoEncoderSession) goto L8;
                boolean r5 = true;
            L9:
                Preconditions.checkState(r5);
                if (this.this$1.this$0.mVideoEncoder == null) goto L13;
                r1 = false;
            L13:
                Preconditions.checkState(r1);
                this.this$1.this$0.onVideoEncoderReady(this.val$videoEncoderSession);
                this.this$1.this$0.onConfigured();
                return;
            L8:
                r5 = false;
                goto L9
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public /* bridge */ /* synthetic */ void onSuccess(Encoder r1) {
                onSuccess2(r1);
            }

            public AnonymousClass1(SetupVideoTask r1, VideoEncoderSession r2) {
                this.this$1 = r1;
                this.val$videoEncoderSession = r2;
            }
        }

        public static /* synthetic */ void a(SetupVideoTask r0, SurfaceRequest r1, Timebase r2) {
            r0.lambda$setupVideo$0(r1, r2);
        }

        public void cancelFailedRetry() {
            if (this.mIsFailedRetryCanceled == false) goto L5;
            return;
        L5:
            this.mIsFailedRetryCanceled = true;
            ScheduledFuture<?> r0 = this.mRetryFuture;
            if (r0 == null) goto L9;
            r0.cancel(false);
            this.mRetryFuture = null;
            return;
        }

        public void start() {
            setupVideo(this.mSurfaceRequest, this.mTimebase);
        }

        public static /* synthetic */ Timebase access$1000(SetupVideoTask r0) {
            return r0.mTimebase;
        }

        public static /* synthetic */ int access$400(SetupVideoTask r0) {
            return r0.mRetryCount;
        }

        public static /* synthetic */ int access$408(SetupVideoTask r2) {
            int r0 = r2.mRetryCount;
            r2.mRetryCount = r0 + 1;
            return r0;
        }

        public static /* synthetic */ int access$500(SetupVideoTask r0) {
            return r0.mMaxRetryCount;
        }

        public static /* synthetic */ boolean access$800(SetupVideoTask r0) {
            return r0.mIsFailedRetryCanceled;
        }

        public static /* synthetic */ SurfaceRequest access$900(SetupVideoTask r0) {
            return r0.mSurfaceRequest;
        }

        public static /* synthetic */ ScheduledFuture access$602(SetupVideoTask r0, ScheduledFuture r1) {
            r0.mRetryFuture = r1;
            return r1;
        }

        private /* synthetic */ void lambda$setupVideo$0(SurfaceRequest r5, Timebase r6) {
            if (r5.isServiced() == false) goto L5;
        L11:
            Logger.w(Recorder.TAG, "Ignore the SurfaceRequest " + r5 + " isServiced: " + r5.isServiced() + " VideoEncoderSession: " + this.this$0.mVideoEncoderSession + " has been configured with a persistent in-progress recording.");
            return;
        L5:
            if (this.this$0.mVideoEncoderSession.isConfiguredSurfaceRequest(r5) == true) goto L7;
        L9:
            EncoderFactory r1 = Recorder.access$100(this.this$0);
            Recorder r2 = this.this$0;
            VideoEncoderSession r0 = new VideoEncoderSession(r1, r2.mSequentialExecutor, Recorder.access$200(r2));
            Recorder r3 = this.this$0;
            ListenableFuture<Encoder> r7 = r0.configure(r5, r6, (MediaSpec) r3.getObservableData(r3.mMediaSpec), Recorder.access$300(this.this$0));
            this.this$0.mVideoEncoderSession = r0;
            Futures.addCallback(r7, new AnonymousClass1(this, r0), this.this$0.mSequentialExecutor);
            return;
        L7:
            if (this.this$0.isPersistentRecordingInProgress() == true) goto L9;
            goto L9
        }

        private void setupVideo(final SurfaceRequest r3, final Timebase r4) {
            Recorder.access$000(this.this$0).addListener(new e0(this, r3, r4), this.this$0.mSequentialExecutor);
        }

        public static /* synthetic */ void access$1100(SetupVideoTask r0, SurfaceRequest r1, Timebase r2) {
            r0.setupVideo(r1, r2);
        }

        public SetupVideoTask(Recorder r1, SurfaceRequest r2, Timebase r3, int r4) {
            this.this$0 = r1;
            this.mIsFailedRetryCanceled = false;
            this.mRetryCount = 0;
            this.mRetryFuture = null;
            this.mSurfaceRequest = r2;
            this.mTimebase = r3;
            this.mMaxRetryCount = r4;
        }
    }

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CONFIGURING = null;
        public static final State ERROR = null;
        public static final State IDLING = null;
        public static final State PAUSED = null;
        public static final State PENDING_PAUSED = null;
        public static final State PENDING_RECORDING = null;
        public static final State RECORDING = null;
        public static final State RESETTING = null;
        public static final State STOPPING = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{CONFIGURING, PENDING_RECORDING, PENDING_PAUSED, IDLING, RECORDING, PAUSED, STOPPING, RESETTING, ERROR};
        }

        static {
            CONFIGURING = new State("CONFIGURING", 0);
            PENDING_RECORDING = new State("PENDING_RECORDING", 1);
            PENDING_PAUSED = new State("PENDING_PAUSED", 2);
            IDLING = new State("IDLING", 3);
            RECORDING = new State("RECORDING", 4);
            PAUSED = new State("PAUSED", 5);
            STOPPING = new State("STOPPING", 6);
            RESETTING = new State("RESETTING", 7);
            ERROR = new State("ERROR", 8);
            $VALUES = $values();
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ void a(Recorder r0, SurfaceRequest r1, Timebase r2) {
        r0.lambda$onSurfaceRequested$0(r1, r2);
    }

    public static /* synthetic */ void b(Recorder r0, RecordingRecord r1) {
        r0.lambda$pause$3(r1);
    }

    public static /* synthetic */ Object c(Recorder r0, RecordingRecord r1, CallbackToFutureAdapter.Completer r2) {
        return r0.lambda$updateEncoderCallbacks$10(r1, r2);
    }

    public static /* synthetic */ void d(Recorder r0) {
        r0.lambda$start$2();
    }

    public static /* synthetic */ Object e(Recorder r0, RecordingRecord r1, CallbackToFutureAdapter.Completer r2) {
        return r0.lambda$updateEncoderCallbacks$12(r1, r2);
    }

    public static /* synthetic */ void f(Encoder r0) {
        lambda$stopInternal$13(r0);
    }

    public static /* synthetic */ void g(VideoSpec.Builder r0) {
        lambda$composeRecorderMediaSpec$8(r0);
    }

    public static /* synthetic */ void h(Recorder r0, VideoOutput.SourceState r1) {
        r0.lambda$onSourceStateChanged$1(r1);
    }

    public static /* synthetic */ void i(Recorder r0, CallbackToFutureAdapter.Completer r1, Throwable r2) {
        r0.lambda$updateEncoderCallbacks$11(r1, r2);
    }

    public static /* synthetic */ void j(Executor r0, Runnable r1) {
        lambda$scheduleTask$14(r0, r1);
    }

    public static /* synthetic */ void k(Recorder r0, RecordingRecord r1, boolean r2) {
        r0.lambda$mute$6(r1, r2);
    }

    public static /* synthetic */ void l(Recorder r0, Uri r1) {
        r0.lambda$setupAndStartMediaMuxer$9(r1);
    }

    public static /* synthetic */ void m(Recorder r0, SurfaceRequest.TransformationInfo r1) {
        r0.lambda$configureInternal$7(r1);
    }

    public static /* synthetic */ void n(Recorder r0, RecordingRecord r1, long r2, int r4, Throwable r5) {
        r0.lambda$stop$5(r1, r2, r4, r5);
    }

    public static /* synthetic */ void o(Recorder r0, RecordingRecord r1) {
        r0.lambda$resume$4(r1);
    }

    static {
        PENDING_STATES = Collections.unmodifiableSet(EnumSet.of(State.PENDING_RECORDING, State.PENDING_PAUSED));
        VALID_NON_PENDING_STATES_WHILE_PENDING = Collections.unmodifiableSet(EnumSet.of(State.CONFIGURING, State.IDLING, State.RESETTING, State.STOPPING, State.ERROR));
        Quality r2 = Quality.FHD;
        QualitySelector r1 = QualitySelector.fromOrderedList(Arrays.asList(new Quality[]{r2, Quality.HD, Quality.SD}), FallbackStrategy.higherQualityOrLowerThan(r2));
        DEFAULT_QUALITY_SELECTOR = r1;
        VideoSpec r3 = VideoSpec.builder().setQualitySelector(r1).setAspectRatio(-1).build();
        VIDEO_SPEC_DEFAULT = r3;
        MEDIA_SPEC_DEFAULT = MediaSpec.builder().setOutputFormat(-1).setVideoSpec(r3).build();
        PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE = new RuntimeException("The video frame producer became inactive before any data was received.");
        DEFAULT_ENCODER_FACTORY = new q();
        AUDIO_EXECUTOR = CameraXExecutors.newSequentialExecutor(CameraXExecutors.ioExecutor());
        sRetrySetupVideoMaxCount = 3;
        sRetrySetupVideoDelayMs = 1000;
    }

    private void clearPendingAudioRingBuffer() {
    L3:
        if (this.mPendingAudioRingBuffer.isEmpty() == true) goto L5;
        this.mPendingAudioRingBuffer.dequeue();
        goto L3
    }

    private /* synthetic */ void lambda$start$2() {
        SurfaceRequest r0 = this.mLatestSurfaceRequest;
        if (r0 == null) goto L7;
        configureInternal(r0, this.mVideoSourceTimebase, false);
        return;
    L7:
        throw new AssertionError("surface request is required to retry initialization.");
    }

    private void onResetVideo() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L5:
        switch(this.mState.ordinal()) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L10;
            case 7: goto L10;
            case 8: goto L8;
            default: goto L12;
        };     // Catch: Throwable -> L22
    L10:
        setState(State.CONFIGURING);     // Catch: Throwable -> L22
        goto L12
    L11:
        updateNonPendingState(State.CONFIGURING);     // Catch: Throwable -> L22
    L12:
        boolean r1 = true;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L22
        this.mNeedsResetBeforeNextStart = false;
        if (r1 == false) goto L27;
        SurfaceRequest r2 = this.mLatestSurfaceRequest;
        if (r2 != null) goto L19;
        return;
    L19:
        if (r2.isServiced() == true) goto L29;
        configureInternal(this.mLatestSurfaceRequest, this.mVideoSourceTimebase, false);
        return;
    L29:
        return;
    L27:
        return;
    L8:
        if (isPersistentRecordingInProgress() == false) goto L10;
        r1 = false;
        goto L13
    }

    private void releaseCurrentAudioSource() {
        final AudioSource r0 = this.mAudioSource;
        if (r0 == null) goto L7;
        this.mAudioSource = null;
        Logger.d(TAG, String.format("Releasing audio source: 0x%x", new Object[]{Integer.valueOf(r0.hashCode())}));
        Futures.addCallback(r0.release(), new AnonymousClass2(this, r0), CameraXExecutors.directExecutor());
        return;
    L7:
        throw new AssertionError("Cannot release null audio source.");
    }

    private void reset() {
        if (this.mAudioEncoder == null) goto L6;
        Logger.d(TAG, "Releasing audio encoder.");
        this.mAudioEncoder.release();
        this.mAudioEncoder = null;
        this.mAudioOutputConfig = null;
    L6:
        if (this.mAudioSource == null) goto L8;
        releaseCurrentAudioSource();
    L8:
        setAudioState(AudioState.INITIALIZING);
        resetVideo();
    }

    private void resetVideo() {
        if (this.mVideoEncoder == null) goto L5;
        Logger.d(TAG, "Releasing video encoder.");
        tryReleaseVideoEncoder();
    L5:
        onResetVideo();
    }

    private void restoreNonPendingState() {
        if (PENDING_STATES.contains(this.mState) == false) goto L7;
        setState(this.mNonPendingState);
        return;
    L7:
        throw new AssertionError("Cannot restore non-pending state when in state " + this.mState);
    }

    private ListenableFuture<Void> safeToCloseVideoEncoder() {
        Logger.d(TAG, "Try to safely release video encoder: " + this.mVideoEncoder);
        return this.mVideoEncoderSession.signalTermination();
    }

    private void tryReleaseVideoEncoder() {
        VideoEncoderSession r0 = this.mVideoEncoderSessionToRelease;
        if (r0 != null) goto L5;
        safeToCloseVideoEncoder();
        return;
    L5:
        if (r0.getVideoEncoder() != this.mVideoEncoder) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1);
        Logger.d(TAG, "Releasing video encoder: " + this.mVideoEncoder);
        this.mVideoEncoderSessionToRelease.terminateNow();
        this.mVideoEncoderSessionToRelease = null;
        this.mVideoEncoder = null;
        this.mVideoOutputConfig = null;
        setLatestSurface(null);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public int getAspectRatio() {
        return ((MediaSpec) getObservableData(this.mMediaSpec)).getVideoSpec().getAspectRatio();
    }

    public int getAudioSource() {
        return ((MediaSpec) getObservableData(this.mMediaSpec)).getAudioSpec().getSource();
    }

    public RecordingStats getInProgressRecordingStats() {
        return RecordingStats.of(this.mRecordingDurationNs, this.mRecordingBytes, AudioStats.of(internalAudioStateToAudioStatsState(this.mAudioState), this.mAudioErrorCause, this.mAudioAmplitude));
    }

    public QualitySelector getQualitySelector() {
        return ((MediaSpec) getObservableData(this.mMediaSpec)).getVideoSpec().getQualitySelector();
    }

    public int getTargetVideoEncodingBitRate() {
        return ((Integer) ((MediaSpec) getObservableData(this.mMediaSpec)).getVideoSpec().getBitrate().getLower()).intValue();
    }

    public boolean isAudioEnabled() {
        if (this.mAudioState != AudioState.ENABLED) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isAudioSupported() {
        if (((MediaSpec) getObservableData(this.mMediaSpec)).getAudioSpec().getChannelCount() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPersistentRecordingInProgress() {
        RecordingRecord r0 = this.mInProgressRecording;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isPersistent() == false) goto L7;
        return true;
    }

    public void onConfigured() {
        Object r1 = this.mLock;
        monitor-enter(r1);
        RecordingRecord r4 = null;
        switch(this.mState.ordinal()) {
            case 0: goto L27;
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L9;
            case 7: goto L17;
            case 8: goto L7;
            default: goto L28;
        };     // Catch: Throwable -> L43
    L7:
        Logger.e(TAG, "onConfigured() was invoked when the Recorder had encountered error");     // Catch: Throwable -> L43
        goto L28
    L13:
        boolean r0 = true;
    L15:
        Preconditions.checkState(isPersistentRecordingInProgress(), "Unexpectedly invoke onConfigured() when there's a non-persistent in-progress recording");     // Catch: Throwable -> L43
        RecordingRecord r2 = null;
        Exception r6 = null;
        int r7 = 0;
        boolean r8 = true;
    L31:
        monitor-exit(r1);     // Catch: Throwable -> L43
        if (r8 == false) goto L38;
        updateEncoderCallbacks(this.mInProgressRecording, true);
        this.mVideoEncoder.start();
        if (this.mShouldSendResumeEvent == false) goto L36;
        RecordingRecord r3 = this.mInProgressRecording;
        r3.updateVideoRecordEvent(VideoRecordEvent.resume(r3.getOutputOptions(), getInProgressRecordingStats()));
        this.mShouldSendResumeEvent = false;
    L36:
        if (r0 == false) goto L47;
        this.mVideoEncoder.pause();
        return;
    L47:
        return;
    L38:
        if (r4 == null) goto L40;
        startRecording(r4, r0);
        return;
    L40:
        if (r2 == null) goto L50;
        finalizePendingRecording(r2, r7, r6);
        return;
    L50:
        return;
    L14:
        r0 = false;
        goto L15
    L18:
        r0 = true;
    L21:
        if (this.mActiveRecordingRecord == null) goto L24;
        r2 = null;
        r6 = null;
    L29:
        r7 = 0;
    L30:
        r8 = false;
        goto L31
    L24:
        if (this.mSourceState != VideoOutput.SourceState.INACTIVE) goto L26;
        r2 = this.mPendingRecordingRecord;     // Catch: Throwable -> L43
        this.mPendingRecordingRecord = null;     // Catch: Throwable -> L43
        restoreNonPendingState();     // Catch: Throwable -> L43
        r6 = PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE;     // Catch: Throwable -> L43
        r7 = 4;
        goto L30
    L26:
        r6 = null;
        r7 = 0;
        r8 = false;
        r4 = makePendingRecordingActiveLocked(this.mState);     // Catch: Throwable -> L43
        r2 = null;
        goto L31
    L19:
        r0 = false;
        goto L21
    L27:
        setState(State.IDLING);     // Catch: Throwable -> L43
    L28:
        r2 = null;
        r6 = null;
        r0 = false;
        goto L29
    L9:
        if (this.mEncoderNotUsePersistentInputSurface == true) goto L28;
        throw new AssertionError("Unexpectedly invoke onConfigured() in a STOPPING state when it's not waiting for a new surface.");     // Catch: Throwable -> L43
    L17:
        throw new AssertionError("Incorrectly invoke onConfigured() in state " + this.mState);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    }

    public void tryServicePendingRecording() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mState.ordinal();     // Catch: Throwable -> L28
        boolean r2 = true;
        boolean r3 = false;
        RecordingRecord r4 = null;
        if (r1 != 1) goto L7;
        r2 = false;
    L11:
        if (this.mActiveRecordingRecord == null) goto L13;
    L21:
        r3 = r2;
    L8:
        RecordingRecord r5 = null;
        Exception r6 = null;
        int r7 = 0;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L28
        if (r4 == null) goto L25;
        startRecording(r4, r3);
        return;
    L25:
        if (r5 == null) goto L34;
        finalizePendingRecording(r5, r7, r6);
        return;
    L34:
        return;
    L13:
        if (this.mNeedsResetBeforeNextStart == true) goto L21;
        if (this.mSourceState != VideoOutput.SourceState.INACTIVE) goto L19;
        r5 = this.mPendingRecordingRecord;     // Catch: Throwable -> L28
        this.mPendingRecordingRecord = null;     // Catch: Throwable -> L28
        restoreNonPendingState();     // Catch: Throwable -> L28
        r7 = 4;
        r3 = r2;
        r6 = PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE;     // Catch: Throwable -> L28
        goto L22
    L19:
        if (this.mVideoEncoder == null) goto L21;
        r3 = r2;
        r6 = null;
        r7 = 0;
        r4 = makePendingRecordingActiveLocked(this.mState);     // Catch: Throwable -> L28
        r5 = null;
        goto L22
    L7:
        if (r1 == 2) goto L11;
    L28:
        th = move-exception;
        throw th;
    }

    public void updateInProgressStatusEvent() {
        RecordingRecord r0 = this.mInProgressRecording;
        if (r0 == null) goto L6;
        r0.updateVideoRecordEvent(VideoRecordEvent.status(r0.getOutputOptions(), getInProgressRecordingStats()));
        return;
    }

    public Executor getExecutor() {
        return this.mUserProvidedExecutor;
    }

    @Override // androidx.camera.video.VideoOutput
    public Observable<MediaSpec> getMediaSpec() {
        return this.mMediaSpec;
    }

    @Override // androidx.camera.video.VideoOutput
    public Observable<StreamInfo> getStreamInfo() {
        return this.mStreamInfo;
    }

    public int getVideoCapabilitiesSource() {
        return this.mVideoCapabilitiesSource;
    }

    @Override // androidx.camera.video.VideoOutput
    public Observable<Boolean> isSourceStreamRequired() {
        return this.mIsRecording;
    }

    public static /* synthetic */ ListenableFuture access$000(Recorder r0) {
        return r0.safeToCloseVideoEncoder();
    }

    public static /* synthetic */ EncoderFactory access$100(Recorder r0) {
        return r0.mVideoEncoderFactory;
    }

    public static /* synthetic */ MutableStateObservable access$1200(Recorder r0) {
        return r0.mIsRecording;
    }

    public static /* synthetic */ Executor access$200(Recorder r0) {
        return r0.mExecutor;
    }

    public static /* synthetic */ VideoValidatedEncoderProfilesProxy access$300(Recorder r0) {
        return r0.mResolvedEncoderProfiles;
    }

    private MediaSpec composeRecorderMediaSpec(MediaSpec r3) {
        MediaSpec.Builder r0 = r3.toBuilder();
        if (r3.getVideoSpec().getAspectRatio() != (-1)) goto L6;
        r0.configureVideo(new r());
    L6:
        return r0.build();
    }

    private List<EncodedData> getAudioDataToWriteAndClearCache(long r6) {
        ArrayList r0 = new ArrayList();
    L4:
        if (this.mPendingAudioRingBuffer.isEmpty() == true) goto L8;
        EncodedData r1 = this.mPendingAudioRingBuffer.dequeue();
        if (r1.getPresentationTimeUs() < r6) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    public static VideoCapabilities getVideoCapabilities(CameraInfo r1) {
        return getVideoCapabilities(r1, 0);
    }

    private int internalAudioStateToAudioStatsState(AudioState r5) {
        int r0 = r5.ordinal();
        if (r0 != 0) goto L5;
        return 1;
    L5:
        if (r0 != 2) goto L7;
        return 1;
    L7:
        if (r0 != 3) goto L9;
        RecordingRecord r6 = this.mInProgressRecording;
        if (r6 == null) goto L21;
        if (r6.isMuted() == false) goto L21;
        return 5;
    L21:
        if (this.mIsAudioSourceSilenced == false) goto L23;
        return 2;
    L23:
        return 0;
    L9:
        if (r0 == 4) goto L14;
        if (r0 != 5) goto L13;
        return 4;
    L13:
        throw new AssertionError("Invalid internal audio state: " + r5);
    L14:
        return 3;
    }

    private StreamInfo.StreamState internalStateToStreamState(State r3) {
        DeactivateEncoderSurfaceBeforeStopEncoderQuirk r0 = (DeactivateEncoderSurfaceBeforeStopEncoderQuirk) DeviceQuirks.get(DeactivateEncoderSurfaceBeforeStopEncoderQuirk.class);
        if (r3 == State.RECORDING) goto L10;
        if (r3 != State.STOPPING) goto L11;
        if (r0 == null) goto L10;
    L11:
        return StreamInfo.StreamState.INACTIVE;
    L10:
        return StreamInfo.StreamState.ACTIVE;
    }

    private static /* synthetic */ void lambda$composeRecorderMediaSpec$8(VideoSpec.Builder r1) {
        r1.setAspectRatio(VIDEO_SPEC_DEFAULT.getAspectRatio());
    }

    private /* synthetic */ void lambda$configureInternal$7(SurfaceRequest.TransformationInfo r1) {
        this.mSourceTransformationInfo = r1;
    }

    private /* synthetic */ void lambda$onSourceStateChanged$1(VideoOutput.SourceState r1) {
        onSourceStateChangedInternal(r1);
    }

    private /* synthetic */ void lambda$pause$3(RecordingRecord r1) {
        pauseInternal(r1);
    }

    private /* synthetic */ void lambda$resume$4(RecordingRecord r1) {
        resumeInternal(r1);
    }

    private /* synthetic */ void lambda$setupAndStartMediaMuxer$9(Uri r1) {
        this.mOutputUri = r1;
    }

    private static /* synthetic */ void lambda$stopInternal$13(Encoder r2) {
        Logger.d(TAG, "The source didn't become non-streaming before timeout. Waited 1000ms");
        if (DeviceQuirks.get(DeactivateEncoderSurfaceBeforeStopEncoderQuirk.class) == null) goto L6;
        notifyEncoderSourceStopped(r2);
        return;
    }

    private RecordingRecord makePendingRecordingActiveLocked(State r5) {
        if (r5 != State.PENDING_PAUSED) goto L6;
        boolean r6 = true;
    L9:
        if (this.mActiveRecordingRecord != null) goto L20;
        RecordingRecord r0 = this.mPendingRecordingRecord;
        if (r0 == null) goto L18;
        this.mActiveRecordingRecord = r0;
        r0.getRecordingState().addObserver(CameraXExecutors.directExecutor(), new AnonymousClass7(this));
        this.mPendingRecordingRecord = null;
        if (r6 == false) goto L15;
        setState(State.PAUSED);
    L16:
        return r0;
    L15:
        setState(State.RECORDING);
        goto L16
    L18:
        throw new AssertionError("Pending recording should exist when in a PENDING state.");
    L20:
        throw new AssertionError("Cannot make pending recording active because another recording is already active.");
    L6:
        if (r5 != State.PENDING_RECORDING) goto L22;
        r6 = false;
        goto L9
    L22:
        throw new AssertionError("makePendingRecordingActiveLocked() can only be called from a pending state.");
    }

    public static void notifyEncoderSourceStopped(Encoder r1) {
        if ((r1 instanceof EncoderImpl) == false) goto L6;
        ((EncoderImpl) r1).signalSourceStopped();
        return;
    }

    private void onRecordingFinalized(RecordingRecord r9) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        RecordingRecord r2 = this.mActiveRecordingRecord;     // Catch: Throwable -> L60
        if (r2 != r9) goto L59;
        r2.getRecordingState().removeObservers();     // Catch: Throwable -> L60
        RecordingRecord r10 = null;
        this.mActiveRecordingRecord = null;     // Catch: Throwable -> L60
        boolean r3 = true;
        switch(this.mState.ordinal()) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L41;
        };     // Catch: Throwable -> L60
    L9:
        r10 = null;
        Throwable r4 = null;
        boolean r0 = false;
        boolean r5 = false;
        boolean r6 = true;
    L43:
        int r7 = 0;
    L44:
        monitor-exit(r1);     // Catch: Throwable -> L60
        if (r5 == false) goto L47;
        configureInternal(this.mLatestSurfaceRequest, this.mVideoSourceTimebase, false);
        return;
    L47:
        if (r6 == false) goto L49;
        reset();
        return;
    L49:
        if (r10 != null) goto L51;
        if (r10 == null) goto L67;
        finalizePendingRecording(r10, r7, r4);
        return;
    L67:
        return;
    L51:
        if (this.mEncoderNotUsePersistentInputSurface == true) goto L54;
        startRecording(r10, r0);
        return;
    L54:
        throw new AssertionError("Attempt to start a pending recording while the Recorder is waiting for a new surface request.");
    L23:
        r0 = true;
    L26:
        if (this.mSourceState != VideoOutput.SourceState.INACTIVE) goto L29;
        r10 = this.mPendingRecordingRecord;     // Catch: Throwable -> L60
        this.mPendingRecordingRecord = null;     // Catch: Throwable -> L60
        setState(State.CONFIGURING);     // Catch: Throwable -> L60
        r4 = PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE;     // Catch: Throwable -> L60
        r5 = false;
        r6 = false;
        r7 = 4;
        goto L44
    L29:
        if (this.mEncoderNotUsePersistentInputSurface == false) goto L38;
        this.mActiveSurface = null;     // Catch: Throwable -> L60
        SurfaceRequest r8 = this.mLatestSurfaceRequest;     // Catch: Throwable -> L60
        if (r8 != null) goto L33;
    L35:
        r3 = false;
    L36:
        updateNonPendingState(State.CONFIGURING);     // Catch: Throwable -> L60
        r5 = r3;
    L19:
        r6 = false;
        r7 = 0;
        r4 = r10;
        goto L44
    L33:
        if (r8.isServiced() == true) goto L35;
    L38:
        if (this.mVideoEncoder == null) goto L40;
        r4 = null;
        r5 = false;
        r6 = false;
        r7 = 0;
        r10 = makePendingRecordingActiveLocked(this.mState);     // Catch: Throwable -> L60
        r10 = null;
        goto L44
    L40:
        r10 = null;
        r4 = null;
    L42:
        r5 = false;
        r6 = false;
        goto L43
    L24:
        r0 = false;
    L41:
        r10 = null;
        r4 = null;
        r0 = false;
        goto L42
    L11:
        if (this.mEncoderNotUsePersistentInputSurface == false) goto L20;
        this.mActiveSurface = null;     // Catch: Throwable -> L60
        SurfaceRequest r11 = this.mLatestSurfaceRequest;     // Catch: Throwable -> L60
        if (r11 != null) goto L15;
    L17:
        r3 = false;
    L18:
        setState(State.CONFIGURING);     // Catch: Throwable -> L60
        r5 = r3;
        r0 = false;
        goto L19
    L15:
        if (r11.isServiced() == true) goto L17;
    L20:
        setState(State.IDLING);     // Catch: Throwable -> L60
        goto L41
    L22:
        throw new AssertionError("Unexpected state on finalize of recording: " + this.mState);     // Catch: Throwable -> L60
    L59:
        throw new AssertionError("Active recording did not match finalized recording on finalize.");     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        throw th;
    }

    private void pauseInternal(RecordingRecord r3) {
        if (this.mInProgressRecording == r3) goto L5;
        return;
    L5:
        if (this.mInProgressRecordingStopping == false) goto L7;
        return;
    L7:
        if (isAudioEnabled() == false) goto L9;
        this.mAudioEncoder.pause();
    L9:
        this.mVideoEncoder.pause();
        RecordingRecord r4 = this.mInProgressRecording;
        r4.updateVideoRecordEvent(VideoRecordEvent.pause(r4.getOutputOptions(), getInProgressRecordingStats()));
    }

    private void resumeInternal(RecordingRecord r3) {
        if (this.mInProgressRecording == r3) goto L5;
        return;
    L5:
        if (this.mInProgressRecordingStopping == false) goto L7;
        return;
    L7:
        if (isAudioEnabled() == false) goto L9;
        this.mAudioEncoder.start();
    L9:
        Encoder r4 = this.mVideoEncoder;
        if (r4 == null) goto L12;
        r4.start();
        RecordingRecord r5 = this.mInProgressRecording;
        r5.updateVideoRecordEvent(VideoRecordEvent.resume(r5.getOutputOptions(), getInProgressRecordingStats()));
        return;
    L12:
        this.mShouldSendResumeEvent = true;
    }

    private void setStreamId(int r4) {
        if (this.mStreamId != r4) goto L5;
        return;
    L5:
        Logger.d(TAG, "Transitioning streamId: " + this.mStreamId + " --> " + r4);
        this.mStreamId = r4;
        this.mStreamInfo.setState(StreamInfo.of(r4, internalStateToStreamState(this.mState), this.mInProgressTransformationInfo));
    }

    private void setupAudio(RecordingRecord r7) throws AudioSourceAccessException, InvalidConfigException {
        MediaSpec r0 = (MediaSpec) getObservableData(this.mMediaSpec);
        AudioMimeInfo r1 = AudioConfigUtil.resolveAudioMimeInfo(r0, this.mResolvedEncoderProfiles);
        Timebase r2 = Timebase.UPTIME;
        AudioSettings r3 = AudioConfigUtil.resolveAudioSettings(r1, r0.getAudioSpec());
        if (this.mAudioSource == null) goto L5;
        releaseCurrentAudioSource();
    L5:
        AudioSource r8 = setupAudioSource(r7, r3);
        this.mAudioSource = r8;
        Logger.d(TAG, String.format("Set up new audio source: 0x%x", new Object[]{Integer.valueOf(r8.hashCode())}));
        Encoder r9 = this.mAudioEncoderFactory.createEncoder(this.mExecutor, AudioConfigUtil.resolveAudioEncoderConfig(r1, r2, r3, r0.getAudioSpec()));
        this.mAudioEncoder = r9;
        Encoder.EncoderInput r10 = r9.getInput();
        if ((r10 instanceof Encoder.ByteBufferInput) == false) goto L10;
        this.mAudioSource.setBufferProvider((Encoder.ByteBufferInput) r10);
        return;
    L10:
        throw new AssertionError("The EncoderInput of audio isn't a ByteBufferInput.");
    }

    private void startInternal(RecordingRecord r8) {
        if (this.mInProgressRecording != null) goto L59;
        if (r8.getOutputOptions().getFileSizeLimit() <= 0) goto L7;
        this.mFileSizeLimitInBytes = Math.round(r8.getOutputOptions().getFileSizeLimit() * 0.95d);
        Logger.d(TAG, "File size limit in bytes: " + this.mFileSizeLimitInBytes);
    L9:
        if (r8.getOutputOptions().getDurationLimitMillis() <= 0) goto L11;
        this.mDurationLimitNs = TimeUnit.MILLISECONDS.toNanos(r8.getOutputOptions().getDurationLimitMillis());
        Logger.d(TAG, "Duration limit in nanoseconds: " + this.mDurationLimitNs);
    L12:
        this.mInProgressRecording = r8;
        int r0 = this.mAudioState.ordinal();
        if (r0 == 0) goto L33;
        if (r0 == 1) goto L28;
        if (r0 == 2) goto L26;
        if (r0 == 3) goto L26;
        if (r0 == 4) goto L26;
        if (r0 == 5) goto L26;
    L53:
        updateEncoderCallbacks(r8, false);
        if (isAudioEnabled() == false) goto L56;
        this.mAudioSource.start(r8.isMuted());
        this.mAudioEncoder.start();
    L56:
        this.mVideoEncoder.start();
        RecordingRecord r9 = this.mInProgressRecording;
        r9.updateVideoRecordEvent(VideoRecordEvent.start(r9.getOutputOptions(), getInProgressRecordingStats()));
        return;
    L26:
        throw new AssertionError("Incorrectly invoke startInternal in audio state " + this.mAudioState);
    L28:
        if (r8.hasAudioEnabled() == false) goto L30;
        AudioState r1 = AudioState.ENABLED;
    L31:
        setAudioState(r1);
        goto L53
    L30:
        r1 = AudioState.DISABLED;
        goto L31
    L33:
        if (r8.hasAudioEnabled() == false) goto L53;
        if (isAudioSupported() == false) goto L52;
    L43:
        e = move-exception;
        Logger.e(TAG, "Unable to create audio resource with error: ", e);
        if ((e instanceof InvalidConfigException) == false) goto L49;
        AudioState r2 = AudioState.ERROR_ENCODER;
    L50:
        setAudioState(r2);
        this.mAudioErrorCause = e;
        goto L53
    L49:
        r2 = AudioState.ERROR_SOURCE;
        goto L50
    L37:
        if (this.mInProgressRecording.isPersistent() == true) goto L39;
    L40:
        setupAudio(r8);     // Catch: Throwable -> L43 AudioSourceAccessException -> L45
    L41:
        setAudioState(AudioState.ENABLED);     // Catch: Throwable -> L43 AudioSourceAccessException -> L45
        goto L53
    L39:
        if (this.mAudioEncoder != null) goto L41;
    L52:
        throw new AssertionError("The Recorder doesn't support recording with audio");
    L11:
        this.mDurationLimitNs = 0;
        goto L12
    L7:
        this.mFileSizeLimitInBytes = 0;
        goto L9
    L59:
        throw new AssertionError("Attempted to start a new recording while another was in progress.");
    }

    private void updateNonPendingState(State r4) {
        if (PENDING_STATES.contains(this.mState) == false) goto L13;
        if (VALID_NON_PENDING_STATES_WHILE_PENDING.contains(r4) == false) goto L11;
        if (this.mNonPendingState == r4) goto L14;
        this.mNonPendingState = r4;
        this.mStreamInfo.setState(StreamInfo.of(this.mStreamId, internalStateToStreamState(r4), this.mInProgressTransformationInfo));
        return;
    L14:
        return;
    L11:
        throw new AssertionError("Invalid state transition. State is not a valid non-pending state while in a pending state: " + r4);
    L13:
        throw new AssertionError("Can only updated non-pending state from a pending state, but state is " + this.mState);
    }

    @Override // androidx.camera.video.VideoOutput
    public VideoCapabilities getMediaCapabilities(CameraInfo r2) {
        return getVideoCapabilities(r2, this.mVideoCapabilitiesSource);
    }

    public <T> T getObservableData(StateObservable<T> r2) {
        return (T) r2.fetchData().get();
    L7:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public void onEncoderSetupError(Throwable r5) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        RecordingRecord r3 = null;
        switch(this.mState.ordinal()) {
            case 0: goto L10;
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            default: goto L11;
        };     // Catch: Throwable -> L15
    L9:
        RecordingRecord r0 = this.mPendingRecordingRecord;     // Catch: Throwable -> L15
        this.mPendingRecordingRecord = null;     // Catch: Throwable -> L15
        r3 = r0;
    L10:
        setStreamId(-1);     // Catch: Throwable -> L15
        setState(State.ERROR);     // Catch: Throwable -> L15
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L15
        if (r3 == null) goto L19;
        finalizePendingRecording(r3, 7, r5);
        return;
    L19:
        return;
    L8:
        throw new AssertionError("Encountered encoder setup error while in unexpected state " + this.mState + ": " + r5);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.video.VideoOutput
    public void onSourceStateChanged(final VideoOutput.SourceState r3) {
        this.mSequentialExecutor.execute(new l(this, r3));
    }

    public void onSourceStateChangedInternal(VideoOutput.SourceState r4) {
        VideoOutput.SourceState r0 = this.mSourceState;
        this.mSourceState = r4;
        if (r0 == r4) goto L27;
        Logger.d(TAG, "Video source has transitioned to state: " + r4);
        if (r4 != VideoOutput.SourceState.INACTIVE) goto L18;
        if (this.mActiveSurface != null) goto L12;
        SetupVideoTask r5 = this.mSetupVideoTask;
        if (r5 == null) goto L11;
        r5.cancelFailedRetry();
        this.mSetupVideoTask = null;
    L11:
        requestReset(4, null, false);
        return;
    L12:
        this.mNeedsResetBeforeNextStart = true;
        RecordingRecord r6 = this.mInProgressRecording;
        if (r6 != null) goto L15;
        return;
    L15:
        if (r6.isPersistent() == true) goto L31;
        onInProgressRecordingInternalError(this.mInProgressRecording, 4, null);
        return;
    L31:
        return;
    L18:
        if (r4 != VideoOutput.SourceState.ACTIVE_NON_STREAMING) goto L33;
        ScheduledFuture<?> r7 = this.mSourceNonStreamingTimeout;
        if (r7 != null) goto L22;
        return;
    L22:
        if (r7.cancel(false) == false) goto L35;
        Encoder r8 = this.mVideoEncoder;
        if (r8 == null) goto L36;
        notifyEncoderSourceStopped(r8);
        return;
    L36:
        return;
    L35:
        return;
    L33:
        return;
    L27:
        Logger.d(TAG, "Video source transitions to the same state: " + r4);
    }

    @Override // androidx.camera.video.VideoOutput
    public void onSurfaceRequested(SurfaceRequest r2) {
        onSurfaceRequested(r2, Timebase.UPTIME);
    }

    public void onVideoEncoderReady(final VideoEncoderSession r3) {
        Encoder r0 = r3.getVideoEncoder();
        this.mVideoEncoder = r0;
        this.mVideoEncoderBitrateRange = ((VideoEncoderInfo) r0.getEncoderInfo()).getSupportedBitrateRange();
        this.mFirstRecordingVideoBitrate = this.mVideoEncoder.getConfiguredBitrate();
        Surface r1 = r3.getActiveSurface();
        this.mActiveSurface = r1;
        setLatestSurface(r1);
        r3.setOnSurfaceUpdateListener(this.mSequentialExecutor, new e(this));
        Futures.addCallback(r3.getReadyToReleaseFuture(), new AnonymousClass1(this, r3), this.mSequentialExecutor);
    }

    public void pause(Recording r5) {
        Object r2 = this.mLock;
        monitor-enter(r2);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (isSameRecording(r5, this.mPendingRecordingRecord) == false) goto L7;
    L11:
        int r6 = this.mState.ordinal();     // Catch: Throwable -> L26
        if (r6 == 0) goto L25;
        if (r6 != 1) goto L16;
        setState(State.PENDING_PAUSED);     // Catch: Throwable -> L26
    L22:
        monitor-exit(r2);     // Catch: Throwable -> L26
        return;
    L16:
        if (r6 == 3) goto L25;
        if (r6 != 4) goto L22;
        setState(State.PAUSED);     // Catch: Throwable -> L26
        final RecordingRecord r7 = this.mActiveRecordingRecord;     // Catch: Throwable -> L26
        this.mSequentialExecutor.execute(new m(this, r7));     // Catch: Throwable -> L26
    L25:
        throw new IllegalStateException("Called pause() from invalid state: " + this.mState);     // Catch: Throwable -> L26
    L7:
        if (isSameRecording(r5, this.mActiveRecordingRecord) == true) goto L11;
        Logger.d(TAG, "pause() called on a recording that is no longer active: " + r5.getOutputOptions());     // Catch: Throwable -> L26
        monitor-exit(r2);     // Catch: Throwable -> L26
    }

    public void resume(Recording r5) {
        Object r2 = this.mLock;
        monitor-enter(r2);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (isSameRecording(r5, this.mPendingRecordingRecord) == false) goto L7;
    L11:
        int r6 = this.mState.ordinal();     // Catch: Throwable -> L26
        if (r6 == 0) goto L25;
        if (r6 != 5) goto L16;
        setState(State.RECORDING);     // Catch: Throwable -> L26
        final RecordingRecord r7 = this.mActiveRecordingRecord;     // Catch: Throwable -> L26
        this.mSequentialExecutor.execute(new k(this, r7));     // Catch: Throwable -> L26
    L22:
        monitor-exit(r2);     // Catch: Throwable -> L26
        return;
    L16:
        if (r6 != 2) goto L18;
        setState(State.PENDING_RECORDING);     // Catch: Throwable -> L26
        goto L22
    L18:
        if (r6 != 3) goto L22;
    L25:
        throw new IllegalStateException("Called resume() from invalid state: " + this.mState);     // Catch: Throwable -> L26
    L7:
        if (isSameRecording(r5, this.mActiveRecordingRecord) == true) goto L11;
        Logger.d(TAG, "resume() called on a recording that is no longer active: " + r5.getOutputOptions());     // Catch: Throwable -> L26
        monitor-exit(r2);     // Catch: Throwable -> L26
    }

    public void setAudioState(AudioState r3) {
        Logger.d(TAG, "Transitioning audio state: " + this.mAudioState + " --> " + r3);
        this.mAudioState = r3;
    }

    public void setInProgressTransformationInfo(SurfaceRequest.TransformationInfo r5) {
        Logger.d(TAG, "Update stream transformation info: " + r5);
        this.mInProgressTransformationInfo = r5;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mStreamInfo.setState(StreamInfo.of(this.mStreamId, internalStateToStreamState(this.mState), r5));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setLatestSurface(Surface r2) {
        if (this.mLatestSurface != r2) goto L5;
        return;
    L5:
        this.mLatestSurface = r2;
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (r2 != null) goto L17;
        int r3 = 0;
    L12:
        setStreamId(r3);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L17:
        r3 = r2.hashCode();     // Catch: Throwable -> L9
        goto L12
    }

    public void setState(State r4) {
        if (this.mState == r4) goto L22;
        Logger.d(TAG, "Transitioning Recorder internal state: " + this.mState + " --> " + r4);
        Set<State> r0 = PENDING_STATES;
        StreamInfo.StreamState r2 = null;
        if (r0.contains(r4) == false) goto L14;
        if (r0.contains(this.mState) == false) goto L9;
    L16:
        this.mState = r4;
        if (r2 != null) goto L19;
        r2 = internalStateToStreamState(r4);
    L19:
        this.mStreamInfo.setState(StreamInfo.of(this.mStreamId, r2, this.mInProgressTransformationInfo));
        return;
    L9:
        if (VALID_NON_PENDING_STATES_WHILE_PENDING.contains(this.mState) == false) goto L12;
        State r1 = this.mState;
        this.mNonPendingState = r1;
        r2 = internalStateToStreamState(r1);
        goto L16
    L12:
        throw new AssertionError("Invalid state transition. Should not be transitioning to a PENDING state from state " + this.mState);
    L14:
        if (this.mNonPendingState == null) goto L16;
        this.mNonPendingState = null;
        goto L16
    L22:
        throw new AssertionError("Attempted to transition to state " + r4 + ", but Recorder is already in state " + r4);
    }

    public void setupAndStartMediaMuxer(RecordingRecord r11) {
        if (this.mMediaMuxer != null) goto L66;
        if (isAudioEnabled() == true) goto L7;
    L11:
        EncodedData r0 = this.mPendingFirstVideoData;
        if (r0 == null) goto L64;
        this.mPendingFirstVideoData = null;     // Catch: Throwable -> L56
        List<EncodedData> r2 = getAudioDataToWriteAndClearCache(r0.getPresentationTimeUs());     // Catch: Throwable -> L56
        long r3 = r0.size();     // Catch: Throwable -> L56
        Iterator<EncodedData> r5 = r2.iterator();     // Catch: Throwable -> L56
    L16:
        if (r5.hasNext() == false) goto L18;
        r3 = r3 + r5.next().size();     // Catch: Throwable -> L56
        goto L16
    L18:
        long r6 = this.mFileSizeLimitInBytes;     // Catch: Throwable -> L56
        if (r6 == 0) goto L71;
        if (r3 <= r6) goto L71;
        Logger.d(TAG, String.format("Initial data exceeds file size limit %d > %d", new Object[]{Long.valueOf(r3), Long.valueOf(this.mFileSizeLimitInBytes)}));     // Catch: Throwable -> L56
        onInProgressRecordingInternalError(r11, 2, null);     // Catch: Throwable -> L56
        r0.close();
        return;
    L71:
        MediaSpec r4 = (MediaSpec) getObservableData(this.mMediaSpec);     // Catch: IOException -> L52 Throwable -> L56
        if (r4.getOutputFormat() != (-1)) goto L29;
        int r7 = supportedMuxerFormatOrDefaultFrom(this.mResolvedEncoderProfiles, MediaSpec.outputFormatToMuxerFormat(MEDIA_SPEC_DEFAULT.getOutputFormat()));     // Catch: IOException -> L52 Throwable -> L56
    L30:
        MediaMuxer r8 = r11.performOneTimeMediaMuxerCreation(r7, new j(this));     // Catch: IOException -> L52 Throwable -> L56
        SurfaceRequest.TransformationInfo r9 = this.mSourceTransformationInfo;     // Catch: Throwable -> L56
        if (r9 == null) goto L34;
        setInProgressTransformationInfo(r9);     // Catch: Throwable -> L56
        r8.setOrientationHint(r9.getRotationDegrees());     // Catch: Throwable -> L56
    L34:
        Location r10 = r11.getOutputOptions().getLocation();     // Catch: Throwable -> L56
        if (r10 != null) goto L69;
    L42:
        this.mVideoTrackIndex = Integer.valueOf(r8.addTrack(this.mVideoOutputConfig.getMediaFormat()));     // Catch: Throwable -> L56
        if (isAudioEnabled() == false) goto L45;
        this.mAudioTrackIndex = Integer.valueOf(r8.addTrack(this.mAudioOutputConfig.getMediaFormat()));     // Catch: Throwable -> L56
    L45:
        r8.start();     // Catch: Throwable -> L56
        this.mMediaMuxer = r8;     // Catch: Throwable -> L56
        writeVideoData(r0, r11);     // Catch: Throwable -> L56
        Iterator<EncodedData> r1 = r2.iterator();     // Catch: Throwable -> L56
    L47:
        if (r1.hasNext() == false) goto L50;
        writeAudioData(r1.next(), r11);     // Catch: Throwable -> L56
        goto L47
    L50:
        r0.close();
        return;
    L69:
        Pair<Double, Double> r12 = CorrectNegativeLatLongForMediaMuxer.adjustGeoLocation(r10.getLatitude(), r10.getLongitude());     // Catch: IllegalArgumentException -> L38 Throwable -> L56
        r8.setLocation((float) ((Double) r12.first).doubleValue(), (float) ((Double) r12.second).doubleValue());     // Catch: IllegalArgumentException -> L38 Throwable -> L56
    L38:
        e = move-exception;
        r8.release();     // Catch: Throwable -> L56
        onInProgressRecordingInternalError(r11, 5, e);     // Catch: Throwable -> L56
        r0.close();
        return;
    L29:
        r7 = MediaSpec.outputFormatToMuxerFormat(r4.getOutputFormat());     // Catch: IOException -> L52 Throwable -> L56
    L52:
        e = move-exception;
        onInProgressRecordingInternalError(r11, 5, e);     // Catch: Throwable -> L56
        r0.close();
        return;
    L56:
        th = move-exception;
        if (r0 != null) goto L67;
    L62:
        throw th;
    L67:
        r0.close();     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        th.addSuppressed(th);
        goto L62
    L64:
        throw new AssertionError("Media muxer cannot be started without an encoded video frame.");
    L7:
        if (this.mPendingAudioRingBuffer.isEmpty() == false) goto L11;
        throw new AssertionError("Audio is enabled but no audio sample is ready. Cannot start media muxer.");
    L66:
        throw new AssertionError("Unable to set up media muxer when one already exists.");
    }

    public Recording start(PendingRecording r10) {
        Preconditions.checkNotNull(r10, "The given PendingRecording cannot be null.");
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r1 = this.mLastGeneratedRecordingId + 1;     // Catch: Throwable -> L39
        this.mLastGeneratedRecordingId = r1;     // Catch: Throwable -> L39
        RecordingRecord r4 = null;
        int r5 = 0;
        switch(this.mState.ordinal()) {
            case 0: goto L10;
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L10;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L10;
            case 7: goto L10;
            case 8: goto L10;
            default: goto L29;
        };     // Catch: Throwable -> L39
    L7:
        RecordingRecord r3 = this.mActiveRecordingRecord;     // Catch: Throwable -> L39
    L8:
        r4 = r3;
        e = null;
    L30:
        monitor-exit(r0);     // Catch: Throwable -> L39
        if (r4 != null) goto L38;
        if (r5 == 0) goto L36;
        Logger.e(TAG, "Recording was started when the Recorder had encountered error " + e);
        finalizePendingRecording(RecordingRecord.from(r10, r1), r5, e);
        return Recording.createFinalizedFrom(r10, r1);
    L36:
        return Recording.from(r10, r1);
    L38:
        throw new IllegalStateException("A recording is already in progress. Previous recordings must be stopped before a new recording can be started.");
    L9:
        r3 = (RecordingRecord) Preconditions.checkNotNull(this.mPendingRecordingRecord);     // Catch: Throwable -> L39
        goto L8
    L10:
        State r6 = this.mState;     // Catch: Throwable -> L39
        State r7 = State.IDLING;     // Catch: Throwable -> L39
        if (r6 == r7) goto L13;
    L45:
        RecordingRecord r8 = RecordingRecord.from(r10, r1);     // Catch: IOException -> L27 Throwable -> L39
        r8.initializeRecording(r10.getApplicationContext());     // Catch: IOException -> L27 Throwable -> L39
        this.mPendingRecordingRecord = r8;     // Catch: IOException -> L27 Throwable -> L39
        State r9 = this.mState;     // Catch: IOException -> L27 Throwable -> L39
        if (r9 != r7) goto L23;
        setState(State.PENDING_RECORDING);     // Catch: IOException -> L27 Throwable -> L39
        this.mSequentialExecutor.execute(new n(this));     // Catch: IOException -> L27 Throwable -> L39
    L44:
        goto L29
    L23:
        if (r9 != State.ERROR) goto L25;
        setState(State.PENDING_RECORDING);     // Catch: IOException -> L27 Throwable -> L39
        this.mSequentialExecutor.execute(new o(this));     // Catch: IOException -> L27 Throwable -> L39
        goto L44
    L25:
        setState(State.PENDING_RECORDING);     // Catch: IOException -> L27 Throwable -> L39
    L27:
        e = e;
        r5 = 5;
        goto L30
    L13:
        if (this.mActiveRecordingRecord == null) goto L15;
    L17:
        boolean r11 = false;
    L18:
        Preconditions.checkState(r11, "Expected recorder to be idle but a recording is either pending or in progress.");     // Catch: Throwable -> L39
        goto L45
    L15:
        if (this.mPendingRecordingRecord != null) goto L17;
        r11 = true;
    L29:
        e = null;
    L39:
        th = move-exception;
        throw th;
    }

    public static VideoCapabilities getVideoCapabilities(CameraInfo r2, int r3) {
        return new RecorderVideoCapabilities(r3, (CameraInfoInternal) r2, VideoEncoderInfoImpl.FINDER);
    }

    private static boolean isSameRecording(Recording r4, RecordingRecord r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r4.getRecordingId() != r5.getRecordingId()) goto L9;
        return true;
    L9:
        return false;
    }

    private /* synthetic */ void lambda$mute$6(RecordingRecord r1, boolean r2) {
        muteInternal(r1, r2);
    }

    private /* synthetic */ void lambda$onSurfaceRequested$0(SurfaceRequest r1, Timebase r2) {
        onSurfaceRequestedInternal(r1, r2);
    }

    private static /* synthetic */ void lambda$scheduleTask$14(Executor r0, Runnable r1) {
        r0.execute(r1);
    }

    private /* synthetic */ Object lambda$updateEncoderCallbacks$10(final RecordingRecord r3, final CallbackToFutureAdapter.Completer r4) throws Exception {
        this.mVideoEncoder.setEncoderCallback(new AnonymousClass3(this, r4, r3), this.mSequentialExecutor);
        return "videoEncodingFuture";
    }

    private /* synthetic */ void lambda$updateEncoderCallbacks$11(CallbackToFutureAdapter.Completer r2, Throwable r3) {
        if (this.mAudioErrorCause == null) goto L5;
        return;
    L5:
        if ((r3 instanceof EncodeException) == false) goto L7;
        setAudioState(AudioState.ERROR_ENCODER);
    L8:
        this.mAudioErrorCause = r3;
        updateInProgressStatusEvent();
        r2.set(null);
        return;
    L7:
        setAudioState(AudioState.ERROR_SOURCE);
        goto L8
    }

    private /* synthetic */ Object lambda$updateEncoderCallbacks$12(final RecordingRecord r5, final CallbackToFutureAdapter.Completer r6) throws Exception {
        final Consumer r0 = new b(this, r6);
        this.mAudioSource.setAudioSourceCallback(this.mSequentialExecutor, new AnonymousClass4(this, r0));
        this.mAudioEncoder.setEncoderCallback(new AnonymousClass5(this, r6, r0, r5), this.mSequentialExecutor);
        return "audioEncodingFuture";
    }

    private void muteInternal(RecordingRecord r2, boolean r3) {
        if (r2.isMuted() != r3) goto L5;
        return;
    L5:
        r2.mute(r3);
        if (this.mInProgressRecording == r2) goto L8;
        return;
    L8:
        if (this.mInProgressRecordingStopping == true) goto L14;
        AudioSource r4 = this.mAudioSource;
        if (r4 == null) goto L15;
        r4.mute(r3);
        return;
    L15:
        return;
    }

    private void onSurfaceRequestedInternal(SurfaceRequest r2, Timebase r3) {
        SurfaceRequest r0 = this.mLatestSurfaceRequest;
        if (r0 != null) goto L5;
    L7:
        this.mLatestSurfaceRequest = r2;
        this.mVideoSourceTimebase = r3;
        configureInternal(r2, r3, true);
        return;
    L5:
        if (r0.isServiced() == true) goto L7;
        this.mLatestSurfaceRequest.willNotProvideSurface();
        goto L7
    }

    private PendingRecording prepareRecordingInternal(Context r2, OutputOptions r3) {
        Preconditions.checkNotNull(r3, "The OutputOptions cannot be null.");
        return new PendingRecording(r2, this, r3);
    }

    private AudioSource setupAudioSource(RecordingRecord r2, AudioSettings r3) throws AudioSourceAccessException {
        return r2.performOneTimeAudioSourceCreation(r3, AUDIO_EXECUTOR);
    }

    private void startRecording(RecordingRecord r1, boolean r2) {
        startInternal(r1);
        if (r2 == false) goto L6;
        pauseInternal(r1);
        return;
    }

    private static int supportedMuxerFormatOrDefaultFrom(VideoValidatedEncoderProfilesProxy r3, int r4) {
        if (r3 == null) goto L15;
        int r5 = r3.getRecommendedFileFormat();
        if (r5 == 1) goto L12;
        if (r5 != 2) goto L7;
        return 0;
    L7:
        if (r5 != 9) goto L15;
        return 1;
    L12:
        if (Build.VERSION.SDK_INT >= 26) goto L14;
        return 0;
    L14:
        return 2;
    L15:
        return r4;
    }

    private void updateEncoderCallbacks(final RecordingRecord r3, boolean r4) {
        if (this.mEncodingFutures.isEmpty() == true) goto L8;
        ListenableFuture r0 = Futures.allAsList(this.mEncodingFutures);
        if (r0.isDone() == true) goto L7;
        r0.cancel(true);
    L7:
        this.mEncodingFutures.clear();
    L8:
        this.mEncodingFutures.add(CallbackToFutureAdapter.getFuture(new g(this, r3)));
        if (isAudioEnabled() == false) goto L12;
        if (r4 == true) goto L12;
        this.mEncodingFutures.add(CallbackToFutureAdapter.getFuture(new h(this, r3)));
    L12:
        Futures.addCallback(Futures.allAsList(this.mEncodingFutures), new AnonymousClass6(this), CameraXExecutors.directExecutor());
    }

    public void finalizeInProgressRecording(int r7, Throwable r8) {
        if (this.mInProgressRecording == null) goto L37;
        MediaMuxer r0 = this.mMediaMuxer;
        if (r0 != null) goto L38;
        if (r7 != 0) goto L15;
        r7 = 8;
    L15:
        this.mInProgressRecording.finalizeRecording(this.mOutputUri);
        OutputOptions r1 = this.mInProgressRecording.getOutputOptions();
        RecordingStats r3 = getInProgressRecordingStats();
        OutputResults r4 = OutputResults.of(this.mOutputUri);
        RecordingRecord r5 = this.mInProgressRecording;
        if (r7 != 0) goto L18;
        VideoRecordEvent.Finalize r9 = VideoRecordEvent.finalize(r1, r3, r4);
    L19:
        r5.updateVideoRecordEvent(r9);
        RecordingRecord r10 = this.mInProgressRecording;
        this.mInProgressRecording = null;
        this.mInProgressRecordingStopping = false;
        this.mAudioTrackIndex = null;
        this.mVideoTrackIndex = null;
        this.mEncodingFutures.clear();
        this.mOutputUri = Uri.EMPTY;
        this.mRecordingBytes = 0;
        this.mRecordingDurationNs = 0;
        this.mFirstRecordingVideoDataTimeUs = Long.MAX_VALUE;
        this.mFirstRecordingAudioDataTimeUs = Long.MAX_VALUE;
        this.mPreviousRecordingVideoDataTimeUs = Long.MAX_VALUE;
        this.mPreviousRecordingAudioDataTimeUs = Long.MAX_VALUE;
        this.mRecordingStopError = 1;
        this.mRecordingStopErrorCause = null;
        this.mAudioErrorCause = null;
        this.mAudioAmplitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        clearPendingAudioRingBuffer();
        setInProgressTransformationInfo(null);
        int r11 = this.mAudioState.ordinal();
        if (r11 == 1) goto L35;
        if (r11 != 2) goto L24;
    L31:
        setAudioState(AudioState.IDLING);
        this.mAudioSource.stop();
    L32:
        onRecordingFinalized(r10);
        return;
    L24:
        if (r11 == 3) goto L31;
        if (r11 != 4) goto L28;
    L30:
        setAudioState(AudioState.INITIALIZING);
        goto L32
    L28:
        if (r11 == 5) goto L30;
    L35:
        throw new AssertionError("Incorrectly finalize recording when audio state is IDLING");
    L18:
        r9 = VideoRecordEvent.finalizeWithError(r1, r3, r4, r7, r8);
        goto L19
    L38:
        r0.stop();     // Catch: IllegalStateException -> L8
        this.mMediaMuxer.release();     // Catch: IllegalStateException -> L8
    L12:
        this.mMediaMuxer = null;
    L8:
        e = move-exception;
        Logger.e(TAG, "MediaMuxer failed to stop or release with error: " + e.getMessage());
        if (r7 != 0) goto L12;
        r7 = 1;
        goto L12
    L37:
        throw new AssertionError("Attempted to finalize in-progress recording, but no recording is in progress.");
    }

    public void mute(Recording r4, final boolean r5) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isSameRecording(r4, this.mPendingRecordingRecord) == true) goto L12;
        if (isSameRecording(r4, this.mActiveRecordingRecord) == true) goto L12;
        Logger.d(TAG, "mute() called on a recording that is no longer active: " + r4.getOutputOptions());     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L12:
        if (isSameRecording(r4, this.mPendingRecordingRecord) == false) goto L14;
        final RecordingRecord r6 = this.mPendingRecordingRecord;     // Catch: Throwable -> L18
    L15:
        this.mSequentialExecutor.execute(new c(this, r6, r5));     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L14:
        r6 = this.mActiveRecordingRecord;     // Catch: Throwable -> L18
        goto L15
    }

    @Override // androidx.camera.video.VideoOutput
    public void onSurfaceRequested(final SurfaceRequest r5, final Timebase r6) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        Logger.d(TAG, "Surface is requested in state: " + this.mState + ", Current surface: " + this.mStreamId);     // Catch: Throwable -> L10
        if (this.mState != State.ERROR) goto L7;
        setState(State.CONFIGURING);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r1);     // Catch: Throwable -> L10
        this.mSequentialExecutor.execute(new s(this, r5, r6));
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public PendingRecording prepareRecording(Context r3, FileDescriptorOutputOptions r4) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return prepareRecordingInternal(r3, r4);
    L7:
        throw new UnsupportedOperationException("File descriptors as output destinations are not supported on pre-Android O (API 26) devices.");
    }

    public void writeAudioData(EncodedData r20, RecordingRecord r21) {
        long r2 = this.mRecordingBytes + r20.size();
        long r4 = this.mFileSizeLimitInBytes;
        if (r4 != 0) goto L5;
    L8:
        long r5 = r20.getPresentationTimeUs();
        long r13 = this.mFirstRecordingAudioDataTimeUs;
        if (r13 != Long.MAX_VALUE) goto L11;
        this.mFirstRecordingAudioDataTimeUs = r5;
        Logger.d(TAG, String.format("First audio time: %d (%s)", new Object[]{Long.valueOf(r5), DebugUtils.readableUs(this.mFirstRecordingAudioDataTimeUs)}));
    L21:
        this.mMediaMuxer.writeSampleData(this.mAudioTrackIndex.intValue(), r20.getByteBuffer(), r20.getBufferInfo());
        this.mRecordingBytes = r2;
        this.mPreviousRecordingAudioDataTimeUs = r5;
        return;
    L11:
        TimeUnit r6 = TimeUnit.MICROSECONDS;
        long r8 = r6.toNanos(r5 - Math.min(this.mFirstRecordingVideoDataTimeUs, r13));
        if (this.mPreviousRecordingAudioDataTimeUs == Long.MAX_VALUE) goto L14;
        boolean r14 = true;
    L15:
        Preconditions.checkState(r14, "There should be a previous data for adjusting the duration.");
        long r9 = r8 + r6.toNanos(r5 - this.mPreviousRecordingAudioDataTimeUs);
        long r15 = this.mDurationLimitNs;
        if (r15 == 0) goto L21;
        if (r9 <= r15) goto L21;
        Logger.d(TAG, String.format("Audio data reaches duration limit %d > %d", new Object[]{Long.valueOf(r9), Long.valueOf(this.mDurationLimitNs)}));
        onInProgressRecordingInternalError(r21, 9, null);
        return;
    L14:
        r14 = false;
        goto L15
    L5:
        if (r2 <= r4) goto L8;
        Logger.d(TAG, String.format("Reach file size limit %d > %d", new Object[]{Long.valueOf(r2), Long.valueOf(this.mFileSizeLimitInBytes)}));
        onInProgressRecordingInternalError(r21, 2, null);
    }

    public void writeVideoData(EncodedData r20, RecordingRecord r21) {
        if (this.mVideoTrackIndex == null) goto L27;
        long r2 = this.mRecordingBytes + r20.size();
        long r4 = this.mFileSizeLimitInBytes;
        long r8 = 0;
        if (r4 != 0) goto L7;
    L10:
        long r5 = r20.getPresentationTimeUs();
        long r13 = this.mFirstRecordingVideoDataTimeUs;
        if (r13 != Long.MAX_VALUE) goto L13;
        this.mFirstRecordingVideoDataTimeUs = r5;
        Logger.d(TAG, String.format("First video time: %d (%s)", new Object[]{Long.valueOf(r5), DebugUtils.readableUs(this.mFirstRecordingVideoDataTimeUs)}));
    L24:
        this.mMediaMuxer.writeSampleData(this.mVideoTrackIndex.intValue(), r20.getByteBuffer(), r20.getBufferInfo());
        this.mRecordingBytes = r2;
        this.mRecordingDurationNs = r8;
        this.mPreviousRecordingVideoDataTimeUs = r5;
        updateInProgressStatusEvent();
        return;
    L13:
        TimeUnit r6 = TimeUnit.MICROSECONDS;
        long r10 = r6.toNanos(r5 - Math.min(r13, this.mFirstRecordingAudioDataTimeUs));
        if (this.mPreviousRecordingVideoDataTimeUs == Long.MAX_VALUE) goto L16;
        boolean r14 = true;
    L17:
        Preconditions.checkState(r14, "There should be a previous data for adjusting the duration.");
        long r15 = r6.toNanos(r5 - this.mPreviousRecordingVideoDataTimeUs) + r10;
        long r12 = this.mDurationLimitNs;
        if (r12 != 0) goto L20;
    L23:
        r8 = r10;
        goto L24
    L20:
        if (r15 <= r12) goto L23;
        Logger.d(TAG, String.format("Video data reaches duration limit %d > %d", new Object[]{Long.valueOf(r15), Long.valueOf(this.mDurationLimitNs)}));
        onInProgressRecordingInternalError(r21, 9, null);
        return;
    L16:
        r14 = false;
        goto L17
    L7:
        if (r2 <= r4) goto L10;
        Logger.d(TAG, String.format("Reach file size limit %d > %d", new Object[]{Long.valueOf(r2), Long.valueOf(this.mFileSizeLimitInBytes)}));
        onInProgressRecordingInternalError(r21, 2, null);
        return;
    L27:
        throw new AssertionError("Video data comes before the track is added to MediaMuxer.");
    }

    public PendingRecording prepareRecording(Context r1, FileOutputOptions r2) {
        return prepareRecordingInternal(r1, r2);
    }

    public PendingRecording prepareRecording(Context r1, MediaStoreOutputOptions r2) {
        return prepareRecordingInternal(r1, r2);
    }

    private void configureInternal(SurfaceRequest r8, Timebase r9, boolean r10) {
        if (r8.isServiced() == false) goto L6;
        Logger.w(TAG, "Ignore the SurfaceRequest since it is already served.");
        return;
    L6:
        r8.setTransformationInfoListener(this.mSequentialExecutor, new p(this));
        Size r0 = r8.getResolution();
        DynamicRange r2 = r8.getDynamicRange();
        VideoCapabilities r3 = getVideoCapabilities(r8.getCamera().getCameraInfo());
        Quality r4 = r3.findNearestHigherSupportedQualityFor(r0, r2);
        Logger.d(TAG, "Using supported quality of " + r4 + " for surface size " + r0);
        if (r4 == Quality.NONE) goto L13;
        VideoValidatedEncoderProfilesProxy r1 = r3.getProfiles(r4, r2);
        this.mResolvedEncoderProfiles = r1;
        if (r1 != null) goto L13;
        throw new AssertionError("Camera advertised available quality but did not produce EncoderProfiles  for advertised quality.");
    L13:
        SetupVideoTask r5 = this.mSetupVideoTask;
        if (r5 == null) goto L17;
        r5.cancelFailedRetry();
    L17:
        if (r10 == false) goto L19;
        int r11 = sRetrySetupVideoMaxCount;
    L20:
        SetupVideoTask r6 = new SetupVideoTask(this, r8, r9, r11);
        this.mSetupVideoTask = r6;
        r6.start();
        return;
    L19:
        r11 = 0;
        goto L20
    }

    private void finalizePendingRecording(RecordingRecord r6, int r7, Throwable r8) {
        r6.finalizeRecording(Uri.EMPTY);
        r6.updateVideoRecordEvent(VideoRecordEvent.finalizeWithError(r6.getOutputOptions(), RecordingStats.of(0, 0, AudioStats.of(1, this.mAudioErrorCause, AudioStats.AUDIO_AMPLITUDE_NONE)), OutputResults.of(Uri.EMPTY), r7, r8));
    }

    public void onInProgressRecordingInternalError(RecordingRecord r11, int r12, Throwable r13) {
        if (r11 != this.mInProgressRecording) goto L25;
        Object r1 = this.mLock;
        monitor-enter(r1);
        boolean r3 = false;
        switch(this.mState.ordinal()) {
            case 0: goto L16;
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L16;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L11;
            case 7: goto L11;
            case 8: goto L16;
            default: goto L17;
        };     // Catch: Throwable -> L21
    L9:
        setState(State.STOPPING);     // Catch: Throwable -> L21
        r3 = true;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L21
        if (r3 == false) goto L27;
        stopInternal(r11, -1, r12, r13);
        return;
    L27:
        return;
    L11:
        if (r11 == this.mActiveRecordingRecord) goto L17;
        throw new AssertionError("Internal error occurred for recording but it is not the active recording.");     // Catch: Throwable -> L21
    L16:
        throw new AssertionError("In-progress recording error occurred while in unexpected state: " + this.mState);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L25:
        throw new AssertionError("Internal error occurred on recording that is not the current in-progress recording.");
    }

    public void requestReset(int r12, Throwable r13, boolean r14) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        boolean r3 = true;
        boolean r4 = false;
        switch(this.mState.ordinal()) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L22;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L21;
            case 8: goto L22;
            default: goto L21;
        };     // Catch: Throwable -> L30
    L7:
        setState(State.RESETTING);     // Catch: Throwable -> L30
        goto L21
    L20:
        updateNonPendingState(State.RESETTING);     // Catch: Throwable -> L30
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L30
        if (r3 == false) goto L27;
        if (r14 == false) goto L26;
        resetVideo();
        return;
    L26:
        reset();
        return;
    L27:
        if (r4 == false) goto L36;
        stopInternal(this.mInProgressRecording, -1, r12, r13);
        return;
    L36:
        return;
    L21:
        r3 = false;
        goto L22
    L9:
        if (this.mInProgressRecording == null) goto L11;
        boolean r2 = true;
    L12:
        Preconditions.checkState(r2, "In-progress recording shouldn't be null when in state " + this.mState);     // Catch: Throwable -> L30
        if (this.mActiveRecordingRecord != this.mInProgressRecording) goto L19;
        if (isPersistentRecordingInProgress() == true) goto L22;
        setState(State.RESETTING);     // Catch: Throwable -> L30
        r3 = false;
        r4 = true;
        goto L22
    L19:
        throw new AssertionError("In-progress recording does not match the active recording. Unable to reset encoder.");     // Catch: Throwable -> L30
    L11:
        r2 = false;
    L30:
        th = move-exception;
        throw th;
    }

    public void stop(Recording r13, final int r14, final Throwable r15) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (isSameRecording(r13, this.mPendingRecordingRecord) == false) goto L7;
    L11:
        RecordingRecord r2 = null;
        switch(this.mState.ordinal()) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L16;
            case 3: goto L18;
            case 4: goto L15;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L14;
            default: goto L19;
        };     // Catch: Throwable -> L26
    L14:
        Preconditions.checkState(isSameRecording(r13, this.mActiveRecordingRecord));     // Catch: Throwable -> L26
        goto L19
    L15:
        setState(State.STOPPING);     // Catch: Throwable -> L26
        final long r8 = TimeUnit.NANOSECONDS.toMicros(System.nanoTime());     // Catch: Throwable -> L26
        final RecordingRecord r7 = this.mActiveRecordingRecord;     // Catch: Throwable -> L26
        this.mSequentialExecutor.execute(new d(this, r7, r8, r14, r15));     // Catch: Throwable -> L26
        goto L19
    L16:
        Preconditions.checkState(isSameRecording(r13, this.mPendingRecordingRecord));     // Catch: Throwable -> L26
        RecordingRecord r16 = this.mPendingRecordingRecord;     // Catch: Throwable -> L26
        this.mPendingRecordingRecord = null;     // Catch: Throwable -> L26
        restoreNonPendingState();     // Catch: Throwable -> L26
        r2 = r16;
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L26
        if (r2 != null) goto L22;
        return;
    L22:
        if (r14 != 10) goto L24;
        Logger.e(TAG, "Recording was stopped due to recording being garbage collected before any valid data has been produced.");
    L24:
        finalizePendingRecording(r2, 8, new RuntimeException("Recording was stopped before any data could be produced.", r15));
        return;
    L18:
        throw new IllegalStateException("Calling stop() while idling or initializing is invalid.");     // Catch: Throwable -> L26
    L7:
        if (isSameRecording(r13, this.mActiveRecordingRecord) == true) goto L11;
        Logger.d(TAG, "stop() called on a recording that is no longer active: " + r13.getOutputOptions());     // Catch: Throwable -> L26
        monitor-exit(r1);     // Catch: Throwable -> L26
    }

    public static /* synthetic */ ScheduledFuture access$700(Runnable r0, Executor r1, long r2, TimeUnit r4) {
        return scheduleTask(r0, r1, r2, r4);
    }

    private /* synthetic */ void lambda$stop$5(RecordingRecord r1, long r2, int r4, Throwable r5) {
        stopInternal(r1, r2, r4, r5);
    }

    private static ScheduledFuture<?> scheduleTask(final Runnable r2, final Executor r3, long r4, TimeUnit r6) {
        return CameraXExecutors.mainThreadExecutor().schedule(new f(r3, r2), r4, r6);
    }

    public void stopInternal(RecordingRecord r3, long r4, int r6, Throwable r7) {
        if (this.mInProgressRecording == r3) goto L5;
        return;
    L5:
        if (this.mInProgressRecordingStopping == true) goto L19;
        this.mInProgressRecordingStopping = true;
        this.mRecordingStopError = r6;
        this.mRecordingStopErrorCause = r7;
        if (isAudioEnabled() == false) goto L9;
        clearPendingAudioRingBuffer();
        this.mAudioEncoder.stop(r4);
    L9:
        EncodedData r5 = this.mPendingFirstVideoData;
        if (r5 == null) goto L13;
        r5.close();
        this.mPendingFirstVideoData = null;
    L13:
        if (this.mSourceState == VideoOutput.SourceState.ACTIVE_NON_STREAMING) goto L15;
        final Encoder r8 = this.mVideoEncoder;
        this.mSourceNonStreamingTimeout = scheduleTask(new i(r8), this.mSequentialExecutor, 1000, TimeUnit.MILLISECONDS);
    L16:
        this.mVideoEncoder.stop(r4);
        return;
    L15:
        notifyEncoderSourceStopped(this.mVideoEncoder);
        goto L16
    }

    public Recorder(Executor r8, MediaSpec r9, int r10, EncoderFactory r11, EncoderFactory r12) {
        this.mLock = new Object();
        if (DeviceQuirks.get(EncoderNotUsePersistentInputSurfaceQuirk.class) == null) goto L5;
        boolean r0 = true;
    L6:
        this.mEncoderNotUsePersistentInputSurface = r0;
        this.mState = State.CONFIGURING;
        this.mNonPendingState = null;
        this.mStreamId = 0;
        this.mActiveRecordingRecord = null;
        this.mPendingRecordingRecord = null;
        this.mLastGeneratedRecordingId = 0;
        this.mInProgressRecording = null;
        this.mInProgressRecordingStopping = false;
        this.mInProgressTransformationInfo = null;
        this.mSourceTransformationInfo = null;
        this.mResolvedEncoderProfiles = null;
        this.mEncodingFutures = new ArrayList();
        this.mAudioTrackIndex = null;
        this.mVideoTrackIndex = null;
        this.mLatestSurface = null;
        this.mActiveSurface = null;
        this.mMediaMuxer = null;
        this.mAudioSource = null;
        this.mVideoEncoder = null;
        this.mVideoOutputConfig = null;
        this.mAudioEncoder = null;
        this.mAudioOutputConfig = null;
        this.mAudioState = AudioState.INITIALIZING;
        this.mOutputUri = Uri.EMPTY;
        this.mRecordingBytes = 0;
        this.mRecordingDurationNs = 0;
        this.mFirstRecordingVideoDataTimeUs = Long.MAX_VALUE;
        this.mFirstRecordingVideoBitrate = 0;
        this.mVideoEncoderBitrateRange = null;
        this.mFirstRecordingAudioDataTimeUs = Long.MAX_VALUE;
        this.mPreviousRecordingVideoDataTimeUs = Long.MAX_VALUE;
        this.mPreviousRecordingAudioDataTimeUs = Long.MAX_VALUE;
        this.mFileSizeLimitInBytes = 0;
        this.mDurationLimitNs = 0;
        this.mRecordingStopError = 1;
        this.mRecordingStopErrorCause = null;
        this.mPendingFirstVideoData = null;
        this.mPendingAudioRingBuffer = new ArrayRingBuffer(AUDIO_CACHE_SIZE);
        this.mAudioErrorCause = null;
        this.mIsAudioSourceSilenced = false;
        this.mSourceState = VideoOutput.SourceState.INACTIVE;
        this.mSourceNonStreamingTimeout = null;
        this.mNeedsResetBeforeNextStart = false;
        this.mVideoEncoderSessionToRelease = null;
        this.mAudioAmplitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mShouldSendResumeEvent = false;
        this.mSetupVideoTask = null;
        this.mUserProvidedExecutor = r8;
        if (r8 != null) goto L10;
        r8 = CameraXExecutors.ioExecutor();
    L10:
        this.mExecutor = r8;
        Executor r1 = CameraXExecutors.newSequentialExecutor(r8);
        this.mSequentialExecutor = r1;
        this.mMediaSpec = MutableStateObservable.withInitialState(composeRecorderMediaSpec(r9));
        this.mVideoCapabilitiesSource = r10;
        this.mStreamInfo = MutableStateObservable.withInitialState(StreamInfo.of(this.mStreamId, internalStateToStreamState(this.mState)));
        this.mIsRecording = MutableStateObservable.withInitialState(Boolean.FALSE);
        this.mVideoEncoderFactory = r11;
        this.mAudioEncoderFactory = r12;
        this.mVideoEncoderSession = new VideoEncoderSession(r11, r1, r8);
        return;
    L5:
        r0 = false;
        goto L6
    }
}

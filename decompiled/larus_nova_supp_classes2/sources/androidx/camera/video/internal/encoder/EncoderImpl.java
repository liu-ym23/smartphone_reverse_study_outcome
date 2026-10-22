package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Range;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.DebugUtils;
import androidx.camera.video.internal.compat.quirk.AudioEncoderIgnoresInputTimestampQuirk;
import androidx.camera.video.internal.compat.quirk.CameraUseInconsistentTimebaseQuirk;
import androidx.camera.video.internal.compat.quirk.CodecStuckOnFlushQuirk;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.EncoderNotUsePersistentInputSurfaceQuirk;
import androidx.camera.video.internal.compat.quirk.SignalEosOutputBufferNotComeQuirk;
import androidx.camera.video.internal.compat.quirk.StopCodecAfterSurfaceRemovalCrashMediaServerQuirk;
import androidx.camera.video.internal.compat.quirk.VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk;
import androidx.camera.video.internal.utils.CodecUtil;
import androidx.camera.video.internal.workaround.VideoTimebaseConverter;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class EncoderImpl implements Encoder {
    private static final boolean DEBUG = false;
    private static final long NO_LIMIT_LONG = Long.MAX_VALUE;
    private static final Range<Long> NO_RANGE = null;
    private static final long SIGNAL_EOS_TIMEOUT_MS = 1000;
    private static final long STOP_TIMEOUT_MS = 1000;
    private final Queue<CallbackToFutureAdapter.Completer<InputBuffer>> mAcquisitionQueue;
    final Deque<Range<Long>> mActivePauseResumeTimeRanges;
    final Set<EncodedDataImpl> mEncodedDataSet;
    EncoderCallback mEncoderCallback;
    Executor mEncoderCallbackExecutor;
    final Executor mEncoderExecutor;
    private final EncoderInfo mEncoderInfo;
    final Encoder.EncoderInput mEncoderInput;
    final Queue<Integer> mFreeInputBufferIndexQueue;
    private final Set<InputBuffer> mInputBufferSet;
    final Timebase mInputTimebase;
    private boolean mIsFlushedAfterEndOfStream;
    final boolean mIsVideoEncoder;
    Long mLastDataStopTimestamp;
    final Object mLock;
    final MediaCodec mMediaCodec;
    private MediaCodecCallback mMediaCodecCallback;
    boolean mMediaCodecEosSignalled;
    private final MediaFormat mMediaFormat;
    boolean mPendingCodecStop;
    private final CallbackToFutureAdapter.Completer<Void> mReleasedCompleter;
    private final ListenableFuture<Void> mReleasedFuture;
    private Future<?> mSignalEosTimeoutFuture;
    private boolean mSourceStoppedSignalled;
    Range<Long> mStartStopTimeRangeUs;
    InternalState mState;
    Future<?> mStopTimeoutFuture;
    final String mTag;
    final TimeProvider mTimeProvider;
    long mTotalPausedDurationUs;

    public static class Api23Impl {
        public static Surface createPersistentInputSurface() {
            return MediaCodec.createPersistentInputSurface();
        }

        private Api23Impl() {
        }

        public static void setInputSurface(MediaCodec r0, Surface r1) {
            r0.setInputSurface(r1);
        }
    }

    public class ByteBufferInput implements Encoder.ByteBufferInput {
        private final List<ListenableFuture<InputBuffer>> mAcquisitionList;
        private BufferProvider.State mBufferProviderState;
        private final Map<Observable.Observer<? super BufferProvider.State>, Executor> mStateObservers;
        final /* synthetic */ EncoderImpl this$0;

        public static /* synthetic */ void a(ByteBufferInput r0, Observable.Observer r1) {
            r0.lambda$removeObserver$8(r1);
        }

        public static /* synthetic */ void b(ByteBufferInput r0, Observable.Observer r1, Executor r2) {
            r0.lambda$addObserver$7(r1, r2);
        }

        public static /* synthetic */ void c(ByteBufferInput r0, ListenableFuture r1) {
            r0.lambda$acquireBuffer$3(r1);
        }

        public static /* synthetic */ void d(Map.Entry r0, BufferProvider.State r1) {
            lambda$setActive$9(r0, r1);
        }

        public static /* synthetic */ void e(ByteBufferInput r0, CallbackToFutureAdapter.Completer r1) {
            r0.lambda$acquireBuffer$4(r1);
        }

        public static /* synthetic */ Object f(ByteBufferInput r0, CallbackToFutureAdapter.Completer r1) {
            return r0.lambda$acquireBuffer$5(r1);
        }

        public static /* synthetic */ void g(Observable.Observer r0, BufferProvider.State r1) {
            lambda$addObserver$6(r0, r1);
        }

        public static /* synthetic */ void h(ByteBufferInput r0, CallbackToFutureAdapter.Completer r1) {
            r0.lambda$fetchData$0(r1);
        }

        public static /* synthetic */ Object i(ByteBufferInput r0, CallbackToFutureAdapter.Completer r1) {
            return r0.lambda$fetchData$1(r1);
        }

        public static /* synthetic */ void j(ByteBufferInput r0, ListenableFuture r1) {
            r0.lambda$acquireBuffer$2(r1);
        }

        @Override // androidx.camera.video.internal.BufferProvider
        public ListenableFuture<InputBuffer> acquireBuffer() {
            return CallbackToFutureAdapter.getFuture(new x(this));
        }

        @Override // androidx.camera.core.impl.Observable
        public ListenableFuture<BufferProvider.State> fetchData() {
            return CallbackToFutureAdapter.getFuture(new c0(this));
        }

        public ByteBufferInput(EncoderImpl r1) {
            this.this$0 = r1;
            this.mStateObservers = new LinkedHashMap();
            this.mBufferProviderState = BufferProvider.State.INACTIVE;
            this.mAcquisitionList = new ArrayList();
        }

        private void cancelInputBuffer(ListenableFuture<InputBuffer> r4) {
            if (r4.cancel(true) == true) goto L16;
            Preconditions.checkState(r4.isDone());
            ((InputBuffer) r4.get()).cancel();     // Catch: CancellationException -> L7 Throwable -> L9 ExecutionException -> L11
            return;
        L9:
            e = move-exception;
            Logger.w(this.this$0.mTag, "Unable to cancel the input buffer: " + e);
            return;
        }

        private /* synthetic */ void lambda$acquireBuffer$2(ListenableFuture r1) {
            cancelInputBuffer(r1);
        }

        private /* synthetic */ void lambda$acquireBuffer$3(ListenableFuture r2) {
            this.mAcquisitionList.remove(r2);
        }

        private /* synthetic */ void lambda$acquireBuffer$4(CallbackToFutureAdapter.Completer r4) {
            BufferProvider.State r0 = this.mBufferProviderState;
            if (r0 != BufferProvider.State.ACTIVE) goto L6;
            final ListenableFuture<InputBuffer> r1 = this.this$0.acquireInputBuffer();
            Futures.propagate(r1, r4);
            r4.addCancellationListener(new z(this, r1), CameraXExecutors.directExecutor());
            this.mAcquisitionList.add(r1);
            r1.addListener(new a0(this, r1), this.this$0.mEncoderExecutor);
            return;
        L6:
            if (r0 != BufferProvider.State.INACTIVE) goto L8;
            r4.setException(new IllegalStateException("BufferProvider is not active."));
            return;
        L8:
            r4.setException(new IllegalStateException("Unknown state: " + this.mBufferProviderState));
        }

        private /* synthetic */ Object lambda$acquireBuffer$5(final CallbackToFutureAdapter.Completer r3) throws Exception {
            this.this$0.mEncoderExecutor.execute(new v(this, r3));
            return "acquireBuffer";
        }

        private /* synthetic */ void lambda$fetchData$0(CallbackToFutureAdapter.Completer r2) {
            r2.set(this.mBufferProviderState);
        }

        private /* synthetic */ Object lambda$fetchData$1(final CallbackToFutureAdapter.Completer r3) throws Exception {
            this.this$0.mEncoderExecutor.execute(new y(this, r3));
            return "fetchData";
        }

        private /* synthetic */ void lambda$removeObserver$8(Observable.Observer r2) {
            this.mStateObservers.remove(Preconditions.checkNotNull(r2));
        }

        @Override // androidx.camera.core.impl.Observable
        public void removeObserver(final Observable.Observer<? super BufferProvider.State> r3) {
            this.this$0.mEncoderExecutor.execute(new b0(this, r3));
        }

        public void setActive(boolean r5) {
            if (r5 == false) goto L4;
            final BufferProvider.State r6 = BufferProvider.State.ACTIVE;
        L6:
            if (this.mBufferProviderState != r6) goto L8;
            return;
        L8:
            this.mBufferProviderState = r6;
            if (r6 != BufferProvider.State.INACTIVE) goto L15;
            Iterator<ListenableFuture<InputBuffer>> r0 = this.mAcquisitionList.iterator();
        L12:
            if (r0.hasNext() == false) goto L14;
            r0.next().cancel(true);
            goto L12
        L14:
            this.mAcquisitionList.clear();
        L15:
            Iterator<Map.Entry<Observable.Observer<? super BufferProvider.State>, Executor>> r1 = this.mStateObservers.entrySet().iterator();
        L17:
            if (r1.hasNext() == false) goto L23;
            final Map.Entry<Observable.Observer<? super BufferProvider.State>, Executor> r2 = r1.next();
            r2.getValue().execute(new u(r2, r6));     // Catch: RejectedExecutionException -> L21
        L21:
            e = move-exception;
            Logger.e(this.this$0.mTag, "Unable to post to the supplied executor.", e);
            goto L17
        L23:
            return;
        L4:
            r6 = BufferProvider.State.INACTIVE;
            goto L6
        }

        private static /* synthetic */ void lambda$addObserver$6(Observable.Observer r0, BufferProvider.State r1) {
            r0.onNewData(r1);
        }

        private /* synthetic */ void lambda$addObserver$7(final Observable.Observer r4, Executor r5) {
            this.mStateObservers.put((Observable.Observer) Preconditions.checkNotNull(r4), (Executor) Preconditions.checkNotNull(r5));
            final BufferProvider.State r0 = this.mBufferProviderState;
            r5.execute(new w(r4, r0));
        }

        private static /* synthetic */ void lambda$setActive$9(Map.Entry r0, BufferProvider.State r1) {
            ((Observable.Observer) r0.getKey()).onNewData(r1);
        }

        @Override // androidx.camera.core.impl.Observable
        public void addObserver(final Executor r3, final Observable.Observer<? super BufferProvider.State> r4) {
            this.this$0.mEncoderExecutor.execute(new d0(this, r4, r3));
        }
    }

    public static final enum InternalState extends Enum<InternalState> {
        private static final /* synthetic */ InternalState[] $VALUES = null;
        public static final InternalState CONFIGURED = null;
        public static final InternalState ERROR = null;
        public static final InternalState PAUSED = null;
        public static final InternalState PENDING_RELEASE = null;
        public static final InternalState PENDING_START = null;
        public static final InternalState PENDING_START_PAUSED = null;
        public static final InternalState RELEASED = null;
        public static final InternalState STARTED = null;
        public static final InternalState STOPPING = null;

        private static /* synthetic */ InternalState[] $values() {
            return new InternalState[]{CONFIGURED, STARTED, PAUSED, STOPPING, PENDING_START, PENDING_START_PAUSED, PENDING_RELEASE, ERROR, RELEASED};
        }

        static {
            CONFIGURED = new InternalState("CONFIGURED", 0);
            STARTED = new InternalState("STARTED", 1);
            PAUSED = new InternalState("PAUSED", 2);
            STOPPING = new InternalState("STOPPING", 3);
            PENDING_START = new InternalState("PENDING_START", 4);
            PENDING_START_PAUSED = new InternalState("PENDING_START_PAUSED", 5);
            PENDING_RELEASE = new InternalState("PENDING_RELEASE", 6);
            ERROR = new InternalState("ERROR", 7);
            RELEASED = new InternalState("RELEASED", 8);
            $VALUES = $values();
        }

        public static InternalState[] values() {
            return (InternalState[]) $VALUES.clone();
        }

        public static InternalState valueOf(String r1) {
            return (InternalState) r27.a.a(InternalState.class, r1);
        }

        private InternalState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public class MediaCodecCallback extends MediaCodec.Callback {
        private boolean mHasEndData;
        private boolean mHasFirstData;
        private boolean mHasSendStartCallback;
        private boolean mIsKeyFrameRequired;
        private boolean mIsOutputBufferInPauseState;
        private long mLastPresentationTimeUs;
        private long mLastSentAdjustedTimeUs;
        private boolean mReachStopTimeAsEos;
        private boolean mStopped;
        private final VideoTimebaseConverter mVideoTimestampConverter;
        final /* synthetic */ EncoderImpl this$0;

        public static /* synthetic */ void a(MediaCodecCallback r0, MediaFormat r1) {
            r0.lambda$onOutputFormatChanged$7(r1);
        }

        public static /* synthetic */ void b(MediaCodecCallback r0, MediaCodec.BufferInfo r1, MediaCodec r2, int r3) {
            r0.lambda$onOutputBufferAvailable$1(r1, r2, r3);
        }

        public static /* synthetic */ void c(MediaCodecCallback r0, int r1) {
            r0.lambda$onInputBufferAvailable$0(r1);
        }

        public static /* synthetic */ void d(MediaCodecCallback r0, MediaCodec.CodecException r1) {
            r0.lambda$onError$4(r1);
        }

        public static /* synthetic */ void e(EncoderCallback r0, EncodedDataImpl r1) {
            lambda$sendEncodedData$3(r0, r1);
        }

        public static /* synthetic */ MediaFormat f(MediaFormat r0) {
            return lambda$onOutputFormatChanged$5(r0);
        }

        public static /* synthetic */ void g(EncoderCallback r0, MediaFormat r1) {
            lambda$onOutputFormatChanged$6(r0, r1);
        }

        public static /* synthetic */ void h(MediaCodecCallback r0, Executor r1, EncoderCallback r2) {
            r0.lambda$reachEndData$2(r1, r2);
        }

        private static /* synthetic */ MediaFormat lambda$onOutputFormatChanged$5(MediaFormat r0) {
            return r0;
        }

        public void stop() {
            this.mStopped = true;
        }

        public void reachEndData() {
            if (this.mHasEndData == false) goto L5;
            return;
        L5:
            this.mHasEndData = true;
            if (EncoderImpl.access$100(this.this$0) == null) goto L8;
            EncoderImpl.access$100(this.this$0).cancel(false);
            EncoderImpl.access$102(this.this$0, null);
        L8:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            EncoderImpl r1 = this.this$0;     // Catch: Throwable -> L14
            final EncoderCallback r2 = r1.mEncoderCallback;     // Catch: Throwable -> L14
            final Executor r3 = r1.mEncoderCallbackExecutor;     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            this.this$0.stopMediaCodec(new g0(this, r3, r2));
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public MediaCodecCallback(EncoderImpl r6) {
            this.this$0 = r6;
            this.mReachStopTimeAsEos = true;
            this.mHasSendStartCallback = false;
            this.mHasFirstData = false;
            this.mHasEndData = false;
            this.mLastPresentationTimeUs = 0;
            this.mLastSentAdjustedTimeUs = 0;
            this.mIsOutputBufferInPauseState = false;
            this.mIsKeyFrameRequired = false;
            this.mStopped = false;
            if (r6.mIsVideoEncoder == false) goto L5;
            this.mVideoTimestampConverter = new VideoTimebaseConverter(r6.mTimeProvider, r6.mInputTimebase, (CameraUseInconsistentTimebaseQuirk) DeviceQuirks.get(CameraUseInconsistentTimebaseQuirk.class));
        L6:
            CodecStuckOnFlushQuirk r1 = (CodecStuckOnFlushQuirk) DeviceQuirks.get(CodecStuckOnFlushQuirk.class);
            if (r1 != null) goto L9;
            return;
        L9:
            if (r1.isProblematicMimeType(EncoderImpl.access$000(r6).getString("mime")) == false) goto L13;
            this.mReachStopTimeAsEos = false;
            return;
        L13:
            return;
        L5:
            this.mVideoTimestampConverter = null;
            goto L6
        }

        private boolean checkBufferInfo(MediaCodec.BufferInfo r8) {
            if (this.mHasEndData == false) goto L7;
            Logger.d(this.this$0.mTag, "Drop buffer by already reach end of stream.");
            return false;
        L7:
            if (r8.size > 0) goto L11;
            Logger.d(this.this$0.mTag, "Drop buffer by invalid buffer size.");
            return false;
        L11:
            if ((r8.flags & 2) == 0) goto L14;
            Logger.d(this.this$0.mTag, "Drop buffer by codec config.");
            return false;
        L14:
            VideoTimebaseConverter r0 = this.mVideoTimestampConverter;
            if (r0 == null) goto L17;
            r8.presentationTimeUs = r0.convertToUptimeUs(r8.presentationTimeUs);
        L17:
            long r2 = r8.presentationTimeUs;
            if (r2 > this.mLastPresentationTimeUs) goto L21;
            Logger.d(this.this$0.mTag, "Drop buffer by out of order buffer from MediaCodec.");
            return false;
        L21:
            this.mLastPresentationTimeUs = r2;
            if (this.this$0.mStartStopTimeRangeUs.contains(Long.valueOf(r2)) == true) goto L33;
            Logger.d(this.this$0.mTag, "Drop buffer by not in start-stop range.");
            EncoderImpl r1 = this.this$0;
            if (r1.mPendingCodecStop == true) goto L26;
        L31:
            return false;
        L26:
            if (r8.presentationTimeUs < ((Long) r1.mStartStopTimeRangeUs.getUpper()).longValue()) goto L31;
            Future<?> r3 = this.this$0.mStopTimeoutFuture;
            if (r3 == null) goto L30;
            r3.cancel(true);
        L30:
            EncoderImpl r4 = this.this$0;
            r4.mLastDataStopTimestamp = Long.valueOf(r8.presentationTimeUs);
            this.this$0.signalCodecStop();
            this.this$0.mPendingCodecStop = false;
            goto L31
        L33:
            if (updatePauseRangeStateAndCheckIfBufferPaused(r8) == false) goto L37;
            Logger.d(this.this$0.mTag, "Drop buffer by pause.");
            return false;
        L37:
            if (this.this$0.getAdjustedTimeUs(r8) > this.mLastSentAdjustedTimeUs) goto L45;
            Logger.d(this.this$0.mTag, "Drop buffer by adjusted time is less than the last sent time.");
            if (this.this$0.mIsVideoEncoder == true) goto L41;
        L43:
            return false;
        L41:
            if (EncoderImpl.isKeyFrame(r8) == false) goto L43;
            this.mIsKeyFrameRequired = true;
            goto L43
        L45:
            if (this.mHasFirstData == true) goto L52;
            if (this.mIsKeyFrameRequired == true) goto L52;
            if (this.this$0.mIsVideoEncoder == false) goto L52;
            this.mIsKeyFrameRequired = true;
        L52:
            if (this.mIsKeyFrameRequired == true) goto L54;
        L58:
            return true;
        L54:
            if (EncoderImpl.isKeyFrame(r8) == true) goto L57;
            Logger.d(this.this$0.mTag, "Drop buffer by not a key frame.");
            this.this$0.requestKeyFrameToMediaCodec();
            return false;
        L57:
            this.mIsKeyFrameRequired = false;
            goto L58
        }

        private boolean isEndOfStream(MediaCodec.BufferInfo r2) {
            if (EncoderImpl.hasEndOfStreamFlag(r2) == false) goto L5;
        L10:
            return true;
        L5:
            if (this.mReachStopTimeAsEos == true) goto L7;
        L9:
            return false;
        L7:
            if (isEosSignalledAndStopTimeReached(r2) == false) goto L9;
            goto L9
        }

        private boolean isEosSignalledAndStopTimeReached(MediaCodec.BufferInfo r6) {
            EncoderImpl r0 = this.this$0;
            if (r0.mMediaCodecEosSignalled == true) goto L5;
        L7:
            return false;
        L5:
            if (r6.presentationTimeUs <= ((Long) r0.mStartStopTimeRangeUs.getUpper()).longValue()) goto L7;
            return true;
        }

        private /* synthetic */ void lambda$onError$4(MediaCodec.CodecException r3) {
            switch(this.this$0.mState.ordinal()) {
                case 0: goto L8;
                case 1: goto L6;
                case 2: goto L6;
                case 3: goto L6;
                case 4: goto L6;
                case 5: goto L6;
                case 6: goto L6;
                case 7: goto L8;
                case 8: goto L8;
                default: goto L5;
            };
        L6:
            this.this$0.handleEncodeError(r3);
            return;
        L8:
            return;
        L5:
            throw new IllegalStateException("Unknown state: " + this.this$0.mState);
        }

        private /* synthetic */ void lambda$onInputBufferAvailable$0(int r3) {
            if (this.mStopped == false) goto L7;
            Logger.w(this.this$0.mTag, "Receives input frame after codec is reset.");
            return;
        L7:
            switch(this.this$0.mState.ordinal()) {
                case 0: goto L12;
                case 1: goto L10;
                case 2: goto L10;
                case 3: goto L10;
                case 4: goto L10;
                case 5: goto L10;
                case 6: goto L10;
                case 7: goto L12;
                case 8: goto L12;
                default: goto L9;
            };
        L10:
            this.this$0.mFreeInputBufferIndexQueue.offer(Integer.valueOf(r3));
            this.this$0.matchAcquisitionsAndFreeBufferIndexes();
            return;
        L12:
            return;
        L9:
            throw new IllegalStateException("Unknown state: " + this.this$0.mState);
        }

        private /* synthetic */ void lambda$onOutputFormatChanged$7(final MediaFormat r4) {
            if (this.mStopped == false) goto L7;
            Logger.w(this.this$0.mTag, "Receives onOutputFormatChanged after codec is reset.");
            return;
        L7:
            switch(this.this$0.mState.ordinal()) {
                case 0: goto L21;
                case 1: goto L10;
                case 2: goto L10;
                case 3: goto L10;
                case 4: goto L10;
                case 5: goto L10;
                case 6: goto L10;
                case 7: goto L21;
                case 8: goto L21;
                default: goto L9;
            };
        L10:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            EncoderImpl r1 = this.this$0;     // Catch: Throwable -> L18
            final EncoderCallback r2 = r1.mEncoderCallback;     // Catch: Throwable -> L18
            Executor r3 = r1.mEncoderCallbackExecutor;     // Catch: Throwable -> L18
            monitor-exit(r0);     // Catch: Throwable -> L18
            r3.execute(new j0(r2, r4));     // Catch: RejectedExecutionException -> L16
            return;
        L16:
            e = move-exception;
            Logger.e(this.this$0.mTag, "Unable to post to the supplied executor.", e);
            return;
        L18:
            th = move-exception;
            throw th;
        L21:
            return;
        L9:
            throw new IllegalStateException("Unknown state: " + this.this$0.mState);
        }

        private MediaCodec.BufferInfo resolveOutputBufferInfo(MediaCodec.BufferInfo r8) {
            long r4 = this.this$0.getAdjustedTimeUs(r8);
            if (r8.presentationTimeUs != r4) goto L6;
            return r8;
        L6:
            if (r4 <= this.mLastSentAdjustedTimeUs) goto L8;
            boolean r0 = true;
        L9:
            Preconditions.checkState(r0);
            MediaCodec.BufferInfo r1 = new MediaCodec.BufferInfo();
            r1.set(r8.offset, r8.size, r4, r8.flags);
            return r1;
        L8:
            r0 = false;
            goto L9
        }

        private boolean updatePauseRangeStateAndCheckIfBufferPaused(MediaCodec.BufferInfo r7) {
            this.this$0.updateTotalPausedDuration(r7.presentationTimeUs);
            boolean r0 = this.this$0.isInPauseRange(r7.presentationTimeUs);
            boolean r1 = this.mIsOutputBufferInPauseState;
            if (r1 == true) goto L34;
            if (r0 == false) goto L34;
            Logger.d(this.this$0.mTag, "Switch to pause state");
            this.mIsOutputBufferInPauseState = true;
            Object r4 = this.this$0.mLock;
            monitor-enter(r4);
            EncoderImpl r2 = this.this$0;     // Catch: Throwable -> L31
            Executor r3 = r2.mEncoderCallbackExecutor;     // Catch: Throwable -> L31
            final EncoderCallback r5 = r2.mEncoderCallback;     // Catch: Throwable -> L31
            monitor-exit(r4);     // Catch: Throwable -> L31
            Objects.requireNonNull(r5);
            r3.execute(new e0(r5));
            EncoderImpl r6 = this.this$0;
            if (r6.mState == InternalState.PAUSED) goto L12;
        L25:
            EncoderImpl r8 = this.this$0;
            r8.mLastDataStopTimestamp = Long.valueOf(r7.presentationTimeUs);
            EncoderImpl r9 = this.this$0;
            if (r9.mPendingCodecStop == false) goto L42;
            Future<?> r10 = r9.mStopTimeoutFuture;
            if (r10 == null) goto L30;
            r10.cancel(true);
        L30:
            this.this$0.signalCodecStop();
            this.this$0.mPendingCodecStop = false;
        L42:
            return this.mIsOutputBufferInPauseState;
        L12:
            if (r6.mIsVideoEncoder == true) goto L17;
            if (DeviceQuirks.get(AudioEncoderIgnoresInputTimestampQuirk.class) != null) goto L25;
        L17:
            if (this.this$0.mIsVideoEncoder == true) goto L19;
        L21:
            Encoder.EncoderInput r11 = this.this$0.mEncoderInput;
            if ((r11 instanceof ByteBufferInput) == false) goto L24;
            ((ByteBufferInput) r11).setActive(false);
        L24:
            this.this$0.setMediaCodecPaused(true);
            goto L25
        L19:
            if (DeviceQuirks.get(VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk.class) == null) goto L21;
        L31:
            th = move-exception;
            throw th;
        L34:
            if (r1 == false) goto L42;
            if (r0 == true) goto L42;
            Logger.d(this.this$0.mTag, "Switch to resume state");
            this.mIsOutputBufferInPauseState = false;
            if (this.this$0.mIsVideoEncoder == false) goto L42;
            if (EncoderImpl.isKeyFrame(r7) == true) goto L42;
            this.mIsKeyFrameRequired = true;
            goto L42
        }

        private static /* synthetic */ void lambda$onOutputFormatChanged$6(EncoderCallback r1, final MediaFormat r2) {
            r1.onOutputConfigUpdate(new k0(r2));
        }

        private /* synthetic */ void lambda$reachEndData$2(Executor r3, final EncoderCallback r4) {
            if (this.this$0.mState != InternalState.ERROR) goto L10;
            return;
        L10:
            Objects.requireNonNull(r4);     // Catch: RejectedExecutionException -> L7
            r3.execute(new i0(r4));     // Catch: RejectedExecutionException -> L7
            return;
        L7:
            e = move-exception;
            Logger.e(this.this$0.mTag, "Unable to post to the supplied executor.", e);
        }

        private static /* synthetic */ void lambda$sendEncodedData$3(EncoderCallback r0, EncodedDataImpl r1) {
            r0.onEncodedData(r1);
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(MediaCodec r2, final MediaCodec.CodecException r3) {
            this.this$0.mEncoderExecutor.execute(new h0(this, r3));
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(MediaCodec r2, final int r3) {
            this.this$0.mEncoderExecutor.execute(new m0(this, r3));
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(MediaCodec r2, final MediaFormat r3) {
            this.this$0.mEncoderExecutor.execute(new f0(this, r3));
        }

        private /* synthetic */ void lambda$onOutputBufferAvailable$1(MediaCodec.BufferInfo r7, MediaCodec r8, int r9) {
            if (this.mStopped == false) goto L7;
            Logger.w(this.this$0.mTag, "Receives frame after codec is reset.");
            return;
        L7:
            switch(this.this$0.mState.ordinal()) {
                case 0: goto L44;
                case 1: goto L10;
                case 2: goto L10;
                case 3: goto L10;
                case 4: goto L10;
                case 5: goto L10;
                case 6: goto L10;
                case 7: goto L44;
                case 8: goto L44;
                default: goto L9;
            };
        L10:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            EncoderImpl r1 = this.this$0;     // Catch: Throwable -> L41
            final EncoderCallback r2 = r1.mEncoderCallback;     // Catch: Throwable -> L41
            Executor r3 = r1.mEncoderCallbackExecutor;     // Catch: Throwable -> L41
            monitor-exit(r0);     // Catch: Throwable -> L41
            if (this.mHasSendStartCallback == true) goto L22;
            this.mHasSendStartCallback = true;
            Objects.requireNonNull(r2);     // Catch: RejectedExecutionException -> L19
            r3.execute(new o0(r2));     // Catch: RejectedExecutionException -> L19
        L19:
            e = move-exception;
            Logger.e(this.this$0.mTag, "Unable to post to the supplied executor.", e);
        L22:
            if (checkBufferInfo(r7) == true) goto L24;
            this.this$0.mMediaCodec.releaseOutputBuffer(r9, false);     // Catch: MediaCodec.CodecException -> L38
        L34:
            if (this.mHasEndData == false) goto L36;
            return;
        L36:
            if (isEndOfStream(r7) == false) goto L54;
            reachEndData();
            return;
        L54:
            return;
        L38:
            e = move-exception;
            this.this$0.handleEncodeError(e);
            return;
        L24:
            if (this.mHasFirstData == true) goto L26;
            this.mHasFirstData = true;
            Logger.d(this.this$0.mTag, "data timestampUs = " + r7.presentationTimeUs + ", data timebase = " + this.this$0.mInputTimebase + ", current system uptimeMs = " + SystemClock.uptimeMillis() + ", current system realtimeMs = " + SystemClock.elapsedRealtime());
        L26:
            MediaCodec.BufferInfo r4 = resolveOutputBufferInfo(r7);
            this.mLastSentAdjustedTimeUs = r4.presentationTimeUs;
            sendEncodedData(new EncodedDataImpl(r8, r9, r4), r2, r3);     // Catch: MediaCodec.CodecException -> L29
        L29:
            e = move-exception;
            this.this$0.handleEncodeError(e);
            return;
        L41:
            th = move-exception;
            throw th;
        L44:
            return;
        L9:
            throw new IllegalStateException("Unknown state: " + this.this$0.mState);
        }

        private void sendEncodedData(final EncodedDataImpl r4, final EncoderCallback r5, Executor r6) {
            this.this$0.mEncodedDataSet.add(r4);
            Futures.addCallback(r4.getClosedFuture(), new AnonymousClass1(this, r4), this.this$0.mEncoderExecutor);
            r6.execute(new n0(r5, r4));     // Catch: RejectedExecutionException -> L5
            return;
        L5:
            e = move-exception;
            Logger.e(this.this$0.mTag, "Unable to post to the supplied executor.", e);
            r4.close();
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(final MediaCodec r3, final int r4, final MediaCodec.BufferInfo r5) {
            this.this$0.mEncoderExecutor.execute(new l0(this, r5, r3, r4));
        }
    }

    public class SurfaceInput implements Encoder.SurfaceInput {
        private final Object mLock;
        private final Set<Surface> mObsoleteSurfaces;
        private Surface mSurface;
        private Executor mSurfaceUpdateExecutor;
        private Encoder.SurfaceInput.OnSurfaceUpdateListener mSurfaceUpdateListener;
        final /* synthetic */ EncoderImpl this$0;

        public static /* synthetic */ void a(Encoder.SurfaceInput.OnSurfaceUpdateListener r0, Surface r1) {
            lambda$notifySurfaceUpdate$0(r0, r1);
        }

        public void releaseSurface() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            Surface r1 = this.mSurface;     // Catch: Throwable -> L13
            this.mSurface = null;     // Catch: Throwable -> L13
            HashSet r2 = new HashSet(this.mObsoleteSurfaces);     // Catch: Throwable -> L13
            this.mObsoleteSurfaces.clear();     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            if (r1 == null) goto L8;
            r1.release();
        L8:
            Iterator r3 = r2.iterator();
        L10:
            if (r3.hasNext() == false) goto L12;
            ((Surface) r3.next()).release();
            goto L10
        L12:
            return;
        L13:
            th = move-exception;
            throw th;
        }

        public void resetSurface() {
            EncoderNotUsePersistentInputSurfaceQuirk r0 = (EncoderNotUsePersistentInputSurfaceQuirk) DeviceQuirks.get(EncoderNotUsePersistentInputSurfaceQuirk.class);
            Object r1 = this.mLock;
            monitor-enter(r1);
            if (r0 == null) goto L6;
            Surface r2 = this.mSurface;     // Catch: Throwable -> L21
            if (r2 == null) goto L13;
            this.mObsoleteSurfaces.add(r2);     // Catch: Throwable -> L21
        L13:
            Surface r3 = this.this$0.mMediaCodec.createInputSurface();     // Catch: Throwable -> L21
            this.mSurface = r3;     // Catch: Throwable -> L21
        L14:
            Encoder.SurfaceInput.OnSurfaceUpdateListener r4 = this.mSurfaceUpdateListener;     // Catch: Throwable -> L21
            Executor r5 = this.mSurfaceUpdateExecutor;     // Catch: Throwable -> L21
            monitor-exit(r1);     // Catch: Throwable -> L21
            if (r3 == null) goto L26;
            if (r4 == null) goto L27;
            if (r5 == null) goto L28;
            notifySurfaceUpdate(r5, r4, r3);
            return;
        L28:
            return;
        L27:
            return;
        L26:
            return;
        L6:
            if (this.mSurface != null) goto L8;
            r3 = Api23Impl.createPersistentInputSurface();     // Catch: Throwable -> L21
            this.mSurface = r3;     // Catch: Throwable -> L21
        L9:
            Api23Impl.setInputSurface(this.this$0.mMediaCodec, this.mSurface);     // Catch: Throwable -> L21
            goto L14
        L8:
            r3 = null;
        L21:
            th = move-exception;
            throw th;
        }

        public SurfaceInput(EncoderImpl r1) {
            this.this$0 = r1;
            this.mLock = new Object();
            this.mObsoleteSurfaces = new HashSet();
        }

        private static /* synthetic */ void lambda$notifySurfaceUpdate$0(Encoder.SurfaceInput.OnSurfaceUpdateListener r0, Surface r1) {
            r0.onSurfaceUpdate(r1);
        }

        @Override // androidx.camera.video.internal.encoder.Encoder.SurfaceInput
        public void setOnSurfaceUpdateListener(Executor r3, Encoder.SurfaceInput.OnSurfaceUpdateListener r4) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mSurfaceUpdateListener = (Encoder.SurfaceInput.OnSurfaceUpdateListener) Preconditions.checkNotNull(r4);     // Catch: Throwable -> L9
            this.mSurfaceUpdateExecutor = (Executor) Preconditions.checkNotNull(r3);     // Catch: Throwable -> L9
            Surface r1 = this.mSurface;     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            if (r1 == null) goto L14;
            notifySurfaceUpdate(r3, r4, r1);
            return;
        L14:
            return;
        L9:
            th = move-exception;
            throw th;
        }

        private void notifySurfaceUpdate(Executor r2, final Encoder.SurfaceInput.OnSurfaceUpdateListener r3, final Surface r4) {
            r2.execute(new p0(r3, r4));     // Catch: RejectedExecutionException -> L4
            return;
        L4:
            e = move-exception;
            Logger.e(this.this$0.mTag, "Unable to post to the supplied executor.", e);
        }
    }

    public static /* synthetic */ Object a(AtomicReference r0, CallbackToFutureAdapter.Completer r1) {
        return lambda$acquireInputBuffer$13(r0, r1);
    }

    public static /* synthetic */ void b(EncoderImpl r0, long r1, long r3) {
        r0.lambda$stop$4(r1, r3);
    }

    public static /* synthetic */ void c(EncoderImpl r0, long r1) {
        r0.lambda$start$1(r1);
    }

    public static /* synthetic */ void d(EncoderImpl r0) {
        r0.lambda$stop$2();
    }

    public static /* synthetic */ void e(EncoderImpl r0, int r1, String r2, Throwable r3) {
        r0.lambda$handleEncodeError$10(r1, r2, r3);
    }

    public static /* synthetic */ Object f(AtomicReference r0, CallbackToFutureAdapter.Completer r1) {
        return lambda$new$0(r0, r1);
    }

    public static /* synthetic */ void g(EncoderImpl r0, long r1) {
        r0.lambda$pause$5(r1);
    }

    public static /* synthetic */ void h(EncoderImpl r0) {
        r0.lambda$stop$3();
    }

    public static /* synthetic */ void i(EncoderImpl r0, InputBufferImpl r1) {
        r0.lambda$matchAcquisitionsAndFreeBufferIndexes$15(r1);
    }

    public static /* synthetic */ void j(EncoderImpl r0) {
        r0.lambda$release$6();
    }

    public static /* synthetic */ void k(EncoderImpl r0, List r1, Runnable r2) {
        r0.lambda$stopMediaCodec$12(r1, r2);
    }

    public static /* synthetic */ void l(EncoderCallback r0, int r1, String r2, Throwable r3) {
        lambda$notifyError$11(r0, r1, r2, r3);
    }

    private /* synthetic */ void lambda$signalSourceStopped$7() {
        this.mSourceStoppedSignalled = true;
        if (this.mIsFlushedAfterEndOfStream == false) goto L6;
        this.mMediaCodec.stop();
        reset();
        return;
    }

    public static /* synthetic */ void m(EncoderImpl r0) {
        r0.lambda$requestKeyFrame$8();
    }

    public static /* synthetic */ void n(EncoderImpl r0) {
        r0.signalEndOfInputStream();
    }

    public static /* synthetic */ void o(EncoderImpl r0) {
        r0.lambda$signalSourceStopped$7();
    }

    public static /* synthetic */ void p(Executor r0, MediaCodecCallback r1) {
        lambda$addSignalEosTimeoutIfNeeded$9(r0, r1);
    }

    public static /* synthetic */ void q(EncoderImpl r0, CallbackToFutureAdapter.Completer r1) {
        r0.lambda$acquireInputBuffer$14(r1);
    }

    private void addSignalEosTimeoutIfNeeded() {
        if (DeviceQuirks.get(SignalEosOutputBufferNotComeQuirk.class) == null) goto L9;
        final MediaCodecCallback r0 = this.mMediaCodecCallback;
        final Executor r1 = this.mEncoderExecutor;
        Future<?> r2 = this.mSignalEosTimeoutFuture;
        if (r2 == null) goto L7;
        r2.cancel(false);
    L7:
        this.mSignalEosTimeoutFuture = CameraXExecutors.mainThreadExecutor().schedule(new f(r1, r0), 1000, TimeUnit.MILLISECONDS);
        return;
    }

    private boolean hasStopCodecAfterSurfaceRemovalCrashMediaServerQuirk() {
        if (DeviceQuirks.get(StopCodecAfterSurfaceRemovalCrashMediaServerQuirk.class) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ void lambda$release$6() {
        switch(this.mState.ordinal()) {
            case 0: goto L7;
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L9;
            default: goto L5;
        };
    L6:
        setState(InternalState.PENDING_RELEASE);
        return;
    L7:
        releaseInternal();
        return;
    L9:
        return;
    L5:
        throw new IllegalStateException("Unknown state: " + this.mState);
    }

    private /* synthetic */ void lambda$requestKeyFrame$8() {
        int r0 = this.mState.ordinal();
        if (r0 != 1) goto L5;
        requestKeyFrameToMediaCodec();
        return;
    L5:
        if (r0 == 6) goto L10;
        if (r0 == 8) goto L10;
        return;
    L10:
        throw new IllegalStateException("Encoder is released");
    }

    private /* synthetic */ void lambda$stop$2() {
        if (this.mPendingCodecStop == false) goto L6;
        Logger.w(this.mTag, "The data didn't reach the expected timestamp before timeout, stop the codec.");
        this.mLastDataStopTimestamp = null;
        signalCodecStop();
        this.mPendingCodecStop = false;
        return;
    }

    private /* synthetic */ void lambda$stop$3() {
        this.mEncoderExecutor.execute(new r(this));
    }

    private void releaseInternal() {
        if (this.mIsFlushedAfterEndOfStream == false) goto L5;
        this.mMediaCodec.stop();
        this.mIsFlushedAfterEndOfStream = false;
    L5:
        this.mMediaCodec.release();
        Encoder.EncoderInput r0 = this.mEncoderInput;
        if ((r0 instanceof SurfaceInput) == false) goto L8;
        ((SurfaceInput) r0).releaseSurface();
    L8:
        setState(InternalState.RELEASED);
        this.mReleasedCompleter.set(null);
    }

    private void reset() {
        this.mStartStopTimeRangeUs = NO_RANGE;
        this.mTotalPausedDurationUs = 0;
        this.mActivePauseResumeTimeRanges.clear();
        this.mFreeInputBufferIndexQueue.clear();
        Iterator<CallbackToFutureAdapter.Completer<InputBuffer>> r0 = this.mAcquisitionQueue.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setCancelled();
        goto L4
    L6:
        this.mAcquisitionQueue.clear();
        this.mMediaCodec.reset();
        this.mIsFlushedAfterEndOfStream = false;
        this.mSourceStoppedSignalled = false;
        this.mMediaCodecEosSignalled = false;
        this.mPendingCodecStop = false;
        Future<?> r1 = this.mStopTimeoutFuture;
        if (r1 == null) goto L9;
        r1.cancel(true);
        this.mStopTimeoutFuture = null;
    L9:
        Future<?> r2 = this.mSignalEosTimeoutFuture;
        if (r2 == null) goto L12;
        r2.cancel(false);
        this.mSignalEosTimeoutFuture = null;
    L12:
        MediaCodecCallback r3 = this.mMediaCodecCallback;
        if (r3 == null) goto L15;
        r3.stop();
    L15:
        MediaCodecCallback r4 = new MediaCodecCallback(this);
        this.mMediaCodecCallback = r4;
        this.mMediaCodec.setCallback(r4);
        this.mMediaCodec.configure(this.mMediaFormat, null, null, 1);
        Encoder.EncoderInput r5 = this.mEncoderInput;
        if ((r5 instanceof SurfaceInput) == false) goto L20;
        ((SurfaceInput) r5).resetSurface();
        return;
    }

    public ListenableFuture<InputBuffer> acquireInputBuffer() {
        switch(this.mState.ordinal()) {
            case 0: goto L13;
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L10;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L7;
            default: goto L5;
        };
    L10:
        final AtomicReference r0 = new AtomicReference();
        ListenableFuture<InputBuffer> r1 = CallbackToFutureAdapter.getFuture(new p(r0));
        final CallbackToFutureAdapter.Completer<InputBuffer> r2 = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) r0.get());
        this.mAcquisitionQueue.offer(r2);
        r2.addCancellationListener(new q(this, r2), this.mEncoderExecutor);
        matchAcquisitionsAndFreeBufferIndexes();
        return r1;
    L5:
        throw new IllegalStateException("Unknown state: " + this.mState);
    L7:
        return Futures.immediateFailedFuture(new IllegalStateException("Encoder is released."));
    L9:
        return Futures.immediateFailedFuture(new IllegalStateException("Encoder is in error state."));
    L13:
        return Futures.immediateFailedFuture(new IllegalStateException("Encoder is not started yet."));
    }

    public long generatePresentationTimeUs() {
        return this.mTimeProvider.uptimeUs();
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public int getConfiguredBitrate() {
        if (this.mMediaFormat.containsKey("bitrate") == true) goto L7;
        return 0;
    L7:
        return this.mMediaFormat.getInteger("bitrate");
    }

    public void handleStopped() {
        InternalState r0 = this.mState;
        if (r0 != InternalState.PENDING_RELEASE) goto L6;
        releaseInternal();
        return;
    L6:
        if (this.mIsFlushedAfterEndOfStream == true) goto L8;
        reset();
    L8:
        setState(InternalState.CONFIGURED);
        if (r0 != InternalState.PENDING_START) goto L11;
    L12:
        start();
        if (r0 != InternalState.PENDING_START_PAUSED) goto L18;
        pause();
        return;
    L18:
        return;
    L11:
        if (r0 == InternalState.PENDING_START_PAUSED) goto L12;
    }

    public void matchAcquisitionsAndFreeBufferIndexes() {
    L3:
        if (this.mAcquisitionQueue.isEmpty() == true) goto L24;
        if (this.mFreeInputBufferIndexQueue.isEmpty() == true) goto L25;
        CallbackToFutureAdapter.Completer<InputBuffer> r0 = this.mAcquisitionQueue.poll();
        Objects.requireNonNull(r0);
        Integer r1 = this.mFreeInputBufferIndexQueue.poll();
        Objects.requireNonNull(r1);
        int r2 = r1.intValue();
        final InputBufferImpl r3 = new InputBufferImpl(this.mMediaCodec, r2);     // Catch: MediaCodec.CodecException -> L12
        if (r0.set(r3) == true) goto L10;
        r3.cancel();
        goto L3
    L10:
        this.mInputBufferSet.add(r3);
        r3.getTerminationFuture().addListener(new m(this, r3), this.mEncoderExecutor);
    L12:
        e = move-exception;
        handleEncodeError(e);
        return;
    L25:
        return;
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void release() {
        this.mEncoderExecutor.execute(new h(this));
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void requestKeyFrame() {
        this.mEncoderExecutor.execute(new g(this));
    }

    public void requestKeyFrameToMediaCodec() {
        Bundle r0 = new Bundle();
        r0.putInt("request-sync", 0);
        this.mMediaCodec.setParameters(r0);
    }

    public void signalCodecStop() {
        Logger.d(this.mTag, "signalCodecStop");
        Encoder.EncoderInput r0 = this.mEncoderInput;
        if ((r0 instanceof ByteBufferInput) == false) goto L10;
        ((ByteBufferInput) r0).setActive(false);
        ArrayList r1 = new ArrayList();
        Iterator<InputBuffer> r2 = this.mInputBufferSet.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r1.add(r2.next().getTerminationFuture());
        goto L6
    L8:
        Futures.successfulAsList(r1).addListener(new n(this), this.mEncoderExecutor);
        return;
    L10:
        if ((r0 instanceof SurfaceInput) == false) goto L20;
        addSignalEosTimeoutIfNeeded();     // Catch: MediaCodec.CodecException -> L13
        this.mMediaCodec.signalEndOfInputStream();     // Catch: MediaCodec.CodecException -> L13
        this.mMediaCodecEosSignalled = true;     // Catch: MediaCodec.CodecException -> L13
        return;
    L13:
        e = move-exception;
        handleEncodeError(e);
        return;
    }

    public void signalSourceStopped() {
        this.mEncoderExecutor.execute(new s(this));
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void stop() {
        stop(-1);
    }

    private void signalEndOfInputStream() {
        Futures.addCallback(acquireInputBuffer(), new AnonymousClass1(this), this.mEncoderExecutor);
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void pause() {
        final long r0 = generatePresentationTimeUs();
        this.mEncoderExecutor.execute(new c(this, r0));
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void start() {
        final long r0 = generatePresentationTimeUs();
        this.mEncoderExecutor.execute(new d(this, r0));
    }

    static {
        Long r0 = Long.valueOf(NO_LIMIT_LONG);
        NO_RANGE = Range.create(r0, r0);
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public EncoderInfo getEncoderInfo() {
        return this.mEncoderInfo;
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public Encoder.EncoderInput getInput() {
        return this.mEncoderInput;
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public ListenableFuture<Void> getReleasedFuture() {
        return this.mReleasedFuture;
    }

    public static /* synthetic */ MediaFormat access$000(EncoderImpl r0) {
        return r0.mMediaFormat;
    }

    public static /* synthetic */ Future access$100(EncoderImpl r0) {
        return r0.mSignalEosTimeoutFuture;
    }

    public static boolean hasEndOfStreamFlag(MediaCodec.BufferInfo r0) {
        if ((r0.flags & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isKeyFrame(MediaCodec.BufferInfo r1) {
        if ((r1.flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private /* synthetic */ void lambda$acquireInputBuffer$14(CallbackToFutureAdapter.Completer r2) {
        this.mAcquisitionQueue.remove(r2);
    }

    private /* synthetic */ void lambda$matchAcquisitionsAndFreeBufferIndexes$15(InputBufferImpl r2) {
        this.mInputBufferSet.remove(r2);
    }

    private /* synthetic */ void lambda$pause$5(long r4) {
        switch(this.mState.ordinal()) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L11;
            case 3: goto L11;
            case 4: goto L8;
            case 5: goto L11;
            case 6: goto L7;
            case 7: goto L11;
            case 8: goto L7;
            default: goto L5;
        };
    L8:
        setState(InternalState.PENDING_START_PAUSED);
        return;
    L9:
        Logger.d(this.mTag, "Pause on " + DebugUtils.readableUs(r4));
        this.mActivePauseResumeTimeRanges.addLast(Range.create(Long.valueOf(r4), Long.valueOf(NO_LIMIT_LONG)));
        setState(InternalState.PAUSED);
        return;
    L11:
        return;
    L5:
        throw new IllegalStateException("Unknown state: " + this.mState);
    L7:
        throw new IllegalStateException("Encoder is released");
    }

    private /* synthetic */ void lambda$start$1(long r9) {
        switch(this.mState.ordinal()) {
            case 0: goto L32;
            case 1: goto L47;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L47;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L47;
            case 8: goto L7;
            default: goto L5;
        };
    L8:
        setState(InternalState.PENDING_START);
        return;
    L9:
        this.mLastDataStopTimestamp = null;
        Range<Long> r0 = this.mActivePauseResumeTimeRanges.removeLast();
        if (r0 != null) goto L12;
    L14:
        boolean r1 = false;
    L15:
        Preconditions.checkState(r1, "There should be a \"pause\" before \"resume\"");
        long r2 = ((Long) r0.getLower()).longValue();
        this.mActivePauseResumeTimeRanges.addLast(Range.create(Long.valueOf(r2), Long.valueOf(r9)));
        Logger.d(this.mTag, "Resume on " + DebugUtils.readableUs(r9) + "\nPaused duration = " + DebugUtils.readableUs(r9 - r2));
        if (this.mIsVideoEncoder == true) goto L21;
        if (DeviceQuirks.get(AudioEncoderIgnoresInputTimestampQuirk.class) == null) goto L21;
    L29:
        if (this.mIsVideoEncoder == false) goto L31;
        requestKeyFrameToMediaCodec();
    L31:
        setState(InternalState.STARTED);
        return;
    L21:
        if (this.mIsVideoEncoder == true) goto L23;
    L25:
        setMediaCodecPaused(false);
        Encoder.EncoderInput r10 = this.mEncoderInput;
        if ((r10 instanceof ByteBufferInput) == false) goto L29;
        ((ByteBufferInput) r10).setActive(true);
        goto L29
    L23:
        if (DeviceQuirks.get(VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk.class) == null) goto L25;
    L12:
        if (((Long) r0.getUpper()).longValue() != NO_LIMIT_LONG) goto L14;
        r1 = true;
        goto L15
    L32:
        this.mLastDataStopTimestamp = null;
        Logger.d(this.mTag, "Start on " + DebugUtils.readableUs(r9));
    L42:
        e = move-exception;
        handleEncodeError(e);
        return;
    L34:
        if (this.mIsFlushedAfterEndOfStream == false) goto L36;
        reset();     // Catch: MediaCodec.CodecException -> L42
    L36:
        this.mStartStopTimeRangeUs = Range.create(Long.valueOf(r9), Long.valueOf(NO_LIMIT_LONG));     // Catch: MediaCodec.CodecException -> L42
        this.mMediaCodec.start();     // Catch: MediaCodec.CodecException -> L42
        Encoder.EncoderInput r11 = this.mEncoderInput;
        if ((r11 instanceof ByteBufferInput) == false) goto L40;
        ((ByteBufferInput) r11).setActive(true);
    L40:
        setState(InternalState.STARTED);
        return;
    L47:
        return;
    L5:
        throw new IllegalStateException("Unknown state: " + this.mState);
    L7:
        throw new IllegalStateException("Encoder is released");
    }

    private void setState(InternalState r4) {
        if (this.mState != r4) goto L5;
        return;
    L5:
        Logger.d(this.mTag, "Transitioning encoder internal state: " + this.mState + " --> " + r4);
        this.mState = r4;
    }

    public long getAdjustedTimeUs(MediaCodec.BufferInfo r6) {
        long r0 = this.mTotalPausedDurationUs;
        if (r0 <= 0) goto L6;
        return r6.presentationTimeUs - r0;
    L6:
        return r6.presentationTimeUs;
    }

    public void handleEncodeError(MediaCodec.CodecException r3) {
        handleEncodeError(1, r3.getMessage(), r3);
    }

    public boolean isInPauseRange(long r6) {
        Iterator<Range<Long>> r0 = this.mActivePauseResumeTimeRanges.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Range<Long> r1 = r0.next();
        if (r1.contains(Long.valueOf(r6)) == true) goto L7;
        if (r6 >= ((Long) r1.getLower()).longValue()) goto L4;
    L7:
        return true;
    L11:
        return false;
    }

    public void setMediaCodecPaused(boolean r3) {
        Bundle r0 = new Bundle();
        r0.putInt("drop-input-frames", r3 ? 1 : 0);
        this.mMediaCodec.setParameters(r0);
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void stop(final long r9) {
        final long r4 = generatePresentationTimeUs();
        this.mEncoderExecutor.execute(new l(this, r9, r4));
    }

    public void stopMediaCodec(final Runnable r5) {
        Logger.d(this.mTag, "stopMediaCodec");
        final ArrayList r0 = new ArrayList();
        Iterator<EncodedDataImpl> r1 = this.mEncodedDataSet.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(r1.next().getClosedFuture());
        goto L4
    L6:
        Iterator<InputBuffer> r2 = this.mInputBufferSet.iterator();
    L8:
        if (r2.hasNext() == false) goto L11;
        r0.add(r2.next().getTerminationFuture());
        goto L8
    L11:
        if (r0.isEmpty() == true) goto L13;
        Logger.d(this.mTag, "Waiting for resources to return. encoded data = " + this.mEncodedDataSet.size() + ", input buffers = " + this.mInputBufferSet.size());
    L13:
        Futures.successfulAsList(r0).addListener(new o(this, r0, r5), this.mEncoderExecutor);
    }

    public void updateTotalPausedDuration(long r8) {
    L3:
        if (this.mActivePauseResumeTimeRanges.isEmpty() == true) goto L7;
        Range<Long> r0 = this.mActivePauseResumeTimeRanges.getFirst();
        if (r8 <= ((Long) r0.getUpper()).longValue()) goto L10;
        this.mActivePauseResumeTimeRanges.removeFirst();
        this.mTotalPausedDurationUs += ((Long) r0.getUpper()).longValue() - ((Long) r0.getLower()).longValue();
        Logger.d(this.mTag, "Total paused duration = " + DebugUtils.readableUs(this.mTotalPausedDurationUs));
        goto L3
    L10:
        return;
    }

    public EncoderImpl(Executor r5, EncoderConfig r6) throws InvalidConfigException {
        this.mLock = new Object();
        this.mFreeInputBufferIndexQueue = new ArrayDeque();
        this.mAcquisitionQueue = new ArrayDeque();
        this.mInputBufferSet = new HashSet();
        this.mEncodedDataSet = new HashSet();
        this.mActivePauseResumeTimeRanges = new ArrayDeque();
        this.mTimeProvider = new SystemTimeProvider();
        this.mEncoderCallback = EncoderCallback.EMPTY;
        this.mEncoderCallbackExecutor = CameraXExecutors.directExecutor();
        this.mStartStopTimeRangeUs = NO_RANGE;
        this.mTotalPausedDurationUs = 0;
        this.mPendingCodecStop = false;
        this.mLastDataStopTimestamp = null;
        this.mStopTimeoutFuture = null;
        this.mMediaCodecCallback = null;
        this.mIsFlushedAfterEndOfStream = false;
        this.mSourceStoppedSignalled = false;
        this.mMediaCodecEosSignalled = false;
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r6);
        MediaCodec r1 = CodecUtil.createCodec(r6);
        this.mMediaCodec = r1;
        MediaCodecInfo r2 = r1.getCodecInfo();
        this.mEncoderExecutor = CameraXExecutors.newSequentialExecutor(r5);
        MediaFormat r7 = r6.toMediaFormat();
        this.mMediaFormat = r7;
        Timebase r3 = r6.getInputTimebase();
        this.mInputTimebase = r3;
        if ((r6 instanceof AudioEncoderConfig) == false) goto L6;
        this.mTag = "AudioEncoder";
        this.mIsVideoEncoder = false;
        this.mEncoderInput = new ByteBufferInput(this);
        this.mEncoderInfo = new AudioEncoderInfoImpl(r2, r6.getMimeType());
    L8:
        Logger.d(this.mTag, "mInputTimebase = " + r3);
        Logger.d(this.mTag, "mMediaFormat = " + r7);
        reset();     // Catch: MediaCodec.CodecException -> L12
        final AtomicReference r8 = new AtomicReference();
        this.mReleasedFuture = Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new j(r8)));
        this.mReleasedCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) r8.get());
        setState(InternalState.CONFIGURED);
        return;
    L12:
        e = move-exception;
        throw new InvalidConfigException(e);
    L6:
        if ((r6 instanceof VideoEncoderConfig) == false) goto L16;
        this.mTag = "VideoEncoder";
        this.mIsVideoEncoder = true;
        this.mEncoderInput = new SurfaceInput(this);
        VideoEncoderInfoImpl r0 = new VideoEncoderInfoImpl(r2, r6.getMimeType());
        clampVideoBitrateIfNotSupported(r0, r7);
        this.mEncoderInfo = r0;
        goto L8
    L16:
        throw new InvalidConfigException("Unknown encoder config type");
    }

    public static /* synthetic */ Future access$102(EncoderImpl r0, Future r1) {
        r0.mSignalEosTimeoutFuture = r1;
        return r1;
    }

    private void clampVideoBitrateIfNotSupported(VideoEncoderInfo r4, MediaFormat r5) {
        Preconditions.checkState(this.mIsVideoEncoder);
        if (r5.containsKey("bitrate") == false) goto L8;
        int r1 = r5.getInteger("bitrate");
        int r6 = ((Integer) r4.getSupportedBitrateRange().clamp(Integer.valueOf(r1))).intValue();
        if (r1 == r6) goto L9;
        r5.setInteger("bitrate", r6);
        Logger.d(this.mTag, "updated bitrate from " + r1 + " to " + r6);
        return;
    L9:
        return;
    }

    private static /* synthetic */ Object lambda$acquireInputBuffer$13(AtomicReference r0, CallbackToFutureAdapter.Completer r1) throws Exception {
        r0.set(r1);
        return "acquireInputBuffer";
    }

    private static /* synthetic */ void lambda$addSignalEosTimeoutIfNeeded$9(Executor r1, final MediaCodecCallback r2) {
        Objects.requireNonNull(r2);
        r1.execute(new i(r2));
    }

    private static /* synthetic */ Object lambda$new$0(AtomicReference r0, CallbackToFutureAdapter.Completer r1) throws Exception {
        r0.set(r1);
        return "mReleasedFuture";
    }

    private /* synthetic */ void lambda$stop$4(long r7, long r9) {
        switch(this.mState.ordinal()) {
            case 0: goto L30;
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L30;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L30;
            case 8: goto L7;
            default: goto L5;
        };
    L8:
        setState(InternalState.CONFIGURED);
        return;
    L9:
        InternalState r0 = this.mState;
        setState(InternalState.STOPPING);
        long r1 = ((Long) this.mStartStopTimeRangeUs.getLower()).longValue();
        if (r1 == NO_LIMIT_LONG) goto L29;
        if (r7 != (-1)) goto L15;
    L17:
        r7 = r9;
    L19:
        if (r7 < r1) goto L27;
        this.mStartStopTimeRangeUs = Range.create(Long.valueOf(r1), Long.valueOf(r7));
        Logger.d(this.mTag, "Stop on " + DebugUtils.readableUs(r7));
        if (r0 == InternalState.PAUSED) goto L23;
    L25:
        this.mPendingCodecStop = true;
        this.mStopTimeoutFuture = CameraXExecutors.mainThreadExecutor().schedule(new t(this), 1000, TimeUnit.MILLISECONDS);
        return;
    L23:
        if (this.mLastDataStopTimestamp == null) goto L25;
        signalCodecStop();
        return;
    L27:
        throw new AssertionError("The start time should be before the stop time.");
    L15:
        if (r7 >= r1) goto L19;
        Logger.w(this.mTag, "The expected stop time is less than the start time. Use current time as stop time.");
        goto L17
    L29:
        throw new AssertionError("There should be a \"start\" before \"stop\"");
    L30:
        return;
    L5:
        throw new IllegalStateException("Unknown state: " + this.mState);
    L7:
        throw new IllegalStateException("Encoder is released");
    }

    private /* synthetic */ void lambda$stopMediaCodec$12(List r3, Runnable r4) {
        if (this.mState != InternalState.ERROR) goto L5;
    L15:
        if (r4 == null) goto L17;
        r4.run();
    L17:
        handleStopped();
        return;
    L5:
        if (r3.isEmpty() == true) goto L8;
        Logger.d(this.mTag, "encoded data and input buffers are returned");
    L8:
        if ((this.mEncoderInput instanceof SurfaceInput) == true) goto L10;
    L14:
        this.mMediaCodec.stop();
        goto L15
    L10:
        if (this.mSourceStoppedSignalled == true) goto L14;
        if (hasStopCodecAfterSurfaceRemovalCrashMediaServerQuirk() == true) goto L14;
        this.mMediaCodec.flush();
        this.mIsFlushedAfterEndOfStream = true;
        goto L15
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void setEncoderCallback(EncoderCallback r2, Executor r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mEncoderCallback = r2;     // Catch: Throwable -> L7
        this.mEncoderCallbackExecutor = r3;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$handleEncodeError$10(int r1, String r2, Throwable r3) {
        notifyError(r1, r2, r3);
    }

    public void handleEncodeError(final int r4, final String r5, final Throwable r6) {
        switch(this.mState.ordinal()) {
            case 0: goto L7;
            case 1: goto L6;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L11;
        };
    L5:
        Logger.w(this.mTag, "Get more than one error: " + r5 + "(" + r4 + ")", r6);
        return;
    L6:
        setState(InternalState.ERROR);
        stopMediaCodec(new e(this, r4, r5, r6));
        return;
    L7:
        notifyError(r4, r5, r6);
        reset();
        return;
    }

    public void notifyError(final int r4, final String r5, final Throwable r6) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        final EncoderCallback r1 = this.mEncoderCallback;     // Catch: Throwable -> L11
        Executor r2 = this.mEncoderCallbackExecutor;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        r2.execute(new k(r1, r4, r5, r6));     // Catch: RejectedExecutionException -> L8
        return;
    L8:
        e = move-exception;
        Logger.e(this.mTag, "Unable to post to the supplied executor.", e);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$notifyError$11(EncoderCallback r1, int r2, String r3, Throwable r4) {
        r1.onEncodeError(new EncodeException(r2, r3, r4));
    }
}

package androidx.camera.video.internal.audio;

import android.content.Context;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.AudioStats;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.encoder.InputBuffer;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class AudioSource {
    static final long DEFAULT_START_RETRY_INTERVAL_MS = 3000;
    private static final String TAG = "AudioSource";
    private FutureCallback<InputBuffer> mAcquireBufferCallback;
    long mAmplitudeTimestamp;
    double mAudioAmplitude;
    private final int mAudioFormat;
    public final int mAudioSource;
    AudioSourceCallback mAudioSourceCallback;
    final AudioStream mAudioStream;
    boolean mAudioStreamSilenced;
    BufferProvider<? extends InputBuffer> mBufferProvider;
    BufferProvider.State mBufferProviderState;
    Executor mCallbackExecutor;
    final Executor mExecutor;
    boolean mInSilentStartState;
    boolean mIsSendingAudio;
    private long mLatestFailedStartTimeNs;
    boolean mMuted;
    final AtomicReference<Boolean> mNotifiedSilenceState;
    final AtomicBoolean mNotifiedSuspendState;
    final SilentAudioStream mSilentAudioStream;
    private final long mStartRetryIntervalNs;
    InternalState mState;
    private Observable.Observer<BufferProvider.State> mStateObserver;
    private byte[] mZeroBytes;

    public interface AudioSourceCallback {

        /* JADX INFO: renamed from: androidx.camera.video.internal.audio.AudioSource$AudioSourceCallback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onSuspendStateChanged(AudioSourceCallback r0, boolean r1) {
            }
        }

        void onAmplitudeValue(double r1);

        void onError(Throwable r1);

        void onSilenceStateChanged(boolean r1);

        void onSuspendStateChanged(boolean r1);
    }

    public class AudioStreamCallback implements AudioStream.AudioStreamCallback {
        final /* synthetic */ AudioSource this$0;

        public AudioStreamCallback(AudioSource r1) {
            this.this$0 = r1;
        }

        @Override // androidx.camera.video.internal.audio.AudioStream.AudioStreamCallback
        public void onSilenceStateChanged(boolean r3) {
            AudioSource r0 = this.this$0;
            r0.mAudioStreamSilenced = r3;
            if (r0.mState != InternalState.STARTED) goto L6;
            r0.notifySilenced();
            return;
        }
    }

    public static final enum InternalState extends Enum<InternalState> {
        private static final /* synthetic */ InternalState[] $VALUES = null;
        public static final InternalState CONFIGURED = null;
        public static final InternalState RELEASED = null;
        public static final InternalState STARTED = null;

        private static /* synthetic */ InternalState[] $values() {
            return new InternalState[]{CONFIGURED, STARTED, RELEASED};
        }

        static {
            CONFIGURED = new InternalState("CONFIGURED", 0);
            STARTED = new InternalState("STARTED", 1);
            RELEASED = new InternalState("RELEASED", 2);
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

    public static /* synthetic */ void a(AudioSource r0, AudioSourceCallback r1) {
        r0.lambda$postMaxAmplitude$11(r1);
    }

    public static /* synthetic */ void b(AudioSource r0) {
        r0.lambda$stop$3();
    }

    public static /* synthetic */ Object c(AudioSource r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$release$5(r1);
    }

    public static /* synthetic */ void d(AudioSource r0, CallbackToFutureAdapter.Completer r1) {
        r0.lambda$release$4(r1);
    }

    public static /* synthetic */ void e(AudioSource r0, boolean r1) {
        r0.lambda$start$2(r1);
    }

    public static /* synthetic */ void f(AudioSourceCallback r0, boolean r1) {
        lambda$notifySuspended$10(r0, r1);
    }

    public static /* synthetic */ void g(AudioSourceCallback r0, boolean r1) {
        lambda$notifySilenced$9(r0, r1);
    }

    public static /* synthetic */ void h(AudioSource r0, BufferProvider r1) {
        r0.lambda$setBufferProvider$0(r1);
    }

    public static /* synthetic */ void i(AudioSource r0) {
        r0.lambda$start$1();
    }

    public static /* synthetic */ void j(AudioSource r0, Executor r1, AudioSourceCallback r2) {
        r0.lambda$setAudioSourceCallback$6(r1, r2);
    }

    public static /* synthetic */ void k(AudioSource r0, boolean r1) {
        r0.lambda$mute$7(r1);
    }

    public static /* synthetic */ void l(AudioSourceCallback r0, Throwable r1) {
        lambda$notifyError$8(r0, r1);
    }

    private /* synthetic */ void lambda$start$1() {
        start(this.mMuted);
    }

    private /* synthetic */ void lambda$stop$3() {
        int r0 = this.mState.ordinal();
        if (r0 != 1) goto L5;
        setState(InternalState.CONFIGURED);
        updateSendingAudio();
        return;
    L5:
        if (r0 != 2) goto L11;
        Logger.w(TAG, "AudioSource is released. Calling stop() is a no-op.");
        return;
    }

    private void startSendingAudio() {
        if (this.mIsSendingAudio == false) goto L12;
        return;
    L12:
        Logger.d(TAG, "startSendingAudio");     // Catch: AudioStream.AudioStreamException -> L8
        this.mAudioStream.start();     // Catch: AudioStream.AudioStreamException -> L8
        this.mInSilentStartState = false;     // Catch: AudioStream.AudioStreamException -> L8
    L10:
        this.mIsSendingAudio = true;
        sendNextAudio();
        return;
    L8:
        e = move-exception;
        Logger.w(TAG, "Failed to start AudioStream", e);
        this.mInSilentStartState = true;
        this.mSilentAudioStream.start();
        this.mLatestFailedStartTimeNs = getCurrentSystemTimeNs();
        notifySilenced();
        goto L10
    }

    private void stopSendingAudio() {
        if (this.mIsSendingAudio == true) goto L5;
        return;
    L5:
        this.mIsSendingAudio = false;
        Logger.d(TAG, "stopSendingAudio");
        this.mAudioStream.stop();
    }

    public AudioStream getCurrentAudioStream() {
        if (this.mInSilentStartState == false) goto L6;
        return this.mSilentAudioStream;
    L6:
        return this.mAudioStream;
    }

    public boolean isStartRetryIntervalReached() {
        if (this.mLatestFailedStartTimeNs <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        if ((getCurrentSystemTimeNs() - this.mLatestFailedStartTimeNs) >= this.mStartRetryIntervalNs) goto L11;
        return false;
    L11:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public void notifySilenced() {
        Executor r0 = this.mCallbackExecutor;
        final AudioSourceCallback r1 = this.mAudioSourceCallback;
        if (r0 == null) goto L18;
        if (r1 != null) goto L6;
        return;
    L6:
        if (this.mMuted == false) goto L8;
    L13:
        final boolean r2 = true;
    L15:
        if (Objects.equals(this.mNotifiedSilenceState.getAndSet(Boolean.valueOf(r2)), Boolean.valueOf(r2)) == true) goto L20;
        r0.execute(new b(r1, r2));
        return;
    L20:
        return;
    L8:
        if (this.mInSilentStartState == true) goto L13;
        if (this.mAudioStreamSilenced == true) goto L13;
        r2 = false;
        goto L15
    }

    public ListenableFuture<Void> release() {
        return CallbackToFutureAdapter.getFuture(new h(this));
    }

    public void retryStartAudioStream() {
        Preconditions.checkState(this.mInSilentStartState);
        this.mAudioStream.start();     // Catch: AudioStream.AudioStreamException -> L5
        Logger.d(TAG, "Retry start AudioStream succeed");     // Catch: AudioStream.AudioStreamException -> L5
        this.mSilentAudioStream.stop();     // Catch: AudioStream.AudioStreamException -> L5
        this.mInSilentStartState = false;     // Catch: AudioStream.AudioStreamException -> L5
        return;
    L5:
        e = move-exception;
        Logger.w(TAG, "Retry start AudioStream failed", e);
        this.mLatestFailedStartTimeNs = getCurrentSystemTimeNs();
    }

    public void sendNextAudio() {
        BufferProvider<? extends InputBuffer> r0 = this.mBufferProvider;
        Objects.requireNonNull(r0);
        ListenableFuture<? extends InputBuffer> r1 = r0.acquireBuffer();
        FutureCallback<InputBuffer> r2 = this.mAcquireBufferCallback;
        Objects.requireNonNull(r2);
        Futures.addCallback(r1, r2, this.mExecutor);
    }

    public void start() {
        this.mExecutor.execute(new f(this));
    }

    public void stop() {
        this.mExecutor.execute(new k(this));
    }

    public void updateSendingAudio() {
        if (this.mState == InternalState.STARTED) goto L5;
        stopSendingAudio();
        return;
    L5:
        if (this.mBufferProviderState != BufferProvider.State.ACTIVE) goto L7;
        boolean r0 = true;
    L8:
        notifySuspended(!r0);
        if (r0 == false) goto L11;
        startSendingAudio();
        return;
    L11:
        stopSendingAudio();
        return;
    L7:
        r0 = false;
        goto L8
    }

    private static long getCurrentSystemTimeNs() {
        return System.nanoTime();
    }

    private static BufferProvider.State fetchBufferProviderState(BufferProvider<? extends InputBuffer> r2) {
        ListenableFuture<? extends InputBuffer> r3 = r2.fetchData();     // Catch: Throwable -> L8
        if (r3.isDone() == false) goto L11;
        return (BufferProvider.State) r3.get();
    L11:
        return null;
    L12:
        return null;
    }

    private /* synthetic */ void lambda$mute$7(boolean r3) {
        int r0 = this.mState.ordinal();
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L12;
        if (r0 == 2) goto L10;
        return;
    L10:
        throw new AssertionError("AudioSource is released");
    L12:
        if (this.mMuted != r3) goto L14;
        return;
    L14:
        this.mMuted = r3;
        if (this.mState != InternalState.STARTED) goto L18;
        notifySilenced();
        return;
    }

    private /* synthetic */ void lambda$postMaxAmplitude$11(AudioSourceCallback r3) {
        r3.onAmplitudeValue(this.mAudioAmplitude);
    }

    private /* synthetic */ void lambda$release$4(CallbackToFutureAdapter.Completer r4) {
        int r0 = this.mState.ordinal();     // Catch: Throwable -> L10
        if (r0 != 0) goto L5;
    L7:
        resetBufferProvider(null);     // Catch: Throwable -> L10
        this.mSilentAudioStream.release();     // Catch: Throwable -> L10
        this.mAudioStream.release();     // Catch: Throwable -> L10
        stopSendingAudio();     // Catch: Throwable -> L10
        setState(InternalState.RELEASED);     // Catch: Throwable -> L10
    L8:
        r4.set(null);     // Catch: Throwable -> L10
        return;
    L5:
        if (r0 == 1) goto L7;
    L10:
        th = move-exception;
        r4.setException(th);
    }

    private /* synthetic */ Object lambda$release$5(final CallbackToFutureAdapter.Completer r3) throws Exception {
        this.mExecutor.execute(new l(this, r3));
        return "AudioSource-release";
    }

    private /* synthetic */ void lambda$setBufferProvider$0(BufferProvider r3) {
        int r0 = this.mState.ordinal();
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L12;
        if (r0 == 2) goto L10;
        return;
    L10:
        throw new AssertionError("AudioSource is released");
    L12:
        if (this.mBufferProvider == r3) goto L15;
        resetBufferProvider(r3);
        return;
    }

    private /* synthetic */ void lambda$start$2(boolean r3) {
        int r0 = this.mState.ordinal();
        if (r0 != 0) goto L5;
        this.mNotifiedSilenceState.set(null);
        this.mNotifiedSuspendState.set(false);
        setState(InternalState.STARTED);
        mute(r3);
        updateSendingAudio();
        return;
    L5:
        if (r0 == 2) goto L8;
        return;
    L8:
        throw new AssertionError("AudioSource is released");
    }

    private void resetBufferProvider(final BufferProvider<? extends InputBuffer> r3) {
        BufferProvider<? extends InputBuffer> r0 = this.mBufferProvider;
        if (r0 == null) goto L5;
        Observable.Observer<BufferProvider.State> r1 = this.mStateObserver;
        Objects.requireNonNull(r1);
        r0.removeObserver(r1);
        this.mBufferProvider = null;
        this.mStateObserver = null;
        this.mAcquireBufferCallback = null;
        this.mBufferProviderState = BufferProvider.State.INACTIVE;
        updateSendingAudio();
    L5:
        if (r3 == null) goto L11;
        this.mBufferProvider = r3;
        this.mStateObserver = new AnonymousClass1(this, r3);
        this.mAcquireBufferCallback = new AnonymousClass2(this, r3);
        BufferProvider.State r4 = fetchBufferProviderState(r3);
        if (r4 == null) goto L9;
        this.mBufferProviderState = r4;
        updateSendingAudio();
    L9:
        this.mBufferProvider.addObserver(this.mExecutor, this.mStateObserver);
        return;
    }

    public void mute(final boolean r3) {
        this.mExecutor.execute(new c(this, r3));
    }

    public void notifyError(final Throwable r4) {
        Executor r0 = this.mCallbackExecutor;
        final AudioSourceCallback r1 = this.mAudioSourceCallback;
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r0.execute(new d(r1, r4));
        return;
    L8:
        return;
    }

    public void notifySuspended(final boolean r4) {
        Executor r0 = this.mCallbackExecutor;
        final AudioSourceCallback r1 = this.mAudioSourceCallback;
        if (r0 == null) goto L9;
        if (r1 != null) goto L6;
        return;
    L6:
        if (this.mNotifiedSuspendState.getAndSet(r4) == r4) goto L11;
        r0.execute(new g(r1, r4));
        return;
    L11:
        return;
    }

    public void postMaxAmplitude(ByteBuffer r7) {
        Executor r0 = this.mCallbackExecutor;
        final AudioSourceCallback r1 = this.mAudioSourceCallback;
        if (this.mAudioFormat != 2) goto L14;
        ShortBuffer r8 = r7.asShortBuffer();
        double r2 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L6:
        if (r8.hasRemaining() == false) goto L8;
        r2 = Math.max(r2, Math.abs(r8.get()));
        goto L6
    L8:
        this.mAudioAmplitude = r2 / 32767.0d;
        if (r0 == null) goto L15;
        if (r1 == null) goto L16;
        r0.execute(new m(this, r1));
        return;
    L16:
        return;
    L15:
        return;
    }

    public void setBufferProvider(final BufferProvider<? extends InputBuffer> r3) {
        this.mExecutor.execute(new a(this, r3));
    }

    public void setState(InternalState r3) {
        Logger.d(TAG, "Transitioning internal state: " + this.mState + " --> " + r3);
        this.mState = r3;
    }

    public void start(final boolean r3) {
        this.mExecutor.execute(new e(this, r3));
    }

    private static /* synthetic */ void lambda$notifyError$8(AudioSourceCallback r0, Throwable r1) {
        r0.onError(r1);
    }

    private static /* synthetic */ void lambda$notifySilenced$9(AudioSourceCallback r0, boolean r1) {
        r0.onSilenceStateChanged(r1);
    }

    private static /* synthetic */ void lambda$notifySuspended$10(AudioSourceCallback r0, boolean r1) {
        r0.onSuspendStateChanged(r1);
    }

    private /* synthetic */ void lambda$setAudioSourceCallback$6(Executor r2, AudioSourceCallback r3) {
        int r0 = this.mState.ordinal();
        if (r0 != 0) goto L5;
        this.mCallbackExecutor = r2;
        this.mAudioSourceCallback = r3;
        return;
    L5:
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L10;
        return;
    L10:
        throw new AssertionError("The audio recording callback must be registered before the audio source is started.");
    }

    public void overrideBySilence(ByteBuffer r4, int r5) {
        byte[] r0 = this.mZeroBytes;
        if (r0 != null) goto L5;
    L6:
        this.mZeroBytes = new byte[r5];
    L7:
        int r1 = r4.position();
        r4.put(this.mZeroBytes, 0, r5);
        r4.limit(r4.position()).position(r1);
        return;
    L5:
        if (r0.length >= r5) goto L7;
        goto L6
    }

    public void setAudioSourceCallback(final Executor r3, final AudioSourceCallback r4) {
        this.mExecutor.execute(new j(this, r3, r4));
    }

    public AudioSource(AudioSettings r8, Executor r9, Context r10) throws AudioSourceAccessException {
        this(r8, r9, r10, new i(), DEFAULT_START_RETRY_INTERVAL_MS);
    }

    public static boolean isSettingsSupported(int r0, int r1, int r2) {
        return AudioStreamImpl.isSettingsSupported(r0, r1, r2);
    }

    public AudioSource(AudioSettings r3, Executor r4, Context r5, AudioStreamFactory r6, long r7) throws AudioSourceAccessException {
        this.mNotifiedSilenceState = new AtomicReference(null);
        this.mNotifiedSuspendState = new AtomicBoolean(false);
        this.mState = InternalState.CONFIGURED;
        this.mBufferProviderState = BufferProvider.State.INACTIVE;
        this.mAmplitudeTimestamp = 0;
        Executor r8 = CameraXExecutors.newSequentialExecutor(r4);
        this.mExecutor = r8;
        this.mStartRetryIntervalNs = TimeUnit.MILLISECONDS.toNanos(r7);
        BufferedAudioStream r9 = new BufferedAudioStream(r6.create(r3, r5), r3);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
        this.mAudioStream = r9;     // Catch: Throwable -> L6 IllegalArgumentException -> L8
        r9.setCallback(new AudioStreamCallback(this), r8);
        this.mSilentAudioStream = new SilentAudioStream(r3);
        this.mAudioFormat = r3.getAudioFormat();
        this.mAudioSource = r3.getAudioSource();
        return;
    L6:
        e = move-exception;
        throw new AudioSourceAccessException("Unable to create AudioStream", e);
    }
}

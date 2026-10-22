package androidx.camera.video.internal.audio;

import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class SilentAudioStream implements AudioStream {
    private static final String TAG = "SilentAudioStream";
    private AudioStream.AudioStreamCallback mAudioStreamCallback;
    private final int mBytesPerFrame;
    private Executor mCallbackExecutor;
    private long mCurrentReadTimeNs;
    private final AtomicBoolean mIsReleased;
    private final AtomicBoolean mIsStarted;
    private final int mSampleRate;
    private byte[] mZeroBytes;

    public static /* synthetic */ void a(AudioStream.AudioStreamCallback r0) {
        lambda$notifySilenced$0(r0);
    }

    private void checkNotReleasedOrThrow() {
        Preconditions.checkState(!this.mIsReleased.get(), "AudioStream has been released.");
    }

    private void checkStartedOrThrow() {
        Preconditions.checkState(this.mIsStarted.get(), "AudioStream has not been started.");
    }

    private void notifySilenced() {
        final AudioStream.AudioStreamCallback r0 = this.mAudioStreamCallback;
        Executor r1 = this.mCallbackExecutor;
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r1.execute(new u(r0));
        return;
    L8:
        return;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void release() {
        this.mIsReleased.getAndSet(true);
    }

    private static long currentSystemTimeNs() {
        return System.nanoTime();
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void start() {
        checkNotReleasedOrThrow();
        if (this.mIsStarted.getAndSet(true) == false) goto L5;
        return;
    L5:
        this.mCurrentReadTimeNs = currentSystemTimeNs();
        notifySilenced();
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void stop() {
        checkNotReleasedOrThrow();
        this.mIsStarted.set(false);
    }

    public SilentAudioStream(AudioSettings r3) {
        this.mIsStarted = new AtomicBoolean(false);
        this.mIsReleased = new AtomicBoolean(false);
        this.mBytesPerFrame = r3.getBytesPerFrame();
        this.mSampleRate = r3.getSampleRate();
    }

    private static void blockUntilSystemTimeReached(long r3) {
        long r4 = r3 - currentSystemTimeNs();
        if (r4 <= 0) goto L11;
        Thread.sleep(TimeUnit.NANOSECONDS.toMillis(r4));     // Catch: InterruptedException -> L6
        return;
    L6:
        e = move-exception;
        Logger.w(TAG, "Ignore interruption", e);
        return;
    }

    private static /* synthetic */ void lambda$notifySilenced$0(AudioStream.AudioStreamCallback r1) {
        r1.onSilenceStateChanged(true);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public AudioStream.PacketInfo read(ByteBuffer r7) {
        checkNotReleasedOrThrow();
        checkStartedOrThrow();
        long r0 = AudioUtils.sizeToFrameCount(r7.remaining(), this.mBytesPerFrame);
        int r3 = (int) AudioUtils.frameCountToSize(r0, this.mBytesPerFrame);
        if (r3 <= 0) goto L5;
        long r4 = this.mCurrentReadTimeNs + AudioUtils.frameCountToDurationNs(r0, this.mSampleRate);
        blockUntilSystemTimeReached(r4);
        writeSilenceToBuffer(r7, r3);
        AudioStream.PacketInfo r8 = AudioStream.PacketInfo.of(r3, this.mCurrentReadTimeNs);
        this.mCurrentReadTimeNs = r4;
        return r8;
    L5:
        return AudioStream.PacketInfo.of(0, this.mCurrentReadTimeNs);
    }

    private void writeSilenceToBuffer(ByteBuffer r4, int r5) {
        if (r5 > r4.remaining()) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        byte[] r1 = this.mZeroBytes;
        if (r1 != null) goto L9;
    L10:
        this.mZeroBytes = new byte[r5];
    L11:
        int r2 = r4.position();
        r4.put(this.mZeroBytes, 0, r5).limit(r5 + r2).position(r2);
        return;
    L9:
        if (r1.length >= r5) goto L11;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void setCallback(AudioStream.AudioStreamCallback r4, Executor r5) {
        boolean r1 = true;
        Preconditions.checkState(!this.mIsStarted.get(), "AudioStream can not be started when setCallback.");
        checkNotReleasedOrThrow();
        if (r4 == null) goto L7;
        if (r5 != null) goto L7;
        r1 = false;
    L7:
        Preconditions.checkArgument(r1, "executor can't be null with non-null callback.");
        this.mAudioStreamCallback = r4;
        this.mCallbackExecutor = r5;
    }
}

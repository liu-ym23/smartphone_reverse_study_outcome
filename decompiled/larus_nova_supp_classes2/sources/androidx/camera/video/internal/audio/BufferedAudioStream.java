package androidx.camera.video.internal.audio;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class BufferedAudioStream implements AudioStream {
    private static final int DATA_WAITING_TIME_MILLIS = 1;
    private static final int DEFAULT_BUFFER_SIZE_IN_FRAME = 1024;
    private static final int DEFAULT_QUEUE_SIZE = 500;
    private static final String TAG = "BufferedAudioStream";
    private AudioData mAudioDataNotFullyRead;
    private final Queue<AudioData> mAudioDataQueue;
    private final AudioStream mAudioStream;
    private int mBufferSize;
    private final int mBytesPerFrame;
    private final AtomicBoolean mIsCollectingAudioData;
    private final AtomicBoolean mIsReleased;
    private final AtomicBoolean mIsStarted;
    private final Object mLock;
    private final Executor mProducerExecutor;
    private final int mQueueMaxSize;
    private final int mSampleRate;

    public static class AudioData {
        private final ByteBuffer mByteBuffer;
        private final int mBytesPerFrame;
        private final int mSampleRate;
        private long mTimestampNs;

        public int getRemainingBufferSizeInBytes() {
            return this.mByteBuffer.remaining();
        }

        public AudioStream.PacketInfo read(ByteBuffer r10) {
            long r0 = this.mTimestampNs;
            int r2 = this.mByteBuffer.position();
            int r3 = r10.position();
            if (this.mByteBuffer.remaining() <= r10.remaining()) goto L5;
            int r4 = r10.remaining();
            this.mTimestampNs += AudioUtils.frameCountToDurationNs(AudioUtils.sizeToFrameCount(r4, this.mBytesPerFrame), this.mSampleRate);
            ByteBuffer r5 = this.mByteBuffer.duplicate();
            r5.position(r2).limit(r2 + r4);
            r10.put(r5).limit(r3 + r4).position(r3);
        L6:
            this.mByteBuffer.position(r2 + r4);
            return AudioStream.PacketInfo.of(r4, r0);
        L5:
            r4 = this.mByteBuffer.remaining();
            r10.put(this.mByteBuffer).limit(r3 + r4).position(r3);
            goto L6
        }

        public AudioData(ByteBuffer r3, AudioStream.PacketInfo r4, int r5, int r6) {
            r3.rewind();
            int r0 = r3.limit() - r3.position();
            if (r0 != r4.getSizeInBytes()) goto L7;
            this.mBytesPerFrame = r5;
            this.mSampleRate = r6;
            this.mByteBuffer = r3;
            this.mTimestampNs = r4.getTimestampNs();
            return;
        L7:
            throw new IllegalStateException("Byte buffer size is not match with packet info: " + r0 + " != " + r4.getSizeInBytes());
        }
    }

    public static /* synthetic */ void a(BufferedAudioStream r0) {
        r0.lambda$start$0();
    }

    public static /* synthetic */ void b(BufferedAudioStream r0, int r1) {
        r0.lambda$updateCollectionBufferSizeAsync$4(r1);
    }

    public static /* synthetic */ void c(BufferedAudioStream r0, AudioStream.AudioStreamCallback r1, Executor r2) {
        r0.lambda$setCallback$3(r1, r2);
    }

    public static /* synthetic */ void d(BufferedAudioStream r0) {
        r0.lambda$stop$1();
    }

    public static /* synthetic */ void e(BufferedAudioStream r0) {
        r0.collectAudioData();
    }

    public static /* synthetic */ void f(BufferedAudioStream r0) {
        r0.lambda$release$2();
    }

    private void checkNotReleasedOrThrow() {
        Preconditions.checkState(!this.mIsReleased.get(), "AudioStream has been released.");
    }

    private void checkStartedOrThrow() {
        Preconditions.checkState(this.mIsStarted.get(), "AudioStream has not been started.");
    }

    private void collectAudioData() {
        if (this.mIsCollectingAudioData.get() == true) goto L5;
        return;
    L5:
        ByteBuffer r0 = ByteBuffer.allocateDirect(this.mBufferSize);
        AudioData r2 = new AudioData(r0, this.mAudioStream.read(r0), this.mBytesPerFrame, this.mSampleRate);
        int r1 = this.mQueueMaxSize;
        Object r3 = this.mLock;
        monitor-enter(r3);
        this.mAudioDataQueue.offer(r2);     // Catch: Throwable -> L16
    L9:
        if (this.mAudioDataQueue.size() <= r1) goto L11;
        this.mAudioDataQueue.poll();     // Catch: Throwable -> L16
        Logger.w(TAG, "Drop audio data due to full of queue.");     // Catch: Throwable -> L16
        goto L9
    L11:
        monitor-exit(r3);     // Catch: Throwable -> L16
        if (this.mIsCollectingAudioData.get() == false) goto L22;
        this.mProducerExecutor.execute(new s(this));
        return;
    L22:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$release$2() {
        this.mIsCollectingAudioData.set(false);
        this.mAudioStream.release();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAudioDataNotFullyRead = null;     // Catch: Throwable -> L8
        this.mAudioDataQueue.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$start$0() {
        this.mAudioStream.start();     // Catch: AudioStream.AudioStreamException -> L4
        startCollectingAudioData();     // Catch: AudioStream.AudioStreamException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private /* synthetic */ void lambda$stop$1() {
        this.mIsCollectingAudioData.set(false);
        this.mAudioStream.stop();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAudioDataNotFullyRead = null;     // Catch: Throwable -> L8
        this.mAudioDataQueue.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void startCollectingAudioData() {
        if (this.mIsCollectingAudioData.getAndSet(true) == false) goto L5;
        return;
    L5:
        collectAudioData();
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void release() {
        if (this.mIsReleased.getAndSet(true) == false) goto L5;
        return;
    L5:
        this.mProducerExecutor.execute(new q(this));
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void start() throws AudioStream.AudioStreamException, IllegalStateException {
        checkNotReleasedOrThrow();
        if (this.mIsStarted.getAndSet(true) == false) goto L5;
        return;
    L5:
        FutureTask r0 = new FutureTask(new r(this), null);
        this.mProducerExecutor.execute(r0);
        r0.get();     // Catch: ExecutionException -> L8 Throwable -> L10
        return;
    L10:
        e = move-exception;
        this.mIsStarted.set(false);
        throw new AudioStream.AudioStreamException(e);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void stop() throws IllegalStateException {
        checkNotReleasedOrThrow();
        if (this.mIsStarted.getAndSet(false) == true) goto L5;
        return;
    L5:
        this.mProducerExecutor.execute(new t(this));
    }

    private /* synthetic */ void lambda$updateCollectionBufferSizeAsync$4(int r1) {
        updateCollectionBufferSize(r1);
    }

    private void updateCollectionBufferSize(int r3) {
        int r0 = this.mBufferSize;
        if (r0 != r3) goto L5;
        return;
    L5:
        int r1 = this.mBytesPerFrame;
        this.mBufferSize = (r3 / r1) * r1;
        Logger.d(TAG, "Update buffer size from " + r0 + " to " + this.mBufferSize);
    }

    private void updateCollectionBufferSizeAsync(final int r3) {
        this.mProducerExecutor.execute(new p(this, r3));
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public AudioStream.PacketInfo read(ByteBuffer r6) {
        checkNotReleasedOrThrow();
        checkStartedOrThrow();
        updateCollectionBufferSizeAsync(r6.remaining());
        AudioStream.PacketInfo r0 = AudioStream.PacketInfo.of(0, 0);
    L3:
        Object r1 = this.mLock;
        monitor-enter(r1);
        AudioData r3 = this.mAudioDataNotFullyRead;     // Catch: Throwable -> L29
        this.mAudioDataNotFullyRead = null;     // Catch: Throwable -> L29
        if (r3 != null) goto L8;
        r3 = this.mAudioDataQueue.poll();     // Catch: Throwable -> L29
    L8:
        if (r3 == null) goto L12;
        r0 = r3.read(r6);     // Catch: Throwable -> L29
        if (r3.getRemainingBufferSizeInBytes() <= 0) goto L12;
        this.mAudioDataNotFullyRead = r3;     // Catch: Throwable -> L29
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L29
        if (r0.getSizeInBytes() <= 0) goto L16;
    L20:
        boolean r2 = false;
    L21:
        if (r2 == false) goto L27;
        Thread.sleep(1);     // Catch: InterruptedException -> L25
    L25:
        e = move-exception;
        Logger.w(TAG, "Interruption while waiting for audio data", e);
    L28:
        return r0;
    L27:
        if (r2 == true) goto L3;
    L16:
        if (this.mIsStarted.get() == false) goto L20;
        if (this.mIsReleased.get() == true) goto L20;
        r2 = true;
    L29:
        th = move-exception;
        throw th;
    }

    public BufferedAudioStream(AudioStream r8, AudioSettings r9) {
        boolean r1 = false;
        this.mIsStarted = new AtomicBoolean(false);
        this.mIsReleased = new AtomicBoolean(false);
        this.mAudioDataQueue = new ConcurrentLinkedQueue();
        this.mProducerExecutor = CameraXExecutors.newSequentialExecutor(CameraXExecutors.audioExecutor());
        this.mLock = new Object();
        this.mAudioDataNotFullyRead = null;
        this.mIsCollectingAudioData = new AtomicBoolean(false);
        this.mAudioStream = r8;
        int r10 = r9.getBytesPerFrame();
        this.mBytesPerFrame = r10;
        int r11 = r9.getSampleRate();
        this.mSampleRate = r11;
        if (r10 <= 0) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "mBytesPerFrame must be greater than 0.");
        if (r11 <= 0) goto L9;
        r1 = true;
    L9:
        Preconditions.checkArgument(r1, "mSampleRate must be greater than 0.");
        this.mQueueMaxSize = DEFAULT_QUEUE_SIZE;
        this.mBufferSize = r10 * DEFAULT_BUFFER_SIZE_IN_FRAME;
        return;
    L5:
        r2 = false;
        goto L6
    }

    private /* synthetic */ void lambda$setCallback$3(AudioStream.AudioStreamCallback r2, Executor r3) {
        this.mAudioStream.setCallback(r2, r3);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void setCallback(final AudioStream.AudioStreamCallback r4, final Executor r5) {
        boolean r1 = true;
        Preconditions.checkState(!this.mIsStarted.get(), "AudioStream can not be started when setCallback.");
        checkNotReleasedOrThrow();
        if (r4 == null) goto L7;
        if (r5 != null) goto L7;
        r1 = false;
    L7:
        Preconditions.checkArgument(r1, "executor can't be null with non-null callback.");
        this.mProducerExecutor.execute(new o(this, r4, r5));
    }
}

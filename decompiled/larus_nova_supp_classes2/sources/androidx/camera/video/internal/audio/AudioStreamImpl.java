package androidx.camera.video.internal.audio;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;
import android.os.Build;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.compat.Api23Impl;
import androidx.camera.video.internal.compat.Api24Impl;
import androidx.camera.video.internal.compat.Api29Impl;
import androidx.camera.video.internal.compat.Api31Impl;
import androidx.camera.video.internal.compat.quirk.AudioTimestampFramePositionIncorrectQuirk;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AudioStreamImpl implements AudioStream {
    private static final long DIFF_LIMIT_FROM_SYSTEM_TIME_NS = 0;
    private static final String TAG = "AudioStreamImpl";
    private AudioRecord mAudioRecord;
    private AudioManager.AudioRecordingCallback mAudioRecordingCallback;
    private AudioStream.AudioStreamCallback mAudioStreamCallback;
    private final int mBufferSize;
    private final int mBytesPerFrame;
    private Executor mCallbackExecutor;
    private final AtomicBoolean mIsReleased;
    private final AtomicBoolean mIsStarted;
    private final AtomicReference<Boolean> mNotifiedSilenceState;
    private final AudioSettings mSettings;
    private boolean mShouldFallbackToSystemTime;
    private long mTotalFramesRead;

    public class AudioRecordingApi29Callback extends AudioManager.AudioRecordingCallback {
        final /* synthetic */ AudioStreamImpl this$0;

        public AudioRecordingApi29Callback(AudioStreamImpl r1) {
            this.this$0 = r1;
        }

        @Override // android.media.AudioManager.AudioRecordingCallback
        public void onRecordingConfigChanged(List<AudioRecordingConfiguration> r4) {
            Iterator<AudioRecordingConfiguration> r5 = r4.iterator();
        L4:
            if (r5.hasNext() == false) goto L12;
            AudioRecordingConfiguration r0 = r5.next();
            if (Api24Impl.getClientAudioSessionId(r0) != AudioStreamImpl.access$000(this.this$0).getAudioSessionId()) goto L4;
            boolean r6 = Api29Impl.isClientSilenced(r0);
            this.this$0.notifySilenced(r6);
            return;
        }
    }

    public static /* synthetic */ void a(AudioStream.AudioStreamCallback r0, boolean r1) {
        lambda$notifySilenced$0(r0, r1);
    }

    static {
        DIFF_LIMIT_FROM_SYSTEM_TIME_NS = TimeUnit.MILLISECONDS.toNanos(500);
    }

    private void checkNotReleasedOrThrow() {
        Preconditions.checkState(!this.mIsReleased.get(), "AudioStream has been released.");
    }

    private void checkStartedOrThrow() {
        Preconditions.checkState(this.mIsStarted.get(), "AudioStream has not been started.");
    }

    private long generatePresentationTimeNs() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L12:
        long r0 = -1;
    L14:
        if (r0 == (-1)) goto L16;
        return r0;
    L16:
        return System.nanoTime();
    L5:
        if (this.mShouldFallbackToSystemTime == true) goto L12;
        AudioTimestamp r1 = new AudioTimestamp();
        if (Api24Impl.getTimestamp(this.mAudioRecord, r1, 0) != 0) goto L11;
        r0 = AudioUtils.computeInterpolatedTimeNs(this.mSettings.getSampleRate(), this.mTotalFramesRead, r1);
        if (Math.abs(r0 - System.nanoTime()) <= DIFF_LIMIT_FROM_SYSTEM_TIME_NS) goto L14;
        this.mShouldFallbackToSystemTime = true;
        goto L12
    L11:
        Logger.w(TAG, "Unable to get audio timestamp");
        goto L12
    }

    private static boolean hasAudioTimestampQuirk() {
        if (DeviceQuirks.get(AudioTimestampFramePositionIncorrectQuirk.class) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void release() {
        if (this.mIsReleased.getAndSet(true) == false) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L10;
        AudioManager.AudioRecordingCallback r0 = this.mAudioRecordingCallback;
        if (r0 == null) goto L10;
        Api29Impl.unregisterAudioRecordingCallback(this.mAudioRecord, r0);
    L10:
        androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_release(this.mAudioRecord);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void start() throws AudioStream.AudioStreamException {
        checkNotReleasedOrThrow();
        boolean r1 = true;
        if (this.mIsStarted.getAndSet(true) == false) goto L6;
        return;
    L6:
        if (hasAudioTimestampQuirk() == false) goto L8;
        checkAudioRecordInitialStateOrReleaseAndThrow(this.mAudioRecord);
    L8:
        INVOKEVIRTUAL_androidx_camera_video_internal_audio_AudioStreamImpl_com_obric_performance_power_monitor_audioin_AudioInLancet_startRecording(this.mAudioRecord);
        boolean r3 = false;
        if (this.mAudioRecord.getRecordingState() != 3) goto L21;
        this.mTotalFramesRead = 0;
        this.mShouldFallbackToSystemTime = false;
        this.mNotifiedSilenceState.set(null);
        if (Build.VERSION.SDK_INT < 29) goto L19;
        AudioRecordingConfiguration r0 = Api29Impl.getActiveRecordingConfiguration(this.mAudioRecord);
        if (r0 != null) goto L15;
    L17:
        r1 = false;
    L18:
        r3 = r1;
        goto L19
    L15:
        if (Api29Impl.isClientSilenced(r0) == false) goto L17;
    L19:
        notifySilenced(r3);
        return;
    L21:
        this.mIsStarted.set(false);
        throw new AudioStream.AudioStreamException("Unable to start AudioRecord with state: " + this.mAudioRecord.getRecordingState());
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void stop() {
        checkNotReleasedOrThrow();
        if (this.mIsStarted.getAndSet(false) == true) goto L5;
        return;
    L5:
        INVOKEVIRTUAL_androidx_camera_video_internal_audio_AudioStreamImpl_com_obric_performance_power_monitor_audioin_AudioInLancet_stop(this.mAudioRecord);
        if (this.mAudioRecord.getRecordingState() == 1) goto L9;
        Logger.w(TAG, "Failed to stop AudioRecord with state: " + this.mAudioRecord.getRecordingState());
    L9:
        if (hasAudioTimestampQuirk() == false) goto L12;
        androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_release(this.mAudioRecord);
        this.mAudioRecord = createAudioRecord(this.mBufferSize, this.mSettings, null);
        return;
    }

    public static void INVOKEVIRTUAL_androidx_camera_video_internal_audio_AudioStreamImpl_com_obric_performance_power_monitor_audioin_AudioInLancet_startRecording(AudioRecord r1) {
        if (fna.g.d() == true) goto L6;
        androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_startRecording(r1);
        return;
    L6:
        androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_startRecording(r1);
        if ((r1 instanceof AudioRecord) == false) goto L10;
        hna.a.b(r1.hashCode());
        return;
    }

    public static void INVOKEVIRTUAL_androidx_camera_video_internal_audio_AudioStreamImpl_com_obric_performance_power_monitor_audioin_AudioInLancet_stop(AudioRecord r1) {
        if (fna.g.d() == true) goto L6;
        androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_stop(r1);
        return;
    L6:
        androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_stop(r1);
        if ((r1 instanceof AudioRecord) == false) goto L10;
        hna.a.c(r1.hashCode());
        return;
    }

    public static /* synthetic */ AudioRecord access$000(AudioStreamImpl r0) {
        return r0.mAudioRecord;
    }

    private static void androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_release(AudioRecord r12) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100403, "android/media/AudioRecord", "release", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100403, "android/media/AudioRecord", "release", r12, r9, null, r10, false);
        return;
    L6:
        r12.release();
        r8.a(100403, "android/media/AudioRecord", "release", r12, r9, null, r10, true);
    }

    private static void androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_startRecording(AudioRecord r12) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100400, "android/media/AudioRecord", "startRecording", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100400, "android/media/AudioRecord", "startRecording", r12, r9, null, r10, false);
        return;
    L6:
        r12.startRecording();
        r8.a(100400, "android/media/AudioRecord", "startRecording", r12, r9, null, r10, true);
    }

    private static void androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_stop(AudioRecord r12) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100401, "android/media/AudioRecord", "stop", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100401, "android/media/AudioRecord", "stop", r12, r9, null, r10, false);
        return;
    L6:
        r12.stop();
        r8.a(100401, "android/media/AudioRecord", "stop", r12, r9, null, r10, true);
    }

    private static void checkAudioRecordInitialStateOrReleaseAndThrow(AudioRecord r2) throws AudioStream.AudioStreamException {
        if (r2.getState() != 1) goto L5;
        return;
    L5:
        androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_release(r2);
        throw new AudioStream.AudioStreamException("Unable to initialize AudioRecord");
    }

    public void notifySilenced(final boolean r5) {
        Executor r0 = this.mCallbackExecutor;
        final AudioStream.AudioStreamCallback r1 = this.mAudioStreamCallback;
        if (r0 == null) goto L9;
        if (r1 != null) goto L6;
        return;
    L6:
        if (Objects.equals(this.mNotifiedSilenceState.getAndSet(Boolean.valueOf(r5)), Boolean.valueOf(r5)) == true) goto L11;
        r0.execute(new n(r1, r5));
        return;
    L11:
        return;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public AudioStream.PacketInfo read(ByteBuffer r8) {
        checkNotReleasedOrThrow();
        checkStartedOrThrow();
        int r0 = this.mAudioRecord.read(r8, this.mBufferSize);
        if (r0 <= 0) goto L5;
        r8.limit(r0);
        long r1 = generatePresentationTimeNs();
        this.mTotalFramesRead += AudioUtils.sizeToFrameCount(r0, this.mBytesPerFrame);
    L7:
        return AudioStream.PacketInfo.of(r0, r1);
    L5:
        r1 = 0;
        goto L7
    }

    public AudioStreamImpl(AudioSettings r7, Context r8) throws IllegalArgumentException, AudioStream.AudioStreamException {
        boolean r1 = false;
        this.mIsReleased = new AtomicBoolean(false);
        this.mIsStarted = new AtomicBoolean(false);
        this.mNotifiedSilenceState = new AtomicReference(null);
        this.mShouldFallbackToSystemTime = false;
        if (isSettingsSupported(r7.getSampleRate(), r7.getChannelCount(), r7.getAudioFormat()) == false) goto L10;
        this.mSettings = r7;
        this.mBytesPerFrame = r7.getBytesPerFrame();
        int r0 = getMinBufferSize(r7.getSampleRate(), r7.getChannelCount(), r7.getAudioFormat());
        if (r0 <= 0) goto L7;
        r1 = true;
    L7:
        Preconditions.checkState(r1);
        int r2 = r0 * 2;
        this.mBufferSize = r2;
        AudioRecord r9 = createAudioRecord(r2, r7, r8);
        this.mAudioRecord = r9;
        checkAudioRecordInitialStateOrReleaseAndThrow(r9);
        return;
    L10:
        throw new UnsupportedOperationException(String.format("The combination of sample rate %d, channel count %d and audio format %d is not supported.", new Object[]{Integer.valueOf(r7.getSampleRate()), Integer.valueOf(r7.getChannelCount()), Integer.valueOf(r7.getAudioFormat())}));
    }

    private static /* synthetic */ void lambda$notifySilenced$0(AudioStream.AudioStreamCallback r0, boolean r1) {
        r0.onSilenceStateChanged(r1);
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
        if (Build.VERSION.SDK_INT < 29) goto L19;
        AudioManager.AudioRecordingCallback r0 = this.mAudioRecordingCallback;
        if (r0 == null) goto L12;
        Api29Impl.unregisterAudioRecordingCallback(this.mAudioRecord, r0);
    L12:
        if (r4 != null) goto L15;
        return;
    L15:
        if (this.mAudioRecordingCallback != null) goto L17;
        this.mAudioRecordingCallback = new AudioRecordingApi29Callback(this);
    L17:
        Api29Impl.registerAudioRecordingCallback(this.mAudioRecord, r5, this.mAudioRecordingCallback);
        return;
    }

    private static AudioRecord createAudioRecord(int r6, AudioSettings r7, Context r8) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L11;
        AudioFormat r1 = new AudioFormat.Builder().setSampleRate(r7.getSampleRate()).setChannelMask(AudioUtils.channelCountToChannelMask(r7.getChannelCount())).setEncoding(r7.getAudioFormat()).build();
        AudioRecord.Builder r2 = Api23Impl.createAudioRecordBuilder();
        if (r0 < 31) goto L8;
        if (r8 == null) goto L8;
        Api31Impl.setContext(r2, r8);
    L8:
        Api23Impl.setAudioSource(r2, r7.getAudioSource());
        Api23Impl.setAudioFormat(r2, r1);
        Api23Impl.setBufferSizeInBytes(r2, r6);
        return Api23Impl.build(r2);
    L11:
        return new AudioRecord(r7.getAudioSource(), r7.getSampleRate(), AudioUtils.channelCountToChannelConfig(r7.getChannelCount()), r7.getAudioFormat(), r6);
    }

    private static int getMinBufferSize(int r0, int r1, int r2) {
        return AudioRecord.getMinBufferSize(r0, AudioUtils.channelCountToChannelConfig(r1), r2);
    }

    public static boolean isSettingsSupported(int r1, int r2, int r3) {
        if (r1 <= 0) goto L10;
        if (r2 > 0) goto L7;
        return false;
    L7:
        if (getMinBufferSize(r1, r2, r3) <= 0) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }
}

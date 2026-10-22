package com.ss.ttm.player;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.ss.ttm.utils.Util;
import java.lang.reflect.Method;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes40.dex */
final class AudioTrackPositionTracker {
    private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200;
    private static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 5000000;
    private static final long MAX_LATENCY_US = 5000000;
    private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    private static final int MIN_LATENCY_SAMPLE_INTERVAL_US = 500000;
    private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    private static final int PLAYSTATE_PAUSED = 2;
    private static final int PLAYSTATE_PLAYING = 3;
    private static final int PLAYSTATE_STOPPED = 1;
    private AudioTimestampPoller audioTimestampPoller;
    private AudioTrack audioTrack;
    private int bufferSize;
    private long bufferSizeUs;
    private long endPlaybackHeadPosition;
    private long forceResetWorkaroundTimeMs;
    private Method getLatencyMethod;
    private boolean hasData;
    private boolean isOutputPcm;
    private long lastLatencySampleTimeUs;
    private long lastPlayheadSampleTimeUs;
    private long lastRawPlaybackHeadPosition;
    private long latencyUs;
    private final Listener listener;
    private boolean needsPassthroughWorkarounds;
    private int nextPlayheadOffsetIndex;
    private int outputPcmFrameSize;
    private int outputSampleRate;
    private long passthroughWorkaroundPauseOffset;
    private int playheadOffsetCount;
    private final long[] playheadOffsets;
    private long rawPlaybackHeadWrapCount;
    private long smoothedPlayheadOffsetUs;
    private long stopPlaybackHeadPosition;
    private long stopTimestampUs;

    public interface Listener {
        void onInvalidLatency(long r100);

        void onPositionFramesMismatch(long r100, long r101, long r102, long r103);

        void onSystemTimeUsMismatch(long r100, long r101, long r102, long r103);

        void onUnderrun(int r100, long r101);
    }

    public static boolean isEncodingLinearPcm(int r100) {
        if (r100 != 3) goto L5;
    L14:
        return true;
    L5:
        if (r100 == 2) goto L14;
        if (r100 == Integer.MIN_VALUE) goto L14;
        if (r100 == 1073741824) goto L14;
        if (r100 == 4) goto L14;
        return false;
    }

    private boolean forceHasPendingData() {
        if (this.needsPassthroughWorkarounds == true) goto L5;
    L9:
        return false;
    L5:
        if (this.audioTrack.getPlayState() != 2) goto L9;
        if (getPlaybackHeadPosition() != 0) goto L9;
        return true;
    }

    private long getPlaybackHeadPosition() {
        AudioTrack r100 = this.audioTrack;
        if (this.stopTimestampUs == (-9223372036854775807L)) goto L7;
        return Math.min(this.endPlaybackHeadPosition, this.stopPlaybackHeadPosition + ((((SystemClock.elapsedRealtime() * 1000) - this.stopTimestampUs) * ((long) this.outputSampleRate)) / 1000000));
    L7:
        if (r100 != null) goto L9;
        return 0;
    L9:
        int r101 = r100.getPlayState();
        if (r101 != 1) goto L12;
        return 0;
    L12:
        long r102 = ((long) r100.getPlaybackHeadPosition()) & BodyPartID.bodyIdMax;
        if (this.needsPassthroughWorkarounds == false) goto L21;
        if (r101 == 2) goto L17;
    L19:
        r102 = r102 + this.passthroughWorkaroundPauseOffset;
        goto L21
    L17:
        if (r102 != 0) goto L19;
        this.passthroughWorkaroundPauseOffset = this.lastRawPlaybackHeadPosition;
    L21:
        if (Util.SDK_INT > 28) goto L35;
        if (r102 == 0) goto L25;
    L33:
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        goto L35
    L25:
        if (this.lastRawPlaybackHeadPosition <= 0) goto L33;
        if (r101 != 3) goto L33;
        if (this.forceResetWorkaroundTimeMs != (-9223372036854775807L)) goto L32;
        this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
    L32:
        return this.lastRawPlaybackHeadPosition;
    L35:
        if (this.lastRawPlaybackHeadPosition <= r102) goto L37;
        this.rawPlaybackHeadWrapCount++;
    L37:
        this.lastRawPlaybackHeadPosition = r102;
        return r102 + (this.rawPlaybackHeadWrapCount << 32);
    }

    private void resetSyncParams() {
        this.smoothedPlayheadOffsetUs = 0;
        this.playheadOffsetCount = 0;
        this.nextPlayheadOffsetIndex = 0;
        this.lastPlayheadSampleTimeUs = 0;
    }

    public boolean isPlaying() {
        if (this.audioTrack.getPlayState() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public void start() {
        this.audioTimestampPoller.reset();
    }

    private long getPlaybackHeadPositionUs() {
        return framesToDurationUs(getPlaybackHeadPosition());
    }

    private void maybeSampleSyncParams() {
        long r100 = getPlaybackHeadPositionUs();
        if (r100 != 0) goto L5;
        return;
    L5:
        long r101 = System.nanoTime() / 1000;
        if ((r101 - this.lastPlayheadSampleTimeUs) < 30000) goto L15;
        long[] r102 = this.playheadOffsets;
        int r103 = this.nextPlayheadOffsetIndex;
        r102[r103] = r100 - r101;
        this.nextPlayheadOffsetIndex = (r103 + 1) % 10;
        int r104 = this.playheadOffsetCount;
        if (r104 >= 10) goto L10;
        this.playheadOffsetCount = r104 + 1;
    L10:
        this.lastPlayheadSampleTimeUs = r101;
        this.smoothedPlayheadOffsetUs = 0;
        int r105 = 0;
    L11:
        int r106 = this.playheadOffsetCount;
        if (r105 >= r106) goto L15;
        this.smoothedPlayheadOffsetUs += this.playheadOffsets[r105] / ((long) r106);
        r105 = r105 + 1;
    L15:
        if (this.needsPassthroughWorkarounds == false) goto L17;
        return;
    L17:
        maybePollAndCheckTimestamp(r101, r100);
        maybeUpdateLatency(r101);
    }

    public boolean pause() {
        resetSyncParams();
        if (this.stopTimestampUs != (-9223372036854775807L)) goto L6;
        this.audioTimestampPoller.reset();
        return true;
    L6:
        return false;
    }

    public void reset() {
        resetSyncParams();
        this.audioTrack = null;
        this.audioTimestampPoller = null;
    }

    public AudioTrackPositionTracker(Listener r100) {
        this.listener = r100;
        if (Util.SDK_INT >= 18) goto L8;
    L5:
        this.playheadOffsets = new long[10];
        return;
    L8:
        this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", null);     // Catch: NoSuchMethodException -> L7
        goto L5
    }

    private long framesToDurationUs(long r100) {
        return (r100 * 1000000) / ((long) this.outputSampleRate);
    }

    private void maybeUpdateLatency(long r100) {
        if (this.isOutputPcm == false) goto L20;
        Method r101 = this.getLatencyMethod;
        if (r101 != null) goto L7;
        return;
    L7:
        if ((r100 - this.lastLatencySampleTimeUs) < 500000) goto L22;
        long r102 = (((long) ((Integer) r101.invoke(this.audioTrack, new Object[0])).intValue()) * 1000) - this.bufferSizeUs;     // Catch: Exception -> L15
        this.latencyUs = r102;     // Catch: Exception -> L15
        long r103 = Math.max(r102, 0);     // Catch: Exception -> L15
        this.latencyUs = r103;     // Catch: Exception -> L15
        if (r103 <= 5000000) goto L16;
        Listener r104 = this.listener;     // Catch: Exception -> L15
        if (r104 == null) goto L13;
        r104.onInvalidLatency(r103);     // Catch: Exception -> L15
    L13:
        this.latencyUs = 0;     // Catch: Exception -> L15
    L16:
        this.lastLatencySampleTimeUs = r100;
        return;
    L15:
        this.getLatencyMethod = null;
        goto L16
    L22:
        return;
    }

    private static boolean needsPassthroughWorkarounds(int r100) {
        if (Util.SDK_INT < 23) goto L5;
    L9:
        return false;
    L5:
        if (r100 != 5) goto L7;
    L8:
        return true;
    L7:
        if (r100 != 6) goto L9;
        goto L8
    }

    public int getAvailableBufferSize(long r100) {
        int r101 = (int) (r100 - (getPlaybackHeadPosition() * ((long) this.outputPcmFrameSize)));
        return this.bufferSize - r101;
    }

    public long getCurrentPositionUs(boolean r100) {
        if (this.audioTrack.getPlayState() != 3) goto L5;
        maybeSampleSyncParams();
    L5:
        long r101 = System.nanoTime() / 1000;
        AudioTimestampPoller r102 = this.audioTimestampPoller;
        if (r102.hasTimestamp() == false) goto L13;
        long r103 = framesToDurationUs(r102.getTimestampPositionFrames());
        if (r102.isTimestampAdvancing() == true) goto L11;
        return r103;
    L11:
        return r103 + (r101 - r102.getTimestampSystemTimeUs());
    L13:
        if (this.playheadOffsetCount != 0) goto L15;
        long r104 = getPlaybackHeadPositionUs();
    L16:
        if (r100 == false) goto L18;
        return r104;
    L18:
        return r104 - this.latencyUs;
    L15:
        r104 = r101 + this.smoothedPlayheadOffsetUs;
        goto L16
    }

    public void handleEndOfStream(long r100) {
        this.stopPlaybackHeadPosition = getPlaybackHeadPosition();
        this.stopTimestampUs = SystemClock.elapsedRealtime() * 1000;
        this.endPlaybackHeadPosition = r100;
    }

    public boolean hasPendingData(long r100) {
        if (r100 <= getPlaybackHeadPosition()) goto L5;
    L8:
        return true;
    L5:
        if (forceHasPendingData() == true) goto L8;
        return false;
    }

    public boolean isStalled(long r100) {
        if (this.forceResetWorkaroundTimeMs != (-9223372036854775807L)) goto L5;
    L9:
        return false;
    L5:
        if (r100 <= 0) goto L9;
        if ((SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs) < 200) goto L9;
        return true;
    }

    public boolean mayHandleBuffer(long r100) {
        int r101 = this.audioTrack.getPlayState();
        if (this.needsPassthroughWorkarounds == true) goto L5;
    L12:
        boolean r102 = this.hasData;
        boolean r103 = hasPendingData(r100);
        this.hasData = r103;
        if (r102 == false) goto L19;
        if (r103 == true) goto L19;
        if (r101 == 1) goto L19;
        Listener r104 = this.listener;
        if (r104 == null) goto L19;
        r104.onUnderrun(this.bufferSize, this.bufferSizeUs / 1000);
    L19:
        return true;
    L5:
        if (r101 != 2) goto L8;
        this.hasData = false;
        return false;
    L8:
        if (r101 != 1) goto L12;
        if (getPlaybackHeadPosition() != 0) goto L12;
        return false;
    }

    private void maybePollAndCheckTimestamp(long r110, long r111) {
        AudioTimestampPoller r100 = this.audioTimestampPoller;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.maybePollTimestamp(r110) == false) goto L24;
        long r101 = r100.getTimestampSystemTimeUs();
        long r102 = r100.getTimestampPositionFrames();
        if (Math.abs(r101 - r110) <= 5000000) goto L14;
        Listener r103 = this.listener;
        if (r103 == null) goto L12;
        r103.onSystemTimeUsMismatch(r102, r101, r110, r111);
    L12:
        r100.rejectTimestamp();
        return;
    L14:
        if (Math.abs(framesToDurationUs(r102) - r111) <= 5000000) goto L19;
        Listener r104 = this.listener;
        if (r104 == null) goto L18;
        r104.onPositionFramesMismatch(r102, r101, r110, r111);
    L18:
        r100.rejectTimestamp();
        return;
    L19:
        r100.acceptTimestamp();
        return;
    }

    public void setAudioTrack(AudioTrack r100, int r101, int r102, int r103) {
        this.audioTrack = r100;
        this.outputPcmFrameSize = r102;
        this.bufferSize = r103;
        this.audioTimestampPoller = new AudioTimestampPoller(r100);
        this.outputSampleRate = r100.getSampleRate();
        this.needsPassthroughWorkarounds = needsPassthroughWorkarounds(r101);
        boolean r104 = isEncodingLinearPcm(r101);
        this.isOutputPcm = r104;
        if (r104 == false) goto L5;
        long r105 = framesToDurationUs(r103 / r102);
    L6:
        this.bufferSizeUs = r105;
        this.lastRawPlaybackHeadPosition = 0;
        this.rawPlaybackHeadWrapCount = 0;
        this.passthroughWorkaroundPauseOffset = 0;
        this.hasData = false;
        this.stopTimestampUs = -9223372036854775807L;
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.latencyUs = 0;
        return;
    L5:
        r105 = -9223372036854775807L;
        goto L6
    }
}

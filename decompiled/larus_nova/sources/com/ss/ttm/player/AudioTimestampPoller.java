package com.ss.ttm.player;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.ss.ttm.utils.Util;

/* JADX INFO: loaded from: classes40.dex */
final class AudioTimestampPoller {
    private static final int ERROR_POLL_INTERVAL_US = 500000;
    private static final int FAST_POLL_INTERVAL_US = 5000;
    private static final int INITIALIZING_DURATION_US = 500000;
    public static final int POSITION_UNSET = -1;
    private static final int SLOW_POLL_INTERVAL_US = 10000000;
    private static final int STATE_ERROR = 4;
    private static final int STATE_INITIALIZING = 0;
    private static final int STATE_NO_TIMESTAMP = 3;
    private static final int STATE_TIMESTAMP = 1;
    private static final int STATE_TIMESTAMP_ADVANCING = 2;
    public static final long TIME_UNSET = -9223372036854775807L;
    private final AudioTimestampV19 audioTimestamp;
    private long initialTimestampPositionFrames;
    private long initializeSystemTimeUs;
    private long lastTimestampSampleTimeUs;
    private long sampleIntervalUs;
    private int state;

    public static final class AudioTimestampV19 {
        private final AudioTimestamp audioTimestamp;
        private final AudioTrack audioTrack;
        private long lastTimestampPositionFrames;
        private long lastTimestampRawPositionFrames;
        private long rawTimestampFramePositionWrapCount;

        public long getTimestampSystemTimeUs() {
            return this.audioTimestamp.nanoTime / 1000;
        }

        public boolean maybeUpdateTimestamp() {
            boolean r100 = this.audioTrack.getTimestamp(this.audioTimestamp);
            if (r100 == false) goto L8;
            long r101 = this.audioTimestamp.framePosition;
            if (this.lastTimestampRawPositionFrames <= r101) goto L7;
            this.rawTimestampFramePositionWrapCount++;
        L7:
            this.lastTimestampRawPositionFrames = r101;
            this.lastTimestampPositionFrames = r101 + (this.rawTimestampFramePositionWrapCount << 32);
        L8:
            return r100;
        }

        public long getTimestampPositionFrames() {
            return this.lastTimestampPositionFrames;
        }

        public AudioTimestampV19(AudioTrack r100) {
            this.audioTrack = r100;
            this.audioTimestamp = new AudioTimestamp();
        }
    }

    public void rejectTimestamp() {
        updateState(4);
    }

    public void acceptTimestamp() {
        if (this.state != 4) goto L6;
        reset();
        return;
    }

    public long getTimestampPositionFrames() {
        AudioTimestampV19 r100 = this.audioTimestamp;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getTimestampPositionFrames();
    }

    public long getTimestampSystemTimeUs() {
        AudioTimestampV19 r100 = this.audioTimestamp;
        if (r100 != null) goto L7;
        return -9223372036854775807L;
    L7:
        return r100.getTimestampSystemTimeUs();
    }

    public boolean hasTimestamp() {
        int r100 = this.state;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean isTimestampAdvancing() {
        if (this.state != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void reset() {
        if (this.audioTimestamp == null) goto L6;
        updateState(0);
        return;
    }

    public AudioTimestampPoller(AudioTrack r100) {
        if (Util.SDK_INT < 19) goto L5;
        this.audioTimestamp = new AudioTimestampV19(r100);
        reset();
        return;
    L5:
        this.audioTimestamp = null;
        updateState(3);
    }

    private void updateState(int r100) {
        this.state = r100;
        if (r100 != 0) goto L5;
        this.lastTimestampSampleTimeUs = 0;
        this.initialTimestampPositionFrames = -1;
        this.initializeSystemTimeUs = System.nanoTime() / 1000;
        this.sampleIntervalUs = 5000;
        return;
    L5:
        if (r100 != 1) goto L7;
        this.sampleIntervalUs = 5000;
        return;
    L7:
        if (r100 != 2) goto L9;
    L15:
        this.sampleIntervalUs = StackLeakChecker.CHECK_INTERVAL_10_SEC;
        return;
    L9:
        if (r100 == 3) goto L15;
        if (r100 != 4) goto L14;
        this.sampleIntervalUs = 500000;
        return;
    L14:
        throw new IllegalStateException();
    }

    public boolean maybePollTimestamp(long r100) {
        AudioTimestampV19 r101 = this.audioTimestamp;
        if (r101 != null) goto L5;
        return false;
    L5:
        if ((r100 - this.lastTimestampSampleTimeUs) < this.sampleIntervalUs) goto L38;
        this.lastTimestampSampleTimeUs = r100;
        boolean r102 = r101.maybeUpdateTimestamp();
        int r103 = this.state;
        if (r103 != 0) goto L10;
        if (r102 == false) goto L32;
        if (this.audioTimestamp.getTimestampSystemTimeUs() < this.initializeSystemTimeUs) goto L37;
        this.initialTimestampPositionFrames = this.audioTimestamp.getTimestampPositionFrames();
        updateState(1);
    L35:
        return r102;
    L37:
        return false;
    L32:
        if ((r100 - this.initializeSystemTimeUs) <= 500000) goto L35;
        updateState(3);
        goto L35
    L10:
        if (r103 == 1) goto L22;
        if (r103 == 2) goto L20;
        if (r103 != 3) goto L14;
        if (r102 == false) goto L35;
        reset();
        goto L35
    L14:
        if (r103 == 4) goto L35;
        throw new IllegalStateException();
    L20:
        if (r102 == true) goto L35;
        reset();
        goto L35
    L22:
        if (r102 == true) goto L24;
        reset();
        goto L35
    L24:
        if (this.audioTimestamp.getTimestampPositionFrames() <= this.initialTimestampPositionFrames) goto L35;
        updateState(2);
        goto L35
    L38:
        return false;
    }
}

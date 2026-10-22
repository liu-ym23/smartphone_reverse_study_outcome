package com.ss.ttm.player;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public abstract class VoiceTrait extends TraitObject {
    public static final int AV_PCM_FMT_DBL = 4;
    public static final int AV_PCM_FMT_DBLP = 9;
    public static final int AV_PCM_FMT_FLT = 3;
    public static final int AV_PCM_FMT_FLTP = 8;
    public static final int AV_PCM_FMT_NONE = -1;
    public static final int AV_PCM_FMT_S16 = 1;
    public static final int AV_PCM_FMT_S16P = 6;
    public static final int AV_PCM_FMT_S32 = 2;
    public static final int AV_PCM_FMT_S32P = 7;
    public static final int AV_PCM_FMT_U8 = 0;
    public static final int AV_PCM_FMT_U8P = 5;
    public static final int Version0 = 0;

    public static class AudioFrameInfo {
        public ByteBuffer[] mBuffers;
        public int mSamples;
        public long mTimestamp;

        public AudioFrameInfo() {
        }
    }

    public static class AudioMediaInfo {
        public int mBytePerSample;
        public int mChannels;
        public int mDuration;
        public int mFormat;
        public int mFrameSampleNB;
        public int mIsPacked;
        public int mSampleRate;

        public AudioMediaInfo(int r100, int r101, int r102, int r103, int r104, int r105, int r106) {
            this.mSampleRate = r100;
            this.mFrameSampleNB = r101;
            this.mBytePerSample = r102;
            this.mChannels = r103;
            this.mFormat = r104;
            this.mIsPacked = r105;
            this.mDuration = r106;
        }
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface Ver {
    }

    public abstract void audioClose();

    public abstract void audioFlush();

    public abstract int audioOpen(AudioMediaInfo r100);

    public abstract void audioPause();

    public abstract void audioResume();

    public abstract int audioWrite(AudioFrameInfo r100);

    public abstract int getLatency();

    public VoiceTrait(int r100) {
        super(1, r100, 0);
    }

    public VoiceTrait(int r100, long r101) {
        super(r100, r101);
    }

    public VoiceTrait(int r100, int r101, long r102) {
        super(r100, r101, r102);
    }
}

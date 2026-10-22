package com.ss.ttm.player;

import android.media.AudioTrack;

/* JADX INFO: loaded from: classes40.dex */
class AudioTrackBuffer {
    AudioTrack AudioTrack;
    int audioFormat;
    int channelsLayout;
    int frameSamples;
    long mFreeTimePoint;
    int sampleRate;
    int streamType;
    int usedCount;

    public void resetFreeTimePoint() {
        this.mFreeTimePoint = System.currentTimeMillis();
    }

    public AudioTrackBuffer(AudioTrack r100, int r101, int r102, int r103, int r104, int r105, int r106) {
        this.AudioTrack = r100;
        this.streamType = r101;
        this.sampleRate = r102;
        this.channelsLayout = r103;
        this.audioFormat = r104;
        this.frameSamples = r105;
        this.usedCount = r106;
    }
}

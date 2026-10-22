package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class MediaPlayerConfig {
    public boolean autoPlay;
    public long callbackOnProgressInterval;
    public int playCount;
    public int startPos;
    public boolean syncProgressToRecordFrame;
    public AudioMixingType type;

    public String toString() {
        return "MediaPlayerConfig{type='" + this.type + "', playCount='" + this.playCount + "', startPos='" + this.startPos + "', autoPlay='" + this.autoPlay + "', syncProgressToRecordFrame='" + this.syncProgressToRecordFrame + "', callbackOnProgressInterval='" + this.callbackOnProgressInterval + "'}";
    }

    public MediaPlayerConfig() {
        this.type = AudioMixingType.AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH;
        this.playCount = 1;
        this.startPos = 0;
        this.callbackOnProgressInterval = 0;
        this.syncProgressToRecordFrame = false;
        this.autoPlay = true;
    }

    public MediaPlayerConfig(AudioMixingType r100, int r110) {
        this(r100, r110, 0, true, 0, false);
    }

    public MediaPlayerConfig(AudioMixingType r100, int r101, int r102, boolean r103, long r104, boolean r105) {
        AudioMixingType r106 = AudioMixingType.AUDIO_MIXING_TYPE_PLAYOUT;
        this.type = r100;
        this.playCount = r101;
        this.startPos = r102;
        this.autoPlay = r103;
        this.syncProgressToRecordFrame = r105;
        this.callbackOnProgressInterval = r104;
    }
}

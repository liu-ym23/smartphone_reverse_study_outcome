package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class InternalLocalStreamStats {
    public InternalLocalAudioStats audioStats;
    public boolean isScreen;
    public int rxQuality;
    public int txQuality;
    public InternalLocalVideoStats videoStats;

    public InternalLocalStreamStats() {
    }

    public InternalLocalStreamStats(InternalLocalAudioStats r100, InternalLocalVideoStats r101, boolean r102, int r103, int r104) {
        this.audioStats = r100;
        this.videoStats = r101;
        this.isScreen = r102;
        this.txQuality = r103;
        this.rxQuality = r104;
    }

    public static InternalLocalStreamStats create(InternalLocalAudioStats r100, InternalLocalVideoStats r101, boolean r102, int r110, int r111) {
        return new InternalLocalStreamStats(r100, r101, r102, r110, r111);
    }
}

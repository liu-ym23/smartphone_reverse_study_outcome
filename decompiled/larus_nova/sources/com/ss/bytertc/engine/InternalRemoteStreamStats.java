package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class InternalRemoteStreamStats {
    public InternalRemoteAudioStats audioStats;
    public boolean isScreen;
    public int rxQuality;
    public int txQuality;
    public String uid;
    public InternalRemoteVideoStats videoStats;

    public InternalRemoteStreamStats() {
    }

    public InternalRemoteStreamStats(String r100, InternalRemoteAudioStats r101, InternalRemoteVideoStats r102, boolean r103, int r104, int r105) {
        this.uid = r100;
        this.audioStats = r101;
        this.videoStats = r102;
        this.isScreen = r103;
        this.txQuality = r104;
        this.rxQuality = r105;
    }

    public static InternalRemoteStreamStats create(String r100, InternalRemoteAudioStats r101, InternalRemoteVideoStats r110, boolean r111, int r112, int r113) {
        return new InternalRemoteStreamStats(r100, r101, r110, r111, r112, r113);
    }
}

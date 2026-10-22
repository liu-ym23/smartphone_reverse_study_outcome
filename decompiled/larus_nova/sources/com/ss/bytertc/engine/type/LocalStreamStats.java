package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalLocalStreamStats;

/* JADX INFO: loaded from: classes40.dex */
public class LocalStreamStats {
    public LocalAudioStats audioStats;
    public boolean isScreen;
    public int rxQuality;
    public int txQuality;
    public LocalVideoStats videoStats;

    public LocalStreamStats() {
    }

    public String toString() {
        return "LocalStreamStats{audioStats=" + this.audioStats + ", videoStats=" + this.videoStats + ", isScreen=" + this.isScreen + ", txQuality=" + this.txQuality + ", rxQuality=" + this.rxQuality + '}';
    }

    public LocalStreamStats(InternalLocalStreamStats r100) {
        LocalAudioStats r101 = new LocalAudioStats(r100.audioStats);
        LocalVideoStats r102 = new LocalVideoStats(r100.videoStats);
        this.audioStats = r101;
        this.videoStats = r102;
        this.isScreen = r100.isScreen;
        this.txQuality = r100.txQuality;
        this.rxQuality = r100.rxQuality;
    }
}

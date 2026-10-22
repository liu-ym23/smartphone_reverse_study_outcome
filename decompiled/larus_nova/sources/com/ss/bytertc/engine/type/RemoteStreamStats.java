package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalRemoteStreamStats;

/* JADX INFO: loaded from: classes40.dex */
public class RemoteStreamStats {
    public RemoteAudioStats audioStats;
    public boolean isScreen;
    public int rxQuality;
    public int txQuality;
    public String uid;
    public RemoteVideoStats videoStats;

    public RemoteStreamStats() {
    }

    public String toString() {
        return "RemoteStreamStats{uid='" + this.uid + "', audioStats=" + this.audioStats + ", videoStats=" + this.videoStats + ", isScreen=" + this.isScreen + ", txQuality=" + this.txQuality + ", rxQuality=" + this.rxQuality + '}';
    }

    public RemoteStreamStats(InternalRemoteStreamStats r100) {
        RemoteAudioStats r101 = new RemoteAudioStats(r100.audioStats);
        RemoteVideoStats r102 = new RemoteVideoStats(r100.videoStats);
        this.audioStats = r101;
        this.videoStats = r102;
        this.uid = r100.uid;
        this.isScreen = r100.isScreen;
        this.rxQuality = r100.rxQuality;
        this.txQuality = r100.txQuality;
    }
}

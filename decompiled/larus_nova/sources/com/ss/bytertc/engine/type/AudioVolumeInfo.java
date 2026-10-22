package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalAudioVolumeInfo;

/* JADX INFO: loaded from: classes40.dex */
public class AudioVolumeInfo {
    public int linearVolume;
    public int nonlinearVolume;
    public String uid;

    public String toString() {
        return "AudioVolumeInfo{ user_id= '" + this.uid + "' linear_volume= '" + this.linearVolume + "' nonlinear_volume= '" + this.nonlinearVolume + "'}";
    }

    public AudioVolumeInfo(InternalAudioVolumeInfo r100) {
        this.uid = r100.uid;
        this.nonlinearVolume = r100.nonlinearVolume;
        this.linearVolume = r100.linearVolume;
    }

    public AudioVolumeInfo(String r100, int r101, int r102) {
        this.uid = r100;
        this.nonlinearVolume = r101;
        this.linearVolume = r102;
    }
}

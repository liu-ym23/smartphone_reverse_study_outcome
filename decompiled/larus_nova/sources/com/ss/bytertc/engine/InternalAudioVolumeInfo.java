package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class InternalAudioVolumeInfo {
    public int linearVolume;
    public int nonlinearVolume;
    public int smoothVolume;
    public String uid;

    public InternalAudioVolumeInfo(String r100, int r101, int r102) {
        this.uid = r100;
        this.linearVolume = r101;
        this.nonlinearVolume = r102;
    }

    private static InternalAudioVolumeInfo create(String r100, int r101, int r102) {
        return new InternalAudioVolumeInfo(r100, r101, r102);
    }
}

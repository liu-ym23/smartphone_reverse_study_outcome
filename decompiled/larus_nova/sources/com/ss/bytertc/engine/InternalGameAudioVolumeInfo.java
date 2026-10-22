package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class InternalGameAudioVolumeInfo {
    public String userId;
    public int volume;

    public InternalGameAudioVolumeInfo(String r100, int r101) {
        this.userId = r100;
        this.volume = r101;
    }

    private static InternalGameAudioVolumeInfo create(String r100, int r101) {
        return new InternalGameAudioVolumeInfo(r100, r101);
    }
}

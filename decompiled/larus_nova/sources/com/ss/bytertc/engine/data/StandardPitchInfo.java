package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class StandardPitchInfo {
    public int duration;
    public int pitch;
    public int startTime;

    public StandardPitchInfo(int r100, int r101, int r102) {
        this.startTime = r100;
        this.duration = r101;
        this.pitch = r102;
    }

    private static StandardPitchInfo create(int r100, int r101, int r102) {
        return new StandardPitchInfo(r100, r101, r102);
    }
}

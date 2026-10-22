package com.ss.bytertc.engine.live;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes40.dex */
public class SourceCrop {
    public double heightProportion;
    public double locationX;
    public double locationY;
    public double widthProportion;

    public SourceCrop() {
        this.locationX = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.locationY = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.widthProportion = 1.0d;
        this.heightProportion = 1.0d;
    }
}

package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class SingScoringConfig {
    public String lyricsFilepath;
    public String midiFilepath;
    public MulDimSingScoringMode mode;
    public AudioSampleRate sampleRate;

    public SingScoringConfig(AudioSampleRate r100, MulDimSingScoringMode r101, String r102, String r103) {
        this.sampleRate = r100;
        this.mode = r101;
        this.lyricsFilepath = r102;
        this.midiFilepath = r103;
    }
}

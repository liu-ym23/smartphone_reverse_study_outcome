package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class SimilaritySingScoringConfig {
    public int calculateIntervalMs;
    public SimilaritySingScoringMode mode;
    public RemoteStreamKey refStream;

    public SimilaritySingScoringConfig() {
        this.mode = SimilaritySingScoringMode.SING_SCORING_MODE_SPECTRAL_SIMILARITY;
        this.calculateIntervalMs = 10000;
        this.refStream = null;
    }

    public SimilaritySingScoringConfig(int r100, SimilaritySingScoringMode r101, RemoteStreamKey r102) {
        SimilaritySingScoringMode r103 = SimilaritySingScoringMode.SING_SCORING_MODE_SPECTRAL_SIMILARITY;
        this.calculateIntervalMs = r100;
        this.mode = r101;
        this.refStream = r102;
    }
}

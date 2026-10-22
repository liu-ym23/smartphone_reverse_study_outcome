package com.ss.bytertc.engine.audio;

import com.ss.bytertc.engine.data.SimilaritySingScoringConfig;

/* JADX INFO: loaded from: classes40.dex */
public abstract class ISimilaritySingScoringManager {
    public ISimilaritySingScoringManager() {
    }

    public abstract int getAverageScore();

    public abstract int getLastScore();

    public abstract int getTotalScore();

    public abstract int startSingScoring(SimilaritySingScoringConfig r100);

    public abstract int stopSingScoring();
}

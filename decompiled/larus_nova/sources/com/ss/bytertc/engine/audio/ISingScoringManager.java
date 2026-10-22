package com.ss.bytertc.engine.audio;

import com.ss.bytertc.engine.ISingScoringEventHandler;
import com.ss.bytertc.engine.data.SingScoringConfig;
import com.ss.bytertc.engine.data.StandardPitchInfo;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public abstract class ISingScoringManager {
    public ISingScoringManager() {
    }

    public abstract int getAverageScore();

    public abstract int getLastSentenceScore();

    public abstract List<StandardPitchInfo> getStandardPitchInfo(String r100);

    public abstract int getTotalScore();

    public abstract int initSingScoring(String r100, String r101, ISingScoringEventHandler r102);

    public abstract int setSingScoringConfig(SingScoringConfig r100);

    public abstract int startSingScoring(int r100, int r101);

    public abstract int stopSingScoring();
}

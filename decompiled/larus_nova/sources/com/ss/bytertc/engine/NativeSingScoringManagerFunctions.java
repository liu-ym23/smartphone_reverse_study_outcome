package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.StandardPitchInfo;
import com.ss.bytertc.engine.handler.NativeSingScoringEventHandler;

/* JADX INFO: loaded from: classes40.dex */
public class NativeSingScoringManagerFunctions {
    public NativeSingScoringManagerFunctions() {
    }

    public static native int nativeGetAverageScore(long r100);

    public static native int nativeGetLastSentenceScore(long r100);

    public static native StandardPitchInfo[] nativeGetStandardPitchInfo(long r100, String r101);

    public static native int nativeGetTotalScore(long r100);

    public static native int nativeInitSingScoring(long r100, long r101, String r102, String r103, NativeSingScoringEventHandler r104);

    public static native int nativeSetSingScoringConfig(long r100, int r101, int r102, String r103, String r104);

    public static native int nativeStartSingScoring(long r100, int r101, int r102);

    public static native int nativeStopSingScoring(long r100);
}

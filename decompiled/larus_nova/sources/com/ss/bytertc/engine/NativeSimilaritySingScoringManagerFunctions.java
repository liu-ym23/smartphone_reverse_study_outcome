package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class NativeSimilaritySingScoringManagerFunctions {
    public NativeSimilaritySingScoringManagerFunctions() {
    }

    public static native int nativeGetAverageSimilarityScore(long r100);

    public static native int nativeGetLastSimilarityScore(long r100);

    public static native int nativeGetTotalSimilarityScore(long r100);

    public static native int nativeStartSimilaritySingScoring(long r100, int r101, int r102, String r103, String r104, int r105);

    public static native int nativeStopSimilaritySingScoring(long r100);
}

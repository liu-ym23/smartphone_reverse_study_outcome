package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum SimilaritySingScoringMode extends Enum<SimilaritySingScoringMode> {
    private static final /* synthetic */ SimilaritySingScoringMode[] $VALUES = null;
    public static final SimilaritySingScoringMode SING_SCORING_MODE_SPECTRAL_SIMILARITY = null;
    private int value;

    static {
        SimilaritySingScoringMode r100 = new SimilaritySingScoringMode("SING_SCORING_MODE_SPECTRAL_SIMILARITY", 0, 0);
        SING_SCORING_MODE_SPECTRAL_SIMILARITY = r100;
        $VALUES = new SimilaritySingScoringMode[]{r100};
    }

    public static SimilaritySingScoringMode[] values() {
        return (SimilaritySingScoringMode[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static SimilaritySingScoringMode fromId(int r100) {
        SimilaritySingScoringMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        SimilaritySingScoringMode r104 = r101[r103];
        if (r104.value == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static SimilaritySingScoringMode valueOf(String r100) {
        return (SimilaritySingScoringMode) a.a(SimilaritySingScoringMode.class, r100);
    }

    private SimilaritySingScoringMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

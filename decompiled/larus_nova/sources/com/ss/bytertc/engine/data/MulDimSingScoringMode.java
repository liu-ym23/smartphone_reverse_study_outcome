package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MulDimSingScoringMode extends Enum<MulDimSingScoringMode> {
    private static final /* synthetic */ MulDimSingScoringMode[] $VALUES = null;
    public static final MulDimSingScoringMode MUL_DIM_SING_SCORING_MODE_NOTE = null;
    private int value;

    static {
        MulDimSingScoringMode r100 = new MulDimSingScoringMode("MUL_DIM_SING_SCORING_MODE_NOTE", 0, 0);
        MUL_DIM_SING_SCORING_MODE_NOTE = r100;
        $VALUES = new MulDimSingScoringMode[]{r100};
    }

    public static MulDimSingScoringMode[] values() {
        return (MulDimSingScoringMode[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static MulDimSingScoringMode valueOf(String r100) {
        return (MulDimSingScoringMode) a.a(MulDimSingScoringMode.class, r100);
    }

    private MulDimSingScoringMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

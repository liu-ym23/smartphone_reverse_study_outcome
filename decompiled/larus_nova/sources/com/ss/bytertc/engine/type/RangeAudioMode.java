package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RangeAudioMode extends Enum<RangeAudioMode> {
    private static final /* synthetic */ RangeAudioMode[] $VALUES = null;
    public static final RangeAudioMode RANGE_AUDIO_MODE_TEAM = null;
    public static final RangeAudioMode RANGE_AUDIO_MODE_UNDEFINED = null;
    public static final RangeAudioMode RANGE_AUDIO_MODE_WORLD = null;
    private int value;

    static {
        RangeAudioMode r100 = new RangeAudioMode("RANGE_AUDIO_MODE_UNDEFINED", 0, 0);
        RANGE_AUDIO_MODE_UNDEFINED = r100;
        RangeAudioMode r101 = new RangeAudioMode("RANGE_AUDIO_MODE_TEAM", 1, 1);
        RANGE_AUDIO_MODE_TEAM = r101;
        RangeAudioMode r102 = new RangeAudioMode("RANGE_AUDIO_MODE_WORLD", 2, 2);
        RANGE_AUDIO_MODE_WORLD = r102;
        $VALUES = new RangeAudioMode[]{r100, r101, r102};
    }

    public static RangeAudioMode[] values() {
        return (RangeAudioMode[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RangeAudioMode valueOf(String r100) {
        return (RangeAudioMode) a.a(RangeAudioMode.class, r100);
    }

    private RangeAudioMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VoiceEqualizationBandFrequency extends Enum<VoiceEqualizationBandFrequency> {
    private static final /* synthetic */ VoiceEqualizationBandFrequency[] $VALUES = null;
    public static final VoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_125 = null;
    public static final VoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_16K = null;
    public static final VoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_1K = null;
    public static final VoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_250 = null;
    public static final VoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_2K = null;
    public static final VoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_31 = null;
    public static final VoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_4K = null;
    public static final VoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_500 = null;
    public static final VoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_62 = null;
    public static final VoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_8K = null;
    private final int value;

    static {
        VoiceEqualizationBandFrequency r100 = new VoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_31", 0, 0);
        VOICE_EQUALIZATION_BAND_FREQUENCY_31 = r100;
        VoiceEqualizationBandFrequency r101 = new VoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_62", 1, 1);
        VOICE_EQUALIZATION_BAND_FREQUENCY_62 = r101;
        VoiceEqualizationBandFrequency r102 = new VoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_125", 2, 2);
        VOICE_EQUALIZATION_BAND_FREQUENCY_125 = r102;
        VoiceEqualizationBandFrequency r103 = new VoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_250", 3, 3);
        VOICE_EQUALIZATION_BAND_FREQUENCY_250 = r103;
        VoiceEqualizationBandFrequency r104 = new VoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_500", 4, 4);
        VOICE_EQUALIZATION_BAND_FREQUENCY_500 = r104;
        VoiceEqualizationBandFrequency r105 = new VoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_1K", 5, 5);
        VOICE_EQUALIZATION_BAND_FREQUENCY_1K = r105;
        VoiceEqualizationBandFrequency r110 = new VoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_2K", 6, 6);
        VOICE_EQUALIZATION_BAND_FREQUENCY_2K = r110;
        VoiceEqualizationBandFrequency r111 = new VoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_4K", 7, 7);
        VOICE_EQUALIZATION_BAND_FREQUENCY_4K = r111;
        VoiceEqualizationBandFrequency r112 = new VoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_8K", 8, 8);
        VOICE_EQUALIZATION_BAND_FREQUENCY_8K = r112;
        VoiceEqualizationBandFrequency r113 = new VoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_16K", 9, 9);
        VOICE_EQUALIZATION_BAND_FREQUENCY_16K = r113;
        $VALUES = new VoiceEqualizationBandFrequency[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static VoiceEqualizationBandFrequency[] values() {
        return (VoiceEqualizationBandFrequency[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static VoiceEqualizationBandFrequency fromId(int r100) {
        VoiceEqualizationBandFrequency[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        VoiceEqualizationBandFrequency r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return VOICE_EQUALIZATION_BAND_FREQUENCY_16K;
    }

    public static VoiceEqualizationBandFrequency valueOf(String r100) {
        return (VoiceEqualizationBandFrequency) a.a(VoiceEqualizationBandFrequency.class, r100);
    }

    private VoiceEqualizationBandFrequency(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

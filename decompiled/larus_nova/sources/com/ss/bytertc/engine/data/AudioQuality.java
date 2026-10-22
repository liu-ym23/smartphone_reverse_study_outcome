package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioQuality extends Enum<AudioQuality> {
    private static final /* synthetic */ AudioQuality[] $VALUES = null;
    public static final AudioQuality AUDIO_QUALITY_HIGH = null;
    public static final AudioQuality AUDIO_QUALITY_LOW = null;
    public static final AudioQuality AUDIO_QUALITY_MEDIUM = null;
    public static final AudioQuality AUDIO_QUALITY_ULTRA_HIGH = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AudioQuality$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioQuality = null;

        static {
            int[] r100 = new int[AudioQuality.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioQuality = r100;
            r100[AudioQuality.AUDIO_QUALITY_LOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$bytertc$engine$data$AudioQuality[AudioQuality.AUDIO_QUALITY_MEDIUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$bytertc$engine$data$AudioQuality[AudioQuality.AUDIO_QUALITY_HIGH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$bytertc$engine$data$AudioQuality[AudioQuality.AUDIO_QUALITY_ULTRA_HIGH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        AudioQuality r100 = new AudioQuality("AUDIO_QUALITY_LOW", 0, 0);
        AUDIO_QUALITY_LOW = r100;
        AudioQuality r101 = new AudioQuality("AUDIO_QUALITY_MEDIUM", 1, 1);
        AUDIO_QUALITY_MEDIUM = r101;
        AudioQuality r102 = new AudioQuality("AUDIO_QUALITY_HIGH", 2, 2);
        AUDIO_QUALITY_HIGH = r102;
        AudioQuality r103 = new AudioQuality("AUDIO_QUALITY_ULTRA_HIGH", 3, 3);
        AUDIO_QUALITY_ULTRA_HIGH = r103;
        $VALUES = new AudioQuality[]{r100, r101, r102, r103};
    }

    public static AudioQuality[] values() {
        return (AudioQuality[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioQuality[ordinal()];
        if (r100 != 1) goto L5;
        return "kAudioQualityLow";
    L5:
        if (r100 != 2) goto L7;
        return "kAudioQualityMedium";
    L7:
        if (r100 != 3) goto L9;
        return "kAudioQualityHigh";
    L9:
        if (r100 == 4) goto L11;
        return "";
    L11:
        return "kAudioQualityUltraHigh";
    }

    public int value() {
        return this.value;
    }

    public static AudioQuality fromId(int r100) {
        AudioQuality[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioQuality r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioQuality valueOf(String r100) {
        return (AudioQuality) a.a(AudioQuality.class, r100);
    }

    private AudioQuality(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

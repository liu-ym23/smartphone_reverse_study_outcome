package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioMixingType extends Enum<AudioMixingType> {
    private static final /* synthetic */ AudioMixingType[] $VALUES = null;
    public static final AudioMixingType AUDIO_MIXING_TYPE_PLAYOUT = null;
    public static final AudioMixingType AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH = null;
    public static final AudioMixingType AUDIO_MIXING_TYPE_PUBLISH = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AudioMixingType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioMixingType = null;

        static {
            int[] r100 = new int[AudioMixingType.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingType = r100;
            r100[AudioMixingType.AUDIO_MIXING_TYPE_PLAYOUT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingType[AudioMixingType.AUDIO_MIXING_TYPE_PUBLISH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingType[AudioMixingType.AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        AudioMixingType r100 = new AudioMixingType("AUDIO_MIXING_TYPE_PLAYOUT", 0, 0);
        AUDIO_MIXING_TYPE_PLAYOUT = r100;
        AudioMixingType r101 = new AudioMixingType("AUDIO_MIXING_TYPE_PUBLISH", 1, 1);
        AUDIO_MIXING_TYPE_PUBLISH = r101;
        AudioMixingType r102 = new AudioMixingType("AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH", 2, 2);
        AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH = r102;
        $VALUES = new AudioMixingType[]{r100, r101, r102};
    }

    public static AudioMixingType[] values() {
        return (AudioMixingType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioMixingType[ordinal()];
        if (r100 != 1) goto L5;
        return "AUDIO_MIXING_TYPE_PLAYOUT";
    L5:
        if (r100 != 2) goto L7;
        return "AUDIO_MIXING_TYPE_PUBLISH";
    L7:
        if (r100 == 3) goto L9;
        return "";
    L9:
        return "AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH";
    }

    public int value() {
        return this.value;
    }

    public static AudioMixingType fromId(int r100) {
        AudioMixingType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioMixingType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioMixingType valueOf(String r100) {
        return (AudioMixingType) a.a(AudioMixingType.class, r100);
    }

    private AudioMixingType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

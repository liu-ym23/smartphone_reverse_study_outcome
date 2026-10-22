package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioSourceType extends Enum<AudioSourceType> {
    private static final /* synthetic */ AudioSourceType[] $VALUES = null;
    public static final AudioSourceType AUDIO_SOURCE_TYPE_EXTERNAL = null;
    public static final AudioSourceType AUDIO_SOURCE_TYPE_INTERNAL = null;
    private int value;

    static {
        AudioSourceType r100 = new AudioSourceType("AUDIO_SOURCE_TYPE_EXTERNAL", 0, 0);
        AUDIO_SOURCE_TYPE_EXTERNAL = r100;
        AudioSourceType r101 = new AudioSourceType("AUDIO_SOURCE_TYPE_INTERNAL", 1, 1);
        AUDIO_SOURCE_TYPE_INTERNAL = r101;
        $VALUES = new AudioSourceType[]{r100, r101};
    }

    public static AudioSourceType[] values() {
        return (AudioSourceType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != AUDIO_SOURCE_TYPE_EXTERNAL) goto L5;
        return "AUDIO_SOURCE_TYPE_EXTERNAL";
    L5:
        return "AUDIO_SOURCE_TYPE_INTERNAL";
    }

    public int value() {
        return this.value;
    }

    public static AudioSourceType fromId(int r100) {
        AudioSourceType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioSourceType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioSourceType valueOf(String r100) {
        return (AudioSourceType) a.a(AudioSourceType.class, r100);
    }

    private AudioSourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

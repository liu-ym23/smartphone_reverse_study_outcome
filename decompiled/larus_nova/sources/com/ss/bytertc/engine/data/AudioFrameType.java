package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioFrameType extends Enum<AudioFrameType> {
    private static final /* synthetic */ AudioFrameType[] $VALUES = null;
    public static final AudioFrameType FRAME_TYPE_PCM16 = null;
    private int value;

    static {
        AudioFrameType r100 = new AudioFrameType("FRAME_TYPE_PCM16", 0, 0);
        FRAME_TYPE_PCM16 = r100;
        $VALUES = new AudioFrameType[]{r100};
    }

    public static AudioFrameType[] values() {
        return (AudioFrameType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != FRAME_TYPE_PCM16) goto L5;
        return "kFrameTypePCM16";
    L5:
        return "kFrameTypeUnknown";
    }

    public int value() {
        return this.value;
    }

    public static AudioFrameType fromId(int r100) {
        AudioFrameType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioFrameType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioFrameType valueOf(String r100) {
        return (AudioFrameType) a.a(AudioFrameType.class, r100);
    }

    private AudioFrameType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

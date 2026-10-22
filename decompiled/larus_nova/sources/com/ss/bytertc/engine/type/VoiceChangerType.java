package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VoiceChangerType extends Enum<VoiceChangerType> {
    private static final /* synthetic */ VoiceChangerType[] $VALUES = null;
    public static final VoiceChangerType VOICE_CHANGER_CHIPMUNK = null;
    public static final VoiceChangerType VOICE_CHANGER_GIANT = null;
    public static final VoiceChangerType VOICE_CHANGER_MINIONST = null;
    public static final VoiceChangerType VOICE_CHANGER_ORIGINAL = null;
    public static final VoiceChangerType VOICE_CHANGER_ROBOT = null;
    public static final VoiceChangerType VOICE_CHANGER_VIBRATO = null;
    private final int value;

    static {
        VoiceChangerType r100 = new VoiceChangerType("VOICE_CHANGER_ORIGINAL", 0, 0);
        VOICE_CHANGER_ORIGINAL = r100;
        VoiceChangerType r101 = new VoiceChangerType("VOICE_CHANGER_GIANT", 1, 1);
        VOICE_CHANGER_GIANT = r101;
        VoiceChangerType r102 = new VoiceChangerType("VOICE_CHANGER_CHIPMUNK", 2, 2);
        VOICE_CHANGER_CHIPMUNK = r102;
        VoiceChangerType r103 = new VoiceChangerType("VOICE_CHANGER_MINIONST", 3, 3);
        VOICE_CHANGER_MINIONST = r103;
        VoiceChangerType r104 = new VoiceChangerType("VOICE_CHANGER_VIBRATO", 4, 4);
        VOICE_CHANGER_VIBRATO = r104;
        VoiceChangerType r105 = new VoiceChangerType("VOICE_CHANGER_ROBOT", 5, 5);
        VOICE_CHANGER_ROBOT = r105;
        $VALUES = new VoiceChangerType[]{r100, r101, r102, r103, r104, r105};
    }

    public static VoiceChangerType[] values() {
        return (VoiceChangerType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static VoiceChangerType fromId(int r100) {
        VoiceChangerType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        VoiceChangerType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return VOICE_CHANGER_ORIGINAL;
    }

    public static VoiceChangerType valueOf(String r100) {
        return (VoiceChangerType) a.a(VoiceChangerType.class, r100);
    }

    private VoiceChangerType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

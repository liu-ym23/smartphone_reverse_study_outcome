package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioScenarioType extends Enum<AudioScenarioType> {
    private static final /* synthetic */ AudioScenarioType[] $VALUES = null;
    public static final AudioScenarioType CHATROOM = null;
    public static final AudioScenarioType CHORUS = null;
    public static final AudioScenarioType DEFAULT = null;
    public static final AudioScenarioType GAMESTREAMING = null;
    private final int value;

    static {
        AudioScenarioType r100 = new AudioScenarioType("DEFAULT", 0, 0);
        DEFAULT = r100;
        AudioScenarioType r101 = new AudioScenarioType("CHATROOM", 1, 1);
        CHATROOM = r101;
        AudioScenarioType r102 = new AudioScenarioType("GAMESTREAMING", 2, 2);
        GAMESTREAMING = r102;
        AudioScenarioType r103 = new AudioScenarioType("CHORUS", 3, 3);
        CHORUS = r103;
        $VALUES = new AudioScenarioType[]{r100, r101, r102, r103};
    }

    public static AudioScenarioType[] values() {
        return (AudioScenarioType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static AudioScenarioType fromId(int r100) {
        AudioScenarioType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        AudioScenarioType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return DEFAULT;
    }

    public static AudioScenarioType valueOf(String r100) {
        return (AudioScenarioType) a.a(AudioScenarioType.class, r100);
    }

    private AudioScenarioType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

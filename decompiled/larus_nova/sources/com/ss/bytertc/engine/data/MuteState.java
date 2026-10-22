package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MuteState extends Enum<MuteState> {
    private static final /* synthetic */ MuteState[] $VALUES = null;
    public static final MuteState MUTE_STATE_OFF = null;
    public static final MuteState MUTE_STATE_ON = null;
    private int value;

    static {
        MuteState r100 = new MuteState("MUTE_STATE_OFF", 0, 0);
        MUTE_STATE_OFF = r100;
        MuteState r101 = new MuteState("MUTE_STATE_ON", 1, 1);
        MUTE_STATE_ON = r101;
        $VALUES = new MuteState[]{r100, r101};
    }

    public static MuteState[] values() {
        return (MuteState[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != MUTE_STATE_ON) goto L5;
        return "kMuteStateOn";
    L5:
        return "kMuteStateOff";
    }

    public int value() {
        return this.value;
    }

    public static MuteState fromId(int r100) {
        MuteState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        MuteState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static MuteState valueOf(String r100) {
        return (MuteState) a.a(MuteState.class, r100);
    }

    private MuteState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

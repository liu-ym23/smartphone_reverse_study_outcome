package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RoomState extends Enum<RoomState> {
    private static final /* synthetic */ RoomState[] $VALUES = null;
    public static final RoomState JOIN_FAILED = null;
    public static final RoomState JOIN_SUCCESS = null;
    public static final RoomState LEFT = null;
    private int value;

    static {
        RoomState r100 = new RoomState("JOIN_SUCCESS", 0, 0);
        JOIN_SUCCESS = r100;
        RoomState r101 = new RoomState("JOIN_FAILED", 1, 1);
        JOIN_FAILED = r101;
        RoomState r102 = new RoomState("LEFT", 2, 2);
        LEFT = r102;
        $VALUES = new RoomState[]{r100, r101, r102};
    }

    public static RoomState[] values() {
        return (RoomState[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RoomState valueOf(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return LEFT;
    L12:
        return JOIN_FAILED;
    L14:
        return JOIN_SUCCESS;
    }

    public static RoomState valueOf(String r100) {
        return (RoomState) a.a(RoomState.class, r100);
    }

    private RoomState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

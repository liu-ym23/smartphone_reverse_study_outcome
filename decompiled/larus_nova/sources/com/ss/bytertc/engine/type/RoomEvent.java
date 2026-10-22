package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RoomEvent extends Enum<RoomEvent> {
    private static final /* synthetic */ RoomEvent[] $VALUES = null;
    public static final RoomEvent FORBIDDEN = null;
    public static final RoomEvent USER_NOTIFY_STOP = null;
    private int value;

    static {
        RoomEvent r100 = new RoomEvent("USER_NOTIFY_STOP", 0, WarningCode.WARNING_CODE_RECEIVE_USER_NOTIFY_STOP);
        USER_NOTIFY_STOP = r100;
        RoomEvent r101 = new RoomEvent("FORBIDDEN", 1, -2012);
        FORBIDDEN = r101;
        $VALUES = new RoomEvent[]{r100, r101};
    }

    public static RoomEvent[] values() {
        return (RoomEvent[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RoomEvent valueOf(int r100) {
        if (r100 == (-2013)) goto L11;
        if (r100 == (-2012)) goto L9;
        return null;
    L9:
        return FORBIDDEN;
    L11:
        return USER_NOTIFY_STOP;
    }

    public static RoomEvent valueOf(String r100) {
        return (RoomEvent) a.a(RoomEvent.class, r100);
    }

    private RoomEvent(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

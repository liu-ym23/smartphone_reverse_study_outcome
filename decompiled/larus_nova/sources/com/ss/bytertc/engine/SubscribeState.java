package com.ss.bytertc.engine;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum SubscribeState extends Enum<SubscribeState> {
    private static final /* synthetic */ SubscribeState[] $VALUES = null;
    public static final SubscribeState SUBSCRIBE_STATE_FAILED_AUTO_MODE = null;
    public static final SubscribeState SUBSCRIBE_STATE_FAILED_NOT_IN_ROOM = null;
    public static final SubscribeState SUBSCRIBE_STATE_FAILED_SIGNAL = null;
    public static final SubscribeState SUBSCRIBE_STATE_FAILED_STREAM_NOT_FOUND = null;
    public static final SubscribeState SUBSCRIBE_STATE_SUCCESS = null;

    static {
        SubscribeState r100 = new SubscribeState("SUBSCRIBE_STATE_SUCCESS", 0);
        SUBSCRIBE_STATE_SUCCESS = r100;
        SubscribeState r101 = new SubscribeState("SUBSCRIBE_STATE_FAILED_NOT_IN_ROOM", 1);
        SUBSCRIBE_STATE_FAILED_NOT_IN_ROOM = r101;
        SubscribeState r102 = new SubscribeState("SUBSCRIBE_STATE_FAILED_STREAM_NOT_FOUND", 2);
        SUBSCRIBE_STATE_FAILED_STREAM_NOT_FOUND = r102;
        SubscribeState r103 = new SubscribeState("SUBSCRIBE_STATE_FAILED_AUTO_MODE", 3);
        SUBSCRIBE_STATE_FAILED_AUTO_MODE = r103;
        SubscribeState r104 = new SubscribeState("SUBSCRIBE_STATE_FAILED_SIGNAL", 4);
        SUBSCRIBE_STATE_FAILED_SIGNAL = r104;
        $VALUES = new SubscribeState[]{r100, r101, r102, r103, r104};
    }

    public static SubscribeState[] values() {
        return (SubscribeState[]) $VALUES.clone();
    }

    public static SubscribeState valueOf(String r100) {
        return (SubscribeState) a.a(SubscribeState.class, r100);
    }

    private SubscribeState(String r100, int r101) {
        super(r100, r101);
    }
}

package com.ss.bytertc.engine;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum StreamSubscribeState extends Enum<StreamSubscribeState> {
    private static final /* synthetic */ StreamSubscribeState[] $VALUES = null;
    public static final StreamSubscribeState FAILED_AUTO_MODE = null;
    public static final StreamSubscribeState FAILED_NOT_IN_ROOM = null;
    public static final StreamSubscribeState FAILED_SIGNAL = null;
    public static final StreamSubscribeState FAILED_STREAM_NOT_FOUND = null;
    public static final StreamSubscribeState SUCCESS = null;

    static {
        StreamSubscribeState r100 = new StreamSubscribeState("SUCCESS", 0);
        SUCCESS = r100;
        StreamSubscribeState r101 = new StreamSubscribeState("FAILED_NOT_IN_ROOM", 1);
        FAILED_NOT_IN_ROOM = r101;
        StreamSubscribeState r102 = new StreamSubscribeState("FAILED_STREAM_NOT_FOUND", 2);
        FAILED_STREAM_NOT_FOUND = r102;
        StreamSubscribeState r103 = new StreamSubscribeState("FAILED_AUTO_MODE", 3);
        FAILED_AUTO_MODE = r103;
        StreamSubscribeState r104 = new StreamSubscribeState("FAILED_SIGNAL", 4);
        FAILED_SIGNAL = r104;
        $VALUES = new StreamSubscribeState[]{r100, r101, r102, r103, r104};
    }

    public static StreamSubscribeState[] values() {
        return (StreamSubscribeState[]) $VALUES.clone();
    }

    public static StreamSubscribeState valueOf(String r100) {
        return (StreamSubscribeState) a.a(StreamSubscribeState.class, r100);
    }

    private StreamSubscribeState(String r100, int r101) {
        super(r100, r101);
    }
}

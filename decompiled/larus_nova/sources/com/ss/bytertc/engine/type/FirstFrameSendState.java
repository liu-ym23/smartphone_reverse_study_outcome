package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum FirstFrameSendState extends Enum<FirstFrameSendState> {
    private static final /* synthetic */ FirstFrameSendState[] $VALUES = null;
    public static final FirstFrameSendState FIRST_FRAME_SEND_STATE_SENDING = null;
    public static final FirstFrameSendState FIRST_FRAME_SEND_STATE_SENT = null;
    public static final FirstFrameSendState FIRST_FRAME_SEND_STAT_END = null;
    private int state;

    static {
        FirstFrameSendState r100 = new FirstFrameSendState("FIRST_FRAME_SEND_STATE_SENDING", 0, 0);
        FIRST_FRAME_SEND_STATE_SENDING = r100;
        FirstFrameSendState r101 = new FirstFrameSendState("FIRST_FRAME_SEND_STATE_SENT", 1, 1);
        FIRST_FRAME_SEND_STATE_SENT = r101;
        FirstFrameSendState r102 = new FirstFrameSendState("FIRST_FRAME_SEND_STAT_END", 2, 2);
        FIRST_FRAME_SEND_STAT_END = r102;
        $VALUES = new FirstFrameSendState[]{r100, r101, r102};
    }

    public static FirstFrameSendState[] values() {
        return (FirstFrameSendState[]) $VALUES.clone();
    }

    public int value() {
        return this.state;
    }

    public static FirstFrameSendState fromId(int r100) {
        FirstFrameSendState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        FirstFrameSendState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return FIRST_FRAME_SEND_STATE_SENDING;
    }

    public static FirstFrameSendState valueOf(String r100) {
        return (FirstFrameSendState) a.a(FirstFrameSendState.class, r100);
    }

    private FirstFrameSendState(String r100, int r101, int r102) {
        super(r100, r101);
        this.state = r102;
    }
}

package com.bytedance.common.wschannel.event;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum MessageAckEvent$MessageState extends Enum<MessageAckEvent$MessageState> {
    private static final /* synthetic */ MessageAckEvent$MessageState[] $VALUES = null;
    public static final MessageAckEvent$MessageState Default = null;
    public static final MessageAckEvent$MessageState Failed = null;
    public static final MessageAckEvent$MessageState Success = null;
    public static final MessageAckEvent$MessageState TimeOut = null;
    final int mState;

    static {
        MessageAckEvent$MessageState r100 = new MessageAckEvent$MessageState("Default", 0, 0);
        Default = r100;
        MessageAckEvent$MessageState r101 = new MessageAckEvent$MessageState("TimeOut", 1, 1);
        TimeOut = r101;
        MessageAckEvent$MessageState r102 = new MessageAckEvent$MessageState("Failed", 2, 2);
        Failed = r102;
        MessageAckEvent$MessageState r103 = new MessageAckEvent$MessageState("Success", 3, 3);
        Success = r103;
        $VALUES = new MessageAckEvent$MessageState[]{r100, r101, r102, r103};
    }

    public static MessageAckEvent$MessageState[] values() {
        return (MessageAckEvent$MessageState[]) $VALUES.clone();
    }

    public int getTypeValue() {
        return this.mState;
    }

    public static MessageAckEvent$MessageState valueOf(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return Default;
    L11:
        return Success;
    L13:
        return Failed;
    L15:
        return TimeOut;
    }

    public static MessageAckEvent$MessageState valueOf(String r100) {
        return (MessageAckEvent$MessageState) a.a(MessageAckEvent$MessageState.class, r100);
    }

    private MessageAckEvent$MessageState(String r100, int r101, int r102) {
        super(r100, r101);
        this.mState = r102;
    }
}

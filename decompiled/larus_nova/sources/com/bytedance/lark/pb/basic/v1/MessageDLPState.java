package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum MessageDLPState extends Enum<MessageDLPState> implements WireEnum {
    private static final /* synthetic */ MessageDLPState[] $VALUES = null;
    public static final ProtoAdapter<MessageDLPState> ADAPTER = null;
    public static final MessageDLPState DLP_BLOCK = null;
    public static final MessageDLPState DLP_INACTIVE = null;
    public static final MessageDLPState DLP_IN_PROGRESS = null;
    public static final MessageDLPState DLP_PASS = null;
    public static final MessageDLPState UNKNOWN_DLP_STATE = null;
    private final int value;

    static {
        MessageDLPState r100 = new MessageDLPState("UNKNOWN_DLP_STATE", 0, 0);
        UNKNOWN_DLP_STATE = r100;
        MessageDLPState r101 = new MessageDLPState("DLP_IN_PROGRESS", 1, 1);
        DLP_IN_PROGRESS = r101;
        MessageDLPState r102 = new MessageDLPState("DLP_PASS", 2, 2);
        DLP_PASS = r102;
        MessageDLPState r103 = new MessageDLPState("DLP_BLOCK", 3, 3);
        DLP_BLOCK = r103;
        MessageDLPState r104 = new MessageDLPState("DLP_INACTIVE", 4, 4);
        DLP_INACTIVE = r104;
        $VALUES = new MessageDLPState[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(MessageDLPState.class);
    }

    public static MessageDLPState[] values() {
        return (MessageDLPState[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static MessageDLPState fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return DLP_INACTIVE;
    L16:
        return DLP_BLOCK;
    L18:
        return DLP_PASS;
    L20:
        return DLP_IN_PROGRESS;
    L22:
        return UNKNOWN_DLP_STATE;
    }

    public static MessageDLPState valueOf(String r100) {
        return (MessageDLPState) a.a(MessageDLPState.class, r100);
    }

    private MessageDLPState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

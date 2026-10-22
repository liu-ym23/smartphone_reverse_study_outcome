package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum MessageSourceType extends Enum<MessageSourceType> implements WireEnum {
    private static final /* synthetic */ MessageSourceType[] $VALUES = null;
    public static final ProtoAdapter<MessageSourceType> ADAPTER = null;
    public static final MessageSourceType COMMON_MESSAGE = null;
    public static final MessageSourceType MERGE_FORWARD_MESSAGE = null;
    private final int value;

    static {
        MessageSourceType r100 = new MessageSourceType("COMMON_MESSAGE", 0, 0);
        COMMON_MESSAGE = r100;
        MessageSourceType r101 = new MessageSourceType("MERGE_FORWARD_MESSAGE", 1, 1);
        MERGE_FORWARD_MESSAGE = r101;
        $VALUES = new MessageSourceType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(MessageSourceType.class);
    }

    public static MessageSourceType[] values() {
        return (MessageSourceType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static MessageSourceType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return MERGE_FORWARD_MESSAGE;
    L10:
        return COMMON_MESSAGE;
    }

    public static MessageSourceType valueOf(String r100) {
        return (MessageSourceType) a.a(MessageSourceType.class, r100);
    }

    private MessageSourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

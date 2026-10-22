package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ChannelType extends Enum<ChannelType> implements WireEnum {
    private static final /* synthetic */ ChannelType[] $VALUES = null;
    public static final ProtoAdapter<ChannelType> ADAPTER = null;
    public static final ChannelType CHAT_CHANNEL = null;
    public static final ChannelType EMAIL_CHANNEL = null;
    public static final ChannelType UNKNOWN_CHANNEL_TYPE = null;
    private final int value;

    static {
        ChannelType r100 = new ChannelType("UNKNOWN_CHANNEL_TYPE", 0, 0);
        UNKNOWN_CHANNEL_TYPE = r100;
        ChannelType r101 = new ChannelType("CHAT_CHANNEL", 1, 1);
        CHAT_CHANNEL = r101;
        ChannelType r102 = new ChannelType("EMAIL_CHANNEL", 2, 2);
        EMAIL_CHANNEL = r102;
        $VALUES = new ChannelType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChannelType.class);
    }

    public static ChannelType[] values() {
        return (ChannelType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ChannelType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return EMAIL_CHANNEL;
    L12:
        return CHAT_CHANNEL;
    L14:
        return UNKNOWN_CHANNEL_TYPE;
    }

    public static ChannelType valueOf(String r100) {
        return (ChannelType) a.a(ChannelType.class, r100);
    }

    private ChannelType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

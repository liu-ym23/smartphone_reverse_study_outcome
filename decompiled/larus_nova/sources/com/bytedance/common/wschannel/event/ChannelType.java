package com.bytedance.common.wschannel.event;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum ChannelType extends Enum<ChannelType> {
    private static final /* synthetic */ ChannelType[] $VALUES = null;
    public static final ChannelType CHANNEL_OK = null;
    public static final ChannelType CHANNEL_SELF = null;
    int mTypeValue;

    static {
        ChannelType r100 = new ChannelType("CHANNEL_SELF", 0, 1);
        CHANNEL_SELF = r100;
        ChannelType r101 = new ChannelType("CHANNEL_OK", 1, 2);
        CHANNEL_OK = r101;
        $VALUES = new ChannelType[]{r100, r101};
    }

    public static ChannelType[] values() {
        return (ChannelType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ChannelType{Type=" + this.mTypeValue + '}';
    }

    public int getVal() {
        return this.mTypeValue;
    }

    public static ChannelType of(int r100) {
        if (r100 != 1) goto L7;
        return CHANNEL_SELF;
    L7:
        return CHANNEL_OK;
    }

    public static ChannelType valueOf(String r100) {
        return (ChannelType) a.a(ChannelType.class, r100);
    }

    private ChannelType(String r100, int r101, int r102) {
        super(r100, r101);
        this.mTypeValue = r102;
    }
}

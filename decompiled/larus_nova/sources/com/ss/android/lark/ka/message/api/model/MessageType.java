package com.ss.android.lark.ka.message.api.model;

import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum MessageType extends Enum<MessageType> {
    private static final /* synthetic */ MessageType[] $VALUES = null;
    public static final MessageType FILE = null;
    public static final MessageType IMAGE = null;
    public static final MessageType MEDIA = null;

    static {
        MessageType r100 = new MessageType("FILE", 0);
        FILE = r100;
        MessageType r101 = new MessageType("IMAGE", 1);
        IMAGE = r101;
        MessageType r102 = new MessageType("MEDIA", 2);
        MEDIA = r102;
        $VALUES = new MessageType[]{r100, r101, r102};
    }

    public static MessageType[] values() {
        return (MessageType[]) $VALUES.clone();
    }

    public static MessageType valueOf(String r100) {
        return (MessageType) a.a(MessageType.class, r100);
    }

    private MessageType(String r100, int r101) {
        super(r100, r101);
    }
}

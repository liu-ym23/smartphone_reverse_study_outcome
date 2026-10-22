package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MessageConfig extends Enum<MessageConfig> {
    private static final /* synthetic */ MessageConfig[] $VALUES = null;
    public static final MessageConfig RELIABLE_ORDERED = null;
    public static final MessageConfig UNRELIABLE_ORDERED = null;
    public static final MessageConfig UNRELIABLE_UNORDERED = null;
    int value;

    static {
        MessageConfig r100 = new MessageConfig("RELIABLE_ORDERED", 0, 0);
        RELIABLE_ORDERED = r100;
        MessageConfig r101 = new MessageConfig("UNRELIABLE_ORDERED", 1, 1);
        UNRELIABLE_ORDERED = r101;
        MessageConfig r102 = new MessageConfig("UNRELIABLE_UNORDERED", 2, 2);
        UNRELIABLE_UNORDERED = r102;
        $VALUES = new MessageConfig[]{r100, r101, r102};
    }

    public static MessageConfig[] values() {
        return (MessageConfig[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static MessageConfig fromId(int r100) {
        MessageConfig[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        MessageConfig r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return RELIABLE_ORDERED;
    }

    public static MessageConfig valueOf(String r100) {
        return (MessageConfig) a.a(MessageConfig.class, r100);
    }

    private MessageConfig(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

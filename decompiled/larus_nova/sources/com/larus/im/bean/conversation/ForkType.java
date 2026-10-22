package com.larus.im.bean.conversation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/im/bean/conversation/ForkType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ACTION_BAR", "LONG_PRESS_MESSAGE", "CONVERSATION_SETTINGS", "AUTO_ROUTE", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForkType extends Enum<ForkType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ForkType[] $VALUES = null;
    public static final ForkType ACTION_BAR = null;
    public static final ForkType AUTO_ROUTE = null;
    public static final ForkType CONVERSATION_SETTINGS = null;
    public static final ForkType LONG_PRESS_MESSAGE = null;
    private final int value;

    private static final /* synthetic */ ForkType[] $values() {
        return new ForkType[]{ACTION_BAR, LONG_PRESS_MESSAGE, CONVERSATION_SETTINGS, AUTO_ROUTE};
    }

    public static EnumEntries<ForkType> getEntries() {
        return $ENTRIES;
    }

    static {
        ACTION_BAR = new ForkType("ACTION_BAR", 0, 0);
        LONG_PRESS_MESSAGE = new ForkType("LONG_PRESS_MESSAGE", 1, 1);
        CONVERSATION_SETTINGS = new ForkType("CONVERSATION_SETTINGS", 2, 2);
        AUTO_ROUTE = new ForkType("AUTO_ROUTE", 3, 3);
        ForkType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ForkType[] values() {
        return (ForkType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ForkType valueOf(String r100) {
        return (ForkType) a.a(ForkType.class, r100);
    }

    private ForkType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/im/bean/message/block/ClickActionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CLICK_ACTION_TYPE_DEFAULT", "CLICK_ACTION_TYPE_PLAY_AUDIO_BUTTON", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ClickActionType extends Enum<ClickActionType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ClickActionType[] $VALUES = null;
    public static final ClickActionType CLICK_ACTION_TYPE_DEFAULT = null;
    public static final ClickActionType CLICK_ACTION_TYPE_PLAY_AUDIO_BUTTON = null;
    private final int value;

    private static final /* synthetic */ ClickActionType[] $values() {
        return new ClickActionType[]{CLICK_ACTION_TYPE_DEFAULT, CLICK_ACTION_TYPE_PLAY_AUDIO_BUTTON};
    }

    public static EnumEntries<ClickActionType> getEntries() {
        return $ENTRIES;
    }

    static {
        CLICK_ACTION_TYPE_DEFAULT = new ClickActionType("CLICK_ACTION_TYPE_DEFAULT", 0, 0);
        CLICK_ACTION_TYPE_PLAY_AUDIO_BUTTON = new ClickActionType("CLICK_ACTION_TYPE_PLAY_AUDIO_BUTTON", 1, 1);
        ClickActionType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ClickActionType[] values() {
        return (ClickActionType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ClickActionType valueOf(String r100) {
        return (ClickActionType) a.a(ClickActionType.class, r100);
    }

    private ClickActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

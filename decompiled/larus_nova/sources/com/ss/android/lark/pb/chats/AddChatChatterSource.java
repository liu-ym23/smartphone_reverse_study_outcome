package com.ss.android.lark.pb.chats;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum AddChatChatterSource extends Enum<AddChatChatterSource> implements WireEnum {
    private static final /* synthetic */ AddChatChatterSource[] $VALUES = null;
    public static final ProtoAdapter<AddChatChatterSource> ADAPTER = null;
    public static final AddChatChatterSource BY_MENTION = null;
    public static final AddChatChatterSource UNKNOWN_SOURCE = null;
    private final int value;

    static {
        AddChatChatterSource r100 = new AddChatChatterSource("UNKNOWN_SOURCE", 0, 0);
        UNKNOWN_SOURCE = r100;
        AddChatChatterSource r101 = new AddChatChatterSource("BY_MENTION", 1, 1);
        BY_MENTION = r101;
        $VALUES = new AddChatChatterSource[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(AddChatChatterSource.class);
    }

    public static AddChatChatterSource[] values() {
        return (AddChatChatterSource[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static AddChatChatterSource fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return BY_MENTION;
    L10:
        return UNKNOWN_SOURCE;
    }

    public static AddChatChatterSource valueOf(String r100) {
        return (AddChatChatterSource) a.a(AddChatChatterSource.class, r100);
    }

    private AddChatChatterSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

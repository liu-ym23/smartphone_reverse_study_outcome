package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ChatPostType extends Enum<ChatPostType> implements WireEnum {
    private static final /* synthetic */ ChatPostType[] $VALUES = null;
    public static final ProtoAdapter<ChatPostType> ADAPTER = null;
    public static final ChatPostType ANYONE = null;
    public static final ChatPostType ONLY_ADMIN = null;
    public static final ChatPostType UNKNOWN_POST_TYPE = null;
    public static final ChatPostType WHITE_LIST = null;
    private final int value;

    static {
        ChatPostType r100 = new ChatPostType("UNKNOWN_POST_TYPE", 0, 0);
        UNKNOWN_POST_TYPE = r100;
        ChatPostType r101 = new ChatPostType("ANYONE", 1, 1);
        ANYONE = r101;
        ChatPostType r102 = new ChatPostType("ONLY_ADMIN", 2, 2);
        ONLY_ADMIN = r102;
        ChatPostType r103 = new ChatPostType("WHITE_LIST", 3, 3);
        WHITE_LIST = r103;
        $VALUES = new ChatPostType[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChatPostType.class);
    }

    public static ChatPostType[] values() {
        return (ChatPostType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ChatPostType fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return WHITE_LIST;
    L14:
        return ONLY_ADMIN;
    L16:
        return ANYONE;
    L18:
        return UNKNOWN_POST_TYPE;
    }

    public static ChatPostType valueOf(String r100) {
        return (ChatPostType) a.a(ChatPostType.class, r100);
    }

    private ChatPostType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

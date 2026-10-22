package com.bytedance.lark.pb.im.v2;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ChatThemeType extends Enum<ChatThemeType> implements WireEnum {
    private static final /* synthetic */ ChatThemeType[] $VALUES = null;
    public static final ProtoAdapter<ChatThemeType> ADAPTER = null;
    public static final ChatThemeType GROUP_CHAT_THEME = null;
    public static final ChatThemeType PERSONAL_CHAT_THEME = null;
    public static final ChatThemeType UNKNOWN_CHAT_THEME_TYPE = null;
    private final int value;

    static {
        ChatThemeType r100 = new ChatThemeType("UNKNOWN_CHAT_THEME_TYPE", 0, 0);
        UNKNOWN_CHAT_THEME_TYPE = r100;
        ChatThemeType r101 = new ChatThemeType("PERSONAL_CHAT_THEME", 1, 1);
        PERSONAL_CHAT_THEME = r101;
        ChatThemeType r102 = new ChatThemeType("GROUP_CHAT_THEME", 2, 2);
        GROUP_CHAT_THEME = r102;
        $VALUES = new ChatThemeType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChatThemeType.class);
    }

    public static ChatThemeType[] values() {
        return (ChatThemeType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ChatThemeType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return GROUP_CHAT_THEME;
    L12:
        return PERSONAL_CHAT_THEME;
    L14:
        return UNKNOWN_CHAT_THEME_TYPE;
    }

    public static ChatThemeType valueOf(String r100) {
        return (ChatThemeType) a.a(ChatThemeType.class, r100);
    }

    private ChatThemeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

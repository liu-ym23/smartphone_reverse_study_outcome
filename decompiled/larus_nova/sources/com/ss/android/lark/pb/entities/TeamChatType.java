package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum TeamChatType extends Enum<TeamChatType> implements WireEnum {
    private static final /* synthetic */ TeamChatType[] $VALUES = null;
    public static final ProtoAdapter<TeamChatType> ADAPTER = null;
    public static final TeamChatType TEAM_CHAT_TYPE_DEFAULT = null;
    public static final TeamChatType TEAM_CHAT_TYPE_OPEN = null;
    public static final TeamChatType TEAM_CHAT_TYPE_PRIVATE = null;
    public static final TeamChatType TEAM_CHAT_TYPE_PUBLIC = null;
    public static final TeamChatType TEAM_CHAT_TYPE_UNKNOWN = null;
    private final int value;

    static {
        TeamChatType r100 = new TeamChatType("TEAM_CHAT_TYPE_UNKNOWN", 0, 0);
        TEAM_CHAT_TYPE_UNKNOWN = r100;
        TeamChatType r101 = new TeamChatType("TEAM_CHAT_TYPE_DEFAULT", 1, 1);
        TEAM_CHAT_TYPE_DEFAULT = r101;
        TeamChatType r102 = new TeamChatType("TEAM_CHAT_TYPE_PUBLIC", 2, 2);
        TEAM_CHAT_TYPE_PUBLIC = r102;
        TeamChatType r103 = new TeamChatType("TEAM_CHAT_TYPE_PRIVATE", 3, 3);
        TEAM_CHAT_TYPE_PRIVATE = r103;
        TeamChatType r104 = new TeamChatType("TEAM_CHAT_TYPE_OPEN", 4, 4);
        TEAM_CHAT_TYPE_OPEN = r104;
        $VALUES = new TeamChatType[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(TeamChatType.class);
    }

    public static TeamChatType[] values() {
        return (TeamChatType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TeamChatType fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return TEAM_CHAT_TYPE_OPEN;
    L16:
        return TEAM_CHAT_TYPE_PRIVATE;
    L18:
        return TEAM_CHAT_TYPE_PUBLIC;
    L20:
        return TEAM_CHAT_TYPE_DEFAULT;
    L22:
        return TEAM_CHAT_TYPE_UNKNOWN;
    }

    public static TeamChatType valueOf(String r100) {
        return (TeamChatType) a.a(TeamChatType.class, r100);
    }

    private TeamChatType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

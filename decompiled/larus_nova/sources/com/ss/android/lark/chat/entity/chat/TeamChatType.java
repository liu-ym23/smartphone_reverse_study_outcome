package com.ss.android.lark.chat.entity.chat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/TeamChatType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DEFAULT", "PUBLIC", "PRIVATE", "OPEN", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TeamChatType extends Enum<TeamChatType> {
    public static final a Companion = null;
    public static final TeamChatType DEFAULT = null;
    public static final TeamChatType OPEN = null;
    public static final TeamChatType PRIVATE = null;
    public static final TeamChatType PUBLIC = null;
    public static final TeamChatType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TeamChatType[] f415168a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415169b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static TeamChatType a(int r100) {
            TeamChatType r101 = TeamChatType.DEFAULT;
            if (r100 == r101.getValue()) goto L16;
            TeamChatType r102 = TeamChatType.PUBLIC;
            if (r100 == r102.getValue()) goto L17;
            TeamChatType r103 = TeamChatType.PRIVATE;
            if (r100 == r103.getValue()) goto L18;
            TeamChatType r104 = TeamChatType.OPEN;
            if (r100 != r104.getValue()) goto L15;
            return r104;
        L15:
            return TeamChatType.UNKNOWN;
        L18:
            return r103;
        L17:
            return r102;
        L16:
            return r101;
        }
    }

    @JvmStatic
    public static final TeamChatType fromValue(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<TeamChatType> getEntries() {
        return f415169b;
    }

    static {
        TeamChatType r100 = new TeamChatType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        TeamChatType r101 = new TeamChatType("DEFAULT", 1, 1);
        DEFAULT = r101;
        TeamChatType r102 = new TeamChatType("PUBLIC", 2, 2);
        PUBLIC = r102;
        TeamChatType r103 = new TeamChatType("PRIVATE", 3, 3);
        PRIVATE = r103;
        TeamChatType r104 = new TeamChatType("OPEN", 4, 4);
        OPEN = r104;
        TeamChatType[] r105 = {r100, r101, r102, r103, r104};
        f415168a = r105;
        f415169b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static TeamChatType[] values() {
        return (TeamChatType[]) f415168a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TeamChatType valueOf(String r100) {
        return (TeamChatType) r27.a.a(TeamChatType.class, r100);
    }

    public TeamChatType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.lark.kmp.pb.basic.v1;

import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TeamChatType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TEAM_CHAT_TYPE_UNKNOWN", "TEAM_CHAT_TYPE_DEFAULT", "TEAM_CHAT_TYPE_PUBLIC", "TEAM_CHAT_TYPE_PRIVATE", "TEAM_CHAT_TYPE_OPEN", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TeamChatType extends Enum<TeamChatType> implements o0 {
    public static final ProtoAdapter<TeamChatType> ADAPTER = null;
    public static final b Companion = null;
    public static final TeamChatType TEAM_CHAT_TYPE_DEFAULT = null;
    public static final TeamChatType TEAM_CHAT_TYPE_OPEN = null;
    public static final TeamChatType TEAM_CHAT_TYPE_PRIVATE = null;
    public static final TeamChatType TEAM_CHAT_TYPE_PUBLIC = null;
    public static final TeamChatType TEAM_CHAT_TYPE_UNKNOWN = null;
    public static final /* synthetic */ TeamChatType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static TeamChatType a(int r1) {
            if (r1 == 0) goto L17;
            if (r1 == 1) goto L22;
            if (r1 == 2) goto L21;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L19;
            return null;
        L19:
            return TeamChatType.TEAM_CHAT_TYPE_OPEN;
        L20:
            return TeamChatType.TEAM_CHAT_TYPE_PRIVATE;
        L21:
            return TeamChatType.TEAM_CHAT_TYPE_PUBLIC;
        L22:
            return TeamChatType.TEAM_CHAT_TYPE_DEFAULT;
        L17:
            return TeamChatType.TEAM_CHAT_TYPE_UNKNOWN;
        }
    }

    @JvmStatic
    public static final TeamChatType fromValue(int r1) {
        Companion.getClass();
        return b.a(r1);
    }

    public static EnumEntries<TeamChatType> getEntries() {
        return b;
    }

    static {
        final TeamChatType r0 = new TeamChatType("TEAM_CHAT_TYPE_UNKNOWN", 0, 0);
        TEAM_CHAT_TYPE_UNKNOWN = r0;
        TeamChatType r1 = new TeamChatType("TEAM_CHAT_TYPE_DEFAULT", 1, 1);
        TEAM_CHAT_TYPE_DEFAULT = r1;
        TeamChatType r3 = new TeamChatType("TEAM_CHAT_TYPE_PUBLIC", 2, 2);
        TEAM_CHAT_TYPE_PUBLIC = r3;
        TeamChatType r5 = new TeamChatType("TEAM_CHAT_TYPE_PRIVATE", 3, 3);
        TEAM_CHAT_TYPE_PRIVATE = r5;
        TeamChatType r7 = new TeamChatType("TEAM_CHAT_TYPE_OPEN", 4, 4);
        TEAM_CHAT_TYPE_OPEN = r7;
        TeamChatType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(TeamChatType.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static TeamChatType[] values() {
        return (TeamChatType[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    public static TeamChatType valueOf(String r1) {
        return (TeamChatType) r27.a.a(TeamChatType.class, r1);
    }

    public TeamChatType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

package com.ss.android.lark.team.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/team/entity/TeamMemberType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "CHATTER", "CHAT", "team-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TeamMemberType extends Enum<TeamMemberType> {
    public static final TeamMemberType CHAT = null;
    public static final TeamMemberType CHATTER = null;
    public static final TeamMemberType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TeamMemberType[] f441181a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441182b = null;

    public static EnumEntries<TeamMemberType> getEntries() {
        return f441182b;
    }

    static {
        TeamMemberType r100 = new TeamMemberType("UNKNOWN", 0);
        UNKNOWN = r100;
        TeamMemberType r101 = new TeamMemberType("CHATTER", 1);
        CHATTER = r101;
        TeamMemberType r102 = new TeamMemberType("CHAT", 2);
        CHAT = r102;
        TeamMemberType[] r103 = {r100, r101, r102};
        f441181a = r103;
        f441182b = EnumEntriesKt.enumEntries(r103);
    }

    public static TeamMemberType[] values() {
        return (TeamMemberType[]) f441181a.clone();
    }

    public static TeamMemberType valueOf(String r100) {
        return (TeamMemberType) a.a(TeamMemberType.class, r100);
    }

    public TeamMemberType(String r100, int r101) {
        super(r100, r101);
    }
}

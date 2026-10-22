package com.ss.android.lark.team.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/team/entity/TeamRole;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "OWNER", "ADMIN", "Companion", "team-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TeamRole extends Enum<TeamRole> {
    public static final TeamRole ADMIN = null;
    public static final a Companion = null;
    public static final TeamRole OWNER = null;
    public static final TeamRole UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TeamRole[] f441183a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441184b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<TeamRole> getEntries() {
        return f441184b;
    }

    static {
        TeamRole r100 = new TeamRole("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        TeamRole r101 = new TeamRole("OWNER", 1, 1);
        OWNER = r101;
        TeamRole r102 = new TeamRole("ADMIN", 2, 2);
        ADMIN = r102;
        TeamRole[] r103 = {r100, r101, r102};
        f441183a = r103;
        f441184b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static TeamRole[] values() {
        return (TeamRole[]) f441183a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TeamRole valueOf(String r100) {
        return (TeamRole) r27.a.a(TeamRole.class, r100);
    }

    public TeamRole(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

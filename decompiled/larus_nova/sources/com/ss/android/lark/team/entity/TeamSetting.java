package com.ss.android.lark.team.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0004\u001c\u001d\u001e\u001fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/ss/android/lark/team/entity/TeamSetting;", "Ljava/io/Serializable;", "addMemberPermission", "Lcom/ss/android/lark/team/entity/TeamSetting$AddMemberPermission;", "addTeamChatPermission", "Lcom/ss/android/lark/team/entity/TeamSetting$AddTeamChatPermission;", "addPrivateTeamChatPermission", "Lcom/ss/android/lark/team/entity/TeamSetting$AddPrivateTeamChatPermission;", "<init>", "(Lcom/ss/android/lark/team/entity/TeamSetting$AddMemberPermission;Lcom/ss/android/lark/team/entity/TeamSetting$AddTeamChatPermission;Lcom/ss/android/lark/team/entity/TeamSetting$AddPrivateTeamChatPermission;)V", "getAddMemberPermission", "()Lcom/ss/android/lark/team/entity/TeamSetting$AddMemberPermission;", "getAddTeamChatPermission", "()Lcom/ss/android/lark/team/entity/TeamSetting$AddTeamChatPermission;", "getAddPrivateTeamChatPermission", "()Lcom/ss/android/lark/team/entity/TeamSetting$AddPrivateTeamChatPermission;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "AddMemberPermission", "AddTeamChatPermission", "AddPrivateTeamChatPermission", "Companion", "team-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TeamSetting implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 8260886629718982206L;
    private final AddMemberPermission addMemberPermission;
    private final AddPrivateTeamChatPermission addPrivateTeamChatPermission;
    private final AddTeamChatPermission addTeamChatPermission;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/team/entity/TeamSetting$AddMemberPermission;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_OWNER", "Companion", "team-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AddMemberPermission extends Enum<AddMemberPermission> {
        public static final AddMemberPermission ALL_MEMBERS = null;
        public static final a Companion = null;
        public static final AddMemberPermission ONLY_OWNER = null;
        public static final AddMemberPermission UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AddMemberPermission[] f441185a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f441186b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<AddMemberPermission> getEntries() {
            return f441186b;
        }

        static {
            AddMemberPermission r100 = new AddMemberPermission("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            AddMemberPermission r101 = new AddMemberPermission("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r101;
            AddMemberPermission r102 = new AddMemberPermission("ONLY_OWNER", 2, 2);
            ONLY_OWNER = r102;
            AddMemberPermission[] r103 = {r100, r101, r102};
            f441185a = r103;
            f441186b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static AddMemberPermission[] values() {
            return (AddMemberPermission[]) f441185a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static AddMemberPermission valueOf(String r100) {
            return (AddMemberPermission) r27.a.a(AddMemberPermission.class, r100);
        }

        public AddMemberPermission(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/team/entity/TeamSetting$AddPrivateTeamChatPermission;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "team-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AddPrivateTeamChatPermission extends Enum<AddPrivateTeamChatPermission> {
        public static final AddPrivateTeamChatPermission ALL_MEMBERS = null;
        public static final a Companion = null;
        public static final AddPrivateTeamChatPermission ONLY_MANAGER = null;
        public static final AddPrivateTeamChatPermission UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AddPrivateTeamChatPermission[] f441187a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f441188b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<AddPrivateTeamChatPermission> getEntries() {
            return f441188b;
        }

        static {
            AddPrivateTeamChatPermission r100 = new AddPrivateTeamChatPermission("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            AddPrivateTeamChatPermission r101 = new AddPrivateTeamChatPermission("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r101;
            AddPrivateTeamChatPermission r102 = new AddPrivateTeamChatPermission("ONLY_MANAGER", 2, 2);
            ONLY_MANAGER = r102;
            AddPrivateTeamChatPermission[] r103 = {r100, r101, r102};
            f441187a = r103;
            f441188b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static AddPrivateTeamChatPermission[] values() {
            return (AddPrivateTeamChatPermission[]) f441187a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static AddPrivateTeamChatPermission valueOf(String r100) {
            return (AddPrivateTeamChatPermission) r27.a.a(AddPrivateTeamChatPermission.class, r100);
        }

        public AddPrivateTeamChatPermission(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/team/entity/TeamSetting$AddTeamChatPermission;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALL_MEMBERS", "ONLY_MANAGER", "Companion", "team-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AddTeamChatPermission extends Enum<AddTeamChatPermission> {
        public static final AddTeamChatPermission ALL_MEMBERS = null;
        public static final a Companion = null;
        public static final AddTeamChatPermission ONLY_MANAGER = null;
        public static final AddTeamChatPermission UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AddTeamChatPermission[] f441189a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f441190b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<AddTeamChatPermission> getEntries() {
            return f441190b;
        }

        static {
            AddTeamChatPermission r100 = new AddTeamChatPermission("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            AddTeamChatPermission r101 = new AddTeamChatPermission("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r101;
            AddTeamChatPermission r102 = new AddTeamChatPermission("ONLY_MANAGER", 2, 2);
            ONLY_MANAGER = r102;
            AddTeamChatPermission[] r103 = {r100, r101, r102};
            f441189a = r103;
            f441190b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static AddTeamChatPermission[] values() {
            return (AddTeamChatPermission[]) f441189a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static AddTeamChatPermission valueOf(String r100) {
            return (AddTeamChatPermission) r27.a.a(AddTeamChatPermission.class, r100);
        }

        public AddTeamChatPermission(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ TeamSetting copy$default(TeamSetting r100, AddMemberPermission r101, AddTeamChatPermission r102, AddPrivateTeamChatPermission r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.addMemberPermission;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.addTeamChatPermission;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.addPrivateTeamChatPermission;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final AddMemberPermission component1() {
        return this.addMemberPermission;
    }

    public final AddTeamChatPermission component2() {
        return this.addTeamChatPermission;
    }

    public final AddPrivateTeamChatPermission component3() {
        return this.addPrivateTeamChatPermission;
    }

    public final TeamSetting copy(AddMemberPermission r100, AddTeamChatPermission r101, AddPrivateTeamChatPermission r102) {
        Intrinsics.checkNotNullParameter(r100, "addMemberPermission");
        Intrinsics.checkNotNullParameter(r101, "addTeamChatPermission");
        Intrinsics.checkNotNullParameter(r102, "addPrivateTeamChatPermission");
        return new TeamSetting(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TeamSetting) == true) goto L8;
        return false;
    L8:
        TeamSetting r101 = (TeamSetting) r100;
        if (this.addMemberPermission == r101.addMemberPermission) goto L12;
        return false;
    L12:
        if (this.addTeamChatPermission == r101.addTeamChatPermission) goto L15;
        return false;
    L15:
        if (this.addPrivateTeamChatPermission == r101.addPrivateTeamChatPermission) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.addMemberPermission.hashCode() * 31) + this.addTeamChatPermission.hashCode()) * 31) + this.addPrivateTeamChatPermission.hashCode();
    }

    public String toString() {
        return "TeamSetting(addMemberPermission=" + this.addMemberPermission + ", addTeamChatPermission=" + this.addTeamChatPermission + ", addPrivateTeamChatPermission=" + this.addPrivateTeamChatPermission + ')';
    }

    public final AddMemberPermission getAddMemberPermission() {
        return this.addMemberPermission;
    }

    public final AddPrivateTeamChatPermission getAddPrivateTeamChatPermission() {
        return this.addPrivateTeamChatPermission;
    }

    public final AddTeamChatPermission getAddTeamChatPermission() {
        return this.addTeamChatPermission;
    }

    public TeamSetting(AddMemberPermission r100, AddTeamChatPermission r101, AddPrivateTeamChatPermission r102) {
        Intrinsics.checkNotNullParameter(r100, "addMemberPermission");
        Intrinsics.checkNotNullParameter(r101, "addTeamChatPermission");
        Intrinsics.checkNotNullParameter(r102, "addPrivateTeamChatPermission");
        this.addMemberPermission = r100;
        this.addTeamChatPermission = r101;
        this.addPrivateTeamChatPermission = r102;
    }
}

package com.ss.android.lark.team.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u00016Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013B\t\b\u0016¢\u0006\u0004\b\u0012\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0011HÆ\u0003Jw\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\fHÖ\u0001J\t\u00105\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00067"}, d2 = {"Lcom/ss/android/lark/team/entity/Team;", "Ljava/io/Serializable;", "id", "", "name", "", "description", "avatarKey", "status", "Lcom/ss/android/lark/team/entity/Team$Status;", "ownerId", "memberCount", "", "version", "teamSetting", "Lcom/ss/android/lark/team/entity/TeamSetting;", "teamUserEntity", "Lcom/ss/android/lark/team/entity/TeamUserEntity;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/team/entity/Team$Status;JIJLcom/ss/android/lark/team/entity/TeamSetting;Lcom/ss/android/lark/team/entity/TeamUserEntity;)V", "()V", "getId", "()J", "getName", "()Ljava/lang/String;", "getDescription", "getAvatarKey", "getStatus", "()Lcom/ss/android/lark/team/entity/Team$Status;", "getOwnerId", "getMemberCount", "()I", "getVersion", "getTeamSetting", "()Lcom/ss/android/lark/team/entity/TeamSetting;", "getTeamUserEntity", "()Lcom/ss/android/lark/team/entity/TeamUserEntity;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "", "hashCode", "toString", "Status", "team-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Team implements Serializable {
    private final String avatarKey;
    private final String description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f441178id;
    private final int memberCount;
    private final String name;
    private final long ownerId;
    private final Status status;
    private final TeamSetting teamSetting;
    private final TeamUserEntity teamUserEntity;
    private final long version;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/team/entity/Team$Status;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ACTIVE", "DISSOLVED", "Companion", "team-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        public static final Status ACTIVE = null;
        public static final a Companion = null;
        public static final Status DISSOLVED = null;
        public static final Status UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f441179a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f441180b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Status> getEntries() {
            return f441180b;
        }

        static {
            Status r100 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Status r101 = new Status("ACTIVE", 1, 1);
            ACTIVE = r101;
            Status r102 = new Status("DISSOLVED", 2, 2);
            DISSOLVED = r102;
            Status[] r103 = {r100, r101, r102};
            f441179a = r103;
            f441180b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static Status[] values() {
            return (Status[]) f441179a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static /* synthetic */ Team copy$default(Team r110, long r111, String r112, String r113, String r114, Status r210, long r211, int r212, long r213, TeamSetting r214, TeamUserEntity r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        long r100 = r110.f441178id;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.description;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.avatarKey;
    L19:
        if ((r216 & 16) == 0) goto L21;
        Status r104 = r110.status;
    L23:
        if ((r216 & 32) == 0) goto L25;
        long r105 = r110.ownerId;
    L27:
        if ((r216 & 64) == 0) goto L29;
        int r115 = r110.memberCount;
    L31:
        if ((r216 & 128) == 0) goto L33;
        long r116 = r110.version;
    L35:
        if ((r216 & 256) == 0) goto L37;
        TeamSetting r117 = r110.teamSetting;
    L39:
        if ((r216 & 512) == 0) goto L41;
        TeamUserEntity r106 = r110.teamUserEntity;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r115, r116, r117, r106);
    L41:
        r106 = r215;
        goto L43
    L37:
        r117 = r214;
        goto L39
    L33:
        r116 = r213;
        goto L35
    L29:
        r115 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.f441178id;
    }

    public final TeamUserEntity component10() {
        return this.teamUserEntity;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.avatarKey;
    }

    public final Status component5() {
        return this.status;
    }

    public final long component6() {
        return this.ownerId;
    }

    public final int component7() {
        return this.memberCount;
    }

    public final long component8() {
        return this.version;
    }

    public final TeamSetting component9() {
        return this.teamSetting;
    }

    public final Team copy(long r110, String r111, String r112, String r210, Status r211, long r212, int r213, long r214, TeamSetting r215, TeamUserEntity r216) {
        Intrinsics.checkNotNullParameter(r111, "name");
        return new Team(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Team) == true) goto L8;
        return false;
    L8:
        Team r101 = (Team) r100;
        if (this.f441178id == r101.f441178id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.avatarKey, r101.avatarKey) == true) goto L21;
        return false;
    L21:
        if (this.status == r101.status) goto L24;
        return false;
    L24:
        if (this.ownerId == r101.ownerId) goto L27;
        return false;
    L27:
        if (this.memberCount == r101.memberCount) goto L30;
        return false;
    L30:
        if (this.version == r101.version) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.teamSetting, r101.teamSetting) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.teamUserEntity, r101.teamUserEntity) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        long r100 = this.f441178id;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.name.hashCode()) * 31;
        String r102 = this.description;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.avatarKey;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        Status r109 = this.status;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        long r111 = this.ownerId;
        int r112 = (((((r108 + r110) * 31) + ((int) (r111 ^ (r111 >>> 32)))) * 31) + this.memberCount) * 31;
        long r113 = this.version;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        TeamSetting r115 = this.teamSetting;
        if (r115 != null) goto L17;
        int r116 = 0;
    L18:
        int r117 = (r114 + r116) * 31;
        TeamUserEntity r118 = this.teamUserEntity;
        if (r118 == null) goto L23;
        r103 = r118.hashCode();
    L23:
        return r117 + r103;
    L17:
        r116 = r115.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "Team(id=" + this.f441178id + ", name=" + this.name + ", description=" + this.description + ", avatarKey=" + this.avatarKey + ", status=" + this.status + ", ownerId=" + this.ownerId + ", memberCount=" + this.memberCount + ", version=" + this.version + ", teamSetting=" + this.teamSetting + ", teamUserEntity=" + this.teamUserEntity + ')';
    }

    public Team() {
        this(0, "", null, null, null, 0, 0, 0, null, null);
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getDescription() {
        return this.description;
    }

    public final long getId() {
        return this.f441178id;
    }

    public final int getMemberCount() {
        return this.memberCount;
    }

    public final String getName() {
        return this.name;
    }

    public final long getOwnerId() {
        return this.ownerId;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final TeamSetting getTeamSetting() {
        return this.teamSetting;
    }

    public final TeamUserEntity getTeamUserEntity() {
        return this.teamUserEntity;
    }

    public final long getVersion() {
        return this.version;
    }

    public Team(long r100, String r101, String r102, String r103, Status r104, long r105, int r110, long r111, TeamSetting r112, TeamUserEntity r113) {
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f441178id = r100;
        this.name = r101;
        this.description = r102;
        this.avatarKey = r103;
        this.status = r104;
        this.ownerId = r105;
        this.memberCount = r110;
        this.version = r111;
        this.teamSetting = r112;
        this.teamUserEntity = r113;
    }
}

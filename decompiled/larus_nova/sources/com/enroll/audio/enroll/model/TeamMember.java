package com.enroll.audio.enroll.model;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/enroll/audio/enroll/model/TeamMember;", "", "order", "", "<init>", "(Ljava/lang/String;II)V", "getOrder", "()I", AccountType.ALL, "TITLE", "UPPER", "MIDDLE", "LOWER", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TeamMember extends Enum<TeamMember> {
    public static final TeamMember ALL = null;
    public static final a Companion = null;
    public static final TeamMember LOWER = null;
    public static final TeamMember MIDDLE = null;
    public static final TeamMember TITLE = null;
    public static final TeamMember UPPER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TeamMember[] f273733a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f273734b = null;
    private final int order;

    public static final class a {
        public a() {
        }

        public static TeamMember a(int r100) {
            TeamMember[] r101 = TeamMember.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            TeamMember r104 = r101[r103];
            if (r104.getOrder() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return TeamMember.ALL;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    public static EnumEntries<TeamMember> getEntries() {
        return f273734b;
    }

    static {
        TeamMember r100 = new TeamMember(AccountType.ALL, 0, -1);
        ALL = r100;
        TeamMember r101 = new TeamMember("TITLE", 1, 0);
        TITLE = r101;
        TeamMember r102 = new TeamMember("UPPER", 2, 1);
        UPPER = r102;
        TeamMember r103 = new TeamMember("MIDDLE", 3, 2);
        MIDDLE = r103;
        TeamMember r104 = new TeamMember("LOWER", 4, 3);
        LOWER = r104;
        TeamMember[] r105 = {r100, r101, r102, r103, r104};
        f273733a = r105;
        f273734b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static TeamMember[] values() {
        return (TeamMember[]) f273733a.clone();
    }

    public final int getOrder() {
        return this.order;
    }

    public static TeamMember valueOf(String r100) {
        return (TeamMember) r27.a.a(TeamMember.class, r100);
    }

    public TeamMember(String r100, int r101, int r102) {
        super(r100, r101);
        this.order = r102;
    }
}

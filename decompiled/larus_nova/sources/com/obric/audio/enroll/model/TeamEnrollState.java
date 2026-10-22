package com.obric.audio.enroll.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/audio/enroll/model/TeamEnrollState;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_START", "BORN", "ENROLLING", "OVERSIZE", "CHECKING_SIMILARITY", "SIMILARITY_FAIL", "SIMILARITY_PASS", "CHECKING_ENROLL", "ENROLL_MATCHED", "ENROLL_NOT_MATCHED_COMMON_ERROR", "ENROLL_NOT_MATCHED_NETWORK_ERROR", "TIMEOUT", "DONE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TeamEnrollState extends Enum<TeamEnrollState> {
    public static final TeamEnrollState BORN = null;
    public static final TeamEnrollState CHECKING_ENROLL = null;
    public static final TeamEnrollState CHECKING_SIMILARITY = null;
    public static final TeamEnrollState DONE = null;
    public static final TeamEnrollState ENROLLING = null;
    public static final TeamEnrollState ENROLL_MATCHED = null;
    public static final TeamEnrollState ENROLL_NOT_MATCHED_COMMON_ERROR = null;
    public static final TeamEnrollState ENROLL_NOT_MATCHED_NETWORK_ERROR = null;
    public static final TeamEnrollState NOT_START = null;
    public static final TeamEnrollState OVERSIZE = null;
    public static final TeamEnrollState SIMILARITY_FAIL = null;
    public static final TeamEnrollState SIMILARITY_PASS = null;
    public static final TeamEnrollState TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TeamEnrollState[] f395449a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f395450b = null;

    public static EnumEntries<TeamEnrollState> getEntries() {
        return f395450b;
    }

    static {
        TeamEnrollState r100 = new TeamEnrollState("NOT_START", 0);
        NOT_START = r100;
        TeamEnrollState r101 = new TeamEnrollState("BORN", 1);
        BORN = r101;
        TeamEnrollState r102 = new TeamEnrollState("ENROLLING", 2);
        ENROLLING = r102;
        TeamEnrollState r103 = new TeamEnrollState("OVERSIZE", 3);
        OVERSIZE = r103;
        TeamEnrollState r104 = new TeamEnrollState("CHECKING_SIMILARITY", 4);
        CHECKING_SIMILARITY = r104;
        TeamEnrollState r105 = new TeamEnrollState("SIMILARITY_FAIL", 5);
        SIMILARITY_FAIL = r105;
        TeamEnrollState r110 = new TeamEnrollState("SIMILARITY_PASS", 6);
        SIMILARITY_PASS = r110;
        TeamEnrollState r111 = new TeamEnrollState("CHECKING_ENROLL", 7);
        CHECKING_ENROLL = r111;
        TeamEnrollState r112 = new TeamEnrollState("ENROLL_MATCHED", 8);
        ENROLL_MATCHED = r112;
        TeamEnrollState r113 = new TeamEnrollState("ENROLL_NOT_MATCHED_COMMON_ERROR", 9);
        ENROLL_NOT_MATCHED_COMMON_ERROR = r113;
        TeamEnrollState r114 = new TeamEnrollState("ENROLL_NOT_MATCHED_NETWORK_ERROR", 10);
        ENROLL_NOT_MATCHED_NETWORK_ERROR = r114;
        TeamEnrollState r115 = new TeamEnrollState("TIMEOUT", 11);
        TIMEOUT = r115;
        TeamEnrollState r106 = new TeamEnrollState("DONE", 12);
        DONE = r106;
        TeamEnrollState[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        f395449a = r107;
        f395450b = EnumEntriesKt.enumEntries(r107);
    }

    public static TeamEnrollState[] values() {
        return (TeamEnrollState[]) f395449a.clone();
    }

    public static TeamEnrollState valueOf(String r100) {
        return (TeamEnrollState) a.a(TeamEnrollState.class, r100);
    }

    public TeamEnrollState(String r100, int r101) {
        super(r100, r101);
    }
}

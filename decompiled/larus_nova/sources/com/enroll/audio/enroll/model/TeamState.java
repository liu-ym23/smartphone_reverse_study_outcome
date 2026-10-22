package com.enroll.audio.enroll.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/enroll/audio/enroll/model/TeamState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "CANDIDATE", "ONSTAGE", "DONE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TeamState extends Enum<TeamState> {
    public static final TeamState CANDIDATE = null;
    public static final TeamState DONE = null;
    public static final TeamState NA = null;
    public static final TeamState ONSTAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TeamState[] f273735a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f273736b = null;

    public static EnumEntries<TeamState> getEntries() {
        return f273736b;
    }

    static {
        TeamState r100 = new TeamState("NA", 0);
        NA = r100;
        TeamState r101 = new TeamState("CANDIDATE", 1);
        CANDIDATE = r101;
        TeamState r102 = new TeamState("ONSTAGE", 2);
        ONSTAGE = r102;
        TeamState r103 = new TeamState("DONE", 3);
        DONE = r103;
        TeamState[] r104 = {r100, r101, r102, r103};
        f273735a = r104;
        f273736b = EnumEntriesKt.enumEntries(r104);
    }

    public static TeamState[] values() {
        return (TeamState[]) f273735a.clone();
    }

    public static TeamState valueOf(String r100) {
        return (TeamState) a.a(TeamState.class, r100);
    }

    public TeamState(String r100, int r101) {
        super(r100, r101);
    }
}

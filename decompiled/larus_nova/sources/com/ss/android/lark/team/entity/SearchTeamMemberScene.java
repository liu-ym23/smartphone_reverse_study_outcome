package com.ss.android.lark.team.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/team/entity/SearchTeamMemberScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TRANSFER_TEAM", "TEAM_MEMBER", "team-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SearchTeamMemberScene extends Enum<SearchTeamMemberScene> {
    public static final SearchTeamMemberScene TEAM_MEMBER = null;
    public static final SearchTeamMemberScene TRANSFER_TEAM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchTeamMemberScene[] f441176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441177b = null;
    private final int value;

    public static EnumEntries<SearchTeamMemberScene> getEntries() {
        return f441177b;
    }

    static {
        SearchTeamMemberScene r100 = new SearchTeamMemberScene("TRANSFER_TEAM", 0, 1);
        TRANSFER_TEAM = r100;
        SearchTeamMemberScene r101 = new SearchTeamMemberScene("TEAM_MEMBER", 1, 2);
        TEAM_MEMBER = r101;
        SearchTeamMemberScene[] r102 = {r100, r101};
        f441176a = r102;
        f441177b = EnumEntriesKt.enumEntries(r102);
    }

    public static SearchTeamMemberScene[] values() {
        return (SearchTeamMemberScene[]) f441176a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SearchTeamMemberScene valueOf(String r100) {
        return (SearchTeamMemberScene) a.a(SearchTeamMemberScene.class, r100);
    }

    public SearchTeamMemberScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

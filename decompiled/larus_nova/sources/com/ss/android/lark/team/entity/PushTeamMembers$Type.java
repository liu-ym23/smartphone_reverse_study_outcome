package com.ss.android.lark.team.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/team/entity/PushTeamMembers$Type;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ADD_CHATTER", "DELETE_CHATTER", "UPDATE_CHATTER", "Companion", "team-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PushTeamMembers$Type extends Enum<PushTeamMembers$Type> {
    public static final PushTeamMembers$Type ADD_CHATTER = null;
    public static final a Companion = null;
    public static final PushTeamMembers$Type DELETE_CHATTER = null;
    public static final PushTeamMembers$Type UPDATE_CHATTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PushTeamMembers$Type[] f441174a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441175b = null;
    private final int value;

    public static EnumEntries<PushTeamMembers$Type> getEntries() {
        return f441175b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.team.entity.PushTeamMembers$Type$a] */
    static {
        PushTeamMembers$Type r100 = new PushTeamMembers$Type("ADD_CHATTER", 0, 1);
        ADD_CHATTER = r100;
        PushTeamMembers$Type r101 = new PushTeamMembers$Type("DELETE_CHATTER", 1, 2);
        DELETE_CHATTER = r101;
        PushTeamMembers$Type r102 = new PushTeamMembers$Type("UPDATE_CHATTER", 2, 3);
        UPDATE_CHATTER = r102;
        PushTeamMembers$Type[] r103 = {r100, r101, r102};
        f441174a = r103;
        f441175b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static PushTeamMembers$Type[] values() {
        return (PushTeamMembers$Type[]) f441174a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PushTeamMembers$Type valueOf(String r100) {
        return (PushTeamMembers$Type) r27.a.a(PushTeamMembers$Type.class, r100);
    }

    public PushTeamMembers$Type(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

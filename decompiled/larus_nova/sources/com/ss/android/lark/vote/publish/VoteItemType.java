package com.ss.android.lark.vote.publish;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/vote/publish/VoteItemType;", "", "<init>", "(Ljava/lang/String;I)V", "TOPIC", "OPTION", "ADD", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoteItemType extends Enum<VoteItemType> {
    public static final VoteItemType ADD = null;
    public static final VoteItemType OPTION = null;
    public static final VoteItemType TOPIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoteItemType[] f445282a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f445283b = null;

    public static EnumEntries<VoteItemType> getEntries() {
        return f445283b;
    }

    static {
        VoteItemType r100 = new VoteItemType("TOPIC", 0);
        TOPIC = r100;
        VoteItemType r101 = new VoteItemType("OPTION", 1);
        OPTION = r101;
        VoteItemType r102 = new VoteItemType("ADD", 2);
        ADD = r102;
        VoteItemType[] r103 = {r100, r101, r102};
        f445282a = r103;
        f445283b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoteItemType[] values() {
        return (VoteItemType[]) f445282a.clone();
    }

    public static VoteItemType valueOf(String r100) {
        return (VoteItemType) r27.a.a(VoteItemType.class, r100);
    }

    public VoteItemType(String r100, int r101) {
        super(r100, r101);
    }
}

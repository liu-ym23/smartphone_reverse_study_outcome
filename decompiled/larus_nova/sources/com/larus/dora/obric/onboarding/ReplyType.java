package com.larus.dora.obric.onboarding;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/obric/onboarding/ReplyType;", "", "<init>", "(Ljava/lang/String;I)V", "FINISH", "ANSWER", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReplyType extends Enum<ReplyType> {
    public static final ReplyType ANSWER = null;
    public static final ReplyType FINISH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplyType[] f340812a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f340813b = null;

    public static EnumEntries<ReplyType> getEntries() {
        return f340813b;
    }

    static {
        ReplyType r100 = new ReplyType("FINISH", 0);
        FINISH = r100;
        ReplyType r101 = new ReplyType("ANSWER", 1);
        ANSWER = r101;
        ReplyType[] r102 = {r100, r101};
        f340812a = r102;
        f340813b = EnumEntriesKt.enumEntries(r102);
    }

    public static ReplyType[] values() {
        return (ReplyType[]) f340812a.clone();
    }

    public static ReplyType valueOf(String r100) {
        return (ReplyType) r27.a.a(ReplyType.class, r100);
    }

    public ReplyType(String r100, int r101) {
        super(r100, r101);
    }
}

package com.larus.bmhome.chat.cotdetail.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/ability/CotDetailPageState;", "", "<init>", "(Ljava/lang/String;I)V", "Loading", "Failed", "Success", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CotDetailPageState extends Enum<CotDetailPageState> {
    public static final CotDetailPageState Failed = null;
    public static final CotDetailPageState Loading = null;
    public static final CotDetailPageState Success = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CotDetailPageState[] f301891a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f301892b = null;

    public static EnumEntries<CotDetailPageState> getEntries() {
        return f301892b;
    }

    static {
        CotDetailPageState r100 = new CotDetailPageState("Loading", 0);
        Loading = r100;
        CotDetailPageState r101 = new CotDetailPageState("Failed", 1);
        Failed = r101;
        CotDetailPageState r102 = new CotDetailPageState("Success", 2);
        Success = r102;
        CotDetailPageState[] r103 = {r100, r101, r102};
        f301891a = r103;
        f301892b = EnumEntriesKt.enumEntries(r103);
    }

    public static CotDetailPageState[] values() {
        return (CotDetailPageState[]) f301891a.clone();
    }

    public static CotDetailPageState valueOf(String r100) {
        return (CotDetailPageState) a.a(CotDetailPageState.class, r100);
    }

    public CotDetailPageState(String r100, int r101) {
        super(r100, r101);
    }
}

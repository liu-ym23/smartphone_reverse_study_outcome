package com.larus.bmhome.chat.bubble.floating;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/ReachSpacerState;", "", "<init>", "(Ljava/lang/String;I)V", "WAITING", "ENTERING", "VISIBLE", "EXITING", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReachSpacerState extends Enum<ReachSpacerState> {
    public static final ReachSpacerState ENTERING = null;
    public static final ReachSpacerState EXITING = null;
    public static final ReachSpacerState VISIBLE = null;
    public static final ReachSpacerState WAITING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReachSpacerState[] f297478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297479b = null;

    public static EnumEntries<ReachSpacerState> getEntries() {
        return f297479b;
    }

    static {
        ReachSpacerState r100 = new ReachSpacerState("WAITING", 0);
        WAITING = r100;
        ReachSpacerState r101 = new ReachSpacerState("ENTERING", 1);
        ENTERING = r101;
        ReachSpacerState r102 = new ReachSpacerState("VISIBLE", 2);
        VISIBLE = r102;
        ReachSpacerState r103 = new ReachSpacerState("EXITING", 3);
        EXITING = r103;
        ReachSpacerState[] r104 = {r100, r101, r102, r103};
        f297478a = r104;
        f297479b = EnumEntriesKt.enumEntries(r104);
    }

    public static ReachSpacerState[] values() {
        return (ReachSpacerState[]) f297478a.clone();
    }

    public static ReachSpacerState valueOf(String r100) {
        return (ReachSpacerState) r27.a.a(ReachSpacerState.class, r100);
    }

    public ReachSpacerState(String r100, int r101) {
        super(r100, r101);
    }
}

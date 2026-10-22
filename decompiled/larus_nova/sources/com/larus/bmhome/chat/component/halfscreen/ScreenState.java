package com.larus.bmhome.chat.component.halfscreen;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/component/halfscreen/ScreenState;", "", "<init>", "(Ljava/lang/String;I)V", "UNINITIALIZED", "HALF", "FULL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ScreenState extends Enum<ScreenState> {
    public static final ScreenState FULL = null;
    public static final ScreenState HALF = null;
    public static final ScreenState UNINITIALIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScreenState[] f300772a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f300773b = null;

    public static EnumEntries<ScreenState> getEntries() {
        return f300773b;
    }

    static {
        ScreenState r100 = new ScreenState("UNINITIALIZED", 0);
        UNINITIALIZED = r100;
        ScreenState r101 = new ScreenState("HALF", 1);
        HALF = r101;
        ScreenState r102 = new ScreenState("FULL", 2);
        FULL = r102;
        ScreenState[] r103 = {r100, r101, r102};
        f300772a = r103;
        f300773b = EnumEntriesKt.enumEntries(r103);
    }

    public static ScreenState[] values() {
        return (ScreenState[]) f300772a.clone();
    }

    public static ScreenState valueOf(String r100) {
        return (ScreenState) r27.a.a(ScreenState.class, r100);
    }

    public ScreenState(String r100, int r101) {
        super(r100, r101);
    }
}

package com.obric.assistant.live.oenum;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/live/oenum/ObricActivityVisibleState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "VISIBLE", "INVISIBLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricActivityVisibleState extends Enum<ObricActivityVisibleState> {
    public static final ObricActivityVisibleState INVISIBLE = null;
    public static final ObricActivityVisibleState NA = null;
    public static final ObricActivityVisibleState VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricActivityVisibleState[] f390156a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f390157b = null;

    public static EnumEntries<ObricActivityVisibleState> getEntries() {
        return f390157b;
    }

    static {
        ObricActivityVisibleState r100 = new ObricActivityVisibleState("NA", 0);
        NA = r100;
        ObricActivityVisibleState r101 = new ObricActivityVisibleState("VISIBLE", 1);
        VISIBLE = r101;
        ObricActivityVisibleState r102 = new ObricActivityVisibleState("INVISIBLE", 2);
        INVISIBLE = r102;
        ObricActivityVisibleState[] r103 = {r100, r101, r102};
        f390156a = r103;
        f390157b = EnumEntriesKt.enumEntries(r103);
    }

    public static ObricActivityVisibleState[] values() {
        return (ObricActivityVisibleState[]) f390156a.clone();
    }

    public static ObricActivityVisibleState valueOf(String r100) {
        return (ObricActivityVisibleState) a.a(ObricActivityVisibleState.class, r100);
    }

    public ObricActivityVisibleState(String r100, int r101) {
        super(r100, r101);
    }
}

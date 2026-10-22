package com.larus.bmhome.chat.bubble.floating;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerState;", "", "<init>", "(Ljava/lang/String;I)V", "RECEIVED", "RESOLVED", "ENTERING", "VISIBLE", "EXITING", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BubbleBannerState extends Enum<BubbleBannerState> {
    public static final BubbleBannerState ENTERING = null;
    public static final BubbleBannerState EXITING = null;
    public static final BubbleBannerState RECEIVED = null;
    public static final BubbleBannerState RESOLVED = null;
    public static final BubbleBannerState VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BubbleBannerState[] f297471a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297472b = null;

    public static EnumEntries<BubbleBannerState> getEntries() {
        return f297472b;
    }

    static {
        BubbleBannerState r100 = new BubbleBannerState("RECEIVED", 0);
        RECEIVED = r100;
        BubbleBannerState r101 = new BubbleBannerState("RESOLVED", 1);
        RESOLVED = r101;
        BubbleBannerState r102 = new BubbleBannerState("ENTERING", 2);
        ENTERING = r102;
        BubbleBannerState r103 = new BubbleBannerState("VISIBLE", 3);
        VISIBLE = r103;
        BubbleBannerState r104 = new BubbleBannerState("EXITING", 4);
        EXITING = r104;
        BubbleBannerState[] r105 = {r100, r101, r102, r103, r104};
        f297471a = r105;
        f297472b = EnumEntriesKt.enumEntries(r105);
    }

    public static BubbleBannerState[] values() {
        return (BubbleBannerState[]) f297471a.clone();
    }

    public static BubbleBannerState valueOf(String r100) {
        return (BubbleBannerState) r27.a.a(BubbleBannerState.class, r100);
    }

    public BubbleBannerState(String r100, int r101) {
        super(r100, r101);
    }
}

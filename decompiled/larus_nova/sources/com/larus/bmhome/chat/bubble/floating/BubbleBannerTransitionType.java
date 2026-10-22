package com.larus.bmhome.chat.bubble.floating;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerTransitionType;", "", "<init>", "(Ljava/lang/String;I)V", "ENTER", "EXIT", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BubbleBannerTransitionType extends Enum<BubbleBannerTransitionType> {
    public static final BubbleBannerTransitionType ENTER = null;
    public static final BubbleBannerTransitionType EXIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BubbleBannerTransitionType[] f297476a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297477b = null;

    public static EnumEntries<BubbleBannerTransitionType> getEntries() {
        return f297477b;
    }

    static {
        BubbleBannerTransitionType r100 = new BubbleBannerTransitionType("ENTER", 0);
        ENTER = r100;
        BubbleBannerTransitionType r101 = new BubbleBannerTransitionType("EXIT", 1);
        EXIT = r101;
        BubbleBannerTransitionType[] r102 = {r100, r101};
        f297476a = r102;
        f297477b = EnumEntriesKt.enumEntries(r102);
    }

    public static BubbleBannerTransitionType[] values() {
        return (BubbleBannerTransitionType[]) f297476a.clone();
    }

    public static BubbleBannerTransitionType valueOf(String r100) {
        return (BubbleBannerTransitionType) r27.a.a(BubbleBannerTransitionType.class, r100);
    }

    public BubbleBannerTransitionType(String r100, int r101) {
        super(r100, r101);
    }
}

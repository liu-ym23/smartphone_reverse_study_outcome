package com.larus.bmhome.chat.bubble.floating;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerEnterTrigger;", "", "<init>", "(Ljava/lang/String;I)V", "CONTAINER_READY", "SPACER_READY", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BubbleBannerEnterTrigger extends Enum<BubbleBannerEnterTrigger> {
    public static final BubbleBannerEnterTrigger CONTAINER_READY = null;
    public static final BubbleBannerEnterTrigger SPACER_READY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BubbleBannerEnterTrigger[] f297465a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297466b = null;

    public static EnumEntries<BubbleBannerEnterTrigger> getEntries() {
        return f297466b;
    }

    static {
        BubbleBannerEnterTrigger r100 = new BubbleBannerEnterTrigger("CONTAINER_READY", 0);
        CONTAINER_READY = r100;
        BubbleBannerEnterTrigger r101 = new BubbleBannerEnterTrigger("SPACER_READY", 1);
        SPACER_READY = r101;
        BubbleBannerEnterTrigger[] r102 = {r100, r101};
        f297465a = r102;
        f297466b = EnumEntriesKt.enumEntries(r102);
    }

    public static BubbleBannerEnterTrigger[] values() {
        return (BubbleBannerEnterTrigger[]) f297465a.clone();
    }

    public static BubbleBannerEnterTrigger valueOf(String r100) {
        return (BubbleBannerEnterTrigger) r27.a.a(BubbleBannerEnterTrigger.class, r100);
    }

    public BubbleBannerEnterTrigger(String r100, int r101) {
        super(r100, r101);
    }
}

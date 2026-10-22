package com.larus.bmhome.chat.bubble.floating;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerDismissReason;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO_DISMISS", "USER_CLICK", "MANUAL", "PAGE_LEAVE", "NEW_MESSAGE", "LOWER_PRIORITY", "HOST_UNAVAILABLE", "KEYBOARD", "ACTION_BAR_ITEM_CLICK", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BubbleBannerDismissReason extends Enum<BubbleBannerDismissReason> {
    public static final BubbleBannerDismissReason ACTION_BAR_ITEM_CLICK = null;
    public static final BubbleBannerDismissReason AUTO_DISMISS = null;
    public static final BubbleBannerDismissReason HOST_UNAVAILABLE = null;
    public static final BubbleBannerDismissReason KEYBOARD = null;
    public static final BubbleBannerDismissReason LOWER_PRIORITY = null;
    public static final BubbleBannerDismissReason MANUAL = null;
    public static final BubbleBannerDismissReason NEW_MESSAGE = null;
    public static final BubbleBannerDismissReason PAGE_LEAVE = null;
    public static final BubbleBannerDismissReason USER_CLICK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BubbleBannerDismissReason[] f297463a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297464b = null;

    public static EnumEntries<BubbleBannerDismissReason> getEntries() {
        return f297464b;
    }

    static {
        BubbleBannerDismissReason r100 = new BubbleBannerDismissReason("AUTO_DISMISS", 0);
        AUTO_DISMISS = r100;
        BubbleBannerDismissReason r101 = new BubbleBannerDismissReason("USER_CLICK", 1);
        USER_CLICK = r101;
        BubbleBannerDismissReason r102 = new BubbleBannerDismissReason("MANUAL", 2);
        MANUAL = r102;
        BubbleBannerDismissReason r103 = new BubbleBannerDismissReason("PAGE_LEAVE", 3);
        PAGE_LEAVE = r103;
        BubbleBannerDismissReason r104 = new BubbleBannerDismissReason("NEW_MESSAGE", 4);
        NEW_MESSAGE = r104;
        BubbleBannerDismissReason r105 = new BubbleBannerDismissReason("LOWER_PRIORITY", 5);
        LOWER_PRIORITY = r105;
        BubbleBannerDismissReason r110 = new BubbleBannerDismissReason("HOST_UNAVAILABLE", 6);
        HOST_UNAVAILABLE = r110;
        BubbleBannerDismissReason r111 = new BubbleBannerDismissReason("KEYBOARD", 7);
        KEYBOARD = r111;
        BubbleBannerDismissReason r112 = new BubbleBannerDismissReason("ACTION_BAR_ITEM_CLICK", 8);
        ACTION_BAR_ITEM_CLICK = r112;
        BubbleBannerDismissReason[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f297463a = r113;
        f297464b = EnumEntriesKt.enumEntries(r113);
    }

    public static BubbleBannerDismissReason[] values() {
        return (BubbleBannerDismissReason[]) f297463a.clone();
    }

    public static BubbleBannerDismissReason valueOf(String r100) {
        return (BubbleBannerDismissReason) r27.a.a(BubbleBannerDismissReason.class, r100);
    }

    public BubbleBannerDismissReason(String r100, int r101) {
        super(r100, r101);
    }
}

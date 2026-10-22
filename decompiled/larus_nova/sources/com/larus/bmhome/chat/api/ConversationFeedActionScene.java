package com.larus.bmhome.chat.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/api/ConversationFeedActionScene;", "", "<init>", "(Ljava/lang/String;I)V", "LONG_PRESS_MENU", "LEFT_SWIPE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ConversationFeedActionScene extends Enum<ConversationFeedActionScene> {
    public static final ConversationFeedActionScene LEFT_SWIPE = null;
    public static final ConversationFeedActionScene LONG_PRESS_MENU = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConversationFeedActionScene[] f297154a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297155b = null;

    public static EnumEntries<ConversationFeedActionScene> getEntries() {
        return f297155b;
    }

    static {
        ConversationFeedActionScene r100 = new ConversationFeedActionScene("LONG_PRESS_MENU", 0);
        LONG_PRESS_MENU = r100;
        ConversationFeedActionScene r101 = new ConversationFeedActionScene("LEFT_SWIPE", 1);
        LEFT_SWIPE = r101;
        ConversationFeedActionScene[] r102 = {r100, r101};
        f297154a = r102;
        f297155b = EnumEntriesKt.enumEntries(r102);
    }

    public static ConversationFeedActionScene[] values() {
        return (ConversationFeedActionScene[]) f297154a.clone();
    }

    public static ConversationFeedActionScene valueOf(String r100) {
        return (ConversationFeedActionScene) r27.a.a(ConversationFeedActionScene.class, r100);
    }

    public ConversationFeedActionScene(String r100, int r101) {
        super(r100, r101);
    }
}

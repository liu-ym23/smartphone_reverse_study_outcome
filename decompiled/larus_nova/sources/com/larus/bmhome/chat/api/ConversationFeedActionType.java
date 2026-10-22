package com.larus.bmhome.chat.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/chat/api/ConversationFeedActionType;", "", "<init>", "(Ljava/lang/String;I)V", "REFRESH_RECOMMEND_BOT", "PIN", "UNPIN", "HIDE", "EDIT_NAME", "MOVE_TO_PROJECT", "REMOVE_FROM_PROJECT", "DELETE", "SHARE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ConversationFeedActionType extends Enum<ConversationFeedActionType> {
    public static final ConversationFeedActionType DELETE = null;
    public static final ConversationFeedActionType EDIT_NAME = null;
    public static final ConversationFeedActionType HIDE = null;
    public static final ConversationFeedActionType MOVE_TO_PROJECT = null;
    public static final ConversationFeedActionType PIN = null;
    public static final ConversationFeedActionType REFRESH_RECOMMEND_BOT = null;
    public static final ConversationFeedActionType REMOVE_FROM_PROJECT = null;
    public static final ConversationFeedActionType SHARE = null;
    public static final ConversationFeedActionType UNPIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConversationFeedActionType[] f297158a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297159b = null;

    public static EnumEntries<ConversationFeedActionType> getEntries() {
        return f297159b;
    }

    static {
        ConversationFeedActionType r100 = new ConversationFeedActionType("REFRESH_RECOMMEND_BOT", 0);
        REFRESH_RECOMMEND_BOT = r100;
        ConversationFeedActionType r101 = new ConversationFeedActionType("PIN", 1);
        PIN = r101;
        ConversationFeedActionType r102 = new ConversationFeedActionType("UNPIN", 2);
        UNPIN = r102;
        ConversationFeedActionType r103 = new ConversationFeedActionType("HIDE", 3);
        HIDE = r103;
        ConversationFeedActionType r104 = new ConversationFeedActionType("EDIT_NAME", 4);
        EDIT_NAME = r104;
        ConversationFeedActionType r105 = new ConversationFeedActionType("MOVE_TO_PROJECT", 5);
        MOVE_TO_PROJECT = r105;
        ConversationFeedActionType r110 = new ConversationFeedActionType("REMOVE_FROM_PROJECT", 6);
        REMOVE_FROM_PROJECT = r110;
        ConversationFeedActionType r111 = new ConversationFeedActionType("DELETE", 7);
        DELETE = r111;
        ConversationFeedActionType r112 = new ConversationFeedActionType("SHARE", 8);
        SHARE = r112;
        ConversationFeedActionType[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f297158a = r113;
        f297159b = EnumEntriesKt.enumEntries(r113);
    }

    public static ConversationFeedActionType[] values() {
        return (ConversationFeedActionType[]) f297158a.clone();
    }

    public static ConversationFeedActionType valueOf(String r100) {
        return (ConversationFeedActionType) r27.a.a(ConversationFeedActionType.class, r100);
    }

    public ConversationFeedActionType(String r100, int r101) {
        super(r100, r101);
    }
}

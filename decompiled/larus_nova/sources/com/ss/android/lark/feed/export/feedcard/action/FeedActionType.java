package com.ss.android.lark.feed.export.feedcard.action;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/feed/export/feedcard/action/FeedActionType;", "", "<init>", "(Ljava/lang/String;I)V", "TOPPING", "FLAG_MARK", "ADD_FEED_TAG", "NO_DISTURB", "MOVE_TO_NO_DISTURB", "DONE", "CLEAR_UNREAD", "MARK_UNREAD", "ADD_CHAT_BOX", "REMOVE_FROM_TAG", "DISMISS", "BOT_MUTE", "ATTACH_TEAM", "DELETE", "TOPPING_IN_LIST", "EDIT_NAME", "SHARE", "FLOW_DELETE", "FLOW_TOPPING", "FLOW_HIDE", "FLOW_PROJECT", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedActionType extends Enum<FeedActionType> {
    public static final FeedActionType ADD_CHAT_BOX = null;
    public static final FeedActionType ADD_FEED_TAG = null;
    public static final FeedActionType ATTACH_TEAM = null;
    public static final FeedActionType BOT_MUTE = null;
    public static final FeedActionType CLEAR_UNREAD = null;
    public static final FeedActionType DELETE = null;
    public static final FeedActionType DISMISS = null;
    public static final FeedActionType DONE = null;
    public static final FeedActionType EDIT_NAME = null;
    public static final FeedActionType FLAG_MARK = null;
    public static final FeedActionType FLOW_DELETE = null;
    public static final FeedActionType FLOW_HIDE = null;
    public static final FeedActionType FLOW_PROJECT = null;
    public static final FeedActionType FLOW_TOPPING = null;
    public static final FeedActionType MARK_UNREAD = null;
    public static final FeedActionType MOVE_TO_NO_DISTURB = null;
    public static final FeedActionType NO_DISTURB = null;
    public static final FeedActionType REMOVE_FROM_TAG = null;
    public static final FeedActionType SHARE = null;
    public static final FeedActionType TOPPING = null;
    public static final FeedActionType TOPPING_IN_LIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedActionType[] f421013a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f421014b = null;

    public static EnumEntries<FeedActionType> getEntries() {
        return f421014b;
    }

    static {
        FeedActionType r100 = new FeedActionType("TOPPING", 0);
        TOPPING = r100;
        FeedActionType r101 = new FeedActionType("FLAG_MARK", 1);
        FLAG_MARK = r101;
        FeedActionType r102 = new FeedActionType("ADD_FEED_TAG", 2);
        ADD_FEED_TAG = r102;
        FeedActionType r103 = new FeedActionType("NO_DISTURB", 3);
        NO_DISTURB = r103;
        FeedActionType r104 = new FeedActionType("MOVE_TO_NO_DISTURB", 4);
        MOVE_TO_NO_DISTURB = r104;
        FeedActionType r105 = new FeedActionType("DONE", 5);
        DONE = r105;
        FeedActionType r110 = new FeedActionType("CLEAR_UNREAD", 6);
        CLEAR_UNREAD = r110;
        FeedActionType r111 = new FeedActionType("MARK_UNREAD", 7);
        MARK_UNREAD = r111;
        FeedActionType r112 = new FeedActionType("ADD_CHAT_BOX", 8);
        ADD_CHAT_BOX = r112;
        FeedActionType r113 = new FeedActionType("REMOVE_FROM_TAG", 9);
        REMOVE_FROM_TAG = r113;
        FeedActionType r114 = new FeedActionType("DISMISS", 10);
        DISMISS = r114;
        FeedActionType r115 = new FeedActionType("BOT_MUTE", 11);
        BOT_MUTE = r115;
        FeedActionType r106 = new FeedActionType("ATTACH_TEAM", 12);
        ATTACH_TEAM = r106;
        FeedActionType r107 = new FeedActionType("DELETE", 13);
        DELETE = r107;
        FeedActionType r108 = new FeedActionType("TOPPING_IN_LIST", 14);
        TOPPING_IN_LIST = r108;
        FeedActionType r109 = new FeedActionType("EDIT_NAME", 15);
        EDIT_NAME = r109;
        FeedActionType r116 = new FeedActionType("SHARE", 16);
        SHARE = r116;
        FeedActionType r117 = new FeedActionType("FLOW_DELETE", 17);
        FLOW_DELETE = r117;
        FeedActionType r118 = new FeedActionType("FLOW_TOPPING", 18);
        FLOW_TOPPING = r118;
        FeedActionType r119 = new FeedActionType("FLOW_HIDE", 19);
        FLOW_HIDE = r119;
        FeedActionType r120 = new FeedActionType("FLOW_PROJECT", 20);
        FLOW_PROJECT = r120;
        FeedActionType[] r121 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120};
        f421013a = r121;
        f421014b = EnumEntriesKt.enumEntries(r121);
    }

    public static FeedActionType[] values() {
        return (FeedActionType[]) f421013a.clone();
    }

    public static FeedActionType valueOf(String r100) {
        return (FeedActionType) a.a(FeedActionType.class, r100);
    }

    public FeedActionType(String r100, int r101) {
        super(r100, r101);
    }
}

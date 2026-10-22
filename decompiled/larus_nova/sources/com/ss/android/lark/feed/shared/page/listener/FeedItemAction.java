package com.ss.android.lark.feed.shared.page.listener;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/listener/FeedItemAction;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "ADD_TO_TAG", "REMOVE_FROM_TAG", "CLEAR_UNREAD", "MARK_UNREAD", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedItemAction extends Enum<FeedItemAction> {
    public static final FeedItemAction ADD_TO_TAG = null;
    public static final FeedItemAction CLEAR_UNREAD = null;
    public static final FeedItemAction MARK_UNREAD = null;
    public static final FeedItemAction REMOVE_FROM_TAG = null;
    public static final FeedItemAction UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedItemAction[] f421431a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f421432b = null;

    public static EnumEntries<FeedItemAction> getEntries() {
        return f421432b;
    }

    static {
        FeedItemAction r100 = new FeedItemAction("UNKNOWN", 0);
        UNKNOWN = r100;
        FeedItemAction r101 = new FeedItemAction("ADD_TO_TAG", 1);
        ADD_TO_TAG = r101;
        FeedItemAction r102 = new FeedItemAction("REMOVE_FROM_TAG", 2);
        REMOVE_FROM_TAG = r102;
        FeedItemAction r103 = new FeedItemAction("CLEAR_UNREAD", 3);
        CLEAR_UNREAD = r103;
        FeedItemAction r104 = new FeedItemAction("MARK_UNREAD", 4);
        MARK_UNREAD = r104;
        FeedItemAction[] r105 = {r100, r101, r102, r103, r104};
        f421431a = r105;
        f421432b = EnumEntriesKt.enumEntries(r105);
    }

    public static FeedItemAction[] values() {
        return (FeedItemAction[]) f421431a.clone();
    }

    public static FeedItemAction valueOf(String r100) {
        return (FeedItemAction) a.a(FeedItemAction.class, r100);
    }

    public FeedItemAction(String r100, int r101) {
        super(r100, r101);
    }
}

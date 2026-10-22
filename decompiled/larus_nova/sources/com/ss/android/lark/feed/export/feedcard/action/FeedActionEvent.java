package com.ss.android.lark.feed.export.feedcard.action;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/feed/export/feedcard/action/FeedActionEvent;", "", "<init>", "(Ljava/lang/String;I)V", "LONG_CLICK", "LEFT_SWIPE", "RIGHT_SWIPE_SHORT", "RIGHT_SWIPE_LONG", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedActionEvent extends Enum<FeedActionEvent> {
    public static final FeedActionEvent LEFT_SWIPE = null;
    public static final FeedActionEvent LONG_CLICK = null;
    public static final FeedActionEvent RIGHT_SWIPE_LONG = null;
    public static final FeedActionEvent RIGHT_SWIPE_SHORT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedActionEvent[] f421009a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f421010b = null;

    public static EnumEntries<FeedActionEvent> getEntries() {
        return f421010b;
    }

    static {
        FeedActionEvent r100 = new FeedActionEvent("LONG_CLICK", 0);
        LONG_CLICK = r100;
        FeedActionEvent r101 = new FeedActionEvent("LEFT_SWIPE", 1);
        LEFT_SWIPE = r101;
        FeedActionEvent r102 = new FeedActionEvent("RIGHT_SWIPE_SHORT", 2);
        RIGHT_SWIPE_SHORT = r102;
        FeedActionEvent r103 = new FeedActionEvent("RIGHT_SWIPE_LONG", 3);
        RIGHT_SWIPE_LONG = r103;
        FeedActionEvent[] r104 = {r100, r101, r102, r103};
        f421009a = r104;
        f421010b = EnumEntriesKt.enumEntries(r104);
    }

    public static FeedActionEvent[] values() {
        return (FeedActionEvent[]) f421009a.clone();
    }

    public static FeedActionEvent valueOf(String r100) {
        return (FeedActionEvent) a.a(FeedActionEvent.class, r100);
    }

    public FeedActionEvent(String r100, int r101) {
        super(r100, r101);
    }
}

package com.ss.android.lark.feed.export.feedviewcontainer;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/feed/export/feedviewcontainer/FeedViewType$BottomView;", "Lcom/ss/android/lark/feed/export/feedviewcontainer/FeedViewType;", "", "<init>", "(Ljava/lang/String;I)V", "UG_BOTTOM_BANNER", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedViewType$BottomView extends Enum<FeedViewType$BottomView> {
    public static final FeedViewType$BottomView UG_BOTTOM_BANNER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedViewType$BottomView[] f421021a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f421022b = null;

    public static EnumEntries<FeedViewType$BottomView> getEntries() {
        return f421022b;
    }

    static {
        FeedViewType$BottomView r100 = new FeedViewType$BottomView();
        UG_BOTTOM_BANNER = r100;
        FeedViewType$BottomView[] r101 = {r100};
        f421021a = r101;
        f421022b = EnumEntriesKt.enumEntries(r101);
    }

    public FeedViewType$BottomView() {
        super("UG_BOTTOM_BANNER", 0);
    }

    public static FeedViewType$BottomView[] values() {
        return (FeedViewType$BottomView[]) f421021a.clone();
    }

    public static FeedViewType$BottomView valueOf(String r100) {
        return (FeedViewType$BottomView) a.a(FeedViewType$BottomView.class, r100);
    }
}

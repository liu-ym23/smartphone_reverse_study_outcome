package com.ss.android.lark.feed.export.feedviewcontainer;

import com.obric.miniapp.alarm.AlarmSessionType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/feed/export/feedviewcontainer/FeedViewType$HeaderView;", "Lcom/ss/android/lark/feed/export/feedviewcontainer/FeedViewType;", "", "<init>", "(Ljava/lang/String;I)V", AlarmSessionType.EVENT, "NETWORK_NOTICE", "APP_CHECK", "PUSH_NOTICE", "UG_TOP_BANNER", "RETURN_TO_LAST_TENANT", "SHORTCUT", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedViewType$HeaderView extends Enum<FeedViewType$HeaderView> {
    public static final FeedViewType$HeaderView APP_CHECK = null;
    public static final FeedViewType$HeaderView EVENT = null;
    public static final FeedViewType$HeaderView NETWORK_NOTICE = null;
    public static final FeedViewType$HeaderView PUSH_NOTICE = null;
    public static final FeedViewType$HeaderView RETURN_TO_LAST_TENANT = null;
    public static final FeedViewType$HeaderView SHORTCUT = null;
    public static final FeedViewType$HeaderView UG_TOP_BANNER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedViewType$HeaderView[] f421023a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f421024b = null;

    public static EnumEntries<FeedViewType$HeaderView> getEntries() {
        return f421024b;
    }

    static {
        FeedViewType$HeaderView r100 = new FeedViewType$HeaderView(AlarmSessionType.EVENT, 0);
        EVENT = r100;
        FeedViewType$HeaderView r101 = new FeedViewType$HeaderView("NETWORK_NOTICE", 1);
        NETWORK_NOTICE = r101;
        FeedViewType$HeaderView r102 = new FeedViewType$HeaderView("APP_CHECK", 2);
        APP_CHECK = r102;
        FeedViewType$HeaderView r103 = new FeedViewType$HeaderView("PUSH_NOTICE", 3);
        PUSH_NOTICE = r103;
        FeedViewType$HeaderView r104 = new FeedViewType$HeaderView("UG_TOP_BANNER", 4);
        UG_TOP_BANNER = r104;
        FeedViewType$HeaderView r105 = new FeedViewType$HeaderView("RETURN_TO_LAST_TENANT", 5);
        RETURN_TO_LAST_TENANT = r105;
        FeedViewType$HeaderView r110 = new FeedViewType$HeaderView("SHORTCUT", 6);
        SHORTCUT = r110;
        FeedViewType$HeaderView[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f421023a = r111;
        f421024b = EnumEntriesKt.enumEntries(r111);
    }

    public static FeedViewType$HeaderView[] values() {
        return (FeedViewType$HeaderView[]) f421023a.clone();
    }

    public static FeedViewType$HeaderView valueOf(String r100) {
        return (FeedViewType$HeaderView) a.a(FeedViewType$HeaderView.class, r100);
    }

    public FeedViewType$HeaderView(String r100, int r101) {
        super(r100, r101);
    }
}

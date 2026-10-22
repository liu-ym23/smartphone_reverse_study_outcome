package com.ss.android.lark.flow.feed.action;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rj\u0002\b\u0004j\u0002\b\u0005¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/flow/feed/action/FlowFeedActionMode;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_FEED", "SIDEBAR", "sourceTag", "", "getSourceTag", "()Ljava/lang/String;", "supportLeftSwipe", "", "getSupportLeftSwipe", "()Z", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowFeedActionMode extends Enum<FlowFeedActionMode> {
    public static final FlowFeedActionMode MAIN_FEED = null;
    public static final FlowFeedActionMode SIDEBAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowFeedActionMode[] f423197a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f423198b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f423199a = null;

        static {
            int[] r100 = new int[FlowFeedActionMode.values().length];
            r100[FlowFeedActionMode.MAIN_FEED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[FlowFeedActionMode.SIDEBAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f423199a = r100;
        }
    }

    public static EnumEntries<FlowFeedActionMode> getEntries() {
        return f423198b;
    }

    static {
        FlowFeedActionMode r100 = new FlowFeedActionMode("MAIN_FEED", 0);
        MAIN_FEED = r100;
        FlowFeedActionMode r101 = new FlowFeedActionMode("SIDEBAR", 1);
        SIDEBAR = r101;
        FlowFeedActionMode[] r102 = {r100, r101};
        f423197a = r102;
        f423198b = EnumEntriesKt.enumEntries(r102);
    }

    public static FlowFeedActionMode[] values() {
        return (FlowFeedActionMode[]) f423197a.clone();
    }

    public final String getSourceTag() {
        int r100 = a.f423199a[ordinal()];
        if (r100 != 1) goto L5;
        return "feed";
    L5:
        if (r100 != 2) goto L8;
        return "feed_sidebar";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getSupportLeftSwipe() {
        if (this != MAIN_FEED) goto L5;
        return true;
    L5:
        return false;
    }

    public static FlowFeedActionMode valueOf(String r100) {
        return (FlowFeedActionMode) r27.a.a(FlowFeedActionMode.class, r100);
    }

    public FlowFeedActionMode(String r100, int r101) {
        super(r100, r101);
    }
}

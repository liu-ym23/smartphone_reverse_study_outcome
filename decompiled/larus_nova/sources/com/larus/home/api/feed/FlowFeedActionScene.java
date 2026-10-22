package com.larus.home.api.feed;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/home/api/feed/FlowFeedActionScene;", "", "<init>", "(Ljava/lang/String;I)V", "Click", "LongClick", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowFeedActionScene extends Enum<FlowFeedActionScene> {
    public static final FlowFeedActionScene Click = null;
    public static final FlowFeedActionScene LongClick = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowFeedActionScene[] f344089a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f344090b = null;

    public static EnumEntries<FlowFeedActionScene> getEntries() {
        return f344090b;
    }

    static {
        FlowFeedActionScene r100 = new FlowFeedActionScene("Click", 0);
        Click = r100;
        FlowFeedActionScene r101 = new FlowFeedActionScene("LongClick", 1);
        LongClick = r101;
        FlowFeedActionScene[] r102 = {r100, r101};
        f344089a = r102;
        f344090b = EnumEntriesKt.enumEntries(r102);
    }

    public static FlowFeedActionScene[] values() {
        return (FlowFeedActionScene[]) f344089a.clone();
    }

    public static FlowFeedActionScene valueOf(String r100) {
        return (FlowFeedActionScene) a.a(FlowFeedActionScene.class, r100);
    }

    public FlowFeedActionScene(String r100, int r101) {
        super(r100, r101);
    }
}

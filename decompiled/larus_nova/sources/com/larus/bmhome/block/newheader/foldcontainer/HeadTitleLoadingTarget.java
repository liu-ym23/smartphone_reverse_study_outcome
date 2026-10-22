package com.larus.bmhome.block.newheader.foldcontainer;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/block/newheader/foldcontainer/HeadTitleLoadingTarget;", "", "<init>", "(Ljava/lang/String;I)V", "CONTAINER", CardAdapter.TEXT, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HeadTitleLoadingTarget extends Enum<HeadTitleLoadingTarget> {
    public static final HeadTitleLoadingTarget CONTAINER = null;
    public static final HeadTitleLoadingTarget TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HeadTitleLoadingTarget[] f296337a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f296338b = null;

    public static EnumEntries<HeadTitleLoadingTarget> getEntries() {
        return f296338b;
    }

    static {
        HeadTitleLoadingTarget r100 = new HeadTitleLoadingTarget("CONTAINER", 0);
        CONTAINER = r100;
        HeadTitleLoadingTarget r101 = new HeadTitleLoadingTarget(CardAdapter.TEXT, 1);
        TEXT = r101;
        HeadTitleLoadingTarget[] r102 = {r100, r101};
        f296337a = r102;
        f296338b = EnumEntriesKt.enumEntries(r102);
    }

    public static HeadTitleLoadingTarget[] values() {
        return (HeadTitleLoadingTarget[]) f296337a.clone();
    }

    public static HeadTitleLoadingTarget valueOf(String r100) {
        return (HeadTitleLoadingTarget) r27.a.a(HeadTitleLoadingTarget.class, r100);
    }

    public HeadTitleLoadingTarget(String r100, int r101) {
        super(r100, r101);
    }
}

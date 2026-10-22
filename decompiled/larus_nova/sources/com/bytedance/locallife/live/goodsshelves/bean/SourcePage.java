package com.bytedance.locallife.live.goodsshelves.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/SourcePage;", "", "", "value", "I", "getValue", "()I", "POI", "DETAIL", "HOMEPAGE_TAB", "LIVE_SHELF", "VIDEO_ANCHOR", "LIVE_CARD", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum SourcePage extends Enum<SourcePage> {
    public static final SourcePage DETAIL = null;
    public static final SourcePage HOMEPAGE_TAB = null;
    public static final SourcePage LIVE_CARD = null;
    public static final SourcePage LIVE_SHELF = null;
    public static final SourcePage POI = null;
    public static final SourcePage VIDEO_ANCHOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SourcePage[] f259584a = null;
    private final int value;

    public static SourcePage valueOf(String r100) {
        return (SourcePage) r27.a.a(SourcePage.class, r100);
    }

    public static SourcePage[] values() {
        return (SourcePage[]) f259584a.clone();
    }

    static {
        SourcePage r100 = new SourcePage("POI", 0, 1);
        POI = r100;
        SourcePage r101 = new SourcePage("DETAIL", 1, 2);
        DETAIL = r101;
        SourcePage r102 = new SourcePage("HOMEPAGE_TAB", 2, 104);
        HOMEPAGE_TAB = r102;
        SourcePage r103 = new SourcePage("LIVE_SHELF", 3, 105);
        LIVE_SHELF = r103;
        SourcePage r104 = new SourcePage("VIDEO_ANCHOR", 4, 106);
        VIDEO_ANCHOR = r104;
        SourcePage r105 = new SourcePage("LIVE_CARD", 5, 107);
        LIVE_CARD = r105;
        f259584a = new SourcePage[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getValue() {
        return this.value;
    }

    public SourcePage(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

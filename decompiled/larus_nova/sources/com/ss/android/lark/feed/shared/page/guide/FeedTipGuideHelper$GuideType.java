package com.ss.android.lark.feed.shared.page.guide;

/* JADX INFO: loaded from: classes35.dex */
public final enum FeedTipGuideHelper$GuideType extends Enum<FeedTipGuideHelper$GuideType> {
    public static final FeedTipGuideHelper$GuideType AT_ALL = null;
    public static final FeedTipGuideHelper$GuideType AT_USER = null;
    public static final FeedTipGuideHelper$GuideType BADGE_STYLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedTipGuideHelper$GuideType[] f421415a = null;
    private int value;

    static {
        FeedTipGuideHelper$GuideType r100 = new FeedTipGuideHelper$GuideType("AT_USER", 0, 0);
        AT_USER = r100;
        FeedTipGuideHelper$GuideType r101 = new FeedTipGuideHelper$GuideType("AT_ALL", 1, 1);
        AT_ALL = r101;
        FeedTipGuideHelper$GuideType r102 = new FeedTipGuideHelper$GuideType("BADGE_STYLE", 2, 2);
        BADGE_STYLE = r102;
        f421415a = new FeedTipGuideHelper$GuideType[]{r100, r101, r102};
    }

    public static FeedTipGuideHelper$GuideType[] values() {
        return (FeedTipGuideHelper$GuideType[]) f421415a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static FeedTipGuideHelper$GuideType forNumber(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return BADGE_STYLE;
    L12:
        return AT_ALL;
    L14:
        return AT_USER;
    }

    public static FeedTipGuideHelper$GuideType valueOf(String r100) {
        return (FeedTipGuideHelper$GuideType) r27.a.a(FeedTipGuideHelper$GuideType.class, r100);
    }

    public static FeedTipGuideHelper$GuideType valueOf(int r100) {
        return forNumber(r100);
    }

    public FeedTipGuideHelper$GuideType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

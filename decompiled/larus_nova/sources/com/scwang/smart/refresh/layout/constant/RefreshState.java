package com.scwang.smart.refresh.layout.constant;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum RefreshState extends Enum<RefreshState> {
    public static final RefreshState LoadFinish = null;
    public static final RefreshState LoadReleased = null;
    public static final RefreshState Loading = null;
    public static final RefreshState None = null;
    public static final RefreshState PullDownCanceled = null;
    public static final RefreshState PullDownToRefresh = null;
    public static final RefreshState PullUpCanceled = null;
    public static final RefreshState PullUpToLoad = null;
    public static final RefreshState RefreshFinish = null;
    public static final RefreshState RefreshReleased = null;
    public static final RefreshState Refreshing = null;
    public static final RefreshState ReleaseToLoad = null;
    public static final RefreshState ReleaseToRefresh = null;
    public static final RefreshState ReleaseToTwoLevel = null;
    public static final RefreshState TwoLevel = null;
    public static final RefreshState TwoLevelFinish = null;
    public static final RefreshState TwoLevelReleased = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RefreshState[] f405858a = null;
    public final boolean isDragging;
    public final boolean isFinishing;
    public final boolean isFooter;
    public final boolean isHeader;
    public final boolean isOpening;
    public final boolean isReleaseToOpening;
    public final boolean isTwoLevel;

    static {
        RefreshState r100 = new RefreshState("None", 0, 0, false, false, false, false, false);
        None = r100;
        RefreshState r101 = new RefreshState("PullDownToRefresh", 1, 1, true, false, false, false, false);
        PullDownToRefresh = r101;
        RefreshState r102 = new RefreshState("PullUpToLoad", 2, 2, true, false, false, false, false);
        PullUpToLoad = r102;
        RefreshState r103 = new RefreshState("PullDownCanceled", 3, 1, false, false, false, false, false);
        PullDownCanceled = r103;
        RefreshState r104 = new RefreshState("PullUpCanceled", 4, 2, false, false, false, false, false);
        PullUpCanceled = r104;
        RefreshState r105 = new RefreshState("ReleaseToRefresh", 5, 1, true, false, false, false, true);
        ReleaseToRefresh = r105;
        RefreshState r106 = new RefreshState("ReleaseToLoad", 6, 2, true, false, false, false, true);
        ReleaseToLoad = r106;
        RefreshState r107 = new RefreshState("ReleaseToTwoLevel", 7, 1, true, false, false, true, true);
        ReleaseToTwoLevel = r107;
        RefreshState r108 = new RefreshState("TwoLevelReleased", 8, 1, false, false, false, true, false);
        TwoLevelReleased = r108;
        RefreshState r109 = new RefreshState("RefreshReleased", 9, 1, false, false, false, false, false);
        RefreshReleased = r109;
        RefreshState r110 = new RefreshState("LoadReleased", 10, 2, false, false, false, false, false);
        LoadReleased = r110;
        RefreshState r210 = new RefreshState("Refreshing", 11, 1, false, true, false, false, false);
        Refreshing = r210;
        RefreshState r111 = new RefreshState("Loading", 12, 2, false, true, false, false, false);
        Loading = r111;
        RefreshState r112 = new RefreshState("TwoLevel", 13, 1, false, true, false, true, false);
        TwoLevel = r112;
        RefreshState r113 = new RefreshState("RefreshFinish", 14, 1, false, false, true, false, false);
        RefreshFinish = r113;
        RefreshState r114 = new RefreshState("LoadFinish", 15, 2, false, false, true, false, false);
        LoadFinish = r114;
        RefreshState r115 = new RefreshState("TwoLevelFinish", 16, 1, false, false, true, true, false);
        TwoLevelFinish = r115;
        f405858a = new RefreshState[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r210, r111, r112, r113, r114, r115};
    }

    public static RefreshState[] values() {
        return (RefreshState[]) f405858a.clone();
    }

    public RefreshState toFooter() {
        if (this.isHeader == true) goto L5;
    L8:
        return this;
    L5:
        if (this.isTwoLevel == true) goto L8;
        return values()[ordinal() + 1];
    }

    public RefreshState toHeader() {
        if (this.isFooter == true) goto L5;
    L8:
        return this;
    L5:
        if (this.isTwoLevel == true) goto L8;
        return values()[ordinal() - 1];
    }

    public static RefreshState valueOf(String r100) {
        return (RefreshState) a.a(RefreshState.class, r100);
    }

    public RefreshState(String r100, int r101, int r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107) {
        super(r100, r101);
        boolean r108 = false;
        if (r102 != 1) goto L5;
        boolean r109 = true;
    L6:
        this.isHeader = r109;
        if (r102 != 2) goto L9;
        r108 = true;
    L9:
        this.isFooter = r108;
        this.isDragging = r103;
        this.isOpening = r104;
        this.isFinishing = r105;
        this.isTwoLevel = r106;
        this.isReleaseToOpening = r107;
        return;
    L5:
        r109 = false;
        goto L6
    }
}

package com.bytedance.ee.bear.share.export;

/* JADX INFO: loaded from: classes18.dex */
public final enum SharePanelState extends Enum<SharePanelState> {
    public static final SharePanelState NOT_SHOW = null;
    public static final SharePanelState SHOWING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SharePanelState[] f237020a = null;

    static {
        SharePanelState r100 = new SharePanelState("NOT_SHOW", 0);
        NOT_SHOW = r100;
        SharePanelState r101 = new SharePanelState("SHOWING", 1);
        SHOWING = r101;
        f237020a = new SharePanelState[]{r100, r101};
    }

    public static SharePanelState[] values() {
        return (SharePanelState[]) f237020a.clone();
    }

    public static SharePanelState valueOf(String r100) {
        return (SharePanelState) r27.a.a(SharePanelState.class, r100);
    }

    public SharePanelState(String r100, int r101) {
        super(r100, r101);
    }
}

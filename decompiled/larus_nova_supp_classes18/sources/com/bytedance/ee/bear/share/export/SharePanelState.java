package com.bytedance.ee.bear.share.export;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum SharePanelState extends Enum<SharePanelState> {
    public static final SharePanelState NOT_SHOW = null;
    public static final SharePanelState SHOWING = null;
    public static final /* synthetic */ SharePanelState[] a = null;

    static {
        SharePanelState r0 = new SharePanelState("NOT_SHOW", 0);
        NOT_SHOW = r0;
        SharePanelState r1 = new SharePanelState("SHOWING", 1);
        SHOWING = r1;
        a = new SharePanelState[]{r0, r1};
    }

    public static SharePanelState[] values() {
        return (SharePanelState[]) a.clone();
    }

    public static SharePanelState valueOf(String r1) {
        return (SharePanelState) r27.a.a(SharePanelState.class, r1);
    }

    public SharePanelState(String r1, int r2) {
        super(r1, r2);
    }
}

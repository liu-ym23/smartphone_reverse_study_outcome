package com.bytedance.ee.bear.bizwidget.shareview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum ShareState extends Enum<ShareState> {
    public static final ShareState ADMIN_NOT_CLICK = null;
    public static final ShareState CAC_NOT_CLICK = null;
    public static final ShareState NOT_CLICK = null;
    public static final ShareState NOT_SHOW = null;
    public static final ShareState SHOW = null;
    public static final ShareState SHOW_NEW = null;
    public static final /* synthetic */ ShareState[] a = null;

    static {
        ShareState r0 = new ShareState("SHOW", 0);
        SHOW = r0;
        ShareState r1 = new ShareState("SHOW_NEW", 1);
        SHOW_NEW = r1;
        ShareState r3 = new ShareState("NOT_SHOW", 2);
        NOT_SHOW = r3;
        ShareState r5 = new ShareState("NOT_CLICK", 3);
        NOT_CLICK = r5;
        ShareState r7 = new ShareState("ADMIN_NOT_CLICK", 4);
        ADMIN_NOT_CLICK = r7;
        ShareState r9 = new ShareState("CAC_NOT_CLICK", 5);
        CAC_NOT_CLICK = r9;
        a = new ShareState[]{r0, r1, r3, r5, r7, r9};
    }

    public static ShareState[] values() {
        return (ShareState[]) a.clone();
    }

    public static ShareState valueOf(String r1) {
        return (ShareState) r27.a.a(ShareState.class, r1);
    }

    public ShareState(String r1, int r2) {
        super(r1, r2);
    }
}

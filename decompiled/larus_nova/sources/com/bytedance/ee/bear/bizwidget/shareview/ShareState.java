package com.bytedance.ee.bear.bizwidget.shareview;

/* JADX INFO: loaded from: classes16.dex */
public final enum ShareState extends Enum<ShareState> {
    public static final ShareState ADMIN_NOT_CLICK = null;
    public static final ShareState CAC_NOT_CLICK = null;
    public static final ShareState NOT_CLICK = null;
    public static final ShareState NOT_SHOW = null;
    public static final ShareState SHOW = null;
    public static final ShareState SHOW_NEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShareState[] f216539a = null;

    static {
        ShareState r100 = new ShareState("SHOW", 0);
        SHOW = r100;
        ShareState r101 = new ShareState("SHOW_NEW", 1);
        SHOW_NEW = r101;
        ShareState r102 = new ShareState("NOT_SHOW", 2);
        NOT_SHOW = r102;
        ShareState r103 = new ShareState("NOT_CLICK", 3);
        NOT_CLICK = r103;
        ShareState r104 = new ShareState("ADMIN_NOT_CLICK", 4);
        ADMIN_NOT_CLICK = r104;
        ShareState r105 = new ShareState("CAC_NOT_CLICK", 5);
        CAC_NOT_CLICK = r105;
        f216539a = new ShareState[]{r100, r101, r102, r103, r104, r105};
    }

    public static ShareState[] values() {
        return (ShareState[]) f216539a.clone();
    }

    public static ShareState valueOf(String r100) {
        return (ShareState) r27.a.a(ShareState.class, r100);
    }

    public ShareState(String r100, int r101) {
        super(r100, r101);
    }
}

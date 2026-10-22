package com.bytedance.ee.bear.contract;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum AnalyticConstant$LinkScene extends Enum<AnalyticConstant$LinkScene> {
    public static final AnalyticConstant$LinkScene CALENDAR = null;
    public static final AnalyticConstant$LinkScene CCM = null;
    public static final AnalyticConstant$LinkScene EMAIL = null;
    public static final AnalyticConstant$LinkScene GADGET = null;
    public static final AnalyticConstant$LinkScene MESSENGER = null;
    public static final /* synthetic */ AnalyticConstant$LinkScene[] a = null;
    String scene;

    static {
        AnalyticConstant$LinkScene r0 = new AnalyticConstant$LinkScene("CCM", 0, "ccm");
        CCM = r0;
        AnalyticConstant$LinkScene r1 = new AnalyticConstant$LinkScene("EMAIL", 1, "email");
        EMAIL = r1;
        AnalyticConstant$LinkScene r2 = new AnalyticConstant$LinkScene("GADGET", 2, "gadget");
        GADGET = r2;
        AnalyticConstant$LinkScene r4 = new AnalyticConstant$LinkScene("CALENDAR", 3, "calendar");
        CALENDAR = r4;
        AnalyticConstant$LinkScene r6 = new AnalyticConstant$LinkScene("MESSENGER", 4, "messenger");
        MESSENGER = r6;
        a = new AnalyticConstant$LinkScene[]{r0, r1, r2, r4, r6};
    }

    public static AnalyticConstant$LinkScene[] values() {
        return (AnalyticConstant$LinkScene[]) a.clone();
    }

    public String getScene() {
        return this.scene;
    }

    public static AnalyticConstant$LinkScene valueOf(String r1) {
        return (AnalyticConstant$LinkScene) r27.a.a(AnalyticConstant$LinkScene.class, r1);
    }

    public AnalyticConstant$LinkScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.scene = r3;
    }
}

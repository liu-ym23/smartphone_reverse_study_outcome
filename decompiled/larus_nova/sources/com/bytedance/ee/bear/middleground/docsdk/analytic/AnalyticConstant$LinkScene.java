package com.bytedance.ee.bear.middleground.docsdk.analytic;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final enum AnalyticConstant$LinkScene extends Enum<AnalyticConstant$LinkScene> {
    public static final AnalyticConstant$LinkScene CALENDAR = null;
    public static final AnalyticConstant$LinkScene CCM = null;
    public static final AnalyticConstant$LinkScene EMAIL = null;
    public static final AnalyticConstant$LinkScene GADGET = null;
    public static final AnalyticConstant$LinkScene MESSENGER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnalyticConstant$LinkScene[] f232375a = null;
    String scene;

    static {
        AnalyticConstant$LinkScene r100 = new AnalyticConstant$LinkScene("CCM", 0, ChameleonResConstants.CCM_ROOT_DIR);
        CCM = r100;
        AnalyticConstant$LinkScene r101 = new AnalyticConstant$LinkScene(CommonConstant.RETKEY.EMAIL, 1, "email");
        EMAIL = r101;
        AnalyticConstant$LinkScene r102 = new AnalyticConstant$LinkScene("GADGET", 2, "gadget");
        GADGET = r102;
        AnalyticConstant$LinkScene r103 = new AnalyticConstant$LinkScene("CALENDAR", 3, "calendar");
        CALENDAR = r103;
        AnalyticConstant$LinkScene r104 = new AnalyticConstant$LinkScene("MESSENGER", 4, "messenger");
        MESSENGER = r104;
        f232375a = new AnalyticConstant$LinkScene[]{r100, r101, r102, r103, r104};
    }

    public static AnalyticConstant$LinkScene[] values() {
        return (AnalyticConstant$LinkScene[]) f232375a.clone();
    }

    public String getScene() {
        return this.scene;
    }

    public static AnalyticConstant$LinkScene valueOf(String r100) {
        return (AnalyticConstant$LinkScene) a.a(AnalyticConstant$LinkScene.class, r100);
    }

    public AnalyticConstant$LinkScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}

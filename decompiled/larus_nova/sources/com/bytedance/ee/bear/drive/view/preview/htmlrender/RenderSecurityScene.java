package com.bytedance.ee.bear.drive.view.preview.htmlrender;

/* JADX INFO: loaded from: classes16.dex */
public final enum RenderSecurityScene extends Enum<RenderSecurityScene> {
    public static final RenderSecurityScene DRIVE_DEGRADED_SCENE = null;
    public static final RenderSecurityScene DRIVE_NORMAL_SCENE = null;
    public static final RenderSecurityScene IM_SCENE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RenderSecurityScene[] f224877a = null;

    static {
        RenderSecurityScene r100 = new RenderSecurityScene("IM_SCENE", 0);
        IM_SCENE = r100;
        RenderSecurityScene r101 = new RenderSecurityScene("DRIVE_DEGRADED_SCENE", 1);
        DRIVE_DEGRADED_SCENE = r101;
        RenderSecurityScene r102 = new RenderSecurityScene("DRIVE_NORMAL_SCENE", 2);
        DRIVE_NORMAL_SCENE = r102;
        f224877a = new RenderSecurityScene[]{r100, r101, r102};
    }

    public static RenderSecurityScene[] values() {
        return (RenderSecurityScene[]) f224877a.clone();
    }

    public static RenderSecurityScene valueOf(String r100) {
        return (RenderSecurityScene) r27.a.a(RenderSecurityScene.class, r100);
    }

    public RenderSecurityScene(String r100, int r101) {
        super(r100, r101);
    }
}

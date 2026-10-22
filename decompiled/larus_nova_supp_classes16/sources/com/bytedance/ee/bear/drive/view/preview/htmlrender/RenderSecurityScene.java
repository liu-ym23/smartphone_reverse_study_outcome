package com.bytedance.ee.bear.drive.view.preview.htmlrender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum RenderSecurityScene extends Enum<RenderSecurityScene> {
    public static final RenderSecurityScene DRIVE_DEGRADED_SCENE = null;
    public static final RenderSecurityScene DRIVE_NORMAL_SCENE = null;
    public static final RenderSecurityScene IM_SCENE = null;
    public static final /* synthetic */ RenderSecurityScene[] a = null;

    static {
        RenderSecurityScene r0 = new RenderSecurityScene("IM_SCENE", 0);
        IM_SCENE = r0;
        RenderSecurityScene r1 = new RenderSecurityScene("DRIVE_DEGRADED_SCENE", 1);
        DRIVE_DEGRADED_SCENE = r1;
        RenderSecurityScene r3 = new RenderSecurityScene("DRIVE_NORMAL_SCENE", 2);
        DRIVE_NORMAL_SCENE = r3;
        a = new RenderSecurityScene[]{r0, r1, r3};
    }

    public static RenderSecurityScene[] values() {
        return (RenderSecurityScene[]) a.clone();
    }

    public static RenderSecurityScene valueOf(String r1) {
        return (RenderSecurityScene) r27.a.a(RenderSecurityScene.class, r1);
    }

    public RenderSecurityScene(String r1, int r2) {
        super(r1, r2);
    }
}

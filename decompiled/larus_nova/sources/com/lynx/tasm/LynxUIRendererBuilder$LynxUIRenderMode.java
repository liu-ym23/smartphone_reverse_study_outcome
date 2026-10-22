package com.lynx.tasm;

/* JADX INFO: loaded from: classes32.dex */
public final enum LynxUIRendererBuilder$LynxUIRenderMode extends Enum<LynxUIRendererBuilder$LynxUIRenderMode> {
    public static final LynxUIRendererBuilder$LynxUIRenderMode Clay = null;
    public static final LynxUIRendererBuilder$LynxUIRenderMode Native = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LynxUIRendererBuilder$LynxUIRenderMode[] f381723a = null;

    static {
        LynxUIRendererBuilder$LynxUIRenderMode r100 = new LynxUIRendererBuilder$LynxUIRenderMode("Native", 0);
        Native = r100;
        LynxUIRendererBuilder$LynxUIRenderMode r101 = new LynxUIRendererBuilder$LynxUIRenderMode("Clay", 1);
        Clay = r101;
        f381723a = new LynxUIRendererBuilder$LynxUIRenderMode[]{r100, r101};
    }

    public static LynxUIRendererBuilder$LynxUIRenderMode[] values() {
        return (LynxUIRendererBuilder$LynxUIRenderMode[]) f381723a.clone();
    }

    public static LynxUIRendererBuilder$LynxUIRenderMode valueOf(String r100) {
        return (LynxUIRendererBuilder$LynxUIRenderMode) r27.a.a(LynxUIRendererBuilder$LynxUIRenderMode.class, r100);
    }

    public LynxUIRendererBuilder$LynxUIRenderMode(String r100, int r101) {
        super(r100, r101);
    }
}

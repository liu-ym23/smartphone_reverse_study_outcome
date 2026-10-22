package com.ss.videoarch.liveplayer;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerDef$VeLivePlayerFillMode extends Enum<VeLivePlayerDef$VeLivePlayerFillMode> {
    public static final VeLivePlayerDef$VeLivePlayerFillMode VeLivePlayerFillModeAspectFill = null;
    public static final VeLivePlayerDef$VeLivePlayerFillMode VeLivePlayerFillModeAspectFit = null;
    public static final VeLivePlayerDef$VeLivePlayerFillMode VeLivePlayerFillModeFullFill = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerDef$VeLivePlayerFillMode[] f458618a = null;

    static {
        VeLivePlayerDef$VeLivePlayerFillMode r100 = new VeLivePlayerDef$VeLivePlayerFillMode("VeLivePlayerFillModeAspectFit", 0);
        VeLivePlayerFillModeAspectFit = r100;
        VeLivePlayerDef$VeLivePlayerFillMode r101 = new VeLivePlayerDef$VeLivePlayerFillMode("VeLivePlayerFillModeFullFill", 1);
        VeLivePlayerFillModeFullFill = r101;
        VeLivePlayerDef$VeLivePlayerFillMode r102 = new VeLivePlayerDef$VeLivePlayerFillMode("VeLivePlayerFillModeAspectFill", 2);
        VeLivePlayerFillModeAspectFill = r102;
        f458618a = new VeLivePlayerDef$VeLivePlayerFillMode[]{r100, r101, r102};
    }

    public static VeLivePlayerDef$VeLivePlayerFillMode[] values() {
        return (VeLivePlayerDef$VeLivePlayerFillMode[]) f458618a.clone();
    }

    public static VeLivePlayerDef$VeLivePlayerFillMode valueOf(String r100) {
        return (VeLivePlayerDef$VeLivePlayerFillMode) r27.a.a(VeLivePlayerDef$VeLivePlayerFillMode.class, r100);
    }

    private VeLivePlayerDef$VeLivePlayerFillMode(String r100, int r101) {
        super(r100, r101);
    }
}

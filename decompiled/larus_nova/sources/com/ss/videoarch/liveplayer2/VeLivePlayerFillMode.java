package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerFillMode extends Enum<VeLivePlayerFillMode> {
    public static final VeLivePlayerFillMode VeLivePlayerFillModeAspectFill = null;
    public static final VeLivePlayerFillMode VeLivePlayerFillModeAspectFit = null;
    public static final VeLivePlayerFillMode VeLivePlayerFillModeFullFill = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerFillMode[] f459683a = null;

    static {
        VeLivePlayerFillMode r100 = new VeLivePlayerFillMode("VeLivePlayerFillModeAspectFit", 0);
        VeLivePlayerFillModeAspectFit = r100;
        VeLivePlayerFillMode r101 = new VeLivePlayerFillMode("VeLivePlayerFillModeFullFill", 1);
        VeLivePlayerFillModeFullFill = r101;
        VeLivePlayerFillMode r102 = new VeLivePlayerFillMode("VeLivePlayerFillModeAspectFill", 2);
        VeLivePlayerFillModeAspectFill = r102;
        f459683a = new VeLivePlayerFillMode[]{r100, r101, r102};
    }

    public static VeLivePlayerFillMode[] values() {
        return (VeLivePlayerFillMode[]) f459683a.clone();
    }

    public static VeLivePlayerFillMode valueOf(String r100) {
        return (VeLivePlayerFillMode) r27.a.a(VeLivePlayerFillMode.class, r100);
    }

    public VeLivePlayerFillMode(String r100, int r101) {
        super(r100, r101);
    }
}

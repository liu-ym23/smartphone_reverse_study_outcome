package com.ss.videoarch.liveplayer;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerDef$VeLivePlayerResolutionSwitchReason extends Enum<VeLivePlayerDef$VeLivePlayerResolutionSwitchReason> {
    public static final VeLivePlayerDef$VeLivePlayerResolutionSwitchReason VeLiveplayerResolutionSwitchByAuto = null;
    public static final VeLivePlayerDef$VeLivePlayerResolutionSwitchReason VeLiveplayerResolutionSwitchByManual = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerDef$VeLivePlayerResolutionSwitchReason[] f458623a = null;

    static {
        VeLivePlayerDef$VeLivePlayerResolutionSwitchReason r100 = new VeLivePlayerDef$VeLivePlayerResolutionSwitchReason("VeLiveplayerResolutionSwitchByAuto", 0);
        VeLiveplayerResolutionSwitchByAuto = r100;
        VeLivePlayerDef$VeLivePlayerResolutionSwitchReason r101 = new VeLivePlayerDef$VeLivePlayerResolutionSwitchReason("VeLiveplayerResolutionSwitchByManual", 1);
        VeLiveplayerResolutionSwitchByManual = r101;
        f458623a = new VeLivePlayerDef$VeLivePlayerResolutionSwitchReason[]{r100, r101};
    }

    public static VeLivePlayerDef$VeLivePlayerResolutionSwitchReason[] values() {
        return (VeLivePlayerDef$VeLivePlayerResolutionSwitchReason[]) f458623a.clone();
    }

    public static VeLivePlayerDef$VeLivePlayerResolutionSwitchReason valueOf(String r100) {
        return (VeLivePlayerDef$VeLivePlayerResolutionSwitchReason) r27.a.a(VeLivePlayerDef$VeLivePlayerResolutionSwitchReason.class, r100);
    }

    private VeLivePlayerDef$VeLivePlayerResolutionSwitchReason(String r100, int r101) {
        super(r100, r101);
    }
}

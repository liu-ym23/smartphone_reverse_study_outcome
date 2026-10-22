package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerResolutionSwitchReason extends Enum<VeLivePlayerResolutionSwitchReason> {
    public static final VeLivePlayerResolutionSwitchReason VeLivePlayerResolutionSwitchByAuto = null;
    public static final VeLivePlayerResolutionSwitchReason VeLivePlayerResolutionSwitchByManual = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerResolutionSwitchReason[] f459700a = null;

    static {
        VeLivePlayerResolutionSwitchReason r100 = new VeLivePlayerResolutionSwitchReason("VeLivePlayerResolutionSwitchByAuto", 0);
        VeLivePlayerResolutionSwitchByAuto = r100;
        VeLivePlayerResolutionSwitchReason r101 = new VeLivePlayerResolutionSwitchReason("VeLivePlayerResolutionSwitchByManual", 1);
        VeLivePlayerResolutionSwitchByManual = r101;
        f459700a = new VeLivePlayerResolutionSwitchReason[]{r100, r101};
    }

    public static VeLivePlayerResolutionSwitchReason[] values() {
        return (VeLivePlayerResolutionSwitchReason[]) f459700a.clone();
    }

    public static VeLivePlayerResolutionSwitchReason valueOf(String r100) {
        return (VeLivePlayerResolutionSwitchReason) r27.a.a(VeLivePlayerResolutionSwitchReason.class, r100);
    }

    public VeLivePlayerResolutionSwitchReason(String r100, int r101) {
        super(r100, r101);
    }
}

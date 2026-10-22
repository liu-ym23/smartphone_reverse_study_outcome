package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerResolutionSwitchMethod extends Enum<VeLivePlayerResolutionSwitchMethod> {
    public static final VeLivePlayerResolutionSwitchMethod VeLivePlayerResolutionSwitchReplay = null;
    public static final VeLivePlayerResolutionSwitchMethod VeLivePlayerResolutionSwitchSmooth = null;
    public static final VeLivePlayerResolutionSwitchMethod VeLivePlayerResolutionSwitchSmoothFirst = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerResolutionSwitchMethod[] f459699a = null;

    static {
        VeLivePlayerResolutionSwitchMethod r100 = new VeLivePlayerResolutionSwitchMethod("VeLivePlayerResolutionSwitchReplay", 0);
        VeLivePlayerResolutionSwitchReplay = r100;
        VeLivePlayerResolutionSwitchMethod r101 = new VeLivePlayerResolutionSwitchMethod("VeLivePlayerResolutionSwitchSmooth", 1);
        VeLivePlayerResolutionSwitchSmooth = r101;
        VeLivePlayerResolutionSwitchMethod r102 = new VeLivePlayerResolutionSwitchMethod("VeLivePlayerResolutionSwitchSmoothFirst", 2);
        VeLivePlayerResolutionSwitchSmoothFirst = r102;
        f459699a = new VeLivePlayerResolutionSwitchMethod[]{r100, r101, r102};
    }

    public static VeLivePlayerResolutionSwitchMethod[] values() {
        return (VeLivePlayerResolutionSwitchMethod[]) f459699a.clone();
    }

    public static VeLivePlayerResolutionSwitchMethod valueOf(String r100) {
        return (VeLivePlayerResolutionSwitchMethod) r27.a.a(VeLivePlayerResolutionSwitchMethod.class, r100);
    }

    public VeLivePlayerResolutionSwitchMethod(String r100, int r101) {
        super(r100, r101);
    }
}

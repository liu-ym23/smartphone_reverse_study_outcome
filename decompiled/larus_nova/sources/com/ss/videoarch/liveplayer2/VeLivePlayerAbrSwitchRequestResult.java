package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerAbrSwitchRequestResult extends Enum<VeLivePlayerAbrSwitchRequestResult> {
    public static final VeLivePlayerAbrSwitchRequestResult VeLivePlayerApproved = null;
    public static final VeLivePlayerAbrSwitchRequestResult VeLivePlayerRejectedForFixedResolution = null;
    public static final VeLivePlayerAbrSwitchRequestResult VeLivePlayerRejectedForFixedSuggestedResolutionInvalid = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerAbrSwitchRequestResult[] f459675a = null;

    static {
        VeLivePlayerAbrSwitchRequestResult r100 = new VeLivePlayerAbrSwitchRequestResult("VeLivePlayerApproved", 0);
        VeLivePlayerApproved = r100;
        VeLivePlayerAbrSwitchRequestResult r101 = new VeLivePlayerAbrSwitchRequestResult("VeLivePlayerRejectedForFixedResolution", 1);
        VeLivePlayerRejectedForFixedResolution = r101;
        VeLivePlayerAbrSwitchRequestResult r102 = new VeLivePlayerAbrSwitchRequestResult("VeLivePlayerRejectedForFixedSuggestedResolutionInvalid", 2);
        VeLivePlayerRejectedForFixedSuggestedResolutionInvalid = r102;
        f459675a = new VeLivePlayerAbrSwitchRequestResult[]{r100, r101, r102};
    }

    public static VeLivePlayerAbrSwitchRequestResult[] values() {
        return (VeLivePlayerAbrSwitchRequestResult[]) f459675a.clone();
    }

    public static VeLivePlayerAbrSwitchRequestResult valueOf(String r100) {
        return (VeLivePlayerAbrSwitchRequestResult) r27.a.a(VeLivePlayerAbrSwitchRequestResult.class, r100);
    }

    public VeLivePlayerAbrSwitchRequestResult(String r100, int r101) {
        super(r100, r101);
    }
}

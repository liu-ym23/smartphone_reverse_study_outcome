package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerSupportResolutionSwitchError extends Enum<VeLivePlayerSupportResolutionSwitchError> {
    public static final VeLivePlayerSupportResolutionSwitchError VeLivePlayerErrorBytevc2NotSupport = null;
    public static final VeLivePlayerSupportResolutionSwitchError VeLivePlayerErrorConfigNotSupport = null;
    public static final VeLivePlayerSupportResolutionSwitchError VeLivePlayerErrorFormatNotSupport = null;
    public static final VeLivePlayerSupportResolutionSwitchError VeLivePlayerErrorInvalidRes = null;
    public static final VeLivePlayerSupportResolutionSwitchError VeLivePlayerErrorResNotFound = null;
    public static final VeLivePlayerSupportResolutionSwitchError VeLivePlayerErrorSameRes = null;
    public static final VeLivePlayerSupportResolutionSwitchError VeLivePlayerErrorStatusInvalid = null;
    public static final VeLivePlayerSupportResolutionSwitchError VeLivePlayerNoError = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerSupportResolutionSwitchError[] f459707a = null;

    static {
        VeLivePlayerSupportResolutionSwitchError r100 = new VeLivePlayerSupportResolutionSwitchError("VeLivePlayerNoError", 0);
        VeLivePlayerNoError = r100;
        VeLivePlayerSupportResolutionSwitchError r101 = new VeLivePlayerSupportResolutionSwitchError("VeLivePlayerErrorInvalidRes", 1);
        VeLivePlayerErrorInvalidRes = r101;
        VeLivePlayerSupportResolutionSwitchError r102 = new VeLivePlayerSupportResolutionSwitchError("VeLivePlayerErrorSameRes", 2);
        VeLivePlayerErrorSameRes = r102;
        VeLivePlayerSupportResolutionSwitchError r103 = new VeLivePlayerSupportResolutionSwitchError("VeLivePlayerErrorStatusInvalid", 3);
        VeLivePlayerErrorStatusInvalid = r103;
        VeLivePlayerSupportResolutionSwitchError r104 = new VeLivePlayerSupportResolutionSwitchError("VeLivePlayerErrorResNotFound", 4);
        VeLivePlayerErrorResNotFound = r104;
        VeLivePlayerSupportResolutionSwitchError r105 = new VeLivePlayerSupportResolutionSwitchError("VeLivePlayerErrorFormatNotSupport", 5);
        VeLivePlayerErrorFormatNotSupport = r105;
        VeLivePlayerSupportResolutionSwitchError r110 = new VeLivePlayerSupportResolutionSwitchError("VeLivePlayerErrorConfigNotSupport", 6);
        VeLivePlayerErrorConfigNotSupport = r110;
        VeLivePlayerSupportResolutionSwitchError r111 = new VeLivePlayerSupportResolutionSwitchError("VeLivePlayerErrorBytevc2NotSupport", 7);
        VeLivePlayerErrorBytevc2NotSupport = r111;
        f459707a = new VeLivePlayerSupportResolutionSwitchError[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static VeLivePlayerSupportResolutionSwitchError[] values() {
        return (VeLivePlayerSupportResolutionSwitchError[]) f459707a.clone();
    }

    public static VeLivePlayerSupportResolutionSwitchError valueOf(String r100) {
        return (VeLivePlayerSupportResolutionSwitchError) r27.a.a(VeLivePlayerSupportResolutionSwitchError.class, r100);
    }

    public VeLivePlayerSupportResolutionSwitchError(String r100, int r101) {
        super(r100, r101);
    }
}

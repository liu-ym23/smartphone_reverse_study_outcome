package com.ss.videoarch.liveplayer;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerDef$VeLivePlayerStatus extends Enum<VeLivePlayerDef$VeLivePlayerStatus> {
    public static final VeLivePlayerDef$VeLivePlayerStatus VeLivePlayerStatusError = null;
    public static final VeLivePlayerDef$VeLivePlayerStatus VeLivePlayerStatusPaused = null;
    public static final VeLivePlayerDef$VeLivePlayerStatus VeLivePlayerStatusPlaying = null;
    public static final VeLivePlayerDef$VeLivePlayerStatus VeLivePlayerStatusPrepared = null;
    public static final VeLivePlayerDef$VeLivePlayerStatus VeLivePlayerStatusStopped = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerDef$VeLivePlayerStatus[] f458625a = null;

    static {
        VeLivePlayerDef$VeLivePlayerStatus r100 = new VeLivePlayerDef$VeLivePlayerStatus("VeLivePlayerStatusStopped", 0);
        VeLivePlayerStatusStopped = r100;
        VeLivePlayerDef$VeLivePlayerStatus r101 = new VeLivePlayerDef$VeLivePlayerStatus("VeLivePlayerStatusPaused", 1);
        VeLivePlayerStatusPaused = r101;
        VeLivePlayerDef$VeLivePlayerStatus r102 = new VeLivePlayerDef$VeLivePlayerStatus("VeLivePlayerStatusPrepared", 2);
        VeLivePlayerStatusPrepared = r102;
        VeLivePlayerDef$VeLivePlayerStatus r103 = new VeLivePlayerDef$VeLivePlayerStatus("VeLivePlayerStatusPlaying", 3);
        VeLivePlayerStatusPlaying = r103;
        VeLivePlayerDef$VeLivePlayerStatus r104 = new VeLivePlayerDef$VeLivePlayerStatus("VeLivePlayerStatusError", 4);
        VeLivePlayerStatusError = r104;
        f458625a = new VeLivePlayerDef$VeLivePlayerStatus[]{r100, r101, r102, r103, r104};
    }

    public static VeLivePlayerDef$VeLivePlayerStatus[] values() {
        return (VeLivePlayerDef$VeLivePlayerStatus[]) f458625a.clone();
    }

    public static VeLivePlayerDef$VeLivePlayerStatus valueOf(String r100) {
        return (VeLivePlayerDef$VeLivePlayerStatus) r27.a.a(VeLivePlayerDef$VeLivePlayerStatus.class, r100);
    }

    private VeLivePlayerDef$VeLivePlayerStatus(String r100, int r101) {
        super(r100, r101);
    }
}

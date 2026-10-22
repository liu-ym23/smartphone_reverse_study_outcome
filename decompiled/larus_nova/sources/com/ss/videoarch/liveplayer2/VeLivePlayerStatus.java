package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerStatus extends Enum<VeLivePlayerStatus> {
    public static final VeLivePlayerStatus VeLivePlayerStatusCompleted = null;
    public static final VeLivePlayerStatus VeLivePlayerStatusError = null;
    public static final VeLivePlayerStatus VeLivePlayerStatusIdel = null;
    public static final VeLivePlayerStatus VeLivePlayerStatusInitialized = null;
    public static final VeLivePlayerStatus VeLivePlayerStatusPaused = null;
    public static final VeLivePlayerStatus VeLivePlayerStatusPlaying = null;
    public static final VeLivePlayerStatus VeLivePlayerStatusPrepared = null;
    public static final VeLivePlayerStatus VeLivePlayerStatusPreparing = null;
    public static final VeLivePlayerStatus VeLivePlayerStatusStopped = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerStatus[] f459702a = null;

    static {
        VeLivePlayerStatus r100 = new VeLivePlayerStatus("VeLivePlayerStatusIdel", 0);
        VeLivePlayerStatusIdel = r100;
        VeLivePlayerStatus r101 = new VeLivePlayerStatus("VeLivePlayerStatusInitialized", 1);
        VeLivePlayerStatusInitialized = r101;
        VeLivePlayerStatus r102 = new VeLivePlayerStatus("VeLivePlayerStatusPreparing", 2);
        VeLivePlayerStatusPreparing = r102;
        VeLivePlayerStatus r103 = new VeLivePlayerStatus("VeLivePlayerStatusPrepared", 3);
        VeLivePlayerStatusPrepared = r103;
        VeLivePlayerStatus r104 = new VeLivePlayerStatus("VeLivePlayerStatusPlaying", 4);
        VeLivePlayerStatusPlaying = r104;
        VeLivePlayerStatus r105 = new VeLivePlayerStatus("VeLivePlayerStatusPaused", 5);
        VeLivePlayerStatusPaused = r105;
        VeLivePlayerStatus r110 = new VeLivePlayerStatus("VeLivePlayerStatusStopped", 6);
        VeLivePlayerStatusStopped = r110;
        VeLivePlayerStatus r111 = new VeLivePlayerStatus("VeLivePlayerStatusCompleted", 7);
        VeLivePlayerStatusCompleted = r111;
        VeLivePlayerStatus r112 = new VeLivePlayerStatus("VeLivePlayerStatusError", 8);
        VeLivePlayerStatusError = r112;
        f459702a = new VeLivePlayerStatus[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static VeLivePlayerStatus[] values() {
        return (VeLivePlayerStatus[]) f459702a.clone();
    }

    public static VeLivePlayerStatus valueOf(String r100) {
        return (VeLivePlayerStatus) r27.a.a(VeLivePlayerStatus.class, r100);
    }

    public VeLivePlayerStatus(String r100, int r101) {
        super(r100, r101);
    }
}

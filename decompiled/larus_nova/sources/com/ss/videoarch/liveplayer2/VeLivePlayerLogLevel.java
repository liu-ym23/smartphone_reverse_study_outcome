package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerLogLevel extends Enum<VeLivePlayerLogLevel> {
    public static final VeLivePlayerLogLevel VeLivePlayerLogLevelDebug = null;
    public static final VeLivePlayerLogLevel VeLivePlayerLogLevelError = null;
    public static final VeLivePlayerLogLevel VeLivePlayerLogLevelInfo = null;
    public static final VeLivePlayerLogLevel VeLivePlayerLogLevelNone = null;
    public static final VeLivePlayerLogLevel VeLivePlayerLogLevelVerbose = null;
    public static final VeLivePlayerLogLevel VeLivePlayerLogLevelWarn = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerLogLevel[] f459695a = null;

    static {
        VeLivePlayerLogLevel r100 = new VeLivePlayerLogLevel("VeLivePlayerLogLevelVerbose", 0);
        VeLivePlayerLogLevelVerbose = r100;
        VeLivePlayerLogLevel r101 = new VeLivePlayerLogLevel("VeLivePlayerLogLevelDebug", 1);
        VeLivePlayerLogLevelDebug = r101;
        VeLivePlayerLogLevel r102 = new VeLivePlayerLogLevel("VeLivePlayerLogLevelInfo", 2);
        VeLivePlayerLogLevelInfo = r102;
        VeLivePlayerLogLevel r103 = new VeLivePlayerLogLevel("VeLivePlayerLogLevelWarn", 3);
        VeLivePlayerLogLevelWarn = r103;
        VeLivePlayerLogLevel r104 = new VeLivePlayerLogLevel("VeLivePlayerLogLevelError", 4);
        VeLivePlayerLogLevelError = r104;
        VeLivePlayerLogLevel r105 = new VeLivePlayerLogLevel("VeLivePlayerLogLevelNone", 5);
        VeLivePlayerLogLevelNone = r105;
        f459695a = new VeLivePlayerLogLevel[]{r100, r101, r102, r103, r104, r105};
    }

    public static VeLivePlayerLogLevel[] values() {
        return (VeLivePlayerLogLevel[]) f459695a.clone();
    }

    public static VeLivePlayerLogLevel valueOf(String r100) {
        return (VeLivePlayerLogLevel) r27.a.a(VeLivePlayerLogLevel.class, r100);
    }

    public VeLivePlayerLogLevel(String r100, int r101) {
        super(r100, r101);
    }
}

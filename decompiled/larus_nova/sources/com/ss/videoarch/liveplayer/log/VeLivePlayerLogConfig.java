package com.ss.videoarch.liveplayer.log;

/* JADX INFO: loaded from: classes38.dex */
public final class VeLivePlayerLogConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f459384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f459385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f459386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f459387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f459388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f459389f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f459390g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f459391h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final VeLivePlayerLogLevel f459392i;

    public static final enum VeLivePlayerLogLevel extends Enum<VeLivePlayerLogLevel> {
        public static final VeLivePlayerLogLevel VeLivePlayerLogLevelDebug = null;
        public static final VeLivePlayerLogLevel VeLivePlayerLogLevelError = null;
        public static final VeLivePlayerLogLevel VeLivePlayerLogLevelInfo = null;
        public static final VeLivePlayerLogLevel VeLivePlayerLogLevelNone = null;
        public static final VeLivePlayerLogLevel VeLivePlayerLogLevelVerbose = null;
        public static final VeLivePlayerLogLevel VeLivePlayerLogLevelWarn = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VeLivePlayerLogLevel[] f459393a = null;

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
            f459393a = new VeLivePlayerLogLevel[]{r100, r101, r102, r103, r104, r105};
        }

        public static VeLivePlayerLogLevel[] values() {
            return (VeLivePlayerLogLevel[]) f459393a.clone();
        }

        public static VeLivePlayerLogLevel valueOf(String r100) {
            return (VeLivePlayerLogLevel) r27.a.a(VeLivePlayerLogLevel.class, r100);
        }

        private VeLivePlayerLogLevel(String r100, int r101) {
            super(r100, r101);
        }
    }

    public String toString() {
        return "VeLivePlayerLogConfig{deviceID='null', logPath='null', maxLogSizeM=" + this.f459384a + ", singleLogSizeM=" + this.f459385b + ", logExpireTimeS=" + this.f459386c + ", enableConsole=" + this.f459387d + ", enableLogFile=" + this.f459388e + ", queryUrl='" + this.f459389f + "', enableThreadLoop=" + this.f459390g + ", intervalMS=" + this.f459391h + ", logLevel=" + this.f459392i + '}';
    }

    public VeLivePlayerLogConfig() {
        this.f459384a = 100;
        this.f459385b = 2;
        this.f459386c = 604800;
        this.f459387d = true;
        this.f459388e = true;
        this.f459389f = "";
        this.f459390g = true;
        this.f459391h = 120000;
        this.f459392i = VeLivePlayerLogLevel.VeLivePlayerLogLevelVerbose;
    }
}

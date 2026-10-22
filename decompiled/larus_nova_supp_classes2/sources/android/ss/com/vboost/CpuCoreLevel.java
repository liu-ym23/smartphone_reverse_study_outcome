package android.ss.com.vboost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final enum CpuCoreLevel extends Enum<CpuCoreLevel> {
    private static final /* synthetic */ CpuCoreLevel[] $VALUES = null;
    public static final CpuCoreLevel LEVEL_0 = null;
    public static final CpuCoreLevel LEVEL_1 = null;
    private int index;
    private String name;

    static {
        CpuCoreLevel r0 = new CpuCoreLevel("LEVEL_0", 0, "level_0", 0);
        LEVEL_0 = r0;
        CpuCoreLevel r1 = new CpuCoreLevel("LEVEL_1", 1, "level_1", 1);
        LEVEL_1 = r1;
        $VALUES = new CpuCoreLevel[]{r0, r1};
    }

    private CpuCoreLevel(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.name = r3;
        this.index = r4;
    }

    public static CpuCoreLevel valueOf(String r1) {
        return (CpuCoreLevel) r27.a.a(CpuCoreLevel.class, r1);
    }

    public static CpuCoreLevel[] values() {
        return (CpuCoreLevel[]) $VALUES.clone();
    }
}

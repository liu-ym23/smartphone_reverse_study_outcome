package android.ss.com.vboost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final enum CapabilityType extends Enum<CapabilityType> {
    private static final /* synthetic */ CapabilityType[] $VALUES = null;
    public static final CapabilityType BUS_FREQ_MAX = null;
    public static final CapabilityType BUS_FREQ_MIN = null;
    public static final CapabilityType CPU_AFFINITY = null;
    public static final CapabilityType CPU_CORE_MAX = null;
    public static final CapabilityType CPU_CORE_MIN = null;
    public static final CapabilityType CPU_FREQ_MAX = null;
    public static final CapabilityType CPU_FREQ_MIN = null;
    public static final CapabilityType GPU_FREQ_MAX = null;
    public static final CapabilityType GPU_FREQ_MIN = null;
    public static final CapabilityType IDLE_STATE = null;
    public static final CapabilityType IO_PRELOAD = null;
    public static final CapabilityType NETWORK_ENHANCE = null;
    public static final CapabilityType PRESET_SCENE = null;
    public static final CapabilityType TASK_PRIORITY = null;
    public static final CapabilityType THUMB_FETCH = null;
    public static final CapabilityType TYPE_MAX = null;
    public static final CapabilityType TYPE_MIN = null;
    public static final CapabilityType UFS_FREQ_MAX = null;
    public static final CapabilityType UFS_FREQ_MIN = null;
    public static final CapabilityType VIBRATE_ENHANCE = null;
    private int index;
    private String name;

    static {
        CapabilityType r0 = new CapabilityType("CPU_FREQ_MIN", 0, "cpu_freq_min", 1);
        CPU_FREQ_MIN = r0;
        CapabilityType r1 = new CapabilityType("CPU_FREQ_MAX", 1, "cpu_freq_max", 2);
        CPU_FREQ_MAX = r1;
        CapabilityType r3 = new CapabilityType("CPU_CORE_MIN", 2, "cpu_core_min", 3);
        CPU_CORE_MIN = r3;
        CapabilityType r5 = new CapabilityType("CPU_CORE_MAX", 3, "cpu_core_max", 4);
        CPU_CORE_MAX = r5;
        CapabilityType r7 = new CapabilityType("GPU_FREQ_MIN", 4, "gpu_freq_min", 5);
        GPU_FREQ_MIN = r7;
        CapabilityType r9 = new CapabilityType("GPU_FREQ_MAX", 5, "gpu_freq_max", 6);
        GPU_FREQ_MAX = r9;
        CapabilityType r11 = new CapabilityType("BUS_FREQ_MIN", 6, "bus_freq_min", 7);
        BUS_FREQ_MIN = r11;
        CapabilityType r13 = new CapabilityType("BUS_FREQ_MAX", 7, "bus_freq_max", 8);
        BUS_FREQ_MAX = r13;
        CapabilityType r14 = new CapabilityType("UFS_FREQ_MIN", 8, "ufs_freq_min", 9);
        UFS_FREQ_MIN = r14;
        CapabilityType r12 = new CapabilityType("UFS_FREQ_MAX", 9, "ufs_freq_max", 10);
        UFS_FREQ_MAX = r12;
        CapabilityType r10 = new CapabilityType("TASK_PRIORITY", 10, "task_priority", 11);
        TASK_PRIORITY = r10;
        CapabilityType r8 = new CapabilityType("CPU_AFFINITY", 11, "cpu_affinity", 12);
        CPU_AFFINITY = r8;
        CapabilityType r6 = new CapabilityType("IDLE_STATE", 12, "idle_state", 13);
        IDLE_STATE = r6;
        CapabilityType r4 = new CapabilityType("IO_PRELOAD", 13, "io_preload", 14);
        IO_PRELOAD = r4;
        CapabilityType r2 = new CapabilityType("NETWORK_ENHANCE", 14, "network_enhance", 15);
        NETWORK_ENHANCE = r2;
        CapabilityType r15 = new CapabilityType("PRESET_SCENE", 15, "preset_scene", 16);
        PRESET_SCENE = r15;
        CapabilityType r16 = new CapabilityType("THUMB_FETCH", 16, "thumb_fetch", 17);
        THUMB_FETCH = r16;
        CapabilityType r17 = new CapabilityType("VIBRATE_ENHANCE", 17, "vibrate_enhance", 18);
        VIBRATE_ENHANCE = r17;
        CapabilityType r18 = new CapabilityType("TYPE_MIN", 18, r0);
        TYPE_MIN = r18;
        CapabilityType r19 = new CapabilityType("TYPE_MAX", 19, r17);
        TYPE_MAX = r19;
        $VALUES = new CapabilityType[]{r0, r1, r3, r5, r7, r9, r11, r13, r14, r12, r10, r8, r6, r4, r2, r15, r16, r17, r18, r19};
    }

    private CapabilityType(String r1, int r2, CapabilityType r3) {
        super(r1, r2);
        this.name = r3.name;
        this.index = r3.index;
    }

    private CapabilityType(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.name = r3;
        this.index = r4;
    }

    public static CapabilityType valueOf(int r5) {
        CapabilityType[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        CapabilityType r3 = r0[r2];
        if (r5 == r3.index) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new RuntimeException("Can't find enum type for index: " + r5);
    }

    public static CapabilityType valueOf(String r1) {
        return (CapabilityType) r27.a.a(CapabilityType.class, r1);
    }

    public static CapabilityType[] values() {
        return (CapabilityType[]) $VALUES.clone();
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }
}

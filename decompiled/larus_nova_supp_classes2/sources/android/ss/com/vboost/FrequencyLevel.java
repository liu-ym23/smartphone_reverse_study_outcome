package android.ss.com.vboost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final enum FrequencyLevel extends Enum<FrequencyLevel> {
    private static final /* synthetic */ FrequencyLevel[] $VALUES = null;
    public static final FrequencyLevel LEVEL_0 = null;
    public static final FrequencyLevel LEVEL_1 = null;
    public static final FrequencyLevel LEVEL_2 = null;
    public static final FrequencyLevel LEVEL_3 = null;
    public static final FrequencyLevel LEVEL_4 = null;
    public static final FrequencyLevel LEVEL_5 = null;
    public static final FrequencyLevel LEVEL_6 = null;
    public static final FrequencyLevel LEVEL_7 = null;
    public static final FrequencyLevel LEVEL_8 = null;
    public static final FrequencyLevel LEVEL_9 = null;
    private int index;
    private String name;

    static {
        FrequencyLevel r0 = new FrequencyLevel("LEVEL_0", 0, "level_0", 0);
        LEVEL_0 = r0;
        FrequencyLevel r1 = new FrequencyLevel("LEVEL_1", 1, "level_1", 1);
        LEVEL_1 = r1;
        FrequencyLevel r2 = new FrequencyLevel("LEVEL_2", 2, "level_2", 2);
        LEVEL_2 = r2;
        FrequencyLevel r4 = new FrequencyLevel("LEVEL_3", 3, "level_3", 3);
        LEVEL_3 = r4;
        FrequencyLevel r6 = new FrequencyLevel("LEVEL_4", 4, "level_4", 4);
        LEVEL_4 = r6;
        FrequencyLevel r8 = new FrequencyLevel("LEVEL_5", 5, "level_5", 5);
        LEVEL_5 = r8;
        FrequencyLevel r10 = new FrequencyLevel("LEVEL_6", 6, "level_6", 6);
        LEVEL_6 = r10;
        FrequencyLevel r12 = new FrequencyLevel("LEVEL_7", 7, "level_7", 7);
        LEVEL_7 = r12;
        FrequencyLevel r14 = new FrequencyLevel("LEVEL_8", 8, "level_8", 8);
        LEVEL_8 = r14;
        FrequencyLevel r13 = new FrequencyLevel("LEVEL_9", 9, "level_9", 9);
        LEVEL_9 = r13;
        $VALUES = new FrequencyLevel[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13};
    }

    private FrequencyLevel(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.name = r3;
        this.index = r4;
    }

    public static FrequencyLevel valueOf(int r0) {
        switch(r0) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return LEVEL_9;
    L8:
        return LEVEL_8;
    L10:
        return LEVEL_7;
    L12:
        return LEVEL_6;
    L14:
        return LEVEL_5;
    L16:
        return LEVEL_4;
    L18:
        return LEVEL_3;
    L20:
        return LEVEL_2;
    L22:
        return LEVEL_1;
    L24:
        return LEVEL_0;
    }

    public static FrequencyLevel valueOf(String r1) {
        return (FrequencyLevel) r27.a.a(FrequencyLevel.class, r1);
    }

    public static FrequencyLevel[] values() {
        return (FrequencyLevel[]) $VALUES.clone();
    }
}

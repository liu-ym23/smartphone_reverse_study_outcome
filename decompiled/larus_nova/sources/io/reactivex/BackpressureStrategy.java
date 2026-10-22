package io.reactivex;

/* JADX INFO: loaded from: classes41.dex */
public final enum BackpressureStrategy extends Enum<BackpressureStrategy> {
    private static final /* synthetic */ BackpressureStrategy[] $VALUES = null;
    public static final BackpressureStrategy BUFFER = null;
    public static final BackpressureStrategy DROP = null;
    public static final BackpressureStrategy ERROR = null;
    public static final BackpressureStrategy LATEST = null;
    public static final BackpressureStrategy MISSING = null;

    static {
        BackpressureStrategy r100 = new BackpressureStrategy("MISSING", 0);
        MISSING = r100;
        BackpressureStrategy r101 = new BackpressureStrategy("ERROR", 1);
        ERROR = r101;
        BackpressureStrategy r102 = new BackpressureStrategy("BUFFER", 2);
        BUFFER = r102;
        BackpressureStrategy r103 = new BackpressureStrategy("DROP", 3);
        DROP = r103;
        BackpressureStrategy r104 = new BackpressureStrategy("LATEST", 4);
        LATEST = r104;
        $VALUES = new BackpressureStrategy[]{r100, r101, r102, r103, r104};
    }

    public static BackpressureStrategy[] values() {
        return (BackpressureStrategy[]) $VALUES.clone();
    }

    public static BackpressureStrategy valueOf(String r100) {
        return (BackpressureStrategy) r27.a.a(BackpressureStrategy.class, r100);
    }

    private BackpressureStrategy(String r100, int r101) {
        super(r100, r101);
    }
}

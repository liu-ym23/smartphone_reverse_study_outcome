package androidx.camera.core.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final enum Timebase extends Enum<Timebase> {
    private static final /* synthetic */ Timebase[] $VALUES = null;
    public static final Timebase REALTIME = null;
    public static final Timebase UPTIME = null;

    private static /* synthetic */ Timebase[] $values() {
        return new Timebase[]{UPTIME, REALTIME};
    }

    static {
        UPTIME = new Timebase("UPTIME", 0);
        REALTIME = new Timebase("REALTIME", 1);
        $VALUES = $values();
    }

    public static Timebase[] values() {
        return (Timebase[]) $VALUES.clone();
    }

    public static Timebase valueOf(String r1) {
        return (Timebase) r27.a.a(Timebase.class, r1);
    }

    private Timebase(String r1, int r2) {
        super(r1, r2);
    }
}

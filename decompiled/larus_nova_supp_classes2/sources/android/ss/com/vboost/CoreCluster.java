package android.ss.com.vboost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final enum CoreCluster extends Enum<CoreCluster> {
    private static final /* synthetic */ CoreCluster[] $VALUES = null;
    public static final CoreCluster GOLD = null;
    public static final CoreCluster SILVER = null;
    public static final CoreCluster SUPER = null;
    private int index;

    static {
        CoreCluster r0 = new CoreCluster("SILVER", 0, 1);
        SILVER = r0;
        CoreCluster r1 = new CoreCluster("GOLD", 1, 2);
        GOLD = r1;
        CoreCluster r4 = new CoreCluster("SUPER", 2, 3);
        SUPER = r4;
        $VALUES = new CoreCluster[]{r0, r1, r4};
    }

    private CoreCluster(String r1, int r2, int r3) {
        super(r1, r2);
        this.index = r3;
    }

    public static CoreCluster valueOf(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return SUPER;
    L13:
        return GOLD;
    L15:
        return SILVER;
    }

    public static CoreCluster valueOf(String r1) {
        return (CoreCluster) r27.a.a(CoreCluster.class, r1);
    }

    public static CoreCluster[] values() {
        return (CoreCluster[]) $VALUES.clone();
    }

    public int getIndex() {
        return this.index;
    }
}

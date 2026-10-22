package io.michaelrocks.libphonenumber.android;

/* JADX INFO: loaded from: classes41.dex */
public final enum ShortNumberInfo$ShortNumberCost extends Enum<ShortNumberInfo$ShortNumberCost> {
    public static final ShortNumberInfo$ShortNumberCost PREMIUM_RATE = null;
    public static final ShortNumberInfo$ShortNumberCost STANDARD_RATE = null;
    public static final ShortNumberInfo$ShortNumberCost TOLL_FREE = null;
    public static final ShortNumberInfo$ShortNumberCost UNKNOWN_COST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShortNumberInfo$ShortNumberCost[] f492236a = null;

    static {
        ShortNumberInfo$ShortNumberCost r100 = new ShortNumberInfo$ShortNumberCost("TOLL_FREE", 0);
        TOLL_FREE = r100;
        ShortNumberInfo$ShortNumberCost r101 = new ShortNumberInfo$ShortNumberCost("STANDARD_RATE", 1);
        STANDARD_RATE = r101;
        ShortNumberInfo$ShortNumberCost r102 = new ShortNumberInfo$ShortNumberCost("PREMIUM_RATE", 2);
        PREMIUM_RATE = r102;
        ShortNumberInfo$ShortNumberCost r103 = new ShortNumberInfo$ShortNumberCost("UNKNOWN_COST", 3);
        UNKNOWN_COST = r103;
        f492236a = new ShortNumberInfo$ShortNumberCost[]{r100, r101, r102, r103};
    }

    public static ShortNumberInfo$ShortNumberCost[] values() {
        return (ShortNumberInfo$ShortNumberCost[]) f492236a.clone();
    }

    public static ShortNumberInfo$ShortNumberCost valueOf(String r100) {
        return (ShortNumberInfo$ShortNumberCost) r27.a.a(ShortNumberInfo$ShortNumberCost.class, r100);
    }

    public ShortNumberInfo$ShortNumberCost(String r100, int r101) {
        super(r100, r101);
    }
}

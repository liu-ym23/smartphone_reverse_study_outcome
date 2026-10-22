package io.opentelemetry.sdk.metrics;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum InstrumentType extends Enum<InstrumentType> {
    public static final InstrumentType COUNTER = null;
    public static final InstrumentType HISTOGRAM = null;
    public static final InstrumentType OBSERVABLE_COUNTER = null;
    public static final InstrumentType OBSERVABLE_GAUGE = null;
    public static final InstrumentType OBSERVABLE_UP_DOWN_COUNTER = null;
    public static final InstrumentType UP_DOWN_COUNTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InstrumentType[] f492720a = null;

    static {
        InstrumentType r100 = new InstrumentType("COUNTER", 0);
        COUNTER = r100;
        InstrumentType r101 = new InstrumentType("UP_DOWN_COUNTER", 1);
        UP_DOWN_COUNTER = r101;
        InstrumentType r102 = new InstrumentType("HISTOGRAM", 2);
        HISTOGRAM = r102;
        InstrumentType r103 = new InstrumentType("OBSERVABLE_COUNTER", 3);
        OBSERVABLE_COUNTER = r103;
        InstrumentType r104 = new InstrumentType("OBSERVABLE_UP_DOWN_COUNTER", 4);
        OBSERVABLE_UP_DOWN_COUNTER = r104;
        InstrumentType r105 = new InstrumentType("OBSERVABLE_GAUGE", 5);
        OBSERVABLE_GAUGE = r105;
        f492720a = new InstrumentType[]{r100, r101, r102, r103, r104, r105};
    }

    public static InstrumentType[] values() {
        return (InstrumentType[]) f492720a.clone();
    }

    public static InstrumentType valueOf(String r100) {
        return (InstrumentType) a.a(InstrumentType.class, r100);
    }

    public InstrumentType(String r100, int r101) {
        super(r100, r101);
    }
}

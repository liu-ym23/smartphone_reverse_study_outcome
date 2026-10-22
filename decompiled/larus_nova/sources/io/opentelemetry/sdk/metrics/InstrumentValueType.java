package io.opentelemetry.sdk.metrics;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum InstrumentValueType extends Enum<InstrumentValueType> {
    public static final InstrumentValueType DOUBLE = null;
    public static final InstrumentValueType LONG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InstrumentValueType[] f492721a = null;

    static {
        InstrumentValueType r100 = new InstrumentValueType("LONG", 0);
        LONG = r100;
        InstrumentValueType r101 = new InstrumentValueType("DOUBLE", 1);
        DOUBLE = r101;
        f492721a = new InstrumentValueType[]{r100, r101};
    }

    public static InstrumentValueType[] values() {
        return (InstrumentValueType[]) f492721a.clone();
    }

    public static InstrumentValueType valueOf(String r100) {
        return (InstrumentValueType) a.a(InstrumentValueType.class, r100);
    }

    public InstrumentValueType(String r100, int r101) {
        super(r100, r101);
    }
}

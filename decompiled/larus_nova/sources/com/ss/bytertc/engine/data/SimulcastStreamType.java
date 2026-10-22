package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum SimulcastStreamType extends Enum<SimulcastStreamType> {
    private static final /* synthetic */ SimulcastStreamType[] $VALUES = null;
    public static final SimulcastStreamType SIMULCAST_STREAM_TYPE_HIGH = null;
    public static final SimulcastStreamType SIMULCAST_STREAM_TYPE_LOW = null;
    public static final SimulcastStreamType SIMULCAST_STREAM_TYPE_MID = null;
    public static final SimulcastStreamType SIMULCAST_STREAM_TYPE_WEAK = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.SimulcastStreamType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$SimulcastStreamType = null;

        static {
            int[] r100 = new int[SimulcastStreamType.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$SimulcastStreamType = r100;
            r100[SimulcastStreamType.SIMULCAST_STREAM_TYPE_WEAK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$bytertc$engine$data$SimulcastStreamType[SimulcastStreamType.SIMULCAST_STREAM_TYPE_LOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$bytertc$engine$data$SimulcastStreamType[SimulcastStreamType.SIMULCAST_STREAM_TYPE_MID.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$bytertc$engine$data$SimulcastStreamType[SimulcastStreamType.SIMULCAST_STREAM_TYPE_HIGH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        SimulcastStreamType r100 = new SimulcastStreamType("SIMULCAST_STREAM_TYPE_WEAK", 0, 0);
        SIMULCAST_STREAM_TYPE_WEAK = r100;
        SimulcastStreamType r101 = new SimulcastStreamType("SIMULCAST_STREAM_TYPE_LOW", 1, 1);
        SIMULCAST_STREAM_TYPE_LOW = r101;
        SimulcastStreamType r102 = new SimulcastStreamType("SIMULCAST_STREAM_TYPE_MID", 2, 2);
        SIMULCAST_STREAM_TYPE_MID = r102;
        SimulcastStreamType r103 = new SimulcastStreamType("SIMULCAST_STREAM_TYPE_HIGH", 3, 3);
        SIMULCAST_STREAM_TYPE_HIGH = r103;
        $VALUES = new SimulcastStreamType[]{r100, r101, r102, r103};
    }

    public static SimulcastStreamType[] values() {
        return (SimulcastStreamType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$SimulcastStreamType[ordinal()];
        if (r100 != 1) goto L5;
        return "kSimulcastStreamTypeWeak";
    L5:
        if (r100 != 2) goto L7;
        return "kSimulcastStreamTypeLow";
    L7:
        if (r100 != 3) goto L9;
        return "kSimulcastStreamTypeMid";
    L9:
        if (r100 == 4) goto L12;
        return "valid";
    L12:
        return "kSimulcastStreamTypeHigh";
    }

    public int value() {
        return this.value;
    }

    public static SimulcastStreamType fromId(int r100) {
        SimulcastStreamType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        SimulcastStreamType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static SimulcastStreamType valueOf(String r100) {
        return (SimulcastStreamType) a.a(SimulcastStreamType.class, r100);
    }

    private SimulcastStreamType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public final enum EventTraceType extends Enum<EventTraceType> {
    public static final EventTraceType CUSTOM_DOUBLE = null;
    public static final EventTraceType CUSTOM_INT = null;
    public static final EventTraceType CUSTOM_STRING = null;
    public static final EventTraceType DURATION = null;
    public static final EventTraceType TIMESTAMP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventTraceType[] f455333a = null;
    private final int mVal;

    static {
        EventTraceType r100 = new EventTraceType("DURATION", 0, 0);
        DURATION = r100;
        EventTraceType r101 = new EventTraceType("TIMESTAMP", 1, 1);
        TIMESTAMP = r101;
        EventTraceType r102 = new EventTraceType("CUSTOM_INT", 2, 2);
        CUSTOM_INT = r102;
        EventTraceType r103 = new EventTraceType("CUSTOM_DOUBLE", 3, 3);
        CUSTOM_DOUBLE = r103;
        EventTraceType r104 = new EventTraceType("CUSTOM_STRING", 4, 4);
        CUSTOM_STRING = r104;
        f455333a = new EventTraceType[]{r100, r101, r102, r103, r104};
    }

    public static EventTraceType[] values() {
        return (EventTraceType[]) f455333a.clone();
    }

    public int getValue() {
        return this.mVal;
    }

    public static EventTraceType valueOf(String r100) {
        return (EventTraceType) r27.a.a(EventTraceType.class, r100);
    }

    public EventTraceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.mVal = r102;
    }
}

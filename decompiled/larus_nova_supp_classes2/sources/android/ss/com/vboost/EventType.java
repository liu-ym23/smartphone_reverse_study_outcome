package android.ss.com.vboost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final enum EventType extends Enum<EventType> {
    private static final /* synthetic */ EventType[] $VALUES = null;
    public static final EventType EVENT_NET = null;
    public static final EventType EVENT_TEMP = null;
    private int index;
    private String name;

    static {
        EventType r0 = new EventType("EVENT_TEMP", 0, "event_temp", 0);
        EVENT_TEMP = r0;
        EventType r1 = new EventType("EVENT_NET", 1, "event_net", 1);
        EVENT_NET = r1;
        $VALUES = new EventType[]{r0, r1};
    }

    private EventType(String r1, int r2, EventType r3) {
        super(r1, r2);
        this.name = r3.name;
        this.index = r3.index;
    }

    private EventType(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.name = r3;
        this.index = r4;
    }

    public static EventType valueOf(int r5) {
        EventType[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        EventType r3 = r0[r2];
        if (r5 == r3.index) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new RuntimeException("Can't find enum type for index: " + r5);
    }

    public static EventType valueOf(String r1) {
        return (EventType) r27.a.a(EventType.class, r1);
    }

    public static EventType[] values() {
        return (EventType[]) $VALUES.clone();
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }
}

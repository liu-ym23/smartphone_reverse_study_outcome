package com.lynx.devtoolwrapper;

/* JADX INFO: loaded from: classes32.dex */
public final enum DevToolState extends Enum<DevToolState> {
    private static final /* synthetic */ DevToolState[] $VALUES = null;
    public static final DevToolState ATTACHED = null;
    public static final DevToolState CONNECTED = null;
    public static final DevToolState ENABLED = null;
    public static final DevToolState INITIALIZED = null;
    public static final DevToolState UNAVAILABLE = null;

    static {
        DevToolState r100 = new DevToolState("UNAVAILABLE", 0);
        UNAVAILABLE = r100;
        DevToolState r101 = new DevToolState("ATTACHED", 1);
        ATTACHED = r101;
        DevToolState r102 = new DevToolState("ENABLED", 2);
        ENABLED = r102;
        DevToolState r103 = new DevToolState("INITIALIZED", 3);
        INITIALIZED = r103;
        DevToolState r104 = new DevToolState("CONNECTED", 4);
        CONNECTED = r104;
        $VALUES = new DevToolState[]{r100, r101, r102, r103, r104};
    }

    public static DevToolState[] values() {
        return (DevToolState[]) $VALUES.clone();
    }

    public static DevToolState valueOf(String r100) {
        return (DevToolState) r27.a.a(DevToolState.class, r100);
    }

    private DevToolState(String r100, int r101) {
        super(r100, r101);
    }
}

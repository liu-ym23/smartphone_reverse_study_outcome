package com.ss.cast.source.api;

/* JADX INFO: loaded from: classes40.dex */
public final enum ConnectState extends Enum<ConnectState> {
    public static final ConnectState STATE_CONNECTED = null;
    public static final ConnectState STATE_CONNECTING = null;
    public static final ConnectState STATE_DISCONNECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConnectState[] f456547a = null;

    static {
        ConnectState r100 = new ConnectState("STATE_DISCONNECTED", 0);
        STATE_DISCONNECTED = r100;
        ConnectState r101 = new ConnectState("STATE_CONNECTING", 1);
        STATE_CONNECTING = r101;
        ConnectState r102 = new ConnectState("STATE_CONNECTED", 2);
        STATE_CONNECTED = r102;
        f456547a = new ConnectState[]{r100, r101, r102};
    }

    public static ConnectState[] values() {
        return (ConnectState[]) f456547a.clone();
    }

    public static ConnectState valueOf(String r100) {
        return (ConnectState) r27.a.a(ConnectState.class, r100);
    }

    public ConnectState(String r100, int r101) {
        super(r100, r101);
    }
}

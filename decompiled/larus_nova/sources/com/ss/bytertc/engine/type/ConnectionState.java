package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum ConnectionState extends Enum<ConnectionState> {
    private static final /* synthetic */ ConnectionState[] $VALUES = null;
    public static final ConnectionState CONNECTION_STATE_CONNECTED = null;
    public static final ConnectionState CONNECTION_STATE_CONNECTING = null;
    public static final ConnectionState CONNECTION_STATE_DISCONNECTED = null;
    public static final ConnectionState CONNECTION_STATE_FAILED = null;
    public static final ConnectionState CONNECTION_STATE_LOST = null;
    public static final ConnectionState CONNECTION_STATE_RECONNECTED = null;
    public static final ConnectionState CONNECTION_STATE_RECONNECTING = null;
    private int value;

    static {
        ConnectionState r100 = new ConnectionState("CONNECTION_STATE_DISCONNECTED", 0, 1);
        CONNECTION_STATE_DISCONNECTED = r100;
        ConnectionState r101 = new ConnectionState("CONNECTION_STATE_CONNECTING", 1, 2);
        CONNECTION_STATE_CONNECTING = r101;
        ConnectionState r102 = new ConnectionState("CONNECTION_STATE_CONNECTED", 2, 3);
        CONNECTION_STATE_CONNECTED = r102;
        ConnectionState r103 = new ConnectionState("CONNECTION_STATE_RECONNECTING", 3, 4);
        CONNECTION_STATE_RECONNECTING = r103;
        ConnectionState r104 = new ConnectionState("CONNECTION_STATE_RECONNECTED", 4, 5);
        CONNECTION_STATE_RECONNECTED = r104;
        ConnectionState r110 = new ConnectionState("CONNECTION_STATE_LOST", 5, 6);
        CONNECTION_STATE_LOST = r110;
        ConnectionState r111 = new ConnectionState("CONNECTION_STATE_FAILED", 6, 7);
        CONNECTION_STATE_FAILED = r111;
        $VALUES = new ConnectionState[]{r100, r101, r102, r103, r104, r110, r111};
    }

    public static ConnectionState[] values() {
        return (ConnectionState[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static ConnectionState fromId(int r100) {
        ConnectionState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        ConnectionState r104 = r101[r103];
        if (r104.getValue() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return CONNECTION_STATE_DISCONNECTED;
    }

    public static ConnectionState valueOf(String r100) {
        return (ConnectionState) a.a(ConnectionState.class, r100);
    }

    private ConnectionState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.bytedance.common.wschannel.event;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum ConnectionState extends Enum<ConnectionState> {
    private static final /* synthetic */ ConnectionState[] $VALUES = null;
    public static final ConnectionState CONNECTED = null;
    public static final ConnectionState CONNECTING = null;
    public static final ConnectionState CONNECTION_UNKNOWN = null;
    public static final ConnectionState CONNECT_CLOSED = null;
    public static final ConnectionState CONNECT_FAILED = null;
    final int mTypeValue;

    static {
        ConnectionState r100 = new ConnectionState("CONNECTION_UNKNOWN", 0, 1);
        CONNECTION_UNKNOWN = r100;
        ConnectionState r101 = new ConnectionState("CONNECTING", 1, 2);
        CONNECTING = r101;
        ConnectionState r102 = new ConnectionState("CONNECT_FAILED", 2, 4);
        CONNECT_FAILED = r102;
        ConnectionState r103 = new ConnectionState("CONNECT_CLOSED", 3, 8);
        CONNECT_CLOSED = r103;
        ConnectionState r104 = new ConnectionState("CONNECTED", 4, 16);
        CONNECTED = r104;
        $VALUES = new ConnectionState[]{r100, r101, r102, r103, r104};
    }

    public static ConnectionState[] values() {
        return (ConnectionState[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ConnectionState{State=" + this.mTypeValue + '}';
    }

    public int getTypeValue() {
        return this.mTypeValue;
    }

    public static ConnectionState valueOf(String r100) {
        return (ConnectionState) a.a(ConnectionState.class, r100);
    }

    private ConnectionState(String r100, int r101, int r102) {
        super(r100, r101);
        this.mTypeValue = r102;
    }
}

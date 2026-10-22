package com.lynx.debugrouter;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum ConnectionType extends Enum<ConnectionType> {
    private static final /* synthetic */ ConnectionType[] $VALUES = null;
    public static final ConnectionType USB = null;
    public static final ConnectionType WebSocket = null;

    static {
        ConnectionType r100 = new ConnectionType("WebSocket", 0);
        WebSocket = r100;
        ConnectionType r101 = new ConnectionType("USB", 1);
        USB = r101;
        $VALUES = new ConnectionType[]{r100, r101};
    }

    public static ConnectionType[] values() {
        return (ConnectionType[]) $VALUES.clone();
    }

    public static ConnectionType valueOf(String r100) {
        return (ConnectionType) a.a(ConnectionType.class, r100);
    }

    private ConnectionType(String r100, int r101) {
        super(r100, r101);
    }
}

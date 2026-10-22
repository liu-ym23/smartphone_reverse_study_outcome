package com.bytedance.debugrouter;

import com.byted.cast.common.bean.State;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum ConnectionState extends Enum<ConnectionState> {
    private static final /* synthetic */ ConnectionState[] $VALUES = null;
    public static final ConnectionState CONNECTED = null;
    public static final ConnectionState CONNECTING = null;
    public static final ConnectionState DISCONNECTED = null;
    public static final ConnectionState DISCONNECTING = null;

    static {
        ConnectionState r100 = new ConnectionState(State.DISCONNECTED, 0);
        DISCONNECTED = r100;
        ConnectionState r101 = new ConnectionState("DISCONNECTING", 1);
        DISCONNECTING = r101;
        ConnectionState r102 = new ConnectionState("CONNECTING", 2);
        CONNECTING = r102;
        ConnectionState r103 = new ConnectionState("CONNECTED", 3);
        CONNECTED = r103;
        $VALUES = new ConnectionState[]{r100, r101, r102, r103};
    }

    public static ConnectionState[] values() {
        return (ConnectionState[]) $VALUES.clone();
    }

    public static ConnectionState valueOf(String r100) {
        return (ConnectionState) a.a(ConnectionState.class, r100);
    }

    private ConnectionState(String r100, int r101) {
        super(r100, r101);
    }
}

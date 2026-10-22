package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
final enum ConnectionInfo extends Enum<ConnectionInfo> {
    private static final /* synthetic */ ConnectionInfo[] $VALUES = null;
    public static final ConnectionInfo CONNECTION_INFO_DEPRECATED_SPDY3 = null;
    public static final ConnectionInfo CONNECTION_INFO_HTTP1_0 = null;
    public static final ConnectionInfo CONNECTION_INFO_HTTP1_1 = null;
    public static final ConnectionInfo CONNECTION_INFO_HTTP2 = null;
    public static final ConnectionInfo CONNECTION_INFO_QUIC_UNKNOWN_VERSION = null;
    public static final ConnectionInfo CONNECTION_INFO_UNKNOWN = null;
    final int mValue;

    static {
        ConnectionInfo r100 = new ConnectionInfo("CONNECTION_INFO_UNKNOWN", 0, 0);
        CONNECTION_INFO_UNKNOWN = r100;
        ConnectionInfo r101 = new ConnectionInfo("CONNECTION_INFO_HTTP1_1", 1, 1);
        CONNECTION_INFO_HTTP1_1 = r101;
        ConnectionInfo r102 = new ConnectionInfo("CONNECTION_INFO_DEPRECATED_SPDY3", 2, 3);
        CONNECTION_INFO_DEPRECATED_SPDY3 = r102;
        ConnectionInfo r103 = new ConnectionInfo("CONNECTION_INFO_HTTP2", 3, 4);
        CONNECTION_INFO_HTTP2 = r103;
        ConnectionInfo r104 = new ConnectionInfo("CONNECTION_INFO_QUIC_UNKNOWN_VERSION", 4, 5);
        CONNECTION_INFO_QUIC_UNKNOWN_VERSION = r104;
        ConnectionInfo r110 = new ConnectionInfo("CONNECTION_INFO_HTTP1_0", 5, 9);
        CONNECTION_INFO_HTTP1_0 = r110;
        $VALUES = new ConnectionInfo[]{r100, r101, r102, r103, r104, r110};
    }

    public static ConnectionInfo[] values() {
        return (ConnectionInfo[]) $VALUES.clone();
    }

    public static ConnectionInfo valueOf(String r100) {
        return (ConnectionInfo) a.a(ConnectionInfo.class, r100);
    }

    private ConnectionInfo(String r100, int r101, int r102) {
        super(r100, r101);
        this.mValue = r102;
    }
}

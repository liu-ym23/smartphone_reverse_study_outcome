package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
final enum HandshakeType extends Enum<HandshakeType> {
    private static final /* synthetic */ HandshakeType[] $VALUES = null;
    public static final HandshakeType HANDSHAKE_FULL = null;
    public static final HandshakeType HANDSHAKE_RESUME = null;
    public static final HandshakeType HANDSHAKE_UNKNOWN = null;

    static {
        HandshakeType r100 = new HandshakeType("HANDSHAKE_UNKNOWN", 0);
        HANDSHAKE_UNKNOWN = r100;
        HandshakeType r101 = new HandshakeType("HANDSHAKE_RESUME", 1);
        HANDSHAKE_RESUME = r101;
        HandshakeType r102 = new HandshakeType("HANDSHAKE_FULL", 2);
        HANDSHAKE_FULL = r102;
        $VALUES = new HandshakeType[]{r100, r101, r102};
    }

    public static HandshakeType[] values() {
        return (HandshakeType[]) $VALUES.clone();
    }

    public static HandshakeType valueOf(String r100) {
        return (HandshakeType) a.a(HandshakeType.class, r100);
    }

    private HandshakeType(String r100, int r101) {
        super(r100, r101);
    }
}

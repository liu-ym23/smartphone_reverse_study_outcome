package com.hihonor.android.softsim;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum ConnectStatusType extends Enum<ConnectStatusType> {
    public static final ConnectStatusType CLIENT_CARD_REMOVED = null;
    public static final ConnectStatusType CLIENT_CONNECTED = null;
    public static final ConnectStatusType CLIENT_DISCONNECTED = null;
    public static final ConnectStatusType CONNECT_CLIENT = null;
    public static final ConnectStatusType DISCONNECT_CLIENT = null;
    public static final ConnectStatusType INVALID_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConnectStatusType[] f276470a = null;

    static {
        ConnectStatusType r100 = new ConnectStatusType("CONNECT_CLIENT", 0);
        CONNECT_CLIENT = r100;
        ConnectStatusType r101 = new ConnectStatusType("DISCONNECT_CLIENT", 1);
        DISCONNECT_CLIENT = r101;
        ConnectStatusType r102 = new ConnectStatusType("CLIENT_CONNECTED", 2);
        CLIENT_CONNECTED = r102;
        ConnectStatusType r103 = new ConnectStatusType("CLIENT_DISCONNECTED", 3);
        CLIENT_DISCONNECTED = r103;
        ConnectStatusType r104 = new ConnectStatusType("CLIENT_CARD_REMOVED", 4);
        CLIENT_CARD_REMOVED = r104;
        ConnectStatusType r105 = new ConnectStatusType("INVALID_TYPE", 5);
        INVALID_TYPE = r105;
        f276470a = new ConnectStatusType[]{r100, r101, r102, r103, r104, r105};
    }

    public static ConnectStatusType[] values() {
        return (ConnectStatusType[]) f276470a.clone();
    }

    public int getValue() {
        throw new RuntimeException("Stub!");
    }

    public static ConnectStatusType getConnectStatusType(int r100) {
        throw new RuntimeException("Stub!");
    }

    public static ConnectStatusType valueOf(String r100) {
        return (ConnectStatusType) a.a(ConnectStatusType.class, r100);
    }

    public ConnectStatusType(String r100, int r101) {
        super(r100, r101);
    }
}

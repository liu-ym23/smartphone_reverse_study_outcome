package com.bytedance.dora.wlan.model;

import com.alibaba.gaiax.model.GXAnimation;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum DoraWifiEventReason extends Enum<DoraWifiEventReason> {
    public static final DoraWifiEventReason DISCONNECT = null;
    public static final DoraWifiEventReason LINK_STATE_CHANGED_CONNECTED = null;
    public static final DoraWifiEventReason LINK_STATE_CHANGED_CONNECTED_DISCONNECTED = null;
    public static final DoraWifiEventReason LINK_STATE_CHANGED_CONNECTING_DISCONNECTED = null;
    public static final DoraWifiEventReason MSG_CONNECT_WIFI_TIMEOUT = null;
    public static final DoraWifiEventReason MSG_CREATE_GROUP_TIMEOUT = null;
    public static final DoraWifiEventReason MSG_REQUEST_GROUP_INFO_TIMEOUT = null;
    public static final DoraWifiEventReason MSG_REQUEST_SOFT_AP_TIMEOUT = null;
    public static final DoraWifiEventReason MSG_SEND_CMD_TIMEOUT = null;
    public static final DoraWifiEventReason ON_SPP_WIFI_CALLBACK = null;
    public static final DoraWifiEventReason P2P_CHECK_FAILED = null;
    public static final DoraWifiEventReason P2P_CLIENTS_EMPTY = null;
    public static final DoraWifiEventReason P2P_GO_CREATE_FAILED = null;
    public static final DoraWifiEventReason P2P_NETWORK_DISCONNECTED = null;
    public static final DoraWifiEventReason P2P_SEND_CMD_ERROR = null;
    public static final DoraWifiEventReason SOFT_AP_CONNECT_LEGACY = null;
    public static final DoraWifiEventReason SOFT_AP_NETWORK_ID_ERROR = null;
    public static final DoraWifiEventReason SOFT_AP_ON_AVAILABLE = null;
    public static final DoraWifiEventReason SOFT_AP_ON_LOST = null;
    public static final DoraWifiEventReason SOFT_AP_ON_UNAVAILABLE = null;
    public static final DoraWifiEventReason SOFT_AP_REQUEST_NETWORK_EXCEPTION = null;
    public static final DoraWifiEventReason START = null;
    public static final DoraWifiEventReason TIMEOUT = null;
    public static final DoraWifiEventReason UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraWifiEventReason[] f204682a = null;
    private final String description;

    static {
        DoraWifiEventReason r100 = new DoraWifiEventReason("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        DoraWifiEventReason r101 = new DoraWifiEventReason(GXAnimation.STATE_START, 1, "start");
        START = r101;
        DoraWifiEventReason r102 = new DoraWifiEventReason("DISCONNECT", 2, "disconnect");
        DISCONNECT = r102;
        DoraWifiEventReason r103 = new DoraWifiEventReason("TIMEOUT", 3, "timeout");
        TIMEOUT = r103;
        DoraWifiEventReason r104 = new DoraWifiEventReason("P2P_CHECK_FAILED", 4, "checkFailed");
        P2P_CHECK_FAILED = r104;
        DoraWifiEventReason r105 = new DoraWifiEventReason("P2P_GO_CREATE_FAILED", 5, "GO_create_failed");
        P2P_GO_CREATE_FAILED = r105;
        DoraWifiEventReason r110 = new DoraWifiEventReason("P2P_SEND_CMD_ERROR", 6, "sendCmdError");
        P2P_SEND_CMD_ERROR = r110;
        DoraWifiEventReason r111 = new DoraWifiEventReason("P2P_NETWORK_DISCONNECTED", 7, "network_disconnected");
        P2P_NETWORK_DISCONNECTED = r111;
        DoraWifiEventReason r112 = new DoraWifiEventReason("P2P_CLIENTS_EMPTY", 8, "clients_empty");
        P2P_CLIENTS_EMPTY = r112;
        DoraWifiEventReason r113 = new DoraWifiEventReason("SOFT_AP_ON_AVAILABLE", 9, "onAvailable");
        SOFT_AP_ON_AVAILABLE = r113;
        DoraWifiEventReason r114 = new DoraWifiEventReason("SOFT_AP_ON_UNAVAILABLE", 10, "onUnavailable");
        SOFT_AP_ON_UNAVAILABLE = r114;
        DoraWifiEventReason r106 = new DoraWifiEventReason("SOFT_AP_ON_LOST", 11, "onLost");
        SOFT_AP_ON_LOST = r106;
        DoraWifiEventReason r107 = new DoraWifiEventReason("SOFT_AP_REQUEST_NETWORK_EXCEPTION", 12, "requestNetworkException");
        SOFT_AP_REQUEST_NETWORK_EXCEPTION = r107;
        DoraWifiEventReason r108 = new DoraWifiEventReason("SOFT_AP_CONNECT_LEGACY", 13, "connectWifiLegacy");
        SOFT_AP_CONNECT_LEGACY = r108;
        DoraWifiEventReason r109 = new DoraWifiEventReason("SOFT_AP_NETWORK_ID_ERROR", 14, "networkId(-1)");
        SOFT_AP_NETWORK_ID_ERROR = r109;
        DoraWifiEventReason r115 = new DoraWifiEventReason("ON_SPP_WIFI_CALLBACK", 15, "onSppWifiCallback");
        ON_SPP_WIFI_CALLBACK = r115;
        DoraWifiEventReason r116 = new DoraWifiEventReason("MSG_CREATE_GROUP_TIMEOUT", 16, "MSG_CREATE_GROUP_TIMEOUT");
        MSG_CREATE_GROUP_TIMEOUT = r116;
        DoraWifiEventReason r117 = new DoraWifiEventReason("MSG_SEND_CMD_TIMEOUT", 17, "MSG_SEND_CMD_TIMEOUT");
        MSG_SEND_CMD_TIMEOUT = r117;
        DoraWifiEventReason r118 = new DoraWifiEventReason("MSG_REQUEST_GROUP_INFO_TIMEOUT", 18, "MSG_REQUEST_GROUP_INFO_TIMEOUT");
        MSG_REQUEST_GROUP_INFO_TIMEOUT = r118;
        DoraWifiEventReason r119 = new DoraWifiEventReason("MSG_REQUEST_SOFT_AP_TIMEOUT", 19, "MSG_REQUEST_SOFT_AP_TIMEOUT");
        MSG_REQUEST_SOFT_AP_TIMEOUT = r119;
        DoraWifiEventReason r120 = new DoraWifiEventReason("MSG_CONNECT_WIFI_TIMEOUT", 20, "MSG_CONNECT_WIFI_TIMEOUT");
        MSG_CONNECT_WIFI_TIMEOUT = r120;
        DoraWifiEventReason r121 = new DoraWifiEventReason("LINK_STATE_CHANGED_CONNECTED", 21, "onWifiStateChanged(connected)");
        LINK_STATE_CHANGED_CONNECTED = r121;
        DoraWifiEventReason r122 = new DoraWifiEventReason("LINK_STATE_CHANGED_CONNECTING_DISCONNECTED", 22, "onWifiStateChanged(connecting->disconnected)");
        LINK_STATE_CHANGED_CONNECTING_DISCONNECTED = r122;
        DoraWifiEventReason r123 = new DoraWifiEventReason("LINK_STATE_CHANGED_CONNECTED_DISCONNECTED", 23, "onWifiStateChanged(connected->disconnected)");
        LINK_STATE_CHANGED_CONNECTED_DISCONNECTED = r123;
        f204682a = new DoraWifiEventReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123};
    }

    public static DoraWifiEventReason[] values() {
        return (DoraWifiEventReason[]) f204682a.clone();
    }

    public String getDescription() {
        return this.description;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.description;
    }

    public static DoraWifiEventReason valueOf(String r100) {
        return (DoraWifiEventReason) a.a(DoraWifiEventReason.class, r100);
    }

    public DoraWifiEventReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.description = r102;
    }
}

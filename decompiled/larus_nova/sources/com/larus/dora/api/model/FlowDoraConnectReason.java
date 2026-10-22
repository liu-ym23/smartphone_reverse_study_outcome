package com.larus.dora.api.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/dora/api/model/FlowDoraConnectReason;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface FlowDoraConnectReason {
    public static final a Companion = null;
    public static final String P2P_CHECK_HOTSPOT_OPEN = "p2pCheckHotspotOpen";
    public static final String P2P_CHECK_LOCATION_NOT_PASS = "p2pCheckLocationNotPass";
    public static final String P2P_CHECK_NEAR_BY_NOT_PASS = "p2pCheckNearByNotPass";
    public static final String P2P_CHECK_VPN_OPEN = "p2pCheckVpnOpen";
    public static final String P2P_CHECK_WIFI_NOT_OPEN = "p2pCheckWiFiNotOpen";
    public static final String P2P_CONNECTED_CALLBACK_TIMEOUT = "p2pConnectedCallBackTimeout";
    public static final String P2P_CREATE_GROUP_FAILED = "p2pCreateGroupFailed";
    public static final String P2P_OPEN_CMD_SEND_FAILED = "p2pOpenCMDSendFailed";
    public static final String SOFT_AP_HOTSPOT_OPEN_CMD_SEND_FAILED = "hotspotOpenCMDSendFailed";
    public static final String SOFT_AP_HOTSPOT_OPEN_TIMEOUT = "hotspotOpenTimeout";
    public static final String SOFT_AP_USER_DENIED = "softAPUserDenied";
    public static final String SUCCESS = "success";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f331749a = null;

        static {
            f331749a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f331749a;
    }
}

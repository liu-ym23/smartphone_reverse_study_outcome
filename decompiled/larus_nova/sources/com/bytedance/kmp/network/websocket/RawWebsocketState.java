package com.bytedance.kmp.network.websocket;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/kmp/network/websocket/RawWebsocketState;", "", "", "state", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CONNECTION_UNKNOWN", "CONNECTING", "CONNECT_FAILED", "CONNECT_CLOSED", "CONNECTED", "DISCONNECTING", "network_service_release"}, k = 1, mv = {1, 7, 0})
public final enum RawWebsocketState extends Enum<RawWebsocketState> {
    public static final RawWebsocketState CONNECTED = null;
    public static final RawWebsocketState CONNECTING = null;
    public static final RawWebsocketState CONNECTION_UNKNOWN = null;
    public static final RawWebsocketState CONNECT_CLOSED = null;
    public static final RawWebsocketState CONNECT_FAILED = null;
    public static final a Companion = null;
    public static final RawWebsocketState DISCONNECTING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RawWebsocketState[] f252572a = null;
    private final int state;

    public static RawWebsocketState valueOf(String r100) {
        return (RawWebsocketState) r27.a.a(RawWebsocketState.class, r100);
    }

    public static RawWebsocketState[] values() {
        return (RawWebsocketState[]) f252572a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.kmp.network.websocket.RawWebsocketState$a] */
    static {
        RawWebsocketState r100 = new RawWebsocketState("CONNECTION_UNKNOWN", 0, 1);
        CONNECTION_UNKNOWN = r100;
        RawWebsocketState r101 = new RawWebsocketState("CONNECTING", 1, 2);
        CONNECTING = r101;
        RawWebsocketState r102 = new RawWebsocketState("CONNECT_FAILED", 2, 4);
        CONNECT_FAILED = r102;
        RawWebsocketState r103 = new RawWebsocketState("CONNECT_CLOSED", 3, 8);
        CONNECT_CLOSED = r103;
        RawWebsocketState r104 = new RawWebsocketState("CONNECTED", 4, 16);
        CONNECTED = r104;
        RawWebsocketState r110 = new RawWebsocketState("DISCONNECTING", 5, 32);
        DISCONNECTING = r110;
        f252572a = new RawWebsocketState[]{r100, r101, r102, r103, r104, r110};
        Companion = new a();
    }

    public static final /* synthetic */ int access$getState$p(RawWebsocketState r100) {
        return r100.state;
    }

    public RawWebsocketState(String r100, int r101, int r102) {
        super(r100, r101);
        this.state = r102;
    }
}

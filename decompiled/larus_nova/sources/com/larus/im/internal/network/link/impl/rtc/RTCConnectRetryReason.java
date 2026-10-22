package com.larus.im.internal.network.link.impl.rtc;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/im/internal/network/link/impl/rtc/RTCConnectRetryReason;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GET_TOKEN_FAILED", "INVALID_TOKEN", "NO_ENGINE", "CREATE_ROOM_FAILED", "START_SESSION_FAILED", "SESSION_STARTED_TIMEOUT", "NETWORK_RECOVERY", "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RTCConnectRetryReason extends Enum<RTCConnectRetryReason> {
    public static final RTCConnectRetryReason CREATE_ROOM_FAILED = null;
    public static final RTCConnectRetryReason GET_TOKEN_FAILED = null;
    public static final RTCConnectRetryReason INVALID_TOKEN = null;
    public static final RTCConnectRetryReason NETWORK_RECOVERY = null;
    public static final RTCConnectRetryReason NO_ENGINE = null;
    public static final RTCConnectRetryReason SESSION_STARTED_TIMEOUT = null;
    public static final RTCConnectRetryReason START_SESSION_FAILED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RTCConnectRetryReason[] f349224a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f349225b = null;
    private final String value;

    public static EnumEntries<RTCConnectRetryReason> getEntries() {
        return f349225b;
    }

    static {
        RTCConnectRetryReason r100 = new RTCConnectRetryReason("GET_TOKEN_FAILED", 0, "get_token_failed");
        GET_TOKEN_FAILED = r100;
        RTCConnectRetryReason r101 = new RTCConnectRetryReason("INVALID_TOKEN", 1, "invalid_token");
        INVALID_TOKEN = r101;
        RTCConnectRetryReason r102 = new RTCConnectRetryReason("NO_ENGINE", 2, "no_engine");
        NO_ENGINE = r102;
        RTCConnectRetryReason r103 = new RTCConnectRetryReason("CREATE_ROOM_FAILED", 3, "create_room_failed");
        CREATE_ROOM_FAILED = r103;
        RTCConnectRetryReason r104 = new RTCConnectRetryReason("START_SESSION_FAILED", 4, "start_session_failed");
        START_SESSION_FAILED = r104;
        RTCConnectRetryReason r105 = new RTCConnectRetryReason("SESSION_STARTED_TIMEOUT", 5, "session_started_timeout");
        SESSION_STARTED_TIMEOUT = r105;
        RTCConnectRetryReason r110 = new RTCConnectRetryReason("NETWORK_RECOVERY", 6, "network_recovery");
        NETWORK_RECOVERY = r110;
        RTCConnectRetryReason[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f349224a = r111;
        f349225b = EnumEntriesKt.enumEntries(r111);
    }

    public static RTCConnectRetryReason[] values() {
        return (RTCConnectRetryReason[]) f349224a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static RTCConnectRetryReason valueOf(String r100) {
        return (RTCConnectRetryReason) r27.a.a(RTCConnectRetryReason.class, r100);
    }

    public RTCConnectRetryReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

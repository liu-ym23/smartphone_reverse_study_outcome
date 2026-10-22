package com.larus.im.internal.network.link.impl.rtc;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/im/internal/network/link/impl/rtc/RTCConnectRetryAction;", "", "<init>", "(Ljava/lang/String;I)V", "RESEND_START_SESSION", "FULL_RECONNECT", "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RTCConnectRetryAction extends Enum<RTCConnectRetryAction> {
    public static final RTCConnectRetryAction FULL_RECONNECT = null;
    public static final RTCConnectRetryAction RESEND_START_SESSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RTCConnectRetryAction[] f349222a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f349223b = null;

    public static EnumEntries<RTCConnectRetryAction> getEntries() {
        return f349223b;
    }

    static {
        RTCConnectRetryAction r100 = new RTCConnectRetryAction("RESEND_START_SESSION", 0);
        RESEND_START_SESSION = r100;
        RTCConnectRetryAction r101 = new RTCConnectRetryAction("FULL_RECONNECT", 1);
        FULL_RECONNECT = r101;
        RTCConnectRetryAction[] r102 = {r100, r101};
        f349222a = r102;
        f349223b = EnumEntriesKt.enumEntries(r102);
    }

    public static RTCConnectRetryAction[] values() {
        return (RTCConnectRetryAction[]) f349222a.clone();
    }

    public static RTCConnectRetryAction valueOf(String r100) {
        return (RTCConnectRetryAction) r27.a.a(RTCConnectRetryAction.class, r100);
    }

    public RTCConnectRetryAction(String r100, int r101) {
        super(r100, r101);
    }
}

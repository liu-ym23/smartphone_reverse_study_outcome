package com.ss.ugc.live.sdk.msg.uplink;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import lmc.g;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/ugc/live/sdk/msg/uplink/UplinkStrategy;", "", "", "isWsConnected", "", "getStrategy", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "WS_MSG_ORIGIN", "WS_ORIGIN", "ORIGIN", "message_release"}, k = 1, mv = {1, 4, 0})
public final enum UplinkStrategy extends Enum<UplinkStrategy> {
    public static final a Companion = null;
    public static final UplinkStrategy ORIGIN = null;
    public static final String ORIGIN_HTTP = "origin_http";
    public static final String UPLINK_HTTP = "uplink_http";
    public static final String WS = "ws";
    public static final UplinkStrategy WS_MSG_ORIGIN = null;
    public static final UplinkStrategy WS_ORIGIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UplinkStrategy[] f458446a = null;

    public static final class a {
        public a() {
        }
    }

    static {
        UplinkStrategy r100 = new UplinkStrategy("WS_MSG_ORIGIN", 0);
        WS_MSG_ORIGIN = r100;
        UplinkStrategy r101 = new UplinkStrategy("WS_ORIGIN", 1);
        WS_ORIGIN = r101;
        UplinkStrategy r102 = new UplinkStrategy("ORIGIN", 2);
        ORIGIN = r102;
        f458446a = new UplinkStrategy[]{r100, r101, r102};
        Companion = new a();
    }

    public static UplinkStrategy valueOf(String r100) {
        return (UplinkStrategy) r27.a.a(UplinkStrategy.class, r100);
    }

    public static UplinkStrategy[] values() {
        return (UplinkStrategy[]) f458446a.clone();
    }

    public final String getStrategy(boolean r100) {
        int r101 = g.f509963a[ordinal()];
        if (r101 != 1) goto L5;
        if (r100 == true) goto L15;
        return UPLINK_HTTP;
    L15:
        return "ws";
    L5:
        if (r101 != 2) goto L13;
        if (r100 == false) goto L13;
        return "ws";
    L13:
        return ORIGIN_HTTP;
    }

    public UplinkStrategy(String r100, int r101) {
        super(r100, r101);
    }
}

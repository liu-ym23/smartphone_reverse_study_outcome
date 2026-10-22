package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedLocalProxyError;", "", "", "value", "I", "Companion", "a", "OK", "SOCKS5_VERSION_ERROR", "SOCKS5_FORMAT_ERROR", "SOCKS5_INVALID_VALUE", "SOCKS5_USER_PASS_NOT_GIVEN", "SOCKS5_TCP_CLOSED", "HTTP_TUNNEL_FAILED", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedLocalProxyError extends Enum<LiveWrappedLocalProxyError> {
    public static final a Companion = null;
    public static final LiveWrappedLocalProxyError HTTP_TUNNEL_FAILED = null;
    public static final LiveWrappedLocalProxyError OK = null;
    public static final LiveWrappedLocalProxyError SOCKS5_FORMAT_ERROR = null;
    public static final LiveWrappedLocalProxyError SOCKS5_INVALID_VALUE = null;
    public static final LiveWrappedLocalProxyError SOCKS5_TCP_CLOSED = null;
    public static final LiveWrappedLocalProxyError SOCKS5_USER_PASS_NOT_GIVEN = null;
    public static final LiveWrappedLocalProxyError SOCKS5_VERSION_ERROR = null;
    public static final /* synthetic */ LiveWrappedLocalProxyError[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedLocalProxyError$a] */
    static {
        LiveWrappedLocalProxyError r1 = new LiveWrappedLocalProxyError("OK", 0, 0);
        OK = r1;
        LiveWrappedLocalProxyError r2 = new LiveWrappedLocalProxyError("SOCKS5_VERSION_ERROR", 1, 1);
        SOCKS5_VERSION_ERROR = r2;
        LiveWrappedLocalProxyError r3 = new LiveWrappedLocalProxyError("SOCKS5_FORMAT_ERROR", 2, 2);
        SOCKS5_FORMAT_ERROR = r3;
        LiveWrappedLocalProxyError r4 = new LiveWrappedLocalProxyError("SOCKS5_INVALID_VALUE", 3, 3);
        SOCKS5_INVALID_VALUE = r4;
        LiveWrappedLocalProxyError r5 = new LiveWrappedLocalProxyError("SOCKS5_USER_PASS_NOT_GIVEN", 4, 4);
        SOCKS5_USER_PASS_NOT_GIVEN = r5;
        LiveWrappedLocalProxyError r6 = new LiveWrappedLocalProxyError("SOCKS5_TCP_CLOSED", 5, 5);
        SOCKS5_TCP_CLOSED = r6;
        LiveWrappedLocalProxyError r7 = new LiveWrappedLocalProxyError("HTTP_TUNNEL_FAILED", 6, 6);
        HTTP_TUNNEL_FAILED = r7;
        a = new LiveWrappedLocalProxyError[]{r1, r2, r3, r4, r5, r6, r7};
        Companion = new a();
    }

    public static LiveWrappedLocalProxyError valueOf(String r1) {
        return (LiveWrappedLocalProxyError) r27.a.a(LiveWrappedLocalProxyError.class, r1);
    }

    public static LiveWrappedLocalProxyError[] values() {
        return (LiveWrappedLocalProxyError[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedLocalProxyError(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

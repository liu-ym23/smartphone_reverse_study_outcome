package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedLocalProxyType;", "", "", "value", "I", "Companion", "a", "SOCKS5", "HTTP_TUNNEL", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedLocalProxyType extends Enum<LiveWrappedLocalProxyType> {
    public static final a Companion = null;
    public static final LiveWrappedLocalProxyType HTTP_TUNNEL = null;
    public static final LiveWrappedLocalProxyType SOCKS5 = null;
    public static final /* synthetic */ LiveWrappedLocalProxyType[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedLocalProxyType$a] */
    static {
        LiveWrappedLocalProxyType r2 = new LiveWrappedLocalProxyType("SOCKS5", 0, 1);
        SOCKS5 = r2;
        LiveWrappedLocalProxyType r3 = new LiveWrappedLocalProxyType("HTTP_TUNNEL", 1, 2);
        HTTP_TUNNEL = r3;
        a = new LiveWrappedLocalProxyType[]{r2, r3};
        Companion = new a();
    }

    public static LiveWrappedLocalProxyType valueOf(String r1) {
        return (LiveWrappedLocalProxyType) r27.a.a(LiveWrappedLocalProxyType.class, r1);
    }

    public static LiveWrappedLocalProxyType[] values() {
        return (LiveWrappedLocalProxyType[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedLocalProxyType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

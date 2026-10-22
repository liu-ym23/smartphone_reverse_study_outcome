package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedNetworkDetectionLinkType;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "Companion", "a", "UP", "DOWN", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedNetworkDetectionLinkType extends Enum<LiveWrappedNetworkDetectionLinkType> {
    public static final a Companion = null;
    public static final LiveWrappedNetworkDetectionLinkType DOWN = null;
    public static final LiveWrappedNetworkDetectionLinkType UP = null;
    public static final /* synthetic */ LiveWrappedNetworkDetectionLinkType[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType$a] */
    static {
        LiveWrappedNetworkDetectionLinkType r1 = new LiveWrappedNetworkDetectionLinkType("UP", 0, 0);
        UP = r1;
        LiveWrappedNetworkDetectionLinkType r2 = new LiveWrappedNetworkDetectionLinkType("DOWN", 1, 1);
        DOWN = r2;
        a = new LiveWrappedNetworkDetectionLinkType[]{r1, r2};
        Companion = new a();
    }

    public static LiveWrappedNetworkDetectionLinkType valueOf(String r1) {
        return (LiveWrappedNetworkDetectionLinkType) r27.a.a(LiveWrappedNetworkDetectionLinkType.class, r1);
    }

    public static LiveWrappedNetworkDetectionLinkType[] values() {
        return (LiveWrappedNetworkDetectionLinkType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public final int value() {
        return this.value;
    }

    public final void setValue(int r1) {
        this.value = r1;
    }

    public LiveWrappedNetworkDetectionLinkType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

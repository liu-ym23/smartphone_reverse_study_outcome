package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedSimulcastStreamType;", "", "", "value", "", "toString", "I", "Companion", "a", "SIMULCAST_STREAM_TYPE_WEAK", "SIMULCAST_STREAM_TYPE_LOW", "SIMULCAST_STREAM_TYPE_MID", "SIMULCAST_STREAM_TYPE_HIGH", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSimulcastStreamType extends Enum<LiveWrappedSimulcastStreamType> {
    public static final a Companion = null;
    public static final LiveWrappedSimulcastStreamType SIMULCAST_STREAM_TYPE_HIGH = null;
    public static final LiveWrappedSimulcastStreamType SIMULCAST_STREAM_TYPE_LOW = null;
    public static final LiveWrappedSimulcastStreamType SIMULCAST_STREAM_TYPE_MID = null;
    public static final LiveWrappedSimulcastStreamType SIMULCAST_STREAM_TYPE_WEAK = null;
    public static final /* synthetic */ LiveWrappedSimulcastStreamType[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedSimulcastStreamType$a] */
    static {
        LiveWrappedSimulcastStreamType r1 = new LiveWrappedSimulcastStreamType("SIMULCAST_STREAM_TYPE_WEAK", 0, 0);
        SIMULCAST_STREAM_TYPE_WEAK = r1;
        LiveWrappedSimulcastStreamType r2 = new LiveWrappedSimulcastStreamType("SIMULCAST_STREAM_TYPE_LOW", 1, 1);
        SIMULCAST_STREAM_TYPE_LOW = r2;
        LiveWrappedSimulcastStreamType r3 = new LiveWrappedSimulcastStreamType("SIMULCAST_STREAM_TYPE_MID", 2, 2);
        SIMULCAST_STREAM_TYPE_MID = r3;
        LiveWrappedSimulcastStreamType r4 = new LiveWrappedSimulcastStreamType("SIMULCAST_STREAM_TYPE_HIGH", 3, 3);
        SIMULCAST_STREAM_TYPE_HIGH = r4;
        a = new LiveWrappedSimulcastStreamType[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static LiveWrappedSimulcastStreamType valueOf(String r1) {
        return (LiveWrappedSimulcastStreamType) r27.a.a(LiveWrappedSimulcastStreamType.class, r1);
    }

    public static LiveWrappedSimulcastStreamType[] values() {
        return (LiveWrappedSimulcastStreamType[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = m0.a[ordinal()];
        if (r0 != 1) goto L5;
        return "kSimulcastStreamTypeWeak";
    L5:
        if (r0 != 2) goto L7;
        return "kSimulcastStreamTypeLow";
    L7:
        if (r0 != 3) goto L9;
        return "kSimulcastStreamTypeMid";
    L9:
        if (r0 == 4) goto L12;
        return "valid";
    L12:
        return "kSimulcastStreamTypeHigh";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedSimulcastStreamType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

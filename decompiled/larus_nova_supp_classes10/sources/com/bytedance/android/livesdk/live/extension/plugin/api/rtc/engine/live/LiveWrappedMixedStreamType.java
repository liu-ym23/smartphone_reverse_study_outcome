package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import bg2.o;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamType;", "", "", "value", "", "toString", "I", "Companion", "a", "MIXED_STREAM_TYPE_BY_SERVER", "MIXED_STREAM_TYPE_BY_CLIENT", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamType extends Enum<LiveWrappedMixedStreamType> {
    public static final a Companion = null;
    public static final LiveWrappedMixedStreamType MIXED_STREAM_TYPE_BY_CLIENT = null;
    public static final LiveWrappedMixedStreamType MIXED_STREAM_TYPE_BY_SERVER = null;
    public static final /* synthetic */ LiveWrappedMixedStreamType[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamType$a] */
    static {
        LiveWrappedMixedStreamType r1 = new LiveWrappedMixedStreamType("MIXED_STREAM_TYPE_BY_SERVER", 0, 0);
        MIXED_STREAM_TYPE_BY_SERVER = r1;
        LiveWrappedMixedStreamType r2 = new LiveWrappedMixedStreamType("MIXED_STREAM_TYPE_BY_CLIENT", 1, 1);
        MIXED_STREAM_TYPE_BY_CLIENT = r2;
        a = new LiveWrappedMixedStreamType[]{r1, r2};
        Companion = new a();
    }

    public static LiveWrappedMixedStreamType valueOf(String r1) {
        return (LiveWrappedMixedStreamType) r27.a.a(LiveWrappedMixedStreamType.class, r1);
    }

    public static LiveWrappedMixedStreamType[] values() {
        return (LiveWrappedMixedStreamType[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = o.a[ordinal()];
        if (r0 != 1) goto L5;
        return "MIXED_STREAM_TYPE_BY_SERVER";
    L5:
        if (r0 == 2) goto L7;
        return "";
    L7:
        return "MIXED_STREAM_TYPE_BY_CLIENT";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedMixedStreamType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

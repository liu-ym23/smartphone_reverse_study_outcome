package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedStreamPriority;", "", "", "value", "I", "Companion", "a", "STREAM_PRIORITY_LOW", "STREAM_PRIORITY_MEDIAM", "STREAM_PRIORITY_HIGH", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedStreamPriority extends Enum<LiveWrappedStreamPriority> {
    public static final a Companion = null;
    public static final LiveWrappedStreamPriority STREAM_PRIORITY_HIGH = null;
    public static final LiveWrappedStreamPriority STREAM_PRIORITY_LOW = null;
    public static final LiveWrappedStreamPriority STREAM_PRIORITY_MEDIAM = null;
    public static final /* synthetic */ LiveWrappedStreamPriority[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamPriority$a] */
    static {
        LiveWrappedStreamPriority r1 = new LiveWrappedStreamPriority("STREAM_PRIORITY_LOW", 0, 0);
        STREAM_PRIORITY_LOW = r1;
        LiveWrappedStreamPriority r2 = new LiveWrappedStreamPriority("STREAM_PRIORITY_MEDIAM", 1, 1);
        STREAM_PRIORITY_MEDIAM = r2;
        LiveWrappedStreamPriority r3 = new LiveWrappedStreamPriority("STREAM_PRIORITY_HIGH", 2, 2);
        STREAM_PRIORITY_HIGH = r3;
        a = new LiveWrappedStreamPriority[]{r1, r2, r3};
        Companion = new a();
    }

    public static LiveWrappedStreamPriority valueOf(String r1) {
        return (LiveWrappedStreamPriority) r27.a.a(LiveWrappedStreamPriority.class, r1);
    }

    public static LiveWrappedStreamPriority[] values() {
        return (LiveWrappedStreamPriority[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedStreamPriority(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedStreamLayoutMode;", "", "", "value", "mode", "I", "AUTO", "CUSTOM", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedStreamLayoutMode extends Enum<LiveWrappedStreamLayoutMode> {
    public static final LiveWrappedStreamLayoutMode AUTO = null;
    public static final LiveWrappedStreamLayoutMode CUSTOM = null;
    public static final /* synthetic */ LiveWrappedStreamLayoutMode[] a = null;
    private final int mode;

    static {
        LiveWrappedStreamLayoutMode r2 = new LiveWrappedStreamLayoutMode("AUTO", 0, 0);
        AUTO = r2;
        LiveWrappedStreamLayoutMode r3 = new LiveWrappedStreamLayoutMode("CUSTOM", 1, 2);
        CUSTOM = r3;
        a = new LiveWrappedStreamLayoutMode[]{r2, r3};
    }

    public static LiveWrappedStreamLayoutMode valueOf(String r1) {
        return (LiveWrappedStreamLayoutMode) a.a(LiveWrappedStreamLayoutMode.class, r1);
    }

    public static LiveWrappedStreamLayoutMode[] values() {
        return (LiveWrappedStreamLayoutMode[]) a.clone();
    }

    public final int value() {
        return this.mode;
    }

    public LiveWrappedStreamLayoutMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.mode = r3;
    }
}

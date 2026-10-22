package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamRenderMode;", "", "", "value", "I", "getValue", "()I", "MIXED_STREAM_RENDER_MODE_HIDDEN", "MIXED_STREAM_RENDER_MODE_FIT", "MIXED_STREAM_RENDER_MODE_ADAPTIVE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamRenderMode extends Enum<LiveWrappedMixedStreamRenderMode> {
    public static final LiveWrappedMixedStreamRenderMode MIXED_STREAM_RENDER_MODE_ADAPTIVE = null;
    public static final LiveWrappedMixedStreamRenderMode MIXED_STREAM_RENDER_MODE_FIT = null;
    public static final LiveWrappedMixedStreamRenderMode MIXED_STREAM_RENDER_MODE_HIDDEN = null;
    public static final /* synthetic */ LiveWrappedMixedStreamRenderMode[] a = null;
    private final int value;

    static {
        LiveWrappedMixedStreamRenderMode r2 = new LiveWrappedMixedStreamRenderMode("MIXED_STREAM_RENDER_MODE_HIDDEN", 0, 1);
        MIXED_STREAM_RENDER_MODE_HIDDEN = r2;
        LiveWrappedMixedStreamRenderMode r3 = new LiveWrappedMixedStreamRenderMode("MIXED_STREAM_RENDER_MODE_FIT", 1, 2);
        MIXED_STREAM_RENDER_MODE_FIT = r3;
        LiveWrappedMixedStreamRenderMode r4 = new LiveWrappedMixedStreamRenderMode("MIXED_STREAM_RENDER_MODE_ADAPTIVE", 2, 3);
        MIXED_STREAM_RENDER_MODE_ADAPTIVE = r4;
        a = new LiveWrappedMixedStreamRenderMode[]{r2, r3, r4};
    }

    public static LiveWrappedMixedStreamRenderMode valueOf(String r1) {
        return (LiveWrappedMixedStreamRenderMode) a.a(LiveWrappedMixedStreamRenderMode.class, r1);
    }

    public static LiveWrappedMixedStreamRenderMode[] values() {
        return (LiveWrappedMixedStreamRenderMode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedMixedStreamRenderMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

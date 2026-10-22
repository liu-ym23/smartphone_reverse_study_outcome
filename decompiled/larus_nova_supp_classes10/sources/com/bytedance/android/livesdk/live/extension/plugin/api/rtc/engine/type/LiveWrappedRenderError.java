package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedRenderError;", "", "", "value", "I", "Companion", "a", "RENDER_ERROR_OK", "RENDER_ERROR_USING_INTERNAL_SURFACE", "RENDER_ERROR_USING_SOFTWARE_DECODER", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedRenderError extends Enum<LiveWrappedRenderError> {
    public static final a Companion = null;
    public static final LiveWrappedRenderError RENDER_ERROR_OK = null;
    public static final LiveWrappedRenderError RENDER_ERROR_USING_INTERNAL_SURFACE = null;
    public static final LiveWrappedRenderError RENDER_ERROR_USING_SOFTWARE_DECODER = null;
    public static final /* synthetic */ LiveWrappedRenderError[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRenderError$a] */
    static {
        LiveWrappedRenderError r1 = new LiveWrappedRenderError("RENDER_ERROR_OK", 0, 0);
        RENDER_ERROR_OK = r1;
        LiveWrappedRenderError r2 = new LiveWrappedRenderError("RENDER_ERROR_USING_INTERNAL_SURFACE", 1, -1);
        RENDER_ERROR_USING_INTERNAL_SURFACE = r2;
        LiveWrappedRenderError r3 = new LiveWrappedRenderError("RENDER_ERROR_USING_SOFTWARE_DECODER", 2, -2);
        RENDER_ERROR_USING_SOFTWARE_DECODER = r3;
        a = new LiveWrappedRenderError[]{r1, r2, r3};
        Companion = new a();
    }

    public static LiveWrappedRenderError valueOf(String r1) {
        return (LiveWrappedRenderError) r27.a.a(LiveWrappedRenderError.class, r1);
    }

    public static LiveWrappedRenderError[] values() {
        return (LiveWrappedRenderError[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedRenderError(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

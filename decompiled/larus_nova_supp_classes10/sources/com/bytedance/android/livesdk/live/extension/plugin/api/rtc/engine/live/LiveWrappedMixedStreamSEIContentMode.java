package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamSEIContentMode;", "", "", "value", "I", "getValue", "()I", "MIXED_STREAM_SEI_CONTENT_MODE_DEFAULT", "MIXED_STREAM_SEI_CONTENT_MODE_ENABLE_VOLUME_INDICATION", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamSEIContentMode extends Enum<LiveWrappedMixedStreamSEIContentMode> {
    public static final LiveWrappedMixedStreamSEIContentMode MIXED_STREAM_SEI_CONTENT_MODE_DEFAULT = null;
    public static final LiveWrappedMixedStreamSEIContentMode MIXED_STREAM_SEI_CONTENT_MODE_ENABLE_VOLUME_INDICATION = null;
    public static final /* synthetic */ LiveWrappedMixedStreamSEIContentMode[] a = null;
    private final int value;

    static {
        LiveWrappedMixedStreamSEIContentMode r1 = new LiveWrappedMixedStreamSEIContentMode("MIXED_STREAM_SEI_CONTENT_MODE_DEFAULT", 0, 0);
        MIXED_STREAM_SEI_CONTENT_MODE_DEFAULT = r1;
        LiveWrappedMixedStreamSEIContentMode r2 = new LiveWrappedMixedStreamSEIContentMode("MIXED_STREAM_SEI_CONTENT_MODE_ENABLE_VOLUME_INDICATION", 1, 1);
        MIXED_STREAM_SEI_CONTENT_MODE_ENABLE_VOLUME_INDICATION = r2;
        a = new LiveWrappedMixedStreamSEIContentMode[]{r1, r2};
    }

    public static LiveWrappedMixedStreamSEIContentMode valueOf(String r1) {
        return (LiveWrappedMixedStreamSEIContentMode) a.a(LiveWrappedMixedStreamSEIContentMode.class, r1);
    }

    public static LiveWrappedMixedStreamSEIContentMode[] values() {
        return (LiveWrappedMixedStreamSEIContentMode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedMixedStreamSEIContentMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

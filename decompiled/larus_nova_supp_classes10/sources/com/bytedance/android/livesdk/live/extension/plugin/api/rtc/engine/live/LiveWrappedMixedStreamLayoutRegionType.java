package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamLayoutRegionType;", "", "", "value", "I", "getValue", "()I", "MIXED_STREAM_LAYOUT_REGION_TYPE_VIDEO_STREAM", "MIXED_STREAM_LAYOUT_REGION_TYPE_IMAGE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamLayoutRegionType extends Enum<LiveWrappedMixedStreamLayoutRegionType> {
    public static final LiveWrappedMixedStreamLayoutRegionType MIXED_STREAM_LAYOUT_REGION_TYPE_IMAGE = null;
    public static final LiveWrappedMixedStreamLayoutRegionType MIXED_STREAM_LAYOUT_REGION_TYPE_VIDEO_STREAM = null;
    public static final /* synthetic */ LiveWrappedMixedStreamLayoutRegionType[] a = null;
    private final int value;

    static {
        LiveWrappedMixedStreamLayoutRegionType r1 = new LiveWrappedMixedStreamLayoutRegionType("MIXED_STREAM_LAYOUT_REGION_TYPE_VIDEO_STREAM", 0, 0);
        MIXED_STREAM_LAYOUT_REGION_TYPE_VIDEO_STREAM = r1;
        LiveWrappedMixedStreamLayoutRegionType r2 = new LiveWrappedMixedStreamLayoutRegionType("MIXED_STREAM_LAYOUT_REGION_TYPE_IMAGE", 1, 1);
        MIXED_STREAM_LAYOUT_REGION_TYPE_IMAGE = r2;
        a = new LiveWrappedMixedStreamLayoutRegionType[]{r1, r2};
    }

    public static LiveWrappedMixedStreamLayoutRegionType valueOf(String r1) {
        return (LiveWrappedMixedStreamLayoutRegionType) a.a(LiveWrappedMixedStreamLayoutRegionType.class, r1);
    }

    public static LiveWrappedMixedStreamLayoutRegionType[] values() {
        return (LiveWrappedMixedStreamLayoutRegionType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedMixedStreamLayoutRegionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

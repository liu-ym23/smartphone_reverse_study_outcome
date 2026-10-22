package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamVideoType;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "MIXED_STREAM_VIDEO_TYPE_MAIN", "MIXED_STREAM_VIDEO_TYPE_SCREEN", "MIXED_STREAM_VIDEO_TYPE_3RD", "MIXED_STREAM_VIDEO_TYPE_4TH", "MIXED_STREAM_VIDEO_TYPE_5TH", "MIXED_STREAM_VIDEO_TYPE_6TH", "MIXED_STREAM_VIDEO_TYPE_7TH", "MIXED_STREAM_VIDEO_TYPE_8TH", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamVideoType extends Enum<LiveWrappedMixedStreamVideoType> {
    public static final LiveWrappedMixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_3RD = null;
    public static final LiveWrappedMixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_4TH = null;
    public static final LiveWrappedMixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_5TH = null;
    public static final LiveWrappedMixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_6TH = null;
    public static final LiveWrappedMixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_7TH = null;
    public static final LiveWrappedMixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_8TH = null;
    public static final LiveWrappedMixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_MAIN = null;
    public static final LiveWrappedMixedStreamVideoType MIXED_STREAM_VIDEO_TYPE_SCREEN = null;
    public static final /* synthetic */ LiveWrappedMixedStreamVideoType[] a = null;
    private int value;

    public static LiveWrappedMixedStreamVideoType valueOf(String r1) {
        return (LiveWrappedMixedStreamVideoType) a.a(LiveWrappedMixedStreamVideoType.class, r1);
    }

    public static LiveWrappedMixedStreamVideoType[] values() {
        return (LiveWrappedMixedStreamVideoType[]) a.clone();
    }

    static {
        LiveWrappedMixedStreamVideoType r1 = new LiveWrappedMixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_MAIN", 0, 0);
        MIXED_STREAM_VIDEO_TYPE_MAIN = r1;
        LiveWrappedMixedStreamVideoType r2 = new LiveWrappedMixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_SCREEN", 1, 1);
        MIXED_STREAM_VIDEO_TYPE_SCREEN = r2;
        LiveWrappedMixedStreamVideoType r3 = new LiveWrappedMixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_3RD", 2, 2);
        MIXED_STREAM_VIDEO_TYPE_3RD = r3;
        LiveWrappedMixedStreamVideoType r4 = new LiveWrappedMixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_4TH", 3, 3);
        MIXED_STREAM_VIDEO_TYPE_4TH = r4;
        LiveWrappedMixedStreamVideoType r5 = new LiveWrappedMixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_5TH", 4, 4);
        MIXED_STREAM_VIDEO_TYPE_5TH = r5;
        LiveWrappedMixedStreamVideoType r6 = new LiveWrappedMixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_6TH", 5, 5);
        MIXED_STREAM_VIDEO_TYPE_6TH = r6;
        LiveWrappedMixedStreamVideoType r7 = new LiveWrappedMixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_7TH", 6, 6);
        MIXED_STREAM_VIDEO_TYPE_7TH = r7;
        LiveWrappedMixedStreamVideoType r8 = new LiveWrappedMixedStreamVideoType("MIXED_STREAM_VIDEO_TYPE_8TH", 7, 7);
        MIXED_STREAM_VIDEO_TYPE_8TH = r8;
        a = new LiveWrappedMixedStreamVideoType[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int r1) {
        this.value = r1;
    }

    public LiveWrappedMixedStreamVideoType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

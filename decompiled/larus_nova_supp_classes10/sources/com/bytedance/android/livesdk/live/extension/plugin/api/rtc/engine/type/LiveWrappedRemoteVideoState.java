package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedRemoteVideoState;", "", "", "value", "I", "Companion", "a", "REMOTE_VIDEO_STATE_STOPPED", "REMOTE_VIDEO_STATE_STARTING", "REMOTE_VIDEO_STATE_DECODING", "REMOTE_VIDEO_STATE_FROZEN", "REMOTE_VIDEO_STATE_FAILED", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedRemoteVideoState extends Enum<LiveWrappedRemoteVideoState> {
    public static final a Companion = null;
    public static final LiveWrappedRemoteVideoState REMOTE_VIDEO_STATE_DECODING = null;
    public static final LiveWrappedRemoteVideoState REMOTE_VIDEO_STATE_FAILED = null;
    public static final LiveWrappedRemoteVideoState REMOTE_VIDEO_STATE_FROZEN = null;
    public static final LiveWrappedRemoteVideoState REMOTE_VIDEO_STATE_STARTING = null;
    public static final LiveWrappedRemoteVideoState REMOTE_VIDEO_STATE_STOPPED = null;
    public static final /* synthetic */ LiveWrappedRemoteVideoState[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRemoteVideoState$a] */
    static {
        LiveWrappedRemoteVideoState r1 = new LiveWrappedRemoteVideoState("REMOTE_VIDEO_STATE_STOPPED", 0, 0);
        REMOTE_VIDEO_STATE_STOPPED = r1;
        LiveWrappedRemoteVideoState r2 = new LiveWrappedRemoteVideoState("REMOTE_VIDEO_STATE_STARTING", 1, 1);
        REMOTE_VIDEO_STATE_STARTING = r2;
        LiveWrappedRemoteVideoState r3 = new LiveWrappedRemoteVideoState("REMOTE_VIDEO_STATE_DECODING", 2, 2);
        REMOTE_VIDEO_STATE_DECODING = r3;
        LiveWrappedRemoteVideoState r4 = new LiveWrappedRemoteVideoState("REMOTE_VIDEO_STATE_FROZEN", 3, 3);
        REMOTE_VIDEO_STATE_FROZEN = r4;
        LiveWrappedRemoteVideoState r5 = new LiveWrappedRemoteVideoState("REMOTE_VIDEO_STATE_FAILED", 4, 4);
        REMOTE_VIDEO_STATE_FAILED = r5;
        a = new LiveWrappedRemoteVideoState[]{r1, r2, r3, r4, r5};
        Companion = new a();
    }

    public static LiveWrappedRemoteVideoState valueOf(String r1) {
        return (LiveWrappedRemoteVideoState) r27.a.a(LiveWrappedRemoteVideoState.class, r1);
    }

    public static LiveWrappedRemoteVideoState[] values() {
        return (LiveWrappedRemoteVideoState[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedRemoteVideoState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

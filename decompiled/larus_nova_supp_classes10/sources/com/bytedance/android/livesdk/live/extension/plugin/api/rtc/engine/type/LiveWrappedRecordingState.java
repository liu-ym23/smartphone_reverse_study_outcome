package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedRecordingState;", "", "", "value", "I", "Companion", "a", "RECORDING_STATE_ERROE", "RECORDING_STATE_PROCESSING", "RECORDING_STATE_SUCCESS", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedRecordingState extends Enum<LiveWrappedRecordingState> {
    public static final a Companion = null;
    public static final LiveWrappedRecordingState RECORDING_STATE_ERROE = null;
    public static final LiveWrappedRecordingState RECORDING_STATE_PROCESSING = null;
    public static final LiveWrappedRecordingState RECORDING_STATE_SUCCESS = null;
    public static final /* synthetic */ LiveWrappedRecordingState[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRecordingState$a] */
    static {
        LiveWrappedRecordingState r1 = new LiveWrappedRecordingState("RECORDING_STATE_ERROE", 0, 0);
        RECORDING_STATE_ERROE = r1;
        LiveWrappedRecordingState r2 = new LiveWrappedRecordingState("RECORDING_STATE_PROCESSING", 1, 1);
        RECORDING_STATE_PROCESSING = r2;
        LiveWrappedRecordingState r3 = new LiveWrappedRecordingState("RECORDING_STATE_SUCCESS", 2, 2);
        RECORDING_STATE_SUCCESS = r3;
        a = new LiveWrappedRecordingState[]{r1, r2, r3};
        Companion = new a();
    }

    public static LiveWrappedRecordingState valueOf(String r1) {
        return (LiveWrappedRecordingState) r27.a.a(LiveWrappedRecordingState.class, r1);
    }

    public static LiveWrappedRecordingState[] values() {
        return (LiveWrappedRecordingState[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedRecordingState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedAudioRecordingState;", "", "", "value", "I", "Companion", "a", "AUDIO_RECORDING_STATE_ERROR", "AUDIO_RECORDING_STATE_PROCESSING", "AUDIO_RECORDING_STATE_SUCCESS", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioRecordingState extends Enum<LiveWrappedAudioRecordingState> {
    public static final LiveWrappedAudioRecordingState AUDIO_RECORDING_STATE_ERROR = null;
    public static final LiveWrappedAudioRecordingState AUDIO_RECORDING_STATE_PROCESSING = null;
    public static final LiveWrappedAudioRecordingState AUDIO_RECORDING_STATE_SUCCESS = null;
    public static final a Companion = null;
    public static final /* synthetic */ LiveWrappedAudioRecordingState[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedAudioRecordingState$a] */
    static {
        LiveWrappedAudioRecordingState r1 = new LiveWrappedAudioRecordingState("AUDIO_RECORDING_STATE_ERROR", 0, 0);
        AUDIO_RECORDING_STATE_ERROR = r1;
        LiveWrappedAudioRecordingState r2 = new LiveWrappedAudioRecordingState("AUDIO_RECORDING_STATE_PROCESSING", 1, 1);
        AUDIO_RECORDING_STATE_PROCESSING = r2;
        LiveWrappedAudioRecordingState r3 = new LiveWrappedAudioRecordingState("AUDIO_RECORDING_STATE_SUCCESS", 2, 2);
        AUDIO_RECORDING_STATE_SUCCESS = r3;
        a = new LiveWrappedAudioRecordingState[]{r1, r2, r3};
        Companion = new a();
    }

    public static LiveWrappedAudioRecordingState valueOf(String r1) {
        return (LiveWrappedAudioRecordingState) r27.a.a(LiveWrappedAudioRecordingState.class, r1);
    }

    public static LiveWrappedAudioRecordingState[] values() {
        return (LiveWrappedAudioRecordingState[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioRecordingState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

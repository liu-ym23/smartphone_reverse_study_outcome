package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedAudioFrameCallbackMethod;", "", "", "value", "I", "Companion", "a", "AUDIO_FRAME_CALLBACK_RECORD", "AUDIO_FRAME_CALLBACK_PLAYBACK", "AUDIO_FRAME_CALLBACK_MIXED", "AUDIO_FRAME_CALLBACK_REMOTE_USER", "AUDIO_FRAME_CALLBACK_CAPTURE_MIXED", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioFrameCallbackMethod extends Enum<LiveWrappedAudioFrameCallbackMethod> {
    public static final LiveWrappedAudioFrameCallbackMethod AUDIO_FRAME_CALLBACK_CAPTURE_MIXED = null;
    public static final LiveWrappedAudioFrameCallbackMethod AUDIO_FRAME_CALLBACK_MIXED = null;
    public static final LiveWrappedAudioFrameCallbackMethod AUDIO_FRAME_CALLBACK_PLAYBACK = null;
    public static final LiveWrappedAudioFrameCallbackMethod AUDIO_FRAME_CALLBACK_RECORD = null;
    public static final LiveWrappedAudioFrameCallbackMethod AUDIO_FRAME_CALLBACK_REMOTE_USER = null;
    public static final a Companion = null;
    public static final /* synthetic */ LiveWrappedAudioFrameCallbackMethod[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioFrameCallbackMethod$a] */
    static {
        LiveWrappedAudioFrameCallbackMethod r2 = new LiveWrappedAudioFrameCallbackMethod("AUDIO_FRAME_CALLBACK_RECORD", 0, 0);
        AUDIO_FRAME_CALLBACK_RECORD = r2;
        LiveWrappedAudioFrameCallbackMethod r3 = new LiveWrappedAudioFrameCallbackMethod("AUDIO_FRAME_CALLBACK_PLAYBACK", 1, 1);
        AUDIO_FRAME_CALLBACK_PLAYBACK = r3;
        LiveWrappedAudioFrameCallbackMethod r4 = new LiveWrappedAudioFrameCallbackMethod("AUDIO_FRAME_CALLBACK_MIXED", 2, 2);
        AUDIO_FRAME_CALLBACK_MIXED = r4;
        LiveWrappedAudioFrameCallbackMethod r5 = new LiveWrappedAudioFrameCallbackMethod("AUDIO_FRAME_CALLBACK_REMOTE_USER", 3, 3);
        AUDIO_FRAME_CALLBACK_REMOTE_USER = r5;
        LiveWrappedAudioFrameCallbackMethod r6 = new LiveWrappedAudioFrameCallbackMethod("AUDIO_FRAME_CALLBACK_CAPTURE_MIXED", 4, 5);
        AUDIO_FRAME_CALLBACK_CAPTURE_MIXED = r6;
        a = new LiveWrappedAudioFrameCallbackMethod[]{r2, r3, r4, r5, r6};
        Companion = new a();
    }

    public static LiveWrappedAudioFrameCallbackMethod valueOf(String r1) {
        return (LiveWrappedAudioFrameCallbackMethod) r27.a.a(LiveWrappedAudioFrameCallbackMethod.class, r1);
    }

    public static LiveWrappedAudioFrameCallbackMethod[] values() {
        return (LiveWrappedAudioFrameCallbackMethod[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioFrameCallbackMethod(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

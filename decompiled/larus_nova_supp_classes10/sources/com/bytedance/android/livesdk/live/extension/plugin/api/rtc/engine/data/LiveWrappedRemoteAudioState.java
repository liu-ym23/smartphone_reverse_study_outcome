package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.i0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedRemoteAudioState;", "", "", "value", "", "toString", "I", "Companion", "a", "REMOTE_AUDIO_STATE_STOPPED", "REMOTE_AUDIO_STATE_STARTING", "REMOTE_AUDIO_STATE_DECODING", "REMOTE_AUDIO_STATE_FROZEN", "REMOTE_AUDIO_STATE_FAILED", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedRemoteAudioState extends Enum<LiveWrappedRemoteAudioState> {
    public static final a Companion = null;
    public static final LiveWrappedRemoteAudioState REMOTE_AUDIO_STATE_DECODING = null;
    public static final LiveWrappedRemoteAudioState REMOTE_AUDIO_STATE_FAILED = null;
    public static final LiveWrappedRemoteAudioState REMOTE_AUDIO_STATE_FROZEN = null;
    public static final LiveWrappedRemoteAudioState REMOTE_AUDIO_STATE_STARTING = null;
    public static final LiveWrappedRemoteAudioState REMOTE_AUDIO_STATE_STOPPED = null;
    public static final /* synthetic */ LiveWrappedRemoteAudioState[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedRemoteAudioState$a] */
    static {
        LiveWrappedRemoteAudioState r1 = new LiveWrappedRemoteAudioState("REMOTE_AUDIO_STATE_STOPPED", 0, 0);
        REMOTE_AUDIO_STATE_STOPPED = r1;
        LiveWrappedRemoteAudioState r2 = new LiveWrappedRemoteAudioState("REMOTE_AUDIO_STATE_STARTING", 1, 1);
        REMOTE_AUDIO_STATE_STARTING = r2;
        LiveWrappedRemoteAudioState r3 = new LiveWrappedRemoteAudioState("REMOTE_AUDIO_STATE_DECODING", 2, 2);
        REMOTE_AUDIO_STATE_DECODING = r3;
        LiveWrappedRemoteAudioState r4 = new LiveWrappedRemoteAudioState("REMOTE_AUDIO_STATE_FROZEN", 3, 3);
        REMOTE_AUDIO_STATE_FROZEN = r4;
        LiveWrappedRemoteAudioState r5 = new LiveWrappedRemoteAudioState("REMOTE_AUDIO_STATE_FAILED", 4, 4);
        REMOTE_AUDIO_STATE_FAILED = r5;
        a = new LiveWrappedRemoteAudioState[]{r1, r2, r3, r4, r5};
        Companion = new a();
    }

    public static LiveWrappedRemoteAudioState valueOf(String r1) {
        return (LiveWrappedRemoteAudioState) r27.a.a(LiveWrappedRemoteAudioState.class, r1);
    }

    public static LiveWrappedRemoteAudioState[] values() {
        return (LiveWrappedRemoteAudioState[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = i0.a[ordinal()];
        if (r0 != 1) goto L5;
        return "kRemoteAudioStateStopped";
    L5:
        if (r0 != 2) goto L7;
        return "kRemoteAudioStateStarting";
    L7:
        if (r0 != 3) goto L9;
        return "kRemoteAudioStateDecoding";
    L9:
        if (r0 != 4) goto L11;
        return "kRemoteAudioStateFrozen";
    L11:
        if (r0 == 5) goto L13;
        return "";
    L13:
        return "kRemoteAudioStateFailed";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedRemoteAudioState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

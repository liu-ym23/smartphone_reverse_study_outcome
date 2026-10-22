package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedWTNRemoteAudioState;", "", "", "value", "", "toString", "I", "Companion", "a", "Stoped", "Starting", "Decoding", "Frozen", "Failed", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedWTNRemoteAudioState extends Enum<LiveWrappedWTNRemoteAudioState> {
    public static final a Companion = null;
    public static final LiveWrappedWTNRemoteAudioState Decoding = null;
    public static final LiveWrappedWTNRemoteAudioState Failed = null;
    public static final LiveWrappedWTNRemoteAudioState Frozen = null;
    public static final LiveWrappedWTNRemoteAudioState Starting = null;
    public static final LiveWrappedWTNRemoteAudioState Stoped = null;
    public static final /* synthetic */ LiveWrappedWTNRemoteAudioState[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNRemoteAudioState$a] */
    static {
        LiveWrappedWTNRemoteAudioState r1 = new LiveWrappedWTNRemoteAudioState("Stoped", 0, 0);
        Stoped = r1;
        LiveWrappedWTNRemoteAudioState r2 = new LiveWrappedWTNRemoteAudioState("Starting", 1, 1);
        Starting = r2;
        LiveWrappedWTNRemoteAudioState r3 = new LiveWrappedWTNRemoteAudioState("Decoding", 2, 2);
        Decoding = r3;
        LiveWrappedWTNRemoteAudioState r4 = new LiveWrappedWTNRemoteAudioState("Frozen", 3, 3);
        Frozen = r4;
        LiveWrappedWTNRemoteAudioState r5 = new LiveWrappedWTNRemoteAudioState("Failed", 4, 4);
        Failed = r5;
        a = new LiveWrappedWTNRemoteAudioState[]{r1, r2, r3, r4, r5};
        Companion = new a();
    }

    public static LiveWrappedWTNRemoteAudioState valueOf(String r1) {
        return (LiveWrappedWTNRemoteAudioState) r27.a.a(LiveWrappedWTNRemoteAudioState.class, r1);
    }

    public static LiveWrappedWTNRemoteAudioState[] values() {
        return (LiveWrappedWTNRemoteAudioState[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = z0.a[ordinal()];
        if (r0 != 1) goto L5;
        return "kWTNRemoteAudioStateStopped";
    L5:
        if (r0 != 2) goto L7;
        return "kWTNRemoteAudioStateStarting";
    L7:
        if (r0 != 3) goto L9;
        return "kWTNRemoteAudioStateDecoding";
    L9:
        if (r0 != 4) goto L11;
        return "kWTNRemoteAudioStateFrozen";
    L11:
        if (r0 == 5) goto L13;
        return "";
    L13:
        return "kWTNRemoteAudioStateFailed";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedWTNRemoteAudioState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

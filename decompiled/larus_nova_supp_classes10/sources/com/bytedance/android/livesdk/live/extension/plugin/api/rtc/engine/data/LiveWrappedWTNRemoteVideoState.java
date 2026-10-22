package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedWTNRemoteVideoState;", "", "", "value", "", "toString", "I", "Companion", "a", "Stoped", "Starting", "Decoding", "Frozen", "Failed", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedWTNRemoteVideoState extends Enum<LiveWrappedWTNRemoteVideoState> {
    public static final a Companion = null;
    public static final LiveWrappedWTNRemoteVideoState Decoding = null;
    public static final LiveWrappedWTNRemoteVideoState Failed = null;
    public static final LiveWrappedWTNRemoteVideoState Frozen = null;
    public static final LiveWrappedWTNRemoteVideoState Starting = null;
    public static final LiveWrappedWTNRemoteVideoState Stoped = null;
    public static final /* synthetic */ LiveWrappedWTNRemoteVideoState[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNRemoteVideoState$a] */
    static {
        LiveWrappedWTNRemoteVideoState r1 = new LiveWrappedWTNRemoteVideoState("Stoped", 0, 0);
        Stoped = r1;
        LiveWrappedWTNRemoteVideoState r2 = new LiveWrappedWTNRemoteVideoState("Starting", 1, 1);
        Starting = r2;
        LiveWrappedWTNRemoteVideoState r3 = new LiveWrappedWTNRemoteVideoState("Decoding", 2, 2);
        Decoding = r3;
        LiveWrappedWTNRemoteVideoState r4 = new LiveWrappedWTNRemoteVideoState("Frozen", 3, 3);
        Frozen = r4;
        LiveWrappedWTNRemoteVideoState r5 = new LiveWrappedWTNRemoteVideoState("Failed", 4, 4);
        Failed = r5;
        a = new LiveWrappedWTNRemoteVideoState[]{r1, r2, r3, r4, r5};
        Companion = new a();
    }

    public static LiveWrappedWTNRemoteVideoState valueOf(String r1) {
        return (LiveWrappedWTNRemoteVideoState) r27.a.a(LiveWrappedWTNRemoteVideoState.class, r1);
    }

    public static LiveWrappedWTNRemoteVideoState[] values() {
        return (LiveWrappedWTNRemoteVideoState[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = b1.a[ordinal()];
        if (r0 != 1) goto L5;
        return "kWTNRemoteVideoStateStopped";
    L5:
        if (r0 != 2) goto L7;
        return "kWTNRemoteVideoStateStarting";
    L7:
        if (r0 != 3) goto L9;
        return "kWTNRemoteVideoStateDecoding";
    L9:
        if (r0 != 4) goto L11;
        return "kWTNRemoteVideoStateFrozen";
    L11:
        if (r0 == 5) goto L13;
        return "";
    L13:
        return "kWTNRemoteVideoStateFailed";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedWTNRemoteVideoState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

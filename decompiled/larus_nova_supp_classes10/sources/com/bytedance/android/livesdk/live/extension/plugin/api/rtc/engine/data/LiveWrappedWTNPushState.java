package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedWTNPushState;", "", "", "value", "", "toString", "I", "Companion", "a", "Init", "Start", "Success", "Stop", "Failed", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedWTNPushState extends Enum<LiveWrappedWTNPushState> {
    public static final a Companion = null;
    public static final LiveWrappedWTNPushState Failed = null;
    public static final LiveWrappedWTNPushState Init = null;
    public static final LiveWrappedWTNPushState Start = null;
    public static final LiveWrappedWTNPushState Stop = null;
    public static final LiveWrappedWTNPushState Success = null;
    public static final /* synthetic */ LiveWrappedWTNPushState[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNPushState$a] */
    static {
        LiveWrappedWTNPushState r1 = new LiveWrappedWTNPushState("Init", 0, 0);
        Init = r1;
        LiveWrappedWTNPushState r2 = new LiveWrappedWTNPushState("Start", 1, 1);
        Start = r2;
        LiveWrappedWTNPushState r3 = new LiveWrappedWTNPushState("Success", 2, 2);
        Success = r3;
        LiveWrappedWTNPushState r4 = new LiveWrappedWTNPushState("Stop", 3, 3);
        Stop = r4;
        LiveWrappedWTNPushState r5 = new LiveWrappedWTNPushState("Failed", 4, 4);
        Failed = r5;
        a = new LiveWrappedWTNPushState[]{r1, r2, r3, r4, r5};
        Companion = new a();
    }

    public static LiveWrappedWTNPushState valueOf(String r1) {
        return (LiveWrappedWTNPushState) r27.a.a(LiveWrappedWTNPushState.class, r1);
    }

    public static LiveWrappedWTNPushState[] values() {
        return (LiveWrappedWTNPushState[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = x0.a[ordinal()];
        if (r0 != 1) goto L5;
        return "kWTNPushStateInit";
    L5:
        if (r0 != 2) goto L7;
        return "kWTNPushStateStart";
    L7:
        if (r0 != 3) goto L9;
        return "kWTNPushStateSuccess";
    L9:
        if (r0 != 4) goto L11;
        return "kWTNPushStateStop";
    L11:
        if (r0 == 5) goto L13;
        return "";
    L13:
        return "kWTNPushStateFailed";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedWTNPushState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

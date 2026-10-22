package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedPlayerState;", "", "", "value", "", "toString", "I", "Companion", "a", "IDLE", "PRELOADED", "OPENED", "PLAYING", "PAUSED", "STOPPED", "FAILED", "FINISHED", "LOOP_FINISHED", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedPlayerState extends Enum<LiveWrappedPlayerState> {
    public static final a Companion = null;
    public static final LiveWrappedPlayerState FAILED = null;
    public static final LiveWrappedPlayerState FINISHED = null;
    public static final LiveWrappedPlayerState IDLE = null;
    public static final LiveWrappedPlayerState LOOP_FINISHED = null;
    public static final LiveWrappedPlayerState OPENED = null;
    public static final LiveWrappedPlayerState PAUSED = null;
    public static final LiveWrappedPlayerState PLAYING = null;
    public static final LiveWrappedPlayerState PRELOADED = null;
    public static final LiveWrappedPlayerState STOPPED = null;
    public static final /* synthetic */ LiveWrappedPlayerState[] a = null;
    private int value;

    public static LiveWrappedPlayerState valueOf(String r1) {
        return (LiveWrappedPlayerState) r27.a.a(LiveWrappedPlayerState.class, r1);
    }

    public static LiveWrappedPlayerState[] values() {
        return (LiveWrappedPlayerState[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedPlayerState$a] */
    static {
        LiveWrappedPlayerState r1 = new LiveWrappedPlayerState("IDLE", 0, 0);
        IDLE = r1;
        LiveWrappedPlayerState r2 = new LiveWrappedPlayerState("PRELOADED", 1, 1);
        PRELOADED = r2;
        LiveWrappedPlayerState r3 = new LiveWrappedPlayerState("OPENED", 2, 2);
        OPENED = r3;
        LiveWrappedPlayerState r4 = new LiveWrappedPlayerState("PLAYING", 3, 3);
        PLAYING = r4;
        LiveWrappedPlayerState r5 = new LiveWrappedPlayerState("PAUSED", 4, 4);
        PAUSED = r5;
        LiveWrappedPlayerState r6 = new LiveWrappedPlayerState("STOPPED", 5, 5);
        STOPPED = r6;
        LiveWrappedPlayerState r7 = new LiveWrappedPlayerState("FAILED", 6, 6);
        FAILED = r7;
        LiveWrappedPlayerState r8 = new LiveWrappedPlayerState("FINISHED", 7, 7);
        FINISHED = r8;
        LiveWrappedPlayerState r9 = new LiveWrappedPlayerState("LOOP_FINISHED", 8, 8);
        LOOP_FINISHED = r9;
        a = new LiveWrappedPlayerState[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(c0.a[ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "LOOP_FINISHED";
    L6:
        return "FINISHED";
    L7:
        return "FAILED";
    L8:
        return "STOPPED";
    L9:
        return "PAUSED";
    L10:
        return "PLAYING";
    L11:
        return "OPENED";
    L12:
        return "PRELOADED";
    L13:
        return "IDLE";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedPlayerState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

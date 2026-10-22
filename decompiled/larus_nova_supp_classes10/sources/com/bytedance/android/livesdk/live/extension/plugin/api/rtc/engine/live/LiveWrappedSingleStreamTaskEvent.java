package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import bg2.t;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedSingleStreamTaskEvent;", "", "", "value", "", "toString", "I", "Companion", "a", "BASE", "START_SUCCESS", "START_FAILED", "STOP_SUCCESS", "STOP_FAILED", "WARNING", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSingleStreamTaskEvent extends Enum<LiveWrappedSingleStreamTaskEvent> {
    public static final LiveWrappedSingleStreamTaskEvent BASE = null;
    public static final a Companion = null;
    public static final LiveWrappedSingleStreamTaskEvent START_FAILED = null;
    public static final LiveWrappedSingleStreamTaskEvent START_SUCCESS = null;
    public static final LiveWrappedSingleStreamTaskEvent STOP_FAILED = null;
    public static final LiveWrappedSingleStreamTaskEvent STOP_SUCCESS = null;
    public static final LiveWrappedSingleStreamTaskEvent WARNING = null;
    public static final /* synthetic */ LiveWrappedSingleStreamTaskEvent[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedSingleStreamTaskEvent$a] */
    static {
        LiveWrappedSingleStreamTaskEvent r1 = new LiveWrappedSingleStreamTaskEvent("BASE", 0, 0);
        BASE = r1;
        LiveWrappedSingleStreamTaskEvent r2 = new LiveWrappedSingleStreamTaskEvent("START_SUCCESS", 1, 1);
        START_SUCCESS = r2;
        LiveWrappedSingleStreamTaskEvent r3 = new LiveWrappedSingleStreamTaskEvent("START_FAILED", 2, 2);
        START_FAILED = r3;
        LiveWrappedSingleStreamTaskEvent r4 = new LiveWrappedSingleStreamTaskEvent("STOP_SUCCESS", 3, 3);
        STOP_SUCCESS = r4;
        LiveWrappedSingleStreamTaskEvent r5 = new LiveWrappedSingleStreamTaskEvent("STOP_FAILED", 4, 4);
        STOP_FAILED = r5;
        LiveWrappedSingleStreamTaskEvent r6 = new LiveWrappedSingleStreamTaskEvent("WARNING", 5, 5);
        WARNING = r6;
        a = new LiveWrappedSingleStreamTaskEvent[]{r1, r2, r3, r4, r5, r6};
        Companion = new a();
    }

    public static LiveWrappedSingleStreamTaskEvent valueOf(String r1) {
        return (LiveWrappedSingleStreamTaskEvent) r27.a.a(LiveWrappedSingleStreamTaskEvent.class, r1);
    }

    public static LiveWrappedSingleStreamTaskEvent[] values() {
        return (LiveWrappedSingleStreamTaskEvent[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(t.a[ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "WARNING";
    L6:
        return "STREAM_MIXING_STOP_FAILED";
    L7:
        return "STREAM_MIXING_STOP_SUCCESS";
    L8:
        return "START_FAILED";
    L9:
        return "START_SUCCESS";
    L10:
        return "BASE";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedSingleStreamTaskEvent(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

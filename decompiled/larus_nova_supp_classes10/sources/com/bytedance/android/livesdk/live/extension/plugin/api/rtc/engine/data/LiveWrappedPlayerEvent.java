package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedPlayerEvent;", "", "", "value", "", "toString", "I", "Companion", "a", "SELECT_AUDIO_TRACK_BEGIN", "SELECT_AUDIO_TRACK_COMPLETED", "SELECT_AUDIO_TRACK_FAILED", "SEEK_BEGIN", "SEEK_COMPLETED", "SEEK_FAILED", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedPlayerEvent extends Enum<LiveWrappedPlayerEvent> {
    public static final a Companion = null;
    public static final LiveWrappedPlayerEvent SEEK_BEGIN = null;
    public static final LiveWrappedPlayerEvent SEEK_COMPLETED = null;
    public static final LiveWrappedPlayerEvent SEEK_FAILED = null;
    public static final LiveWrappedPlayerEvent SELECT_AUDIO_TRACK_BEGIN = null;
    public static final LiveWrappedPlayerEvent SELECT_AUDIO_TRACK_COMPLETED = null;
    public static final LiveWrappedPlayerEvent SELECT_AUDIO_TRACK_FAILED = null;
    public static final /* synthetic */ LiveWrappedPlayerEvent[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedPlayerEvent$a] */
    static {
        LiveWrappedPlayerEvent r1 = new LiveWrappedPlayerEvent("SELECT_AUDIO_TRACK_BEGIN", 0, 0);
        SELECT_AUDIO_TRACK_BEGIN = r1;
        LiveWrappedPlayerEvent r2 = new LiveWrappedPlayerEvent("SELECT_AUDIO_TRACK_COMPLETED", 1, 1);
        SELECT_AUDIO_TRACK_COMPLETED = r2;
        LiveWrappedPlayerEvent r3 = new LiveWrappedPlayerEvent("SELECT_AUDIO_TRACK_FAILED", 2, 2);
        SELECT_AUDIO_TRACK_FAILED = r3;
        LiveWrappedPlayerEvent r4 = new LiveWrappedPlayerEvent("SEEK_BEGIN", 3, 3);
        SEEK_BEGIN = r4;
        LiveWrappedPlayerEvent r5 = new LiveWrappedPlayerEvent("SEEK_COMPLETED", 4, 4);
        SEEK_COMPLETED = r5;
        LiveWrappedPlayerEvent r6 = new LiveWrappedPlayerEvent("SEEK_FAILED", 5, 5);
        SEEK_FAILED = r6;
        a = new LiveWrappedPlayerEvent[]{r1, r2, r3, r4, r5, r6};
        Companion = new a();
    }

    public static LiveWrappedPlayerEvent valueOf(String r1) {
        return (LiveWrappedPlayerEvent) r27.a.a(LiveWrappedPlayerEvent.class, r1);
    }

    public static LiveWrappedPlayerEvent[] values() {
        return (LiveWrappedPlayerEvent[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(b0.a[ordinal()]) {
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
        return "SEEK_FAILED";
    L6:
        return "SEEK_COMPLETED";
    L7:
        return "SEEK_BEGIN";
    L8:
        return "SELECT_AUDIO_TRACK_FAILED";
    L9:
        return "SELECT_AUDIO_TRACK_COMPLETED";
    L10:
        return "SELECT_AUDIO_TRACK_BEGIN";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedPlayerEvent(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

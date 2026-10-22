package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedRoomEvent;", "", "", "value", "I", "Companion", "a", "USER_NOTIFY_STOP", "FORBIDDEN", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedRoomEvent extends Enum<LiveWrappedRoomEvent> {
    public static final a Companion = null;
    public static final LiveWrappedRoomEvent FORBIDDEN = null;
    public static final LiveWrappedRoomEvent USER_NOTIFY_STOP = null;
    public static final /* synthetic */ LiveWrappedRoomEvent[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomEvent$a] */
    static {
        LiveWrappedRoomEvent r1 = new LiveWrappedRoomEvent("USER_NOTIFY_STOP", 0, -2013);
        USER_NOTIFY_STOP = r1;
        LiveWrappedRoomEvent r2 = new LiveWrappedRoomEvent("FORBIDDEN", 1, -2012);
        FORBIDDEN = r2;
        a = new LiveWrappedRoomEvent[]{r1, r2};
        Companion = new a();
    }

    public static LiveWrappedRoomEvent valueOf(String r1) {
        return (LiveWrappedRoomEvent) r27.a.a(LiveWrappedRoomEvent.class, r1);
    }

    public static LiveWrappedRoomEvent[] values() {
        return (LiveWrappedRoomEvent[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedRoomEvent(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

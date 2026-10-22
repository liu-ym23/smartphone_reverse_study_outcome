package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedSEIStreamUpdateEvent;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "Companion", "a", "STREAM_ADD", "STREAM_REMOVE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSEIStreamUpdateEvent extends Enum<LiveWrappedSEIStreamUpdateEvent> {
    public static final a Companion = null;
    public static final LiveWrappedSEIStreamUpdateEvent STREAM_ADD = null;
    public static final LiveWrappedSEIStreamUpdateEvent STREAM_REMOVE = null;
    public static final /* synthetic */ LiveWrappedSEIStreamUpdateEvent[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedSEIStreamUpdateEvent$a] */
    static {
        LiveWrappedSEIStreamUpdateEvent r1 = new LiveWrappedSEIStreamUpdateEvent("STREAM_ADD", 0, 0);
        STREAM_ADD = r1;
        LiveWrappedSEIStreamUpdateEvent r2 = new LiveWrappedSEIStreamUpdateEvent("STREAM_REMOVE", 1, 1);
        STREAM_REMOVE = r2;
        a = new LiveWrappedSEIStreamUpdateEvent[]{r1, r2};
        Companion = new a();
    }

    public static LiveWrappedSEIStreamUpdateEvent valueOf(String r1) {
        return (LiveWrappedSEIStreamUpdateEvent) r27.a.a(LiveWrappedSEIStreamUpdateEvent.class, r1);
    }

    public static LiveWrappedSEIStreamUpdateEvent[] values() {
        return (LiveWrappedSEIStreamUpdateEvent[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public final int value() {
        return this.value;
    }

    public final void setValue(int r1) {
        this.value = r1;
    }

    public LiveWrappedSEIStreamUpdateEvent(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

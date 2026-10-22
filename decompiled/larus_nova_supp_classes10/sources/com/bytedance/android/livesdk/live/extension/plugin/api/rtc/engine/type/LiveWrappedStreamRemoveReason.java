package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedStreamRemoveReason;", "", "", "value", "I", "Companion", "a", "STREAM_REMOVE_REASON_UNPUBLISH", "STREAM_REMOVE_REASON_PUBLISH_FAILED", "STREAM_REMOVE_REASON_KEEP_LIVE_FAILED", "STREAM_REMOVE_REASON_CLIENT_DISCONNECTED", "STREAM_REMOVE_REASON_REPUBLISH", "STREAM_REMOVE_REASON_OTHER", "STREAM_REMOVE_REASON_PUBLISH_PRIVILEGE_TOKEN_EXPIRED", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedStreamRemoveReason extends Enum<LiveWrappedStreamRemoveReason> {
    public static final a Companion = null;
    public static final LiveWrappedStreamRemoveReason STREAM_REMOVE_REASON_CLIENT_DISCONNECTED = null;
    public static final LiveWrappedStreamRemoveReason STREAM_REMOVE_REASON_KEEP_LIVE_FAILED = null;
    public static final LiveWrappedStreamRemoveReason STREAM_REMOVE_REASON_OTHER = null;
    public static final LiveWrappedStreamRemoveReason STREAM_REMOVE_REASON_PUBLISH_FAILED = null;
    public static final LiveWrappedStreamRemoveReason STREAM_REMOVE_REASON_PUBLISH_PRIVILEGE_TOKEN_EXPIRED = null;
    public static final LiveWrappedStreamRemoveReason STREAM_REMOVE_REASON_REPUBLISH = null;
    public static final LiveWrappedStreamRemoveReason STREAM_REMOVE_REASON_UNPUBLISH = null;
    public static final /* synthetic */ LiveWrappedStreamRemoveReason[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedStreamRemoveReason$a] */
    static {
        LiveWrappedStreamRemoveReason r1 = new LiveWrappedStreamRemoveReason("STREAM_REMOVE_REASON_UNPUBLISH", 0, 0);
        STREAM_REMOVE_REASON_UNPUBLISH = r1;
        LiveWrappedStreamRemoveReason r2 = new LiveWrappedStreamRemoveReason("STREAM_REMOVE_REASON_PUBLISH_FAILED", 1, 1);
        STREAM_REMOVE_REASON_PUBLISH_FAILED = r2;
        LiveWrappedStreamRemoveReason r3 = new LiveWrappedStreamRemoveReason("STREAM_REMOVE_REASON_KEEP_LIVE_FAILED", 2, 2);
        STREAM_REMOVE_REASON_KEEP_LIVE_FAILED = r3;
        LiveWrappedStreamRemoveReason r4 = new LiveWrappedStreamRemoveReason("STREAM_REMOVE_REASON_CLIENT_DISCONNECTED", 3, 3);
        STREAM_REMOVE_REASON_CLIENT_DISCONNECTED = r4;
        LiveWrappedStreamRemoveReason r5 = new LiveWrappedStreamRemoveReason("STREAM_REMOVE_REASON_REPUBLISH", 4, 4);
        STREAM_REMOVE_REASON_REPUBLISH = r5;
        LiveWrappedStreamRemoveReason r6 = new LiveWrappedStreamRemoveReason("STREAM_REMOVE_REASON_OTHER", 5, 5);
        STREAM_REMOVE_REASON_OTHER = r6;
        LiveWrappedStreamRemoveReason r7 = new LiveWrappedStreamRemoveReason("STREAM_REMOVE_REASON_PUBLISH_PRIVILEGE_TOKEN_EXPIRED", 6, 6);
        STREAM_REMOVE_REASON_PUBLISH_PRIVILEGE_TOKEN_EXPIRED = r7;
        a = new LiveWrappedStreamRemoveReason[]{r1, r2, r3, r4, r5, r6, r7};
        Companion = new a();
    }

    public static LiveWrappedStreamRemoveReason valueOf(String r1) {
        return (LiveWrappedStreamRemoveReason) r27.a.a(LiveWrappedStreamRemoveReason.class, r1);
    }

    public static LiveWrappedStreamRemoveReason[] values() {
        return (LiveWrappedStreamRemoveReason[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedStreamRemoveReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

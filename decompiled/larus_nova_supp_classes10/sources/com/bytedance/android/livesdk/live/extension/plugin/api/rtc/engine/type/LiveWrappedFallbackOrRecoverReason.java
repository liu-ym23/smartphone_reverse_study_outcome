package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedFallbackOrRecoverReason;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "Companion", "a", "FALLBACK_OR_RECOVER_REASON_UNKNOWN", "FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_BANDWIDTH", "FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_PERFORMANCE", "FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_BANDWIDTH", "FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_PERFORMANCE", "FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_BANDWIDTH", "FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_PERFORMANCE", "FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_BANDWIDTH", "FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_PERFORMANCE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedFallbackOrRecoverReason extends Enum<LiveWrappedFallbackOrRecoverReason> {
    public static final a Companion = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_BANDWIDTH = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_PERFORMANCE = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_BANDWIDTH = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_PERFORMANCE = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_BANDWIDTH = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_PERFORMANCE = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_BANDWIDTH = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_PERFORMANCE = null;
    public static final LiveWrappedFallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_UNKNOWN = null;
    public static final /* synthetic */ LiveWrappedFallbackOrRecoverReason[] a = null;
    private int value;

    public static LiveWrappedFallbackOrRecoverReason valueOf(String r1) {
        return (LiveWrappedFallbackOrRecoverReason) r27.a.a(LiveWrappedFallbackOrRecoverReason.class, r1);
    }

    public static LiveWrappedFallbackOrRecoverReason[] values() {
        return (LiveWrappedFallbackOrRecoverReason[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedFallbackOrRecoverReason$a] */
    static {
        LiveWrappedFallbackOrRecoverReason r1 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_UNKNOWN", 0, -1);
        FALLBACK_OR_RECOVER_REASON_UNKNOWN = r1;
        LiveWrappedFallbackOrRecoverReason r2 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_BANDWIDTH", 1, 0);
        FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_BANDWIDTH = r2;
        LiveWrappedFallbackOrRecoverReason r3 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_PERFORMANCE", 2, 1);
        FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_PERFORMANCE = r3;
        LiveWrappedFallbackOrRecoverReason r4 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_BANDWIDTH", 3, 2);
        FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_BANDWIDTH = r4;
        LiveWrappedFallbackOrRecoverReason r5 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_PERFORMANCE", 4, 3);
        FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_PERFORMANCE = r5;
        LiveWrappedFallbackOrRecoverReason r6 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_BANDWIDTH", 5, 4);
        FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_BANDWIDTH = r6;
        LiveWrappedFallbackOrRecoverReason r7 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_PERFORMANCE", 6, 5);
        FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_PERFORMANCE = r7;
        LiveWrappedFallbackOrRecoverReason r8 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_BANDWIDTH", 7, 6);
        FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_BANDWIDTH = r8;
        LiveWrappedFallbackOrRecoverReason r9 = new LiveWrappedFallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_PERFORMANCE", 8, 7);
        FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_PERFORMANCE = r9;
        a = new LiveWrappedFallbackOrRecoverReason[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
        Companion = new a();
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

    public LiveWrappedFallbackOrRecoverReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

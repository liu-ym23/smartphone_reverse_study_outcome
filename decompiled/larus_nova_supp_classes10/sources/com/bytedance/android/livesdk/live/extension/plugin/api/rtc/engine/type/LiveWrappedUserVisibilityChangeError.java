package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedUserVisibilityChangeError;", "", "", "value", "I", "Companion", "a", "OK", "UNKNOWN", "TOO_MANY_VISIBLE_USER", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedUserVisibilityChangeError extends Enum<LiveWrappedUserVisibilityChangeError> {
    public static final a Companion = null;
    public static final LiveWrappedUserVisibilityChangeError OK = null;
    public static final LiveWrappedUserVisibilityChangeError TOO_MANY_VISIBLE_USER = null;
    public static final LiveWrappedUserVisibilityChangeError UNKNOWN = null;
    public static final /* synthetic */ LiveWrappedUserVisibilityChangeError[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedUserVisibilityChangeError$a] */
    static {
        LiveWrappedUserVisibilityChangeError r1 = new LiveWrappedUserVisibilityChangeError("OK", 0, 0);
        OK = r1;
        LiveWrappedUserVisibilityChangeError r2 = new LiveWrappedUserVisibilityChangeError("UNKNOWN", 1, 1);
        UNKNOWN = r2;
        LiveWrappedUserVisibilityChangeError r3 = new LiveWrappedUserVisibilityChangeError("TOO_MANY_VISIBLE_USER", 2, 2);
        TOO_MANY_VISIBLE_USER = r3;
        a = new LiveWrappedUserVisibilityChangeError[]{r1, r2, r3};
        Companion = new a();
    }

    public static LiveWrappedUserVisibilityChangeError valueOf(String r1) {
        return (LiveWrappedUserVisibilityChangeError) r27.a.a(LiveWrappedUserVisibilityChangeError.class, r1);
    }

    public static LiveWrappedUserVisibilityChangeError[] values() {
        return (LiveWrappedUserVisibilityChangeError[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedUserVisibilityChangeError(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

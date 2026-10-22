package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedPublicStreamErrorCode;", "", "", "value", "I", "Companion", "a", "ERROR_CODE_SUCCESS", "ERROR_CODE_PUSH_PARAM_ERROR", "ERROR_CODE_PUSH_STATE_ERROR", "ERROR_CODE_PUSH_INTERNAL_ERROR", "ERROR_CODE_PUSH_ERROR", "ERROR_CODE_PUSH_TIMEOUT", "ERROR_CODE_PULL_NO_PUSH_STREAM", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedPublicStreamErrorCode extends Enum<LiveWrappedPublicStreamErrorCode> {
    public static final a Companion = null;
    public static final LiveWrappedPublicStreamErrorCode ERROR_CODE_PULL_NO_PUSH_STREAM = null;
    public static final LiveWrappedPublicStreamErrorCode ERROR_CODE_PUSH_ERROR = null;
    public static final LiveWrappedPublicStreamErrorCode ERROR_CODE_PUSH_INTERNAL_ERROR = null;
    public static final LiveWrappedPublicStreamErrorCode ERROR_CODE_PUSH_PARAM_ERROR = null;
    public static final LiveWrappedPublicStreamErrorCode ERROR_CODE_PUSH_STATE_ERROR = null;
    public static final LiveWrappedPublicStreamErrorCode ERROR_CODE_PUSH_TIMEOUT = null;
    public static final LiveWrappedPublicStreamErrorCode ERROR_CODE_SUCCESS = null;
    public static final /* synthetic */ LiveWrappedPublicStreamErrorCode[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedPublicStreamErrorCode$a] */
    static {
        LiveWrappedPublicStreamErrorCode r1 = new LiveWrappedPublicStreamErrorCode("ERROR_CODE_SUCCESS", 0, 0);
        ERROR_CODE_SUCCESS = r1;
        LiveWrappedPublicStreamErrorCode r2 = new LiveWrappedPublicStreamErrorCode("ERROR_CODE_PUSH_PARAM_ERROR", 1, 1191);
        ERROR_CODE_PUSH_PARAM_ERROR = r2;
        LiveWrappedPublicStreamErrorCode r3 = new LiveWrappedPublicStreamErrorCode("ERROR_CODE_PUSH_STATE_ERROR", 2, 1192);
        ERROR_CODE_PUSH_STATE_ERROR = r3;
        LiveWrappedPublicStreamErrorCode r4 = new LiveWrappedPublicStreamErrorCode("ERROR_CODE_PUSH_INTERNAL_ERROR", 3, 1193);
        ERROR_CODE_PUSH_INTERNAL_ERROR = r4;
        LiveWrappedPublicStreamErrorCode r5 = new LiveWrappedPublicStreamErrorCode("ERROR_CODE_PUSH_ERROR", 4, 1195);
        ERROR_CODE_PUSH_ERROR = r5;
        LiveWrappedPublicStreamErrorCode r6 = new LiveWrappedPublicStreamErrorCode("ERROR_CODE_PUSH_TIMEOUT", 5, 1196);
        ERROR_CODE_PUSH_TIMEOUT = r6;
        LiveWrappedPublicStreamErrorCode r7 = new LiveWrappedPublicStreamErrorCode("ERROR_CODE_PULL_NO_PUSH_STREAM", 6, 1300);
        ERROR_CODE_PULL_NO_PUSH_STREAM = r7;
        a = new LiveWrappedPublicStreamErrorCode[]{r1, r2, r3, r4, r5, r6, r7};
        Companion = new a();
    }

    public static LiveWrappedPublicStreamErrorCode valueOf(String r1) {
        return (LiveWrappedPublicStreamErrorCode) r27.a.a(LiveWrappedPublicStreamErrorCode.class, r1);
    }

    public static LiveWrappedPublicStreamErrorCode[] values() {
        return (LiveWrappedPublicStreamErrorCode[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedPublicStreamErrorCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

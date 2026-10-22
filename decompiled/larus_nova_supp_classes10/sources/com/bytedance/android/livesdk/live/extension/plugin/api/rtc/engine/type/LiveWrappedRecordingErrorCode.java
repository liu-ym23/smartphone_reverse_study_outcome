package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedRecordingErrorCode;", "", "", "value", "I", "Companion", "a", "RECORDING_ERROR_CODE_OK", "RECORDING_ERROR_CODE_NO_PERMISSION", "RECORDING_ERROR_CODE_NOT_SUPPORT", "RECORDING_ERROR_CODE_NO_OTHER", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedRecordingErrorCode extends Enum<LiveWrappedRecordingErrorCode> {
    public static final a Companion = null;
    public static final LiveWrappedRecordingErrorCode RECORDING_ERROR_CODE_NOT_SUPPORT = null;
    public static final LiveWrappedRecordingErrorCode RECORDING_ERROR_CODE_NO_OTHER = null;
    public static final LiveWrappedRecordingErrorCode RECORDING_ERROR_CODE_NO_PERMISSION = null;
    public static final LiveWrappedRecordingErrorCode RECORDING_ERROR_CODE_OK = null;
    public static final /* synthetic */ LiveWrappedRecordingErrorCode[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRecordingErrorCode$a] */
    static {
        LiveWrappedRecordingErrorCode r1 = new LiveWrappedRecordingErrorCode("RECORDING_ERROR_CODE_OK", 0, 0);
        RECORDING_ERROR_CODE_OK = r1;
        LiveWrappedRecordingErrorCode r2 = new LiveWrappedRecordingErrorCode("RECORDING_ERROR_CODE_NO_PERMISSION", 1, -1);
        RECORDING_ERROR_CODE_NO_PERMISSION = r2;
        LiveWrappedRecordingErrorCode r3 = new LiveWrappedRecordingErrorCode("RECORDING_ERROR_CODE_NOT_SUPPORT", 2, -2);
        RECORDING_ERROR_CODE_NOT_SUPPORT = r3;
        LiveWrappedRecordingErrorCode r4 = new LiveWrappedRecordingErrorCode("RECORDING_ERROR_CODE_NO_OTHER", 3, -3);
        RECORDING_ERROR_CODE_NO_OTHER = r4;
        a = new LiveWrappedRecordingErrorCode[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static LiveWrappedRecordingErrorCode valueOf(String r1) {
        return (LiveWrappedRecordingErrorCode) r27.a.a(LiveWrappedRecordingErrorCode.class, r1);
    }

    public static LiveWrappedRecordingErrorCode[] values() {
        return (LiveWrappedRecordingErrorCode[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedRecordingErrorCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

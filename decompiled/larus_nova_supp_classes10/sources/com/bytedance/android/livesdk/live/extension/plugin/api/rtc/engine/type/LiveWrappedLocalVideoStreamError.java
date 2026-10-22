package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedLocalVideoStreamError;", "", "", "value", "I", "Companion", "a", "LOCAL_VIDEO_STREAM_ERROR_OK", "LOCAL_VIDEO_STREAM_ERROR_FAILURE", "LOCAL_VIDEO_STREAM_ERROR_DEVICE_NO_PERMISSION", "LOCAL_VIDEO_STREAM_ERROR_DEVICE_BUSY", "LOCAL_VIDEO_STREAM_ERROR_DEVICE_NOT_FOUND", "LOCAL_VIDEO_STREAM_ERROR_CAPTURE_FAILURE", "LOCAL_VIDEO_STREAM_ERROR_ENCODE_FAILURE", "LOCAL_VIDEO_STREAM_ERROR_DEVICE_DISCONNECTED", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedLocalVideoStreamError extends Enum<LiveWrappedLocalVideoStreamError> {
    public static final a Companion = null;
    public static final LiveWrappedLocalVideoStreamError LOCAL_VIDEO_STREAM_ERROR_CAPTURE_FAILURE = null;
    public static final LiveWrappedLocalVideoStreamError LOCAL_VIDEO_STREAM_ERROR_DEVICE_BUSY = null;
    public static final LiveWrappedLocalVideoStreamError LOCAL_VIDEO_STREAM_ERROR_DEVICE_DISCONNECTED = null;
    public static final LiveWrappedLocalVideoStreamError LOCAL_VIDEO_STREAM_ERROR_DEVICE_NOT_FOUND = null;
    public static final LiveWrappedLocalVideoStreamError LOCAL_VIDEO_STREAM_ERROR_DEVICE_NO_PERMISSION = null;
    public static final LiveWrappedLocalVideoStreamError LOCAL_VIDEO_STREAM_ERROR_ENCODE_FAILURE = null;
    public static final LiveWrappedLocalVideoStreamError LOCAL_VIDEO_STREAM_ERROR_FAILURE = null;
    public static final LiveWrappedLocalVideoStreamError LOCAL_VIDEO_STREAM_ERROR_OK = null;
    public static final /* synthetic */ LiveWrappedLocalVideoStreamError[] a = null;
    private int value;

    public static LiveWrappedLocalVideoStreamError valueOf(String r1) {
        return (LiveWrappedLocalVideoStreamError) r27.a.a(LiveWrappedLocalVideoStreamError.class, r1);
    }

    public static LiveWrappedLocalVideoStreamError[] values() {
        return (LiveWrappedLocalVideoStreamError[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedLocalVideoStreamError$a] */
    static {
        LiveWrappedLocalVideoStreamError r1 = new LiveWrappedLocalVideoStreamError("LOCAL_VIDEO_STREAM_ERROR_OK", 0, 0);
        LOCAL_VIDEO_STREAM_ERROR_OK = r1;
        LiveWrappedLocalVideoStreamError r2 = new LiveWrappedLocalVideoStreamError("LOCAL_VIDEO_STREAM_ERROR_FAILURE", 1, 1);
        LOCAL_VIDEO_STREAM_ERROR_FAILURE = r2;
        LiveWrappedLocalVideoStreamError r3 = new LiveWrappedLocalVideoStreamError("LOCAL_VIDEO_STREAM_ERROR_DEVICE_NO_PERMISSION", 2, 2);
        LOCAL_VIDEO_STREAM_ERROR_DEVICE_NO_PERMISSION = r3;
        LiveWrappedLocalVideoStreamError r4 = new LiveWrappedLocalVideoStreamError("LOCAL_VIDEO_STREAM_ERROR_DEVICE_BUSY", 3, 3);
        LOCAL_VIDEO_STREAM_ERROR_DEVICE_BUSY = r4;
        LiveWrappedLocalVideoStreamError r5 = new LiveWrappedLocalVideoStreamError("LOCAL_VIDEO_STREAM_ERROR_DEVICE_NOT_FOUND", 4, 4);
        LOCAL_VIDEO_STREAM_ERROR_DEVICE_NOT_FOUND = r5;
        LiveWrappedLocalVideoStreamError r6 = new LiveWrappedLocalVideoStreamError("LOCAL_VIDEO_STREAM_ERROR_CAPTURE_FAILURE", 5, 5);
        LOCAL_VIDEO_STREAM_ERROR_CAPTURE_FAILURE = r6;
        LiveWrappedLocalVideoStreamError r7 = new LiveWrappedLocalVideoStreamError("LOCAL_VIDEO_STREAM_ERROR_ENCODE_FAILURE", 6, 6);
        LOCAL_VIDEO_STREAM_ERROR_ENCODE_FAILURE = r7;
        LiveWrappedLocalVideoStreamError r8 = new LiveWrappedLocalVideoStreamError("LOCAL_VIDEO_STREAM_ERROR_DEVICE_DISCONNECTED", 7, 7);
        LOCAL_VIDEO_STREAM_ERROR_DEVICE_DISCONNECTED = r8;
        a = new LiveWrappedLocalVideoStreamError[]{r1, r2, r3, r4, r5, r6, r7, r8};
        Companion = new a();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedLocalVideoStreamError(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

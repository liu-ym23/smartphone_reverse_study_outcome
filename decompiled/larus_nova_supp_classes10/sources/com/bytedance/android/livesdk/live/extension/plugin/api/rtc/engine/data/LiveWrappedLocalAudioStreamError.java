package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedLocalAudioStreamError;", "", "", "value", "", "toString", "I", "Companion", "a", "LOCAL_AUDIO_STREAM_ERROR_OK", "LOCAL_AUDIO_STREAM_ERROR_FAILURE", "LOCAL_AUDIO_STREAM_ERROR_DEVICE_NO_PERMISSION", "LOCAL_AUDIO_STREAM_ERROR_DEVICE_BUSY", "LOCAL_AUDIO_STREAM_ERROR_RECORD_FAILURE", "LOCAL_AUDIO_STREAM_ERROR_ENCODE_FAILURE", "LOCAL_AUDIO_STREAM_ERROR_NO_RECORDING_DEVICE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedLocalAudioStreamError extends Enum<LiveWrappedLocalAudioStreamError> {
    public static final a Companion = null;
    public static final LiveWrappedLocalAudioStreamError LOCAL_AUDIO_STREAM_ERROR_DEVICE_BUSY = null;
    public static final LiveWrappedLocalAudioStreamError LOCAL_AUDIO_STREAM_ERROR_DEVICE_NO_PERMISSION = null;
    public static final LiveWrappedLocalAudioStreamError LOCAL_AUDIO_STREAM_ERROR_ENCODE_FAILURE = null;
    public static final LiveWrappedLocalAudioStreamError LOCAL_AUDIO_STREAM_ERROR_FAILURE = null;
    public static final LiveWrappedLocalAudioStreamError LOCAL_AUDIO_STREAM_ERROR_NO_RECORDING_DEVICE = null;
    public static final LiveWrappedLocalAudioStreamError LOCAL_AUDIO_STREAM_ERROR_OK = null;
    public static final LiveWrappedLocalAudioStreamError LOCAL_AUDIO_STREAM_ERROR_RECORD_FAILURE = null;
    public static final /* synthetic */ LiveWrappedLocalAudioStreamError[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedLocalAudioStreamError$a] */
    static {
        LiveWrappedLocalAudioStreamError r1 = new LiveWrappedLocalAudioStreamError("LOCAL_AUDIO_STREAM_ERROR_OK", 0, 0);
        LOCAL_AUDIO_STREAM_ERROR_OK = r1;
        LiveWrappedLocalAudioStreamError r2 = new LiveWrappedLocalAudioStreamError("LOCAL_AUDIO_STREAM_ERROR_FAILURE", 1, 1);
        LOCAL_AUDIO_STREAM_ERROR_FAILURE = r2;
        LiveWrappedLocalAudioStreamError r3 = new LiveWrappedLocalAudioStreamError("LOCAL_AUDIO_STREAM_ERROR_DEVICE_NO_PERMISSION", 2, 2);
        LOCAL_AUDIO_STREAM_ERROR_DEVICE_NO_PERMISSION = r3;
        LiveWrappedLocalAudioStreamError r4 = new LiveWrappedLocalAudioStreamError("LOCAL_AUDIO_STREAM_ERROR_DEVICE_BUSY", 3, 3);
        LOCAL_AUDIO_STREAM_ERROR_DEVICE_BUSY = r4;
        LiveWrappedLocalAudioStreamError r5 = new LiveWrappedLocalAudioStreamError("LOCAL_AUDIO_STREAM_ERROR_RECORD_FAILURE", 4, 4);
        LOCAL_AUDIO_STREAM_ERROR_RECORD_FAILURE = r5;
        LiveWrappedLocalAudioStreamError r6 = new LiveWrappedLocalAudioStreamError("LOCAL_AUDIO_STREAM_ERROR_ENCODE_FAILURE", 5, 5);
        LOCAL_AUDIO_STREAM_ERROR_ENCODE_FAILURE = r6;
        LiveWrappedLocalAudioStreamError r7 = new LiveWrappedLocalAudioStreamError("LOCAL_AUDIO_STREAM_ERROR_NO_RECORDING_DEVICE", 6, 6);
        LOCAL_AUDIO_STREAM_ERROR_NO_RECORDING_DEVICE = r7;
        a = new LiveWrappedLocalAudioStreamError[]{r1, r2, r3, r4, r5, r6, r7};
        Companion = new a();
    }

    public static LiveWrappedLocalAudioStreamError valueOf(String r1) {
        return (LiveWrappedLocalAudioStreamError) r27.a.a(LiveWrappedLocalAudioStreamError.class, r1);
    }

    public static LiveWrappedLocalAudioStreamError[] values() {
        return (LiveWrappedLocalAudioStreamError[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(u.a[ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "kLocalAudioStreamErrorNoRecordingDevice";
    L6:
        return "kLocalAudioStreamErrorEncodeFailure";
    L7:
        return "kLocalAudioStreamErrorRecordFailure";
    L8:
        return "kLocalAudioStreamErrorDeviceBusy";
    L9:
        return "kLocalAudioStreamErrorDeviceNoPermission";
    L10:
        return "kLocalAudioStreamErrorFailure";
    L11:
        return "kLocalAudioStreamErrorOk";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedLocalAudioStreamError(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

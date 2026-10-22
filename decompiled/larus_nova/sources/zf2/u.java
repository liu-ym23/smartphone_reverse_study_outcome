package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedLocalAudioStreamError;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571744a = null;

    static {
        int[] r100 = new int[LiveWrappedLocalAudioStreamError.values().length];
        f571744a = r100;
        r100[LiveWrappedLocalAudioStreamError.LOCAL_AUDIO_STREAM_ERROR_OK.ordinal()] = 1;
        r100[LiveWrappedLocalAudioStreamError.LOCAL_AUDIO_STREAM_ERROR_FAILURE.ordinal()] = 2;
        r100[LiveWrappedLocalAudioStreamError.LOCAL_AUDIO_STREAM_ERROR_DEVICE_NO_PERMISSION.ordinal()] = 3;
        r100[LiveWrappedLocalAudioStreamError.LOCAL_AUDIO_STREAM_ERROR_DEVICE_BUSY.ordinal()] = 4;
        r100[LiveWrappedLocalAudioStreamError.LOCAL_AUDIO_STREAM_ERROR_RECORD_FAILURE.ordinal()] = 5;
        r100[LiveWrappedLocalAudioStreamError.LOCAL_AUDIO_STREAM_ERROR_ENCODE_FAILURE.ordinal()] = 6;
        r100[LiveWrappedLocalAudioStreamError.LOCAL_AUDIO_STREAM_ERROR_NO_RECORDING_DEVICE.ordinal()] = 7;
    }
}

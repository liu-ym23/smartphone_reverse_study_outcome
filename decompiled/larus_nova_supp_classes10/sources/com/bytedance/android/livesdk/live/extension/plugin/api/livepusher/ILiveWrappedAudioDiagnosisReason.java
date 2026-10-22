package com.bytedance.android.livesdk.live.extension.plugin.api.livepusher;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/livepusher/ILiveWrappedAudioDiagnosisReason;", "", "", "value", "I", "AudioDiagnosisReasonNoAbnormality", "AudioDiagnosisReasonCaptureMutedData", "AudioDiagnosisReasonCaptureFrameRateZero", "AudioDiagnosisReasonPlaybackFrameRateZero", "AudioDiagnosisReasonPermissionDenied", "AudioDiagnosisReasonAndroidDeviceOccupied", "AudioDiagnosisReasonSpeakerSystemMuted", "AudioDiagnosisReasonLowSpeakerSystemVolume", "AudioDiagnosisReasonLowCaptureLevel", "AudioDiagnosisReasonHighAecSuppression", "AudioDiagnosisReasonHighMediaPlayerLevel", "AudioDiagnosisReasonCaptureDeviceNotStart", "AudioDiagnosisReasonLowCaptureVolume", "AudioDiagnosisReasonCaptureFrameRateError", "AudioDiagnosisReasonPlaybackFrameRateError", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ILiveWrappedAudioDiagnosisReason extends Enum<ILiveWrappedAudioDiagnosisReason> {
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonAndroidDeviceOccupied = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonCaptureDeviceNotStart = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonCaptureFrameRateError = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonCaptureFrameRateZero = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonCaptureMutedData = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonHighAecSuppression = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonHighMediaPlayerLevel = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonLowCaptureLevel = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonLowCaptureVolume = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonLowSpeakerSystemVolume = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonNoAbnormality = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonPermissionDenied = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonPlaybackFrameRateError = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonPlaybackFrameRateZero = null;
    public static final ILiveWrappedAudioDiagnosisReason AudioDiagnosisReasonSpeakerSystemMuted = null;
    public static final /* synthetic */ ILiveWrappedAudioDiagnosisReason[] a = null;
    private final int value;

    public static ILiveWrappedAudioDiagnosisReason valueOf(String r1) {
        return (ILiveWrappedAudioDiagnosisReason) a.a(ILiveWrappedAudioDiagnosisReason.class, r1);
    }

    public static ILiveWrappedAudioDiagnosisReason[] values() {
        return (ILiveWrappedAudioDiagnosisReason[]) a.clone();
    }

    static {
        ILiveWrappedAudioDiagnosisReason r1 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonNoAbnormality", 0, 0);
        AudioDiagnosisReasonNoAbnormality = r1;
        ILiveWrappedAudioDiagnosisReason r2 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonCaptureMutedData", 1, -1000);
        AudioDiagnosisReasonCaptureMutedData = r2;
        ILiveWrappedAudioDiagnosisReason r3 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonCaptureFrameRateZero", 2, -1001);
        AudioDiagnosisReasonCaptureFrameRateZero = r3;
        ILiveWrappedAudioDiagnosisReason r4 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonPlaybackFrameRateZero", 3, -1002);
        AudioDiagnosisReasonPlaybackFrameRateZero = r4;
        ILiveWrappedAudioDiagnosisReason r5 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonPermissionDenied", 4, -1005);
        AudioDiagnosisReasonPermissionDenied = r5;
        ILiveWrappedAudioDiagnosisReason r6 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonAndroidDeviceOccupied", 5, -2005);
        AudioDiagnosisReasonAndroidDeviceOccupied = r6;
        ILiveWrappedAudioDiagnosisReason r7 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonSpeakerSystemMuted", 6, -2006);
        AudioDiagnosisReasonSpeakerSystemMuted = r7;
        ILiveWrappedAudioDiagnosisReason r8 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonLowSpeakerSystemVolume", 7, -2007);
        AudioDiagnosisReasonLowSpeakerSystemVolume = r8;
        ILiveWrappedAudioDiagnosisReason r9 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonLowCaptureLevel", 8, -2008);
        AudioDiagnosisReasonLowCaptureLevel = r9;
        ILiveWrappedAudioDiagnosisReason r10 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonHighAecSuppression", 9, -2009);
        AudioDiagnosisReasonHighAecSuppression = r10;
        ILiveWrappedAudioDiagnosisReason r11 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonHighMediaPlayerLevel", 10, -2010);
        AudioDiagnosisReasonHighMediaPlayerLevel = r11;
        ILiveWrappedAudioDiagnosisReason r12 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonCaptureDeviceNotStart", 11, -2011);
        AudioDiagnosisReasonCaptureDeviceNotStart = r12;
        ILiveWrappedAudioDiagnosisReason r13 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonLowCaptureVolume", 12, -2013);
        AudioDiagnosisReasonLowCaptureVolume = r13;
        ILiveWrappedAudioDiagnosisReason r14 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonCaptureFrameRateError", 13, -2015);
        AudioDiagnosisReasonCaptureFrameRateError = r14;
        ILiveWrappedAudioDiagnosisReason r15 = new ILiveWrappedAudioDiagnosisReason("AudioDiagnosisReasonPlaybackFrameRateError", 14, -2016);
        AudioDiagnosisReasonPlaybackFrameRateError = r15;
        a = new ILiveWrappedAudioDiagnosisReason[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15};
    }

    public final int value() {
        return this.value;
    }

    public ILiveWrappedAudioDiagnosisReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

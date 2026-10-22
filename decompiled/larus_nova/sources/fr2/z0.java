package fr2;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedAudioDiagnosisReason;

/* JADX INFO: loaded from: classes11.dex */
public final class z0 implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z0 f478564b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z0 f478565c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final z0 f478566d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final z0 f478567e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final z0 f478568f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final z0 f478569g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final z0 f478570h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final z0 f478571i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final z0 f478572j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final z0 f478573k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final z0 f478574l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final z0 f478575m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final z0 f478576n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final z0 f478577o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final z0 f478578p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILiveWrappedAudioDiagnosisReason f478579a;

    public static final class a {
    }

    static {
        f478564b = new z0(ILiveWrappedAudioDiagnosisReason.AudioDiagnosisReasonNoAbnormality);
        f478565c = new z0(ILiveWrappedAudioDiagnosisReason.AudioDiagnosisReasonCaptureMutedData);
        f478566d = new z0(ILiveWrappedAudioDiagnosisReason.AudioDiagnosisReasonCaptureFrameRateZero);
        f478567e = new z0(ILiveWrappedAudioDiagnosisReason.AudioDiagnosisReasonPlaybackFrameRateZero);
        f478568f = new z0(ILiveWrappedAudioDiagnosisReason.AudioDiagnosisReasonPermissionDenied);
        f478569g = new z0(ILiveWrappedAudioDiagnosisReason.AudioDiagnosisReasonAndroidDeviceOccupied);
        f478570h = new z0(ILiveWrappedAudioDiagnosisReason.AudioDiagnosisReasonSpeakerSystemMuted);
        f478571i = new z0(ILiveWrappedAudioDiagnosisReason.AudioDiagnosisReasonLowSpeakerSystemVolume);
        f478572j = new z0(ILiveWrappedAudioDiagnosisReason.AudioDiagnosisReasonLowCaptureLevel);
        f478573k = new z0(ILiveWrappedAudioDiagnosisReason.AudioDiagnosisReasonHighAecSuppression);
        f478574l = new z0(ILiveWrappedAudioDiagnosisReason.AudioDiagnosisReasonHighMediaPlayerLevel);
        f478575m = new z0(ILiveWrappedAudioDiagnosisReason.AudioDiagnosisReasonCaptureDeviceNotStart);
        f478576n = new z0(ILiveWrappedAudioDiagnosisReason.AudioDiagnosisReasonLowCaptureVolume);
        f478577o = new z0(ILiveWrappedAudioDiagnosisReason.AudioDiagnosisReasonCaptureFrameRateError);
        f478578p = new z0(ILiveWrappedAudioDiagnosisReason.AudioDiagnosisReasonPlaybackFrameRateError);
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f478579a;
    }

    public z0(ILiveWrappedAudioDiagnosisReason r100) {
        this.f478579a = r100;
    }
}

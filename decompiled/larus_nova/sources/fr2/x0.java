package fr2;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedAudioDiagnosisLevel;

/* JADX INFO: loaded from: classes11.dex */
public final class x0 implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x0 f478550b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x0 f478551c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x0 f478552d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILiveWrappedAudioDiagnosisLevel f478553a;

    public static final class a {
    }

    static {
        f478550b = new x0(ILiveWrappedAudioDiagnosisLevel.AudioDiagnosisLevelNormal);
        f478551c = new x0(ILiveWrappedAudioDiagnosisLevel.AudioDiagnosisLevelLow);
        f478552d = new x0(ILiveWrappedAudioDiagnosisLevel.AudioDiagnosisLevelHigh);
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f478553a;
    }

    public x0(ILiveWrappedAudioDiagnosisLevel r100) {
        this.f478553a = r100;
    }
}

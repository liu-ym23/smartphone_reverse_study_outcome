package com.bytedance.android.livesdk.live.extension.plugin.api.livepusher;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/livepusher/ILiveWrappedAudioDiagnosisLevel;", "", "", "value", "I", "AudioDiagnosisLevelNormal", "AudioDiagnosisLevelLow", "AudioDiagnosisLevelHigh", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ILiveWrappedAudioDiagnosisLevel extends Enum<ILiveWrappedAudioDiagnosisLevel> {
    public static final ILiveWrappedAudioDiagnosisLevel AudioDiagnosisLevelHigh = null;
    public static final ILiveWrappedAudioDiagnosisLevel AudioDiagnosisLevelLow = null;
    public static final ILiveWrappedAudioDiagnosisLevel AudioDiagnosisLevelNormal = null;
    public static final /* synthetic */ ILiveWrappedAudioDiagnosisLevel[] a = null;
    private final int value;

    static {
        ILiveWrappedAudioDiagnosisLevel r1 = new ILiveWrappedAudioDiagnosisLevel("AudioDiagnosisLevelNormal", 0, 0);
        AudioDiagnosisLevelNormal = r1;
        ILiveWrappedAudioDiagnosisLevel r2 = new ILiveWrappedAudioDiagnosisLevel("AudioDiagnosisLevelLow", 1, -1);
        AudioDiagnosisLevelLow = r2;
        ILiveWrappedAudioDiagnosisLevel r3 = new ILiveWrappedAudioDiagnosisLevel("AudioDiagnosisLevelHigh", 2, -2);
        AudioDiagnosisLevelHigh = r3;
        a = new ILiveWrappedAudioDiagnosisLevel[]{r1, r2, r3};
    }

    public static ILiveWrappedAudioDiagnosisLevel valueOf(String r1) {
        return (ILiveWrappedAudioDiagnosisLevel) a.a(ILiveWrappedAudioDiagnosisLevel.class, r1);
    }

    public static ILiveWrappedAudioDiagnosisLevel[] values() {
        return (ILiveWrappedAudioDiagnosisLevel[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public ILiveWrappedAudioDiagnosisLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

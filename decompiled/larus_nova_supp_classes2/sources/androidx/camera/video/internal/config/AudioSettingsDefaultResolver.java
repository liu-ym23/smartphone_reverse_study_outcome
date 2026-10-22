package androidx.camera.video.internal.config;

import android.util.Range;
import androidx.camera.core.Logger;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.core.util.Supplier;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class AudioSettingsDefaultResolver implements Supplier<AudioSettings> {
    private static final String TAG = "DefAudioResolver";
    private final AudioSpec mAudioSpec;

    public AudioSettings get() {
        int r0 = AudioConfigUtil.resolveAudioSource(this.mAudioSpec);
        int r1 = AudioConfigUtil.resolveAudioSourceFormat(this.mAudioSpec);
        int r2 = this.mAudioSpec.getChannelCount();
        if (r2 != (-1)) goto L5;
        Logger.d(TAG, "Using fallback AUDIO channel count: 1");
        r2 = 1;
    L6:
        Range<Integer> r3 = this.mAudioSpec.getSampleRate();
        if (AudioSpec.SAMPLE_RATE_RANGE_AUTO.equals(r3) == false) goto L9;
        Logger.d(TAG, "Using fallback AUDIO sample rate: 44100Hz");
        int r4 = 44100;
    L11:
        return AudioSettings.builder().setAudioSource(r0).setAudioFormat(r1).setChannelCount(r2).setSampleRate(r4).build();
    L9:
        r4 = AudioConfigUtil.selectSampleRateOrNearestSupported(r3, r2, r1, ((Integer) r3.getUpper()).intValue());
        Logger.d(TAG, "Using AUDIO sample rate resolved from AudioSpec: " + r4 + "Hz");
        goto L11
    L5:
        Logger.d(TAG, "Using supplied AUDIO channel count: " + r2);
        goto L6
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m78get() {
        return get();
    }

    public AudioSettingsDefaultResolver(AudioSpec r1) {
        this.mAudioSpec = r1;
    }
}

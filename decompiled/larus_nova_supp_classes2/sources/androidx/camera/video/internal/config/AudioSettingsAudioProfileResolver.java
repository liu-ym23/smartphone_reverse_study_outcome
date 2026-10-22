package androidx.camera.video.internal.config;

import android.util.Range;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.core.util.Supplier;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class AudioSettingsAudioProfileResolver implements Supplier<AudioSettings> {
    private static final String TAG = "AudioSrcAdPrflRslvr";
    private final EncoderProfilesProxy.AudioProfileProxy mAudioProfile;
    private final AudioSpec mAudioSpec;

    public AudioSettings get() {
        int r0 = AudioConfigUtil.resolveAudioSource(this.mAudioSpec);
        int r1 = AudioConfigUtil.resolveAudioSourceFormat(this.mAudioSpec);
        int r2 = this.mAudioSpec.getChannelCount();
        Range<Integer> r3 = this.mAudioSpec.getSampleRate();
        int r4 = this.mAudioProfile.getChannels();
        if (r2 != (-1)) goto L5;
        Logger.d(TAG, "Resolved AUDIO channel count from AudioProfile: " + r4);
        r2 = r4;
    L6:
        int r5 = this.mAudioProfile.getSampleRate();
        int r6 = AudioConfigUtil.selectSampleRateOrNearestSupported(r3, r2, r1, r5);
        Logger.d(TAG, "Using resolved AUDIO sample rate or nearest supported from AudioProfile: " + r6 + "Hz. [AudioProfile sample rate: " + r5 + "Hz]");
        return AudioSettings.builder().setAudioSource(r0).setAudioFormat(r1).setChannelCount(r2).setSampleRate(r6).build();
    L5:
        Logger.d(TAG, "Media spec AUDIO channel count overrides AudioProfile [AudioProfile channel count: " + r4 + ", Resolved Channel Count: " + r2 + "]");
        goto L6
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m77get() {
        return get();
    }

    public AudioSettingsAudioProfileResolver(AudioSpec r1, EncoderProfilesProxy.AudioProfileProxy r2) {
        this.mAudioSpec = r1;
        this.mAudioProfile = r2;
    }
}

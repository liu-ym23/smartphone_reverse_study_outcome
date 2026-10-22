package com.ss.android.vesdk.jni;

import com.ss.android.vesdk.filterparam.VEAudioDspFilterParam;
import com.ss.android.vesdk.filterparam.VEAudioEffectFilterParam;
import com.ss.android.vesdk.filterparam.VEAudioFadeFilterParam;
import com.ss.android.vesdk.filterparam.VEAudioLoudnessBalanceFilter;
import com.ss.android.vesdk.filterparam.VEAudioMetricsFilterParam;
import com.ss.android.vesdk.filterparam.VEAudioNoiseFilterParam;
import com.ss.android.vesdk.filterparam.VEAudioSamiFilterParam;
import com.ss.android.vesdk.filterparam.VEAudioVolumeFilterParam;
import com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam;
import com.ss.android.vesdk.filterparam.VEBaseFilterParam;

/* JADX INFO: loaded from: classes40.dex */
public class TEAudioEffectInterface {
    private long mNative;

    private native int nativeUpdateAudioDspFilterParam(long r100, int r101, int r102, VEAudioDspFilterParam r103);

    private native int nativeUpdateAudioEffectFilterParam(long r100, int r101, int r102, VEAudioEffectFilterParam r103);

    private native int nativeUpdateAudioFadeFilterParam(long r100, int r101, int r102, VEAudioFadeFilterParam r103);

    private native int nativeUpdateAudioLoudnessBalanceFilterParam(long r100, int r101, int r102, VEAudioLoudnessBalanceFilter r103);

    private native int nativeUpdateAudioMetricsFilterParam(long r100, int r101, int r102, VEAudioMetricsFilterParam r103);

    private native int nativeUpdateAudioNoiseFilterParam(long r100, int r101, int r102, VEAudioNoiseFilterParam r103);

    private native int nativeUpdateAudioSamiFilterParam(long r100, int r101, int r102, VEAudioSamiFilterParam r103);

    private native int nativeUpdateAudioVolumeFilterParam(long r100, int r101, int r102, VEAudioVolumeFilterParam r103);

    public void clearNative() {
        this.mNative = 0;
    }

    public TEAudioEffectInterface(long r100) {
        this.mNative = r100;
    }

    public int updateAudioFilterParam(int r100, int r101, VEBaseFilterParam r110) {
        if (this.mNative != 0) goto L7;
        return -112;
    L7:
        if (r110.filterName.equals(VEBaseAudioFilterParam.AUDIO_VOLUME_FILTER_NAME) == false) goto L11;
        return nativeUpdateAudioVolumeFilterParam(this.mNative, r100, r101, (VEAudioVolumeFilterParam) r110);
    L11:
        if (r110.filterName.equals(VEBaseAudioFilterParam.AUDIO_FADING_TRANSITION_NAME) == false) goto L15;
        return nativeUpdateAudioFadeFilterParam(this.mNative, r100, r101, (VEAudioFadeFilterParam) r110);
    L15:
        if (r110.filterName.equals(VEBaseAudioFilterParam.AUDIO_EFFECT_FILTER_NAME) == false) goto L19;
        return nativeUpdateAudioEffectFilterParam(this.mNative, r100, r101, (VEAudioEffectFilterParam) r110);
    L19:
        if (r110.filterName.equals(VEBaseAudioFilterParam.AUDIO_NOISE_FILTER_NAME) == false) goto L23;
        return nativeUpdateAudioNoiseFilterParam(this.mNative, r100, r101, (VEAudioNoiseFilterParam) r110);
    L23:
        if (r110.filterName.equals(VEBaseAudioFilterParam.AUDIO_LOUDNESS_BALANCE_NAME) == false) goto L27;
        return nativeUpdateAudioLoudnessBalanceFilterParam(this.mNative, r100, r101, (VEAudioLoudnessBalanceFilter) r110);
    L27:
        if (r110.filterName.equals(VEBaseAudioFilterParam.AUDIO_DSP_FILTER_NAME) == false) goto L31;
        return nativeUpdateAudioDspFilterParam(this.mNative, r100, r101, (VEAudioDspFilterParam) r110);
    L31:
        if (r110.filterName.equals(VEAudioSamiFilterParam.AUDIO_SAMI_FILTER_NAME) == false) goto L35;
        return nativeUpdateAudioSamiFilterParam(this.mNative, r100, r101, (VEAudioSamiFilterParam) r110);
    L35:
        if (r110.filterName.equals(VEAudioMetricsFilterParam.AUDIO_METRICS_FILTER_NAME) == true) goto L37;
        return -1;
    L37:
        return nativeUpdateAudioMetricsFilterParam(this.mNative, r100, r101, (VEAudioMetricsFilterParam) r110);
    }
}

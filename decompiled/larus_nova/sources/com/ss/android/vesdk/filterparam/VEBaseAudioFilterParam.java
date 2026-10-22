package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VEBaseAudioFilterParam extends VEBaseFilterParam {
    public static final String AUDIO_ACOUSTIC_ECHO_CANCELLATION_NAME = "audio acoustic echo cancellation filter";
    public static final String AUDIO_DSP_FILTER_NAME = "audio dsp filter";
    public static final String AUDIO_EFFECT_FILTER_NAME = "audio effect";
    public static final String AUDIO_FADING_TRANSITION_NAME = "audio fading";
    public static final String AUDIO_LOUDNESS_BALANCE_NAME = "loudness balance";
    public static final String AUDIO_NOISE_FILTER_NAME = "audio noise";
    public static final String AUDIO_SPEED_FILTER_NAME = "audio speed filter";
    public static final String AUDIO_VOLUME_FILTER_NAME = "audio volume filter";

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public String toString() {
        return "VEBaseAudioFilterParam{filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VEBaseAudioFilterParam() {
        this.filterName = "audio filter";
        this.filterType = 1;
        this.filterDurationType = 1;
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setString("FilterName", this.filterName);
        return r100;
    }

    public VEBaseAudioFilterParam(Parcel r100) {
        super(r100);
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
    }
}

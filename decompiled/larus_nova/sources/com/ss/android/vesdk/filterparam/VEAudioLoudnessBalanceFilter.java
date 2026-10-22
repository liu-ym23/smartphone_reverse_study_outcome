package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes40.dex */
public class VEAudioLoudnessBalanceFilter extends VEBaseAudioFilterParam {
    public static final Parcelable.Creator<VEAudioLoudnessBalanceFilter> CREATOR = null;
    public double avgLoudness;
    public boolean enable;
    public boolean isBGM;
    public boolean isOnLine;
    public double peakLoudness;
    public double targetLoudness;

    public class a implements Parcelable.Creator<VEAudioLoudnessBalanceFilter> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioLoudnessBalanceFilter createFromParcel(Parcel r100) {
            return new VEAudioLoudnessBalanceFilter(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioLoudnessBalanceFilter[] newArray(int r100) {
            return new VEAudioLoudnessBalanceFilter[r100];
        }
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam, com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam, com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public String toString() {
        return "VEAudioLoudnessBalanceFilter{avgLoudness: " + this.avgLoudness + ", peakLoudness: " + this.peakLoudness + ", targetLoudness: '" + this.targetLoudness + ", filterName: '" + this.filterName + ", filterType: '" + this.filterType + ", filterDurationType=" + this.filterDurationType + '}';
    }

    public VEAudioLoudnessBalanceFilter() {
        this.avgLoudness = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.peakLoudness = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.targetLoudness = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.enable = false;
        this.isOnLine = true;
        this.isBGM = false;
        this.filterName = VEBaseAudioFilterParam.AUDIO_LOUDNESS_BALANCE_NAME;
    }

    public VEAudioLoudnessBalanceFilter(Parcel r100) {
        super(r100);
        this.avgLoudness = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.peakLoudness = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.targetLoudness = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.enable = false;
        this.isOnLine = true;
        this.isBGM = false;
        this.avgLoudness = r100.readDouble();
        this.peakLoudness = r100.readDouble();
        this.targetLoudness = r100.readDouble();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam, com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeDouble(this.avgLoudness);
        r100.writeDouble(this.peakLoudness);
        r100.writeDouble(this.targetLoudness);
    }
}

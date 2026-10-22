package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEAudioNoiseFilterParam extends VEBaseAudioFilterParam {
    public static final Parcelable.Creator<VEAudioNoiseFilterParam> CREATOR = null;
    public boolean enable;
    public String modelPath;
    public float noiseMode;

    public class a implements Parcelable.Creator<VEAudioNoiseFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioNoiseFilterParam createFromParcel(Parcel r100) {
            return new VEAudioNoiseFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioNoiseFilterParam[] newArray(int r100) {
            return new VEAudioNoiseFilterParam[r100];
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
        return "VEAudioNoiseFilterParam{filterType=" + this.filterType + ", filterName='" + this.filterName + ", filterDurationType=" + this.filterDurationType + ", noiseMode=" + this.noiseMode + ", modelPath=" + this.modelPath + '}';
    }

    public VEAudioNoiseFilterParam() {
        this.noiseMode = 0.0f;
        this.enable = false;
        this.filterName = VEBaseAudioFilterParam.AUDIO_NOISE_FILTER_NAME;
    }

    public VEAudioNoiseFilterParam(Parcel r100) {
        super(r100);
        this.noiseMode = 0.0f;
        this.enable = false;
        this.noiseMode = r100.readFloat();
        this.modelPath = r100.readString();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam, com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeFloat(this.noiseMode);
        r100.writeString(this.modelPath);
    }
}

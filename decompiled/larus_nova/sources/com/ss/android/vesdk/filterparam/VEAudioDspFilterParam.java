package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEAudioDspFilterParam extends VEBaseAudioFilterParam {
    public static final Parcelable.Creator<VEAudioDspFilterParam> CREATOR = null;
    private static final String DSP_INBUILT_JSON = "audio dsp use inbuilt json";
    public String jsonDir;

    public class a implements Parcelable.Creator<VEAudioDspFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioDspFilterParam createFromParcel(Parcel r100) {
            return new VEAudioDspFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioDspFilterParam[] newArray(int r100) {
            return new VEAudioDspFilterParam[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam, com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public String toString() {
        return "VEAudioDspFilterParam{jsonPath='" + this.jsonDir + "'}";
    }

    public VEAudioDspFilterParam() {
        this.filterName = VEBaseAudioFilterParam.AUDIO_DSP_FILTER_NAME;
        this.jsonDir = DSP_INBUILT_JSON;
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam, com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public int describeContents() {
        return super.describeContents();
    }

    public VEAudioDspFilterParam(Parcel r100) {
        super(r100);
        this.jsonDir = r100.readString();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam, com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.jsonDir);
    }
}

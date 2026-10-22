package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEAudioMetricsFilterParam extends VEBaseAudioFilterParam {
    public static final String AUDIO_METRICS_FILTER_NAME = "audio metrics filter";
    public static final Parcelable.Creator<VEAudioMetricsFilterParam> CREATOR = null;
    public String samiModelPath;
    public String samiParam;

    public class a implements Parcelable.Creator<VEAudioMetricsFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioMetricsFilterParam createFromParcel(Parcel r100) {
            return new VEAudioMetricsFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioMetricsFilterParam[] newArray(int r100) {
            return new VEAudioMetricsFilterParam[r100];
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
        return "VEAudioSamiFilterParam{filterType=" + this.filterType + ", filterName='" + this.filterName + ", filterDurationType=" + this.filterDurationType + ", samiModelPath=" + this.samiModelPath + ", samiParam=" + this.samiParam + '}';
    }

    public VEAudioMetricsFilterParam() {
        this.filterName = AUDIO_METRICS_FILTER_NAME;
        this.samiModelPath = "";
        this.samiParam = "";
    }

    public VEAudioMetricsFilterParam(Parcel r100) {
        super(r100);
        this.samiModelPath = r100.readString();
        this.samiParam = r100.readString();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam, com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.samiModelPath);
        r100.writeString(this.samiParam);
    }
}

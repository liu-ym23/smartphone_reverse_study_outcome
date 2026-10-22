package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEAudioVolumeFilterParam extends VEBaseAudioFilterParam {
    public static final Parcelable.Creator<VEAudioVolumeFilterParam> CREATOR = null;
    public float volume;

    public class a implements Parcelable.Creator<VEAudioVolumeFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioVolumeFilterParam createFromParcel(Parcel r100) {
            return new VEAudioVolumeFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioVolumeFilterParam[] newArray(int r100) {
            return new VEAudioVolumeFilterParam[r100];
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
        return "VEAudioVolumeFilterParam{volume=" + this.volume + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VEAudioVolumeFilterParam() {
        this.filterName = VEBaseAudioFilterParam.AUDIO_VOLUME_FILTER_NAME;
    }

    public VEAudioVolumeFilterParam(Parcel r100) {
        super(r100);
        this.volume = r100.readFloat();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam, com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeFloat(this.volume);
    }
}

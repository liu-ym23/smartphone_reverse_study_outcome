package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEAudioSpeedFilterParam extends VEBaseAudioFilterParam {
    public static final Parcelable.Creator<VEAudioSpeedFilterParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f455776a;

    public class a implements Parcelable.Creator<VEAudioSpeedFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioSpeedFilterParam createFromParcel(Parcel r100) {
            return new VEAudioSpeedFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioSpeedFilterParam[] newArray(int r100) {
            return new VEAudioSpeedFilterParam[r100];
        }
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam, com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam, com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public final String toString() {
        return "VEAudioSpeedFilterParam {speed=" + this.f455776a + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VEAudioSpeedFilterParam() {
        this.filterName = VEBaseAudioFilterParam.AUDIO_SPEED_FILTER_NAME;
    }

    public VEAudioSpeedFilterParam(Parcel r100) {
        super(r100);
        this.f455776a = r100.readFloat();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam, com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeFloat(this.f455776a);
    }
}

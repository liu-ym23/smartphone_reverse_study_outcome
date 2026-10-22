package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEAudioFadeFilterParam extends VEBaseAudioFilterParam {
    public static final Parcelable.Creator<VEAudioFadeFilterParam> CREATOR = null;
    public int fadeInLength;
    public int fadeOutLength;

    public class a implements Parcelable.Creator<VEAudioFadeFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioFadeFilterParam createFromParcel(Parcel r100) {
            return new VEAudioFadeFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioFadeFilterParam[] newArray(int r100) {
            return new VEAudioFadeFilterParam[r100];
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
        return "VEAudioFadeFilterParam{fadeInLength=" + this.fadeInLength + ", fadeOutLength=" + this.fadeOutLength + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VEAudioFadeFilterParam() {
        this.filterName = VEBaseAudioFilterParam.AUDIO_FADING_TRANSITION_NAME;
    }

    public VEAudioFadeFilterParam(Parcel r100) {
        super(r100);
        this.fadeInLength = r100.readInt();
        this.fadeOutLength = r100.readInt();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam, com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.fadeInLength);
        r100.writeInt(this.fadeOutLength);
    }
}

package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.vesdk.VEAudioEffectBean;

/* JADX INFO: loaded from: classes40.dex */
public class VEAudioEffectFilterParam extends VEBaseAudioFilterParam {
    public static final Parcelable.Creator<VEAudioEffectFilterParam> CREATOR = null;
    public VEAudioEffectBean audioEffectBean;

    public class a implements Parcelable.Creator<VEAudioEffectFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioEffectFilterParam createFromParcel(Parcel r100) {
            return new VEAudioEffectFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioEffectFilterParam[] newArray(int r100) {
            return new VEAudioEffectFilterParam[r100];
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
        return "VEAudioEffectFilterParam{audioEffectBean=" + this.audioEffectBean + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VEAudioEffectFilterParam() {
        this.filterName = VEBaseAudioFilterParam.AUDIO_EFFECT_FILTER_NAME;
    }

    public VEAudioEffectFilterParam(Parcel r100) {
        super(r100);
        this.audioEffectBean = (VEAudioEffectBean) r100.readParcelable(VEAudioEffectBean.class.getClassLoader());
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam, com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeParcelable(this.audioEffectBean, r101);
    }
}

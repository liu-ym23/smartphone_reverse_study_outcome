package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEAudioSamiFilterParam extends VEBaseAudioFilterParam {
    public static final String AUDIO_SAMI_FILTER_NAME = "audio sami filter";
    public static final Parcelable.Creator<VEAudioSamiFilterParam> CREATOR = null;
    public boolean enable;
    public String samiModelPath;
    public String samiParam;
    public int samiType;

    public class a implements Parcelable.Creator<VEAudioSamiFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioSamiFilterParam createFromParcel(Parcel r100) {
            return new VEAudioSamiFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioSamiFilterParam[] newArray(int r100) {
            return new VEAudioSamiFilterParam[r100];
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
        return "VEAudioSamiFilterParam{filterType=" + this.filterType + ", filterName='" + this.filterName + ", filterDurationType=" + this.filterDurationType + ", samiModelPath=" + this.samiModelPath + ", samiType=" + this.samiType + ", samiParam=" + this.samiParam + ", enable=" + this.enable + '}';
    }

    public VEAudioSamiFilterParam() {
        this.enable = true;
        this.filterName = AUDIO_SAMI_FILTER_NAME;
        this.samiType = 0;
        this.samiModelPath = "";
        this.samiParam = "";
    }

    public VEAudioSamiFilterParam(Parcel r100) {
        super(r100);
        boolean r101 = true;
        this.enable = true;
        this.samiModelPath = r100.readString();
        this.samiType = r100.readInt();
        this.samiParam = r100.readString();
        if (r100.readByte() != 0) goto L6;
        r101 = false;
    L6:
        this.enable = r101;
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseAudioFilterParam, com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.samiModelPath);
        r100.writeInt(this.samiType);
        r100.writeString(this.samiParam);
        r100.writeByte(this.enable ? 1 : 0);
    }
}

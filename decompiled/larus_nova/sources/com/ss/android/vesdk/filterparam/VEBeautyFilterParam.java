package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEBeautyFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEBeautyFilterParam> CREATOR = null;
    public String beautyName;
    public int beautyType;
    public float brightenIntensity;
    public float sharpIntensity;
    public float skinToneIntensity;
    public String skinTonePath;
    public float smoothIntensity;

    public class a implements Parcelable.Creator<VEBeautyFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEBeautyFilterParam createFromParcel(Parcel r100) {
            return new VEBeautyFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEBeautyFilterParam[] newArray(int r100) {
            return new VEBeautyFilterParam[r100];
        }
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public String toString() {
        return "VEBeautyFilterParam{beautyName='" + this.beautyName + "', beautyType=" + this.beautyType + ", brightenIntensity=" + this.brightenIntensity + ", smoothIntensity=" + this.smoothIntensity + ", sharpIntensity=" + this.sharpIntensity + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + ", skinTonePath='" + this.skinTonePath + "', skinToneIntensity=" + this.skinToneIntensity + '}';
    }

    public VEBeautyFilterParam() {
        this.filterName = "beauty";
        this.filterType = 12;
        this.filterDurationType = 1;
        this.beautyName = "";
        this.beautyType = -1;
        this.brightenIntensity = 0.0f;
        this.smoothIntensity = 0.0f;
        this.sharpIntensity = 0.0f;
        this.skinTonePath = "";
        this.skinToneIntensity = 0.0f;
    }

    public VEBeautyFilterParam(Parcel r100) {
        super(r100);
        this.beautyName = r100.readString();
        this.beautyType = r100.readInt();
        this.brightenIntensity = r100.readFloat();
        this.smoothIntensity = r100.readFloat();
        this.sharpIntensity = r100.readFloat();
        this.skinTonePath = r100.readString();
        this.skinToneIntensity = r100.readFloat();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.beautyName);
        r100.writeInt(this.beautyType);
        r100.writeFloat(this.brightenIntensity);
        r100.writeFloat(this.smoothIntensity);
        r100.writeFloat(this.sharpIntensity);
        r100.writeString(this.skinTonePath);
        r100.writeFloat(this.skinToneIntensity);
    }
}

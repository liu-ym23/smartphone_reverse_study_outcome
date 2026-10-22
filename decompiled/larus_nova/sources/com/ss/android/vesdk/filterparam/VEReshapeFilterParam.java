package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEReshapeFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEReshapeFilterParam> CREATOR = null;
    public float cheekIntensity;
    public float eyeIntensity;
    public String resPath;

    public class a implements Parcelable.Creator<VEReshapeFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEReshapeFilterParam createFromParcel(Parcel r100) {
            return new VEReshapeFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEReshapeFilterParam[] newArray(int r100) {
            return new VEReshapeFilterParam[r100];
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
        return "VEReshapeFilterParam{resPath='" + this.resPath + "', eyeIntensity=" + this.eyeIntensity + ", cheekIntensity=" + this.cheekIntensity + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VEReshapeFilterParam() {
        this.filterName = "reshape filter";
        this.filterType = 13;
        this.filterDurationType = 1;
        this.resPath = "";
        this.eyeIntensity = 0.0f;
        this.cheekIntensity = 0.0f;
    }

    public VEReshapeFilterParam(Parcel r100) {
        super(r100);
        this.resPath = r100.readString();
        this.eyeIntensity = r100.readFloat();
        this.cheekIntensity = r100.readFloat();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.resPath);
        r100.writeFloat(this.eyeIntensity);
        r100.writeFloat(this.cheekIntensity);
    }
}

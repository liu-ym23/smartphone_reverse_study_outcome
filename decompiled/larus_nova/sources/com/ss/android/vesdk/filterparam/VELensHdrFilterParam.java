package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VELensHdrFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VELensHdrFilterParam> CREATOR = null;
    public String filterPath;
    public float intensity;

    public class a implements Parcelable.Creator<VELensHdrFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VELensHdrFilterParam createFromParcel(Parcel r100) {
            return new VELensHdrFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VELensHdrFilterParam[] newArray(int r100) {
            return new VELensHdrFilterParam[r100];
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
        return "VELensHdrFilterParam{filterPath='" + this.filterPath + "', intensity=" + this.intensity + ", filterDurationType=" + this.filterDurationType + '}';
    }

    public VELensHdrFilterParam() {
        this.filterName = "lens hdr filter";
        this.filterType = 33;
        this.filterDurationType = 0;
        this.filterPath = "";
        this.intensity = 1.0f;
    }

    public VELensHdrFilterParam(Parcel r100) {
        super(r100);
        this.filterPath = r100.readString();
        this.intensity = r100.readFloat();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.filterPath);
        r100.writeFloat(this.intensity);
    }
}

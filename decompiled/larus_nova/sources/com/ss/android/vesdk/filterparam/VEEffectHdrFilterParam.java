package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEEffectHdrFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEEffectHdrFilterParam> CREATOR = null;
    public String filterPath;
    public int hdrType;
    public float intensity;

    public class a implements Parcelable.Creator<VEEffectHdrFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEEffectHdrFilterParam createFromParcel(Parcel r100) {
            return new VEEffectHdrFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEEffectHdrFilterParam[] newArray(int r100) {
            return new VEEffectHdrFilterParam[r100];
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
        return "VEEffectHdrFilterParam{filterPath='" + this.filterPath + "', hdrType=" + this.hdrType + ", intensity=" + this.intensity + ", filterDurationType=" + this.filterDurationType + '}';
    }

    public VEEffectHdrFilterParam() {
        this.filterName = "effect hdr filter";
        this.filterType = 16;
        this.filterDurationType = 0;
        this.filterPath = "";
        this.hdrType = 1;
        this.intensity = 1.0f;
    }

    public VEEffectHdrFilterParam(Parcel r100) {
        super(r100);
        this.filterPath = r100.readString();
        this.hdrType = r100.readInt();
        this.intensity = r100.readFloat();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.filterPath);
        r100.writeInt(this.hdrType);
        r100.writeFloat(this.intensity);
    }
}

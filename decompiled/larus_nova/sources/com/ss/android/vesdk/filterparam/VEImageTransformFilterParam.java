package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEImageTransformFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEImageTransformFilterParam> CREATOR = null;
    public float beginScale;
    public float endScale;

    public class a implements Parcelable.Creator<VEImageTransformFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEImageTransformFilterParam createFromParcel(Parcel r100) {
            return new VEImageTransformFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEImageTransformFilterParam[] newArray(int r100) {
            return new VEImageTransformFilterParam[r100];
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
        return "VEImageTransformFilterParam{beginScale=" + this.beginScale + ", endScale=" + this.endScale + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VEImageTransformFilterParam() {
        this.filterName = "image transform filter";
        this.filterType = 20;
        this.beginScale = 1.0f;
        this.endScale = 1.0f;
    }

    public VEImageTransformFilterParam(Parcel r100) {
        super(r100);
        this.beginScale = r100.readFloat();
        this.endScale = r100.readFloat();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeFloat(this.beginScale);
        r100.writeFloat(this.endScale);
    }
}

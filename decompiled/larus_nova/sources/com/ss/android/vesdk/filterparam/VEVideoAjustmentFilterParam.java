package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes40.dex */
public class VEVideoAjustmentFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEVideoAjustmentFilterParam> CREATOR = null;
    public float[] ajustmentIntensity;
    public String[] ajustmentName;
    public int[] ajustmentType;

    public class a implements Parcelable.Creator<VEVideoAjustmentFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoAjustmentFilterParam createFromParcel(Parcel r100) {
            return new VEVideoAjustmentFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoAjustmentFilterParam[] newArray(int r100) {
            return new VEVideoAjustmentFilterParam[r100];
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
        return "VEVideoAjustmentFilterParam{ajustmentName=" + Arrays.toString(this.ajustmentName) + ", ajustmentType=" + Arrays.toString(this.ajustmentType) + ", ajustmentIntensity=" + Arrays.toString(this.ajustmentIntensity) + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VEVideoAjustmentFilterParam() {
        this.filterName = "quality filter";
        this.filterType = 17;
        this.filterDurationType = 1;
        this.ajustmentName = null;
        this.ajustmentType = null;
        this.ajustmentIntensity = null;
    }

    public VEVideoAjustmentFilterParam(Parcel r100) {
        super(r100);
        this.ajustmentName = r100.createStringArray();
        this.ajustmentType = r100.createIntArray();
        this.ajustmentIntensity = r100.createFloatArray();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeStringArray(this.ajustmentName);
        r100.writeIntArray(this.ajustmentType);
        r100.writeFloatArray(this.ajustmentIntensity);
    }
}

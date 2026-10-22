package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VEExposureFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEExposureFilterParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f455777a;

    public class a implements Parcelable.Creator<VEExposureFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEExposureFilterParam createFromParcel(Parcel r100) {
            return new VEExposureFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEExposureFilterParam[] newArray(int r100) {
            return new VEExposureFilterParam[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public final String toString() {
        return "VEExposureFilterParam{exposure=" + this.f455777a + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VEExposureFilterParam() {
        this.f455777a = 0.0f;
        this.filterName = "exposure filter";
        this.filterType = 39;
        this.filterDurationType = 1;
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public final int describeContents() {
        return super.describeContents();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public final TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setFloat("exposure", this.f455777a);
        return r100;
    }

    public VEExposureFilterParam(Parcel r100) {
        super(r100);
        this.f455777a = 0.0f;
        this.f455777a = r100.readFloat();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
    }
}

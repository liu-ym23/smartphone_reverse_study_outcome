package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VERoundFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VERoundFilterParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f455815a;

    public class a implements Parcelable.Creator<VERoundFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VERoundFilterParam createFromParcel(Parcel r100) {
            return new VERoundFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VERoundFilterParam[] newArray(int r100) {
            return new VERoundFilterParam[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public final String toString() {
        return "VEBlurFilterParam{radius=" + this.f455815a + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VERoundFilterParam() {
        this.f455815a = 0.5f;
        this.filterName = "round filter";
        this.filterType = 38;
        this.filterDurationType = 1;
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public final int describeContents() {
        return super.describeContents();
    }

    public VERoundFilterParam(Parcel r100) {
        super(r100);
        this.f455815a = 0.5f;
        this.f455815a = r100.readFloat();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
    }
}

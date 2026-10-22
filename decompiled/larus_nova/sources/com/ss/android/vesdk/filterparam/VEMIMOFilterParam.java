package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEMIMOFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEMIMOFilterParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f455805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f455806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f455807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f455808d;

    public class a implements Parcelable.Creator<VEMIMOFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEMIMOFilterParam createFromParcel(Parcel r100) {
            return new VEMIMOFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEMIMOFilterParam[] newArray(int r100) {
            return new VEMIMOFilterParam[r100];
        }
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public final String toString() {
        return "VEMIMOFilterParam{layoutWidth=" + this.f455805a + ", layoutHeight=" + this.f455806b + ", camOutWidth=" + this.f455807c + ", camOutHeight=" + this.f455808d + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VEMIMOFilterParam() {
        this.filterName = "ve_mimo";
        this.filterType = 37;
        this.filterDurationType = 1;
    }

    public VEMIMOFilterParam(Parcel r100) {
        super(r100);
        this.f455805a = r100.readInt();
        this.f455806b = r100.readInt();
        this.f455807c = r100.readInt();
        this.f455808d = r100.readInt();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.f455805a);
        r100.writeInt(this.f455806b);
        r100.writeInt(this.f455807c);
        r100.writeInt(this.f455808d);
    }
}

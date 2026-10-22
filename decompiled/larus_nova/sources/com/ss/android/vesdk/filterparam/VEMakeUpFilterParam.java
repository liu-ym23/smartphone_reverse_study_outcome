package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEMakeUpFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEMakeUpFilterParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f455809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f455810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f455811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f455812d;

    public class a implements Parcelable.Creator<VEMakeUpFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEMakeUpFilterParam createFromParcel(Parcel r100) {
            return new VEMakeUpFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEMakeUpFilterParam[] newArray(int r100) {
            return new VEMakeUpFilterParam[r100];
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
        return "VEMakeUpFilterParam{resPath='" + this.f455809a + "', lipIntensity=" + this.f455810b + ", blusherIntensity=" + this.f455811c + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + ", maleMakeupState=" + this.f455812d + '}';
    }

    public VEMakeUpFilterParam() {
        this.filterName = "makeup filter";
        this.filterType = 26;
        this.filterDurationType = 1;
        this.f455809a = "";
        this.f455810b = -1.0f;
        this.f455811c = -1.0f;
        this.f455812d = false;
    }

    public VEMakeUpFilterParam(Parcel r100) {
        super(r100);
        this.f455809a = r100.readString();
        this.f455810b = r100.readFloat();
        this.f455811c = r100.readFloat();
        boolean r101 = true;
        if (1 == r100.readInt()) goto L6;
        r101 = false;
    L6:
        this.f455812d = r101;
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.f455809a);
        r100.writeFloat(this.f455810b);
        r100.writeFloat(this.f455811c);
        r100.writeInt(this.f455812d ? 1 : 0);
    }
}

package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEVideoEffectOutSizeFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEVideoEffectOutSizeFilterParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f455816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f455817b;

    public class a implements Parcelable.Creator<VEVideoEffectOutSizeFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoEffectOutSizeFilterParam createFromParcel(Parcel r100) {
            return new VEVideoEffectOutSizeFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoEffectOutSizeFilterParam[] newArray(int r100) {
            return new VEVideoEffectOutSizeFilterParam[r100];
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
        return "VEVideoEffectOutSizeFilterParam{width=" + this.f455816a + ", height=" + this.f455817b + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VEVideoEffectOutSizeFilterParam() {
        this.filterName = "effect output size";
        this.filterType = 30;
        this.filterDurationType = 1;
        this.f455816a = 0;
        this.f455817b = 0;
    }

    public VEVideoEffectOutSizeFilterParam(Parcel r100) {
        super(r100);
        this.f455816a = r100.readInt();
        this.f455817b = r100.readInt();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.f455816a);
        r100.writeInt(this.f455817b);
    }
}

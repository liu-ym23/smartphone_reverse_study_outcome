package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEVideoEffectStreamFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEVideoEffectStreamFilterParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f455818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f455819b;

    public class a implements Parcelable.Creator<VEVideoEffectStreamFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoEffectStreamFilterParam createFromParcel(Parcel r100) {
            return new VEVideoEffectStreamFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoEffectStreamFilterParam[] newArray(int r100) {
            return new VEVideoEffectStreamFilterParam[r100];
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
        return "VEVideoEffectStreamFilterParam{filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + ", streamFlags=" + this.f455818a + ", extraString=" + this.f455819b + '}';
    }

    public VEVideoEffectStreamFilterParam() {
        this.f455818a = 0;
        this.f455819b = null;
        this.filterName = "effect stream";
        this.filterType = 29;
        this.filterDurationType = 1;
    }

    public VEVideoEffectStreamFilterParam(Parcel r100) {
        super(r100);
        this.f455818a = 0;
        this.f455819b = null;
        this.f455818a = r100.readInt();
        this.f455819b = r100.readString();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        super.writeToParcel(r100, r101);
        r100.writeInt(this.f455818a);
        r100.writeString(this.f455819b);
    }
}

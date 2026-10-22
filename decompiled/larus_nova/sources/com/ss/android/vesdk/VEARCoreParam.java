package com.ss.android.vesdk;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEARCoreParam implements Parcelable {
    public static final Parcelable.Creator<VEARCoreParam> CREATOR = null;
    private boolean enableARCore;

    public class a implements Parcelable.Creator<VEARCoreParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEARCoreParam createFromParcel(Parcel r100) {
            return new VEARCoreParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEARCoreParam[] newArray(int r100) {
            return new VEARCoreParam[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public VEARCoreParam() {
        this.enableARCore = false;
    }

    public boolean isEnableARCore() {
        return this.enableARCore;
    }

    public VEARCoreParam(Parcel r100) {
        boolean r101 = false;
        this.enableARCore = false;
        if (r100.readByte() == 0) goto L5;
        r101 = true;
    L5:
        this.enableARCore = r101;
    }

    public void setEnableARCore(boolean r100) {
        this.enableARCore = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeByte(this.enableARCore ? 1 : 0);
    }
}

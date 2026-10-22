package com.ss.android.vesdk.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEPrePlayParams implements Parcelable {
    public static final Parcelable.Creator<VEPrePlayParams> CREATOR = null;
    public int duration;
    public boolean isLoop;
    public int stopStrategy;
    public int timeUnit;

    public class a implements Parcelable.Creator<VEPrePlayParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEPrePlayParams createFromParcel(Parcel r100) {
            return new VEPrePlayParams(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEPrePlayParams[] newArray(int r100) {
            return new VEPrePlayParams[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public VEPrePlayParams() {
        this.timeUnit = 0;
        this.stopStrategy = 0;
    }

    public VEPrePlayParams(Parcel r100) {
        boolean r101 = false;
        this.timeUnit = 0;
        this.stopStrategy = 0;
        this.duration = r100.readInt();
        if (r100.readByte() == 0) goto L5;
        r101 = true;
    L5:
        this.isLoop = r101;
        this.stopStrategy = r100.readInt();
    }

    public VEPrePlayParams(int r100, boolean r101) {
        this.timeUnit = 0;
        this.stopStrategy = 0;
        this.duration = r100;
        this.isLoop = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.duration);
        r100.writeByte(this.isLoop ? 1 : 0);
        r100.writeInt(this.stopStrategy);
    }

    public VEPrePlayParams(int r100, boolean r101, int r102) {
        this.timeUnit = 0;
        this.duration = r100;
        this.isLoop = r101;
        this.stopStrategy = r102;
    }
}

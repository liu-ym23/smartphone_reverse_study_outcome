package com.ss.android.vesdk.clipparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEClipTimelineParam implements Parcelable {
    public static final Parcelable.Creator<VEClipTimelineParam> CREATOR = null;
    public float[] curveSpeedPointX;
    public float[] curveSpeedPointY;
    public boolean isReverseCurveSpeed;
    public double speed;
    public int trimIn;
    public int trimOut;

    public class a implements Parcelable.Creator<VEClipTimelineParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEClipTimelineParam createFromParcel(Parcel r100) {
            return new VEClipTimelineParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEClipTimelineParam[] newArray(int r100) {
            return new VEClipTimelineParam[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "trimIn: " + this.trimIn + " trimOut: " + this.trimOut + " speed: " + this.speed;
    }

    public VEClipTimelineParam() {
        this.trimIn = 0;
        this.trimOut = 0;
        this.speed = 1.0d;
        this.isReverseCurveSpeed = false;
    }

    public VEClipTimelineParam(Parcel r100) {
        this.trimIn = r100.readInt();
        this.trimOut = r100.readInt();
        this.speed = r100.readDouble();
        this.curveSpeedPointX = r100.createFloatArray();
        this.curveSpeedPointY = r100.createFloatArray();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.isReverseCurveSpeed = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.trimIn);
        r100.writeInt(this.trimOut);
        r100.writeDouble(this.speed);
        r100.writeFloatArray(this.curveSpeedPointX);
        r100.writeFloatArray(this.curveSpeedPointY);
        r100.writeByte(this.isReverseCurveSpeed ? 1 : 0);
    }
}

package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VESlowMotionFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VESlowMotionFilterParam> CREATOR = null;
    public static final String SLOW_ATTR_DURATION = "timeEffect slow motion duration";
    public static final String SLOW_ATTR_FILTERSEQIN = "timeEffect seqin";
    public static final String SLOW_ATTR_FILTERSEQOUT = "timeEffect seqout";
    public static final String SLOW_ATTR_MODE = "timeEffect slow motion mode";
    public static final String SLOW_ATTR_SPEED = "timeEffect slow motion speed";
    public static final String SLOW_FILTER_NAME = "new slow effect";
    public int seqIn;
    public int seqOut;
    public int slowMotionDuration;
    public float slowMotionSpeed;
    public int timeMode;

    public class a implements Parcelable.Creator<VESlowMotionFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VESlowMotionFilterParam createFromParcel(Parcel r100) {
            return new VESlowMotionFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VESlowMotionFilterParam[] newArray(int r100) {
            return new VESlowMotionFilterParam[r100];
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
        return "VESlowMotionFilterParam{seqIn=" + this.seqIn + ", seqOut=" + this.seqOut + ", slowMotionDuration=" + this.slowMotionDuration + ", slowMotionSpeed=" + this.slowMotionSpeed + ", timeMode=" + this.timeMode + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VESlowMotionFilterParam() {
        this.filterName = SLOW_FILTER_NAME;
        this.filterType = 25;
        this.filterDurationType = 1;
        this.seqIn = -1;
        this.slowMotionDuration = 0;
        this.slowMotionSpeed = 1.0f;
        this.timeMode = 0;
    }

    public VESlowMotionFilterParam(Parcel r100) {
        super(r100);
        this.seqIn = r100.readInt();
        this.seqOut = r100.readInt();
        this.slowMotionDuration = r100.readInt();
        this.slowMotionSpeed = r100.readFloat();
        this.timeMode = r100.readInt();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.seqIn);
        r100.writeInt(this.seqOut);
        r100.writeInt(this.slowMotionDuration);
        r100.writeFloat(this.slowMotionSpeed);
        r100.writeInt(this.timeMode);
    }
}

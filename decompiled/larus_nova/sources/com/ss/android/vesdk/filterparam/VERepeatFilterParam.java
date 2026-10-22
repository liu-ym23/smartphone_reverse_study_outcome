package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VERepeatFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VERepeatFilterParam> CREATOR = null;
    public static final String REPEAT_ATTR_DURATION = "timeEffect repeating duration";
    public static final String REPEAT_ATTR_FILTERSEQIN = "timeEffect seqin";
    public static final String REPEAT_ATTR_FILTERSEQOUT = "timeEffect seqout";
    public static final String REPEAT_ATTR_MODE = "timeEffect repeating mode";
    public static final String REPEAT_ATTR_TIMES = "timeEffect repeating times";
    public static final String REPEAT_FILTER_NAME = "new repeat effect";
    public int repeatDuration;
    public int repeatTime;
    public int seqIn;
    public int seqOut;
    public int timeMode;

    public class a implements Parcelable.Creator<VERepeatFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VERepeatFilterParam createFromParcel(Parcel r100) {
            return new VERepeatFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VERepeatFilterParam[] newArray(int r100) {
            return new VERepeatFilterParam[r100];
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
        return "VERepeatFilterParam{seqIn=" + this.seqIn + ", seqOut=" + this.seqOut + ", repeatTime=" + this.repeatTime + ", repeatDuration=" + this.repeatDuration + ", timeMode=" + this.timeMode + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VERepeatFilterParam() {
        this.filterName = REPEAT_FILTER_NAME;
        this.filterType = 25;
        this.filterDurationType = 1;
        this.seqIn = -1;
        this.repeatTime = 0;
        this.repeatDuration = 0;
        this.timeMode = 0;
    }

    public VERepeatFilterParam(Parcel r100) {
        super(r100);
        this.seqIn = r100.readInt();
        this.seqOut = r100.readInt();
        this.repeatTime = r100.readInt();
        this.repeatDuration = r100.readInt();
        this.timeMode = r100.readInt();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.seqIn);
        r100.writeInt(this.seqOut);
        r100.writeInt(this.repeatTime);
        r100.writeInt(this.repeatDuration);
        r100.writeInt(this.timeMode);
    }
}

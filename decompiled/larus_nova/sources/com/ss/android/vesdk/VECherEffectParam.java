package com.ss.android.vesdk;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VECherEffectParam implements Parcelable {
    public static final Parcelable.Creator<VECherEffectParam> CREATOR = null;
    private double[] duration;
    private int length;
    private String[] matrix;
    private boolean[] segUseCher;
    private int totalNum;

    public class a implements Parcelable.Creator<VECherEffectParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VECherEffectParam createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            int r102 = r100.readInt();
            String[] r103 = new String[r101];
            r100.readStringArray(r103);
            double[] r104 = new double[r101 * 2];
            r100.readDoubleArray(r104);
            boolean[] r105 = new boolean[r102];
            r100.readBooleanArray(r105);
            return new VECherEffectParam(r103, r104, r105);
        }

        @Override // android.os.Parcelable.Creator
        public final VECherEffectParam[] newArray(int r100) {
            return new VECherEffectParam[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public double[] getDuration() {
        return this.duration;
    }

    public String[] getMatrix() {
        return this.matrix;
    }

    public boolean[] getSegUseCher() {
        return this.segUseCher;
    }

    public void setDuration(double[] r100) {
        this.duration = r100;
    }

    public void setMatrix(String[] r100) {
        this.matrix = r100;
    }

    public void setSegUseCher(boolean[] r100) {
        this.segUseCher = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.matrix.length);
        r100.writeInt(this.totalNum);
        r100.writeStringArray(this.matrix);
        r100.writeDoubleArray(this.duration);
        r100.writeBooleanArray(this.segUseCher);
    }

    public VECherEffectParam(String[] r100, double[] r101, boolean[] r102) {
        this(r100, r101, r100.length, r102);
    }

    private VECherEffectParam(String[] r100, double[] r101, int r102, boolean[] r103) {
        this.matrix = r100;
        this.duration = r101;
        this.length = r102;
        this.segUseCher = r103;
        this.totalNum = r103.length;
    }
}

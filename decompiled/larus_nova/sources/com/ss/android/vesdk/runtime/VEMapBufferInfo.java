package com.ss.android.vesdk.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes40.dex */
public class VEMapBufferInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<VEMapBufferInfo> CREATOR = null;
    private static final long serialVersionUID = 1;
    public double CMTime;
    public float[] clientVertexes;
    public int[] clientVertexesLength;
    public double firstTriggerTime;
    public double[] timestamp;
    public double totalTriggerTime;

    public class a implements Parcelable.Creator<VEMapBufferInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEMapBufferInfo createFromParcel(Parcel r100) {
            return new VEMapBufferInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEMapBufferInfo[] newArray(int r100) {
            return new VEMapBufferInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public VEMapBufferInfo() {
    }

    public VEMapBufferInfo(Parcel r100) {
        this.CMTime = r100.readDouble();
        this.firstTriggerTime = r100.readDouble();
        this.totalTriggerTime = r100.readDouble();
        this.timestamp = r100.createDoubleArray();
        this.clientVertexes = r100.createFloatArray();
        this.clientVertexesLength = r100.createIntArray();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeDouble(this.CMTime);
        r100.writeDouble(this.firstTriggerTime);
        r100.writeDouble(this.totalTriggerTime);
        r100.writeDoubleArray(this.timestamp);
        r100.writeFloatArray(this.clientVertexes);
        r100.writeIntArray(this.clientVertexesLength);
    }
}

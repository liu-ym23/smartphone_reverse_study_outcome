package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes6.dex */
public class SensorEventInfo implements Parcelable {
    public static final Parcelable.Creator<SensorEventInfo> CREATOR = null;
    private static final int VERSION = 3;
    private final int accuracy;
    private final long adspTimeStamp;
    private final String sensorName;
    private final int sensorType;
    private final long timestamp;
    private final float[] values;

    /* JADX INFO: loaded from: classes33.dex */
    public class a implements Parcelable.Creator<SensorEventInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SensorEventInfo createFromParcel(Parcel r100) {
            return new SensorEventInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SensorEventInfo[] newArray(int r100) {
            return new SensorEventInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersion() {
        return 3;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("[SensorEventInfo:3, timestamp: ");
        r100.append(this.timestamp);
        r100.append(", sensor: ");
        r100.append(this.sensorName);
        r100.append(", sensorType: ");
        r100.append(this.sensorType);
        r100.append(", values: (");
        StringJoiner r101 = new StringJoiner(", ");
        float[] r102 = this.values;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r101.add(String.valueOf(r102[r104]));
        r104 = r104 + 1;
        goto L3
    L5:
        r100.append(r101);
        r100.append("), accuracy: ");
        r100.append(this.accuracy);
        r100.append(", adspTimeStamp: ");
        r100.append(this.adspTimeStamp);
        r100.append("]");
        return r100.toString();
    }

    public int getAccuracy() {
        return this.accuracy;
    }

    public long getAdspTimeStamp() {
        return this.adspTimeStamp;
    }

    public String getSensorName() {
        return this.sensorName;
    }

    public int getSensorType() {
        return this.sensorType;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public float[] getValues() {
        return this.values;
    }

    public SensorEventInfo(Parcel r100) {
        this.sensorName = r100.readString();
        this.accuracy = r100.readInt();
        this.timestamp = r100.readLong();
        this.values = r100.createFloatArray();
        this.adspTimeStamp = r100.readLong();
        if (r100.dataAvail() <= 0) goto L5;
        int r101 = r100.readInt();
    L6:
        this.sensorType = r101;
        return;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.sensorName);
        r100.writeInt(this.accuracy);
        r100.writeLong(this.timestamp);
        r100.writeFloatArray(this.values);
        r100.writeLong(this.adspTimeStamp);
        r100.writeInt(this.sensorType);
    }

    public SensorEventInfo(String r100, int r101, int r102, long r103, float[] r104) {
        this.timestamp = System.currentTimeMillis();
        this.sensorName = r100;
        this.sensorType = r101;
        this.accuracy = r102;
        this.adspTimeStamp = r103;
        this.values = r104;
    }
}

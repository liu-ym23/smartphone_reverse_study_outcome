package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public class UnifiedDataPacket implements Parcelable {
    public static final Parcelable.Creator<UnifiedDataPacket> CREATOR = null;
    public static final int TYPE_BT = 2;
    public static final int TYPE_CELL = 3;
    public static final int TYPE_GNSS = 5;
    public static final int TYPE_LOCATION = 4;
    public static final int TYPE_SENSOR = 6;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WIFI = 1;
    private Parcelable data;
    private final int dataType;

    /* JADX INFO: loaded from: classes33.dex */
    public class a implements Parcelable.Creator<UnifiedDataPacket> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UnifiedDataPacket createFromParcel(Parcel r100) {
            return new UnifiedDataPacket(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final UnifiedDataPacket[] newArray(int r100) {
            return new UnifiedDataPacket[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public <T extends Parcelable> T getData() {
        return (T) this.data;
    }

    public int getDataType() {
        return this.dataType;
    }

    public UnifiedDataPacket(Parcel r100) {
        int r101 = r100.readInt();
        this.dataType = r101;
        switch(r101) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L17;
        };
    L5:
        this.data = r100.readParcelable(SensorEventInfo.class.getClassLoader());
        return;
    L6:
        this.data = r100.readParcelable(GnssSvAwareInfo.class.getClassLoader());
        return;
    L7:
        this.data = r100.readParcelable(LocationAwareInfo.class.getClassLoader());
        return;
    L8:
        this.data = r100.readParcelable(CellAwareInfo.class.getClassLoader());
        return;
    L9:
        this.data = r100.readParcelable(BtAwareInfo.class.getClassLoader());
        return;
    L10:
        this.data = r100.readParcelable(WifiStandardData.class.getClassLoader());
        return;
    }

    public UnifiedDataPacket(Parcelable r100) {
        this.data = r100;
        if ((r100 instanceof WifiStandardData) == false) goto L6;
        this.dataType = 1;
        return;
    L6:
        if ((r100 instanceof BtAwareInfo) == false) goto L9;
        this.dataType = 2;
        return;
    L9:
        if ((r100 instanceof CellAwareInfo) == false) goto L12;
        this.dataType = 3;
        return;
    L12:
        if ((r100 instanceof LocationAwareInfo) == false) goto L15;
        this.dataType = 4;
        return;
    L15:
        if ((r100 instanceof GnssSvAwareInfo) == false) goto L18;
        this.dataType = 5;
        return;
    L18:
        if ((r100 instanceof SensorEventInfo) == false) goto L20;
        this.dataType = 6;
        return;
    L20:
        this.dataType = 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.dataType);
        r100.writeParcelable(this.data, r101);
    }
}

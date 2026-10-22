package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public class HarLevel2DataReq implements Parcelable {
    public static final Parcelable.Creator<HarLevel2DataReq> CREATOR = null;
    public static final int TYPE_BT = 2;
    public static final int TYPE_CELL = 3;
    public static final int TYPE_LOCATION = 4;
    public static final int TYPE_SENSOR = 5;
    public static final int TYPE_WIFI = 1;
    private final int count;
    private final int interval;
    private final int requestType;
    private final int timeout;

    /* JADX INFO: loaded from: classes33.dex */
    public class a implements Parcelable.Creator<HarLevel2DataReq> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HarLevel2DataReq createFromParcel(Parcel r100) {
            return new HarLevel2DataReq(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final HarLevel2DataReq[] newArray(int r100) {
            return new HarLevel2DataReq[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public int getCount() {
        return this.count;
    }

    public int getInterval() {
        return this.interval;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public HarLevel2DataReq(Parcel r100) {
        this.requestType = r100.readInt();
        this.count = r100.readInt();
        this.interval = r100.readInt();
        this.timeout = r100.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.requestType);
        r100.writeInt(this.count);
        r100.writeInt(this.interval);
        r100.writeInt(this.timeout);
    }

    public HarLevel2DataReq(int r100, int r101, int r102, int r103) {
        this.requestType = r100;
        this.count = r101;
        this.interval = r102;
        this.timeout = r103;
    }
}

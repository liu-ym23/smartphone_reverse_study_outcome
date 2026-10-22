package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public class HarEventData implements Parcelable {
    public static final Parcelable.Creator<HarEventData> CREATOR = null;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_CAR = 8;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_CYCLING = 6;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_ELECTRIC_BIKE = 7;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_OTHER = 4;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_RUNNING = 1;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_STATIONARY = 0;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_SUBWAY = 5;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_WALKING = 2;
    private int mEvent;
    private long mTimestamp;

    /* JADX INFO: loaded from: classes33.dex */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f395939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f395940b;

        public Builder() {
        }

        public HarEventData build() {
            return new HarEventData(this.f395939a, this.f395940b);
        }

        public Builder setEvent(int r100) {
            this.f395939a = r100;
            return this;
        }

        public Builder setTimestamp(long r100) {
            this.f395940b = r100;
            return this;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public class a implements Parcelable.Creator<HarEventData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HarEventData createFromParcel(Parcel r100) {
            return new HarEventData(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final HarEventData[] newArray(int r100) {
            return new HarEventData[r100];
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
        return "HarEventData{event=" + this.mEvent + ", timestamp=" + this.mTimestamp + '}';
    }

    public HarEventData() {
    }

    public int getEvent() {
        return this.mEvent;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public HarEventData(Parcel r100) {
        this.mEvent = r100.readInt();
        this.mTimestamp = r100.readLong();
    }

    public void readFromParcel(Parcel r100) {
        this.mEvent = r100.readInt();
        this.mTimestamp = r100.readLong();
    }

    public HarEventData(HarEventData r100) {
        this.mEvent = r100.getEvent();
        this.mTimestamp = r100.getTimestamp();
    }

    public HarEventData(int r100, long r101) {
        this.mEvent = r100;
        this.mTimestamp = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.mEvent);
        r100.writeLong(this.mTimestamp);
    }
}

package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes33.dex */
public class QshHarEventData implements Parcelable {
    public static final int ACTIVITY_ALL = 7;
    public static final int ACTIVITY_BIKING = 6;
    public static final int ACTIVITY_DRIVING = 4;
    public static final int ACTIVITY_RUNNING = 3;
    public static final int ACTIVITY_STATIONARY = 1;
    public static final int ACTIVITY_TRANSIT = 5;
    public static final int ACTIVITY_UNKNOWN = 0;
    public static final int ACTIVITY_WALKING = 2;
    public static final Parcelable.Creator<QshHarEventData> CREATOR = null;
    public static final int EVENT_TYPE_ALL = 3;
    public static final int EVENT_TYPE_MOTION_OTHER = 2;
    public static final int EVENT_TYPE_MOTION_STATE = 1;
    private float mConfidence;
    private long mDurationMs;
    private int mEvent;
    private float mFrequency;
    private float mSpeed;
    private long mTimestamp;
    private int mTriggerReason;
    private float mValue;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f395954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f395955b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f395956c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f395957d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f395958e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f395959f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f395960g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f395961h;

        public Builder() {
        }

        public QshHarEventData build() {
            return new QshHarEventData(this.f395954a, this.f395955b, this.f395956c, this.f395957d, this.f395958e, this.f395959f, this.f395960g, this.f395961h);
        }

        public Builder setConfidence(float r100) {
            this.f395955b = r100;
            return this;
        }

        public Builder setDurationMs(long r100) {
            this.f395960g = r100;
            return this;
        }

        public Builder setEvent(int r100) {
            this.f395954a = r100;
            return this;
        }

        public Builder setFrequency(float r100) {
            this.f395959f = r100;
            return this;
        }

        public Builder setSpeed(float r100) {
            this.f395958e = r100;
            return this;
        }

        public Builder setTimestamp(long r100) {
            this.f395961h = r100;
            return this;
        }

        public Builder setTriggerReason(int r100) {
            this.f395957d = r100;
            return this;
        }

        public Builder setValue(float r100) {
            this.f395956c = r100;
            return this;
        }
    }

    public class a implements Parcelable.Creator<QshHarEventData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarEventData createFromParcel(Parcel r100) {
            return new QshHarEventData(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarEventData[] newArray(int r100) {
            return new QshHarEventData[r100];
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
        return "QshHarEventParcel[event=" + this.mEvent + ", confidence=" + this.mConfidence + ", value=" + this.mValue + ", triggerReason=" + this.mTriggerReason + ", speed=" + this.mSpeed + ", frequency=" + this.mFrequency + ", durationMs=" + this.mDurationMs + ", timestamp=" + this.mTimestamp + ']';
    }

    public QshHarEventData() {
    }

    public float getConfidence() {
        return this.mConfidence;
    }

    public long getDurationMs() {
        return this.mDurationMs;
    }

    public int getEvent() {
        return this.mEvent;
    }

    public float getFrequency() {
        return this.mFrequency;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public int getTriggerReason() {
        return this.mTriggerReason;
    }

    public float getValue() {
        return this.mValue;
    }

    public QshHarEventData(Parcel r100) {
        this.mEvent = r100.readInt();
        this.mConfidence = r100.readFloat();
        this.mValue = r100.readFloat();
        this.mTriggerReason = r100.readInt();
        this.mSpeed = r100.readFloat();
        this.mFrequency = r100.readFloat();
        this.mDurationMs = r100.readLong();
        this.mTimestamp = r100.readLong();
    }

    public void readFromParcel(Parcel r100) {
        this.mEvent = r100.readInt();
        this.mConfidence = r100.readFloat();
        this.mValue = r100.readFloat();
        this.mTriggerReason = r100.readInt();
        this.mSpeed = r100.readFloat();
        this.mFrequency = r100.readFloat();
        this.mDurationMs = r100.readLong();
        this.mTimestamp = r100.readLong();
    }

    public QshHarEventData(QshHarEventData r100) {
        this.mEvent = r100.getEvent();
        this.mConfidence = r100.getConfidence();
        this.mValue = r100.getValue();
        this.mTriggerReason = r100.getTriggerReason();
        this.mSpeed = r100.getSpeed();
        this.mFrequency = r100.getFrequency();
        this.mDurationMs = r100.getDurationMs();
        this.mTimestamp = r100.getTimestamp();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.mEvent);
        r100.writeFloat(this.mConfidence);
        r100.writeFloat(this.mValue);
        r100.writeInt(this.mTriggerReason);
        r100.writeFloat(this.mSpeed);
        r100.writeFloat(this.mFrequency);
        r100.writeLong(this.mDurationMs);
        r100.writeLong(this.mTimestamp);
    }

    public QshHarEventData(int r100, float r101, float r102, int r103, float r104, float r105, long r106, long r107) {
        this.mEvent = r100;
        this.mConfidence = r101;
        this.mValue = r102;
        this.mTriggerReason = r103;
        this.mSpeed = r104;
        this.mFrequency = r105;
        this.mDurationMs = r106;
        this.mTimestamp = r107;
    }
}

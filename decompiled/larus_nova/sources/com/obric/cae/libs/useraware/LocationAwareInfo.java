package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public class LocationAwareInfo implements Parcelable {
    public static final Parcelable.Creator<LocationAwareInfo> CREATOR = null;
    private static final int VERSION = 1;
    private float mAltitudeAccuracyMeters;
    private double mAltitudeMeters;
    private float mBearingAccuracyDegrees;
    private float mBearingDegrees;
    private float mHorizontalAccuracyMeters;
    private double mLatitudeDegrees;
    private double mLongitudeDegrees;
    private String mProvider;
    private float mSpeedAccuracyMetersPerSecond;
    private float mSpeedMetersPerSecond;
    private long mTimestamp;

    /* JADX INFO: loaded from: classes33.dex */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f395943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f395944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f395945c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public double f395946d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f395947e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public double f395948f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f395949g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f395950h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f395951i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f395952j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f395953k;

        public Builder() {
        }

        public LocationAwareInfo build() {
            return new LocationAwareInfo(this);
        }

        public static /* synthetic */ long a(Builder r100) {
            return r100.f395943a;
        }

        public static /* synthetic */ String b(Builder r100) {
            return r100.f395944b;
        }

        public static /* synthetic */ float c(Builder r100) {
            return r100.f395953k;
        }

        public static /* synthetic */ double d(Builder r100) {
            return r100.f395945c;
        }

        public static /* synthetic */ double e(Builder r100) {
            return r100.f395946d;
        }

        public static /* synthetic */ float f(Builder r100) {
            return r100.f395947e;
        }

        public static /* synthetic */ double g(Builder r100) {
            return r100.f395948f;
        }

        public static /* synthetic */ float h(Builder r100) {
            return r100.f395949g;
        }

        public static /* synthetic */ float i(Builder r100) {
            return r100.f395950h;
        }

        public static /* synthetic */ float j(Builder r100) {
            return r100.f395951i;
        }

        public static /* synthetic */ float k(Builder r100) {
            return r100.f395952j;
        }

        public Builder setAltitudeAccuracyMeters(float r100) {
            this.f395949g = r100;
            return this;
        }

        public Builder setAltitudeMeters(double r100) {
            this.f395948f = r100;
            return this;
        }

        public Builder setBearingAccuracyDegrees(float r100) {
            this.f395953k = r100;
            return this;
        }

        public Builder setBearingDegrees(float r100) {
            this.f395952j = r100;
            return this;
        }

        public Builder setHorizontalAccuracyMeters(float r100) {
            this.f395947e = r100;
            return this;
        }

        public Builder setLatitudeDegrees(double r100) {
            this.f395945c = r100;
            return this;
        }

        public Builder setLongitudeDegrees(double r100) {
            this.f395946d = r100;
            return this;
        }

        public Builder setProvider(String r100) {
            this.f395944b = r100;
            return this;
        }

        public Builder setSpeedAccuracyMetersPerSecond(float r100) {
            this.f395951i = r100;
            return this;
        }

        public Builder setSpeedMetersPerSecond(float r100) {
            this.f395950h = r100;
            return this;
        }

        public Builder setTimestamp(long r100) {
            this.f395943a = r100;
            return this;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public class a implements Parcelable.Creator<LocationAwareInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LocationAwareInfo createFromParcel(Parcel r100) {
            return new LocationAwareInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final LocationAwareInfo[] newArray(int r100) {
            return new LocationAwareInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersion() {
        return 1;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "LocationAwareInfo[1," + this.mTimestamp + "," + this.mProvider + "," + this.mLatitudeDegrees + "," + this.mLongitudeDegrees + "," + this.mHorizontalAccuracyMeters + "," + this.mAltitudeMeters + "," + this.mAltitudeAccuracyMeters + "," + this.mSpeedMetersPerSecond + "," + this.mSpeedAccuracyMetersPerSecond + "," + this.mBearingDegrees + "," + this.mBearingAccuracyDegrees + ']';
    }

    public LocationAwareInfo() {
    }

    public float getAltitudeAccuracyMeters() {
        return this.mAltitudeAccuracyMeters;
    }

    public double getAltitudeMeters() {
        return this.mAltitudeMeters;
    }

    public float getBearingAccuracyDegrees() {
        return this.mBearingAccuracyDegrees;
    }

    public float getBearingDegrees() {
        return this.mBearingDegrees;
    }

    public float getHorizontalAccuracyMeters() {
        return this.mHorizontalAccuracyMeters;
    }

    public double getLatitudeDegrees() {
        return this.mLatitudeDegrees;
    }

    public double getLongitudeDegrees() {
        return this.mLongitudeDegrees;
    }

    public String getProvider() {
        return this.mProvider;
    }

    public float getSpeedAccuracyMetersPerSecond() {
        return this.mSpeedAccuracyMetersPerSecond;
    }

    public float getSpeedMetersPerSecond() {
        return this.mSpeedMetersPerSecond;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public LocationAwareInfo(Parcel r100) {
        this.mTimestamp = r100.readLong();
        this.mProvider = r100.readString();
        this.mLatitudeDegrees = r100.readDouble();
        this.mLongitudeDegrees = r100.readDouble();
        this.mHorizontalAccuracyMeters = r100.readFloat();
        this.mAltitudeMeters = r100.readDouble();
        this.mAltitudeAccuracyMeters = r100.readFloat();
        this.mSpeedMetersPerSecond = r100.readFloat();
        this.mSpeedAccuracyMetersPerSecond = r100.readFloat();
        this.mBearingDegrees = r100.readFloat();
        this.mBearingAccuracyDegrees = r100.readFloat();
    }

    public void readFromParcel(Parcel r100) {
        this.mTimestamp = r100.readLong();
        this.mProvider = r100.readString();
        this.mLatitudeDegrees = r100.readDouble();
        this.mLongitudeDegrees = r100.readDouble();
        this.mHorizontalAccuracyMeters = r100.readFloat();
        this.mAltitudeMeters = r100.readDouble();
        this.mAltitudeAccuracyMeters = r100.readFloat();
        this.mSpeedMetersPerSecond = r100.readFloat();
        this.mSpeedAccuracyMetersPerSecond = r100.readFloat();
        this.mBearingDegrees = r100.readFloat();
        this.mBearingAccuracyDegrees = r100.readFloat();
    }

    public boolean sameLocation(LocationAwareInfo r100) {
        if (r100 != null) goto L4;
    L10:
        return false;
    L4:
        if (r100.mLatitudeDegrees != this.mLatitudeDegrees) goto L10;
        if (r100.mLongitudeDegrees != this.mLongitudeDegrees) goto L10;
        if (r100.mHorizontalAccuracyMeters != this.mHorizontalAccuracyMeters) goto L10;
        return true;
    }

    public LocationAwareInfo(Builder r100) {
        this.mTimestamp = Builder.a(r100);
        this.mProvider = Builder.b(r100);
        this.mLatitudeDegrees = Builder.d(r100);
        this.mLongitudeDegrees = Builder.e(r100);
        this.mHorizontalAccuracyMeters = Builder.f(r100);
        this.mAltitudeMeters = Builder.g(r100);
        this.mAltitudeAccuracyMeters = Builder.h(r100);
        this.mSpeedMetersPerSecond = Builder.i(r100);
        this.mSpeedAccuracyMetersPerSecond = Builder.j(r100);
        this.mBearingDegrees = Builder.k(r100);
        this.mBearingAccuracyDegrees = Builder.c(r100);
    }

    public LocationAwareInfo(LocationAwareInfo r100) {
        this.mTimestamp = r100.getTimestamp();
        this.mProvider = r100.getProvider();
        this.mLatitudeDegrees = r100.getLatitudeDegrees();
        this.mLongitudeDegrees = r100.getLongitudeDegrees();
        this.mHorizontalAccuracyMeters = r100.getHorizontalAccuracyMeters();
        this.mAltitudeMeters = r100.getAltitudeMeters();
        this.mAltitudeAccuracyMeters = r100.getAltitudeAccuracyMeters();
        this.mSpeedMetersPerSecond = r100.getSpeedMetersPerSecond();
        this.mSpeedAccuracyMetersPerSecond = r100.getSpeedAccuracyMetersPerSecond();
        this.mBearingDegrees = r100.getBearingDegrees();
        this.mBearingAccuracyDegrees = r100.getBearingAccuracyDegrees();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.mTimestamp);
        r100.writeString(this.mProvider);
        r100.writeDouble(this.mLatitudeDegrees);
        r100.writeDouble(this.mLongitudeDegrees);
        r100.writeFloat(this.mHorizontalAccuracyMeters);
        r100.writeDouble(this.mAltitudeMeters);
        r100.writeFloat(this.mAltitudeAccuracyMeters);
        r100.writeFloat(this.mSpeedMetersPerSecond);
        r100.writeFloat(this.mSpeedAccuracyMetersPerSecond);
        r100.writeFloat(this.mBearingDegrees);
        r100.writeFloat(this.mBearingAccuracyDegrees);
    }

    public LocationAwareInfo(long r100, String r101, double r102, double r103, float r104, double r105, float r110, float r111, float r112, float r113, float r114) {
        this.mTimestamp = r100;
        this.mProvider = r101;
        this.mLatitudeDegrees = r102;
        this.mLongitudeDegrees = r103;
        this.mHorizontalAccuracyMeters = r104;
        this.mAltitudeMeters = r105;
        this.mAltitudeAccuracyMeters = r110;
        this.mSpeedMetersPerSecond = r111;
        this.mSpeedAccuracyMetersPerSecond = r112;
        this.mBearingDegrees = r113;
        this.mBearingAccuracyDegrees = r114;
    }
}

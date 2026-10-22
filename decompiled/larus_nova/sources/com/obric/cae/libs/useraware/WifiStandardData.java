package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public class WifiStandardData implements Parcelable {
    public static final int AP_TYPE_NORMAL = 0;
    public static final int AP_TYPE_SOFTAP = 1;
    public static final int AP_TYPE_UNKNOWN = -1;
    public static final int AUTH_ENTERPRISE = 1;
    public static final int AUTH_OPEN = 3;
    public static final int AUTH_PERSONAL = 2;
    public static final int AUTH_UNKNOWN = 0;
    public static final Parcelable.Creator<WifiStandardData> CREATOR = null;
    private static final String TAG = "WifiStandardData";
    private static final int VERSION = 1;
    public static final int WIFI_BAND_24_GHZ = 1;
    public static final int WIFI_BAND_5_GHZ = 2;
    public static final int WIFI_BAND_UNKNOWN = 0;
    public static final int WIFI_STANDARD_11AC = 5;
    public static final int WIFI_STANDARD_11AD = 7;
    public static final int WIFI_STANDARD_11AX = 6;
    public static final int WIFI_STANDARD_11BE = 8;
    public static final int WIFI_STANDARD_11N = 4;
    public static final int WIFI_STANDARD_LEGACY = 1;
    public static final int WIFI_STANDARD_UNKNOWN = 0;
    private int mApStandard;
    private int mApType;
    private int mAuthType;
    private int mBand;
    private String mBssid;
    private long mDataflow;
    private int mFrequency;
    private int mRssi;
    private int mSignalLevel;
    private String mSsid;
    private long mTimestamp;
    private long mUseTime;

    /* JADX INFO: loaded from: classes33.dex */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f395972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f395973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f395974c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f395975d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f395976e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f395977f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f395978g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f395979h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f395980i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f395981j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f395982k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f395983l;

        public WifiStandardData build() {
            return new WifiStandardData(this);
        }

        public Builder() {
            this.f395973b = "";
            this.f395974c = "";
            this.f395975d = 0;
            this.f395976e = 0;
            this.f395977f = 0;
            this.f395978g = 0;
            this.f395979h = 0;
            this.f395980i = 0;
            this.f395981j = 0;
            this.f395982k = -1;
            this.f395983l = 0;
        }

        public static /* synthetic */ long a(Builder r100) {
            return r100.f395972a;
        }

        public static /* synthetic */ String b(Builder r100) {
            return r100.f395973b;
        }

        public static /* synthetic */ int c(Builder r100) {
            return r100.f395982k;
        }

        public static /* synthetic */ int d(Builder r100) {
            return r100.f395983l;
        }

        public static /* synthetic */ String e(Builder r100) {
            return r100.f395974c;
        }

        public static /* synthetic */ int f(Builder r100) {
            return r100.f395975d;
        }

        public static /* synthetic */ int g(Builder r100) {
            return r100.f395976e;
        }

        public static /* synthetic */ int h(Builder r100) {
            return r100.f395977f;
        }

        public static /* synthetic */ int i(Builder r100) {
            return r100.f395978g;
        }

        public static /* synthetic */ long j(Builder r100) {
            return r100.f395979h;
        }

        public static /* synthetic */ long k(Builder r100) {
            return r100.f395980i;
        }

        public static /* synthetic */ int l(Builder r100) {
            return r100.f395981j;
        }

        public Builder setApStandard(int r100) {
            this.f395983l = r100;
            return this;
        }

        public Builder setApType(int r100) {
            this.f395982k = r100;
            return this;
        }

        public Builder setAuthType(int r100) {
            this.f395981j = r100;
            return this;
        }

        public Builder setBand(int r100) {
            this.f395978g = r100;
            return this;
        }

        public Builder setBssid(String r100) {
            this.f395973b = r100;
            return this;
        }

        public Builder setDataflow(long r100) {
            this.f395979h = r100;
            return this;
        }

        public Builder setFrequency(int r100) {
            this.f395977f = r100;
            return this;
        }

        public Builder setRssi(int r100) {
            this.f395976e = r100;
            return this;
        }

        public Builder setSignalLevel(int r100) {
            this.f395975d = r100;
            return this;
        }

        public Builder setSsid(String r100) {
            this.f395974c = r100;
            return this;
        }

        public Builder setTimestamp(long r100) {
            this.f395972a = r100;
            return this;
        }

        public Builder setUseTime(long r100) {
            this.f395980i = r100;
            return this;
        }
    }

    public class a implements Parcelable.Creator<WifiStandardData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WifiStandardData createFromParcel(Parcel r100) {
            return new WifiStandardData(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final WifiStandardData[] newArray(int r100) {
            return new WifiStandardData[r100];
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
        return "WifiStandardData[1," + this.mTimestamp + "," + this.mBssid + "," + this.mSsid + "," + this.mSignalLevel + "," + this.mRssi + "," + this.mFrequency + "," + this.mBand + "," + this.mDataflow + "," + this.mUseTime + "," + this.mAuthType + "," + this.mApType + "," + this.mApStandard + ']';
    }

    public int getApStandard() {
        return this.mApStandard;
    }

    public int getApType() {
        return this.mApType;
    }

    public int getAuthType() {
        return this.mAuthType;
    }

    public int getBand() {
        return this.mBand;
    }

    public String getBssid() {
        return this.mBssid;
    }

    public long getDataflow() {
        return this.mDataflow;
    }

    public int getFrequency() {
        return this.mFrequency;
    }

    public int getRssi() {
        return this.mRssi;
    }

    public int getSignalLevel() {
        return this.mSignalLevel;
    }

    public String getSsid() {
        return this.mSsid;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public long getUseTime() {
        return this.mUseTime;
    }

    public WifiStandardData(Parcel r100) {
        this.mAuthType = 0;
        this.mApType = -1;
        this.mApStandard = 0;
        this.mTimestamp = r100.readLong();
        this.mBssid = r100.readString();
        this.mSsid = r100.readString();
        this.mSignalLevel = r100.readInt();
        this.mRssi = r100.readInt();
        this.mFrequency = r100.readInt();
        this.mBand = r100.readInt();
        this.mDataflow = r100.readLong();
        this.mUseTime = r100.readLong();
        this.mAuthType = r100.readInt();
        this.mApType = r100.readInt();
        this.mApStandard = r100.readInt();
    }

    public WifiStandardData(Builder r100) {
        this.mAuthType = 0;
        this.mApType = -1;
        this.mApStandard = 0;
        this.mTimestamp = Builder.a(r100);
        this.mBssid = Builder.b(r100);
        this.mSsid = Builder.e(r100);
        this.mSignalLevel = Builder.f(r100);
        this.mRssi = Builder.g(r100);
        this.mFrequency = Builder.h(r100);
        this.mBand = Builder.i(r100);
        this.mDataflow = Builder.j(r100);
        this.mUseTime = Builder.k(r100);
        this.mAuthType = Builder.l(r100);
        this.mApType = Builder.c(r100);
        this.mApStandard = Builder.d(r100);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.mTimestamp);
        r100.writeString(this.mBssid);
        r100.writeString(this.mSsid);
        r100.writeInt(this.mSignalLevel);
        r100.writeInt(this.mRssi);
        r100.writeInt(this.mFrequency);
        r100.writeInt(this.mBand);
        r100.writeLong(this.mDataflow);
        r100.writeLong(this.mUseTime);
        r100.writeInt(this.mAuthType);
        r100.writeInt(this.mApType);
        r100.writeInt(this.mApStandard);
    }
}

package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes33.dex */
public class QshHarRuntimeParamData implements Parcelable {
    public static final Parcelable.Creator<QshHarRuntimeParamData> CREATOR = null;
    public static final int POWER_MODE_HIGH_PERF = 2;
    public static final int POWER_MODE_LOW = 1;
    public static final int POWER_MODE_NORMAL = 0;
    private int mConfidenceThreshold;
    private int mPowerMode;
    private int mSampleRate;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f395962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f395963b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f395964c;

        public QshHarRuntimeParamData build() {
            return new QshHarRuntimeParamData(this.f395962a, this.f395963b, this.f395964c);
        }

        public Builder() {
            this.f395964c = 0;
        }

        public Builder setConfidenceThreshold(int r100) {
            this.f395963b = r100;
            return this;
        }

        public Builder setPowerMode(int r100) {
            this.f395964c = r100;
            return this;
        }

        public Builder setSampleRate(int r100) {
            this.f395962a = r100;
            return this;
        }
    }

    public class a implements Parcelable.Creator<QshHarRuntimeParamData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarRuntimeParamData createFromParcel(Parcel r100) {
            return new QshHarRuntimeParamData(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarRuntimeParamData[] newArray(int r100) {
            return new QshHarRuntimeParamData[r100];
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
        return "QshHarRuntimeParamParcel[sampleRate=" + this.mSampleRate + ", confidenceThreshold=" + this.mConfidenceThreshold + ", powerMode=" + this.mPowerMode + ']';
    }

    public QshHarRuntimeParamData() {
    }

    public int getConfidenceThreshold() {
        return this.mConfidenceThreshold;
    }

    public int getPowerMode() {
        return this.mPowerMode;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public QshHarRuntimeParamData(Parcel r100) {
        this.mSampleRate = r100.readInt();
        this.mConfidenceThreshold = r100.readInt();
        this.mPowerMode = r100.readInt();
    }

    public void readFromParcel(Parcel r100) {
        this.mSampleRate = r100.readInt();
        this.mConfidenceThreshold = r100.readInt();
        this.mPowerMode = r100.readInt();
    }

    public void setConfidenceThreshold(int r100) {
        this.mConfidenceThreshold = r100;
    }

    public void setPowerMode(int r100) {
        this.mPowerMode = r100;
    }

    public void setSampleRate(int r100) {
        this.mSampleRate = r100;
    }

    public QshHarRuntimeParamData(QshHarRuntimeParamData r100) {
        this.mSampleRate = r100.getSampleRate();
        this.mConfidenceThreshold = r100.getConfidenceThreshold();
        this.mPowerMode = r100.getPowerMode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.mSampleRate);
        r100.writeInt(this.mConfidenceThreshold);
        r100.writeInt(this.mPowerMode);
    }

    public QshHarRuntimeParamData(int r100, int r101, int r102) {
        this.mSampleRate = r100;
        this.mConfidenceThreshold = r101;
        this.mPowerMode = r102;
    }
}

package com.ss.android.vesdk.settings;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.ss.android.vesdk.VEVideoEncodeSettings;

/* JADX INFO: loaded from: classes40.dex */
public class VEVideoSWEncodeSettings implements Parcelable {
    public static final Parcelable.Creator<VEVideoSWEncodeSettings> CREATOR = null;
    private static final String TAG = "VEVideoSWEncodeSettings";
    public int mBitrateMode;
    public int mBps;
    public int mByteVC1Crf;
    public int mCrf;
    public double mFHDCrfRatio;
    public int mGop;
    public double mHFpsOffset;
    public long mMaxRate;
    public int mPreset;
    public int mProfile;
    public double mQPOffset;
    public double mSDCrfRatio;

    public class a implements Parcelable.Creator<VEVideoSWEncodeSettings> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoSWEncodeSettings createFromParcel(Parcel r100) {
            return new VEVideoSWEncodeSettings(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoSWEncodeSettings[] newArray(int r100) {
            return new VEVideoSWEncodeSettings[r100];
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
        return "VEVideoSWEncodeSettings{mCrf=" + this.mCrf + ", mBps=" + this.mBps + ", mBitrateMode=" + this.mBitrateMode + ", mPreset=" + this.mPreset + ", mProfile=" + this.mProfile + ", mMaxRate=" + this.mMaxRate + ", mGop=" + this.mGop + '}';
    }

    public VEVideoSWEncodeSettings() {
        this.mCrf = 15;
        this.mQPOffset = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mHFpsOffset = -1.0d;
        this.mByteVC1Crf = 22;
        this.mSDCrfRatio = 1.0d;
        this.mFHDCrfRatio = 1.0d;
        this.mBps = 4000000;
        this.mBitrateMode = VEVideoEncodeSettings.ENCODE_BITRATE_MODE.ENCODE_BITRATE_CRF.ordinal();
        this.mPreset = VEVideoEncodePreset.ENCODE_LEVEL_ULTRAFAST.ordinal();
        this.mProfile = VEVideoEncodeProfile.ENCODE_PROFILE_UNKNOWN.ordinal();
        this.mMaxRate = 15000000;
        this.mGop = 35;
    }

    public VEVideoSWEncodeSettings(Parcel r100) {
        this.mCrf = 15;
        this.mQPOffset = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mHFpsOffset = -1.0d;
        this.mByteVC1Crf = 22;
        this.mSDCrfRatio = 1.0d;
        this.mFHDCrfRatio = 1.0d;
        this.mBps = 4000000;
        this.mBitrateMode = VEVideoEncodeSettings.ENCODE_BITRATE_MODE.ENCODE_BITRATE_CRF.ordinal();
        this.mPreset = VEVideoEncodePreset.ENCODE_LEVEL_ULTRAFAST.ordinal();
        this.mProfile = VEVideoEncodeProfile.ENCODE_PROFILE_UNKNOWN.ordinal();
        this.mMaxRate = 15000000;
        this.mGop = 35;
        this.mCrf = r100.readInt();
        this.mQPOffset = r100.readDouble();
        this.mHFpsOffset = r100.readDouble();
        this.mByteVC1Crf = r100.readInt();
        this.mSDCrfRatio = r100.readDouble();
        this.mFHDCrfRatio = r100.readDouble();
        this.mPreset = r100.readInt();
        this.mProfile = r100.readInt();
        this.mMaxRate = r100.readLong();
        this.mBps = r100.readInt();
        this.mBitrateMode = r100.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.mCrf);
        r100.writeDouble(this.mQPOffset);
        r100.writeDouble(this.mHFpsOffset);
        r100.writeInt(this.mByteVC1Crf);
        r100.writeDouble(this.mSDCrfRatio);
        r100.writeDouble(this.mFHDCrfRatio);
        r100.writeInt(this.mPreset);
        r100.writeInt(this.mProfile);
        r100.writeLong(this.mMaxRate);
        r100.writeInt(this.mBps);
        r100.writeInt(this.mBitrateMode);
    }
}

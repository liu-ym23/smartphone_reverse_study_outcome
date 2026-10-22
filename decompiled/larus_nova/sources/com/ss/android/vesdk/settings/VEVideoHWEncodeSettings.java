package com.ss.android.vesdk.settings;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEVideoHWEncodeSettings implements Parcelable {
    public static final Parcelable.Creator<VEVideoHWEncodeSettings> CREATOR = null;
    private static final String TAG = "VEVideoHWEncodeSettings";
    public static final int TE_CODEC_TYPE_BYTE_VC1 = 1;
    public static final int TE_CODEC_TYPE_H264 = 0;
    public double m2K_bitrate_ratio;
    public double m4K_bitrate_ratio;
    public long mBitrate;
    public int mCodecType;
    public double mFullHd_bitrate_ratio;
    public int mGop;
    public double mH_fps_bitrate_ratio;
    public double mHevc_bitrate_ratio;
    public double mHp_bitrate_ratio;
    public int mProfile;
    public double mSd_bitrate_ratio;
    public double transition_bitrate_ratio;

    public class a implements Parcelable.Creator<VEVideoHWEncodeSettings> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoHWEncodeSettings createFromParcel(Parcel r100) {
            return new VEVideoHWEncodeSettings(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoHWEncodeSettings[] newArray(int r100) {
            return new VEVideoHWEncodeSettings[r100];
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
        return "VEVideoHWEncodeSettings{mBitrate=" + this.mBitrate + ", mProfile=" + this.mProfile + ", mHp_bitrate_ratio=" + this.mHp_bitrate_ratio + ", mFullHd_bitrate_ratio=" + this.mFullHd_bitrate_ratio + ", mSd_bitrate_ratio=" + this.mSd_bitrate_ratio + ", mH_fps_bitrate_ratio=" + this.mH_fps_bitrate_ratio + ", transition_bitrate_ratio=" + this.transition_bitrate_ratio + ", m2KbitrateRatio=" + this.m2K_bitrate_ratio + ", m4KbiterateRatio=" + this.m4K_bitrate_ratio + ", mHevc_bitrate_ratio=" + this.mHevc_bitrate_ratio + ", mGop=" + this.mGop + ", mCodecType=" + this.mCodecType + '}';
    }

    public VEVideoHWEncodeSettings() {
        this.mBitrate = 6000000;
        this.mProfile = VEVideoEncodeProfile.ENCODE_PROFILE_UNKNOWN.ordinal();
        this.mHp_bitrate_ratio = 0.75d;
        this.mFullHd_bitrate_ratio = 1.0d;
        this.mSd_bitrate_ratio = 1.0d;
        this.mH_fps_bitrate_ratio = 1.0d;
        this.transition_bitrate_ratio = 1.0d;
        this.m2K_bitrate_ratio = 1.0d;
        this.m4K_bitrate_ratio = 1.0d;
        this.mHevc_bitrate_ratio = 1.0d;
        this.mGop = 35;
        this.mCodecType = 0;
    }

    public VEVideoHWEncodeSettings(Parcel r100) {
        this.mBitrate = 6000000;
        this.mProfile = VEVideoEncodeProfile.ENCODE_PROFILE_UNKNOWN.ordinal();
        this.mHp_bitrate_ratio = 0.75d;
        this.mFullHd_bitrate_ratio = 1.0d;
        this.mSd_bitrate_ratio = 1.0d;
        this.mH_fps_bitrate_ratio = 1.0d;
        this.transition_bitrate_ratio = 1.0d;
        this.m2K_bitrate_ratio = 1.0d;
        this.m4K_bitrate_ratio = 1.0d;
        this.mHevc_bitrate_ratio = 1.0d;
        this.mGop = 35;
        this.mCodecType = 0;
        this.mBitrate = r100.readLong();
        this.mProfile = r100.readInt();
        this.mHp_bitrate_ratio = r100.readDouble();
        this.mFullHd_bitrate_ratio = r100.readDouble();
        this.mSd_bitrate_ratio = r100.readDouble();
        this.mH_fps_bitrate_ratio = r100.readDouble();
        this.mHevc_bitrate_ratio = r100.readDouble();
        this.mGop = r100.readInt();
        this.transition_bitrate_ratio = r100.readDouble();
        this.m2K_bitrate_ratio = r100.readDouble();
        this.m4K_bitrate_ratio = r100.readDouble();
        this.mCodecType = r100.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.mBitrate);
        r100.writeInt(this.mProfile);
        r100.writeDouble(this.mHp_bitrate_ratio);
        r100.writeDouble(this.mFullHd_bitrate_ratio);
        r100.writeDouble(this.mSd_bitrate_ratio);
        r100.writeDouble(this.mH_fps_bitrate_ratio);
        r100.writeDouble(this.mHevc_bitrate_ratio);
        r100.writeInt(this.mGop);
        r100.writeDouble(this.transition_bitrate_ratio);
        r100.writeDouble(this.m2K_bitrate_ratio);
        r100.writeDouble(this.m4K_bitrate_ratio);
        r100.writeInt(this.mCodecType);
    }
}

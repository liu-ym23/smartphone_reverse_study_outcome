package com.ss.android.vesdk.settings;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEVideoCompileEncodeSettings implements Parcelable {
    public static final Parcelable.Creator<VEVideoCompileEncodeSettings> CREATOR = null;
    private static final String TAG = "VEVideoCompileEncodeSettings";
    public boolean enableHwBufferEncode;
    public boolean isSupportHWEncoder;
    public VEVideoHWEncodeSettings mHWEncodeSetting;
    public VEVideoSWEncodeSettings mSWEncodeSetting;
    public boolean useHWEncoder;

    public class a implements Parcelable.Creator<VEVideoCompileEncodeSettings> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoCompileEncodeSettings createFromParcel(Parcel r100) {
            return new VEVideoCompileEncodeSettings(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoCompileEncodeSettings[] newArray(int r100) {
            return new VEVideoCompileEncodeSettings[r100];
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
        return "VEVideoCompileEncodeSettings{useHWEncoder=" + this.useHWEncoder + ", isSupportHWEncoder=" + this.isSupportHWEncoder + ", mHWEncodeSetting=" + this.mHWEncodeSetting + ", mSWEncodeSetting=" + this.mSWEncodeSetting + '}';
    }

    public VEVideoCompileEncodeSettings() {
        this.mHWEncodeSetting = new VEVideoHWEncodeSettings();
        this.mSWEncodeSetting = new VEVideoSWEncodeSettings();
    }

    public VEVideoCompileEncodeSettings(Parcel r100) {
        this.mHWEncodeSetting = new VEVideoHWEncodeSettings();
        this.mSWEncodeSetting = new VEVideoSWEncodeSettings();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.useHWEncoder = r102;
        if (r100.readByte() != 0) goto L10;
        r101 = false;
    L10:
        this.isSupportHWEncoder = r101;
        this.mHWEncodeSetting = (VEVideoHWEncodeSettings) r100.readParcelable(VEVideoHWEncodeSettings.class.getClassLoader());
        this.mSWEncodeSetting = (VEVideoSWEncodeSettings) r100.readParcelable(VEVideoSWEncodeSettings.class.getClassLoader());
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeByte(this.useHWEncoder ? 1 : 0);
        r100.writeByte(this.isSupportHWEncoder ? 1 : 0);
        r100.writeParcelable(this.mHWEncodeSetting, r101);
        r100.writeParcelable(this.mSWEncodeSetting, r101);
    }
}

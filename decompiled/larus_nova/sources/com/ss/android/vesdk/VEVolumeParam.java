package com.ss.android.vesdk;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VEVolumeParam implements Parcelable {
    public static final Parcelable.Creator<VEVolumeParam> CREATOR = null;
    public float bgmPlayVolume;
    public boolean enhanceSysPlayVolume;
    public String trackId;
    public int trackIndex;

    public class a implements Parcelable.Creator<VEVolumeParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEVolumeParam createFromParcel(Parcel r100) {
            return new VEVolumeParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEVolumeParam[] newArray(int r100) {
            return new VEVolumeParam[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public VEVolumeParam() {
        this.trackIndex = -1;
        this.bgmPlayVolume = -1.0f;
    }

    public TEBundle getBundle() {
        TEBundle r100 = TEBundle.obtain();
        r100.setString("trackId", this.trackId);
        r100.setInt("trackIndex", this.trackIndex);
        r100.setFloat("bgmPlayVolume", this.bgmPlayVolume);
        r100.setBool("enhanceSysPlayVolume", this.enhanceSysPlayVolume);
        return r100;
    }

    public VEVolumeParam(Parcel r100) {
        this.trackIndex = -1;
        this.bgmPlayVolume = -1.0f;
        this.bgmPlayVolume = r100.readFloat();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.enhanceSysPlayVolume = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeFloat(this.bgmPlayVolume);
        r100.writeByte(this.enhanceSysPlayVolume ? 1 : 0);
    }
}

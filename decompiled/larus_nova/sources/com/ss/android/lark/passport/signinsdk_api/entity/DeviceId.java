package com.ss.android.lark.passport.signinsdk_api.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class DeviceId implements Serializable, Parcelable {
    public static final Parcelable.Creator<DeviceId> CREATOR = null;
    private String deviceId;

    public class a implements Parcelable.Creator<DeviceId> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DeviceId createFromParcel(Parcel r100) {
            return new DeviceId(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DeviceId[] newArray(int r100) {
            return new DeviceId[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public DeviceId(Parcel r100) {
        this.deviceId = r100.readString();
    }

    public void setDeviceId(String r100) {
        this.deviceId = r100;
    }

    public DeviceId(String r100) {
        this.deviceId = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.deviceId);
    }
}

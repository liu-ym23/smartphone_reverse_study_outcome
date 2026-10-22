package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.u.i;
import nw7.c;

/* JADX INFO: loaded from: classes23.dex */
public class DeviceInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f276532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f276533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f276534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f276535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f276536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f276537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f276538g;

    public class a implements Parcelable.Creator<DeviceInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DeviceInfo createFromParcel(Parcel r100) {
            DeviceInfo r101 = new DeviceInfo();
            r101.f276533b = r100.readString();
            r101.f276535d = r100.readString();
            r101.f276532a = r100.readString();
            r101.f276534c = r100.readString();
            r101.f276536e = r100.readString();
            r101.f276537f = r100.readString();
            r101.f276538g = r100.readString();
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final DeviceInfo[] newArray(int r100) {
            return new DeviceInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "{'mDeviceAliasName':" + c.a(this.f276535d) + ",'mDeviceId':" + c.a(this.f276533b) + ",'mTerminalType':" + this.f276534c + ",'mDeviceType':" + this.f276532a + ",'mLoginTime':" + this.f276536e + ",'mLogoutTime':" + this.f276537f + ",'mFrequentlyUsed':" + this.f276538g + i.f25855d;
    }

    public DeviceInfo() {
        this.f276538g = "";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f276533b);
        r100.writeString(this.f276535d);
        r100.writeString(this.f276532a);
        r100.writeString(this.f276534c);
        r100.writeString(this.f276536e);
        r100.writeString(this.f276537f);
        r100.writeString(this.f276538g);
    }
}

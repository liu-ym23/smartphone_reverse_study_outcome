package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes15.dex */
public class ServiceConnectEvent implements Parcelable {
    public static final Parcelable.Creator<ServiceConnectEvent> CREATOR = null;
    private final int mChannelId;
    private final boolean mConnected;
    private final String mLogInfo;
    private final int mServiceId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public String toString() {
        return "ServiceConnectEvent{mChannelId=" + this.mChannelId + ", mServiceId=" + this.mServiceId + ", mConnected=" + this.mConnected + ", mLogInfo='" + this.mLogInfo + "'}";
    }

    public int getChannelId() {
        return this.mChannelId;
    }

    public int getServiceId() {
        return this.mServiceId;
    }

    public boolean isServiceConnected() {
        return this.mConnected;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.mChannelId);
        r100.writeInt(this.mServiceId);
        r100.writeByte(this.mConnected ? 1 : 0);
        r100.writeString(this.mLogInfo);
    }

    public ServiceConnectEvent(int r100, int r101, boolean r102, String r103) {
        this.mChannelId = r100;
        this.mServiceId = r101;
        this.mConnected = r102;
        this.mLogInfo = r103;
    }
}

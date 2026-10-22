package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes15.dex */
public class ServiceParcelable implements Parcelable {
    public static final Parcelable.Creator<ServiceParcelable> CREATOR = null;
    private final int mChannelId;
    private final int mServiceId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int getChannelId() {
        return this.mChannelId;
    }

    public int getServiceId() {
        return this.mServiceId;
    }

    public ServiceParcelable(int r100, int r101) {
        this.mChannelId = r100;
        this.mServiceId = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.mChannelId);
        r100.writeInt(this.mServiceId);
    }
}

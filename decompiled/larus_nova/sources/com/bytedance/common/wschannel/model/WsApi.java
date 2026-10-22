package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes15.dex */
public class WsApi implements Parcelable {
    public static final Parcelable.Creator<WsApi> CREATOR = null;
    int method;
    int service;

    public WsApi() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.service);
        r100.writeInt(this.method);
    }
}

package com.hihonor.push.framework.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = null;
    public Bundle body;
    public String eventType;
    public Bundle header;

    static {
        CREATOR = new AnonymousClass1();
    }

    public DataBuffer(Parcel r100) {
        this.eventType = r100.readString();
        this.header = r100.readBundle(Bundle.class.getClassLoader());
        this.body = r100.readBundle(Bundle.class.getClassLoader());
    }

    public DataBuffer(String r100, Bundle r101, Bundle r102) {
        this.eventType = r100;
        this.header = r101;
        this.body = r102;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getBody() {
        return this.body;
    }

    public String getEventType() {
        return this.eventType;
    }

    public Bundle getHeader() {
        return this.header;
    }

    public void setBody(Bundle r100) {
        this.body = r100;
    }

    public void setEventType(String r100) {
        this.eventType = r100;
    }

    public void setHeader(Bundle r100) {
        this.header = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.eventType);
        r100.writeBundle(this.header);
        r100.writeBundle(this.body);
    }
}

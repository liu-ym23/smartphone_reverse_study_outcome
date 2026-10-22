package com.hihonor.cloudservice.framework.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f276489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f276490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f276491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bundle f276492d;

    public class a implements Parcelable.Creator<DataBuffer> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DataBuffer createFromParcel(Parcel r100) {
            return new DataBuffer(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DataBuffer[] newArray(int r100) {
            return new DataBuffer[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public DataBuffer() {
        this.f276491c = null;
        this.f276492d = null;
        this.f276490b = "honorid.silentsignin";
        this.f276489a = 1001;
    }

    public DataBuffer(Parcel r100) {
        this.f276491c = null;
        this.f276492d = null;
        this.f276489a = r100.readInt();
        this.f276490b = r100.readString();
        this.f276491c = r100.readBundle(Bundle.class.getClassLoader());
        this.f276492d = r100.readBundle(Bundle.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f276489a);
        r100.writeString(this.f276490b);
        r100.writeBundle(this.f276491c);
        r100.writeBundle(this.f276492d);
    }
}

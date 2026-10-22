package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = null;
    public String URI;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f277133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bundle f277134b;
    public Bundle header;

    public class a implements Parcelable.Creator<DataBuffer> {
        public a() {
        }

        public DataBuffer a(Parcel r100) {
            return new DataBuffer(r100, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DataBuffer createFromParcel(Parcel r100) {
            return a(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DataBuffer[] newArray(int r100) {
            return a(r100);
        }

        public DataBuffer[] a(int r100) {
            return new DataBuffer[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public int getBodySize() {
        if (this.f277134b != null) goto L5;
        return 0;
    L5:
        return 1;
    }

    public DataBuffer() {
        this.header = null;
        this.f277133a = 1;
        this.f277134b = null;
    }

    public Bundle getBody() {
        return this.f277134b;
    }

    public int getProtocol() {
        return this.f277133a;
    }

    private DataBuffer(Parcel r100) {
        this.header = null;
        this.f277133a = 1;
        this.f277134b = null;
        a(r100);
    }

    private void a(Parcel r100) {
        this.f277133a = r100.readInt();
        this.URI = r100.readString();
        this.header = r100.readBundle(a(Bundle.class));
        this.f277134b = r100.readBundle(a(Bundle.class));
    }

    public DataBuffer addBody(Bundle r100) {
        this.f277134b = r100;
        return this;
    }

    public DataBuffer(String r100) {
        this.header = null;
        this.f277133a = 1;
        this.f277134b = null;
        this.URI = r100;
    }

    private static ClassLoader a(Class r100) {
        return r100.getClassLoader();
    }

    public DataBuffer(String r100, int r101) {
        this.header = null;
        this.f277134b = null;
        this.URI = r100;
        this.f277133a = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.writeInt(this.f277133a);
        r100.writeString(this.URI);
        r100.writeBundle(this.header);
        r100.writeBundle(this.f277134b);
    }

    public /* synthetic */ DataBuffer(Parcel r100, a r101) {
        this(r100);
    }
}

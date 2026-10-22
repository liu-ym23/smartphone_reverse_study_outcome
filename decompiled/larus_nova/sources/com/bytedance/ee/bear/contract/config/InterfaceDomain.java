package com.bytedance.ee.bear.contract.config;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes16.dex */
public class InterfaceDomain implements Parcelable {
    public static final Parcelable.Creator<InterfaceDomain> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f216926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f216927b;

    public class a implements Parcelable.Creator<InterfaceDomain> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final InterfaceDomain createFromParcel(Parcel r100) {
            return new InterfaceDomain(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final InterfaceDomain[] newArray(int r100) {
            return new InterfaceDomain[r100];
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
        return "InterfaceDomain{docsApi='" + this.f216926a + "', driveApi='" + this.f216927b + "'}";
    }

    public InterfaceDomain(Parcel r100) {
        this.f216926a = r100.readString();
        this.f216927b = r100.readString();
    }

    public InterfaceDomain(String r100, String r101) {
        this.f216926a = r100;
        this.f216927b = r101;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f216926a);
        r100.writeString(this.f216927b);
    }
}

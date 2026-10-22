package com.bytedance.ee.bear.contract.config;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class InterfaceDomain implements Parcelable {
    public static final Parcelable.Creator<InterfaceDomain> CREATOR = null;
    public final String a;
    public final String b;

    public class a implements Parcelable.Creator<InterfaceDomain> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final InterfaceDomain createFromParcel(Parcel r2) {
            return new InterfaceDomain(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final InterfaceDomain[] newArray(int r1) {
            return new InterfaceDomain[r1];
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
        return "InterfaceDomain{docsApi='" + this.a + "', driveApi='" + this.b + "'}";
    }

    public InterfaceDomain(Parcel r2) {
        this.a = r2.readString();
        this.b = r2.readString();
    }

    public InterfaceDomain(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeString(this.b);
    }
}

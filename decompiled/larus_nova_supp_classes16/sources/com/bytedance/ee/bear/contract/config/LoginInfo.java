package com.bytedance.ee.bear.contract.config;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class LoginInfo implements Parcelable {
    public static final Parcelable.Creator<LoginInfo> CREATOR = null;
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public class a implements Parcelable.Creator<LoginInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LoginInfo createFromParcel(Parcel r2) {
            return new LoginInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final LoginInfo[] newArray(int r1) {
            return new LoginInfo[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public LoginInfo() {
    }

    public LoginInfo(Parcel r3) {
        this.a = r3.readString();
        this.b = r3.readString();
        this.c = r3.readString();
        boolean r1 = true;
        if (r3.readByte() == 1) goto L6;
        r1 = false;
    L6:
        this.d = r1;
        this.e = r3.readString();
        this.f = r3.readString();
        this.g = r3.readString();
        this.h = r3.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeByte(this.d ? 1 : 0);
        r1.writeString(this.e);
        r1.writeString(this.f);
        r1.writeString(this.g);
        r1.writeString(this.h);
    }

    public LoginInfo(String r1, String r2, String r3, String r4, String r5, String r6, String r7, boolean r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.d = r8;
    }
}

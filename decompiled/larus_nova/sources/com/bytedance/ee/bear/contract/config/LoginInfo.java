package com.bytedance.ee.bear.contract.config;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes16.dex */
public class LoginInfo implements Parcelable {
    public static final Parcelable.Creator<LoginInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f216928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f216929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f216930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f216931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f216932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f216933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f216934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f216935h;

    public class a implements Parcelable.Creator<LoginInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LoginInfo createFromParcel(Parcel r100) {
            return new LoginInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final LoginInfo[] newArray(int r100) {
            return new LoginInfo[r100];
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

    public LoginInfo(Parcel r100) {
        this.f216928a = r100.readString();
        this.f216929b = r100.readString();
        this.f216930c = r100.readString();
        boolean r101 = true;
        if (r100.readByte() == 1) goto L6;
        r101 = false;
    L6:
        this.f216931d = r101;
        this.f216932e = r100.readString();
        this.f216933f = r100.readString();
        this.f216934g = r100.readString();
        this.f216935h = r100.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f216928a);
        r100.writeString(this.f216929b);
        r100.writeString(this.f216930c);
        r100.writeByte(this.f216931d ? 1 : 0);
        r100.writeString(this.f216932e);
        r100.writeString(this.f216933f);
        r100.writeString(this.f216934g);
        r100.writeString(this.f216935h);
    }

    public LoginInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107) {
        this.f216928a = r100;
        this.f216929b = r101;
        this.f216930c = r102;
        this.f216932e = r103;
        this.f216933f = r104;
        this.f216934g = r105;
        this.f216935h = r106;
        this.f216931d = r107;
    }
}

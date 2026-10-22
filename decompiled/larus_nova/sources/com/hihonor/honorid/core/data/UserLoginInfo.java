package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class UserLoginInfo implements Parcelable {
    public static final Parcelable.Creator<UserLoginInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f276620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f276621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f276622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f276623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f276624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f276625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f276626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f276627h;

    public class a implements Parcelable.Creator<UserLoginInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserLoginInfo createFromParcel(Parcel r100) {
            UserLoginInfo r101 = new UserLoginInfo();
            r101.f276627h = r100.readString();
            r101.f276623d = r100.readString();
            r101.f276625f = r100.readString();
            r101.f276624e = r100.readString();
            r101.f276626g = r100.readString();
            r101.f276621b = r100.readString();
            r101.f276622c = r100.readString();
            r101.f276620a = r100.readString();
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final UserLoginInfo[] newArray(int r100) {
            return new UserLoginInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public UserLoginInfo() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f276627h);
        r100.writeString(this.f276623d);
        r100.writeString(this.f276625f);
        r100.writeString(this.f276624e);
        r100.writeString(this.f276626g);
        r100.writeString(this.f276621b);
        r100.writeString(this.f276622c);
        r100.writeString(this.f276620a);
    }
}

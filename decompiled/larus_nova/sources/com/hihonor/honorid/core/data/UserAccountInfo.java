package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class UserAccountInfo implements Parcelable {
    public static final Parcelable.Creator<UserAccountInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f276584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f276585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f276586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f276587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f276588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f276589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f276590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f276591h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f276592i;

    public class a implements Parcelable.Creator<UserAccountInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserAccountInfo createFromParcel(Parcel r100) {
            UserAccountInfo r101 = new UserAccountInfo();
            r101.f276584a = r100.readString();
            r101.f276585b = r100.readString();
            r101.f276586c = r100.readString();
            r101.f276587d = r100.readString();
            r101.f276588e = r100.readString();
            r101.f276589f = r100.readString();
            r101.f276590g = r100.readString();
            r101.f276591h = r100.readString();
            r101.f276592i = r100.readString();
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final UserAccountInfo[] newArray(int r100) {
            return new UserAccountInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public UserAccountInfo() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f276584a);
        r100.writeString(this.f276585b);
        r100.writeString(this.f276586c);
        r100.writeString(this.f276587d);
        r100.writeString(this.f276588e);
        r100.writeString(this.f276589f);
        r100.writeString(this.f276590g);
        r100.writeString(this.f276591h);
        r100.writeString(this.f276592i);
    }
}

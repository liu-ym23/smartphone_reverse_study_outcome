package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.u.i;
import nw7.c;

/* JADX INFO: loaded from: classes23.dex */
public class ChildrenInfo implements Parcelable {
    public static final Parcelable.Creator<ChildrenInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f276525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f276526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f276527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f276528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f276529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f276530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f276531g;

    public class a implements Parcelable.Creator<ChildrenInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChildrenInfo createFromParcel(Parcel r100) {
            ChildrenInfo r101 = new ChildrenInfo();
            r101.f276525a = r100.readString();
            r101.f276526b = r100.readString();
            r101.f276527c = r100.readString();
            r101.f276528d = r100.readString();
            r101.f276529e = r100.readString();
            r101.f276530f = r100.readString();
            r101.f276531g = r100.readString();
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final ChildrenInfo[] newArray(int r100) {
            return new ChildrenInfo[r100];
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
        return "{'childrenUserId':" + c.a(this.f276525a) + ",'birthDate':" + this.f276526b + ",'uniquelyNickname':" + this.f276527c + ",'headPictureUrl':" + c.a(this.f276529e) + ",'accountName':" + this.f276528d + this.f276530f + c.a(this.f276531g) + i.f25855d;
    }

    public ChildrenInfo() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f276525a);
        r100.writeString(this.f276526b);
        r100.writeString(this.f276527c);
        r100.writeString(this.f276528d);
        r100.writeString(this.f276529e);
        r100.writeString(this.f276530f);
        r100.writeString(this.f276531g);
    }
}

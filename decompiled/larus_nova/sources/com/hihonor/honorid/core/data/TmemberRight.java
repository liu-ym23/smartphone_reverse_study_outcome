package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class TmemberRight implements Parcelable {
    public static final Parcelable.Creator<TmemberRight> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f276576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f276577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f276578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f276579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f276580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f276581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f276582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f276583h;

    public class a implements Parcelable.Creator<TmemberRight> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TmemberRight createFromParcel(Parcel r100) {
            TmemberRight r101 = new TmemberRight();
            r101.f276576a = r100.readLong();
            r101.f276577b = r100.readInt();
            r101.f276578c = r100.readString();
            r101.f276579d = r100.readString();
            r101.f276580e = r100.readString();
            r101.f276581f = r100.readInt();
            r101.f276582g = r100.readString();
            r101.f276583h = r100.readString();
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final TmemberRight[] newArray(int r100) {
            return new TmemberRight[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public TmemberRight() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.f276576a);
        r100.writeInt(this.f276577b);
        r100.writeString(this.f276578c);
        r100.writeString(this.f276579d);
        r100.writeString(this.f276580e);
        r100.writeInt(this.f276581f);
        r100.writeString(this.f276582g);
        r100.writeString(this.f276583h);
    }
}

package com.bytedance.bdp.bdpbase.ipc;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes11.dex */
public final class Request implements Parcelable {
    public static final Parcelable.Creator<Request> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f201114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f201115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f201116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ParameterList f201117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f201118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f201119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f201120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f201121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f201122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f201123j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f201124k;

    public class a implements Parcelable.Creator<Request> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Request createFromParcel(Parcel r100) {
            return new Request(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Request[] newArray(int r100) {
            return new Request[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final String a() {
        if (this.f201123j != null) goto L6;
        this.f201123j = this.f201114a + '-' + this.f201116c;
    L6:
        return this.f201123j;
    }

    public final String b() {
        return "{requestId='" + this.f201122i + "', method='" + a() + "'}";
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("{requestId='");
        r100.append(this.f201122i);
        r100.append("', method='");
        r100.append(this.f201116c);
        r100.append("', reflection='");
        boolean r101 = true;
        if (this.f201121h == 0) goto L5;
        boolean r102 = true;
    L6:
        r100.append(r102);
        r100.append("', targetClass='");
        r100.append(this.f201114a);
        r100.append("', notDispatch='");
        if (this.f201119f != 0) goto L10;
        r101 = false;
    L10:
        r100.append(r101);
        r100.append("'}");
        return r100.toString();
    L5:
        r102 = false;
        goto L6
    }

    public Request(Parcel r100) {
        this.f201118e = false;
        this.f201123j = null;
        this.f201124k = false;
        this.f201114a = r100.readString();
        this.f201115b = r100.readString();
        this.f201116c = r100.readString();
        this.f201117d = (ParameterList) r100.readParcelable(com.bytedance.bdp.bdpbase.util.b.a());
        this.f201122i = r100.readLong();
        this.f201121h = r100.readInt();
        this.f201119f = r100.readInt();
        this.f201120g = r100.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f201114a);
        r100.writeString(this.f201115b);
        r100.writeString(this.f201116c);
        r100.writeParcelable(this.f201117d, r101);
        r100.writeLong(this.f201122i);
        r100.writeInt(this.f201121h);
        r100.writeInt(this.f201119f);
        r100.writeInt(this.f201120g);
    }

    public Request(String r100, String r101, String r102, ParameterList r103, boolean r104, boolean r105, boolean r106, boolean r110, long r111) {
        this.f201118e = false;
        this.f201123j = null;
        this.f201124k = false;
        this.f201114a = r100;
        this.f201115b = r101;
        this.f201116c = r102;
        this.f201117d = r103;
        this.f201121h = r106 ? 1 : 0;
        this.f201118e = r104;
        this.f201119f = r105 ? 1 : 0;
        this.f201120g = r110 ? 1 : 0;
        this.f201122i = r111;
    }
}

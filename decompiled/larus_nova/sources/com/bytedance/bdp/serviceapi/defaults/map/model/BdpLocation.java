package com.bytedance.bdp.serviceapi.defaults.map.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes11.dex */
public class BdpLocation implements Cloneable, Parcelable {
    public static final Parcelable.Creator CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f201553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f201554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f201555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f201556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f201557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f201558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f201559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f201560h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f201561i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f201562j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f201563k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f201564l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f201565m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f201566n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f201567o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f201568p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f201569q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f201570r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public double f201571s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f201572t;

    public class a implements Parcelable.Creator {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r100) {
            BdpLocation r101 = new BdpLocation();
            r101.f201555c = r100.readDouble();
            r101.f201556d = r100.readDouble();
            r101.f201553a = r100.readInt();
            r101.f201554b = r100.readInt();
            r101.f201557e = r100.readString();
            r101.f201558f = r100.readString();
            r101.f201559g = r100.readString();
            r101.f201560h = r100.readString();
            r101.f201561i = r100.readString();
            r101.f201562j = r100.readString();
            r101.f201563k = r100.readString();
            r101.f201564l = r100.readString();
            r101.f201565m = r100.readString();
            r101.f201566n = r100.readString();
            r101.f201572t = r100.readString();
            r101.f201567o = r100.readLong();
            r101.f201568p = r100.readFloat();
            r101.f201569q = r100.readFloat();
            r101.f201570r = r100.readFloat();
            r101.f201571s = r100.readDouble();
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r100) {
            return new BdpLocation[r100];
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
        return "BdpLocation{mStatusCode=" + this.f201553a + ", mRawImplStatusCode=" + this.f201554b + ", name='" + this.f201557e + "', address='" + this.f201558f + "', country='" + this.f201559g + "', countryCode='" + this.f201560h + "', province='" + this.f201561i + "', provinceCode='" + this.f201562j + "', city='" + this.f201563k + "', cityCode='" + this.f201564l + "', district='" + this.f201565m + "', districtCode='" + this.f201566n + "', latitude='" + this.f201555c + "', longitude='" + this.f201556d + "', from='" + this.f201572t + "'}";
    }

    public BdpLocation() {
        this.f201553a = 0;
        this.f201554b = 0;
        this.f201572t = "sdk";
    }

    public final Object clone() {
        return (BdpLocation) super.clone();
    L4:
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeDouble(this.f201555c);
        r100.writeDouble(this.f201556d);
        r100.writeInt(this.f201553a);
        r100.writeInt(this.f201554b);
        r100.writeString(this.f201557e);
        r100.writeString(this.f201558f);
        r100.writeString(this.f201559g);
        r100.writeString(this.f201560h);
        r100.writeString(this.f201561i);
        r100.writeString(this.f201562j);
        r100.writeString(this.f201563k);
        r100.writeString(this.f201564l);
        r100.writeString(this.f201565m);
        r100.writeString(this.f201566n);
        r100.writeString(this.f201572t);
        r100.writeLong(this.f201567o);
        r100.writeFloat(this.f201568p);
        r100.writeFloat(this.f201569q);
        r100.writeFloat(this.f201570r);
        r100.writeDouble(this.f201571s);
    }
}

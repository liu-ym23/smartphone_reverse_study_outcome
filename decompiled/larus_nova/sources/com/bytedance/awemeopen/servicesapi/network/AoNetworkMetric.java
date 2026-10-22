package com.bytedance.awemeopen.servicesapi.network;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes46.dex */
public class AoNetworkMetric implements Parcelable {
    public static final Parcelable.Creator<AoNetworkMetric> CREATOR = null;
    public int A;
    public int B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f198975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f198976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f198977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f198978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f198979e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f198980f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f198981g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f198982h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f198983i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f198984j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f198985k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f198986l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f198987m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f198988n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f198989o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f198990p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f198991q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f198992r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f198993s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f198994t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f198995u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f198996v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f198997w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f198998x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f198999y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f199000z;

    public static class a implements Parcelable.Creator<AoNetworkMetric> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AoNetworkMetric createFromParcel(Parcel r100) {
            return new AoNetworkMetric(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final AoNetworkMetric[] newArray(int r100) {
            return new AoNetworkMetric[r100];
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
        return "BdpNetworkMetric{dnsDuration=" + this.f198975a + ", connectDuration=" + this.f198976b + ", sslDuration=" + this.f198977c + ", sendDuration=" + this.f198978d + ", waitDuration=" + this.f198979e + ", receiveDuration=" + this.f198980f + ", exeDuration=" + this.f198981g + ", socketReused=" + this.f198982h + ", requestStart=" + this.f198983i + ", requestEnd=" + this.f198984j + ", domainLookupStart=" + this.f198985k + ", domainLookupEnd=" + this.f198986l + ", connectStart=" + this.f198987m + ", connectEnd=" + this.f198988n + ", sslConnectionStart=" + this.f198989o + ", sslConnectionEnd=" + this.f198990p + ", responseStart=" + this.f198991q + ", responseEnd=" + this.f198992r + ", sentBytesCount=" + this.f198993s + ", receivedBytesCount=" + this.f198994t + ", estimateNetType='" + this.f198995u + "', protocol='" + this.f198996v + "', peerIP='" + this.f198997w + "', port=" + this.f198998x + ", rtt=" + this.f198999y + ", throughputKbps=" + this.f199000z + ", httpClientType=" + this.A + ", metricDuration=" + this.B + '}';
    }

    public AoNetworkMetric() {
        this.A = -1;
    }

    public AoNetworkMetric(Parcel r100) {
        this.A = -1;
        this.f198975a = r100.readInt();
        this.f198976b = r100.readInt();
        this.f198977c = r100.readInt();
        this.f198978d = r100.readInt();
        this.f198979e = r100.readInt();
        this.f198980f = r100.readInt();
        this.f198981g = r100.readInt();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f198982h = r101;
        this.f198983i = r100.readLong();
        this.f198984j = r100.readLong();
        this.f198985k = r100.readLong();
        this.f198986l = r100.readLong();
        this.f198987m = r100.readLong();
        this.f198988n = r100.readLong();
        this.f198989o = r100.readLong();
        this.f198990p = r100.readLong();
        this.f198991q = r100.readLong();
        this.f198992r = r100.readLong();
        this.f198993s = r100.readLong();
        this.f198994t = r100.readLong();
        this.f198995u = r100.readString();
        this.f198996v = r100.readString();
        this.f198997w = r100.readString();
        this.f198998x = r100.readInt();
        this.f198999y = r100.readInt();
        this.f199000z = r100.readInt();
        this.A = r100.readInt();
        this.B = r100.readInt();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void update(AoNetworkMetric r100) {
        this.f198975a = r100.f198975a;
        this.f198976b = r100.f198976b;
        this.f198977c = r100.f198977c;
        this.f198978d = r100.f198978d;
        this.f198979e = r100.f198979e;
        this.f198980f = r100.f198980f;
        this.f198981g = r100.f198981g;
        this.f198982h = r100.f198982h;
        this.f198983i = r100.f198983i;
        this.f198984j = r100.f198984j;
        this.f198985k = r100.f198985k;
        this.f198986l = r100.f198986l;
        this.f198987m = r100.f198987m;
        this.f198988n = r100.f198988n;
        this.f198989o = r100.f198989o;
        this.f198990p = r100.f198990p;
        this.f198991q = r100.f198991q;
        this.f198992r = r100.f198992r;
        this.f198993s = r100.f198993s;
        this.f198994t = r100.f198994t;
        this.f198995u = r100.f198995u;
        this.f198996v = r100.f198996v;
        this.f198997w = r100.f198997w;
        this.f198998x = r100.f198998x;
        this.f198999y = r100.f198999y;
        this.f199000z = r100.f199000z;
        this.A = r100.A;
        this.B = r100.B;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f198975a);
        r100.writeInt(this.f198976b);
        r100.writeInt(this.f198977c);
        r100.writeInt(this.f198978d);
        r100.writeInt(this.f198979e);
        r100.writeInt(this.f198980f);
        r100.writeInt(this.f198981g);
        r100.writeByte(this.f198982h ? 1 : 0);
        r100.writeLong(this.f198983i);
        r100.writeLong(this.f198984j);
        r100.writeLong(this.f198985k);
        r100.writeLong(this.f198986l);
        r100.writeLong(this.f198987m);
        r100.writeLong(this.f198988n);
        r100.writeLong(this.f198989o);
        r100.writeLong(this.f198990p);
        r100.writeLong(this.f198991q);
        r100.writeLong(this.f198992r);
        r100.writeLong(this.f198993s);
        r100.writeLong(this.f198994t);
        r100.writeString(this.f198995u);
        r100.writeString(this.f198996v);
        r100.writeString(this.f198997w);
        r100.writeInt(this.f198998x);
        r100.writeInt(this.f198999y);
        r100.writeInt(this.f199000z);
        r100.writeInt(this.A);
        r100.writeInt(this.B);
    }
}

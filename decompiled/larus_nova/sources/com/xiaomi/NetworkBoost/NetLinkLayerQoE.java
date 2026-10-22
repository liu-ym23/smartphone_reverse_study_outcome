package com.xiaomi.NetworkBoost;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes41.dex */
public final class NetLinkLayerQoE implements Parcelable {
    public static final Parcelable.Creator<NetLinkLayerQoE> CREATOR = null;
    public static NetLinkLayerQoE singleClass;
    public long A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f462975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f462976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f462977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f462978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f462979e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f462980f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f462981g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f462982h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f462983i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f462984j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f462985k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f462986l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f462987m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f462988n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f462989o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f462990p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f462991q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f462992r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f462993s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f462994t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f462995u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f462996v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f462997w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f462998x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f462999y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f463000z;

    public class a implements Parcelable.Creator<NetLinkLayerQoE> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final NetLinkLayerQoE createFromParcel(Parcel r100) {
            return NetLinkLayerQoE.access$000(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final NetLinkLayerQoE[] newArray(int r100) {
            return new NetLinkLayerQoE[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public NetLinkLayerQoE() {
    }

    public NetLinkLayerQoE(Parcel r100) {
        this.f462975a = r100.readString();
        this.f462976b = r100.readString();
        this.f462979e = r100.readDouble();
        this.f462980f = r100.readDouble();
        this.f462977c = r100.readInt();
        this.f462978d = r100.readInt();
        this.f462981g = r100.readInt();
        this.f462982h = r100.readInt();
        this.f462983i = r100.readInt();
        this.f462984j = r100.readInt();
        this.f462985k = r100.readInt();
        this.f462986l = r100.readLong();
        this.f462987m = r100.readLong();
        this.f462988n = r100.readLong();
        this.f462989o = r100.readLong();
        this.f462990p = r100.readLong();
        this.f462991q = r100.readLong();
        this.f462992r = r100.readLong();
        this.f462993s = r100.readLong();
        this.f462994t = r100.readLong();
        this.f462995u = r100.readLong();
        this.f462996v = r100.readLong();
        this.f462997w = r100.readLong();
        this.f462998x = r100.readLong();
        this.f462999y = r100.readLong();
        this.f463000z = r100.readLong();
        this.A = r100.readLong();
    }

    public static synchronized NetLinkLayerQoE a(Parcel r100) {
        monitor-enter(NetLinkLayerQoE.class);
        singleClass.setVersion(r100.readString());     // Catch: Throwable -> L7
        singleClass.setSsid(r100.readString());     // Catch: Throwable -> L7
        singleClass.setMpduLostRatio(r100.readDouble());     // Catch: Throwable -> L7
        singleClass.setRetriesRatio(r100.readDouble());     // Catch: Throwable -> L7
        singleClass.setRssi_mgmt(r100.readInt());     // Catch: Throwable -> L7
        singleClass.setFrequency(r100.readInt());     // Catch: Throwable -> L7
        singleClass.setRadioOnTimeMs(r100.readInt());     // Catch: Throwable -> L7
        singleClass.setCcaBusyTimeMs(r100.readInt());     // Catch: Throwable -> L7
        singleClass.setBw(r100.readInt());     // Catch: Throwable -> L7
        singleClass.setRateMcsIdx(r100.readInt());     // Catch: Throwable -> L7
        singleClass.setBitRateInKbps(r100.readInt());     // Catch: Throwable -> L7
        singleClass.setRxmpdu_be(r100.readLong());     // Catch: Throwable -> L7
        singleClass.setTxmpdu_be(r100.readLong());     // Catch: Throwable -> L7
        singleClass.setLostmpdu_be(r100.readLong());     // Catch: Throwable -> L7
        singleClass.setRetries_be(r100.readLong());     // Catch: Throwable -> L7
        singleClass.setRxmpdu_bk(r100.readLong());     // Catch: Throwable -> L7
        singleClass.setTxmpdu_bk(r100.readLong());     // Catch: Throwable -> L7
        singleClass.setLostmpdu_bk(r100.readLong());     // Catch: Throwable -> L7
        singleClass.setRetries_bk(r100.readLong());     // Catch: Throwable -> L7
        singleClass.setRxmpdu_vi(r100.readLong());     // Catch: Throwable -> L7
        singleClass.setTxmpdu_vi(r100.readLong());     // Catch: Throwable -> L7
        singleClass.setLostmpdu_vi(r100.readLong());     // Catch: Throwable -> L7
        singleClass.setRetries_vi(r100.readLong());     // Catch: Throwable -> L7
        singleClass.setRxmpdu_vo(r100.readLong());     // Catch: Throwable -> L7
        singleClass.setTxmpdu_vo(r100.readLong());     // Catch: Throwable -> L7
        singleClass.setLostmpdu_vo(r100.readLong());     // Catch: Throwable -> L7
        singleClass.setRetries_vo(r100.readLong());     // Catch: Throwable -> L7
        NetLinkLayerQoE r101 = singleClass;     // Catch: Throwable -> L7
        monitor-exit(NetLinkLayerQoE.class);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBitRateInKbps() {
        return this.f462985k;
    }

    public int getBw() {
        return this.f462983i;
    }

    public int getCcaBusyTimeMs() {
        return this.f462982h;
    }

    public int getFrequency() {
        return this.f462978d;
    }

    public long getLostmpdu_be() {
        return this.f462988n;
    }

    public long getLostmpdu_bk() {
        return this.f462992r;
    }

    public long getLostmpdu_vi() {
        return this.f462996v;
    }

    public long getLostmpdu_vo() {
        return this.f463000z;
    }

    public double getMpduLostRatio() {
        return this.f462979e;
    }

    public int getRadioOnTimeMs() {
        return this.f462981g;
    }

    public int getRateMcsIdx() {
        return this.f462984j;
    }

    public double getRetriesRatio() {
        return this.f462980f;
    }

    public long getRetries_be() {
        return this.f462989o;
    }

    public long getRetries_bk() {
        return this.f462993s;
    }

    public long getRetries_vi() {
        return this.f462997w;
    }

    public long getRetries_vo() {
        return this.A;
    }

    public int getRssi_mgmt() {
        return this.f462977c;
    }

    public long getRxmpdu_be() {
        return this.f462986l;
    }

    public long getRxmpdu_bk() {
        return this.f462990p;
    }

    public long getRxmpdu_vi() {
        return this.f462994t;
    }

    public long getRxmpdu_vo() {
        return this.f462998x;
    }

    public String getSsid() {
        return this.f462976b;
    }

    public long getTxmpdu_be() {
        return this.f462987m;
    }

    public long getTxmpdu_bk() {
        return this.f462991q;
    }

    public long getTxmpdu_vi() {
        return this.f462995u;
    }

    public long getTxmpdu_vo() {
        return this.f462999y;
    }

    public String getVersion() {
        return this.f462975a;
    }

    public void setBitRateInKbps(int r100) {
        this.f462985k = r100;
    }

    public void setBw(int r100) {
        this.f462983i = r100;
    }

    public void setCcaBusyTimeMs(int r100) {
        this.f462982h = r100;
    }

    public void setFrequency(int r100) {
        this.f462978d = r100;
    }

    public void setLostmpdu_be(long r100) {
        this.f462988n = r100;
    }

    public void setLostmpdu_bk(long r100) {
        this.f462992r = r100;
    }

    public void setLostmpdu_vi(long r100) {
        this.f462996v = r100;
    }

    public void setLostmpdu_vo(long r100) {
        this.f463000z = r100;
    }

    public void setMpduLostRatio(double r100) {
        this.f462979e = r100;
    }

    public void setRadioOnTimeMs(int r100) {
        this.f462981g = r100;
    }

    public void setRateMcsIdx(int r100) {
        this.f462984j = r100;
    }

    public void setRetriesRatio(double r100) {
        this.f462980f = r100;
    }

    public void setRetries_be(long r100) {
        this.f462989o = r100;
    }

    public void setRetries_bk(long r100) {
        this.f462993s = r100;
    }

    public void setRetries_vi(long r100) {
        this.f462997w = r100;
    }

    public void setRetries_vo(long r100) {
        this.A = r100;
    }

    public void setRssi_mgmt(int r100) {
        this.f462977c = r100;
    }

    public void setRxmpdu_be(long r100) {
        this.f462986l = r100;
    }

    public void setRxmpdu_bk(long r100) {
        this.f462990p = r100;
    }

    public void setRxmpdu_vi(long r100) {
        this.f462994t = r100;
    }

    public void setRxmpdu_vo(long r100) {
        this.f462998x = r100;
    }

    public void setSsid(String r100) {
        this.f462976b = r100;
    }

    public void setTxmpdu_be(long r100) {
        this.f462987m = r100;
    }

    public void setTxmpdu_bk(long r100) {
        this.f462991q = r100;
    }

    public void setTxmpdu_vi(long r100) {
        this.f462995u = r100;
    }

    public void setTxmpdu_vo(long r100) {
        this.f462999y = r100;
    }

    public void setVersion(String r100) {
        this.f462975a = r100;
    }

    public String toString() {
        return "NetLinkLayerQoE{version='" + this.f462975a + "', ssid='" + this.f462976b + "', rssi_mgmt=" + this.f462977c + ", frequency=" + this.f462978d + ", mpduLostRatio=" + this.f462979e + ", retriesRatio=" + this.f462980f + ", radioOnTimeMs=" + this.f462981g + ", ccaBusyTimeMs=" + this.f462982h + ", bw=" + this.f462983i + ", rateMcsIdx=" + this.f462984j + ", bitRateInKbps=" + this.f462985k + ", rxmpdu_be=" + this.f462986l + ", txmpdu_be=" + this.f462987m + ", lostmpdu_be=" + this.f462988n + ", retries_be=" + this.f462989o + ", rxmpdu_bk=" + this.f462990p + ", txmpdu_bk=" + this.f462991q + ", lostmpdu_bk=" + this.f462992r + ", retries_bk=" + this.f462993s + ", rxmpdu_vi=" + this.f462994t + ", txmpdu_vi=" + this.f462995u + ", lostmpdu_vi=" + this.f462996v + ", retries_vi=" + this.f462997w + ", rxmpdu_vo=" + this.f462998x + ", txmpdu_vo=" + this.f462999y + ", lostmpdu_vo=" + this.f463000z + ", retries_vo=" + this.A + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f462975a);
        r100.writeString(this.f462976b);
        r100.writeDouble(this.f462979e);
        r100.writeDouble(this.f462980f);
        r100.writeInt(this.f462977c);
        r100.writeInt(this.f462978d);
        r100.writeInt(this.f462981g);
        r100.writeInt(this.f462982h);
        r100.writeInt(this.f462983i);
        r100.writeInt(this.f462984j);
        r100.writeInt(this.f462985k);
        r100.writeLong(this.f462986l);
        r100.writeLong(this.f462987m);
        r100.writeLong(this.f462988n);
        r100.writeLong(this.f462989o);
        r100.writeLong(this.f462990p);
        r100.writeLong(this.f462991q);
        r100.writeLong(this.f462992r);
        r100.writeLong(this.f462993s);
        r100.writeLong(this.f462994t);
        r100.writeLong(this.f462995u);
        r100.writeLong(this.f462996v);
        r100.writeLong(this.f462997w);
        r100.writeLong(this.f462998x);
        r100.writeLong(this.f462999y);
        r100.writeLong(this.f463000z);
        r100.writeLong(this.A);
    }

    public static NetLinkLayerQoE access$000(Parcel r100) {
        monitor-enter(NetLinkLayerQoE.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (singleClass != null) goto L7;
        NetLinkLayerQoE r101 = new NetLinkLayerQoE(r100);     // Catch: Throwable -> L10
        singleClass = r101;     // Catch: Throwable -> L10
    L8:
        monitor-exit(NetLinkLayerQoE.class);
        return r101;
    L7:
        r101 = a(r100);     // Catch: Throwable -> L10
        goto L8
    }
}

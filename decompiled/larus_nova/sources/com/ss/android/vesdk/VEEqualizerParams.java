package com.ss.android.vesdk;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEEqualizerParams implements Parcelable {
    public static final Parcelable.Creator<VEEqualizerParams> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f455603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f455604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f455605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f455606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f455607e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f455608f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f455609g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f455610h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f455611i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f455612j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f455613k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f455614l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f455615m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f455616n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f455617o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f455618p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f455619q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f455620r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f455621s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float f455622t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float f455623u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f455624v;

    public class a implements Parcelable.Creator<VEEqualizerParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEEqualizerParams createFromParcel(Parcel r100) {
            return new VEEqualizerParams(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEEqualizerParams[] newArray(int r100) {
            return new VEEqualizerParams[r100];
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
        return "VEEqualizerParams{name='" + this.f455603a + "', preamp=" + this.f455604b + ", amp31=" + this.f455615m + ", amp63=" + this.f455616n + ", amp125=" + this.f455617o + ", amp250=" + this.f455618p + ", amp500=" + this.f455619q + ", amp1000=" + this.f455620r + ", amp2000=" + this.f455621s + ", amp4000=" + this.f455622t + ", amp8000=" + this.f455623u + ", amp16000=" + this.f455624v + ", freqWidth31=" + this.f455605c + ", freqWidth63=" + this.f455606d + ", freqWidth125=" + this.f455607e + ", freqWidth250=" + this.f455608f + ", freqWidth500=" + this.f455609g + ", freqWidth1000=" + this.f455610h + ", freqWidth2000=" + this.f455611i + ", freqWidth4000=" + this.f455612j + ", freqWidth8000=" + this.f455613k + ", freqWidth16000=" + this.f455614l + '}';
    }

    public VEEqualizerParams() {
        this.f455603a = "";
        this.f455604b = 12.0f;
        this.f455605c = 1.0f;
        this.f455606d = 1.0f;
        this.f455607e = 1.0f;
        this.f455608f = 1.0f;
        this.f455609g = 1.0f;
        this.f455610h = 1.0f;
        this.f455611i = 1.0f;
        this.f455612j = 1.0f;
        this.f455613k = 1.0f;
        this.f455614l = 1.0f;
        this.f455615m = 0.0f;
        this.f455616n = 0.0f;
        this.f455617o = 0.0f;
        this.f455618p = 0.0f;
        this.f455619q = 0.0f;
        this.f455620r = 0.0f;
        this.f455621s = 0.0f;
        this.f455622t = 0.0f;
        this.f455623u = 0.0f;
        this.f455624v = 0.0f;
    }

    public VEEqualizerParams(Parcel r100) {
        this.f455603a = "";
        this.f455604b = 12.0f;
        this.f455605c = 1.0f;
        this.f455606d = 1.0f;
        this.f455607e = 1.0f;
        this.f455608f = 1.0f;
        this.f455609g = 1.0f;
        this.f455610h = 1.0f;
        this.f455611i = 1.0f;
        this.f455612j = 1.0f;
        this.f455613k = 1.0f;
        this.f455614l = 1.0f;
        this.f455615m = 0.0f;
        this.f455616n = 0.0f;
        this.f455617o = 0.0f;
        this.f455618p = 0.0f;
        this.f455619q = 0.0f;
        this.f455620r = 0.0f;
        this.f455621s = 0.0f;
        this.f455622t = 0.0f;
        this.f455623u = 0.0f;
        this.f455624v = 0.0f;
        this.f455603a = r100.readString();
        this.f455604b = r100.readFloat();
        this.f455605c = r100.readFloat();
        this.f455606d = r100.readFloat();
        this.f455607e = r100.readFloat();
        this.f455608f = r100.readFloat();
        this.f455609g = r100.readFloat();
        this.f455610h = r100.readFloat();
        this.f455611i = r100.readFloat();
        this.f455612j = r100.readFloat();
        this.f455613k = r100.readFloat();
        this.f455614l = r100.readFloat();
        this.f455615m = r100.readFloat();
        this.f455616n = r100.readFloat();
        this.f455617o = r100.readFloat();
        this.f455618p = r100.readFloat();
        this.f455619q = r100.readFloat();
        this.f455620r = r100.readFloat();
        this.f455621s = r100.readFloat();
        this.f455622t = r100.readFloat();
        this.f455623u = r100.readFloat();
        this.f455624v = r100.readFloat();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f455603a);
        r100.writeFloat(this.f455604b);
        r100.writeFloat(this.f455605c);
        r100.writeFloat(this.f455606d);
        r100.writeFloat(this.f455607e);
        r100.writeFloat(this.f455608f);
        r100.writeFloat(this.f455609g);
        r100.writeFloat(this.f455610h);
        r100.writeFloat(this.f455611i);
        r100.writeFloat(this.f455612j);
        r100.writeFloat(this.f455613k);
        r100.writeFloat(this.f455614l);
        r100.writeFloat(this.f455615m);
        r100.writeFloat(this.f455616n);
        r100.writeFloat(this.f455617o);
        r100.writeFloat(this.f455618p);
        r100.writeFloat(this.f455619q);
        r100.writeFloat(this.f455620r);
        r100.writeFloat(this.f455621s);
        r100.writeFloat(this.f455622t);
        r100.writeFloat(this.f455623u);
        r100.writeFloat(this.f455624v);
    }
}

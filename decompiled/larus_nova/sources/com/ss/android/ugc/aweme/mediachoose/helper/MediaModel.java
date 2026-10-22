package com.ss.android.ugc.aweme.mediachoose.helper;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class MediaModel implements Comparable<MediaModel>, Parcelable {
    public static final Parcelable.Creator<MediaModel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f451271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f451272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f451273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f451274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f451275e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f451276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f451277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f451278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f451279i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f451280j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f451281k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f451282l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final double f451283m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final double f451284n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f451285o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f451286p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f451287q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f451288r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f451289s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f451290t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final MediaAudio f451291u;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        new AnonymousClass1();
        CREATOR = new AnonymousClass2();
    }

    public final int hashCode() {
        return Long.valueOf(this.f451271a).hashCode();
    }

    public MediaModel() {
        this.f451281k = -1;
        this.f451282l = -1;
        this.f451291u = new MediaAudio();
        this.f451271a = -9999;
    }

    public int getType() {
        return this.f451276f;
    }

    public MediaModel(Parcel r100) {
        this.f451281k = -1;
        this.f451282l = -1;
        this.f451291u = new MediaAudio();
        this.f451271a = r100.readLong();
        this.f451272b = r100.readString();
        this.f451273c = r100.readString();
        this.f451274d = r100.readString();
        this.f451275e = r100.readLong();
        this.f451276f = r100.readInt();
        this.f451277g = r100.readLong();
        this.f451278h = r100.readLong();
        this.f451279i = r100.readString();
        this.f451280j = r100.readString();
        this.f451281k = r100.readInt();
        this.f451282l = r100.readInt();
        this.f451283m = r100.readDouble();
        this.f451284n = r100.readDouble();
        this.f451288r = r100.readInt();
        this.f451289s = r100.readInt();
        this.f451290t = r100.readString();
        this.f451285o = r100.readInt();
        this.f451286p = r100.readLong();
        this.f451287q = r100.readInt();
        this.f451286p = r100.readLong();
        this.f451291u = (MediaAudio) r100.readParcelable(MediaAudio.class.getClassLoader());
    }

    @Override // java.lang.Comparable
    public int compareTo(MediaModel r100) {
        long r101 = this.f451275e;
        long r102 = r100.f451275e;
        if (r101 <= r102) goto L5;
        return -1;
    L5:
        if (r101 >= r102) goto L7;
        return 1;
    L7:
        return 0;
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof MediaModel) == true) goto L9;
        return false;
    L9:
        if (this.f451271a == ((MediaModel) r100).f451271a) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.f451271a);
        r100.writeString(this.f451272b);
        r100.writeString(this.f451273c);
        r100.writeString(this.f451274d);
        r100.writeLong(this.f451275e);
        r100.writeInt(this.f451276f);
        r100.writeLong(this.f451277g);
        r100.writeLong(this.f451278h);
        r100.writeString(this.f451279i);
        r100.writeString(this.f451280j);
        r100.writeInt(this.f451281k);
        r100.writeInt(this.f451282l);
        r100.writeDouble(this.f451283m);
        r100.writeDouble(this.f451284n);
        r100.writeInt(this.f451288r);
        r100.writeInt(this.f451289s);
        r100.writeString(this.f451290t);
        r100.writeInt(this.f451285o);
        r100.writeLong(this.f451286p);
        r100.writeInt(this.f451287q);
        r100.writeLong(this.f451286p);
        r100.writeParcelable(this.f451291u, 0);
    }
}

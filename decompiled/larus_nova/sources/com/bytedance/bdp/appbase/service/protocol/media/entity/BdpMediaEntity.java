package com.bytedance.bdp.appbase.service.protocol.media.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes11.dex */
public class BdpMediaEntity implements Parcelable {
    public static final Parcelable.Creator<BdpMediaEntity> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f200971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f200972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f200973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f200974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f200975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f200976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f200977g;

    public class a implements Parcelable.Creator<BdpMediaEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BdpMediaEntity createFromParcel(Parcel r100) {
            return new BdpMediaEntity(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BdpMediaEntity[] newArray(int r100) {
            return new BdpMediaEntity[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public BdpMediaEntity(Parcel r100) {
        this.f200971a = r100.readString();
        this.f200972b = r100.readString();
        this.f200973c = r100.readLong();
        this.f200974d = r100.readInt();
        this.f200975e = r100.readLong();
        this.f200976f = r100.readInt();
        this.f200977g = r100.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f200971a);
        r100.writeString(this.f200972b);
        r100.writeLong(this.f200973c);
        r100.writeInt(this.f200974d);
        r100.writeLong(this.f200975e);
        r100.writeInt(this.f200976f);
        r100.writeString(this.f200977g);
    }
}

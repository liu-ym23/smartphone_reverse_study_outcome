package com.bytedance.badger.x;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes47.dex */
public class A implements Parcelable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Parcelable.Creator f199358d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f199359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f199360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f199361c;

    static {
        f199358d = new g0();
    }

    public A(Parcel r100) {
        this.f199359a = r100.readInt();
        this.f199360b = r100.createByteArray();
        this.f199361c = r100.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f199359a);
        r100.writeByteArray(this.f199360b);
        r100.writeInt(this.f199361c);
    }
}

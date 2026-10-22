package com.bytedance.badger.x;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes47.dex */
public final class g0 implements Parcelable.Creator {
    public g0() {
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel r100) {
        return new A(r100);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r100) {
        return new A[r100];
    }
}

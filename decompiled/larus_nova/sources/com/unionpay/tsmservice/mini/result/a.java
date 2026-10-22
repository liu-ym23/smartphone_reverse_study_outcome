package com.unionpay.tsmservice.mini.result;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements Parcelable.Creator {
    public a() {
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel r100) {
        return new QueryVendorPayStatusResult(r100);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r100) {
        return new QueryVendorPayStatusResult[r100];
    }
}

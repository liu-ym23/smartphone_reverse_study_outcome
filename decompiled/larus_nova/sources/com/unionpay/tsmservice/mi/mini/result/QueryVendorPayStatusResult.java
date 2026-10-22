package com.unionpay.tsmservice.mi.mini.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes41.dex */
public class QueryVendorPayStatusResult extends BaseResult {
    public static final Parcelable.Creator CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f462183a;

    static {
        CREATOR = new a();
    }

    public QueryVendorPayStatusResult() {
    }

    public QueryVendorPayStatusResult(Parcel r100) {
        this.f462183a = r100.readBundle();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeBundle(this.f462183a);
    }
}

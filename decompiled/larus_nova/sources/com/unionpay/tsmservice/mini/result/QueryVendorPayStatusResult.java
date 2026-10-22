package com.unionpay.tsmservice.mini.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes41.dex */
public class QueryVendorPayStatusResult extends BaseResult {
    public static final Parcelable.Creator CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f462193a;

    static {
        CREATOR = new a();
    }

    public QueryVendorPayStatusResult() {
    }

    public QueryVendorPayStatusResult(Parcel r100) {
        this.f462193a = r100.readBundle();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeBundle(this.f462193a);
    }
}

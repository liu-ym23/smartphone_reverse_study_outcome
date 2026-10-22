package com.bytedance.mira.core;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
class BinderParcel implements Parcelable {
    public static final Parcelable.Creator<BinderParcel> CREATOR = null;
    private final IBinder mBinder;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public IBinder getBinder() {
        return this.mBinder;
    }

    public BinderParcel(Parcel r1) {
        this.mBinder = r1.readStrongBinder();
    }

    public BinderParcel(IBinder r1) {
        this.mBinder = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeStrongBinder(this.mBinder);
    }
}

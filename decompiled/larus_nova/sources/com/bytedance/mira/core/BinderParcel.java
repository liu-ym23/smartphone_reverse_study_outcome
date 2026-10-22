package com.bytedance.mira.core;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
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

    public BinderParcel(Parcel r100) {
        this.mBinder = r100.readStrongBinder();
    }

    public BinderParcel(IBinder r100) {
        this.mBinder = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeStrongBinder(this.mBinder);
    }
}

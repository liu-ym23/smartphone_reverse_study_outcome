package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f274496a;

    static {
        CREATOR = new m();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public /* synthetic */ BinderWrapper(Parcel r100) {
        this.f274496a = r100.readStrongBinder();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeStrongBinder(this.f274496a);
    }
}

package com.bytedance.keva.ext.fast;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes19.dex */
public class StubParcelable implements Parcelable {
    public static final Parcelable.Creator<StubParcelable> CREATOR = null;
    final IBinder binder;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public StubParcelable(IBinder r100) {
        this.binder = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeStrongBinder(this.binder);
    }
}

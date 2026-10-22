package com.volcengine.zeus.servermanager;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class BinderParcel implements Parcelable {
    public static final Parcelable.Creator<BinderParcel> CREATOR = null;
    public final IBinder a;

    public static class a implements Parcelable.Creator<BinderParcel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BinderParcel createFromParcel(Parcel r2) {
            return new BinderParcel(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final BinderParcel[] newArray(int r1) {
            return new BinderParcel[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public BinderParcel(Parcel r1) {
        this.a = r1.readStrongBinder();
    }

    public BinderParcel(IBinder r1) {
        this.a = r1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeStrongBinder(this.a);
    }
}

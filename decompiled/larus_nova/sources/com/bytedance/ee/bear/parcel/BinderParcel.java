package com.bytedance.ee.bear.parcel;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.lark.aidl.IReminderImpl;

/* JADX INFO: loaded from: classes18.dex */
public class BinderParcel implements Parcelable {
    public static final Parcelable.Creator<BinderParcel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f236231a;

    public class a implements Parcelable.Creator<BinderParcel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BinderParcel createFromParcel(Parcel r100) {
            return new BinderParcel(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BinderParcel[] newArray(int r100) {
            return new BinderParcel[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public BinderParcel(Parcel r100) {
        this.f236231a = r100.readStrongBinder();
    }

    public BinderParcel(IReminderImpl r100) {
        this.f236231a = r100;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeStrongBinder(this.f236231a);
    }
}

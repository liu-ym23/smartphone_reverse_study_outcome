package com.hihonor.cloudservice.framework.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes23.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.hihonor.cloudservice.framework.aidl.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC3868a extends Binder implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC3868a() {
            attachInterface(this, "com.hihonor.cloudservice.framework.aidl.IServiceCallback");
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) {
            if (r100 == 1598968902) goto L13;
            if (r100 != 1) goto L6;
            r101.enforceInterface("com.hihonor.cloudservice.framework.aidl.IServiceCallback");
            if (r101.readInt() == 0) goto L10;
            DataBuffer r104 = DataBuffer.CREATOR.createFromParcel(r101);
        L11:
            a(r104);
            return true;
        L10:
            r104 = null;
            goto L11
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L13:
            r102.writeString("com.hihonor.cloudservice.framework.aidl.IServiceCallback");
            return true;
        }
    }

    void a(DataBuffer r100);
}

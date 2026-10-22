package com.oplus.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes34.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.oplus.a.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC4687a extends Binder implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC4687a() {
            attachInterface(this, "com.oplus.cosa.gamemanagersdk.IOplusHyperBoostNotifier");
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1) goto L5;
            r101.enforceInterface("com.oplus.cosa.gamemanagersdk.IOplusHyperBoostNotifier");
            a(r101.readString());
            r102.writeNoException();
            return true;
        L5:
            if (r100 != 1598968902) goto L7;
            r102.writeString("com.oplus.cosa.gamemanagersdk.IOplusHyperBoostNotifier");
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void a(String r100) throws RemoteException;
}

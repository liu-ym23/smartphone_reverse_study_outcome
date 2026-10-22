package com.volcengine.zeus;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface IServiceManager extends IInterface {

    public static abstract class Stub extends Binder implements IServiceManager {
        private static final String DESCRIPTOR = "com.volcengine.zeus.IServiceManager";
        static final int TRANSACTION_bindService = 3;
        static final int TRANSACTION_startService = 1;
        static final int TRANSACTION_stopService = 2;
        static final int TRANSACTION_unbindService = 4;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IServiceManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IServiceManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IServiceManager) == false) goto L12;
            return (IServiceManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IServiceManager r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            Intent r0 = null;
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L31;
            r0 = (Intent) Intent.CREATOR.createFromParcel(r6);
        L31:
            ComponentName r9 = startService(r0, r6.readString());
            r7.writeNoException();
            if (r9 == null) goto L34;
            r7.writeInt(1);
            r9.writeToParcel(r7, 1);
        L35:
            return true;
        L34:
            r7.writeInt(0);
            goto L35
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L26;
            r0 = (Intent) Intent.CREATOR.createFromParcel(r6);
        L26:
            boolean r10 = stopService(r0, r6.readString());
            r7.writeNoException();
            r7.writeInt(r10 ? 1 : 0);
            return true;
        L7:
            if (r5 != 3) goto L9;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L21;
            r0 = (Intent) Intent.CREATOR.createFromParcel(r6);
        L21:
            boolean r11 = bindService(r0, ServiceConnection.Stub.asInterface(r6.readStrongBinder()), r6.readInt(), r6.readString());
            r7.writeNoException();
            r7.writeInt(r11 ? 1 : 0);
            return true;
        L9:
            if (r5 != 4) goto L11;
            r6.enforceInterface(DESCRIPTOR);
            unbindService(ServiceConnection.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L11:
            if (r5 != 1598968902) goto L13;
            r7.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r5, r6, r7, r8);
        }
    }

    boolean bindService(Intent r1, ServiceConnection r2, int r3, String r4) throws RemoteException;

    ComponentName startService(Intent r1, String r2) throws RemoteException;

    boolean stopService(Intent r1, String r2) throws RemoteException;

    void unbindService(ServiceConnection r1) throws RemoteException;
}

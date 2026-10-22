package com.bytedance.mira.am;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IApplicationThread extends IInterface {

    /* JADX INFO: loaded from: classes21.dex */
    public static class Default implements IApplicationThread {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IApplicationThread {
        private static final String DESCRIPTOR = "com.bytedance.mira.am.IApplicationThread";

        /* JADX INFO: loaded from: classes21.dex */
        public static class Proxy implements IApplicationThread {
            public static IApplicationThread sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IApplicationThread getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IApplicationThread asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IApplicationThread) == false) goto L12;
            return (IApplicationThread) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IApplicationThread r100) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r100 == null) goto L9;
            Proxy.sDefaultImpl = r100;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1598968902) goto L5;
            r102.writeString(DESCRIPTOR);
            return true;
        L5:
            return super.onTransact(r100, r101, r102, r103);
        }
    }
}

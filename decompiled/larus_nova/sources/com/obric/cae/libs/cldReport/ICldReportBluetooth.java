package com.obric.cae.libs.cldReport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes33.dex */
public interface ICldReportBluetooth extends IInterface {
    public static final int CLD_ERRCODE_BLUETOOTH_BOND = 0;
    public static final int CLD_ERRCODE_BLUETOOTH_LINK = 1;

    public static class Default implements ICldReportBluetooth {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICldReportBluetooth {
        private static final String DESCRIPTOR = "com.obric.cae.libs.cldReport.ICldReportBluetooth";

        public static class Proxy implements ICldReportBluetooth {
            public static ICldReportBluetooth sDefaultImpl;
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

        public static ICldReportBluetooth getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICldReportBluetooth asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICldReportBluetooth) == false) goto L12;
            return (ICldReportBluetooth) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ICldReportBluetooth r100) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r100 == null) goto L7;
            Proxy.sDefaultImpl = r100;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
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

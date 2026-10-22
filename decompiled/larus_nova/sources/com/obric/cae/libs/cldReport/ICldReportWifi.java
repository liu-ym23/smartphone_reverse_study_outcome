package com.obric.cae.libs.cldReport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes33.dex */
public interface ICldReportWifi extends IInterface {
    public static final int CLD_ERRCODE_WIFI_CONNECT_FAIL = 3;
    public static final int CLD_ERRCODE_WIFI_CONNECT_SLOW = 4;
    public static final int CLD_ERRCODE_WIFI_DISCONNECT = 5;
    public static final int CLD_ERRCODE_WIFI_FEEDBACK = 0;
    public static final int CLD_ERRCODE_WIFI_NOT_AUTO_CONNECT = 8;
    public static final int CLD_ERRCODE_WIFI_OPEN_FAIL = 1;
    public static final int CLD_ERRCODE_WIFI_OPEN_SLOW = 2;
    public static final int CLD_ERRCODE_WIFI_ROAM_FAIL = 7;
    public static final int CLD_ERRCODE_WIFI_WLAN_CRASH = 6;

    public static class Default implements ICldReportWifi {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICldReportWifi {
        private static final String DESCRIPTOR = "com.obric.cae.libs.cldReport.ICldReportWifi";

        public static class Proxy implements ICldReportWifi {
            public static ICldReportWifi sDefaultImpl;
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

        public static ICldReportWifi getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICldReportWifi asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICldReportWifi) == false) goto L12;
            return (ICldReportWifi) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ICldReportWifi r100) {
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

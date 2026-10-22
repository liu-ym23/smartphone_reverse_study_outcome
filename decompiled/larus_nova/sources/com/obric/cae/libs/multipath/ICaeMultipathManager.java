package com.obric.cae.libs.multipath;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public interface ICaeMultipathManager extends IInterface {

    public static class Default implements ICaeMultipathManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public String getLatestNetworkTruth() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportAssistantFailure() throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportMPAConnectionQuality(String r100, int r101, int r102, int r103, int r104, int r105) throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportPathCtlModeChanged(String r100, int r101) throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void setICaeMultipathCallback(ICaeMultipathCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void startMultipath() throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void stopMultipath() throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void unsetICaeMultipathCallback() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeMultipathManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.multipath.ICaeMultipathManager";
        static final int TRANSACTION_getLatestNetworkTruth = 7;
        static final int TRANSACTION_reportAssistantFailure = 8;
        static final int TRANSACTION_reportMPAConnectionQuality = 3;
        static final int TRANSACTION_reportPathCtlModeChanged = 6;
        static final int TRANSACTION_setICaeMultipathCallback = 4;
        static final int TRANSACTION_startMultipath = 1;
        static final int TRANSACTION_stopMultipath = 2;
        static final int TRANSACTION_unsetICaeMultipathCallback = 5;

        public static class Proxy implements ICaeMultipathManager {
            public static ICaeMultipathManager sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public String getLatestNetworkTruth() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_multipath_ICaeMultipathManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getLatestNetworkTruth();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportAssistantFailure() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_cae_libs_multipath_ICaeMultipathManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportAssistantFailure();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void startMultipath() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_multipath_ICaeMultipathManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().startMultipath();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void stopMultipath() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_multipath_ICaeMultipathManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().stopMultipath();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void unsetICaeMultipathCallback() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_multipath_ICaeMultipathManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unsetICaeMultipathCallback();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void setICaeMultipathCallback(ICaeMultipathCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_multipath_ICaeMultipathManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setICaeMultipathCallback(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportPathCtlModeChanged(String r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeString(r100);     // Catch: Throwable -> L13
                r102.writeInt(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_multipath_ICaeMultipathManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportPathCtlModeChanged(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_multipath_ICaeMultipathManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
                if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
                long r100 = SystemClock.uptimeMillis();
                boolean r101 = r110.transact(r111, r112, r113, r114);     // Catch: Throwable -> L12
                long r102 = SystemClock.uptimeMillis() - r100;
                if (r102 < 100) goto L11;
                BinderPerformanceReporter.report(r102, r110.getClass().getName(), r111, r114, new Throwable("Slow main-thread Binder transaction"));
            L11:
                return r101;
            L12:
                th = move-exception;
                long r103 = SystemClock.uptimeMillis() - r100;
                if (r103 < 100) goto L22;
                if (r110 != null) goto L17;
                String r104 = "";
            L18:
                BinderPerformanceReporter.report(r103, r104, r111, r114, new Throwable("Slow main-thread Binder transaction"));
                throw th;
            L17:
                r104 = r110.getClass().getName();
                goto L18
            L22:
                throw th;
            L5:
                return r110.transact(r111, r112, r113, r114);
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportMPAConnectionQuality(String r110, int r111, int r112, int r113, int r114, int r115) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r100.writeString(r110);     // Catch: Throwable -> L17
                r100.writeInt(r111);     // Catch: Throwable -> L17
                r100.writeInt(r112);     // Catch: Throwable -> L17
                r100.writeInt(r113);     // Catch: Throwable -> L17
                r100.writeInt(r114);     // Catch: Throwable -> L17
                r100.writeInt(r115);     // Catch: Throwable -> L17
            L15:
                th = th;
            L19:
                r101.recycle();
                r100.recycle();
                throw th;
            L6:
                if (INVOKEINTERFACE_com_obric_cae_libs_multipath_ICaeMultipathManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0) == false) goto L8;
            L12:
                r101.readException();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return;
            L8:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().reportMPAConnectionQuality(r110, r111, r112, r113, r114, r115);     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return;
            L17:
                th = th;
                goto L19
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeMultipathManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeMultipathManager asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICaeMultipathManager) == false) goto L12;
            return (ICaeMultipathManager) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ICaeMultipathManager r100) {
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
        public boolean onTransact(int r110, Parcel r111, Parcel r112, int r113) throws RemoteException {
            if (r110 == 1598968902) goto L23;
            switch(r110) {
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L17;
                case 4: goto L15;
                case 5: goto L13;
                case 6: goto L11;
                case 7: goto L9;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r111.enforceInterface(DESCRIPTOR);
            reportAssistantFailure();
            return true;
        L9:
            r111.enforceInterface(DESCRIPTOR);
            String r114 = getLatestNetworkTruth();
            r112.writeNoException();
            r112.writeString(r114);
            return true;
        L11:
            r111.enforceInterface(DESCRIPTOR);
            reportPathCtlModeChanged(r111.readString(), r111.readInt());
            r112.writeNoException();
            return true;
        L13:
            r111.enforceInterface(DESCRIPTOR);
            unsetICaeMultipathCallback();
            r112.writeNoException();
            return true;
        L15:
            r111.enforceInterface(DESCRIPTOR);
            setICaeMultipathCallback(ICaeMultipathCallback.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            return true;
        L17:
            r111.enforceInterface(DESCRIPTOR);
            reportMPAConnectionQuality(r111.readString(), r111.readInt(), r111.readInt(), r111.readInt(), r111.readInt(), r111.readInt());
            r112.writeNoException();
            return true;
        L19:
            r111.enforceInterface(DESCRIPTOR);
            stopMultipath();
            r112.writeNoException();
            return true;
        L21:
            r111.enforceInterface(DESCRIPTOR);
            startMultipath();
            r112.writeNoException();
            return true;
        L6:
            return super.onTransact(r110, r111, r112, r113);
        L23:
            r112.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getLatestNetworkTruth() throws RemoteException;

    void reportAssistantFailure() throws RemoteException;

    void reportMPAConnectionQuality(String r100, int r101, int r102, int r103, int r104, int r105) throws RemoteException;

    void reportPathCtlModeChanged(String r100, int r101) throws RemoteException;

    void setICaeMultipathCallback(ICaeMultipathCallback r100) throws RemoteException;

    void startMultipath() throws RemoteException;

    void stopMultipath() throws RemoteException;

    void unsetICaeMultipathCallback() throws RemoteException;
}

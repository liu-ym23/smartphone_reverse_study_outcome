package com.oplus.ocs.base;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public interface IServiceBroker extends IInterface {
    public static final String DESCRIPTOR = "com.oplus.ocs.base.IServiceBroker";

    public static class Default implements IServiceBroker {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.ocs.base.IServiceBroker
        public IBinder getBinder(String r100, String r101) throws RemoteException {
            return null;
        }

        @Override // com.oplus.ocs.base.IServiceBroker
        public void handleAuthentication(String r100, String r101, IAuthenticationListener r102) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IServiceBroker {
        static final int TRANSACTION_getBinder = 2;
        static final int TRANSACTION_handleAuthentication = 1;

        public static class Proxy implements IServiceBroker {
            public static IServiceBroker sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IServiceBroker.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.oplus.ocs.base.IServiceBroker
            public IBinder getBinder(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(IServiceBroker.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeString(r100);     // Catch: Throwable -> L13
                r102.writeString(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_oplus_ocs_base_IServiceBroker$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                IBinder r104 = r103.readStrongBinder();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IBinder r105 = Stub.getDefaultImpl().getBinder(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r105;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.oplus.ocs.base.IServiceBroker
            public void handleAuthentication(String r100, String r101, IAuthenticationListener r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(IServiceBroker.DESCRIPTOR);     // Catch: Throwable -> L16
                r103.writeString(r100);     // Catch: Throwable -> L16
                r103.writeString(r101);     // Catch: Throwable -> L16
                if (r102 == null) goto L6;
                IBinder r105 = r102.asBinder();     // Catch: Throwable -> L16
            L7:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_oplus_ocs_base_IServiceBroker$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L16
            L12:
                r104.recycle();
                r103.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().handleAuthentication(r100, r101, r102);     // Catch: Throwable -> L16
                goto L12
            L6:
                r105 = null;
            L16:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_oplus_ocs_base_IServiceBroker$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IServiceBroker.DESCRIPTOR);
        }

        public static IServiceBroker getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IServiceBroker asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(IServiceBroker.DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IServiceBroker) == false) goto L12;
            return (IServiceBroker) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IServiceBroker r100) {
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
            if (r100 == 1598968902) goto L13;
            if (r100 != 1) goto L6;
            r101.enforceInterface(IServiceBroker.DESCRIPTOR);
            handleAuthentication(r101.readString(), r101.readString(), IAuthenticationListener.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L6:
            if (r100 != 2) goto L8;
            r101.enforceInterface(IServiceBroker.DESCRIPTOR);
            IBinder r104 = getBinder(r101.readString(), r101.readString());
            r102.writeNoException();
            r102.writeStrongBinder(r104);
            return true;
        L8:
            return super.onTransact(r100, r101, r102, r103);
        L13:
            r102.writeString(IServiceBroker.DESCRIPTOR);
            return true;
        }
    }

    IBinder getBinder(String r100, String r101) throws RemoteException;

    void handleAuthentication(String r100, String r101, IAuthenticationListener r102) throws RemoteException;
}
